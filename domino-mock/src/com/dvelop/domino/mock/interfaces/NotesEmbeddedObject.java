package com.dvelop.domino.mock.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesEmbeddedObject extends NotesBase {
	public static final int EMBED_OBJECTLINK = 1452;
	public static final int EMBED_OBJECT = 1453;
	public static final int EMBED_ATTACHMENT = 1454;

	public abstract int activate(boolean arg0) throws NotesApiException;

	public abstract void doVerb(String arg0) throws NotesApiException;

	public abstract void extractFile(String arg0) throws NotesApiException;

	public abstract String getClassName() throws NotesApiException;

	public abstract int getFileSize() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract int getObject() throws NotesApiException;

	public abstract NotesRichTextItem getParent() throws NotesApiException;

	public abstract String getSource() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract Vector getVerbs() throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract Reader getReader() throws NotesApiException;

	public abstract org.xml.sax.InputSource getInputSource()
			throws NotesApiException;

	public abstract InputStream getInputStream() throws NotesApiException;

	public abstract org.w3c.dom.Document parseXML(boolean arg0)
			throws IOException, NotesApiException;

	public abstract void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException;
}
