package com.fr.mowitnow.mow.framework.context;

import java.util.ArrayList;
import java.util.List;

import com.fr.mowitnow.mow.framework.constant.EnumAction;
/**
 * 
 * 
 * @author ehuguette
 * @since 1.0
 */
public class Actions {

	/** The list of actions types. */
	private final List<EnumAction> enumActions = new ArrayList<>();

	/**
	 * Constructor.
	 */
	public Actions() {
		super();
	}

	/**
	 * @return {@link List}<EnumAction> The list of actions types
	 */
	public List<EnumAction> getList() {
		return enumActions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enumActions == null) ? 0 : enumActions.hashCode());
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
		Actions other = (Actions) obj;
		if (enumActions == null) {
			if (other.enumActions != null) {
				return false;
			}
		} else if (!enumActions.equals(other.enumActions)) {
			return false;
		}
		return true;
	}

}
