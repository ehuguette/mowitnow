package com.fr.mowitnow.mow.framework.context;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * The mow parameters.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowParameters {

	/** The mow position and the mow field parameters. */
	private MowFieldParameters mowFieldParameters;
	/** The mow actions. */
	private Actions actions;

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
	public MowParameters(Integer xi, Integer yi, EnumDirection direction) {
		this.setMowFieldParameters(new MowFieldParameters(xi, yi, direction));
	}

	/**
	 * @return {@link MowPosition} The mow position to get
	 */
	public MowPosition getMowPosition() {
		return getMowFieldParameters().getMowPosition();
	}

	/**
	 * @param mowPosition
	 *            The mow position to set
	 */
	public void setMowPosition(MowPosition mowPosition) {
		getMowFieldParameters().setMowPosition(mowPosition);
	}

	/**
	 * @return the mowField
	 */
	public MowField getMowField() {
		return getMowFieldParameters().getMowField();
	}

	/**
	 * @param mowField
	 *            the mowField to set
	 */
	public void setMowField(MowField mowField) {
		getMowFieldParameters().setMowField(mowField);
	}

	/**
	 * @return the mowFieldParameters
	 */
	public MowFieldParameters getMowFieldParameters() {
		return mowFieldParameters;
	}

	/**
	 * @param mowFieldParameters
	 *            the mowFieldParameters to set
	 */
	public void setMowFieldParameters(MowFieldParameters mowFieldParameters) {
		this.mowFieldParameters = mowFieldParameters;
	}

	/**
	 * @return {@link Actions} The actions to get
	 */
	public Actions getActions() {
		return actions;
	}

	/**
	 * @param actions
	 *            The actions to set
	 */
	public void setActions(Actions actions) {
		this.actions = actions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((mowFieldParameters == null)
				? 0
				: mowFieldParameters.hashCode());
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
		MowParameters other = (MowParameters) obj;
		if (actions == null) {
			if (other.actions != null) {
				return false;
			}
		} else if (!actions.equals(other.actions)) {
			return false;
		}
		if (mowFieldParameters == null) {
			if (other.mowFieldParameters != null) {
				return false;
			}
		} else if (!mowFieldParameters.equals(other.mowFieldParameters)) {
			return false;
		}
		return true;
	}

}
