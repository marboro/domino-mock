package com.dvelop.domino.mock.interfaces;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.dvelop.domino.mock.Exception.NotesApiException;

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

	public abstract void getContents(Writer arg0) throws NotesApiException;

	public abstract void getContents(OutputStream arg0)
			throws NotesApiException;

	public abstract int getPosition() throws NotesApiException;

	public abstract boolean isEOS() throws NotesApiException;

	public abstract boolean isReadOnly() throws NotesApiException;

	public abstract boolean open(String arg0) throws NotesApiException;

	public abstract boolean open(String arg0, String arg1)
			throws NotesApiException;

	public abstract byte[] read() throws NotesApiException;

	public abstract byte[] read(int arg0) throws NotesApiException;

	public abstract String readText() throws NotesApiException;

	public abstract String readText(int arg0) throws NotesApiException;

	public abstract String readText(int arg0, int arg1)
			throws NotesApiException;

	public abstract void setContents(Reader arg0) throws NotesApiException;

	public abstract void setContents(InputStream arg0) throws NotesApiException;

	public abstract void setPosition(int arg0) throws NotesApiException;

	public abstract void truncate() throws NotesApiException;

	public abstract int write(byte[] arg0) throws NotesApiException;

	public abstract int writeText(String arg0) throws NotesApiException;

	public abstract int writeText(String arg0, int arg1)
			throws NotesApiException;

}
