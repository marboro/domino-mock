package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.OutlineEntry;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesOutline;
import com.dvelop.domino.mock.interfaces.NotesOutlineEntry;
import com.dvelop.domino.mock.interfaces.NotesView;

public class NotesOutlineEntryProdImpl extends NotesBaseProdImpl implements
		NotesOutlineEntry {

	private final OutlineEntry outlineEntry;

	public NotesOutlineEntryProdImpl(OutlineEntry outlineEntry) {
		this.outlineEntry = outlineEntry;
	}

	public OutlineEntry get() {
		return outlineEntry;
	}

	@Override
	public boolean setNoteLink(NotesDatabase arg0) throws NotesApiException {
		try {
			return outlineEntry.setNoteLink(((NotesDatabaseProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setNoteLink(NotesView arg0) throws NotesApiException {
		try {
			return outlineEntry.setNoteLink(((NotesViewProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setNoteLink(NotesDocument arg0) throws NotesApiException {
		try {
			return outlineEntry.setNoteLink(((NotesDocumentProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setURL(String arg0) throws NotesApiException {
		try {
			return outlineEntry.setURL(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setNamedElement(NotesDatabase arg0, String arg1, int arg2)
			throws NotesApiException {
		try {
			return outlineEntry.setNamedElement(
					((NotesDatabaseProdImpl) arg0).get(), arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean setAction(String arg0) throws NotesApiException {
		try {
			return outlineEntry.setAction(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(outlineEntry.getDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getView() throws NotesApiException {
		try {
			return new NotesViewProdImpl(outlineEntry.getView());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(outlineEntry.getDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNamedElement() throws NotesApiException {
		try {
			return outlineEntry.getNamedElement();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFormula() throws NotesApiException {
		try {
			return outlineEntry.getFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return outlineEntry.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean hasChildren() throws NotesApiException {
		try {
			return outlineEntry.hasChildren();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isInThisDB() throws NotesApiException {
		try {
			return outlineEntry.isInThisDB();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHidden() throws NotesApiException {
		try {
			return outlineEntry.isHidden();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHiddenFromNotes() throws NotesApiException {
		try {
			return outlineEntry.isHiddenFromNotes();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHiddenFromWeb() throws NotesApiException {
		try {
			return outlineEntry.isHiddenFromWeb();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPrivate() throws NotesApiException {
		try {
			return outlineEntry.isPrivate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return outlineEntry.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getEntryClass() throws NotesApiException {
		try {
			return outlineEntry.getEntryClass();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getLabel() throws NotesApiException {
		try {
			return outlineEntry.getLabel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getImagesText() throws NotesApiException {
		try {
			return outlineEntry.getImagesText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFrameText() throws NotesApiException {
		try {
			return outlineEntry.getFrameText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getLevel() throws NotesApiException {
		try {
			return outlineEntry.getLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAlias() throws NotesApiException {
		try {
			return outlineEntry.getAlias();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getKeepSelectionFocus() throws NotesApiException {
		try {
			return outlineEntry.getKeepSelectionFocus();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getUseHideFormula() throws NotesApiException {
		try {
			return outlineEntry.getUseHideFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHideFormula() throws NotesApiException {
		try {
			return outlineEntry.getHideFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutline getParent() throws NotesApiException {
		try {
			return new NotesOutlineProdImpl(outlineEntry.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHidden(boolean arg0) throws NotesApiException {
		try {
			outlineEntry.setHidden(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHiddenFromNotes(boolean arg0) throws NotesApiException {
		try {
			outlineEntry.setHiddenFromNotes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHiddenFromWeb(boolean arg0) throws NotesApiException {
		try {
			outlineEntry.setHiddenFromWeb(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLabel(String arg0) throws NotesApiException {
		try {
			outlineEntry.setLabel(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAlias(String arg0) throws NotesApiException {
		try {
			outlineEntry.setAlias(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setImagesText(String arg0) throws NotesApiException {
		try {
			outlineEntry.setImagesText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFrameText(String arg0) throws NotesApiException {
		try {
			outlineEntry.setFrameText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setKeepSelectionFocus(boolean arg0) throws NotesApiException {
		try {
			outlineEntry.setKeepSelectionFocus(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUseHideFormula(boolean arg0) throws NotesApiException {
		try {
			outlineEntry.setUseHideFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHideFormula(String arg0) throws NotesApiException {
		try {
			outlineEntry.setHideFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}