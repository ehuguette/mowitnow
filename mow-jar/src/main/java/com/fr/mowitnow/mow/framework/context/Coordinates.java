package com.fr.mowitnow.mow.framework.context;

/**
 * The coordinates class.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class Coordinates {

	/** Axe X coordinates. */
	private Integer xi;
	/** Axe Y coordinates. */
	private Integer yi;

	/**
	 * Constructor.
	 * 
	 * @param xi
	 *            the Axe X coordinates
	 * @param yi
	 *            the Axe Y coordinates
	 */
	public Coordinates(Integer xi, Integer yi) {
		this.xi = xi;
		this.yi = yi;
	}

	/**
	 * get the Axe X coordinates.
	 * 
	 * @return the Axe X coordinates
	 */
	public Integer getX() {
		return xi;
	}

	/**
	 * get the Axe Y coordinates.
	 * 
	 * @return the Axe Y coordinates
	 */
	public Integer getY() {
		return yi;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xi == null) ? 0 : xi.hashCode());
		result = prime * result + ((yi == null) ? 0 : yi.hashCode());
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
		Coordinates other = (Coordinates) obj;
		if (xi == null) {
			if (other.xi != null) {
				return false;
			}
		} else if (!xi.equals(other.xi)) {
			return false;
		}
		if (yi == null) {
			if (other.yi != null) {
				return false;
			}
		} else if (!yi.equals(other.yi)) {
			return false;
		}
		return true;
	}
}
