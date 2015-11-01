package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link MowField} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowFieldTest {

	/**
	 * Test for method {@link MowField#MowField(Coordinates)}.
	 */
	@Test
	public void testConstruct() {
		final Coordinates limitBottomLeft = new Coordinates(0, 0);
		final Coordinates limitTopRight = new Coordinates(2, 2);

		final MowField mowParameters = new MowField(new Coordinates(2, 2));
		Assert.assertEquals(limitBottomLeft,
				mowParameters.getLimitBottomLeftField());
		Assert.assertEquals(limitTopRight,
				mowParameters.getLimitTopRightField());
	}

	/**
	 * Test for method {@link MowField#equals(Object)}.
	 */
	@Test
	public void testEquals() {
		final MowField mowParameters1 = new MowField(new Coordinates(1, 1));
		final MowField mowParameters2 = new MowField(new Coordinates(1, 1));
		Assert.assertEquals(mowParameters1, mowParameters2);
	}

}
