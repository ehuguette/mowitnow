package com.fr.mowitnow.mow.framework.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.MowFieldParameters;

/**
 * {@link MowActionTurnLeft} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionTurnLeftTest {

	/** Mow action object. */
	private IMowAction mowAction;

	/**
	 * Set up before test.
	 */
	@Before
	public void setUp() {
		mowAction = new MowActionTurnLeft();
	}

	/**
	 * Test for method
	 * {@link MowActionTurnLeft#executeAction(MowFieldParameters)}.
	 */
	@Test
	public void testTurnLeftOk() {
		final MowFieldParameters resultParameters = new MowFieldParameters(0, 0,
				EnumDirection.E);
		final MowFieldParameters mowFieldParameters = new MowFieldParameters(0,
				0, EnumDirection.N);
		mowAction.executeAction(mowFieldParameters);
		Assert.assertEquals(resultParameters, mowFieldParameters);
	}

	/**
	 * Test for method
	 * {@link MowActionTurnLeft#executeAction(MowFieldParameters)}.
	 */
	@Test
	public void testTurnLeftTwiceOk() {
		final MowFieldParameters resultParameters = new MowFieldParameters(0, 0,
				EnumDirection.S);
		final MowFieldParameters mowFieldParameters = new MowFieldParameters(0,
				0, EnumDirection.N);
		mowAction.executeAction(mowFieldParameters);
		mowAction.executeAction(mowFieldParameters);
		Assert.assertEquals(resultParameters, mowFieldParameters);
	}

	/**
	 * Test for method
	 * {@link MowActionTurnLeft#executeAction(MowFieldParameters)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testTurnLeftNullValue() {
		mowAction.executeAction(null);
	}

}
