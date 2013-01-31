package com.dvelop.domino.mock.impl.production;

import java.util.Iterator;
import java.util.Vector;

import lotus.domino.DateTime;
import lotus.domino.Document;
import lotus.domino.NotesException;
import lotus.domino.View;
import lotus.domino.ViewColumn;
import lotus.domino.ViewEntry;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesView;
import com.dvelop.domino.mock.interfaces.NotesViewColumn;
import com.dvelop.domino.mock.interfaces.NotesViewEntry;
import com.dvelop.domino.mock.interfaces.NotesViewEntryCollection;
import com.dvelop.domino.mock.interfaces.NotesViewNavigator;

public class NotesViewProdImpl extends NotesBaseProdImpl implements NotesView {

	private final View view;

	public NotesViewProdImpl(View view) {
		this.view = view;
	}

	public View get() {
		return view;
	}

	@Override
	public void clear() throws NotesApiException {
		try {
			view.clear();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNav() throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(view.createViewNav());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNav(int arg0) throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(view.createViewNav(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavMaxLevel(int arg0)
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(
					view.createViewNavMaxLevel(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavMaxLevel(int arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(view.createViewNavMaxLevel(
					arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFrom(Object arg0)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFrom((Document) arg0));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFrom((ViewEntry) arg0));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFrom(Object arg0, int arg1)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(view.createViewNavFrom(
						(Document) arg0, arg1));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(view.createViewNavFrom(
						(ViewEntry) arg0, arg1));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromChildren(Object arg0)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromChildren((Document) arg0));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromChildren((ViewEntry) arg0));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromChildren(Object arg0, int arg1)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromChildren((Document) arg0, arg1));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromChildren((ViewEntry) arg0, arg1));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromDescendants(Object arg0)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromDescendants((Document) arg0));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromDescendants((ViewEntry) arg0));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromDescendants(Object arg0, int arg1)
			throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromDescendants((Document) arg0, arg1));
			} else if (arg0 instanceof ViewEntry) {
				return new NotesViewNavigatorProdImpl(
						view.createViewNavFromDescendants((ViewEntry) arg0,
								arg1));
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromCategory(String arg0)
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(
					view.createViewNavFromCategory(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromCategory(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(
					view.createViewNavFromCategory(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int FTSearch(String arg0) throws NotesApiException {
		try {
			return view.FTSearch(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int FTSearch(String arg0, int arg1) throws NotesApiException {
		try {
			return view.FTSearch(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAliases() throws NotesApiException {
		try {
			return view.getAliases();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getBackgroundColor() throws NotesApiException {
		try {
			return view.getBackgroundColor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn getColumn(int arg0) throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.getColumn(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getColumns() throws NotesApiException {
		try {
			Vector columns = view.getColumns();
			Vector<NotesViewColumn> vector = new Vector<NotesViewColumn>();
			Iterator iterator = columns.iterator();
			while (iterator.hasNext()) {
				vector.add(new NotesViewColumnProdImpl((ViewColumn) iterator
						.next()));
			}
			return vector;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getColumnCount() throws NotesApiException {
		try {
			return view.getColumnCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getColumnNames() throws NotesApiException {
		try {
			return view.getColumnNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(view.getCreated());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHeaderLines() throws NotesApiException {
		try {
			return view.getHeaderLines();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(view.getLastModified());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return view.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(view.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		try {
			return view.getUniversalID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getReaders() throws NotesApiException {
		try {
			return view.getReaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setReaders(Vector arg0) throws NotesApiException {
		try {
			view.setReaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getRowLines() throws NotesApiException {
		try {
			return view.getRowLines();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSpacing() throws NotesApiException {
		try {
			return view.getSpacing();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTopLevelEntryCount() throws NotesApiException {
		try {
			return view.getTopLevelEntryCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getFirstDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getFirstDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getLastDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getLastDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNextDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getNextDocument(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getPrevDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getPrevDocument(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNextSibling(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getNextSibling(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getPrevSibling(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getPrevSibling(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getParentDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getParentDocument(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getChild(NotesDocument arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(
					view.getChild(((NotesDocumentProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNthDocument(int arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getNthDocument(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByKey(Vector arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getDocumentByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getDocumentByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByKey(Object arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getDocumentByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(view.getDocumentByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getEntryByKey(Vector arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(view.getEntryByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getEntryByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(view.getEntryByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getEntryByKey(Object arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(view.getEntryByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getEntryByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(view.getEntryByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Vector arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					view.getAllDocumentsByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Vector arg0,
			boolean arg1) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					view.getAllDocumentsByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Object arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					view.getAllDocumentsByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Object arg0,
			boolean arg1) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					view.getAllDocumentsByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Vector arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllEntriesByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllEntriesByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Object arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllEntriesByKey(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllEntriesByKey(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllEntries() throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(view.getAllEntries());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAutoUpdate() throws NotesApiException {
		try {
			return view.isAutoUpdate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAutoUpdate(boolean arg0) throws NotesApiException {
		try {
			view.setAutoUpdate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCalendar() throws NotesApiException {
		try {
			return view.isCalendar();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCategorized() throws NotesApiException {
		try {
			return view.isCategorized();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConflict() throws NotesApiException {
		try {
			return view.isConflict();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDefaultView() throws NotesApiException {
		try {
			return view.isDefaultView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFolder() throws NotesApiException {
		try {
			return view.isFolder();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHierarchical() throws NotesApiException {
		try {
			return view.isHierarchical();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isModified() throws NotesApiException {
		try {
			return view.isModified();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPrivate() throws NotesApiException {
		try {
			return view.isPrivate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isQueryView() throws NotesApiException {
		try {
			return view.isQueryView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProtectReaders() throws NotesApiException {
		try {
			return view.isProtectReaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProtectReaders(boolean arg0) throws NotesApiException {
		try {
			view.setProtectReaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void refresh() throws NotesApiException {
		try {
			view.refresh();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			view.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return view.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		try {
			return view.getNotesURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return view.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn createColumn() throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.createColumn());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn createColumn(int arg0) throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.createColumn(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn createColumn(int arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.createColumn(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn createColumn(int arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.createColumn(arg0, arg1,
					arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(int arg0) throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.copyColumn(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(String arg0) throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.copyColumn(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(NotesViewColumn arg0)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(
					view.copyColumn(((NotesViewColumnProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(int arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.copyColumn(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.copyColumn(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewColumn copyColumn(NotesViewColumn arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesViewColumnProdImpl(view.copyColumn(
					((NotesViewColumnProdImpl) arg0).get(), arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeColumn() throws NotesApiException {
		try {
			view.removeColumn();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeColumn(int arg0) throws NotesApiException {
		try {
			view.removeColumn(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeColumn(String arg0) throws NotesApiException {
		try {
			view.removeColumn(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAliases(Vector arg0) throws NotesApiException {
		try {
			view.setAliases(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAliases(String arg0) throws NotesApiException {
		try {
			view.setAliases(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProhibitDesignRefresh() throws NotesApiException {
		try {
			return view.isProhibitDesignRefresh();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProhibitDesignRefresh(boolean arg0) throws NotesApiException {
		try {
			view.setProhibitDesignRefresh(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDefaultView(boolean arg0) throws NotesApiException {
		try {
			view.setDefaultView(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setBackgroundColor(int arg0) throws NotesApiException {
		try {
			view.setBackgroundColor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSpacing(int arg0) throws NotesApiException {
		try {
			view.setSpacing(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setName(String arg0) throws NotesApiException {
		try {
			view.setName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectionFormula(String arg0) throws NotesApiException {
		try {
			view.setSelectionFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSelectionFormula() throws NotesApiException {
		try {
			return view.getSelectionFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getEntryCount() throws NotesApiException {
		try {
			return view.getEntryCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		try {
			return view.getLockHolders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getViewInheritedName() throws NotesApiException {
		try {
			return view.getViewInheritedName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock() throws NotesApiException {
		try {
			return view.lock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		try {
			return view.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		try {
			return view.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		try {
			return view.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		try {
			return view.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		try {
			return view.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		try {
			return view.lockProvisional();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		try {
			return view.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		try {
			return view.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void unlock() throws NotesApiException {
		try {
			view.unlock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead(String arg0) throws NotesApiException {
		try {
			view.markAllRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
		try {
			view.markAllUnread(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromAllUnread(String arg0)
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(
					view.createViewNavFromAllUnread(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead() throws NotesApiException {
		try {
			view.markAllRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void markAllUnread() throws NotesApiException {
		try {
			view.markAllUnread();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewNavigator createViewNavFromAllUnread()
			throws NotesApiException {
		try {
			return new NotesViewNavigatorProdImpl(
					view.createViewNavFromAllUnread());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection createViewEntryCollection()
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.createViewEntryCollection());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSelectionQuery() throws NotesApiException {
		try {
			return view.getSelectionQuery();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectionQuery(String arg0) throws NotesApiException {
		try {
			view.setSelectionQuery(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getColumnValues(int arg0) throws NotesApiException {
		try {
			Vector columnValues = view.getColumnValues(arg0);
			if (columnValues.size() > 0) {
				if (columnValues instanceof DateTime) {
					Vector<NotesDateTime> vector = new Vector<NotesDateTime>();
					Iterator iterator = columnValues.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return vector;
				}
			}
			return columnValues;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void resortView(String arg0, boolean arg1) throws NotesApiException {
		try {
			view.resortView(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void resortView() throws NotesApiException {
		try {
			view.resortView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllUnreadEntries()
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllUnreadEntries());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllUnreadEntries(String arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllUnreadEntries(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllReadEntries()
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllReadEntries());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntryCollection getAllReadEntries(String arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryCollectionProdImpl(
					view.getAllReadEntries(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}