package cover;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import labelpropagation.LabelPropagator;
import ltsa.lts.EmptyLTSOuput;
import ltsa.lts.ModelCheckerResult;
import ltsa.lts.ThreeValuedModelCheckerOutput;
import ltsa.lts.ltl.AssertDefinition;
import ltsa.ui.HPWindow;
import models.goal.GOALMODEL;
import models.goal.GOALMODEL.SCENARIO.GOAL;
import models.goal.GoalModelAdapter;
import utils.SatisfactionValueAdapter;

import com.google.common.base.Preconditions;

/**
 * Contains the COVER framework.
 * 
 * @author Claudio Menghi
 *
 */
public class COVER {

	private final PrintStream output;

	/**
	 * The goal model to be considered
	 */
	private final GOALMODEL goalModel;

	/**
	 * The IBA to be analyzed
	 */
	private final HPWindow window;

	private File outputFile;

	private String processName;

	/**
	 * contains the time required for the verification of the MTS
	 */
	private double verificationTime = 0;

	/**
	 * contains the time required for the label propagation
	 */
	private double labelPropagationTime = 0;

	/**
	 * creates a new COVER object
	 * 
	 * @param goalModel
	 *            the goal model to be considered
	 * @param iba
	 *            the incompleteBA to be considered
	 * @throws JAXBException 
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public COVER(File goalModelFile, HPWindow window, String mtsInputFile,
			String mtsName, File outputFile, PrintStream output) throws JAXBException {
		Preconditions.checkNotNull(goalModelFile,
				"The goal model to be considered cannot be null");
		Preconditions.checkNotNull(window,
				"The window to be considered cannot be null");
		Preconditions
				.checkNotNull(mtsInputFile,
						"The input file containing the MTS to be analyzed cannot be null");
		Preconditions
				.checkNotNull(mtsName,
						"The name of the process to be considered in the verification cannot be null");
		Preconditions
				.checkNotNull(outputFile,
						"The name of the file where the results must be written cannot be null");
		Preconditions.checkNotNull(output,
				"The name of the output cannot be null");
		output.println("************************************************");
		output.println("PHASE 1 - Initializing COVER");
		output.println("Goal model file: "+goalModelFile.getPath());
		output.println("MTS file: "+mtsInputFile);
		output.println("MTS processName: "+mtsName);
		output.println("Output file: "+outputFile);
		
		this.goalModel = new GoalModelAdapter().parseModel(
				goalModelFile);
		this.processName = mtsName;
		this.window = window;
		String folder = mtsInputFile.substring(0,
				mtsInputFile.lastIndexOf(File.separator) + 1);
		String file = mtsInputFile.substring(
				mtsInputFile.lastIndexOf(File.separator) + 1,
				mtsInputFile.length());

		
		this.window.doOpenFile(folder, file, false);

		this.window.coverCompile(mtsName);
		output.println("Compiling the process: " + mtsName);
		this.outputFile = outputFile;
		this.processName = mtsName;
		this.output = output;
	}

	/**
	 * checks whether the goal with the specified name is verified in the
	 * current design
	 * 
	 * @param goalName
	 *            the name of the goal to be verified
	 * @return the results of the verification procedure
	 * @throws NullPointerException
	 *             if the name of the goal is null
	 */
	private ModelCheckerResult checkGoal(String goalName) {
		Preconditions
				.checkNotNull(goalName, "The name of the goal of interest");

		this.window.asserted = goalName;

		AssertDefinition.compileAll(new EmptyLTSOuput());
		long startTime = System.currentTimeMillis();
		ThreeValuedModelCheckerOutput mcoutput = new ThreeValuedModelCheckerOutput();
		if (AssertDefinition.definitions.containsKey(goalName)) {
			this.window.coverLiveness(mcoutput);
			output.println("Goal: " + goalName + " Model Checking Result: "
					+ mcoutput.getResult());
		}
		long stopTime = System.currentTimeMillis();
		verificationTime = verificationTime + (stopTime - startTime);
		return mcoutput.getResult();
	}

	public void check() {

		GOALMODEL.SCENARIO currentGoalScenario = goalModel.getSCENARIO().get(
				goalModel.getSCENARIO().size() - 1);
		List<GOAL> goals = currentGoalScenario.getGOAL();

		
		output.println("************************************************");
		output.println("PHASE 2 - Running the MTS checker, considered process: "+this.processName);
		// Getting the initial satisfaction values
		final GOALMODEL.SCENARIO initialSatisfactionScenarioValues = computeInitialSatisfactionValues(goals);

		output.println("Model checking time: " + verificationTime + "ms");

		output.println("************************************************");
		output.println("PHASE 3 - Running the label propagation algorithm");
		// propagating the initial values
		long startTime = System.currentTimeMillis();
		GOALMODEL.SCENARIO newScenarioPropagationResults = new LabelPropagator(
				goalModel, initialSatisfactionScenarioValues).perform();
		long stopTime = System.currentTimeMillis();

		labelPropagationTime = labelPropagationTime + (stopTime - startTime);
		output.println("Label propagation time: " + labelPropagationTime + "ms");
		goalModel.getSCENARIO().add(newScenarioPropagationResults);

	}

	/**
	 * computes the initial satisfaction values of the goals
	 * 
	 * @param goals
	 *            the list of the goals of interest
	 * @return a scenario where the goals are associates with the initial values
	 *         obtained by running the model checker
	 * @throws NullPointerException
	 *             if the list of the goal is null
	 */
	private GOALMODEL.SCENARIO computeInitialSatisfactionValues(List<GOAL> goals) {
		Preconditions.checkNotNull(goals,
				"The list of the goals cannot be null");

		final GOALMODEL.SCENARIO initialSatisfactionScenarioValues = new GOALMODEL.SCENARIO();
		initialSatisfactionScenarioValues.setNAME("Scenario: "
				+ (goalModel.getSCENARIO().size() + 1));

		goals.forEach(goal -> {
			GOAL newGoal = goal.clone();

			if (goal.getCAPTION().contains(":")) {
				String goalName = goal.getCAPTION().substring(0,
						goal.getCAPTION().indexOf(":"));

				ModelCheckerResult satisfaction = this.checkGoal(goalName);

				newGoal.setSAT(new SatisfactionValueAdapter()
						.convertSatisfactionValue(satisfaction));
			} else {
				this.output.println("The goal: "
						+ newGoal.getCAPTION()
						+ " with id: "
						+ newGoal.getID()
						+ " is not associated with an LTL formalization (use : to separate the name of the goal and its formalization)");
			}
			initialSatisfactionScenarioValues.getGOAL().add(newGoal);
		});
		return initialSatisfactionScenarioValues;
	}

	private void writeResults() throws JAXBException {
		output.println("************************************************");
		output.println("PHASE 4 - Writing the results");
		new GoalModelAdapter().writeGoalModel(this.outputFile, goalModel);
	}

	/**
	 * runs the COVER framework. The framework takes two arguments: the goal
	 * model to be analyzed and the IBA over which the LTL formulae must be
	 * considered. s
	 * 
	 * @param args
	 *            it contains the path of the goal model to be analyzed and of
	 *            the IBA which represents the model to be considered
	 * @throws Exception
	 * @throws IllegalArgumentException
	 *             if one of the two parameters is not present or not correct
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");

		PrintStream output = System.out;
		if (args.length != 4) {
			output.println("Illegal arguments. To run cover type: \n java -jar COVER.jar model.goal design.mts PROC newmodel.goal");
			System.exit(0);
		}
		if (args[0] == null) {
			output.println("You must specity the original goal model");
			System.exit(0);
		}
		if (args[1] == null) {
			output.println("You must specity the .mts containing the model to be considered");
			System.exit(0);
		}
		if (args[2] == null) {
			output.println("You must the name of the process to be checked contained in the .mtsa file");
			System.exit(0);
		}
		if (args[3] == null) {
			output.println("You must specity the file which must contain the destination goal model");
			System.exit(0);
		}
		if (!Files.exists(Paths.get(args[0]), LinkOption.NOFOLLOW_LINKS)) {
			output.println("The original goal model must exist");
			System.exit(0);
		}
		if (!Files.exists(Paths.get(args[1]), LinkOption.NOFOLLOW_LINKS)) {
			output.println("The xml file containing the design must exist");
			System.exit(0);
		}
		output.println("Loading the goal model");

		HPWindow window = new HPWindow(null);
		window.setVisible(false);

		String goalModelFile=args[0];
		String mtsInputFile = args[1];
		String processName = args[2];

		COVER cover = new COVER(new File(goalModelFile), window, mtsInputFile, processName,
				new File(args[3]), output);
		cover.check();
		cover.writeResults();
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}
}