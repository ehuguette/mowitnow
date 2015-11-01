package com.fr.mowitnow.mow.framework;

import com.fr.mowitnow.mow.framework.context.Coordinates;
import com.fr.mowitnow.mow.framework.context.MowField;

/**
 * Test class to generate Object.
 * 
 * @author ehuguette
 * @since 1.0
 */
public final class DataGenerator {

	/**
	 * Constructor.
	 */
	private DataGenerator() {
		super();
	}

	/**
	 * Generate a default field object.
	 * 
	 * @param limitRightX
	 *            The X coordinate of the top right field parameter
	 * @param limitRightY
	 *            The Y coordinate of the top right field parameter
	 * @return {@link MowField}
	 */
	public static MowField generateDefaultMowField(final Integer limitRightX,
			final Integer limitRightY) {
		final Coordinates limitTopRight = new Coordinates(limitRightX,
				limitRightY);
		final MowField mowField = new MowField(limitTopRight);
		return mowField;
	}
}
