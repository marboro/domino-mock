package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesDxlExporter;
import com.dvelop.domino.mock.interfaces.NotesNoteCollection;

public class NotesDxlExporterMockImpl extends NotesBaseMockImpl implements
		NotesDxlExporter {

	@Override
	public String exportDxl(NotesDatabase arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NotesNoteCollection arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NotesDocumentCollection arg0)
			throws NotesApiException {
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
	public void setForceNoteFormat(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getForceNoteFormat() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOutputDOCTYPE(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOutputDOCTYPE() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setConvertNotesBitmapsToGIF(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getConvertNotesBitmapsToGIF() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDoctypeSYSTEM(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDoctypeSYSTEM() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOmitRichtextAttachments(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitRichtextAttachments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOmitOLEObjects(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitOLEObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOmitMiscFileObjects(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitMiscFileObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOmitRichtextPictures(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitRichtextPictures() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUncompressAttachments(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getUncompressAttachments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttachmentOmittedText(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAttachmentOmittedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOLEObjectOmittedText(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOLEObjectOmittedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPictureOmittedText(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPictureOmittedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOmitItemNames(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getOmitItemNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRestrictToItemNames(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getRestrictToItemNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRichTextOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRichTextOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMIMEOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMIMEOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}
}