package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextRange extends NotesBase {
	public abstract void setStyle(NotesRichTextStyle arg0)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract void setBegin(NotesBase arg0) throws NotesApiException;

	public abstract void setEnd(NotesBase arg0) throws NotesApiException;

	public abstract void reset(boolean arg0, boolean arg1)
			throws NotesApiException;

	public abstract int findandReplace(String arg0, String arg1)
			throws NotesApiException;

	public abstract int findandReplace(String arg0, String arg1, long arg2)
			throws NotesApiException;

	public abstract NotesRichTextRange Clone() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract String getTextRun() throws NotesApiException;

	public abstract String getTextParagraph() throws NotesApiException;

	public abstract NotesRichTextStyle getStyle() throws NotesApiException;

	public abstract NotesRichTextNavigator getNavigator()
			throws NotesApiException;
}
