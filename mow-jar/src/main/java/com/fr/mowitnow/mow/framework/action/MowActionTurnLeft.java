package com.fr.mowitnow.mow.framework.action;

import com.fr.mowitnow.mow.framework.context.MowFieldParameters;
import com.fr.mowitnow.mow.framework.context.MowPosition;

/**
 * Implementation of action to turn left.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionTurnLeft implements IMowAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeAction(MowFieldParameters mowFieldParameters) {
		MowPosition mowPosition = mowFieldParameters.getMowPosition();
		mowPosition.turnLeft();
	}

}
