package com.fr.mowitnow.mow.framework.context;

import java.util.ArrayList;
import java.util.List;

/**
 * The mows parameters.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowsParameters {

	/** The list of mow parameters. */
	private List<MowParameters> mowsParameters = new ArrayList<>();

	/**
	 * Constructor.
	 */
	public MowsParameters() {

	}

	/**
	 * @return {@link List}<MowParameters> The list of mow parameters
	 */
	public List<MowParameters> getList() {
		return mowsParameters;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mowsParameters == null) ? 0 : mowsParameters.hashCode());
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
		MowsParameters other = (MowsParameters) obj;
		if (mowsParameters == null) {
			if (other.mowsParameters != null) {
				return false;
			}
		} else if (!mowsParameters.equals(other.mowsParameters)) {
			return false;
		}
		return true;
	}

}
