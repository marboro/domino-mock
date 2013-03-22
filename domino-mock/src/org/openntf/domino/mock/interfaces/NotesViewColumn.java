package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesViewColumn extends NotesBase {
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 1;
	public static final int ALIGN_CENTER = 2;
	public static final int SEP_SPACE = 1;
	public static final int SEP_COMMA = 2;
	public static final int SEP_SEMICOLON = 3;
	public static final int SEP_NEWLINE = 4;
	public static final int SOLO_NOTES_NAMES = 1000;
	public static final int SEP_NONE = 0;
	public static final int FMT_H = 2;
	public static final int FMT_ALL = 3;
	public static final int FMT_GENERAL = 0;
	public static final int FMT_FIXED = 1;
	public static final int FMT_SCIENTIFIC = 2;
	public static final int FMT_CURRENCY = 3;
	public static final int ATTR_PUNCTUATED = 1;
	public static final int ATTR_PARENS = 2;
	public static final int ATTR_PERCENT = 4;
	public static final int FMT_YMD = 0;
	public static final int FMT_MD = 2;
	public static final int FMT_YM = 3;
	public static final int FMT_Y4M = 6;
	public static final int FMT_HMS = 0;
	public static final int FMT_HM = 1;
	public static final int FMT_NEVER = 0;
	public static final int FMT_SOMETIMES = 1;
	public static final int FMT_ALWAYS = 2;
	public static final int FMT_DATE = 0;
	public static final int FMT_TIME = 1;
	public static final int FMT_DATETIME = 2;
	public static final int FMT_TODAYTIME = 3;
	public static final int FONT_BOLD = 1;
	public static final int FONT_ITALIC = 2;
	public static final int FONT_UNDERLINE = 4;
	public static final int FONT_STRIKEOUT = 8;
	public static final int FONT_STRIKETHROUGH = 8;
	public static final int FONT_PLAIN = 0;
	public static final int VC_NOT_PRESENT = 65535;

	public abstract boolean isField() throws NotesApiException;

	public abstract boolean isFormula() throws NotesApiException;

	public abstract String getTitle() throws NotesApiException;

	public abstract String getItemName() throws NotesApiException;

	public abstract int getPosition() throws NotesApiException;

	public abstract String getFormula() throws NotesApiException;

	public abstract int getWidth() throws NotesApiException;

	public abstract int getListSep() throws NotesApiException;

	public abstract int getAlignment() throws NotesApiException;

	public abstract int getHeaderAlignment() throws NotesApiException;

	public abstract String getFontFace() throws NotesApiException;

	public abstract int getFontStyle() throws NotesApiException;

	public abstract int getFontColor() throws NotesApiException;

	public abstract int getFontPointSize() throws NotesApiException;

	public abstract int getNumberDigits() throws NotesApiException;

	public abstract int getNumberFormat() throws NotesApiException;

	public abstract int getNumberAttrib() throws NotesApiException;

	public abstract int getDateFmt() throws NotesApiException;

	public abstract int getTimeFmt() throws NotesApiException;

	public abstract int getTimeZoneFmt() throws NotesApiException;

	public abstract int getTimeDateFmt() throws NotesApiException;

	public abstract NotesView getParent() throws NotesApiException;

	public abstract boolean isSorted() throws NotesApiException;

	public abstract boolean isCategory() throws NotesApiException;

	public abstract boolean isHidden() throws NotesApiException;

	public abstract boolean isResponse() throws NotesApiException;

	public abstract boolean isSortDescending() throws NotesApiException;

	public abstract boolean isHideDetail() throws NotesApiException;

	public abstract boolean isIcon() throws NotesApiException;

	public abstract boolean isResize() throws NotesApiException;

	public abstract boolean isResortAscending() throws NotesApiException;

	public abstract boolean isResortDescending() throws NotesApiException;

	public abstract boolean isShowTwistie() throws NotesApiException;

	public abstract boolean isResortToView() throws NotesApiException;

	public abstract boolean isSecondaryResort() throws NotesApiException;

	public abstract boolean isSecondaryResortDescending()
			throws NotesApiException;

	public abstract boolean isCaseSensitiveSort() throws NotesApiException;

	public abstract boolean isAccentSensitiveSort() throws NotesApiException;

	public abstract int getHeaderFontColor() throws NotesApiException;

	public abstract String getHeaderFontFace() throws NotesApiException;

	public abstract int getHeaderFontPointSize() throws NotesApiException;

	public abstract int getHeaderFontStyle() throws NotesApiException;

	public abstract int getSecondaryResortColumnIndex()
			throws NotesApiException;

	public abstract boolean isFontBold() throws NotesApiException;

	public abstract boolean isFontItalic() throws NotesApiException;

	public abstract boolean isFontUnderline() throws NotesApiException;

	public abstract boolean isFontStrikethrough() throws NotesApiException;

	public abstract boolean isHeaderFontBold() throws NotesApiException;

	public abstract boolean isHeaderFontItalic() throws NotesApiException;

	public abstract boolean isHeaderFontUnderline() throws NotesApiException;

	public abstract boolean isHeaderFontStrikethrough()
			throws NotesApiException;

	public abstract boolean isNumberAttribParens() throws NotesApiException;

	public abstract boolean isNumberAttribPunctuated() throws NotesApiException;

	public abstract boolean isNumberAttribPercent() throws NotesApiException;

	public abstract String getResortToViewName() throws NotesApiException;

	public abstract void setAlignment(int arg0) throws NotesApiException;

	public abstract void setDateFmt(int arg0) throws NotesApiException;

	public abstract void setFontColor(int arg0) throws NotesApiException;

	public abstract void setFontFace(String arg0) throws NotesApiException;

	public abstract void setFontPointSize(int arg0) throws NotesApiException;

	public abstract void setFontStyle(int arg0) throws NotesApiException;

	public abstract void setFormula(String arg0) throws NotesApiException;

	public abstract void setHeaderAlignment(int arg0) throws NotesApiException;

	public abstract void setAccentSensitiveSort(boolean flag)
			throws NotesApiException;

	public abstract void setCaseSensitiveSort(boolean flag)
			throws NotesApiException;

	public abstract void setHidden(boolean flag) throws NotesApiException;

	public abstract void setHideDetail(boolean flag) throws NotesApiException;

	public abstract void setResize(boolean flag) throws NotesApiException;

	public abstract void setResortAscending(boolean flag)
			throws NotesApiException;

	public abstract void setResortDescending(boolean flag)
			throws NotesApiException;

	public abstract void setResortToView(boolean flag) throws NotesApiException;

	public abstract void setSecondaryResort(boolean flag)
			throws NotesApiException;

	public abstract void setSecondaryResortDescending(boolean flag)
			throws NotesApiException;

	public abstract void setShowTwistie(boolean flag) throws NotesApiException;

	public abstract void setSortDescending(boolean flag)
			throws NotesApiException;

	public abstract void setSorted(boolean flag) throws NotesApiException;

	public abstract void setListSep(int separator) throws NotesApiException;

	public abstract void setNumberAttrib(int attributes)
			throws NotesApiException;

	public abstract void setNumberDigits(int digits) throws NotesApiException;

	public abstract void setNumberFormat(int format) throws NotesApiException;

	public abstract void setPosition(int position) throws NotesApiException;

	public abstract void setTimeDateFmt(int format) throws NotesApiException;

	public abstract void setTimeFmt(int format) throws NotesApiException;

	public abstract void setTimeZoneFmt(int format) throws NotesApiException;

	public abstract void setTitle(String title) throws NotesApiException;

	public abstract void setWidth(int width) throws NotesApiException;

	public abstract void setHeaderFontColor(int color) throws NotesApiException;

	public abstract void setHeaderFontFace(String face)
			throws NotesApiException;

	public abstract void setHeaderFontPointSize(int size)
			throws NotesApiException;

	public abstract void setHeaderFontStyle(int style) throws NotesApiException;

	public abstract void setSecondaryResortColumnIndex(int index)
			throws NotesApiException;

	public abstract void setFontBold(boolean flag) throws NotesApiException;

	public abstract void setFontItalic(boolean flag) throws NotesApiException;

	public abstract void setFontUnderline(boolean flag)
			throws NotesApiException;

	public abstract void setFontStrikethrough(boolean flag)
			throws NotesApiException;

	public abstract void setHeaderFontBold(boolean flag)
			throws NotesApiException;

	public abstract void setHeaderFontItalic(boolean flag)
			throws NotesApiException;

	public abstract void setHeaderFontUnderline(boolean flag)
			throws NotesApiException;

	public abstract void setHeaderFontStrikethrough(boolean flag)
			throws NotesApiException;

	public abstract void setNumberAttribParens(boolean flag)
			throws NotesApiException;

	public abstract void setNumberAttribPunctuated(boolean flag)
			throws NotesApiException;

	public abstract void setNumberAttribPercent(boolean flag)
			throws NotesApiException;

	public abstract void setResortToViewName(String name)
			throws NotesApiException;

	public abstract boolean isHideFormula() throws NotesApiException;

	public abstract void setHideFormula(boolean flag) throws NotesApiException;

	public abstract boolean isConstant() throws NotesApiException;

	public abstract int getColumnValuesIndex() throws NotesApiException;
}
