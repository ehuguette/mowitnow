package com.fr.mowitnow.mow.framework.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fr.mowitnow.mow.framework.DataGenerator;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * {@link MowActionOperation} class test.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionOperationTest {

	/** The MowActionOperation tested class. */
	private MowActionOperation mowActionOperation;

	/**
	 * Set up before test.
	 */
	@Before
	public final void setUp() {
		mowActionOperation = new MowActionOperation();
	}

	/**
	 * Test for method {@link MowActionOperation#next(EnumDirection)}.
	 */
	@Test
	public void testNextNorth() {
		final EnumDirection direction = mowActionOperation
				.next(EnumDirection.N);

		Assert.assertEquals(EnumDirection.W, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#next(EnumDirection)}.
	 */
	@Test
	public void testNextWest() {
		final EnumDirection direction = mowActionOperation
				.next(EnumDirection.W);

		Assert.assertEquals(EnumDirection.S, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#next(EnumDirection)}.
	 */
	@Test
	public void testNextSouth() {
		final EnumDirection direction = mowActionOperation
				.next(EnumDirection.S);

		Assert.assertEquals(EnumDirection.E, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#next(EnumDirection)}.
	 */
	@Test
	public void testNextEst() {
		final EnumDirection direction = mowActionOperation
				.next(EnumDirection.E);

		Assert.assertEquals(EnumDirection.N, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#next(EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testNextNull() {
		mowActionOperation.next(null);
	}

	/**
	 * Test for method {@link MowActionOperation#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousNorth() {
		final EnumDirection direction = mowActionOperation
				.previous(EnumDirection.N);
		Assert.assertEquals(EnumDirection.E, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousWest() {
		final EnumDirection direction = mowActionOperation
				.previous(EnumDirection.W);
		Assert.assertEquals(EnumDirection.N, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousSouth() {
		final EnumDirection direction = mowActionOperation
				.previous(EnumDirection.S);
		Assert.assertEquals(EnumDirection.W, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#previous(EnumDirection)}.
	 */
	@Test
	public void testPreviousEst() {
		final EnumDirection direction = mowActionOperation
				.previous(EnumDirection.E);
		Assert.assertEquals(EnumDirection.S, direction);
	}

	/**
	 * Test for method {@link MowActionOperation#previous(EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testPreviousNull() {
		mowActionOperation.previous(null);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveNorth() {
		final Coordinates resultCoordinates = new Coordinates(1, 3);
		final Coordinates coordinates = mowActionOperation
				.moveOneStep(new Coordinates(1, 2), EnumDirection.N);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveWest() {
		final Coordinates resultCoordinates = new Coordinates(2, 2);
		final Coordinates coordinates = mowActionOperation
				.moveOneStep(new Coordinates(1, 2), EnumDirection.W);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveSouth() {
		final Coordinates resultCoordinates = new Coordinates(1, 1);
		final Coordinates coordinates = mowActionOperation
				.moveOneStep(new Coordinates(1, 2), EnumDirection.S);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test
	public void testMoveEst() {
		final Coordinates resultCoordinates = new Coordinates(0, 2);
		final Coordinates coordinates = mowActionOperation
				.moveOneStep(new Coordinates(1, 2), EnumDirection.E);

		Assert.assertEquals(resultCoordinates, coordinates);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveWithNullCoordinates() {
		mowActionOperation.moveOneStep(null, EnumDirection.E);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#moveOneStep(Coordinates, EnumDirection)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMoveWithNullDirection() {
		mowActionOperation.moveOneStep(new Coordinates(1, 2), null);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinates() {
		final Coordinates resultCoordinates = new Coordinates(5, 5);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = mowActionOperation
				.isInFieldCoordinates(mowField, resultCoordinates);

		Assert.assertEquals(Boolean.TRUE, isInField);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesNorthFalse() {
		final Coordinates resultCoordinates = new Coordinates(6, 4);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = mowActionOperation
				.isInFieldCoordinates(mowField, resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesWestFalse() {
		final Coordinates resultCoordinates = new Coordinates(4, 6);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = mowActionOperation
				.isInFieldCoordinates(mowField, resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesSouthFalse() {
		final Coordinates resultCoordinates = new Coordinates(-1, 0);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = mowActionOperation
				.isInFieldCoordinates(mowField, resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test
	public void testIsInFieldCoordinatesEstFalse() {
		final Coordinates resultCoordinates = new Coordinates(0, -1);
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		final boolean isInField = mowActionOperation
				.isInFieldCoordinates(mowField, resultCoordinates);

		Assert.assertEquals(Boolean.FALSE, isInField);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testIsInFieldCoordinatesWithNullField() {
		final Coordinates resultCoordinates = new Coordinates(2, 2);
		mowActionOperation.isInFieldCoordinates(null, resultCoordinates);
	}

	/**
	 * Test for method
	 * {@link MowActionOperation#isInFieldCoordinates(MowField, Coordinates)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testIsInFieldCoordinatesWithNullCoordinates() {
		final MowField mowField = DataGenerator.generateDefaultMowField(5, 5);
		mowActionOperation.isInFieldCoordinates(mowField, null);
	}

}
