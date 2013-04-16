package org.openntf.domino.mock.Exception;

/**
 * Wrapper for NotesException
 * 
 * @author Sven Dreher
 * 
 */
public class NotesApiException extends Exception {

	/**
	 * {@value}
	 */
	private static final long serialVersionUID = -3174803543456246262L;

	/**
	 * Cunstructor for NotesApiException
	 * 
	 * @param e
	 *            The original Exception
	 */
	public NotesApiException(Throwable e) {
		super(e);
	}
}
