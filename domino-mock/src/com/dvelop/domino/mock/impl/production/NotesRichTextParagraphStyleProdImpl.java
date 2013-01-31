package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.NotesException;
import lotus.domino.RichTextParagraphStyle;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesRichTextParagraphStyle;

public class NotesRichTextParagraphStyleProdImpl extends NotesBaseProdImpl
		implements NotesRichTextParagraphStyle {

	private final RichTextParagraphStyle richTextParagraphStyle;

	public NotesRichTextParagraphStyleProdImpl(
			RichTextParagraphStyle richTextParagraphStyle) {
		this.richTextParagraphStyle = richTextParagraphStyle;
	}

	public RichTextParagraphStyle get() {
		return richTextParagraphStyle;
	}

	@Override
	public int getAlignment() throws NotesApiException {
		try {
			return richTextParagraphStyle.getAlignment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAlignment(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setAlignment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getInterLineSpacing() throws NotesApiException {
		try {
			return richTextParagraphStyle.getInterLineSpacing();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setInterLineSpacing(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setInterLineSpacing(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getSpacingAbove() throws NotesApiException {
		try {
			return richTextParagraphStyle.getSpacingAbove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSpacingAbove(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setSpacingAbove(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getSpacingBelow() throws NotesApiException {
		try {
			return richTextParagraphStyle.getSpacingBelow();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSpacingBelow(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setSpacingBelow(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getLeftMargin() throws NotesApiException {
		try {
			return richTextParagraphStyle.getLeftMargin();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLeftMargin(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setLeftMargin(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getRightMargin() throws NotesApiException {
		try {
			return richTextParagraphStyle.getRightMargin();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setRightMargin(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setRightMargin(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getFirstLineLeftMargin() throws NotesApiException {
		try {
			return richTextParagraphStyle.getFirstLineLeftMargin();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFirstLineLeftMargin(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setFirstLineLeftMargin(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getPagination() throws NotesApiException {
		try {
			return richTextParagraphStyle.getPagination();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPagination(int arg0) throws NotesApiException {
		try {
			richTextParagraphStyle.setPagination(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public Vector getTabs() throws NotesApiException {
		try {
			return richTextParagraphStyle.getTabs();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTab(int arg0, int arg1) throws NotesApiException {
		try {
			richTextParagraphStyle.setTab(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setTabs(int arg0, int arg1, int arg2) throws NotesApiException {
		try {
			richTextParagraphStyle.setTabs(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setTabs(int arg0, int arg1, int arg2, int arg3)
			throws NotesApiException {
		try {
			richTextParagraphStyle.setTabs(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void clearAllTabs() throws NotesApiException {
		try {
			richTextParagraphStyle.clearAllTabs();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}