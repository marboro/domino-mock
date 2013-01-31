package com.dvelop.domino.mock.impl.mock;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesRichTextNavigator;
import com.dvelop.domino.mock.interfaces.NotesRichTextRange;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;

public class NotesRichTextRangeMockImpl extends NotesBaseMockImpl implements
		NotesRichTextRange {

	@Override
	public void setStyle(NotesRichTextStyle arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBegin(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnd(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(boolean arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int findandReplace(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findandReplace(String arg0, String arg1, long arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesRichTextRange Clone() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTextRun() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTextParagraph() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextStyle getStyle() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextNavigator getNavigator() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}