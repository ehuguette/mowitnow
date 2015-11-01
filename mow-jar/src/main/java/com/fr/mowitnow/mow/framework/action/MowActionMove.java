package com.fr.mowitnow.mow.framework.action;

import com.fr.mowitnow.mow.framework.context.MowFieldParameters;
import com.fr.mowitnow.mow.framework.context.MowPosition;
/**
 * Implement of Action move.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowActionMove implements IMowAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeAction(MowFieldParameters mowFieldParameters) {
		MowPosition mowPosition = mowFieldParameters.getMowPosition();
		mowPosition.moveOneStep(mowFieldParameters.getMowField());
	}

}
