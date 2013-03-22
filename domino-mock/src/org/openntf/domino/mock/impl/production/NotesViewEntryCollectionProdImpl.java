package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesBase;
import org.openntf.domino.mock.interfaces.NotesView;
import org.openntf.domino.mock.interfaces.NotesViewEntry;
import org.openntf.domino.mock.interfaces.NotesViewEntryCollection;

import lotus.domino.Document;
import lotus.domino.NotesException;
import lotus.domino.ViewEntry;
import lotus.domino.ViewEntryCollection;


public class NotesViewEntryCollectionProdImpl extends NotesBaseProdImpl
		implements NotesViewEntryCollection {

	private final ViewEntryCollection veCol;

	public NotesViewEntryCollectionProdImpl(ViewEntryCollection veCol) {
		this.veCol = veCol;
	}

	public ViewEntryCollection get() {
		return veCol;
	}

	@Override
	public int getCount() throws NotesApiException {
		try {
			return veCol.getCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getQuery() throws NotesApiException {
		try {
			return veCol.getQuery();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getParent() throws NotesApiException {
		try {
			return new NotesViewProdImpl(veCol.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getFirstEntry() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(veCol.getFirstEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextEntry() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(veCol.getNextEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevEntry() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(veCol.getPrevEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getLastEntry() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(veCol.getLastEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNthEntry(int arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(veCol.getNthEntry(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextEntry(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					veCol.getNextEntry(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevEntry(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					veCol.getPrevEntry(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getEntry(Object arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					veCol.getEntry(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addEntry(Object arg0) throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				veCol.addEntry(new NotesDocumentProdImpl((Document) arg0));
			} else if (arg0 instanceof ViewEntry) {
				veCol.addEntry(new NotesViewEntryProdImpl((ViewEntry) arg0));
			}
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addEntry(Object arg0, boolean arg1) throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				veCol.addEntry(new NotesDocumentProdImpl((Document) arg0), arg1);
			} else if (arg0 instanceof ViewEntry) {
				veCol.addEntry(new NotesViewEntryProdImpl((ViewEntry) arg0),
						arg1);
			}
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void deleteEntry(NotesViewEntry arg0) throws NotesApiException {
		try {
			veCol.deleteEntry(((NotesViewEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void FTSearch(String arg0) throws NotesApiException {
		try {
			veCol.FTSearch(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void FTSearch(String arg0, int arg1) throws NotesApiException {
		try {
			veCol.FTSearch(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void putAllInFolder(String arg0) throws NotesApiException {
		try {
			veCol.putAllInFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void putAllInFolder(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			veCol.putAllInFolder(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeAll(boolean arg0) throws NotesApiException {
		try {
			veCol.removeAll(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeAllFromFolder(String arg0) throws NotesApiException {
		try {
			veCol.removeAllFromFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void stampAll(String arg0, Object arg1) throws NotesApiException {
		try {
			veCol.stampAll(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void updateAll() throws NotesApiException {
		try {
			veCol.updateAll();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead(String arg0) throws NotesApiException {
		try {
			veCol.markAllRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
		try {
			veCol.markAllUnread(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead() throws NotesApiException {
		try {
			veCol.markAllRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllUnread() throws NotesApiException {
		try {
			veCol.markAllUnread();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(int arg0) throws NotesApiException {
		try {
			veCol.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(String arg0) throws NotesApiException {
		try {
			veCol.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesBase arg0) throws NotesApiException {
		try {
			veCol.intersect(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void merge(int arg0) throws NotesApiException {
		try {
			veCol.merge(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void merge(String arg0) throws NotesApiException {
		try {
			veCol.merge(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void merge(NotesBase arg0) throws NotesApiException {
		try {
			veCol.merge(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void subtract(int arg0) throws NotesApiException {
		try {
			veCol.subtract(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void subtract(String arg0) throws NotesApiException {
		try {
			veCol.subtract(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void subtract(NotesBase arg0) throws NotesApiException {
		try {
			veCol.subtract(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean contains(int arg0) throws NotesApiException {
		try {
			return veCol.contains(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean contains(String arg0) throws NotesApiException {
		try {
			return veCol.contains(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean contains(NotesBase arg0) throws NotesApiException {
		try {
			return veCol.contains(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection cloneCollection() throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(veCol.cloneCollection());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}