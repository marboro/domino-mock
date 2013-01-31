package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDxlExporter extends NotesBase {
	public static final int DXLRICHTEXTOPTION_DXL = 0;
	public static final int DXLRICHTEXTOPTION_RAW = 1;
	public static final int DXLMIMEOPTION_DXL = 0;
	public static final int DXLMIMEOPTION_RAW = 1;

	public abstract String exportDxl(NotesDatabase arg0)
			throws NotesApiException;

	public abstract String exportDxl(NotesNoteCollection arg0)
			throws NotesApiException;

	public abstract String exportDxl(NotesDocument arg0)
			throws NotesApiException;

	public abstract String exportDxl(NotesDocumentCollection arg0)
			throws NotesApiException;

	public abstract String getLog() throws NotesApiException;

	public abstract void setLogComment(String arg0) throws NotesApiException;

	public abstract String getLogComment() throws NotesApiException;

	public abstract void setExitOnFirstFatalError(boolean arg0)
			throws NotesApiException;

	public abstract boolean getExitOnFirstFatalError() throws NotesApiException;

	public abstract void setForceNoteFormat(boolean arg0)
			throws NotesApiException;

	public abstract boolean getForceNoteFormat() throws NotesApiException;

	public abstract void setOutputDOCTYPE(boolean arg0)
			throws NotesApiException;

	public abstract boolean getOutputDOCTYPE() throws NotesApiException;

	public abstract void setConvertNotesBitmapsToGIF(boolean arg0)
			throws NotesApiException;

	public abstract boolean getConvertNotesBitmapsToGIF()
			throws NotesApiException;

	public abstract void setDoctypeSYSTEM(String arg0) throws NotesApiException;

	public abstract String getDoctypeSYSTEM() throws NotesApiException;

	public abstract void setOmitRichtextAttachments(boolean arg0)
			throws NotesApiException;

	public abstract boolean getOmitRichtextAttachments()
			throws NotesApiException;

	public abstract void setOmitOLEObjects(boolean arg0)
			throws NotesApiException;

	public abstract boolean getOmitOLEObjects() throws NotesApiException;

	public abstract void setOmitMiscFileObjects(boolean arg0)
			throws NotesApiException;

	public abstract boolean getOmitMiscFileObjects() throws NotesApiException;

	public abstract void setOmitRichtextPictures(boolean arg0)
			throws NotesApiException;

	public abstract boolean getOmitRichtextPictures() throws NotesApiException;

	public abstract void setUncompressAttachments(boolean arg0)
			throws NotesApiException;

	public abstract boolean getUncompressAttachments() throws NotesApiException;

	public abstract void setAttachmentOmittedText(String arg0)
			throws NotesApiException;

	public abstract String getAttachmentOmittedText() throws NotesApiException;

	public abstract void setOLEObjectOmittedText(String arg0)
			throws NotesApiException;

	public abstract String getOLEObjectOmittedText() throws NotesApiException;

	public abstract void setPictureOmittedText(String arg0)
			throws NotesApiException;

	public abstract String getPictureOmittedText() throws NotesApiException;

	public abstract void setOmitItemNames(Vector arg0) throws NotesApiException;

	public abstract Vector getOmitItemNames() throws NotesApiException;

	public abstract void setRestrictToItemNames(Vector arg0)
			throws NotesApiException;

	public abstract Vector getRestrictToItemNames() throws NotesApiException;

	public abstract void setRichTextOption(int arg0) throws NotesApiException;

	public abstract int getRichTextOption() throws NotesApiException;

	public abstract void setMIMEOption(int arg0) throws NotesApiException;

	public abstract int getMIMEOption() throws NotesApiException;
}
