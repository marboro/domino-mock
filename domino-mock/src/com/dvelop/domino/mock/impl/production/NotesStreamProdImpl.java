package com.dvelop.domino.mock.impl.production;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import lotus.domino.NotesException;
import lotus.domino.Stream;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesStream;

public class NotesStreamProdImpl extends NotesBaseProdImpl implements
		NotesStream {

	private final Stream stream;

	public NotesStreamProdImpl(Stream stream) {
		this.stream = stream;
	}

	public Stream get() {
		return stream;
	}

	@Override
	public void close() throws NotesApiException {
		try {
			stream.close();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getBytes() throws NotesApiException {
		try {
			return stream.getBytes();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCharset() throws NotesApiException {
		try {
			return stream.getCharset();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void getContents(Writer arg0) throws NotesApiException {
		try {
			stream.getContents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void getContents(OutputStream arg0) throws NotesApiException {
		try {
			stream.getContents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getPosition() throws NotesApiException {
		try {
			return stream.getPosition();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isEOS() throws NotesApiException {
		try {
			return stream.isEOS();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isReadOnly() throws NotesApiException {
		try {
			return stream.isReadOnly();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean open(String arg0) throws NotesApiException {
		try {
			return stream.open(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean open(String arg0, String arg1) throws NotesApiException {
		try {
			return stream.open(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public byte[] read() throws NotesApiException {
		try {
			return stream.read();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public byte[] read(int arg0) throws NotesApiException {
		try {
			return stream.read(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String readText() throws NotesApiException {
		try {
			return stream.readText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String readText(int arg0) throws NotesApiException {
		try {
			return stream.readText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String readText(int arg0, int arg1) throws NotesApiException {
		try {
			return stream.readText(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setContents(Reader arg0) throws NotesApiException {
		try {
			stream.setContents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setContents(InputStream arg0) throws NotesApiException {
		try {
			stream.setContents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setPosition(int arg0) throws NotesApiException {
		try {
			stream.setPosition(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void truncate() throws NotesApiException {
		try {
			stream.truncate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int write(byte[] arg0) throws NotesApiException {
		try {
			return stream.write(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int writeText(String arg0) throws NotesApiException {
		try {
			return stream.writeText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int writeText(String arg0, int arg1) throws NotesApiException {
		try {
			return stream.writeText(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}