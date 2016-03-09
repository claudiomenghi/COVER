/**
 * 
 */
package it.polimi.cover.labelpropagation;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.checker.SatisfactionValue;

/**
 * @author Claudio Menghi
 *
 */
public class PropagationRuleTest {

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getAnd(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getAndShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().getAnd(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getAnd(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getAndShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().getAnd(SatisfactionValue.SATISFIED, null);
		
	}
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getAnd(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testGetAnd() {
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().getAnd(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.POSSIBLYSATISFIED, new PropagationRule().getAnd(SatisfactionValue.SATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().getAnd(SatisfactionValue.SATISFIED, SatisfactionValue.NOTSATISFIED));
	}

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getOr(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getOrShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().getOr(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getOr(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getOrShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().getOr(SatisfactionValue.SATISFIED, null);
		
	}
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getOr(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testGetOr() {
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().getOr(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().getOr(SatisfactionValue.SATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().getOr(SatisfactionValue.SATISFIED, SatisfactionValue.NOTSATISFIED));
	
	}

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getPlusPlus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getPlusPlusShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().getPlusPlus(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getPlusPlus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getPlusPlusShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().getPlusPlus(SatisfactionValue.SATISFIED, null);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getPlusPlus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testGetPlusPlus() {
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().getPlusPlus(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.POSSIBLYSATISFIED, new PropagationRule().getPlusPlus(SatisfactionValue.NOTSATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().getPlusPlus(SatisfactionValue.POSSIBLYSATISFIED, SatisfactionValue.NOTSATISFIED));
	
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getMinusMinus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMinusMinusShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().getMinusMinus(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getMinusMinus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMinusMinusShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().getMinusMinus(SatisfactionValue.SATISFIED, null);
		
	}

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#getMinusMinus(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testGetMinusMinus() {
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().getMinusMinus(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().getMinusMinus(SatisfactionValue.NOTSATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().getMinusMinus(SatisfactionValue.POSSIBLYSATISFIED, SatisfactionValue.NOTSATISFIED));
	
	}

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#min(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMinShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().min(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#min(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMinShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().min(SatisfactionValue.SATISFIED, null);
		
	}
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#min(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testMin() {
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().min(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().min(SatisfactionValue.NOTSATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.NOTSATISFIED, new PropagationRule().min(SatisfactionValue.POSSIBLYSATISFIED, SatisfactionValue.NOTSATISFIED));
	}

	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#max(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMaxShouldThrowAnExceptionIfTheFirstValueIsNull() {
		new PropagationRule().max(null, SatisfactionValue.SATISFIED);
		
	}
	
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#max(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test(expected=NullPointerException.class)
	public void getMaxShouldThrowAnExceptionIfTheSecondValueIsNull() {
		new PropagationRule().max(SatisfactionValue.SATISFIED, null);
		
	}
	/**
	 * Test method for {@link it.polimi.cover.labelpropagation.PropagationRule#max(it.polimi.checker.SatisfactionValue, it.polimi.checker.SatisfactionValue)}.
	 */
	@Test
	public void testMax() {
		assertEquals(SatisfactionValue.SATISFIED, new PropagationRule().max(SatisfactionValue.SATISFIED, SatisfactionValue.SATISFIED));
		assertEquals(SatisfactionValue.POSSIBLYSATISFIED, new PropagationRule().max(SatisfactionValue.NOTSATISFIED, SatisfactionValue.POSSIBLYSATISFIED));
		assertEquals(SatisfactionValue.POSSIBLYSATISFIED, new PropagationRule().max(SatisfactionValue.POSSIBLYSATISFIED, SatisfactionValue.NOTSATISFIED));
	
	}

}
