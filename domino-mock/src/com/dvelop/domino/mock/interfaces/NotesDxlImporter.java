package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDxlImporter extends NotesBase {
	public static final int DXLIMPORTOPTION_IGNORE = 1;
	public static final int DXLIMPORTOPTION_CREATE = 2;
	public static final int DXLIMPORTOPTION_REPLACE_ELSE_IGNORE = 5;
	public static final int DXLIMPORTOPTION_REPLACE_ELSE_CREATE = 6;
	public static final int DXLIMPORTOPTION_UPDATE_ELSE_IGNORE = 9;
	public static final int DXLIMPORTOPTION_UPDATE_ELSE_CREATE = 10;
	public static final int DXLLOGOPTION_IGNORE = 1;
	public static final int DXLLOGOPTION_WARNING = 2;
	public static final int DXLLOGOPTION_ERROR = 3;
	public static final int DXLLOGOPTION_FATALERROR = 4;
	public static final int DXLVALIDATIONOPTION_VALIDATE_NEVER = 0;
	public static final int DXLVALIDATIONOPTION_VALIDATE_ALWAYS = 1;
	public static final int DXLVALIDATIONOPTION_VALIDATE_AUTO = 2;

	public abstract void importDxl(String input, NotesDatabase target)
			throws NotesApiException;

	public abstract void importDxl(NotesStream input, NotesDatabase target)
			throws NotesApiException;

	public abstract void importDxl(NotesRichTextItem input, NotesDatabase target)
			throws NotesApiException;

	public abstract String getFirstImportedNoteID() throws NotesApiException;

	public abstract String getNextImportedNoteID(String noteID)
			throws NotesApiException;

	public abstract String getLog() throws NotesApiException;

	public abstract void setLogComment(String comment) throws NotesApiException;

	public abstract String getLogComment() throws NotesApiException;

	public abstract void setExitOnFirstFatalError(boolean flag)
			throws NotesApiException;

	public abstract boolean getExitOnFirstFatalError() throws NotesApiException;

	public abstract int getImportedNoteCount() throws NotesApiException;

	public abstract void setInputValidationOption(int option)
			throws NotesApiException;

	public abstract int getInputValidationOption() throws NotesApiException;

	public abstract void setAclImportOption(int option) throws NotesApiException;

	public abstract int getAclImportOption() throws NotesApiException;

	public abstract void setDesignImportOption(int option)
			throws NotesApiException;

	public abstract int getDesignImportOption() throws NotesApiException;

	public abstract void setDocumentImportOption(int option)
			throws NotesApiException;

	public abstract int getDocumentImportOption() throws NotesApiException;

	public abstract void setUnknownTokenLogOption(int option)
			throws NotesApiException;

	public abstract int getUnknownTokenLogOption() throws NotesApiException;

	public abstract void setReplaceDbProperties(boolean flag)
			throws NotesApiException;

	public abstract boolean getReplaceDbProperties() throws NotesApiException;

	public abstract void setCreateFTIndex(boolean flag)
			throws NotesApiException;

	public abstract boolean getCreateFTIndex() throws NotesApiException;

	public abstract void setReplicaRequiredForReplaceOrUpdate(boolean flag)
			throws NotesApiException;

	public abstract boolean getReplicaRequiredForReplaceOrUpdate()
			throws NotesApiException;

	public abstract void setCompileLotusScript(boolean flag)
			throws NotesApiException;

	public abstract boolean getCompileLotusScript() throws NotesApiException;
}
