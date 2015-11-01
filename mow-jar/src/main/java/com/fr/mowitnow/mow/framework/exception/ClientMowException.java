package com.fr.mowitnow.mow.framework.exception;

/**
 * The client mow exception.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class ClientMowException extends Exception {

	/** The serial version ID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param string
	 *            The String exception message
	 */
	public ClientMowException(final String string) {
		super(string);
	}

}
