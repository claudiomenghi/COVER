/**
 * 
 */
package it.polimi.cover.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.checker.SatisfactionValue;

/**
 * @author Claudio Menghi
 *
 */
public class SatisfactionValueAdapterTest {

	/**
	 * Test method for
	 * {@link it.polimi.cover.utils.SatisfactionValueAdapter#convertSatisfactionValue(it.polimi.checker.SatisfactionValue)}
	 * .
	 */
	@Test
	public void testConvertSatisfactionValue() {

		assertEquals("NOT satisfaction must be assigned to the zero value", 0,
				new SatisfactionValueAdapter().convertSatisfactionValue(SatisfactionValue.NOTSATISFIED), 0.0001);
		assertEquals("Satisfaction must be assigned to the value one", 1,
				new SatisfactionValueAdapter().convertSatisfactionValue(SatisfactionValue.SATISFIED), 0.0001);
		assertEquals("Possible satisfaction be assigned to the value one", 0.5,
				new SatisfactionValueAdapter().convertSatisfactionValue(SatisfactionValue.POSSIBLYSATISFIED), 0.0001);
	}

	/**
	 * Test method for
	 * {@link it.polimi.cover.utils.SatisfactionValueAdapter#convertSatisfactionValue(it.polimi.checker.SatisfactionValue)}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testConvertSatisfactionValue_Null() {
		new SatisfactionValueAdapter().convertSatisfactionValue(null);
	}

	/**
	 * Test method for
	 * {@link it.polimi.cover.utils.SatisfactionValueAdapter#floatToSatisfactionValue(float)}
	 * .
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFloatToSatisfactionValue_IllegalArgumentException() {
		new SatisfactionValueAdapter().floatToSatisfactionValue(-1);
	}

	/**
	 * Test method for
	 * {@link it.polimi.cover.utils.SatisfactionValueAdapter#floatToSatisfactionValue(float)}
	 * .
	 */
	@Test
	public void testFloatToSatisfactionValue() {
		assertEquals("The value 1 indicates that the formula is satisfied", SatisfactionValue.SATISFIED,
				new SatisfactionValueAdapter().floatToSatisfactionValue(1));
		assertEquals("The value 0 indicates that the formula is not satisfied", SatisfactionValue.NOTSATISFIED,
				new SatisfactionValueAdapter().floatToSatisfactionValue(0));
		assertEquals("The value 0.5 indicates that the formula is possibly satisfied",
				SatisfactionValue.POSSIBLYSATISFIED, new SatisfactionValueAdapter().floatToSatisfactionValue(0.5f));
	}

}
