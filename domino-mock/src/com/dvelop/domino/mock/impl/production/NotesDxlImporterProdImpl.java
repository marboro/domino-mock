package com.dvelop.domino.mock.impl.production;

import lotus.domino.DxlImporter;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDxlImporter;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesStream;

public class NotesDxlImporterProdImpl extends NotesBaseProdImpl implements
		NotesDxlImporter {

	private final DxlImporter dxlImporter;

	public NotesDxlImporterProdImpl(DxlImporter dxlImporter) {
		this.dxlImporter = dxlImporter;
	}

	@Override
	public void importDxl(String arg0, NotesDatabase arg1)
			throws NotesApiException {
		try {
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg1;
			dxlImporter.importDxl(arg0, db.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void importDxl(NotesStream arg0, NotesDatabase arg1)
			throws NotesApiException {
		try {
			NotesStreamProdImpl stream = (NotesStreamProdImpl) arg0;
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg1;
			dxlImporter.importDxl(stream.get(), db.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void importDxl(NotesRichTextItem arg0, NotesDatabase arg1)
			throws NotesApiException {
		try {
			NotesRichTextItemProdImpl richTextItem = (NotesRichTextItemProdImpl) arg0;
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg1;
			dxlImporter.importDxl(richTextItem.get(), db.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getFirstImportedNoteID() throws NotesApiException {
		try {
			return dxlImporter.getFirstImportedNoteID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNextImportedNoteID(String arg0) throws NotesApiException {
		try {
			return dxlImporter.getNextImportedNoteID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getLog() throws NotesApiException {
		try {
			return dxlImporter.getLog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLogComment(String arg0) throws NotesApiException {
		try {
			dxlImporter.setLogComment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getLogComment() throws NotesApiException {
		try {
			return dxlImporter.getLogComment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setExitOnFirstFatalError(boolean arg0) throws NotesApiException {
		try {
			dxlImporter.setExitOnFirstFatalError(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getExitOnFirstFatalError() throws NotesApiException {
		try {
			return dxlImporter.getExitOnFirstFatalError();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getImportedNoteCount() throws NotesApiException {
		try {
			return dxlImporter.getImportedNoteCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setInputValidationOption(int arg0) throws NotesApiException {
		try {
			dxlImporter.setInputValidationOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getInputValidationOption() throws NotesApiException {
		try {
			return dxlImporter.getInputValidationOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAclImportOption(int arg0) throws NotesApiException {
		try {
			dxlImporter.setAclImportOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getAclImportOption() throws NotesApiException {
		try {
			return dxlImporter.getAclImportOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDesignImportOption(int arg0) throws NotesApiException {
		try {
			dxlImporter.setDesignImportOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getDesignImportOption() throws NotesApiException {
		try {
			return dxlImporter.getDesignImportOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDocumentImportOption(int arg0) throws NotesApiException {
		try {
			dxlImporter.setDesignImportOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getDocumentImportOption() throws NotesApiException {
		try {
			return dxlImporter.getDesignImportOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUnknownTokenLogOption(int arg0) throws NotesApiException {
		try {
			dxlImporter.setUnknownTokenLogOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getUnknownTokenLogOption() throws NotesApiException {
		try {
			return dxlImporter.getUnknownTokenLogOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setReplaceDbProperties(boolean arg0) throws NotesApiException {
		try {
			dxlImporter.setReplaceDbProperties(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getReplaceDbProperties() throws NotesApiException {
		try {
			return dxlImporter.getReplaceDbProperties();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCreateFTIndex(boolean arg0) throws NotesApiException {
		try {
			dxlImporter.setCreateFTIndex(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getCreateFTIndex() throws NotesApiException {
		try {
			return dxlImporter.getCreateFTIndex();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setReplicaRequiredForReplaceOrUpdate(boolean arg0)
			throws NotesApiException {
		try {
			dxlImporter.setReplicaRequiredForReplaceOrUpdate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getReplicaRequiredForReplaceOrUpdate()
			throws NotesApiException {
		try {
			return dxlImporter.getReplicaRequiredForReplaceOrUpdate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCompileLotusScript(boolean arg0) throws NotesApiException {
		try {
			dxlImporter.setCompileLotusScript(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getCompileLotusScript() throws NotesApiException {
		try {
			return dxlImporter.getCompileLotusScript();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}