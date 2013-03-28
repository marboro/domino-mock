package org.openntf.domino.mock.impl.mock;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesSession;
import org.openntf.domino.mock.interfaces.NotesStream;

public class NotesStreamMockImpl extends NotesBaseMockImpl implements
		NotesStream {

	private final NotesSession parent;

	public NotesStreamMockImpl(NotesSession parent) {
		this.parent = parent;
	}

	@Override
	public void close() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBytes() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCharset() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getContents(Writer arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContents(OutputStream arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPosition() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEOS() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean open(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean open(String arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte[] read() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] read(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readText(int arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContents(Reader arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContents(InputStream arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void truncate() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int write(byte[] arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeText(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeText(String arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}
}