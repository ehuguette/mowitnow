package com.fr.mowitnow.mow.framework.context;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * 
 * Implements mow actions.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionOperation {

	/** Message error to display. */
	private static final String MSG_ERROR = "Enum direction unknown :";

	/**
	 * Constructor.
	 */
	public MowActionOperation() {

	}

	/**
	 * Change to the next direction.
	 * 
	 * @param enumDirection
	 *            The actual direction
	 * @return EnumDirection The next direction
	 */
	public EnumDirection next(final EnumDirection enumDirection) {
		EnumDirection result = null;
		switch (enumDirection) {
			case N :
				result = EnumDirection.W;
				break;
			case W :
				result = EnumDirection.S;
				break;
			case S :
				result = EnumDirection.E;
				break;
			case E :
				result = EnumDirection.N;
				break;
			default :
				throw new IllegalArgumentException(MSG_ERROR + enumDirection);
		}
		return result;
	}

	/**
	 * Change to the previous direction.
	 * 
	 * @param enumDirection
	 *            The actual direction
	 * @return EnumDirection The previous direction
	 */
	public EnumDirection previous(final EnumDirection enumDirection) {
		EnumDirection result = null;
		switch (enumDirection) {
			case N :
				result = EnumDirection.E;
				break;
			case E :
				result = EnumDirection.S;
				break;
			case S :
				result = EnumDirection.W;
				break;
			case W :
				result = EnumDirection.N;
				break;
			default :
				throw new IllegalArgumentException(MSG_ERROR + enumDirection);
		}
		return result;
	}

	/**
	 * Move from one step in the actual direction.
	 * 
	 * @param coordinates
	 *            The coordinates
	 * @param direction
	 *            The direction
	 * @return Coordinates The new coordinates
	 */
	public Coordinates moveOneStep(final Coordinates coordinates,
			final EnumDirection direction) {
		Coordinates result = null;
		switch (direction) {
			case N :
				result = new Coordinates(coordinates.getX(),
						increment(coordinates.getY()));
				break;
			case E :
				result = new Coordinates(decrement(coordinates.getX()),
						coordinates.getY());
				break;
			case S :
				result = new Coordinates(coordinates.getX(),
						decrement(coordinates.getY()));
				break;
			case W :
				result = new Coordinates(increment(coordinates.getX()),
						coordinates.getY());
				break;
			default :
				throw new IllegalArgumentException(MSG_ERROR + direction);
		}
		return result;
	}

	/**
	 * Check the given coordinates are in the field.
	 * 
	 * @param mowField
	 *            The mow field
	 * @param mowCoordinates
	 *            TheS mow coordinates
	 * @return boolean True if the coordinates are in the field, false otherwise
	 */
	public boolean isInFieldCoordinates(final MowField mowField,
			final Coordinates mowCoordinates) {
		boolean result = Boolean.FALSE;
		Coordinates limitBottomLeftField = mowField.getLimitBottomLeftField();
		Coordinates limitTopRightField = mowField.getLimitTopRightField();
		if (limitTopRightField.getX() >= mowCoordinates.getX()
				&& limitTopRightField.getY() >= mowCoordinates.getY()
				&& limitBottomLeftField.getX() <= mowCoordinates.getX()
				&& limitBottomLeftField.getY() <= mowCoordinates.getY()) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Increment value by one.
	 * 
	 * @param value
	 *            The value to increment
	 * @return Integer
	 */
	protected Integer increment(final Integer value) {
		return value + 1;
	}

	/**
	 * Decrement value by one.
	 * 
	 * @param value
	 *            The value to decrement
	 * @return Integer
	 */
	protected Integer decrement(final Integer value) {
		return value - 1;
	}
}
