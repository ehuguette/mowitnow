package com.fr.mowitnow.mow.framework.constant;

/**
 * Manage constants.
 * 
 * @author ehuguette
 * @since 1.0
 */
public final class Constant {

	/** The global parameters format regex. */
	public static final String MSG_FORMAT_REGEX = "^[0-9][ ][0-9](\\n)(([0-9][ ][0-9][ ][N|W|E|S](\\n))([D|G|A])+(\\n))+";
	/** The regex to match for the top right limit field. */
	public static final String MSG_LIMIT_FIELD_REGEX = "^[0-9][ ][0-9]";
	/** The regex to match the mow parameters. */
	public static final String MSG_MOW_PARAMS_REGEX = "(([0-9][ ][0-9][ ][N|W|E|S](\\n))([D|G|A])+(\\n))+";
	/** The regex to match mow position. */
	public static final String MSG_MOW_POSITION_REGEX = "[0-9][ ][0-9][ ][N|W|E|S]";
	/** The regex to match the mow actions. */
	public static final String MSG_MOW_ACTION_REGEX = "([D|G|A])+";
	/** The space regex. */
	public static final String MSG_SPACE_REGEX = " ";

	/**
	 * Constructor.
	 */
	private Constant() {
	}
}
