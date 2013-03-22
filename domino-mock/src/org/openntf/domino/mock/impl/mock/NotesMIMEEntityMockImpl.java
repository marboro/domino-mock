package org.openntf.domino.mock.impl.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesMIMEEntity;
import org.openntf.domino.mock.interfaces.NotesMIMEHeader;
import org.openntf.domino.mock.interfaces.NotesStream;
import org.openntf.domino.mock.interfaces.NotesXSLTResultTarget;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class NotesMIMEEntityMockImpl extends NotesBaseMockImpl implements
		NotesMIMEEntity {

	@Override
	public NotesMIMEEntity getNextEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getNextEntity(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getNextSibling() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getFirstChildEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getParentEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getPrevEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getPrevEntity(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getPrevSibling() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createChildEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createChildEntity(NotesMIMEEntity arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createParentEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBoundaryStart() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBoundaryEnd() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharset() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentSubType() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentAsText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPreamble() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEncoding() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getHeaderObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEHeader getNthHeader(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEHeader getNthHeader(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEHeader createHeader(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getReader() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputSource getInputSource() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document parseXML(boolean arg0) throws IOException,
			NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void decodeContent() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void encodeContent(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEntityAsText(NotesStream arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEntityAsText(NotesStream arg0, Vector arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEntityAsText(NotesStream arg0, Vector arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsBytes(NotesStream arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsBytes(NotesStream arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsText(NotesStream arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getContentAsText(NotesStream arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSomeHeaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeHeaders(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSomeHeaders(Vector arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentFromBytes(NotesStream arg0, String arg1, int arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentFromText(NotesStream arg0, String arg1, int arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPreamble(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}