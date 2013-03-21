package com.dvelop.domino.mock.impl.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesItem;
import com.dvelop.domino.mock.interfaces.NotesMIMEEntity;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesItemMockImpl extends NotesBaseMockImpl implements NotesItem {

	private String name;
	private int type;

	public NotesItemMockImpl(String name) {
		this.name = name;
	}

	public NotesItemMockImpl(NotesItem item) throws NotesApiException {
		this.name = item.getName();
	}

	@Override
	public String abstractText(int arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendToTextList(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendToTextList(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsValue(Object arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
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
	public void setDateTimeValue(NotesDateTime arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
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
	public String getText(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() throws NotesApiException {
		return type;
	}

	@Override
	public Vector getValues() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValues(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getValueString() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueString(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getValueDouble() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValueDouble(double arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getValueInteger() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValueInteger(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getValueLength() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValueCustomData(String arg0, Object arg1)
			throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueCustomData(Object arg0) throws IOException,
			NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueCustomDataBytes(String arg0, byte[] arg1)
			throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValueCustomData(String arg0) throws IOException,
			ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValueCustomData() throws IOException,
			ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getValueCustomDataBytes(String arg0) throws IOException,
			NotesApiException {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthors(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEncrypted(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setNames(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isProtected() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProtected(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReaders(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveToDisk() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSaveToDisk(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSigned() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSigned(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSummary() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSummary(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

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
}