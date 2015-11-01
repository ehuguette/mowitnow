package com.fr.mowitnow.mow.framework.control;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fr.mowitnow.mow.framework.constant.Constant;
import com.fr.mowitnow.mow.framework.constant.EnumAction;
import com.fr.mowitnow.mow.framework.constant.EnumDirection;
import com.fr.mowitnow.mow.framework.context.Actions;
import com.fr.mowitnow.mow.framework.context.Coordinates;
import com.fr.mowitnow.mow.framework.context.MowField;
import com.fr.mowitnow.mow.framework.context.MowParameters;
import com.fr.mowitnow.mow.framework.context.MowsParameters;
import com.fr.mowitnow.mow.framework.exception.ClientMowException;

/**
 * A helper class to extract parameters from the receive message.
 * 
 * @author ehuguette
 * @since 1.0
 */
public final class ParameterOperation {

	/** logger class. */
	private static final Logger LOG = LoggerFactory
			.getLogger(ParameterOperation.class);

	/**
	 * The constructor.
	 */
	public ParameterOperation() {

	}

	/**
	 * Get all the mows parameters from the message.
	 * 
	 * @param message
	 *            The received message
	 * @return {@link MowsParameters}
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	public MowsParameters getParamaters(String message)
			throws ClientMowException {
		MowsParameters parameters = null;
		boolean isValidFormat = checkParametersFormat(message);
		if (isValidFormat) {
			Coordinates limitTopRightCoordinates = extractLimitTopRightCoordinates(
					message);
			MowField mowField = new MowField(limitTopRightCoordinates);
			parameters = extractMowsParameters(message, mowField);
		} else {
			StringBuilder msgError = new StringBuilder(
					"Unsupported message format -");
			msgError.append(" should be : ").append(Constant.MSG_FORMAT_REGEX)
					.append(" -");
			msgError.append(" received : ").append(message);

			LOG.error(msgError.toString());
			throw new ClientMowException(msgError.toString());
		}

		return parameters;
	}

	/**
	 * Check the receive format message is a valid one.
	 * 
	 * @param message
	 *            The received message
	 * @return boolean True if the format message is valid
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	protected boolean checkParametersFormat(String message)
			throws ClientMowException {
		boolean result = Boolean.FALSE;
		if (message.matches(Constant.MSG_FORMAT_REGEX)) {
			return Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Extract limit top right parameters from the received message.
	 * 
	 * @param message
	 *            The received messages
	 * @return {@link Coordinates} The coordinates extracted form the message
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	protected Coordinates extractLimitTopRightCoordinates(String message)
			throws ClientMowException {
		Coordinates coordinates = null;

		List<String> fieldParameters = extractPatternMatcher(message,
				Constant.MSG_LIMIT_FIELD_REGEX);
		if (fieldParameters.size() == 1) {
			String limitTopRightCoordinates = fieldParameters.get(0);
			String[] coordinatesField = limitTopRightCoordinates
					.split(Constant.MSG_SPACE_REGEX);
			coordinates = new Coordinates(Integer.valueOf(coordinatesField[0]),
					Integer.valueOf(coordinatesField[1]));
		} else {
			StringBuilder msgError = new StringBuilder(
					"Unsupported message field parameters format -");
			msgError.append(" should be : ")
					.append(Constant.MSG_LIMIT_FIELD_REGEX).append(" -");
			msgError.append(" received : ").append(message);

			LOG.error(msgError.toString());
			throw new ClientMowException(msgError.toString());
		}

		return coordinates;
	}

	/**
	 * extract all mow parameters from the received message.
	 * 
	 * @param message
	 *            The message containing the mow parameters
	 * @param mowField
	 *            The mow field
	 * 
	 * @return {@link MowsParameters} The mow parameters
	 * @throws ClientMowException
	 *             Raised if the message format is invalid
	 */
	protected MowsParameters extractMowsParameters(String message,
			MowField mowField) throws ClientMowException {
		MowsParameters mowsParameters = new MowsParameters();
		List<String> mowPositionParameters = null;
		List<String> mowActionParameters = null;
		String partMessage = null;

		if (mowField == null) {
			StringBuilder msgError = new StringBuilder(
					"Parameters should not be null - ");
			msgError.append("mowField is null : ").append(mowField == null);
			LOG.error(msgError.toString());
			throw new IllegalArgumentException(msgError.toString());
		} else {
			List<String> parameters = extractPatternMatcher(message,
					Constant.MSG_MOW_PARAMS_REGEX);
			if (parameters.size() == 1) {

				partMessage = parameters.get(0);
				mowPositionParameters = extractPatternMatcher(partMessage,
						Constant.MSG_MOW_POSITION_REGEX);
				mowActionParameters = extractPatternMatcher(partMessage,
						Constant.MSG_MOW_ACTION_REGEX);

				if (mowPositionParameters.size() > 0 && mowPositionParameters
						.size() == mowActionParameters.size()) {
					for (int mowIndex = 0; mowIndex < mowPositionParameters
							.size()
							&& mowIndex < mowActionParameters
									.size(); mowIndex++) {
						mowsParameters.getList().add(extractMowParameters(
								mowPositionParameters.get(mowIndex),
								mowActionParameters.get(mowIndex), mowField));
					}

				} else {
					StringBuilder msgError = new StringBuilder(
							"Unsupported message parameters format -");
					if (mowPositionParameters.isEmpty()) {
						msgError.append(" mow position message should be : ")
								.append(Constant.MSG_MOW_POSITION_REGEX)
								.append(" -");
						msgError.append(" received : ").append(partMessage);
					}
					if (mowActionParameters.isEmpty()) {
						msgError.append(" mow action message should be : ")
								.append(Constant.MSG_MOW_ACTION_REGEX)
								.append(" -");
						msgError.append(" received : ").append(partMessage);
					}
					if (mowPositionParameters.size() != mowActionParameters
							.size()) {
						msgError.append(" number of mow position : ")
								.append(mowPositionParameters.size())
								.append(" -");
						msgError.append(" number of mow action : ")
								.append(mowActionParameters.size());
					}

					LOG.error(msgError.toString());
					throw new ClientMowException(msgError.toString());
				}
			} else {
				final StringBuilder msgError = new StringBuilder(
						"Unsupported message parameters format -");

				msgError.append(" mow parameters message should be : ")
						.append(Constant.MSG_MOW_PARAMS_REGEX).append(" -");
				msgError.append(" received : ").append(message);

				LOG.error(msgError.toString());
				throw new ClientMowException(msgError.toString());
			}
		}
		return mowsParameters;
	}

	/**
	 * Extract mow parameters from 2 strings and set the mow field.
	 * 
	 * @param mowPosition
	 *            The mow position parameters
	 * @param mowAction
	 *            The mow action parameters
	 * @param mowField
	 *            The mow field
	 * @return {@link MowParameters} The mow parameters
	 */
	protected MowParameters extractMowParameters(String mowPosition,
			String mowAction, MowField mowField) {
		MowParameters mowParameters = null;

		String[] mowPositions = mowPosition.split(Constant.MSG_SPACE_REGEX);

		mowParameters = new MowParameters(Integer.valueOf(mowPositions[0]),
				Integer.valueOf(mowPositions[1]),
				EnumDirection.valueOf(mowPositions[2]));
		mowParameters.setMowField(mowField);

		Actions actions = new Actions();
		for (int indexAction = 0; indexAction < mowAction
				.length(); indexAction++) {
			actions.getList().add(EnumAction
					.valueOf(String.valueOf(mowAction.charAt(indexAction))));
		}
		mowParameters.setActions(actions);

		return mowParameters;
	}

	/**
	 * Parsing a string form a given regex.
	 * 
	 * @param message
	 *            The string to parse
	 * @param regex
	 *            The regex to apply for parsing
	 * @return {@link List}<String>
	 */
	protected List<String> extractPatternMatcher(String message, String regex) {
		List<String> patterns = new ArrayList<>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);

		while (matcher.find()) {
			patterns.add(matcher.group());
		}
		return patterns;
	}
}
