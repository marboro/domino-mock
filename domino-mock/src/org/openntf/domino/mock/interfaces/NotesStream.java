package org.openntf.domino.mock.interfaces;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesStream extends NotesBase {
	public static final int STMREAD_LINE = 0;
	public static final int EOL_CRLF = 0;
	public static final int EOL_LF = 1;
	public static final int EOL_CR = 2;
	public static final int EOL_PLATFORM = 3;
	public static final int EOL_ANY = 4;
	public static final int EOL_NONE = 5;

	public abstract void close() throws NotesApiException;

	public abstract int getBytes() throws NotesApiException;

	public abstract String getCharset() throws NotesApiException;

	public abstract void getContents(Writer stream) throws NotesApiException;

	public abstract void getContents(OutputStream stream)
			throws NotesApiException;

	public abstract int getPosition() throws NotesApiException;

	public abstract boolean isEOS() throws NotesApiException;

	public abstract boolean isReadOnly() throws NotesApiException;

	public abstract boolean open(String pathname) throws NotesApiException;

	public abstract boolean open(String pathname, String charset)
			throws NotesApiException;

	public abstract byte[] read() throws NotesApiException;

	public abstract byte[] read(int length) throws NotesApiException;

	public abstract String readText() throws NotesApiException;

	public abstract String readText(int contant) throws NotesApiException;

	public abstract String readText(int constant, int eolConstant)
			throws NotesApiException;

	public abstract void setContents(Reader stream) throws NotesApiException;

	public abstract void setContents(InputStream stream)
			throws NotesApiException;

	public abstract void setPosition(int position) throws NotesApiException;

	public abstract void truncate() throws NotesApiException;

	public abstract int write(byte[] buffer) throws NotesApiException;

	public abstract int writeText(String text) throws NotesApiException;

	public abstract int writeText(String text, int endOfLine)
			throws NotesApiException;

}
