package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.RichTextStyle;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesRichTextStyleProdImpl extends NotesBaseProdImpl implements
		NotesRichTextStyle {

	private final RichTextStyle richTextStyle;

	public NotesRichTextStyleProdImpl(RichTextStyle richTextStyle) {
		this.richTextStyle = richTextStyle;
	}

	public RichTextStyle get() {
		return richTextStyle;
	}

	@Override
	public int getBold() throws NotesApiException {
		try {
			return richTextStyle.getBold();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setBold(int arg0) throws NotesApiException {
		try {
			richTextStyle.setBold(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getColor() throws NotesApiException {
		try {
			return richTextStyle.getColor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setColor(int arg0) throws NotesApiException {
		try {
			richTextStyle.setColor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getEffects() throws NotesApiException {
		try {
			return richTextStyle.getEffects();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEffects(int arg0) throws NotesApiException {
		try {
			richTextStyle.setEffects(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getFont() throws NotesApiException {
		try {
			return richTextStyle.getFont();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFont(int arg0) throws NotesApiException {
		try {
			richTextStyle.setFont(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getFontSize() throws NotesApiException {
		try {
			return richTextStyle.getFontSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontSize(int arg0) throws NotesApiException {
		try {
			richTextStyle.setFontSize(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getItalic() throws NotesApiException {
		try {
			return richTextStyle.getItalic();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setItalic(int arg0) throws NotesApiException {
		try {
			richTextStyle.setItalic(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getStrikeThrough() throws NotesApiException {
		try {
			return richTextStyle.getStrikeThrough();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setStrikeThrough(int arg0) throws NotesApiException {
		try {
			richTextStyle.setStrikeThrough(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getUnderline() throws NotesApiException {
		try {
			return richTextStyle.getUnderline();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUnderline(int arg0) throws NotesApiException {
		try {
			richTextStyle.setUnderline(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getPassThruHTML() throws NotesApiException {
		try {
			return richTextStyle.getPassThruHTML();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPassThruHTML(int arg0) throws NotesApiException {
		try {
			richTextStyle.setPassThruHTML(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isDefault() throws NotesApiException {
		try {
			return richTextStyle.isDefault();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(richTextStyle.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}