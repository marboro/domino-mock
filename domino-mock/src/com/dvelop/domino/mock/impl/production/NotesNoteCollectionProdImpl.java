package com.dvelop.domino.mock.impl.production;

import lotus.domino.NoteCollection;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesForm;
import com.dvelop.domino.mock.interfaces.NotesNoteCollection;
import com.dvelop.domino.mock.interfaces.NotesView;

public class NotesNoteCollectionProdImpl extends NotesBaseProdImpl implements
		NotesNoteCollection {

	private final NoteCollection noteCollection;

	public NotesNoteCollectionProdImpl(NoteCollection noteCollection) {
		this.noteCollection = noteCollection;
	}

	public NoteCollection get() {
		return noteCollection;
	}

	@Override
	public void selectAllNotes(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllNotes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void selectAllDataNotes(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllDataNotes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void selectAllAdminNotes(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllAdminNotes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void selectAllDesignElements(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllDesignElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void selectAllFormatElements(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllFormatElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void selectAllIndexElements(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllIndexElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void selectAllCodeElements(boolean arg0) throws NotesApiException {
		try {
			noteCollection.selectAllCodeElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void buildCollection() throws NotesApiException {
		try {
			noteCollection.buildCollection();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void clearCollection() throws NotesApiException {
		try {
			noteCollection.clearCollection();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(String arg0) throws NotesApiException {
		try {
			noteCollection.add(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(int arg0) throws NotesApiException {
		try {
			noteCollection.add(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesDocument arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesDocumentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesDocumentCollection arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesDocumentCollectionProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesNoteCollection arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesNoteCollectionProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesForm arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesFormProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesAgent arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesAgentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void add(NotesView arg0) throws NotesApiException {
		try {
			noteCollection.add(((NotesViewProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(String arg0) throws NotesApiException {
		try {
			noteCollection.remove(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void remove(int arg0) throws NotesApiException {
		try {
			noteCollection.remove(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesDocument arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesDocumentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesDocumentCollection arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesDocumentCollectionProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesNoteCollection arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesNoteCollectionProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesForm arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesFormProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesAgent arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesAgentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove(NotesView arg0) throws NotesApiException {
		try {
			noteCollection.remove(((NotesViewProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(String arg0) throws NotesApiException {
		try {
			noteCollection.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(int arg0) throws NotesApiException {
		try {
			noteCollection.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesDocument arg0) throws NotesApiException {
		try {
			noteCollection.intersect(((NotesDocumentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesDocumentCollection arg0)
			throws NotesApiException {
		try {
			noteCollection.intersect(((NotesDocumentCollectionProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesNoteCollection arg0) throws NotesApiException {
		try {
			noteCollection
					.intersect(((NotesNoteCollectionProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesForm arg0) throws NotesApiException {
		try {
			noteCollection.intersect(((NotesFormProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesAgent arg0) throws NotesApiException {
		try {
			noteCollection.intersect(((NotesAgentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void intersect(NotesView arg0) throws NotesApiException {
		try {
			noteCollection.intersect(((NotesViewProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFirstNoteID() throws NotesApiException {
		try {
			return noteCollection.getFirstNoteID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNextNoteID(String arg0) throws NotesApiException {
		try {
			return noteCollection.getNextNoteID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectDocuments(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectDocuments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectDocuments() throws NotesApiException {
		try {
			return noteCollection.getSelectDocuments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectProfiles(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectProfiles(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectProfiles() throws NotesApiException {
		try {
			return noteCollection.getSelectProfiles();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectForms(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectForms(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectForms() throws NotesApiException {
		try {
			return noteCollection.getSelectForms();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectSubforms(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectSubforms(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectSubforms() throws NotesApiException {
		try {
			return noteCollection.getSelectSubforms();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectActions(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectActions(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectActions() throws NotesApiException {
		try {
			return noteCollection.getSelectActions();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectFramesets(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectFramesets(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectFramesets() throws NotesApiException {
		try {
			return noteCollection.getSelectFramesets();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectPages(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectPages(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectPages() throws NotesApiException {
		try {
			return noteCollection.getSelectPages();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectImageResources(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectImageResources(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectImageResources() throws NotesApiException {
		try {
			return noteCollection.getSelectImageResources();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectStylesheetResources(boolean arg0)
			throws NotesApiException {
		try {
			noteCollection.setSelectStylesheetResources(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectStylesheetResources() throws NotesApiException {
		try {
			return noteCollection.getSelectStylesheetResources();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectJavaResources(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectJavaResources(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectJavaResources() throws NotesApiException {
		try {
			return noteCollection.getSelectJavaResources();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectMiscFormatElements(boolean arg0)
			throws NotesApiException {
		try {
			noteCollection.setSelectMiscFormatElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectMiscFormatElements() throws NotesApiException {
		try {
			return noteCollection.getSelectMiscFormatElements();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectViews(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectViews(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectViews() throws NotesApiException {
		try {
			return noteCollection.getSelectViews();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectFolders(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectFolders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectFolders() throws NotesApiException {
		try {
			return noteCollection.getSelectFolders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectNavigators(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectNavigators(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectNavigators() throws NotesApiException {
		try {
			return noteCollection.getSelectNavigators();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectMiscIndexElements(boolean arg0)
			throws NotesApiException {
		try {
			noteCollection.setSelectMiscIndexElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectMiscIndexElements() throws NotesApiException {
		try {
			return noteCollection.getSelectMiscIndexElements();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectIcon(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectIcon(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectIcon() throws NotesApiException {
		try {
			return noteCollection.getSelectIcon();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectAgents(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectAgents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectAgents() throws NotesApiException {
		try {
			return noteCollection.getSelectAgents();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectOutlines(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectOutlines(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectOutlines() throws NotesApiException {
		try {
			return noteCollection.getSelectOutlines();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectDatabaseScript(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectDatabaseScript(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectDatabaseScript() throws NotesApiException {
		try {
			return noteCollection.getSelectDatabaseScript();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectScriptLibraries(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectScriptLibraries(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectScriptLibraries() throws NotesApiException {
		try {
			return noteCollection.getSelectScriptLibraries();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectDataConnections(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectDataConnections(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectDataConnections() throws NotesApiException {
		try {
			return noteCollection.getSelectDataConnections();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectMiscCodeElements(boolean arg0)
			throws NotesApiException {
		try {
			noteCollection.setSelectMiscCodeElements(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectMiscCodeElements() throws NotesApiException {
		try {
			return noteCollection.getSelectMiscCodeElements();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectSharedFields(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectSharedFields(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectSharedFields() throws NotesApiException {
		try {
			return noteCollection.getSelectSharedFields();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectHelpAbout(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectHelpAbout(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectHelpAbout() throws NotesApiException {
		try {
			return noteCollection.getSelectHelpAbout();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectHelpUsing(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectHelpUsing(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectHelpUsing() throws NotesApiException {
		try {
			return noteCollection.getSelectHelpUsing();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectHelpIndex(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectHelpIndex(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectHelpIndex() throws NotesApiException {
		try {
			return noteCollection.getSelectHelpIndex();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectReplicationFormulas(boolean arg0)
			throws NotesApiException {
		try {
			noteCollection.setSelectReplicationFormulas(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectReplicationFormulas() throws NotesApiException {
		try {
			return noteCollection.getSelectReplicationFormulas();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectAcl(boolean arg0) throws NotesApiException {
		try {
			noteCollection.setSelectAcl(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getSelectAcl() throws NotesApiException {
		try {
			return noteCollection.getSelectAcl();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSelectionFormula(String arg0) throws NotesApiException {
		try {
			noteCollection.setSelectionFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSelectionFormula() throws NotesApiException {
		try {
			return noteCollection.getSelectionFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getCount() throws NotesApiException {
		try {
			return noteCollection.getCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSinceTime(NotesDateTime arg0) throws NotesApiException {
		try {
			noteCollection.setSinceTime(((NotesDateTimeProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getSinceTime() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(noteCollection.getSinceTime());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastBuildTime() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(noteCollection.getLastBuildTime());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(noteCollection.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}