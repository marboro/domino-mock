package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesRichTextRange extends NotesBase {
	public abstract void setStyle(NotesRichTextStyle style)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract void setBegin(NotesBase element) throws NotesApiException;

	public abstract void setEnd(NotesBase element) throws NotesApiException;

	public abstract void reset(boolean begin, boolean end)
			throws NotesApiException;

	public abstract int findandReplace(String target, String replacement)
			throws NotesApiException;

	public abstract int findandReplace(String target, String replacement,
			long options) throws NotesApiException;

	public abstract NotesRichTextRange Clone() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract String getTextRun() throws NotesApiException;

	public abstract String getTextParagraph() throws NotesApiException;

	public abstract NotesRichTextStyle getStyle() throws NotesApiException;

	public abstract NotesRichTextNavigator getNavigator()
			throws NotesApiException;
}
