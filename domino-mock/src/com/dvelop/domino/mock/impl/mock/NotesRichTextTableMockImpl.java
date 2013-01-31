package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesColorObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextTable;

public class NotesRichTextTableMockImpl extends NotesBaseMockImpl implements
		NotesRichTextTable {

	@Override
	public void addRow() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(int count) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(int count, int targetRow) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow(int count) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRow(int count, int targetRow) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(NotesColorObject color) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlternateColor(NotesColorObject color)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getStyle() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStyle(int tablestyle) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRowCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getRowLabels() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowLabels(Vector labels) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesColorObject getColor() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesColorObject getAlternateColor() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRightToLeft() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRightToLeft(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

}
