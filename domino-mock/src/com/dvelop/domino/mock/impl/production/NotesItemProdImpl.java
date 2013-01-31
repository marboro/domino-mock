package com.dvelop.domino.mock.impl.production;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.Vector;

import lotus.domino.DateTime;
import lotus.domino.Item;
import lotus.domino.NotesException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesItem;
import com.dvelop.domino.mock.interfaces.NotesMIMEEntity;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesItemProdImpl extends NotesBaseProdImpl implements NotesItem {

	private final Item item;

	public NotesItemProdImpl(Item item) {
		this.item = item;
	}

	public NotesItemProdImpl() {
		this.item = null;
	}

	public Item get() {
		return item;
	}

	@Override
	public String abstractText(int arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		try {
			return item.abstractText(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendToTextList(Vector arg0) throws NotesApiException {
		try {
			item.appendToTextList(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendToTextList(String arg0) throws NotesApiException {
		try {
			item.appendToTextList(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean containsValue(Object arg0) throws NotesApiException {
		try {
			if (arg0 instanceof DateTime) {
				return item.containsValue(((NotesDateTimeProdImpl) arg0).get());
			}
			return item.containsValue(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(item.copyItemToDocument(
					((NotesDocumentProdImpl) arg0).get(), arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem copyItemToDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(
					item.copyItemToDocument(((NotesDocumentProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getMIMEEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(item.getMIMEEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getDateTimeValue() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(item.getDateTimeValue());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDateTimeValue(NotesDateTime arg0) throws NotesApiException {
		try {
			item.setDateTimeValue(((NotesDateTimeProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(item.getLastModified());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return item.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getParent() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(item.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getText() throws NotesApiException {
		try {
			return item.getText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getText(int arg0) throws NotesApiException {
		try {
			return item.getText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return item.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getValues() throws NotesApiException {
		try {
			Vector values = item.getValues();
			Vector<NotesDateTime> vector = new Vector<NotesDateTime>();
			if (values.size() > 0) {
				if (values.get(0) instanceof DateTime) {
					Iterator iterator = values.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return vector;
				}
			}
			return values;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValues(Vector arg0) throws NotesApiException {
		try {
			item.setValues(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getValueString() throws NotesApiException {
		try {
			return item.getValueString();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValueString(String arg0) throws NotesApiException {
		try {
			item.setValueString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getValueDouble() throws NotesApiException {
		try {
			return item.getValueDouble();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValueDouble(double arg0) throws NotesApiException {
		try {
			item.setValueDouble(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getValueInteger() throws NotesApiException {
		try {
			return item.getValueInteger();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValueInteger(int arg0) throws NotesApiException {
		try {
			item.setValueInteger(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getValueLength() throws NotesApiException {
		try {
			return item.getValueLength();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValueCustomData(String arg0, Object arg1)
			throws IOException, NotesApiException {
		try {
			item.setValueCustomData(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setValueCustomData(Object arg0) throws IOException,
			NotesApiException {
		try {
			item.setValueCustomData(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setValueCustomDataBytes(String arg0, byte[] arg1)
			throws IOException, NotesApiException {
		try {
			item.setValueCustomDataBytes(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getValueCustomData(String arg0) throws IOException,
			ClassNotFoundException, NotesApiException {
		try {
			return item.getValueCustomData(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getValueCustomData() throws IOException,
			ClassNotFoundException, NotesApiException {
		try {
			return item.getValueCustomData();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public byte[] getValueCustomDataBytes(String arg0) throws IOException,
			NotesApiException {
		try {
			return item.getValueCustomDataBytes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getValueDateTimeArray() throws NotesApiException {
		try {
			Vector timeArray = item.getValueDateTimeArray();
			Vector<NotesDateTime> vector = new Vector<NotesDateTime>();
			if (timeArray.size() > 0) {
				if (timeArray.get(0) instanceof DateTime) {
					Iterator iterator = timeArray.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return vector;
				}
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAuthors() throws NotesApiException {
		try {
			return item.isAuthors();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAuthors(boolean arg0) throws NotesApiException {
		try {
			item.setAuthors(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		try {
			return item.isEncrypted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEncrypted(boolean arg0) throws NotesApiException {
		try {
			item.setEncrypted(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNames() throws NotesApiException {
		try {
			return item.isNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNames(boolean arg0) throws NotesApiException {
		try {
			item.setNames(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProtected() throws NotesApiException {
		try {
			return item.isProtected();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProtected(boolean arg0) throws NotesApiException {
		try {
			item.setProtected(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isReaders() throws NotesApiException {
		try {
			return item.isReaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setReaders(boolean arg0) throws NotesApiException {
		try {
			item.setReaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSaveToDisk() throws NotesApiException {
		try {
			return item.isSaveToDisk();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSaveToDisk(boolean arg0) throws NotesApiException {
		try {
			item.setSaveToDisk(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSigned() throws NotesApiException {
		try {
			return item.isSigned();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSigned(boolean arg0) throws NotesApiException {
		try {
			item.setSigned(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSummary() throws NotesApiException {
		try {
			return item.isSummary();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSummary(boolean arg0) throws NotesApiException {
		try {
			item.setSummary(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			item.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Reader getReader() throws NotesApiException {
		try {
			return item.getReader();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputSource getInputSource() throws NotesApiException {
		try {
			return item.getInputSource();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputStream getInputStream() throws NotesApiException {
		try {
			return item.getInputStream();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Document parseXML(boolean arg0) throws IOException,
			NotesApiException {
		try {
			return item.parseXML(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException {
		try {
			item.transformXML(arg0,
					((NotesXSLTResultTargetProdImpl) arg1).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}