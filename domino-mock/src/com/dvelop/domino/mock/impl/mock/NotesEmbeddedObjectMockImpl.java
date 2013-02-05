package com.dvelop.domino.mock.impl.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesEmbeddedObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesEmbeddedObjectMockImpl extends NotesBaseMockImpl implements NotesEmbeddedObject {

	@Override
	public int activate(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void doVerb(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void extractFile(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getClassName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFileSize() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getObject() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesRichTextItem getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSource() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getVerbs() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

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
	public Document parseXML(boolean arg0) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transformXML(Object arg0, NotesXSLTResultTarget arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO getName
		return super.toString();
	}
}