package org.openntf.domino.mock.impl.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesItem;
import org.openntf.domino.mock.interfaces.NotesMIMEEntity;
import org.openntf.domino.mock.interfaces.NotesXSLTResultTarget;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class NotesItemMockImpl extends NotesBaseMockImpl implements NotesItem {

	private String name;
	private int type;
	private Vector values;
	private boolean isAuthors;
	private boolean isEncrypted;
	private boolean isNames;
	private boolean isProtected;
	private boolean isReaders;
	private boolean isSaveToDisk;
	private boolean isSigned;
	private boolean isSummary;
	private String valueString;

	public NotesItemMockImpl(String name) {
		this.name = name;
	}

	public NotesItemMockImpl(NotesItem item) throws NotesApiException {
		this.name = item.getName();
	}

	@Override
	public NotesMIMEEntity getMIMEEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getDateTimeValue() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() throws NotesApiException {
		return name;
	}

	@Override
	public NotesDocument getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() throws NotesApiException {
		return type;
	}

	@Override
	public Vector getValues() throws NotesApiException {
		return values;
	}

	@Override
	public String getValueString() throws NotesApiException {
		return valueString;
	}

	@Override
	public double getValueDouble() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValueInteger() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getValueLength() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueCustomData() throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getValueDateTimeArray() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthors() throws NotesApiException {
		return isAuthors;
	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		return isEncrypted;
	}

	@Override
	public boolean isNames() throws NotesApiException {
		return isNames;
	}

	@Override
	public boolean isProtected() throws NotesApiException {
		return isProtected;
	}

	@Override
	public boolean isReaders() throws NotesApiException {
		return isReaders;
	}

	@Override
	public boolean isSaveToDisk() throws NotesApiException {
		return isSaveToDisk;
	}

	@Override
	public boolean isSigned() throws NotesApiException {
		return isSigned;
	}

	@Override
	public boolean isSummary() throws NotesApiException {
		return isSummary;
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
	public String toString() {
		// TODO getName
		return super.toString();
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String abstractText(int maxLen, boolean dropVowels, boolean userDict) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendToTextList(Vector values) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendToTextList(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsValue(Object value) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument doc, String newName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDateTimeValue(NotesDateTime dt) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getText(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValues(Vector values) throws NotesApiException {
		this.values = values;
	}

	@Override
	public void setValueString(String value) throws NotesApiException {
		this.valueString = value;

	}

	@Override
	public void setValueDouble(double value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueInteger(int value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueCustomData(String dataTypeName, Object userObj) throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueCustomData(Object userObj) throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueCustomDataBytes(String dataTypeName, byte[] byteArray) throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValueCustomData(String dataTypeName) throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getValueCustomDataBytes(String dataTypeName) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthors(boolean flag) throws NotesApiException {
		this.isAuthors = flag;
	}

	@Override
	public void setEncrypted(boolean flag) throws NotesApiException {
		this.isEncrypted = flag;

	}

	@Override
	public void setNames(boolean flag) throws NotesApiException {
		this.isNames = flag;

	}

	@Override
	public void setProtected(boolean flag) throws NotesApiException {
		this.isProtected = flag;

	}

	@Override
	public void setReaders(boolean flag) throws NotesApiException {
		this.isReaders = flag;

	}

	@Override
	public void setSaveToDisk(boolean flag) throws NotesApiException {
		this.isSaveToDisk = flag;

	}

	@Override
	public void setSigned(boolean flag) throws NotesApiException {
		this.isSigned = flag;

	}

	@Override
	public void setSummary(boolean flag) throws NotesApiException {
		this.isSummary = flag;

	}

	@Override
	public Document parseXML(boolean validate) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transformXML(Object style, NotesXSLTResultTarget result) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}