package com.fr.mowitnow.mow.framework;

import org.junit.Assert;

import com.fr.mowitnow.mow.framework.context.Coordinates;
import com.fr.mowitnow.mow.framework.context.MowField;
import com.fr.mowitnow.mow.framework.context.MowPosition;

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
    public static MowField generateDefaultMowField(final Integer limitRightX, final Integer limitRightY) {
	final Coordinates limitTopRight = new Coordinates(limitRightX, limitRightY);
	final MowField mowField = new MowField(limitTopRight);
	return mowField;
    }

    /**
     * Test the functional equality between the expected result and the received
     * one.
     * 
     * @param resultPosition
     *            The expected result position to compare
     * @param mowPosition
     *            The mow position obtain from process
     * @param expectedNotificationNb
     *            The expected notification number as it not accessible.
     * @return boolean
     */
    public static boolean assertEquals(MowPosition resultPosition,
            MowPosition mowPosition,
            Integer expectedNotificationNb) {
	if (resultPosition != null && mowPosition != null && expectedNotificationNb != null) {
	    Assert.assertEquals(resultPosition.getX(), mowPosition.getX());
	    Assert.assertEquals(resultPosition.getY(), mowPosition.getY());
	    Assert.assertEquals(resultPosition.getDirection(), mowPosition.getDirection());
	    Assert.assertEquals(expectedNotificationNb, mowPosition.getNotificationNumber());
	}

	return Boolean.TRUE;

    }
}
