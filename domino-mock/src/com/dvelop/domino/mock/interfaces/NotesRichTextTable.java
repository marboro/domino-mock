package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextTable extends NotesBase {
	public static final int TABLESTYLE_NONE = 0;
	public static final int TABLESTYLE_LEFTTOP = 1;
	public static final int TABLESTYLE_TOP = 2;
	public static final int TABLESTYLE_LEFT = 3;
	public static final int TABLESTYLE_ALTERNATINGCOLS = 4;
	public static final int TABLESTYLE_ALTERNATINGROWS = 5;
	public static final int TABLESTYLE_RIGHTTOP = 6;
	public static final int TABLESTYLE_RIGHT = 7;
	public static final int TABLESTYLE_SOLID = 8;

	public abstract void addRow() throws NotesApiException;

	public abstract void addRow(int count) throws NotesApiException;

	public abstract void addRow(int count, int targetRow)
			throws NotesApiException;

	public abstract void removeRow() throws NotesApiException;

	public abstract void removeRow(int count) throws NotesApiException;

	public abstract void removeRow(int count, int targetRow)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract void setColor(NotesColorObject color)
			throws NotesApiException;

	public abstract void setAlternateColor(NotesColorObject color)
			throws NotesApiException;

	public abstract int getStyle() throws NotesApiException;

	public abstract void setStyle(int tablestyle) throws NotesApiException;

	public abstract int getRowCount() throws NotesApiException;

	public abstract int getColumnCount() throws NotesApiException;

	public abstract Vector getRowLabels() throws NotesApiException;

	public abstract void setRowLabels(Vector labels) throws NotesApiException;

	public abstract NotesColorObject getColor() throws NotesApiException;

	public abstract NotesColorObject getAlternateColor()
			throws NotesApiException;

	public abstract boolean isRightToLeft() throws NotesApiException;

	public abstract void setRightToLeft(boolean flag) throws NotesApiException;
}
