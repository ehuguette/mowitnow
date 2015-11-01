package com.fr.mowitnow.mow.framework.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.MowFieldParameters;

/**
 * {@link MowActionTurnRight} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionTurnRightTest {

	/** Mow action object. */
	private IMowAction mowAction;

	/**
	 * Set up before test.
	 */
	@Before
	public void setUp() {
		mowAction = new MowActionTurnRight();
	}

	/**
	 * Test for method
	 * {@link MowActionTurnRight#executeAction(MowFieldParameters)}.
	 */
	@Test
	public void testTurnRightOk() {
		final MowFieldParameters resultParameters = new MowFieldParameters(0, 0,
				EnumDirection.W);
		final MowFieldParameters mowFieldParameters = new MowFieldParameters(0,
				0, EnumDirection.N);
		mowAction.executeAction(mowFieldParameters);
		Assert.assertEquals(resultParameters, mowFieldParameters);
	}

	/**
	 * Test for method
	 * {@link MowActionTurnRight#executeAction(MowFieldParameters)}.
	 */
	@Test
	public void testTurnRightTwiceOk() {
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
	 * {@link MowActionTurnRight#executeAction(MowFieldParameters)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testTurnRightNullValue() {
		mowAction.executeAction(null);
	}

}
