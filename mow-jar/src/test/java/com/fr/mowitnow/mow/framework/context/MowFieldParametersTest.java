package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * {@link MowFieldParameters} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowFieldParametersTest {

	/**
	 * Test for method {@link MowFieldParameters#equals(Object)}.
	 */
	@Test
	public void testEquals() {
		final MowFieldParameters mowParameters1 = new MowFieldParameters(1, 2,
				EnumDirection.N);

		final MowFieldParameters mowParameters2 = new MowFieldParameters(1, 2,
				EnumDirection.N);
		Assert.assertEquals(mowParameters1, mowParameters2);
	}

}
