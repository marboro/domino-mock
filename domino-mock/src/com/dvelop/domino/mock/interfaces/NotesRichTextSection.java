package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextSection extends NotesBase {
	public abstract void remove() throws NotesApiException;

	public abstract void setBarColor(NotesColorObject color)
			throws NotesApiException;

	public abstract String getTitle() throws NotesApiException;

	public abstract void setTitle(String title) throws NotesApiException;

	public abstract NotesRichTextStyle getTitleStyle() throws NotesApiException;

	public abstract void setTitleStyle(NotesRichTextStyle style)
			throws NotesApiException;

	public abstract boolean isExpanded() throws NotesApiException;

	public abstract void setExpanded(boolean flag) throws NotesApiException;

	public abstract NotesColorObject getBarColor() throws NotesApiException;

}
