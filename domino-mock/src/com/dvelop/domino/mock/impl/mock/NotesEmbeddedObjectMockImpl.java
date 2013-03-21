package com.dvelop.domino.mock.impl.mock;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesEmbeddedObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesEmbeddedObjectMockImpl extends NotesBaseMockImpl implements
		NotesEmbeddedObject {

	private String className;
	private int fileSize;
	private String name;
	private int objectHandle;
	private NotesRichTextItem parent;
	private String source;
	private int type;
	private Vector verbs;
	private boolean show = false;
	private Map<String, Boolean> doneVerbs;

	public NotesEmbeddedObjectMockImpl() {
		doneVerbs = new HashMap<String, Boolean>();
	}

	public NotesEmbeddedObjectMockImpl(NotesRichTextItem parent) {
		this();
		this.parent = parent;

	}

	public void setParent(NotesRichTextItem parent) {
		this.parent = parent;
	}

	@Override
	public int activate(boolean show) throws NotesApiException {
		if (type == NotesEmbeddedObject.EMBED_OBJECT) {
			this.show = show;
			return objectHandle;
		}
		return 0;
	}

	@Override
	public void doVerb(String verb) throws NotesApiException {
		if (type == NotesEmbeddedObject.EMBED_OBJECT) {
			if (verbs.contains(verb)) {
				doneVerbs.put(verb, true);
			}
		}

	}

	@Override
	public void extractFile(String path) throws NotesApiException {
		if (type == NotesEmbeddedObject.EMBED_ATTACHMENT) {
			return;
		}
		throw new NotesApiException(new IOException("Not an attachment"));
	}

	@Override
	public String getClassName() throws NotesApiException {
		return className;
	}

	@Override
	public int getFileSize() throws NotesApiException {
		return fileSize;
	}

	@Override
	public String getName() throws NotesApiException {
		return name;
	}

	@Override
	public int getObject() throws NotesApiException {
		return objectHandle;
	}

	@Override
	public NotesRichTextItem getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public String getSource() throws NotesApiException {
		return source;
	}

	@Override
	public int getType() throws NotesApiException {
		return type;
	}

	@Override
	public Vector getVerbs() throws NotesApiException {
		return verbs;
	}

	@Override
	public void remove() throws NotesApiException {
		((NotesRichTextItemMockImpl) parent).removeEmbeddedObject(this);
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
		return name;
	}
}