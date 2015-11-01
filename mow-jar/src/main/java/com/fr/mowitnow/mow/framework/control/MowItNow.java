package com.fr.mowitnow.mow.framework.control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fr.mowitnow.mow.framework.action.IMowAction;
import com.fr.mowitnow.mow.framework.action.MowActionCache;
import com.fr.mowitnow.mow.framework.constant.EnumAction;
import com.fr.mowitnow.mow.framework.context.Actions;
import com.fr.mowitnow.mow.framework.context.MowActionObservable;
import com.fr.mowitnow.mow.framework.context.MowFieldParameters;
import com.fr.mowitnow.mow.framework.context.MowParameters;
import com.fr.mowitnow.mow.framework.context.MowPosition;
import com.fr.mowitnow.mow.framework.context.MowsParameters;
import com.fr.mowitnow.mow.framework.exception.ClientMowException;

/**
 * The mow execution.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowItNow {

	/** logger class. */
	private static final Logger LOG = LoggerFactory
			.getLogger(ParameterOperation.class);

	/** The parameter generic operations. */
	private ParameterOperation parameterOperation;

	/**
	 * Constructor.
	 */
	public MowItNow() {
		parameterOperation = new ParameterOperation();
	}

	/**
	 * Mows actions parameters to apply.
	 * 
	 * @param moveMessage
	 *            The mow message parameters
	 * @return {@link List}<MowPosition>
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	public List<MowPosition> move(String moveMessage)
			throws ClientMowException {
		StringBuilder msgLog = new StringBuilder("Initial message - {");
		msgLog.append(moveMessage).append("}");
		LOG.info(msgLog.toString());

		MowActionObservable mowActionObservable = new MowActionObservable();
		List<MowPosition> mowPositions = new ArrayList<>();

		MowsParameters parameters = parameterOperation
				.getParamaters(moveMessage);

		// MowPosition subscription
		for (MowParameters mowParameters : parameters.getList()) {
			mowActionObservable.addObserver(mowParameters.getMowPosition());
		}

		MowPosition mowPosition = null;
		for (MowParameters mowParameters : parameters.getList()) {
			mowPosition = actions(mowParameters, mowActionObservable);
			mowPositions.add(mowPosition);

			msgLog = new StringBuilder("Position");
			msgLog.append(" - X = ").append(mowPosition.getX());
			msgLog.append(" - Y = ").append(mowPosition.getY());
			msgLog.append(" - Direction = ").append(mowPosition.getDirection());
			LOG.info(msgLog.toString());
		}
		return mowPositions;
	}

	/**
	 * Apply action on the mow parameters.
	 * 
	 * @param mowParameters
	 *            The mow parameters
	 * @param mowActionObservable
	 *            The mow action observable
	 * @return {@link MowPosition} The mow position
	 */
	protected MowPosition actions(MowParameters mowParameters,
			MowActionObservable mowActionObservable) {
		MowPosition movePosition = null;
		MowFieldParameters mowFieldParameters = null;
		IMowAction mowAction = null;
		if (mowParameters == null || mowParameters.getMowField() == null
				|| mowParameters.getActions() == null
				|| mowActionObservable == null) {
			StringBuilder msgError = new StringBuilder(
					"Parameters should not be null - ");
			msgError.append("fieldParameters is null : ");
			msgError.append(mowParameters == null
					? true
					: mowParameters.getMowField() == null);
			msgError.append(" - ");
			msgError.append("actionParameters is null : ");
			msgError.append(mowParameters == null
					? true
					: mowParameters.getActions() == null);
			msgError.append(" - ");
			msgError.append("mowParameters is null : ")
					.append(mowParameters == null);
			msgError.append(" - ");
			msgError.append("mowActionObservable is null : ")
					.append(mowActionObservable == null);
			LOG.error(msgError.toString());
			throw new IllegalArgumentException(msgError.toString());
		} else {

			mowFieldParameters = mowParameters.getMowFieldParameters();
			movePosition = mowParameters.getMowPosition();
			Actions actions = mowParameters.getActions();
			StringBuilder msg = null;
			for (EnumAction enumAction : actions.getList()) {
				mowAction = MowActionCache.getInstance()
						.getMowAction(enumAction);
				mowAction.executeAction(mowFieldParameters);
				msg = new StringBuilder("Movement");
				msg.append(" - Action = ").append(enumAction);
				msg.append(" - X = ").append(movePosition.getX());
				msg.append(" - Y = ").append(movePosition.getY());
				msg.append(" - Direction = ")
						.append(movePosition.getDirection());
				LOG.debug(msg.toString());
			}
			mowActionObservable.setMowPosition(movePosition);
		}
		return movePosition;
	}
}
