package cover;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import utils.SatisfactionValueAdapter;
import labelpropagation.LabelPropagator;
import ltsa.lts.ModelCheckerResult;
import ltsa.lts.ThreeValuedModelCheckerOutput;
import ltsa.lts.ltl.AssertDefinition;
import ltsa.ui.HPWindow;
import models.goal.GOALMODEL;
import models.goal.GOALMODEL.SCENARIO.GOAL;
import models.goal.GoalModelAdapter;

import com.google.common.base.Preconditions;

/**
 * Contains the CHIARE framework.
 * 
 * @author Claudio Menghi
 *
 */
public class COVER {

	private static final PrintStream output = System.out;

	/**
	 * The goal model to be considered
	 */
	private final GOALMODEL goalModel;

	/**
	 * The IBA to be analyzed
	 */
	private final HPWindow window;

	private File outputFile;

	private String mtsName;

	/**
	 * creates a new CHIARE object
	 * 
	 * @param goalModel
	 *            the goal model to be considered
	 * @param iba
	 *            the incompleteBA to be considered
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public COVER(GOALMODEL goalModel, HPWindow window, String mtsInputFile,
			String mtsName, File outputFile) {
		Preconditions.checkNotNull(goalModel,
				"The goal model to be considered cannot be null");
		Preconditions.checkNotNull(window,
				"The IBA to be considered cannot be null");
		this.goalModel = goalModel;
		this.mtsName = mtsName;
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
		this.mtsName = mtsName;
	}

	private ModelCheckerResult checkGoal(String goalName) {
		this.window.asserted = goalName;

		ThreeValuedModelCheckerOutput mcoutput = new ThreeValuedModelCheckerOutput();
		if (AssertDefinition.definitions.containsKey(goalName)) {
			this.window.coverLiveness(mcoutput);
			output.println("Checking goal: " + goalName + " result: "
					+ mcoutput.getResult());
		}
		return mcoutput.getResult();
	}

	private void check() throws Exception {

		GOALMODEL.SCENARIO currentGoalScenario = goalModel.getSCENARIO().get(
				goalModel.getSCENARIO().size() - 1);
		List<GOAL> goals = currentGoalScenario.getGOAL();

		GOALMODEL.SCENARIO newScenario = new GOALMODEL.SCENARIO();
		newScenario
				.setNAME("Scenario: " + (goalModel.getSCENARIO().size() + 1));
		for (GOAL goal : goals) {
			GOAL newGoal = this.cloneGoal(goal);

			if (goal.getCAPTION().contains(":")) {
				String goalName = goal.getCAPTION().substring(0,
						goal.getCAPTION().indexOf(":"));

				ModelCheckerResult satisfaction = this.checkGoal(goalName);

				newGoal.setSAT(new SatisfactionValueAdapter()
						.convertSatisfactionValue(satisfaction));
			}
			newScenario.getGOAL().add(newGoal);
		}
		newScenario = new LabelPropagator(goalModel, newScenario).perform();
		goalModel.getSCENARIO().add(newScenario);

	}

	private void writeResults() throws JAXBException {
		new GoalModelAdapter().writeGoalModel(this.outputFile, goalModel);
	}

	private GOAL cloneGoal(GOAL goal) {
		GOAL retGoal = new GOAL();
		retGoal.setCAPTION(goal.getCAPTION());
		retGoal.setDEN(goal.getDEN());
		retGoal.setID(goal.getID());
		retGoal.setINPUT(goal.getINPUT());
		retGoal.setINPUTFORCED(goal.getINPUTFORCED());
		retGoal.setLTL(goal.getLTL());
		retGoal.setOP(goal.getOP());
		retGoal.setOUTPUTDEN(goal.getOUTPUTDEN());
		retGoal.setOUTPUTSAT(goal.getOUTPUTSAT());
		retGoal.setSAT(goal.getSAT());
		retGoal.setTOP(goal.getTOP());
		retGoal.setTYPE(goal.getTYPE());

		return retGoal;
	}

	/**
	 * runs the CHIARE framework. The framework takes two arguments: the goal
	 * model to be analyzed and the IBA over which the LTL formulae must be
	 * considered.
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
		// output.print(args.length);
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
		GOALMODEL goalModel = new GoalModelAdapter().parseModel(new File(
				args[0]));

		HPWindow window = new HPWindow(null);
		window.setVisible(false);
		COVER cover = new COVER(goalModel, window, args[1], args[2], new File(
				args[3]));
		output.println("Checking");
		cover.check();
		output.println("Writing the results");
		cover.writeResults();
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}
}