package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesRichTextDocLink;
import org.openntf.domino.mock.interfaces.NotesRichTextStyle;

import lotus.domino.NotesException;
import lotus.domino.RichTextDoclink;


public class NotesRichTextDocLinkProdImpl extends NotesBaseProdImpl implements
		NotesRichTextDocLink {

	private final RichTextDoclink rtDocLink;

	public NotesRichTextDocLinkProdImpl(RichTextDoclink rtDocLink) {
		this.rtDocLink = rtDocLink;
	}

	public RichTextDoclink get() {
		return rtDocLink;
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			rtDocLink.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHotSpotTextStyle(NotesRichTextStyle arg0)
			throws NotesApiException {
		try {
			rtDocLink.setHotSpotTextStyle(((NotesRichTextStyleProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDBReplicaID() throws NotesApiException {
		try {
			return rtDocLink.getDBReplicaID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDBReplicaID(String arg0) throws NotesApiException {
		try {
			rtDocLink.setDBReplicaID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getViewUnID() throws NotesApiException {
		try {
			return rtDocLink.getViewUnID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setViewUnID(String arg0) throws NotesApiException {
		try {
			rtDocLink.setViewUnID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDocUnID() throws NotesApiException {
		try {
			return rtDocLink.getDocUnID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDocUnID(String arg0) throws NotesApiException {
		try {
			rtDocLink.setDocUnID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDisplayComment() throws NotesApiException {
		try {
			return rtDocLink.getDisplayComment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDisplayComment(String arg0) throws NotesApiException {
		try {
			rtDocLink.setDisplayComment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getServerHint() throws NotesApiException {
		try {
			return rtDocLink.getServerHint();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setServerHint(String arg0) throws NotesApiException {
		try {
			rtDocLink.setServerHint(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHotSpotText() throws NotesApiException {
		try {
			return rtDocLink.getHotSpotText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHotSpotText(String arg0) throws NotesApiException {
		try {
			rtDocLink.setHotSpotText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesRichTextStyle getHotSpotTextStyle() throws NotesApiException {
		try {
			return new NotesRichTextStyleProdImpl(
					rtDocLink.getHotSpotTextStyle());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

}
