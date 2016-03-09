package it.polimi.cover.labelpropagation;

import com.google.common.base.Preconditions;

import it.polimi.checker.SatisfactionValue;

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
	 * @throws NullPointerException
	 *             if one of the two values is null
	 */
	public SatisfactionValue getAnd(SatisfactionValue satGoal1, SatisfactionValue satGoal2) {
		Preconditions.checkNotNull(satGoal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(satGoal2, "The satisfaction value associated with the goal2 cannot be null");

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
	 * @throws NullPointerException
	 *             if one of the two values is null
	 */
	public SatisfactionValue getOr(SatisfactionValue satGoal1, SatisfactionValue satGoal2) {

		Preconditions.checkNotNull(satGoal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(satGoal2, "The satisfaction value associated with the goal2 cannot be null");
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
	public SatisfactionValue getPlusPlus(SatisfactionValue satGoal1, SatisfactionValue satGoal2) {

		Preconditions.checkNotNull(satGoal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(satGoal2, "The satisfaction value associated with the goal2 cannot be null");
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
	public SatisfactionValue getMinusMinus(SatisfactionValue satGoal1, SatisfactionValue satGoal2) {

		Preconditions.checkNotNull(satGoal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(satGoal2, "The satisfaction value associated with the goal2 cannot be null");
		return SatisfactionValue.NOTSATISFIED;
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
	public SatisfactionValue min(SatisfactionValue goal1, SatisfactionValue goal2) {
		Preconditions.checkNotNull(goal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(goal2, "The satisfaction value associated with the goal2 cannot be null");

		if (goal1 == SatisfactionValue.NOTSATISFIED || goal2 == SatisfactionValue.NOTSATISFIED) {
			return SatisfactionValue.NOTSATISFIED;
		}
		if (goal1 == SatisfactionValue.POSSIBLYSATISFIED || goal2 == SatisfactionValue.POSSIBLYSATISFIED) {
			return SatisfactionValue.POSSIBLYSATISFIED;
		}
		return SatisfactionValue.SATISFIED;
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
	public SatisfactionValue max(SatisfactionValue goal1, SatisfactionValue goal2) {

		Preconditions.checkNotNull(goal1, "The satisfaction value associated with the goal1 cannot be null");
		Preconditions.checkNotNull(goal2, "The satisfaction value associated with the goal2 cannot be null");

		if (goal1 == SatisfactionValue.SATISFIED || goal2 == SatisfactionValue.SATISFIED) {
			return SatisfactionValue.SATISFIED;
		}
		if (goal1 == SatisfactionValue.POSSIBLYSATISFIED || goal2 == SatisfactionValue.POSSIBLYSATISFIED) {
			return SatisfactionValue.POSSIBLYSATISFIED;
		}
		return SatisfactionValue.NOTSATISFIED;
	}

}
