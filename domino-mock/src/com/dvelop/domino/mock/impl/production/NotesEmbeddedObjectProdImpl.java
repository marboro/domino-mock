package com.dvelop.domino.mock.impl.production;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import lotus.domino.EmbeddedObject;
import lotus.domino.NotesException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesEmbeddedObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesEmbeddedObjectProdImpl extends NotesBaseProdImpl implements
		NotesEmbeddedObject {

	private final EmbeddedObject embeddedObject;

	public NotesEmbeddedObjectProdImpl(EmbeddedObject embeddedObject) {
		this.embeddedObject = embeddedObject;
	}

	public EmbeddedObject get() {
		return embeddedObject;
	}

	@Override
	public int activate(boolean arg0) throws NotesApiException {
		try {
			return embeddedObject.activate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void doVerb(String arg0) throws NotesApiException {
		try {
			embeddedObject.doVerb(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void extractFile(String arg0) throws NotesApiException {
		try {
			embeddedObject.extractFile(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getClassName() throws NotesApiException {
		try {
			return embeddedObject.getClassName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFileSize() throws NotesApiException {
		try {
			return embeddedObject.getFileSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return embeddedObject.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getObject() throws NotesApiException {
		try {
			return embeddedObject.getObject();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextItem getParent() throws NotesApiException {
		try {
			return new NotesRichTextItemProdImpl(embeddedObject.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSource() throws NotesApiException {
		try {
			return embeddedObject.getSource();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return embeddedObject.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getVerbs() throws NotesApiException {
		try {
			return embeddedObject.getVerbs();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			embeddedObject.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Reader getReader() throws NotesApiException {
		try {
			return embeddedObject.getReader();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputSource getInputSource() throws NotesApiException {
		try {
			return embeddedObject.getInputSource();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputStream getInputStream() throws NotesApiException {
		try {
			return embeddedObject.getInputStream();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Document parseXML(boolean arg0) throws IOException,
			NotesApiException {
		try {
			return embeddedObject.parseXML(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException {
		try {
			NotesXSLTResultTargetProdImpl xslResult = (NotesXSLTResultTargetProdImpl) arg1;
			embeddedObject.transformXML(arg0, xslResult.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}