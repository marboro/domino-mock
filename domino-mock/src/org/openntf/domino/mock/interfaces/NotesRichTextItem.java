package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesRichTextItem extends NotesItem {
	public static final int RT_FIND_CASEINSENSITIVE = 1;
	public static final int RT_FIND_PITCHINSENSITIVE = 2;
	public static final int RT_FIND_ACCENTINSENSITIVE = 4;
	public static final int RT_REPL_PRESERVECASE = 8;
	public static final int RT_REPL_ALL = 16;
	public static final int RTELEM_TYPE_TABLE = 1;
	public static final int RTELEM_TYPE_TEXTRUN = 3;
	public static final int RTELEM_TYPE_TEXTPARAGRAPH = 4;
	public static final int RTELEM_TYPE_DOCLINK = 5;
	public static final int RTELEM_TYPE_SECTION = 6;
	public static final int RTELEM_TYPE_TABLECELL = 7;
	public static final int RTELEM_TYPE_FILEATTACHMENT = 8;
	public static final int RTELEM_TYPE_OLE = 9;
	public static final int RTELEM_TYPE_TEXTPOSITION = 10;
	public static final int RTELEM_TYPE_TEXTSTRING = 11;

	public abstract void addNewLine(int count, boolean newparagraph)
			throws NotesApiException;

	public abstract void addNewLine(int count) throws NotesApiException;

	public abstract void addNewLine() throws NotesApiException;

	public abstract void addTab(int count) throws NotesApiException;

	public abstract void addTab() throws NotesApiException;

	public abstract void addPageBreak() throws NotesApiException;

	public abstract void addPageBreak(NotesRichTextParagraphStyle pstyle)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDocument doc, String comment)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDocument doc)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase db, String comment)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase db)
			throws NotesApiException;

	public abstract void appendDocLink(NotesView vw, String comment)
			throws NotesApiException;

	public abstract void appendDocLink(NotesView vw) throws NotesApiException;

	public abstract void appendDocLink(NotesDocument doc, String comment,
			String hotspottext) throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase db, String comment,
			String hotspottext) throws NotesApiException;

	public abstract void appendDocLink(NotesView vw, String comment,
			String hotspottext) throws NotesApiException;

	public abstract void appendRTItem(NotesRichTextItem item)
			throws NotesApiException;

	public abstract void appendStyle(NotesRichTextStyle style)
			throws NotesApiException;

	public abstract void appendParagraphStyle(NotesRichTextParagraphStyle pstyle)
			throws NotesApiException;

	public abstract void appendText(String text) throws NotesApiException;

	public abstract NotesEmbeddedObject embedObject(int type, String clazz,
			String source, String name) throws NotesApiException;

	public abstract NotesEmbeddedObject getEmbeddedObject(String name)
			throws NotesApiException;

	public abstract Vector getEmbeddedObjects() throws NotesApiException;

	public abstract String getFormattedText(boolean tabstrip, int linelen,
			int maxlen) throws NotesApiException;

	public abstract void appendTable(int rows, int columns)
			throws NotesApiException;

	public abstract void appendTable(int rows, int columns, Vector labels)
			throws NotesApiException;

	public abstract void appendTable(int rows, int columns, Vector labels,
			int leftmargin, Vector rtpstyles) throws NotesApiException;

	public abstract void beginInsert(NotesBase element)
			throws NotesApiException;

	public abstract void beginInsert(NotesBase element, boolean after)
			throws NotesApiException;

	public abstract void endInsert() throws NotesApiException;

	public abstract NotesRichTextNavigator createNavigator()
			throws NotesApiException;

	public abstract NotesRichTextRange createRange() throws NotesApiException;

	public abstract int getNotesFont(String facename, boolean addonfail)
			throws NotesApiException;

	public abstract void beginSection(String title) throws NotesApiException;

	public abstract void beginSection(String title,
			NotesRichTextStyle titlestyle) throws NotesApiException;

	public abstract void beginSection(String title,
			NotesRichTextStyle titlestyle, NotesColorObject barcolor,
			boolean expand) throws NotesApiException;

	public abstract void endSection() throws NotesApiException;

	public abstract void update() throws NotesApiException;

	public abstract void compact() throws NotesApiException;

	public abstract String getUnformattedText() throws NotesApiException;
}
