package it.polimi.cover.labelpropagation;

import it.polimi.checker.SatisfactionValue;

public class PropagationRule {
	
	public SatisfactionValue getAnd(SatisfactionValue goal1, SatisfactionValue goal2){
		return this.min(goal1, goal2);
	}
	
	public SatisfactionValue getOr(SatisfactionValue goal1, SatisfactionValue goal2){
		return this.max(goal1, goal2);
	}
	
	public SatisfactionValue getPlusPlus(SatisfactionValue oldValueCurrentGoal, SatisfactionValue goal1){
		return this.max(oldValueCurrentGoal, goal1);
	}
	public SatisfactionValue getMinusMinus(SatisfactionValue oldValueCurrentGoal, SatisfactionValue goal1){
		return this.max(oldValueCurrentGoal, SatisfactionValue.NOTSATISFIED);
	}
	
	public SatisfactionValue min(SatisfactionValue goal1, SatisfactionValue goal2){
		if(goal1==null){
			return goal2;
		}
		if(goal2==null){
			return goal1;
		}
		if(goal1==SatisfactionValue.NOTSATISFIED || goal2==SatisfactionValue.NOTSATISFIED){
			return SatisfactionValue.NOTSATISFIED;
		}
		if(goal1==SatisfactionValue.POSSIBLYSATISFIED || goal2==SatisfactionValue.POSSIBLYSATISFIED){
			return SatisfactionValue.POSSIBLYSATISFIED;
		}
		return SatisfactionValue.SATISFIED;
	}
	
	public SatisfactionValue max(SatisfactionValue goal1, SatisfactionValue goal2){
		if(goal1==null){
			return goal2;
		}
		if(goal2==null){
			return goal1;
		}
		if(goal1==SatisfactionValue.SATISFIED || goal2==SatisfactionValue.SATISFIED){
			return SatisfactionValue.SATISFIED;
		}
		if(goal1==SatisfactionValue.POSSIBLYSATISFIED || goal2==SatisfactionValue.POSSIBLYSATISFIED){
			return SatisfactionValue.POSSIBLYSATISFIED;
		}
		return SatisfactionValue.NOTSATISFIED;
	}
	
}
