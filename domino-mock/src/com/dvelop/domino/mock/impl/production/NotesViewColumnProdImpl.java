package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.ViewColumn;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesView;
import com.dvelop.domino.mock.interfaces.NotesViewColumn;

public class NotesViewColumnProdImpl extends NotesBaseProdImpl implements
		NotesViewColumn {

	private final ViewColumn column;

	public NotesViewColumnProdImpl(ViewColumn column) {
		this.column = column;
	}

	public ViewColumn get() {
		return column;
	}

	@Override
	public boolean isField() throws NotesApiException {
		try {
			return column.isField();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFormula() throws NotesApiException {
		try {
			return column.isFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTitle() throws NotesApiException {
		try {
			return column.getTitle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getItemName() throws NotesApiException {
		try {
			return column.getItemName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getPosition() throws NotesApiException {
		try {
			return column.getPosition();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFormula() throws NotesApiException {
		try {
			return column.getFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getWidth() throws NotesApiException {
		try {
			return column.getWidth();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getListSep() throws NotesApiException {
		try {
			return column.getListSep();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getAlignment() throws NotesApiException {
		try {
			return column.getAlignment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHeaderAlignment() throws NotesApiException {
		try {
			return column.getHeaderAlignment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFontFace() throws NotesApiException {
		try {
			return column.getFontFace();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFontStyle() throws NotesApiException {
		try {
			return column.getFontStyle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFontColor() throws NotesApiException {
		try {
			return column.getFontColor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFontPointSize() throws NotesApiException {
		try {
			return column.getFontPointSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNumberDigits() throws NotesApiException {
		try {
			return column.getNumberDigits();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNumberFormat() throws NotesApiException {
		try {
			return column.getNumberFormat();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNumberAttrib() throws NotesApiException {
		try {
			return column.getNumberAttrib();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getDateFmt() throws NotesApiException {
		try {
			return column.getDateFmt();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTimeFmt() throws NotesApiException {
		try {
			return column.getTimeFmt();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTimeZoneFmt() throws NotesApiException {
		try {
			return column.getTimeZoneFmt();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTimeDateFmt() throws NotesApiException {
		try {
			return column.getTimeDateFmt();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getParent() throws NotesApiException {
		try {
			return new NotesViewProdImpl(column.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSorted() throws NotesApiException {
		try {
			return column.isSorted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCategory() throws NotesApiException {
		try {
			return column.isCategory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHidden() throws NotesApiException {
		try {
			return column.isHidden();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResponse() throws NotesApiException {
		try {
			return column.isResponse();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSortDescending() throws NotesApiException {
		try {
			return column.isSortDescending();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHideDetail() throws NotesApiException {
		try {
			return column.isHideDetail();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIcon() throws NotesApiException {
		try {
			return column.isIcon();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResize() throws NotesApiException {
		try {
			return column.isResize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResortAscending() throws NotesApiException {
		try {
			return column.isResortAscending();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResortDescending() throws NotesApiException {
		try {
			return column.isResortDescending();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isShowTwistie() throws NotesApiException {
		try {
			return column.isShowTwistie();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResortToView() throws NotesApiException {
		try {
			return column.isResortToView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSecondaryResort() throws NotesApiException {
		try {
			return column.isSecondaryResort();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSecondaryResortDescending() throws NotesApiException {
		try {
			return column.isSecondaryResortDescending();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCaseSensitiveSort() throws NotesApiException {
		try {
			return column.isCaseSensitiveSort();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAccentSensitiveSort() throws NotesApiException {
		try {
			return column.isAccentSensitiveSort();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHeaderFontColor() throws NotesApiException {
		try {
			return column.getHeaderFontColor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHeaderFontFace() throws NotesApiException {
		try {
			return column.getHeaderFontFace();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHeaderFontPointSize() throws NotesApiException {
		try {
			return column.getHeaderFontPointSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHeaderFontStyle() throws NotesApiException {
		try {
			return column.getHeaderFontStyle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSecondaryResortColumnIndex() throws NotesApiException {
		try {
			return column.getSecondaryResortColumnIndex();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFontBold() throws NotesApiException {
		try {
			return column.isFontBold();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFontItalic() throws NotesApiException {
		try {
			return column.isFontItalic();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFontUnderline() throws NotesApiException {
		try {
			return column.isFontUnderline();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isFontStrikethrough() throws NotesApiException {
		try {
			return column.isFontStrikethrough();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHeaderFontBold() throws NotesApiException {
		try {
			return column.isHeaderFontBold();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHeaderFontItalic() throws NotesApiException {
		try {
			return column.isHeaderFontItalic();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHeaderFontUnderline() throws NotesApiException {
		try {
			return column.isHeaderFontUnderline();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHeaderFontStrikethrough() throws NotesApiException {
		try {
			return column.isHeaderFontStrikethrough();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNumberAttribParens() throws NotesApiException {
		try {
			return column.isNumberAttribParens();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNumberAttribPunctuated() throws NotesApiException {
		try {
			return column.isNumberAttribPunctuated();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNumberAttribPercent() throws NotesApiException {
		try {
			return column.isNumberAttribPercent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getResortToViewName() throws NotesApiException {
		try {
			return column.getResortToViewName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAlignment(int arg0) throws NotesApiException {
		try {
			column.setAlignment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDateFmt(int arg0) throws NotesApiException {
		try {
			column.setDateFmt(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontColor(int arg0) throws NotesApiException {
		try {
			column.setFontColor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontFace(String arg0) throws NotesApiException {
		try {
			column.setFontFace(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontPointSize(int arg0) throws NotesApiException {
		try {
			column.setFontPointSize(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontStyle(int arg0) throws NotesApiException {
		try {
			column.setFontStyle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFormula(String arg0) throws NotesApiException {
		try {
			column.setFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderAlignment(int arg0) throws NotesApiException {
		try {
			column.setHeaderAlignment(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAccentSensitiveSort(boolean arg0) throws NotesApiException {
		try {
			column.setAccentSensitiveSort(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCaseSensitiveSort(boolean arg0) throws NotesApiException {
		try {
			column.setCaseSensitiveSort(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHidden(boolean arg0) throws NotesApiException {
		try {
			column.setHidden(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHideDetail(boolean arg0) throws NotesApiException {
		try {
			column.setHideDetail(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setResize(boolean arg0) throws NotesApiException {
		try {
			column.setResize(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setResortAscending(boolean arg0) throws NotesApiException {
		try {
			column.setResortAscending(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setResortDescending(boolean arg0) throws NotesApiException {
		try {
			column.setResortDescending(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setResortToView(boolean arg0) throws NotesApiException {
		try {
			column.setResortToView(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSecondaryResort(boolean arg0) throws NotesApiException {
		try {
			column.setSecondaryResort(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSecondaryResortDescending(boolean arg0)
			throws NotesApiException {
		try {
			column.setSecondaryResortDescending(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setShowTwistie(boolean arg0) throws NotesApiException {
		try {
			column.setShowTwistie(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSortDescending(boolean arg0) throws NotesApiException {
		try {
			column.setSortDescending(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSorted(boolean arg0) throws NotesApiException {
		try {
			column.setSorted(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setListSep(int arg0) throws NotesApiException {
		try {
			column.setListSep(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberAttrib(int arg0) throws NotesApiException {
		try {
			column.setNumberAttrib(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberDigits(int arg0) throws NotesApiException {
		try {
			column.setNumberDigits(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberFormat(int arg0) throws NotesApiException {
		try {
			column.setNumberFormat(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPosition(int arg0) throws NotesApiException {
		try {
			column.setPosition(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTimeDateFmt(int arg0) throws NotesApiException {
		try {
			column.setTimeDateFmt(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTimeFmt(int arg0) throws NotesApiException {
		try {
			column.setTimeFmt(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTimeZoneFmt(int arg0) throws NotesApiException {
		try {
			column.setTimeZoneFmt(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTitle(String arg0) throws NotesApiException {
		try {
			column.setTitle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setWidth(int arg0) throws NotesApiException {
		try {
			column.setWidth(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontColor(int arg0) throws NotesApiException {
		try {
			column.setHeaderFontColor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontFace(String arg0) throws NotesApiException {
		try {
			column.setHeaderFontFace(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontPointSize(int arg0) throws NotesApiException {
		try {
			column.setHeaderFontPointSize(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontStyle(int arg0) throws NotesApiException {
		try {
			column.setHeaderFontStyle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSecondaryResortColumnIndex(int arg0)
			throws NotesApiException {
		try {
			column.setSecondaryResortColumnIndex(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontBold(boolean arg0) throws NotesApiException {
		try {
			column.setFontBold(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontItalic(boolean arg0) throws NotesApiException {
		try {
			column.setFontItalic(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontUnderline(boolean arg0) throws NotesApiException {
		try {
			column.setFontUnderline(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFontStrikethrough(boolean arg0) throws NotesApiException {
		try {
			column.setFontStrikethrough(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontBold(boolean arg0) throws NotesApiException {
		try {
			column.setHeaderFontBold(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontItalic(boolean arg0) throws NotesApiException {
		try {
			column.setHeaderFontItalic(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontUnderline(boolean arg0) throws NotesApiException {
		try {
			column.setHeaderFontUnderline(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHeaderFontStrikethrough(boolean arg0)
			throws NotesApiException {
		try {
			column.setHeaderFontStrikethrough(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberAttribParens(boolean arg0) throws NotesApiException {
		try {
			column.setNumberAttribParens(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberAttribPunctuated(boolean arg0)
			throws NotesApiException {
		try {
			column.setNumberAttribPunctuated(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNumberAttribPercent(boolean arg0) throws NotesApiException {
		try {
			column.setNumberAttribPercent(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setResortToViewName(String arg0) throws NotesApiException {
		try {
			column.setResortToViewName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHideFormula() throws NotesApiException {
		try {
			return column.isHideFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setHideFormula(boolean arg0) throws NotesApiException {
		try {
			column.setHideFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConstant() throws NotesApiException {
		try {
			return column.isConstant();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getColumnValuesIndex() throws NotesApiException {
		try {
			return column.getColumnValuesIndex();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}