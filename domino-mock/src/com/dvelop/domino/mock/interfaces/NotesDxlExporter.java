package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDxlExporter extends NotesBase {
	public static final int DXLRICHTEXTOPTION_DXL = 0;
	public static final int DXLRICHTEXTOPTION_RAW = 1;
	public static final int DXLMIMEOPTION_DXL = 0;
	public static final int DXLMIMEOPTION_RAW = 1;

	public abstract String exportDxl(NotesDatabase database)
			throws NotesApiException;

	public abstract String exportDxl(NotesNoteCollection noteCollection)
			throws NotesApiException;

	public abstract String exportDxl(NotesDocument document)
			throws NotesApiException;

	public abstract String exportDxl(NotesDocumentCollection documentCollection)
			throws NotesApiException;

	public abstract String getLog() throws NotesApiException;

	public abstract void setLogComment(String comment) throws NotesApiException;

	public abstract String getLogComment() throws NotesApiException;

	public abstract void setExitOnFirstFatalError(boolean flag)
			throws NotesApiException;

	public abstract boolean getExitOnFirstFatalError() throws NotesApiException;

	public abstract void setForceNoteFormat(boolean flag)
			throws NotesApiException;

	public abstract boolean getForceNoteFormat() throws NotesApiException;

	public abstract void setOutputDOCTYPE(boolean system)
			throws NotesApiException;

	public abstract boolean getOutputDOCTYPE() throws NotesApiException;

	public abstract void setConvertNotesBitmapsToGIF(boolean flag)
			throws NotesApiException;

	public abstract boolean getConvertNotesBitmapsToGIF()
			throws NotesApiException;

	public abstract void setDoctypeSYSTEM(String system) throws NotesApiException;

	public abstract String getDoctypeSYSTEM() throws NotesApiException;

	public abstract void setOmitRichtextAttachments(boolean flag)
			throws NotesApiException;

	public abstract boolean getOmitRichtextAttachments()
			throws NotesApiException;

	public abstract void setOmitOLEObjects(boolean flag)
			throws NotesApiException;

	public abstract boolean getOmitOLEObjects() throws NotesApiException;

	public abstract void setOmitMiscFileObjects(boolean flag)
			throws NotesApiException;

	public abstract boolean getOmitMiscFileObjects() throws NotesApiException;

	public abstract void setOmitRichtextPictures(boolean flag)
			throws NotesApiException;

	public abstract boolean getOmitRichtextPictures() throws NotesApiException;

	public abstract void setUncompressAttachments(boolean flag)
			throws NotesApiException;

	public abstract boolean getUncompressAttachments() throws NotesApiException;

	public abstract void setAttachmentOmittedText(String replacementText)
			throws NotesApiException;

	public abstract String getAttachmentOmittedText() throws NotesApiException;

	public abstract void setOLEObjectOmittedText(String comment)
			throws NotesApiException;

	public abstract String getOLEObjectOmittedText() throws NotesApiException;

	public abstract void setPictureOmittedText(String comment)
			throws NotesApiException;

	public abstract String getPictureOmittedText() throws NotesApiException;

	public abstract void setOmitItemNames(Vector names) throws NotesApiException;

	public abstract Vector getOmitItemNames() throws NotesApiException;

	public abstract void setRestrictToItemNames(Vector names)
			throws NotesApiException;

	public abstract Vector getRestrictToItemNames() throws NotesApiException;

	public abstract void setRichTextOption(int option) throws NotesApiException;

	public abstract int getRichTextOption() throws NotesApiException;

	public abstract void setMIMEOption(int option) throws NotesApiException;

	public abstract int getMIMEOption() throws NotesApiException;
}
