package com.fr.mowitnow.mow.framework.context;

import java.util.Observable;

/**
 * The observable implementation.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionObservable extends Observable {

	/** The MowPosition which changed state. */
	private MowPosition mowPosition;

	/**
	 * Constructor.
	 */
	public MowActionObservable() {
		super();
	}

	/**
	 * @return {@link MowPosition} The mow position
	 */
	public MowPosition getMowPosition() {
		return mowPosition;
	}

	/**
	 * @param mowPosition
	 *            The mow position to set.
	 */
	public void setMowPosition(MowPosition mowPosition) {
		this.mowPosition = mowPosition;
		setChanged();
		notifyObservers(mowPosition);
	}

}
