package com.dvelop.domino.mock.impl.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesForm;
import com.dvelop.domino.mock.interfaces.NotesItem;

public class NotesFormMockImpl extends NotesBaseMockImpl implements NotesForm {

	private Vector aliases;
	private Map<String, NotesItem> fields;
	private Vector formUsers;
	private String name;
	private NotesDatabase parent;
	private Vector readers;
	private boolean isSubForm;
	private boolean isProtectReaders;
	private boolean isProtectUsers;
	private String url;
	private String notesURL;
	private String httpURL;
	private boolean provisionalok;
	private Vector lockedBy;

	public NotesFormMockImpl(String name, Vector aliases, NotesDatabase parent) {
		this.name = name;
		this.aliases = aliases;
		this.parent = parent;
		lockedBy = new Vector();
		fields = new HashMap<String, NotesItem>();
	}

	@Override
	public Vector getAliases() throws NotesApiException {
		return aliases;
	}

	@Override
	public Vector getFields() throws NotesApiException {
		return new Vector(fields.keySet());
	}

	@Override
	public Vector getFormUsers() throws NotesApiException {
		return formUsers;
	}

	@Override
	public String getName() throws NotesApiException {
		return name;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public Vector getReaders() throws NotesApiException {
		return readers;
	}

	@Override
	public boolean isSubForm() throws NotesApiException {
		return isSubForm;
	}

	@Override
	public boolean isProtectReaders() throws NotesApiException {
		return isProtectReaders;
	}

	@Override
	public boolean isProtectUsers() throws NotesApiException {
		return isProtectUsers;
	}

	@Override
	public void remove() throws NotesApiException {
		((NotesDatabaseMockImpl) parent).removeForm(name);
	}

	@Override
	public String getURL() throws NotesApiException {
		return url;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		return notesURL;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		return httpURL;
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		return lockedBy;
	}

	@Override
	public boolean lock() throws NotesApiException {
		return lock(false);
	}

	@Override
	public boolean lock(boolean provisionalok) throws NotesApiException {
		return lock(parent.getParent().getUserName(), provisionalok);
	}

	@Override
	public boolean lock(String name) throws NotesApiException {
		return lock(name, false);
	}

	@Override
	public boolean lock(String name, boolean provisionalok)
			throws NotesApiException {
		Vector vector = new Vector();
		vector.add(name);
		return lock(vector, provisionalok);
	}

	@Override
	public boolean lock(Vector names) throws NotesApiException {
		return lock(names, false);
	}

	@Override
	public boolean lock(Vector names, boolean provisionalok)
			throws NotesApiException {
		if (names.isEmpty()
				|| "".equalsIgnoreCase((String) names.firstElement())) {
			return false;
		}

		if (lockedBy.isEmpty() || lockedBy.containsAll(names)) {
			lockedBy.addAll(names);
			this.provisionalok = provisionalok;
			return true;
		}
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		return lock(true);
	}

	@Override
	public boolean lockProvisional(String name) throws NotesApiException {
		return lock(name, true);
	}

	@Override
	public boolean lockProvisional(Vector names) throws NotesApiException {
		return lock(names, true);
	}

	@Override
	public void unlock() throws NotesApiException {
		this.provisionalok = false;
		lockedBy.removeAllElements();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void setFormUsers(Vector users) throws NotesApiException {
		this.formUsers = users;
	}

	@Override
	public void setReaders(Vector readers) throws NotesApiException {
		this.readers = readers;
	}

	@Override
	public void setProtectReaders(boolean flag) throws NotesApiException {
		isProtectReaders = flag;
	}

	@Override
	public void setProtectUsers(boolean flag) throws NotesApiException {
		isProtectUsers = flag;
	}

	@Override
	public int getFieldType(String name) throws NotesApiException {
		return fields.get(name).getType();
	}
}