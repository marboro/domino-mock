package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesRichTextParagraphStyle extends NotesBase {
	public static final int ALIGN_LEFT = 0;
	public static final int ALIGN_RIGHT = 1;
	public static final int ALIGN_CENTER = 3;
	public static final int ALIGN_FULL = 2;
	public static final int ALIGN_NOWRAP = 4;
	public static final int SPACING_SINGLE = 0;
	public static final int SPACING_ONE_POINT_50 = 1;
	public static final int SPACING_DOUBLE = 2;
	public static final int PAGINATE_DEFAULT = 0;
	public static final int PAGINATE_BEFORE = 1;
	public static final int PAGINATE_KEEP_WITH_NEXT = 2;
	public static final int PAGINATE_KEEP_TOGETHER = 4;
	public static final int TAB_LEFT = 0;
	public static final int TAB_RIGHT = 1;
	public static final int TAB_DECIMAL = 2;
	public static final int TAB_CENTER = 3;
	public static final int RULER_ONE_INCH = 1440;
	public static final int RULER_ONE_CENTIMETER = 567;

	public abstract int getAlignment() throws NotesApiException;

	public abstract void setAlignment(int value) throws NotesApiException;

	public abstract int getInterLineSpacing() throws NotesApiException;

	public abstract void setInterLineSpacing(int value)
			throws NotesApiException;

	public abstract int getSpacingAbove() throws NotesApiException;

	public abstract void setSpacingAbove(int value) throws NotesApiException;

	public abstract int getSpacingBelow() throws NotesApiException;

	public abstract void setSpacingBelow(int value) throws NotesApiException;

	public abstract int getLeftMargin() throws NotesApiException;

	public abstract void setLeftMargin(int value) throws NotesApiException;

	public abstract int getRightMargin() throws NotesApiException;

	public abstract void setRightMargin(int value) throws NotesApiException;

	public abstract int getFirstLineLeftMargin() throws NotesApiException;

	public abstract void setFirstLineLeftMargin(int value)
			throws NotesApiException;

	public abstract int getPagination() throws NotesApiException;

	public abstract void setPagination(int value) throws NotesApiException;

	public abstract Vector getTabs() throws NotesApiException;

	public abstract void setTab(int position, int type)
			throws NotesApiException;

	public abstract void setTabs(int count, int startpos, int interval)
			throws NotesApiException;

	public abstract void setTabs(int count, int startpos, int interval, int type)
			throws NotesApiException;

	public abstract void clearAllTabs() throws NotesApiException;
}
