package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesOutline;
import org.openntf.domino.mock.interfaces.NotesOutlineEntry;
import org.openntf.domino.mock.interfaces.NotesView;

public class NotesOutlineEntryMockImpl extends NotesBaseMockImpl implements NotesOutlineEntry {

	@Override
	public boolean setNoteLink(NotesDatabase db) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNoteLink(NotesView doc) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNoteLink(NotesDocument view) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setURL(String url) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setNamedElement(NotesDatabase db, String elementName, int entryClass) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAction(String formula) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesDatabase getDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView getView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNamedElement() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormula() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInThisDB() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHidden() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHiddenFromNotes() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHiddenFromWeb() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivate() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEntryClass() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLabel() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImagesText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFrameText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getAlias() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getKeepSelectionFocus() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseHideFormula() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHideFormula() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHidden(boolean value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHiddenFromNotes(boolean value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHiddenFromWeb(boolean value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLabel(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlias(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setImagesText(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFrameText(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setKeepSelectionFocus(boolean value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUseHideFormula(boolean value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHideFormula(String value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

}