package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesNoteCollection extends NotesBase {
	public abstract void selectAllNotes(boolean selectorvalue) throws NotesApiException;

	public abstract void selectAllDataNotes(boolean selectorvalue)
			throws NotesApiException;

	public abstract void selectAllAdminNotes(boolean selectorvalue)
			throws NotesApiException;

	public abstract void selectAllDesignElements(boolean selectorvalue)
			throws NotesApiException;

	public abstract void selectAllFormatElements(boolean selectorvalue)
			throws NotesApiException;

	public abstract void selectAllIndexElements(boolean selectorvalue)
			throws NotesApiException;

	public abstract void selectAllCodeElements(boolean selectorvalue)
			throws NotesApiException;

	public abstract void buildCollection() throws NotesApiException;

	public abstract void clearCollection() throws NotesApiException;

	public abstract void add(String additionSpecifier) throws NotesApiException;

	public abstract void add(int additionSpecifier) throws NotesApiException;

	public abstract void add(NotesDocument additionSpecifier) throws NotesApiException;

	public abstract void add(NotesDocumentCollection additionSpecifier)
			throws NotesApiException;

	public abstract void add(NotesNoteCollection additionSpecifier) throws NotesApiException;

	public abstract void add(NotesForm additionSpecifier) throws NotesApiException;

	public abstract void add(NotesAgent additionSpecifier) throws NotesApiException;

	public abstract void add(NotesView additionSpecifier) throws NotesApiException;

	public abstract void remove(String removalSpecifier) throws NotesApiException;

	public abstract void remove(int removalSpecifier) throws NotesApiException;

	public abstract void remove(NotesDocument removalSpecifier) throws NotesApiException;

	public abstract void remove(NotesDocumentCollection removalSpecifier)
			throws NotesApiException;

	public abstract void remove(NotesNoteCollection removalSpecifier)
			throws NotesApiException;

	public abstract void remove(NotesForm removalSpecifier) throws NotesApiException;

	public abstract void remove(NotesAgent removalSpecifier) throws NotesApiException;

	public abstract void remove(NotesView removalSpecifier) throws NotesApiException;

	public abstract void intersect(String intersectionSpecifier) throws NotesApiException;

	public abstract void intersect(int intersectionSpecifier) throws NotesApiException;

	public abstract void intersect(NotesDocument intersectionSpecifier) throws NotesApiException;

	public abstract void intersect(NotesDocumentCollection intersectionSpecifier)
			throws NotesApiException;

	public abstract void intersect(NotesNoteCollection intersectionSpecifier)
			throws NotesApiException;

	public abstract void intersect(NotesForm intersectionSpecifier) throws NotesApiException;

	public abstract void intersect(NotesAgent intersectionSpecifier) throws NotesApiException;

	public abstract void intersect(NotesView intersectionSpecifier) throws NotesApiException;

	public abstract String getFirstNoteID() throws NotesApiException;

	public abstract String getNextNoteID(String noteID) throws NotesApiException;

	public abstract void setSelectDocuments(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectDocuments() throws NotesApiException;

	public abstract void setSelectProfiles(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectProfiles() throws NotesApiException;

	public abstract void setSelectForms(boolean flag) throws NotesApiException;

	public abstract boolean getSelectForms() throws NotesApiException;

	public abstract void setSelectSubforms(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectSubforms() throws NotesApiException;

	public abstract void setSelectActions(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectActions() throws NotesApiException;

	public abstract void setSelectFramesets(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectFramesets() throws NotesApiException;

	public abstract void setSelectPages(boolean flag) throws NotesApiException;

	public abstract boolean getSelectPages() throws NotesApiException;

	public abstract void setSelectImageResources(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectImageResources() throws NotesApiException;

	public abstract void setSelectStylesheetResources(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectStylesheetResources()
			throws NotesApiException;

	public abstract void setSelectJavaResources(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectJavaResources() throws NotesApiException;

	public abstract void setSelectMiscFormatElements(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectMiscFormatElements()
			throws NotesApiException;

	public abstract void setSelectViews(boolean flag) throws NotesApiException;

	public abstract boolean getSelectViews() throws NotesApiException;

	public abstract void setSelectFolders(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectFolders() throws NotesApiException;

	public abstract void setSelectNavigators(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectNavigators() throws NotesApiException;

	public abstract void setSelectMiscIndexElements(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectMiscIndexElements()
			throws NotesApiException;

	public abstract void setSelectIcon(boolean flag) throws NotesApiException;

	public abstract boolean getSelectIcon() throws NotesApiException;

	public abstract void setSelectAgents(boolean flag) throws NotesApiException;

	public abstract boolean getSelectAgents() throws NotesApiException;

	public abstract void setSelectOutlines(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectOutlines() throws NotesApiException;

	public abstract void setSelectDatabaseScript(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectDatabaseScript() throws NotesApiException;

	public abstract void setSelectScriptLibraries(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectScriptLibraries() throws NotesApiException;

	public abstract void setSelectDataConnections(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectDataConnections() throws NotesApiException;

	public abstract void setSelectMiscCodeElements(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectMiscCodeElements()
			throws NotesApiException;

	public abstract void setSelectSharedFields(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectSharedFields() throws NotesApiException;

	public abstract void setSelectHelpAbout(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectHelpAbout() throws NotesApiException;

	public abstract void setSelectHelpUsing(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectHelpUsing() throws NotesApiException;

	public abstract void setSelectHelpIndex(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectHelpIndex() throws NotesApiException;

	public abstract void setSelectReplicationFormulas(boolean flag)
			throws NotesApiException;

	public abstract boolean getSelectReplicationFormulas()
			throws NotesApiException;

	public abstract void setSelectAcl(boolean flag) throws NotesApiException;

	public abstract boolean getSelectAcl() throws NotesApiException;

	public abstract void setSelectionFormula(String flag)
			throws NotesApiException;

	public abstract String getSelectionFormula() throws NotesApiException;

	public abstract int getCount() throws NotesApiException;

	public abstract void setSinceTime(NotesDateTime sinceTime)
			throws NotesApiException;

	public abstract NotesDateTime getSinceTime() throws NotesApiException;

	public abstract NotesDateTime getLastBuildTime() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;
}
