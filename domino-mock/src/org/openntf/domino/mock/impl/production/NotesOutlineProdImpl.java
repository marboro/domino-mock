package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesOutline;
import org.openntf.domino.mock.interfaces.NotesOutlineEntry;

import lotus.domino.NotesException;
import lotus.domino.Outline;


public class NotesOutlineProdImpl extends NotesBaseProdImpl implements
		NotesOutline {

	private final Outline outline;

	public NotesOutlineProdImpl(Outline outline) {
		this.outline = outline;
	}

	@Override
	public int save() throws NotesApiException {
		try {
			return outline.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getParent(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getParent(((NotesOutlineEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getNext(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getNext(((NotesOutlineEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getPrev(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getPrev(((NotesOutlineEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getNextSibling(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getNextSibling(((NotesOutlineEntryProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getPrevSibling(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getPrevSibling(((NotesOutlineEntryProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getChild(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.getChild(((NotesOutlineEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getFirst() throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.getFirst());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry getLast() throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.getLast());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0) throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(arg0,
					((NotesOutlineEntryProdImpl) arg1).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(arg0,
					((NotesOutlineEntryProdImpl) arg1).get(), arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(String arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(arg0,
					((NotesOutlineEntryProdImpl) arg1).get(), arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(
					outline.createEntry(((NotesOutlineEntryProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1) throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(
					((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(
					((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException {
		try {
			return new NotesOutlineEntryProdImpl(outline.createEntry(
					((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		try {
			outline.addEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		try {
			outline.addEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		try {
			outline.addEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void removeEntry(NotesOutlineEntry arg0) throws NotesApiException {
		try {
			outline.removeEntry(((NotesOutlineEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1)
			throws NotesApiException {
		try {
			outline.moveEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2) throws NotesApiException {
		try {
			outline.moveEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void moveEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1,
			boolean arg2, boolean arg3) throws NotesApiException {
		try {
			outline.moveEntry(((NotesOutlineEntryProdImpl) arg0).get(),
					((NotesOutlineEntryProdImpl) arg1).get(), arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return outline.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAlias() throws NotesApiException {
		try {
			return outline.getAlias();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getComment() throws NotesApiException {
		try {
			return outline.getComment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParentDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(outline.getParentDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setName(String arg0) throws NotesApiException {
		try {
			outline.setName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAlias(String arg0) throws NotesApiException {
		try {
			outline.setAlias(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setComment(String arg0) throws NotesApiException {
		try {
			outline.setComment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}