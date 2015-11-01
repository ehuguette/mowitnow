package com.fr.mowitnow.mow.framework.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.DataGenerator;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.MowFieldParameters;

/**
 * {@link MowActionMove} class test.
 * 
 * @author ehuguette
 * @since 1.0
 *
 */
public class MowActionMoveTest {

	/** Mow action object. */
	private IMowAction mowAction;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mowAction = new MowActionMove();
	}

	/**
	 * Test for method {@link MowActionMove#executeAction(MowFieldParameters)}.
	 */
	@Test
	public void testMoveOneStep() {
		final MowFieldParameters resultParameters = new MowFieldParameters(0, 1,
				EnumDirection.N);
		resultParameters
				.setMowField(DataGenerator.generateDefaultMowField(5, 5));

		final MowFieldParameters mowFieldParameters = new MowFieldParameters(0,
				0, EnumDirection.N);
		mowFieldParameters
				.setMowField(DataGenerator.generateDefaultMowField(5, 5));
		mowAction.executeAction(mowFieldParameters);
		Assert.assertEquals(resultParameters, mowFieldParameters);
	}

	/**
	 * Test for method {@link MowActionMove#executeAction(MowFieldParameters)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveOneStepWithoutFieldParam() {

		final MowFieldParameters mowFieldParameters = new MowFieldParameters(0,
				0, EnumDirection.N);
		mowAction.executeAction(mowFieldParameters);
	}

	/**
	 * Test for method {@link MowActionMove#executeAction(MowFieldParameters)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveOneStepNullValue() {
		mowAction.executeAction(null);
	}

}
