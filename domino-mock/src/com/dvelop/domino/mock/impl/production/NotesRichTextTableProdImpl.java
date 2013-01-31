package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.NotesException;
import lotus.domino.RichTextTable;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesColorObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextTable;

public class NotesRichTextTableProdImpl extends NotesBaseProdImpl implements
		NotesRichTextTable {

	private final RichTextTable rtTable;

	public NotesRichTextTableProdImpl(RichTextTable rtTable) {
		this.rtTable = rtTable;
	}

	public RichTextTable get() {
		return rtTable;
	}

	@Override
	public void addRow() throws NotesApiException {
		try {
			rtTable.addRow();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void addRow(int arg0) throws NotesApiException {
		try {
			rtTable.addRow(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addRow(int arg0, int arg1) throws NotesApiException {
		try {
			rtTable.addRow(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeRow() throws NotesApiException {
		try {
			rtTable.removeRow();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeRow(int arg0) throws NotesApiException {
		try {
			rtTable.removeRow(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeRow(int arg0, int arg1) throws NotesApiException {
		try {
			rtTable.removeRow(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			rtTable.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setColor(NotesColorObject arg0) throws NotesApiException {
		try {
			rtTable.setColor(((NotesColorObjectProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAlternateColor(NotesColorObject arg0)
			throws NotesApiException {
		try {
			rtTable.setAlternateColor(((NotesColorObjectProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getStyle() throws NotesApiException {
		try {
			return rtTable.getStyle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setStyle(int arg0) throws NotesApiException {
		try {
			rtTable.setStyle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getRowCount() throws NotesApiException {
		try {
			return rtTable.getRowCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getColumnCount() throws NotesApiException {
		try {
			return rtTable.getColumnCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getRowLabels() throws NotesApiException {
		try {
			return rtTable.getRowLabels();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setRowLabels(Vector arg0) throws NotesApiException {
		try {
			rtTable.setRowLabels(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesColorObject getColor() throws NotesApiException {
		try {
			return new NotesColorObjectProdImpl(rtTable.getColor());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesColorObject getAlternateColor() throws NotesApiException {
		try {
			return new NotesColorObjectProdImpl(rtTable.getAlternateColor());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isRightToLeft() throws NotesApiException {
		try {
			return rtTable.isRightToLeft();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setRightToLeft(boolean arg0) throws NotesApiException {
		try {
			rtTable.setRightToLeft(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

}
