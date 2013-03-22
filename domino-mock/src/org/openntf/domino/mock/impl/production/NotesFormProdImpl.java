package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesForm;

import lotus.domino.Form;
import lotus.domino.NotesException;


public class NotesFormProdImpl extends NotesBaseProdImpl implements NotesForm {

	private final Form form;

	public NotesFormProdImpl(Form form) {
		this.form = form;
	}

	public Form get() {
		return form;
	}

	@Override
	public Vector getAliases() throws NotesApiException {
		try {
			return form.getAliases();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getFields() throws NotesApiException {
		try {
			return form.getFields();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getFormUsers() throws NotesApiException {
		try {
			return form.getFormUsers();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFormUsers(Vector arg0) throws NotesApiException {
		try {
			form.setFormUsers(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return form.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(form.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getReaders() throws NotesApiException {
		try {
			return form.getReaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setReaders(Vector arg0) throws NotesApiException {
		try {
			form.setReaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSubForm() throws NotesApiException {
		try {
			return form.isSubForm();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProtectReaders() throws NotesApiException {
		try {
			return form.isProtectReaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProtectReaders(boolean arg0) throws NotesApiException {
		try {
			form.setProtectReaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProtectUsers() throws NotesApiException {
		try {
			return form.isProtectUsers();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProtectUsers(boolean arg0) throws NotesApiException {
		try {
			form.setProtectUsers(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			form.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return form.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		try {
			return form.getNotesURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return form.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFieldType(String arg0) throws NotesApiException {
		try {
			return form.getFieldType(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		try {
			return form.getLockHolders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock() throws NotesApiException {
		try {
			return form.lock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		try {
			return form.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		try {
			return form.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		try {
			return form.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		try {
			return form.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		try {
			return form.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		try {
			return form.lockProvisional();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		try {
			return form.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		try {
			return form.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void unlock() throws NotesApiException {
		try {
			form.unlock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}