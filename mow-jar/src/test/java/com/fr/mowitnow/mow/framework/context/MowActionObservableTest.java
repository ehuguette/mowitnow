package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * {@link MowActionObservable} class test.
 * 
 * @author ehuguette
 * @since 1.0
 *
 */
public class MowActionObservableTest {

    /** The MowActionObservable tested class. */
    private MowActionObservable mowActionObservable;

    /**
     * Set up before test.
     */
    @Before
    public final void setUp() {
	mowActionObservable = new MowActionObservable();
    }

    /**
     * Test method for
     * {@link com.fr.mowitnow.mow.framework.context.MowActionObservable#setMowPosition(com.fr.mowitnow.mow.framework.context.MowPosition)}
     * .
     */
    @Test
    public void testNotifyOneMow() {

	MowPosition mowPosition = new MowPosition(2, 2, EnumDirection.N);
	mowActionObservable.addObserver(mowPosition);
	mowActionObservable.setMowPosition(mowPosition);

	Assert.assertEquals(Integer.valueOf(1), mowPosition.getNotificationNumber());
    }

}
