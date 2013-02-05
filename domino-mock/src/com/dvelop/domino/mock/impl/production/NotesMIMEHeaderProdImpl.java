package com.dvelop.domino.mock.impl.production;

import lotus.domino.MIMEHeader;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesMIMEHeader;

public class NotesMIMEHeaderProdImpl extends NotesBaseProdImpl implements
		NotesMIMEHeader {

	private final MIMEHeader header;

	public NotesMIMEHeaderProdImpl(MIMEHeader header) {
		this.header = header;
	}

	public MIMEHeader get() {
		return header;
	}

	@Override
	public boolean addValText(String arg0) throws NotesApiException {
		try {
			return header.addValText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean addValText(String arg0, String arg1)
			throws NotesApiException {
		try {
			return header.addValText(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderName() throws NotesApiException {
		try {
			return header.getHeaderName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderVal() throws NotesApiException {
		try {
			return header.getHeaderVal();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderVal(boolean arg0) throws NotesApiException {
		try {
			return header.getHeaderVal(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderVal(boolean arg0, boolean arg1)
			throws NotesApiException {
		try {
			return header.getHeaderVal(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderValAndParams() throws NotesApiException {
		try {
			return header.getHeaderValAndParams();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderValAndParams(boolean arg0) throws NotesApiException {
		try {
			return header.getHeaderValAndParams(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderValAndParams(boolean arg0, boolean arg1)
			throws NotesApiException {
		try {
			return header.getHeaderValAndParams(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getParamVal(String arg0) throws NotesApiException {
		try {
			return header.getParamVal(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getParamVal(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return header.getParamVal(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			header.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setHeaderVal(String arg0) throws NotesApiException {
		try {
			return header.setHeaderVal(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setHeaderValAndParams(String arg0) throws NotesApiException {
		try {
			return header.setHeaderValAndParams(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setParamVal(String arg0, String arg1)
			throws NotesApiException {
		try {
			return header.setParamVal(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}