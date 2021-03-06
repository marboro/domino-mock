package org.openntf.domino.mock.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesEmbeddedObject extends NotesBase {
	public static final int EMBED_OBJECTLINK = 1452;
	public static final int EMBED_OBJECT = 1453;
	public static final int EMBED_ATTACHMENT = 1454;

	public abstract int activate(boolean show) throws NotesApiException;

	public abstract void doVerb(String verb) throws NotesApiException;

	public abstract void extractFile(String path) throws NotesApiException;

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

	public abstract org.w3c.dom.Document parseXML(boolean validate)
			throws IOException, NotesApiException;

	public abstract void transformXML(Object style, NotesXSLTResultTarget result)
			throws NotesApiException;
}
