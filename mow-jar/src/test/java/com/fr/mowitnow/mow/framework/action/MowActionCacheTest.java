package com.fr.mowitnow.mow.framework.action;

import org.junit.Assert;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.constant.EnumAction;

/**
 * 
 * {@link MowActionCache} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionCacheTest {

	/**
	 * Test for method {@link MowActionCache#getMowAction(EnumAction)}.
	 */
	@Test
	public void testGetMowActionMove() {
		final Class<MowActionMove> resultClass = MowActionMove.class;

		final IMowAction mowAction = MowActionCache.getInstance()
				.getMowAction(EnumAction.A);
		Assert.assertNotNull(mowAction);
		Assert.assertEquals(resultClass, mowAction.getClass());
	}

	/**
	 * Test for method {@link MowActionCache#getMowAction(EnumAction)}.
	 */
	@Test
	public void testGetMowActionTurnLeft() {
		final Class<MowActionTurnLeft> resultClass = MowActionTurnLeft.class;

		final IMowAction mowAction = MowActionCache.getInstance()
				.getMowAction(EnumAction.G);
		Assert.assertNotNull(mowAction);
		Assert.assertEquals(resultClass, mowAction.getClass());
	}

	/**
	 * Test for method {@link MowActionCache#getMowAction(EnumAction)}.
	 */
	@Test
	public void testGetMowActionTurnRight() {
		final Class<MowActionTurnRight> resultClass = MowActionTurnRight.class;

		final IMowAction mowAction = MowActionCache.getInstance()
				.getMowAction(EnumAction.D);
		Assert.assertNotNull(mowAction);
		Assert.assertEquals(resultClass, mowAction.getClass());
	}

	/**
	 * Test for method {@link MowActionCache#getMowAction(EnumAction)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetMowActionWithNullValue() {

		MowActionCache.getInstance().getMowAction(null);
	}

}
