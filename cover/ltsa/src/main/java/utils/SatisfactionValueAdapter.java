package utils;

import ltsa.lts.ModelCheckerResult;

import com.google.common.base.Preconditions;


/**
 * converts the satisfaction value from the type {@link SatisfactionValue} to a
 * float and vice versa
 * 
 * @author Claudio Menghi
 *
 */
public class SatisfactionValueAdapter {

	private static float PRECISION=0.005f;
	/**
	 * given a satisfaction value specified through the enumeration
	 * {@link SatisfactionValue} it converts its type into a float value
	 * 
	 * @param value
	 *            the value to be converted
	 * @return 1 if the satisfaction value is satisfied, 0.5 if the satisfaction
	 *         value is possibly satisfied 0 if the satisfaction value is not
	 *         satisfied
	 * @throws NullPointerException
	 *             if the satisfaction value is null
	 */
	public float convertSatisfactionValue(ModelCheckerResult value) {
		Preconditions.checkNotNull(value, "The value to be converted cannot be null");
		if (value == ModelCheckerResult.TRUE) {
			return 1;
		}
		if (value == ModelCheckerResult.MAYBE) {
			return 0.5f;
		}
		return 0;
	}

	/**
	 * converts a float value into the corresponding satisfaction value
	 * 
	 * @param value
	 *            the value can be 0, 0.5 or 1
	 * @return the satisfaction value corresponding to the float value specified
	 *         as parameter: SATISFIED if the float value is 1, NOT SATISFIED if
	 *         the float value is 0, POSSIBLY SATISFIED if the float value is
	 *         0.5
	 * @throws IllegalArgumentException
	 *             if the value specified as parameter is different from 0, 0.5
	 *             or 1
	 */
	public ModelCheckerResult floatToSatisfactionValue(float value) {
		if (Math.abs(value) < PRECISION) {
			return ModelCheckerResult.FALSE;
		}
		if (Math.abs(value-1)<PRECISION) {
			return ModelCheckerResult.TRUE;
		}
		if (Math.abs(value-0.5)<PRECISION){
			return ModelCheckerResult.MAYBE;
		}
		throw new IllegalArgumentException("The value to be converted be only be 0, 1 or 0.5");
	}
}
