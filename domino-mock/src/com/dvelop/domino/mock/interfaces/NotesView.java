package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesView extends NotesBase {
	public static final int SPACING_SINGLE = 0;
	public static final int SPACING_ONE_POINT_25 = 1;
	public static final int SPACING_ONE_POINT_50 = 2;
	public static final int SPACING_ONE_POINT_75 = 3;
	public static final int SPACING_DOUBLE = 4;
	public static final int VW_SPACING_SINGLE = 0;
	public static final int VW_SPACING_ONE_POINT_25 = 1;
	public static final int VW_SPACING_ONE_POINT_50 = 2;
	public static final int VW_SPACING_ONE_POINT_75 = 3;
	public static final int VW_SPACING_DOUBLE = 4;

	public abstract void clear() throws NotesApiException;

	public abstract NotesViewNavigator createViewNav() throws NotesApiException;

	public abstract NotesViewNavigator createViewNav(int cacheSize)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavMaxLevel(int level)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavMaxLevel(int level,
			int cacheSize) throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFrom(Object entry)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFrom(Object entry,
			int cacheSize) throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromChildren(Object entry)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromChildren(Object entry,
			int cacheSize) throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromDescendants(Object entry)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromDescendants(
			Object entry, int cacheSize) throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromCategory(
			String categoryName) throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromCategory(
			String categoryName, int cacheSize) throws NotesApiException;

	public abstract int FTSearch(String query) throws NotesApiException;

	public abstract int FTSearch(String query, int maxdocs)
			throws NotesApiException;

	public abstract Vector getAliases() throws NotesApiException;

	public abstract int getBackgroundColor() throws NotesApiException;

	public abstract NotesViewColumn getColumn(int columnNumber)
			throws NotesApiException;

	public abstract Vector getColumns() throws NotesApiException;

	public abstract int getColumnCount() throws NotesApiException;

	public abstract Vector getColumnNames() throws NotesApiException;

	public abstract NotesDateTime getCreated() throws NotesApiException;

	public abstract int getHeaderLines() throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract String getUniversalID() throws NotesApiException;

	public abstract Vector getReaders() throws NotesApiException;

	public abstract void setReaders(Vector reader) throws NotesApiException;

	public abstract int getRowLines() throws NotesApiException;

	public abstract int getSpacing() throws NotesApiException;

	public abstract int getTopLevelEntryCount() throws NotesApiException;

	public abstract NotesDocument getFirstDocument() throws NotesApiException;

	public abstract NotesDocument getLastDocument() throws NotesApiException;

	public abstract NotesDocument getNextDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getPrevDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getNextSibling(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getPrevSibling(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getParentDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getChild(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getNthDocument(int n)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByKey(Vector keys)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByKey(Vector keys, boolean exact)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByKey(Object key)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByKey(Object key, boolean exact)
			throws NotesApiException;

	public abstract NotesViewEntry getEntryByKey(Vector keys)
			throws NotesApiException;

	public abstract NotesViewEntry getEntryByKey(Vector keys, boolean exact)
			throws NotesApiException;

	public abstract NotesViewEntry getEntryByKey(Object key)
			throws NotesApiException;

	public abstract NotesViewEntry getEntryByKey(Object key, boolean exact)
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllDocumentsByKey(Vector keys)
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllDocumentsByKey(Vector keys,
			boolean exact) throws NotesApiException;

	public abstract NotesDocumentCollection getAllDocumentsByKey(Object key)
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllDocumentsByKey(Object key,
			boolean exact) throws NotesApiException;

	public abstract NotesViewEntryCollection getAllEntriesByKey(Vector keys)
			throws NotesApiException;

	public abstract NotesViewEntryCollection getAllEntriesByKey(Vector keys,
			boolean exact) throws NotesApiException;

	public abstract NotesViewEntryCollection getAllEntriesByKey(Object key)
			throws NotesApiException;

	public abstract NotesViewEntryCollection getAllEntriesByKey(Object key,
			boolean exact) throws NotesApiException;

	public abstract NotesViewEntryCollection getAllEntries()
			throws NotesApiException;

	public abstract boolean isAutoUpdate() throws NotesApiException;

	public abstract void setAutoUpdate(boolean flag) throws NotesApiException;

	public abstract boolean isCalendar() throws NotesApiException;

	public abstract boolean isCategorized() throws NotesApiException;

	public abstract boolean isConflict() throws NotesApiException;

	public abstract boolean isDefaultView() throws NotesApiException;

	public abstract boolean isFolder() throws NotesApiException;

	public abstract boolean isHierarchical() throws NotesApiException;

	public abstract boolean isModified() throws NotesApiException;

	public abstract boolean isPrivate() throws NotesApiException;

	public abstract boolean isQueryView() throws NotesApiException;

	public abstract boolean isProtectReaders() throws NotesApiException;

	public abstract void setProtectReaders(boolean flag)
			throws NotesApiException;

	public abstract void refresh() throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract NotesViewColumn createColumn() throws NotesApiException;

	public abstract NotesViewColumn createColumn(int position)
			throws NotesApiException;

	public abstract NotesViewColumn createColumn(int position,
			String columntitle) throws NotesApiException;

	public abstract NotesViewColumn createColumn(int position,
			String columntitle, String formula) throws NotesApiException;

	public abstract NotesViewColumn copyColumn(int sourcecolumn)
			throws NotesApiException;

	public abstract NotesViewColumn copyColumn(String sourcecolumn)
			throws NotesApiException;

	public abstract NotesViewColumn copyColumn(NotesViewColumn sourcecolumn)
			throws NotesApiException;

	public abstract NotesViewColumn copyColumn(int sourcecolumn,
			int destinationindex) throws NotesApiException;

	public abstract NotesViewColumn copyColumn(String sourcecolumn,
			int destinationindex) throws NotesApiException;

	public abstract NotesViewColumn copyColumn(NotesViewColumn sourcecolumn,
			int destinationindex) throws NotesApiException;

	public abstract void removeColumn() throws NotesApiException;

	public abstract void removeColumn(int columnindex) throws NotesApiException;

	public abstract void removeColumn(String columntitle)
			throws NotesApiException;

	public abstract void setAliases(Vector aliases) throws NotesApiException;

	public abstract void setAliases(String aliases) throws NotesApiException;

	public abstract boolean isProhibitDesignRefresh() throws NotesApiException;

	public abstract void setProhibitDesignRefresh(boolean flag)
			throws NotesApiException;

	public abstract void setDefaultView(boolean flag) throws NotesApiException;

	public abstract void setBackgroundColor(int color) throws NotesApiException;

	public abstract void setSpacing(int spacing) throws NotesApiException;

	public abstract void setName(String name) throws NotesApiException;

	public abstract void setSelectionFormula(String formula)
			throws NotesApiException;

	public abstract String getSelectionFormula() throws NotesApiException;

	public abstract int getEntryCount() throws NotesApiException;

	public abstract Vector getLockHolders() throws NotesApiException;

	public abstract String getViewInheritedName() throws NotesApiException;

	public abstract boolean lock() throws NotesApiException;

	public abstract boolean lock(boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lock(String name) throws NotesApiException;

	public abstract boolean lock(String name, boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lock(Vector names) throws NotesApiException;

	public abstract boolean lock(Vector names, boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lockProvisional() throws NotesApiException;

	public abstract boolean lockProvisional(String name)
			throws NotesApiException;

	public abstract boolean lockProvisional(Vector names)
			throws NotesApiException;

	public abstract void unlock() throws NotesApiException;

	public abstract void markAllRead(String username) throws NotesApiException;

	public abstract void markAllUnread(String username)
			throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromAllUnread(
			String userName) throws NotesApiException;

	public abstract void markAllRead() throws NotesApiException;

	public abstract void markAllUnread() throws NotesApiException;

	public abstract NotesViewNavigator createViewNavFromAllUnread()
			throws NotesApiException;

	public abstract NotesViewEntryCollection createViewEntryCollection()
			throws NotesApiException;

	public abstract String getSelectionQuery() throws NotesApiException;

	public abstract void setSelectionQuery(String query)
			throws NotesApiException;

	public abstract Vector getColumnValues(int n) throws NotesApiException;

	public abstract void resortView(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void resortView() throws NotesApiException;

	public abstract NotesViewEntryCollection getAllUnreadEntries()
			throws NotesApiException;

	public abstract NotesViewEntryCollection getAllUnreadEntries(String userName)
			throws NotesApiException;

	public abstract NotesViewEntryCollection getAllReadEntries()
			throws NotesApiException;

	public abstract NotesViewEntryCollection getAllReadEntries(String userName)
			throws NotesApiException;
}
