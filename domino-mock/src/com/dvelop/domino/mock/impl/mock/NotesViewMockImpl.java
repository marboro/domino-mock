package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

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

public class NotesViewMockImpl extends NotesBaseMockImpl implements NotesView {

	private final String viewName;
	private final String formula;
	private final NotesView templateView;
	private final boolean prohibitDesignRefreshModifications;
	private final NotesDatabase parent;
	private boolean isFolder;

	public NotesViewMockImpl(String viewName, String formula,
			NotesView templateView, boolean prohibitDesignRefreshModifications,
			NotesDatabase parent) {
		this.viewName = viewName;
		this.formula = formula;
		this.templateView = templateView;
		this.prohibitDesignRefreshModifications = prohibitDesignRefreshModifications;
		this.parent = parent;
		this.isFolder = false;
	}

	@Override
	public void clear() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesViewNavigator createViewNav() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNav(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavMaxLevel(int arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavMaxLevel(int arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFrom(Object arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFrom(Object arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromChildren(Object arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromChildren(Object arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromDescendants(Object arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromDescendants(Object arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromCategory(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewNavigator createViewNavFromCategory(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int FTSearch(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FTSearch(String arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getAliases() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBackgroundColor() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesViewColumn getColumn(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getColumns() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getColumnNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeaderLines() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getReaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReaders(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRowLines() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpacing() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTopLevelEntryCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDocument getFirstDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getLastDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNextDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getPrevDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNextSibling(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getPrevSibling(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getParentDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getChild(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNthDocument(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByKey(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByKey(Object arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getEntryByKey(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getEntryByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getEntryByKey(Object arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getEntryByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Vector arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Vector arg0,
			boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Object arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllDocumentsByKey(Object arg0,
			boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Vector arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Vector arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Object arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllEntriesByKey(Object arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllEntries() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoUpdate() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAutoUpdate(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCalendar() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCategorized() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConflict() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefaultView() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFolder() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHierarchical() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQueryView() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtectReaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProtectReaders(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn createColumn() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn createColumn(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn createColumn(int arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn createColumn(int arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(NotesViewColumn arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(int arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewColumn copyColumn(NotesViewColumn arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeColumn() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeColumn(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeColumn(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAliases(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAliases(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isProhibitDesignRefresh() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProhibitDesignRefresh(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDefaultView(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBackgroundColor(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSpacing(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectionFormula(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSelectionFormula() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntryCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getViewInheritedName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lock() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllRead(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesViewNavigator createViewNavFromAllUnread(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markAllRead() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesViewNavigator createViewNavFromAllUnread()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection createViewEntryCollection()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSelectionQuery() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelectionQuery(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getColumnValues(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resortView(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void resortView() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesViewEntryCollection getAllUnreadEntries()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllUnreadEntries(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllReadEntries()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntryCollection getAllReadEntries(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIsFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
}