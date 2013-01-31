package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesNoteCollection extends NotesBase {
	public abstract void selectAllNotes(boolean arg0) throws NotesApiException;

	public abstract void selectAllDataNotes(boolean arg0)
			throws NotesApiException;

	public abstract void selectAllAdminNotes(boolean arg0)
			throws NotesApiException;

	public abstract void selectAllDesignElements(boolean arg0)
			throws NotesApiException;

	public abstract void selectAllFormatElements(boolean arg0)
			throws NotesApiException;

	public abstract void selectAllIndexElements(boolean arg0)
			throws NotesApiException;

	public abstract void selectAllCodeElements(boolean arg0)
			throws NotesApiException;

	public abstract void buildCollection() throws NotesApiException;

	public abstract void clearCollection() throws NotesApiException;

	public abstract void add(String arg0) throws NotesApiException;

	public abstract void add(int arg0) throws NotesApiException;

	public abstract void add(NotesDocument arg0) throws NotesApiException;

	public abstract void add(NotesDocumentCollection arg0)
			throws NotesApiException;

	public abstract void add(NotesNoteCollection arg0) throws NotesApiException;

	public abstract void add(NotesForm arg0) throws NotesApiException;

	public abstract void add(NotesAgent arg0) throws NotesApiException;

	public abstract void add(NotesView arg0) throws NotesApiException;

	public abstract void remove(String arg0) throws NotesApiException;

	public abstract void remove(int arg0) throws NotesApiException;

	public abstract void remove(NotesDocument arg0) throws NotesApiException;

	public abstract void remove(NotesDocumentCollection arg0)
			throws NotesApiException;

	public abstract void remove(NotesNoteCollection arg0)
			throws NotesApiException;

	public abstract void remove(NotesForm arg0) throws NotesApiException;

	public abstract void remove(NotesAgent arg0) throws NotesApiException;

	public abstract void remove(NotesView arg0) throws NotesApiException;

	public abstract void intersect(String arg0) throws NotesApiException;

	public abstract void intersect(int arg0) throws NotesApiException;

	public abstract void intersect(NotesDocument arg0) throws NotesApiException;

	public abstract void intersect(NotesDocumentCollection arg0)
			throws NotesApiException;

	public abstract void intersect(NotesNoteCollection arg0)
			throws NotesApiException;

	public abstract void intersect(NotesForm arg0) throws NotesApiException;

	public abstract void intersect(NotesAgent arg0) throws NotesApiException;

	public abstract void intersect(NotesView arg0) throws NotesApiException;

	public abstract String getFirstNoteID() throws NotesApiException;

	public abstract String getNextNoteID(String arg0) throws NotesApiException;

	public abstract void setSelectDocuments(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectDocuments() throws NotesApiException;

	public abstract void setSelectProfiles(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectProfiles() throws NotesApiException;

	public abstract void setSelectForms(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectForms() throws NotesApiException;

	public abstract void setSelectSubforms(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectSubforms() throws NotesApiException;

	public abstract void setSelectActions(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectActions() throws NotesApiException;

	public abstract void setSelectFramesets(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectFramesets() throws NotesApiException;

	public abstract void setSelectPages(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectPages() throws NotesApiException;

	public abstract void setSelectImageResources(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectImageResources() throws NotesApiException;

	public abstract void setSelectStylesheetResources(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectStylesheetResources()
			throws NotesApiException;

	public abstract void setSelectJavaResources(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectJavaResources() throws NotesApiException;

	public abstract void setSelectMiscFormatElements(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectMiscFormatElements()
			throws NotesApiException;

	public abstract void setSelectViews(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectViews() throws NotesApiException;

	public abstract void setSelectFolders(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectFolders() throws NotesApiException;

	public abstract void setSelectNavigators(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectNavigators() throws NotesApiException;

	public abstract void setSelectMiscIndexElements(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectMiscIndexElements()
			throws NotesApiException;

	public abstract void setSelectIcon(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectIcon() throws NotesApiException;

	public abstract void setSelectAgents(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectAgents() throws NotesApiException;

	public abstract void setSelectOutlines(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectOutlines() throws NotesApiException;

	public abstract void setSelectDatabaseScript(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectDatabaseScript() throws NotesApiException;

	public abstract void setSelectScriptLibraries(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectScriptLibraries() throws NotesApiException;

	public abstract void setSelectDataConnections(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectDataConnections() throws NotesApiException;

	public abstract void setSelectMiscCodeElements(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectMiscCodeElements()
			throws NotesApiException;

	public abstract void setSelectSharedFields(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectSharedFields() throws NotesApiException;

	public abstract void setSelectHelpAbout(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectHelpAbout() throws NotesApiException;

	public abstract void setSelectHelpUsing(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectHelpUsing() throws NotesApiException;

	public abstract void setSelectHelpIndex(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectHelpIndex() throws NotesApiException;

	public abstract void setSelectReplicationFormulas(boolean arg0)
			throws NotesApiException;

	public abstract boolean getSelectReplicationFormulas()
			throws NotesApiException;

	public abstract void setSelectAcl(boolean arg0) throws NotesApiException;

	public abstract boolean getSelectAcl() throws NotesApiException;

	public abstract void setSelectionFormula(String arg0)
			throws NotesApiException;

	public abstract String getSelectionFormula() throws NotesApiException;

	public abstract int getCount() throws NotesApiException;

	public abstract void setSinceTime(NotesDateTime arg0)
			throws NotesApiException;

	public abstract NotesDateTime getSinceTime() throws NotesApiException;

	public abstract NotesDateTime getLastBuildTime() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;
}
