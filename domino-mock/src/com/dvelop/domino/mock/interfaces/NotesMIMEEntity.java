package com.dvelop.domino.mock.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesMIMEEntity extends NotesBase {
	public static final int SEARCH_DEPTH = 1723;
	public static final int SEARCH_BREADTH = 1724;
	public static final int ENC_NONE = 1725;
	public static final int ENC_QUOTED_PRINTABLE = 1726;
	public static final int ENC_BASE64 = 1727;
	public static final int ENC_IDENTITY_7BIT = 1728;
	public static final int ENC_IDENTITY_8BIT = 1729;
	public static final int ENC_IDENTITY_BINARY = 1730;
	public static final int ENC_EXTENSION = 1731;

	public abstract NotesMIMEEntity getNextEntity() throws NotesApiException;

	public abstract NotesMIMEEntity getNextEntity(int search)
			throws NotesApiException;

	public abstract NotesMIMEEntity getNextSibling() throws NotesApiException;

	public abstract NotesMIMEEntity getFirstChildEntity()
			throws NotesApiException;

	public abstract NotesMIMEEntity getParentEntity() throws NotesApiException;

	public abstract NotesMIMEEntity getPrevEntity() throws NotesApiException;

	public abstract NotesMIMEEntity getPrevEntity(int search)
			throws NotesApiException;

	public abstract NotesMIMEEntity getPrevSibling() throws NotesApiException;

	public abstract NotesMIMEEntity createChildEntity()
			throws NotesApiException;

	public abstract NotesMIMEEntity createChildEntity(NotesMIMEEntity nextSibling)
			throws NotesApiException;

	public abstract NotesMIMEEntity createParentEntity()
			throws NotesApiException;

	public abstract String getBoundaryStart() throws NotesApiException;

	public abstract String getBoundaryEnd() throws NotesApiException;

	public abstract String getCharset() throws NotesApiException;

	public abstract String getContentType() throws NotesApiException;

	public abstract String getContentSubType() throws NotesApiException;

	public abstract String getContentAsText() throws NotesApiException;

	public abstract String getHeaders() throws NotesApiException;

	public abstract String getPreamble() throws NotesApiException;

	public abstract int getEncoding() throws NotesApiException;

	public abstract Vector getHeaderObjects() throws NotesApiException;

	public abstract NotesMIMEHeader getNthHeader(String headerName)
			throws NotesApiException;

	public abstract NotesMIMEHeader getNthHeader(String headerName, int instance)
			throws NotesApiException;

	public abstract NotesMIMEHeader createHeader(String headerName)
			throws NotesApiException;

	public abstract Reader getReader() throws NotesApiException;

	public abstract InputSource getInputSource() throws NotesApiException;

	public abstract InputStream getInputStream() throws NotesApiException;

	public abstract Document parseXML(boolean validate) throws IOException,
			NotesApiException;

	public abstract void transformXML(Object style, NotesXSLTResultTarget result)
			throws NotesApiException;

	public abstract void decodeContent() throws NotesApiException;

	public abstract void encodeContent(int encoding) throws NotesApiException;

	public abstract void getEntityAsText(NotesStream stream)
			throws NotesApiException;

	public abstract void getEntityAsText(NotesStream stream, Vector headerFilters)
			throws NotesApiException;

	public abstract void getEntityAsText(NotesStream stream, Vector headerFilters,
			boolean inclusive) throws NotesApiException;

	public abstract void getContentAsBytes(NotesStream stream)
			throws NotesApiException;

	public abstract void getContentAsBytes(NotesStream stream, boolean decoded)
			throws NotesApiException;

	public abstract void getContentAsText(NotesStream stream)
			throws NotesApiException;

	public abstract void getContentAsText(NotesStream stream, boolean decoded)
			throws NotesApiException;

	public abstract String getSomeHeaders() throws NotesApiException;

	public abstract String getSomeHeaders(Vector headerFilters) throws NotesApiException;

	public abstract String getSomeHeaders(Vector headerFilters, boolean inclusive)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract void setContentFromBytes(NotesStream stream, String contentType,
			int encoding) throws NotesApiException;

	public abstract void setContentFromText(NotesStream stream, String contentType,
			int encoding) throws NotesApiException;

	public abstract void setPreamble(String preamble) throws NotesApiException;
}
