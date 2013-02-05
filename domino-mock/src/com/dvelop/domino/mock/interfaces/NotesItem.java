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

	public abstract String abstractText(int maxLen, boolean dropVowels, boolean userDict)
			throws NotesApiException;

	public abstract void appendToTextList(Vector values) throws NotesApiException;

	public abstract void appendToTextList(String value) throws NotesApiException;

	public abstract boolean containsValue(Object value) throws NotesApiException;

	public abstract NotesItem copyItemToDocument(NotesDocument doc, String newName)
			throws NotesApiException;

	public abstract NotesItem copyItemToDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity() throws NotesApiException;

	public abstract NotesDateTime getDateTimeValue() throws NotesApiException;

	public abstract void setDateTimeValue(NotesDateTime dt)
			throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract NotesDocument getParent() throws NotesApiException;

	public abstract String getText() throws NotesApiException;

	public abstract String getText(int arg0) throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract Vector getValues() throws NotesApiException;

	public abstract void setValues(Vector values) throws NotesApiException;

	public abstract String getValueString() throws NotesApiException;

	public abstract void setValueString(String value) throws NotesApiException;

	public abstract double getValueDouble() throws NotesApiException;

	public abstract void setValueDouble(double value) throws NotesApiException;

	public abstract int getValueInteger() throws NotesApiException;

	public abstract void setValueInteger(int value) throws NotesApiException;

	public abstract int getValueLength() throws NotesApiException;

	public abstract void setValueCustomData(String dataTypeName, Object userObj)
			throws IOException, NotesApiException;

	public abstract void setValueCustomData(Object userObj) throws IOException,
			NotesApiException;

	public abstract void setValueCustomDataBytes(String dataTypeName, byte[] byteArray)
			throws IOException, NotesApiException;

	public abstract Object getValueCustomData(String dataTypeName) throws IOException,
			ClassNotFoundException, NotesApiException;

	public abstract Object getValueCustomData() throws IOException,
			ClassNotFoundException, NotesApiException;

	public abstract byte[] getValueCustomDataBytes(String dataTypeName)
			throws IOException, NotesApiException;

	public abstract Vector getValueDateTimeArray() throws NotesApiException;

	public abstract boolean isAuthors() throws NotesApiException;

	public abstract void setAuthors(boolean flag) throws NotesApiException;

	public abstract boolean isEncrypted() throws NotesApiException;

	public abstract void setEncrypted(boolean flag) throws NotesApiException;

	public abstract boolean isNames() throws NotesApiException;

	public abstract void setNames(boolean flag) throws NotesApiException;

	public abstract boolean isProtected() throws NotesApiException;

	public abstract void setProtected(boolean flag) throws NotesApiException;

	public abstract boolean isReaders() throws NotesApiException;

	public abstract void setReaders(boolean flag) throws NotesApiException;

	public abstract boolean isSaveToDisk() throws NotesApiException;

	public abstract void setSaveToDisk(boolean flag) throws NotesApiException;

	public abstract boolean isSigned() throws NotesApiException;

	public abstract void setSigned(boolean flag) throws NotesApiException;

	public abstract boolean isSummary() throws NotesApiException;

	public abstract void setSummary(boolean flag) throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract Reader getReader() throws NotesApiException;

	public abstract InputSource getInputSource() throws NotesApiException;

	public abstract InputStream getInputStream() throws NotesApiException;

	public abstract Document parseXML(boolean validate) throws IOException,
			NotesApiException;

	public abstract void transformXML(Object style, NotesXSLTResultTarget result)
			throws NotesApiException;
}
