package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link Coordinates} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class CoordinatesTest {

	/**
	 * Test for method {@link Coordinates#equals(Object)}.
	 */
	@Test
	public void testEquals() {
		final Coordinates coordinates1 = new Coordinates(1, 2);
		final Coordinates coordinates2 = new Coordinates(1, 2);
		Assert.assertEquals(coordinates1, coordinates2);
	}

}
