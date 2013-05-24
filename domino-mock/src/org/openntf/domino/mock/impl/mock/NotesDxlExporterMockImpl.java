package org.openntf.domino.mock.impl.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesDxlExporter;
import org.openntf.domino.mock.interfaces.NotesNoteCollection;

public class NotesDxlExporterMockImpl extends NotesBaseMockImpl implements NotesDxlExporter {

	private String replacementText;
	private boolean isOmitRichtextAttachments;

	@Override
	public String exportDxl(NotesDatabase database) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NotesNoteCollection noteCollection) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportDxl(NotesDocument document) throws NotesApiException {
		// TODO dxl dateien importieren
		Class<? extends NotesDxlExporterMockImpl> clazz = getClass();
		ClassLoader classLoader = clazz.getClassLoader();
		InputStream stream = classLoader.getResourceAsStream(document.getUniversalID() + ".dxl");
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		String line = "";

		StringBuilder sb = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String exportDxl(NotesDocumentCollection documentCollection) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLog() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogComment(String comment) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLogComment() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExitOnFirstFatalError(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getExitOnFirstFatalError() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setForceNoteFormat(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getForceNoteFormat() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOutputDOCTYPE(boolean system) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOutputDOCTYPE() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setConvertNotesBitmapsToGIF(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getConvertNotesBitmapsToGIF() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDoctypeSYSTEM(String system) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDoctypeSYSTEM() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOmitRichtextAttachments(boolean flag) throws NotesApiException {
		this.isOmitRichtextAttachments = flag;

	}

	@Override
	public boolean getOmitRichtextAttachments() throws NotesApiException {
		return isOmitRichtextAttachments;
	}

	@Override
	public void setOmitOLEObjects(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitOLEObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOmitMiscFileObjects(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitMiscFileObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOmitRichtextPictures(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOmitRichtextPictures() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUncompressAttachments(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getUncompressAttachments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttachmentOmittedText(String replacementText) throws NotesApiException {
		this.replacementText = replacementText;

	}

	@Override
	public String getAttachmentOmittedText() throws NotesApiException {
		return replacementText;
	}

	@Override
	public void setOLEObjectOmittedText(String comment) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOLEObjectOmittedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPictureOmittedText(String comment) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPictureOmittedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOmitItemNames(Vector names) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getOmitItemNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRestrictToItemNames(Vector names) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getRestrictToItemNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRichTextOption(int option) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRichTextOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMIMEOption(int option) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMIMEOption() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

}