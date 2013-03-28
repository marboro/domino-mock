package org.openntf.domino.mock.impl.mock;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesLog;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesLogMockImpl extends NotesBaseMockImpl implements NotesLog {

	private String name;
	private final NotesSession parent;

	public NotesLogMockImpl(String name, NotesSession parent) {
		this.name = name;
		this.parent = parent;

	}

	@Override
	public void close() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getProgramName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProgramName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNumActions() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumErrors() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogActions() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLogActions(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLogErrors() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLogErrors(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOverwriteFile() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOverwriteFile(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void logAction(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void logError(int arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void logEvent(String arg0, String arg1, int arg2, int arg3)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openAgentLog() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openFileLog(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openMailLog(Vector arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openNotesLog(String arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO getProgramName
		return super.toString();
	}
}