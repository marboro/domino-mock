package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesDxlExporter;
import org.openntf.domino.mock.interfaces.NotesNoteCollection;

import lotus.domino.DxlExporter;
import lotus.domino.NotesException;


public class NotesDxlExporterProdImpl extends NotesBaseProdImpl implements
		NotesDxlExporter {

	private final DxlExporter dxlExporter;

	public NotesDxlExporterProdImpl(DxlExporter dxlExporter) {
		this.dxlExporter = dxlExporter;
	}

	@Override
	public String exportDxl(NotesDatabase arg0) throws NotesApiException {
		try {
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg0;
			return dxlExporter.exportDxl(db.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String exportDxl(NotesNoteCollection arg0) throws NotesApiException {
		try {
			NotesNoteCollectionProdImpl col = (NotesNoteCollectionProdImpl) arg0;
			return dxlExporter.exportDxl(col.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String exportDxl(NotesDocument arg0) throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			return dxlExporter.exportDxl(doc.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String exportDxl(NotesDocumentCollection arg0)
			throws NotesApiException {
		try {
			NotesDocumentCollectionProdImpl col = (NotesDocumentCollectionProdImpl) arg0;
			return dxlExporter.exportDxl(col.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getLog() throws NotesApiException {
		try {
			return dxlExporter.getLog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLogComment(String arg0) throws NotesApiException {
		try {
			dxlExporter.setLogComment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getLogComment() throws NotesApiException {
		try {
			return dxlExporter.getLogComment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setExitOnFirstFatalError(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setExitOnFirstFatalError(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getExitOnFirstFatalError() throws NotesApiException {
		try {
			return dxlExporter.getExitOnFirstFatalError();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setForceNoteFormat(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setForceNoteFormat(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getForceNoteFormat() throws NotesApiException {
		try {
			return dxlExporter.getForceNoteFormat();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOutputDOCTYPE(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setOutputDOCTYPE(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getOutputDOCTYPE() throws NotesApiException {
		try {
			return dxlExporter.getOutputDOCTYPE();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setConvertNotesBitmapsToGIF(boolean arg0)
			throws NotesApiException {
		try {
			dxlExporter.setConvertNotesBitmapsToGIF(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getConvertNotesBitmapsToGIF() throws NotesApiException {
		try {
			return dxlExporter.getConvertNotesBitmapsToGIF();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDoctypeSYSTEM(String arg0) throws NotesApiException {
		try {
			dxlExporter.setDoctypeSYSTEM(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getDoctypeSYSTEM() throws NotesApiException {
		try {
			return dxlExporter.getDoctypeSYSTEM();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOmitRichtextAttachments(boolean arg0)
			throws NotesApiException {
		try {
			dxlExporter.setOmitRichtextAttachments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getOmitRichtextAttachments() throws NotesApiException {
		try {
			return dxlExporter.getOmitRichtextAttachments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOmitOLEObjects(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setOmitOLEObjects(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getOmitOLEObjects() throws NotesApiException {
		try {
			return dxlExporter.getOmitOLEObjects();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOmitMiscFileObjects(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setOmitMiscFileObjects(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getOmitMiscFileObjects() throws NotesApiException {
		try {
			return dxlExporter.getOmitMiscFileObjects();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOmitRichtextPictures(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setOmitRichtextPictures(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getOmitRichtextPictures() throws NotesApiException {
		try {
			return dxlExporter.getOmitRichtextPictures();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUncompressAttachments(boolean arg0) throws NotesApiException {
		try {
			dxlExporter.setUncompressAttachments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean getUncompressAttachments() throws NotesApiException {
		try {
			return dxlExporter.getUncompressAttachments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAttachmentOmittedText(String arg0) throws NotesApiException {
		try {
			dxlExporter.setAttachmentOmittedText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getAttachmentOmittedText() throws NotesApiException {
		try {
			return dxlExporter.getAttachmentOmittedText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOLEObjectOmittedText(String arg0) throws NotesApiException {
		try {
			dxlExporter.setOLEObjectOmittedText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getOLEObjectOmittedText() throws NotesApiException {
		try {
			return dxlExporter.getOLEObjectOmittedText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPictureOmittedText(String arg0) throws NotesApiException {
		try {
			dxlExporter.setPictureOmittedText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getPictureOmittedText() throws NotesApiException {
		try {
			return dxlExporter.getPictureOmittedText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOmitItemNames(Vector arg0) throws NotesApiException {
		try {
			dxlExporter.setOmitItemNames(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public Vector getOmitItemNames() throws NotesApiException {
		try {
			return dxlExporter.getOmitItemNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setRestrictToItemNames(Vector arg0) throws NotesApiException {
		try {
			dxlExporter.setRestrictToItemNames(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public Vector getRestrictToItemNames() throws NotesApiException {
		try {
			return dxlExporter.getRestrictToItemNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setRichTextOption(int arg0) throws NotesApiException {
		try {
			dxlExporter.setRichTextOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getRichTextOption() throws NotesApiException {
		try {
			return dxlExporter.getRichTextOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setMIMEOption(int arg0) throws NotesApiException {
		try {
			dxlExporter.setMIMEOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getMIMEOption() throws NotesApiException {
		try {
			return dxlExporter.getMIMEOption();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}