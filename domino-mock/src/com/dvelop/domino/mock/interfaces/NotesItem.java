package com.dvelop.domino.mock.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesItem extends NotesBase {
	public static final int ERRORITEM = 256;
	public static final int UNAVAILABLE = 512;
	public static final int TEXT = 1280;
	public static final int NUMBERS = 768;
	public static final int DATETIMES = 1024;
	public static final int NAMES = 1074;
	public static final int READERS = 1075;
	public static final int AUTHORS = 1076;
	public static final int RICHTEXT = 1;
	public static final int USERID = 1792;
	public static final int FORMULA = 1536;
	public static final int COLLATION = 2;
	public static final int NOTEREFS = 4;
	public static final int NOTELINKS = 7;
	public static final int ATTACHMENT = 1084;
	public static final int OTHEROBJECT = 1085;
	public static final int UNKNOWN = 0;
	public static final int ICON = 6;
	public static final int SIGNATURE = 8;
	public static final int USERDATA = 14;
	public static final int EMBEDDEDOBJECT = 1090;
	public static final int QUERYCD = 15;
	public static final int ACTIONCD = 16;
	public static final int ASSISTANTINFO = 17;
	public static final int VIEWMAPDATA = 18;
	public static final int VIEWMAPLAYOUT = 19;
	public static final int LSOBJECT = 20;
	public static final int HTML = 21;
	public static final int MIME_PART = 25;
	public static final int RFC822TEXT = 1282;

	public abstract String abstractText(int arg0, boolean arg1, boolean arg2)
			throws NotesApiException;

	public abstract void appendToTextList(Vector arg0) throws NotesApiException;

	public abstract void appendToTextList(String arg0) throws NotesApiException;

	public abstract boolean containsValue(Object arg0) throws NotesApiException;

	public abstract NotesItem copyItemToDocument(NotesDocument arg0, String arg1)
			throws NotesApiException;

	public abstract NotesItem copyItemToDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity() throws NotesApiException;

	public abstract NotesDateTime getDateTimeValue() throws NotesApiException;

	public abstract void setDateTimeValue(NotesDateTime arg0)
			throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract NotesDocument getParent() throws NotesApiException;

	public abstract String getText() throws NotesApiException;

	public abstract String getText(int arg0) throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract Vector getValues() throws NotesApiException;

	public abstract void setValues(Vector arg0) throws NotesApiException;

	public abstract String getValueString() throws NotesApiException;

	public abstract void setValueString(String arg0) throws NotesApiException;

	public abstract double getValueDouble() throws NotesApiException;

	public abstract void setValueDouble(double arg0) throws NotesApiException;

	public abstract int getValueInteger() throws NotesApiException;

	public abstract void setValueInteger(int arg0) throws NotesApiException;

	public abstract int getValueLength() throws NotesApiException;

	public abstract void setValueCustomData(String arg0, Object arg1)
			throws IOException, NotesApiException;

	public abstract void setValueCustomData(Object arg0) throws IOException,
			NotesApiException;

	public abstract void setValueCustomDataBytes(String arg0, byte[] arg1)
			throws IOException, NotesApiException;

	public abstract Object getValueCustomData(String arg0) throws IOException,
			ClassNotFoundException, NotesApiException;

	public abstract Object getValueCustomData() throws IOException,
			ClassNotFoundException, NotesApiException;

	public abstract byte[] getValueCustomDataBytes(String arg0)
			throws IOException, NotesApiException;

	public abstract Vector getValueDateTimeArray() throws NotesApiException;

	public abstract boolean isAuthors() throws NotesApiException;

	public abstract void setAuthors(boolean arg0) throws NotesApiException;

	public abstract boolean isEncrypted() throws NotesApiException;

	public abstract void setEncrypted(boolean arg0) throws NotesApiException;

	public abstract boolean isNames() throws NotesApiException;

	public abstract void setNames(boolean arg0) throws NotesApiException;

	public abstract boolean isProtected() throws NotesApiException;

	public abstract void setProtected(boolean arg0) throws NotesApiException;

	public abstract boolean isReaders() throws NotesApiException;

	public abstract void setReaders(boolean arg0) throws NotesApiException;

	public abstract boolean isSaveToDisk() throws NotesApiException;

	public abstract void setSaveToDisk(boolean arg0) throws NotesApiException;

	public abstract boolean isSigned() throws NotesApiException;

	public abstract void setSigned(boolean arg0) throws NotesApiException;

	public abstract boolean isSummary() throws NotesApiException;

	public abstract void setSummary(boolean arg0) throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract Reader getReader() throws NotesApiException;

	public abstract InputSource getInputSource() throws NotesApiException;

	public abstract InputStream getInputStream() throws NotesApiException;

	public abstract Document parseXML(boolean arg0) throws IOException,
			NotesApiException;

	public abstract void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException;
}
