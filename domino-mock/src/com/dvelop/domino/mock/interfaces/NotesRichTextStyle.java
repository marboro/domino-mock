package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextStyle extends NotesBase {
	public static final int EFFECTS_NONE = 0;
	public static final int EFFECTS_SUPERSCRIPT = 1;
	public static final int EFFECTS_SUBSCRIPT = 2;
	public static final int EFFECTS_SHADOW = 3;
	public static final int EFFECTS_EMBOSS = 4;
	public static final int EFFECTS_EXTRUDE = 5;
	public static final int FONT_ROMAN = 0;
	public static final int FONT_HELV = 1;
	public static final int FONT_COURIER = 4;
	public static final int STYLE_NO_CHANGE = 255;
	public static final int YES = 1;
	public static final int NO = 0;
	public static final int MAYBE = 255;
	public static final int COLOR_BLACK = 0;
	public static final int COLOR_WHITE = 1;
	public static final int COLOR_RED = 2;
	public static final int COLOR_GREEN = 3;
	public static final int COLOR_BLUE = 4;
	public static final int COLOR_MAGENTA = 5;
	public static final int COLOR_YELLOW = 6;
	public static final int COLOR_CYAN = 7;
	public static final int COLOR_DARK_RED = 8;
	public static final int COLOR_DARK_GREEN = 9;
	public static final int COLOR_DARK_BLUE = 10;
	public static final int COLOR_DARK_MAGENTA = 11;
	public static final int COLOR_DARK_YELLOW = 12;
	public static final int COLOR_DARK_CYAN = 13;
	public static final int COLOR_GRAY = 14;
	public static final int COLOR_LIGHT_GRAY = 15;

	public abstract int getBold() throws NotesApiException;

	public abstract void setBold(int arg0) throws NotesApiException;

	public abstract int getColor() throws NotesApiException;

	public abstract void setColor(int arg0) throws NotesApiException;

	public abstract int getEffects() throws NotesApiException;

	public abstract void setEffects(int arg0) throws NotesApiException;

	public abstract int getFont() throws NotesApiException;

	public abstract void setFont(int arg0) throws NotesApiException;

	public abstract int getFontSize() throws NotesApiException;

	public abstract void setFontSize(int arg0) throws NotesApiException;

	public abstract int getItalic() throws NotesApiException;

	public abstract void setItalic(int arg0) throws NotesApiException;

	public abstract int getStrikeThrough() throws NotesApiException;

	public abstract void setStrikeThrough(int arg0) throws NotesApiException;

	public abstract int getUnderline() throws NotesApiException;

	public abstract void setUnderline(int arg0) throws NotesApiException;

	public abstract int getPassThruHTML() throws NotesApiException;

	public abstract void setPassThruHTML(int arg0) throws NotesApiException;

	public abstract boolean isDefault() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

}
