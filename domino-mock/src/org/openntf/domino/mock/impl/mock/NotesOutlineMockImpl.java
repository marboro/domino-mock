package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesOutline;
import org.openntf.domino.mock.interfaces.NotesOutlineEntry;

public class NotesOutlineMockImpl extends NotesBaseMockImpl implements
		NotesOutline {

	private final String outlineName;
	private final boolean defaultOutline;

	public NotesOutlineMockImpl(String name, boolean defaultOutline) {
		this.outlineName = name;
		this.defaultOutline = defaultOutline;
	}

	@Override
	public int save() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesOutlineEntry getParent(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getNext(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getPrev(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getNextSibling(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getPrevSibling(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getChild(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getFirst() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry getLast() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEntry(NotesOutlineEntry arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlias() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComment() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParentDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlias(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setComment(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}