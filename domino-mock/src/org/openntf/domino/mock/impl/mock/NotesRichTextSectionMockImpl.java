package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesColorObject;
import org.openntf.domino.mock.interfaces.NotesRichTextSection;
import org.openntf.domino.mock.interfaces.NotesRichTextStyle;

public class NotesRichTextSectionMockImpl extends NotesBaseMockImpl implements
		NotesRichTextSection {

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBarColor(NotesColorObject color) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitle(String title) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesRichTextStyle getTitleStyle() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitleStyle(NotesRichTextStyle style)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExpanded() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setExpanded(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesColorObject getBarColor() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

}
