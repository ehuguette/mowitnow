package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.DataGenerator;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * {@link MowPosition} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowPositionTest {

	/**
	 * Test for method {@link MowPosition#equals(Object)}.
	 */
	@Test
	public void testEquals() {
		final MowPosition mowPosition1 = new MowPosition(1, 2, EnumDirection.N);
		final MowPosition mowPosition2 = new MowPosition(1, 2, EnumDirection.N);
		Assert.assertEquals(mowPosition1, mowPosition2);
	}

	/**
	 * Test for method {@link MowPosition#turnRight()}.
	 */
	@Test
	public void testTurnRight() {
		final MowPosition resultPosition = new MowPosition(1, 2,
				EnumDirection.E);
		final MowPosition mowPosition = new MowPosition(1, 2, EnumDirection.N);
		mowPosition.turnRight();
		mowPosition.turnRight();
		mowPosition.turnRight();
		Assert.assertEquals(resultPosition, mowPosition);
	}

	/**
	 * Test for method {@link MowPosition#turnLeft()}.
	 */
	@Test
	public void testTurnLeft() {
		final MowPosition resultPosition = new MowPosition(1, 2,
				EnumDirection.W);
		final MowPosition mowPosition = new MowPosition(1, 2, EnumDirection.N);
		mowPosition.turnLeft();
		mowPosition.turnLeft();
		mowPosition.turnLeft();
		Assert.assertEquals(resultPosition, mowPosition);
	}

	/**
	 * Test for method {@link MowPosition#moveOneStep(MowField)}.
	 */
	@Test
	public void testMoveThreeTimes() {
		final MowPosition resultPosition = new MowPosition(1, 5,
				EnumDirection.N);
		final MowPosition mowPosition = new MowPosition(1, 2, EnumDirection.N);
		mowPosition.moveOneStep(DataGenerator.generateDefaultMowField(5, 5));
		mowPosition.moveOneStep(DataGenerator.generateDefaultMowField(5, 5));
		mowPosition.moveOneStep(DataGenerator.generateDefaultMowField(5, 5));
		Assert.assertEquals(resultPosition, mowPosition);
	}

	/**
	 * Test for method {@link MowPosition#moveOneStep(MowField)}.
	 */
	@Test
	public void testDoNotMoveOutOfTheField() {
		final MowPosition resultPosition = new MowPosition(5, 5,
				EnumDirection.N);
		final MowPosition mowPosition = new MowPosition(5, 5, EnumDirection.N);
		mowPosition.moveOneStep(DataGenerator.generateDefaultMowField(5, 5));
		Assert.assertEquals(resultPosition, mowPosition);
	}
}
