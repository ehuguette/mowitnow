package com.fr.mowitnow.mow.framework.context;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * The mow field parameters.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowFieldParameters {

	/** The mow position. */
	private MowPosition mowPosition;
	/** The mow field. */
	private MowField mowField;

	/**
	 * Constructor.
	 * 
	 * @param xi
	 *            The top right X limit parameter
	 * @param yi
	 *            The top right X limit parameter
	 * @param direction
	 *            The orientation
	 */
	public MowFieldParameters(Integer xi, Integer yi, EnumDirection direction) {
		this.setMowPosition(new MowPosition(xi, yi, direction));
	}

	/**
	 * 
	 * @return {@link MowPosition} The mow position
	 */
	public MowPosition getMowPosition() {
		return mowPosition;
	}

	/**
	 * 
	 * @param mowPosition
	 *            The mow position to set
	 */
	public void setMowPosition(MowPosition mowPosition) {
		this.mowPosition = mowPosition;
	}

	/**
	 * @return {@link MowField} the mowField
	 */
	public MowField getMowField() {
		return mowField;
	}

	/**
	 * @param mowField
	 *            the mowField to set
	 */
	public void setMowField(final MowField mowField) {
		this.mowField = mowField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mowField == null) ? 0 : mowField.hashCode());
		result = prime * result
				+ ((mowPosition == null) ? 0 : mowPosition.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MowFieldParameters other = (MowFieldParameters) obj;
		if (mowField == null) {
			if (other.mowField != null) {
				return false;
			}
		} else if (!mowField.equals(other.mowField)) {
			return false;
		}
		if (mowPosition == null) {
			if (other.mowPosition != null) {
				return false;
			}
		} else if (!mowPosition.equals(other.mowPosition)) {
			return false;
		}
		return true;
	}

}
