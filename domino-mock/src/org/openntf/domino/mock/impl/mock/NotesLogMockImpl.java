package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesLog;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesLogMockImpl extends NotesBaseMockImpl implements NotesLog {

	private class Error {
		private int code;
		private String text;

		public Error(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

	private String name;
	private final NotesSession parent;
	private boolean logActions;
	private boolean logErrors;
	private boolean overwriteFile;
	private List<String> actionsLog;
	private ArrayList<Error> errorLog;

	public NotesLogMockImpl(String name, NotesSession parent) {
		this.name = name;
		this.parent = parent;
		actionsLog = new ArrayList<String>();
		errorLog = new ArrayList<Error>();
	}

	@Override
	public void close() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getProgramName() throws NotesApiException {
		return name;
	}

	@Override
	public void setProgramName(String name) throws NotesApiException {
		this.name = name;
	}

	@Override
	public int getNumActions() throws NotesApiException {
		return actionsLog.size();
	}

	@Override
	public int getNumErrors() throws NotesApiException {
		return errorLog.size();
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public boolean isLogActions() throws NotesApiException {
		return logActions;
	}

	@Override
	public void setLogActions(boolean flag) throws NotesApiException {
		this.logActions = flag;

	}

	@Override
	public boolean isLogErrors() throws NotesApiException {

		return logErrors;
	}

	@Override
	public void setLogErrors(boolean flag) throws NotesApiException {
		this.logErrors = flag;

	}

	@Override
	public boolean isOverwriteFile() throws NotesApiException {
		return overwriteFile;
	}

	@Override
	public void setOverwriteFile(boolean flag) throws NotesApiException {
		this.overwriteFile = flag;

	}

	@Override
	public void logAction(String action) throws NotesApiException {
		actionsLog.add(action);
	}

	@Override
	public void logError(int code, String text) throws NotesApiException {
		errorLog.add(new Error(code, text));

	}

	@Override
	public void logEvent(String text, String queue, int event, int severity)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openAgentLog() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openFileLog(String filePath) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openMailLog(Vector recipients, String subject)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void openNotesLog(String server, String database)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

}