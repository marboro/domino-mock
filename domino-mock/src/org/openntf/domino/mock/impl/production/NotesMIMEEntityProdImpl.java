package org.openntf.domino.mock.impl.production;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import lotus.domino.MIMEEntity;
import lotus.domino.NotesException;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesMIMEEntity;
import org.openntf.domino.mock.interfaces.NotesMIMEHeader;
import org.openntf.domino.mock.interfaces.NotesStream;
import org.openntf.domino.mock.interfaces.NotesXSLTResultTarget;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class NotesMIMEEntityProdImpl extends NotesBaseProdImpl implements
		NotesMIMEEntity {

	private final MIMEEntity mIMEEntity;

	public NotesMIMEEntityProdImpl(MIMEEntity mIMEEntity) {
		this.mIMEEntity = mIMEEntity;
	}

	public MIMEEntity get() {
		return mIMEEntity;
	}

	@Override
	public NotesMIMEEntity getNextEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getNextEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getNextEntity(int arg0) throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getNextEntity(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getNextSibling() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getNextSibling());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getFirstChildEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getFirstChildEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getParentEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getParentEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getPrevEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getPrevEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getPrevEntity(int arg0) throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getPrevEntity(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getPrevSibling() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.getPrevSibling());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity createChildEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.createChildEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity createChildEntity(NotesMIMEEntity arg0)
			throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(
					mIMEEntity
							.createChildEntity(((NotesMIMEEntityProdImpl) arg0)
									.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity createParentEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(mIMEEntity.createParentEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getBoundaryStart() throws NotesApiException {
		try {
			return mIMEEntity.getBoundaryStart();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getBoundaryEnd() throws NotesApiException {
		try {
			return mIMEEntity.getBoundaryEnd();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCharset() throws NotesApiException {
		try {
			return mIMEEntity.getCharset();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getContentType() throws NotesApiException {
		try {
			return mIMEEntity.getContentType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getContentSubType() throws NotesApiException {
		try {
			return mIMEEntity.getContentSubType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getContentAsText() throws NotesApiException {
		try {
			return mIMEEntity.getContentAsText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaders() throws NotesApiException {
		try {
			return mIMEEntity.getHeaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPreamble() throws NotesApiException {
		try {
			return mIMEEntity.getPreamble();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getEncoding() throws NotesApiException {
		try {
			return mIMEEntity.getEncoding();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getHeaderObjects() throws NotesApiException {
		try {
			return mIMEEntity.getHeaderObjects();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEHeader getNthHeader(String arg0) throws NotesApiException {
		try {
			return new NotesMIMEHeaderProdImpl(mIMEEntity.getNthHeader(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEHeader getNthHeader(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesMIMEHeaderProdImpl(mIMEEntity.getNthHeader(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEHeader createHeader(String arg0) throws NotesApiException {
		try {
			return new NotesMIMEHeaderProdImpl(mIMEEntity.createHeader(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Reader getReader() throws NotesApiException {
		try {
			return mIMEEntity.getReader();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputSource getInputSource() throws NotesApiException {
		try {
			return mIMEEntity.getInputSource();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public InputStream getInputStream() throws NotesApiException {
		try {
			return mIMEEntity.getInputStream();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Document parseXML(boolean arg0) throws IOException,
			NotesApiException {
		try {
			return mIMEEntity.parseXML(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void transformXML(Object arg0, NotesXSLTResultTarget arg1)
			throws NotesApiException {
		try {
			mIMEEntity.transformXML(arg0,
					((NotesXSLTResultTargetProdImpl) arg1).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void decodeContent() throws NotesApiException {
		try {
			mIMEEntity.decodeContent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void encodeContent(int arg0) throws NotesApiException {
		try {
			mIMEEntity.encodeContent(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void getEntityAsText(NotesStream arg0) throws NotesApiException {
		try {
			mIMEEntity.getEntityAsText(((NotesStreamProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void getEntityAsText(NotesStream arg0, Vector arg1)
			throws NotesApiException {
		try {
			mIMEEntity
					.getEntityAsText(((NotesStreamProdImpl) arg0).get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void getEntityAsText(NotesStream arg0, Vector arg1, boolean arg2)
			throws NotesApiException {
		try {
			mIMEEntity.getEntityAsText(((NotesStreamProdImpl) arg0).get(),
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void getContentAsBytes(NotesStream arg0) throws NotesApiException {
		try {
			mIMEEntity.getContentAsBytes(((NotesStreamProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void getContentAsBytes(NotesStream arg0, boolean arg1)
			throws NotesApiException {
		try {
			mIMEEntity.getContentAsBytes(((NotesStreamProdImpl) arg0).get(),
					arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void getContentAsText(NotesStream arg0) throws NotesApiException {
		try {
			mIMEEntity.getContentAsText(((NotesStreamProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void getContentAsText(NotesStream arg0, boolean arg1)
			throws NotesApiException {
		try {
			mIMEEntity.getContentAsText(((NotesStreamProdImpl) arg0).get(),
					arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSomeHeaders() throws NotesApiException {
		try {
			return mIMEEntity.getSomeHeaders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSomeHeaders(Vector arg0) throws NotesApiException {
		try {
			return mIMEEntity.getSomeHeaders(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSomeHeaders(Vector arg0, boolean arg1)
			throws NotesApiException {
		try {
			return mIMEEntity.getSomeHeaders(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			mIMEEntity.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setContentFromBytes(NotesStream arg0, String arg1, int arg2)
			throws NotesApiException {
		try {
			mIMEEntity.setContentFromBytes(((NotesStreamProdImpl) arg0).get(),
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setContentFromText(NotesStream arg0, String arg1, int arg2)
			throws NotesApiException {
		try {
			mIMEEntity.setContentFromText(((NotesStreamProdImpl) arg0).get(),
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPreamble(String arg0) throws NotesApiException {
		try {
			mIMEEntity.setPreamble(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}