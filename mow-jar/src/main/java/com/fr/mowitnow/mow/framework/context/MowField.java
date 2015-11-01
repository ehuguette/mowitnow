package com.fr.mowitnow.mow.framework.context;

/**
 * The mow field definition.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowField {

	/** The limit of the bottom left field. */
	private Coordinates limitBottomLeftField;
	/** The limit of the top right field. */
	private Coordinates limitTopRightField;

	/**
	 * Constructor.
	 * 
	 * @param limitTopRightField
	 *            The limit of the top right field
	 */
	public MowField(Coordinates limitTopRightField) {
		this.limitBottomLeftField = new Coordinates(0, 0);
		this.limitTopRightField = limitTopRightField;
	}

	/**
	 * 
	 * @return {@link Coordinates} The limit of the bottom left field
	 */
	public Coordinates getLimitBottomLeftField() {
		return limitBottomLeftField;
	}

	/**
	 * 
	 * @return Coordinates The limit of the top right field
	 */
	public Coordinates getLimitTopRightField() {
		return limitTopRightField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limitBottomLeftField == null)
				? 0
				: limitBottomLeftField.hashCode());
		result = prime * result + ((limitTopRightField == null)
				? 0
				: limitTopRightField.hashCode());
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
		MowField other = (MowField) obj;
		if (limitBottomLeftField == null) {
			if (other.limitBottomLeftField != null) {
				return false;
			}
		} else if (!limitBottomLeftField.equals(other.limitBottomLeftField)) {
			return false;
		}
		if (limitTopRightField == null) {
			if (other.limitTopRightField != null) {
				return false;
			}
		} else if (!limitTopRightField.equals(other.limitTopRightField)) {
			return false;
		}
		return true;
	}

}
