package com.fr.mowitnow.mow.framework.control;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.DataGenerator;
import com.fr.mowitnow.mow.framework.constant.EnumAction;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.Actions;
import com.fr.mowitnow.mow.framework.context.Coordinates;
import com.fr.mowitnow.mow.framework.context.MowActionObservable;
import com.fr.mowitnow.mow.framework.context.MowField;
import com.fr.mowitnow.mow.framework.context.MowParameters;
import com.fr.mowitnow.mow.framework.context.MowPosition;
import com.fr.mowitnow.mow.framework.exception.ClientMowException;

/**
 * {@link MowItNow} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowItNowTest {

    /** The MowItNow tested class. */
    private MowItNow mowItNow;

    /**
     * Set up before test.
     */
    @Before
    public final void setUp() {
	mowItNow = new MowItNow();
    }

    /**
     * Test for method {@link MowItNow#move(String)}.
     *
     * @throws ClientMowException
     */
    @Test
    public void testActions() throws ClientMowException {
	final String move = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n";
	final List<MowPosition> resultPositions = new ArrayList<>();
	final MowPosition resultPosition1 = new MowPosition(1, 3, EnumDirection.N);
	resultPositions.add(resultPosition1);
	final MowPosition resultPosition2 = new MowPosition(5, 1, EnumDirection.E);
	resultPositions.add(resultPosition2);

	final List<MowPosition> mowPositions = mowItNow.move(move);
	Assert.assertNotNull(mowPositions);
	Assert.assertEquals(2, mowPositions.size());

	for (int index = 0; index < resultPositions.size(); index++) {
	    Assert.assertEquals(resultPositions.get(index), mowPositions.get(index));
	}
    }

    /**
     * Test for method {@link MowItNow#move(String)}.
     * 
     * @throws ClientMowException
     */
    @Test
    public final void testActionRotateNorthWest() throws ClientMowException {
	final String move = "5 5\n1 0 N\nD\n";
	final MowPosition resultPosition = new MowPosition(1, 0, EnumDirection.W);

	final List<MowPosition> mowPositions = mowItNow.move(move);
	Assert.assertNotNull(mowPositions);
	Assert.assertEquals(1, mowPositions.size());
	Assert.assertEquals(resultPosition, mowPositions.get(0));
    }

    /**
     * Test for method {@link MowItNow#move(String)}.
     * 
     * @throws ClientMowException
     */
    @Test
    public final void testActionRotateWestSouth() throws ClientMowException {
	final String move = "5 5\n1 0 W\nD\n";
	final MowPosition resultPosition = new MowPosition(1, 0, EnumDirection.S);

	final List<MowPosition> mowPositions = mowItNow.move(move);
	Assert.assertNotNull(mowPositions);
	Assert.assertEquals(1, mowPositions.size());
	Assert.assertEquals(resultPosition, mowPositions.get(0));
    }

    /**
     * Test for method {@link MowItNow#move(String)}.
     * 
     * @throws ClientMowException
     */
    @Test
    public final void testActionRotateNorthEst() throws ClientMowException {
	final String move = "5 5\n0 0 N\nG\n";
	final MowPosition resultPosition = new MowPosition(0, 0, EnumDirection.E);

	final List<MowPosition> mowPositions = mowItNow.move(move);
	Assert.assertNotNull(mowPositions);
	Assert.assertEquals(1, mowPositions.size());
	Assert.assertEquals(resultPosition, mowPositions.get(0));
    }

    /**
     * Test for method {@link MowItNow#move(String)}.
     * 
     * @throws ClientMowException
     */
    @Test
    public final void testActionRotateWestNorth() throws ClientMowException {
	final String move = "5 5\n1 0 W\nG\n";
	final MowPosition resultPosition = new MowPosition(1, 0, EnumDirection.N);

	final List<MowPosition> mowPositions = mowItNow.move(move);
	Assert.assertNotNull(mowPositions);
	Assert.assertEquals(1, mowPositions.size());
	Assert.assertEquals(resultPosition, mowPositions.get(0));
    }

    /**
     * Test for method
     * {@link MowItNow#actions(MowParameters, MowActionObservable)}.
     * 
     * @throws ClientMowException
     */
    @Test
    public final void testActionRotateSouthEast() throws ClientMowException {
	final MowField mowField = new MowField(new Coordinates(5, 5));
	final MowParameters mowParameters = new MowParameters(0, 0, EnumDirection.S);
	mowParameters.setMowField(mowField);
	final Actions actions = new Actions();
	actions.getList().add(EnumAction.D);
	mowParameters.setActions(actions);

	final MowPosition resultPosition = new MowPosition(0, 0, EnumDirection.E);

	final MowPosition mowPosition = mowItNow.actions(mowParameters, new MowActionObservable());
	Assert.assertEquals(resultPosition, mowPosition);
    }

    /**
     * Test for method
     * {@link MowItNow#actions(MowParameters, MowActionObservable)}.
     * 
     * @throws ClientMowException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testActionRotateWithNullFieldValue() throws ClientMowException {
	final MowParameters mowParameters = new MowParameters(0, 0, EnumDirection.S);
	final Actions actions = new Actions();
	actions.getList().add(EnumAction.D);
	mowParameters.setActions(actions);

	mowItNow.actions(mowParameters, null);
    }

    /**
     * Test for method
     * {@link MowItNow#actions(MowParameters, MowActionObservable)}.
     * 
     * @throws ClientMowException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testActionRotateWithNullActionValue() throws ClientMowException {
	final MowParameters mowParameters = new MowParameters(0, 0, EnumDirection.S);
	mowParameters.setMowField(DataGenerator.generateDefaultMowField(5, 5));

	mowItNow.actions(mowParameters, null);
    }

    /**
     * Test for method
     * {@link MowItNow#actions(MowParameters, MowActionObservable)}.
     * 
     * @throws ClientMowException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testActionRotateWithNullMowValue() throws ClientMowException {
	mowItNow.actions(null, null);
    }

    /**
     * Test for method
     * {@link MowItNow#actions(MowParameters, MowActionObservable)}.
     * 
     * @throws ClientMowException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testActionRotateWithNullObservableValue() throws ClientMowException {
	final MowField mowField = new MowField(new Coordinates(5, 5));
	final MowParameters mowParameters = new MowParameters(0, 0, EnumDirection.S);
	mowParameters.setMowField(mowField);
	final Actions actions = new Actions();
	actions.getList().add(EnumAction.D);
	mowParameters.setActions(actions);

	mowItNow.actions(mowParameters, null);
    }
}
