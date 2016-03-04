package it.polimi.cover.utils;

import it.polimi.checker.SatisfactionValue;

public class SatisfactionValueAdapter {

	public float convertSatisfactionValue(SatisfactionValue value) {
		if (value == SatisfactionValue.SATISFIED) {
			return 1;
		}
		if (value == SatisfactionValue.POSSIBLYSATISFIED) {
			return 0.5f;
		}
		return 0;
	}

	public SatisfactionValue floatToSatisfactionValue(float value) {
		if (value == 0) {
			return SatisfactionValue.NOTSATISFIED;
		}
		if (value == 1) {
			return SatisfactionValue.SATISFIED;
		}
		return SatisfactionValue.POSSIBLYSATISFIED;
	}
}
