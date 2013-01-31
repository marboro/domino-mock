package com.dvelop.domino.mock.impl.mock;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDxlImporter;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesStream;

public class NotesDxlImporterMockImpl extends NotesBaseMockImpl implements
		NotesDxlImporter {

	@Override
	public void importDxl(String arg0, NotesDatabase arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void importDxl(NotesStream arg0, NotesDatabase arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void importDxl(NotesRichTextItem arg0, NotesDatabase arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFirstImportedNoteID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNextImportedNoteID(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLog() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogComment(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLogComment() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExitOnFirstFatalError(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getExitOnFirstFatalError() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getImportedNoteCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInputValidationOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getInputValidationOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAclImportOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAclImportOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDesignImportOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDesignImportOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDocumentImportOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDocumentImportOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUnknownTokenLogOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUnknownTokenLogOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setReplaceDbProperties(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getReplaceDbProperties() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCreateFTIndex(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getCreateFTIndex() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReplicaRequiredForReplaceOrUpdate(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getReplicaRequiredForReplaceOrUpdate()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCompileLotusScript(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getCompileLotusScript() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}
}