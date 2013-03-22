package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesLog;
import org.openntf.domino.mock.interfaces.NotesSession;

import lotus.domino.Log;
import lotus.domino.NotesException;


public class NotesLogProdImpl extends NotesBaseProdImpl implements NotesLog {

	private final Log log;

	public NotesLogProdImpl(Log log) {
		this.log = log;
	}

	@Override
	public void close() throws NotesApiException {
		try {
			log.close();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getProgramName() throws NotesApiException {
		try {
			return log.getProgramName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProgramName(String arg0) throws NotesApiException {
		try {
			log.setProgramName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getNumActions() throws NotesApiException {
		try {
			return log.getNumActions();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNumErrors() throws NotesApiException {
		try {
			return log.getNumErrors();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(log.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isLogActions() throws NotesApiException {
		try {
			return log.isLogActions();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLogActions(boolean arg0) throws NotesApiException {
		try {
			log.setLogActions(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isLogErrors() throws NotesApiException {
		try {
			return log.isLogErrors();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLogErrors(boolean arg0) throws NotesApiException {
		try {
			log.setLogErrors(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isOverwriteFile() throws NotesApiException {
		try {
			return log.isOverwriteFile();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOverwriteFile(boolean arg0) throws NotesApiException {
		try {
			log.setOverwriteFile(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void logAction(String arg0) throws NotesApiException {
		try {
			log.logAction(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void logError(int arg0, String arg1) throws NotesApiException {
		try {
			log.logError(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void logEvent(String arg0, String arg1, int arg2, int arg3)
			throws NotesApiException {
		try {
			log.logEvent(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void openAgentLog() throws NotesApiException {
		try {
			log.openAgentLog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void openFileLog(String arg0) throws NotesApiException {
		try {
			log.openFileLog(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void openMailLog(Vector arg0, String arg1) throws NotesApiException {
		try {
			log.openMailLog(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void openNotesLog(String arg0, String arg1) throws NotesApiException {
		try {
			log.openNotesLog(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}