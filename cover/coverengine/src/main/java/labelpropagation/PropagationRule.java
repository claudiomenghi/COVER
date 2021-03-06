package labelpropagation;

import ltsa.lts.ModelCheckerResult;

/**
 * contains the Rule that govern the label propagation
 * 
 * @author Claudio Menghi
 *
 */
public class PropagationRule {

	/**
	 * the and of two satisfaction values returns the minimum of the two values
	 * 
	 * @param satGoal1
	 *            the satisfaction value associated with the goal1
	 * @param satGoal2
	 *            the satisfaction value associated with the goal2
	 * @return the minimum between the satGoal1 and satGoal2
	 */
	public ModelCheckerResult getAnd(ModelCheckerResult satGoal1, ModelCheckerResult satGoal2) {
		if(satGoal1==null){
			return satGoal2;
		}
		if(satGoal2==null){
			return satGoal1;
		}
		return this.min(satGoal1, satGoal2);
	}

	/**
	 * the or combination of two satisfaction values returns the maximum between
	 * the two satisfaction values
	 * 
	 * @param satGoal1
	 *            the satisfaction value associated with the goal1
	 * @param satGoal2
	 *            the satisfaction value associated with the goal2
	 * @return the maximum between the values associated with the goal1 and the
	 *         goal2
	 */
	public ModelCheckerResult getOr(ModelCheckerResult satGoal1, ModelCheckerResult satGoal2) {

		if(satGoal1==null){
			return satGoal2;
		}
		if(satGoal2==null){
			return satGoal1;
		}
		
		return this.max(satGoal1, satGoal2);
	}

	/**
	 * the plus plus operator returns the
	 * 
	 * @param satGoal1
	 *            is the satisfaction value associated with the source of the
	 *            relation
	 * @param satGoal2
	 *            is the satisfaction value associated with the destination of
	 *            the relation
	 * @return the satisfaction value associated to the destination
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public ModelCheckerResult getPlusPlus(ModelCheckerResult satGoal1, ModelCheckerResult satGoal2) {

		if(satGoal1==null){
			return satGoal2;
		}
		if(satGoal2==null){
			return satGoal1;
		}
		return satGoal2;
	}

	/**
	 * the minus minus operator returns the
	 * 
	 * @param satGoal1
	 *            is the satisfaction value associated with the source of the
	 *            relation
	 * @param satGoal2
	 *            is the satisfaction value associated with the destination of
	 *            the relation
	 * @return the SatisfactionValue.NOTSATISFIED satisfaction value
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public ModelCheckerResult getMinusMinus(ModelCheckerResult satGoal1, ModelCheckerResult satGoal2) {

		if(satGoal1==null){
			return satGoal2;
		}
		if(satGoal2==null){
			return satGoal1;
		}
		return ModelCheckerResult.FALSE;
	}

	/**
	 * returns the minimum of the satisfaction values
	 * 
	 * @param goal1
	 *            is the satisfaction values associated to the goal1
	 * @param goal2
	 *            is the satisfaction values associated to the goal2
	 * @return returns the minimum of the satisfaction values where
	 *         SatisfactionValue.NOTSATISFIED <
	 *         SatisfactionValue.POSSIBLYSATISFIED < SatisfactionValue.SATISFIED
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public ModelCheckerResult min(ModelCheckerResult goal1, ModelCheckerResult goal2) {
		if(goal1==null){
			return goal2;
		}
		if(goal2==null){
			return goal1;
		}
		
		if (goal1 == ModelCheckerResult.FALSE || goal2 == ModelCheckerResult.FALSE) {
			return ModelCheckerResult.FALSE;
		}
		if (goal1 == ModelCheckerResult.MAYBE || goal2 == ModelCheckerResult.MAYBE) {
			return ModelCheckerResult.MAYBE;
		}
		return ModelCheckerResult.TRUE;
	}

	/**
	 * returns the maximum of the satisfaction values
	 * 
	 * @param goal1
	 *            is the satisfaction values associated to the goal1
	 * @param goal2
	 *            is the satisfaction values associated to the goal2
	 * @return returns the maximum of the satisfaction values where
	 *         SatisfactionValue.NOTSATISFIED <
	 *         SatisfactionValue.POSSIBLYSATISFIED < SatisfactionValue.SATISFIED
	 * @throws NullPointerException
	 *             if one of the parameters is null
	 */
	public ModelCheckerResult max(ModelCheckerResult goal1, ModelCheckerResult goal2) {
		if(goal1==null){
			return goal2;
		}
		if(goal2==null){
			return goal1;
		}
		
		if (goal1 == ModelCheckerResult.TRUE || goal2 == ModelCheckerResult.TRUE) {
			return ModelCheckerResult.TRUE;
		}
		if (goal1 == ModelCheckerResult.MAYBE || goal2 == ModelCheckerResult.MAYBE) {
			return ModelCheckerResult.MAYBE;
		}
		return ModelCheckerResult.FALSE;
	}

}
