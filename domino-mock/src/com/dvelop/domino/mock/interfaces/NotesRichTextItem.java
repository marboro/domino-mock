package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

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

	public abstract void addNewLine(int arg0, boolean arg1)
			throws NotesApiException;

	public abstract void addNewLine(int arg0) throws NotesApiException;

	public abstract void addNewLine() throws NotesApiException;

	public abstract void addTab(int arg0) throws NotesApiException;

	public abstract void addTab() throws NotesApiException;

	public abstract void addPageBreak() throws NotesApiException;

	public abstract void addPageBreak(NotesRichTextParagraphStyle arg0)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDocument arg0, String arg1)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDocument arg0)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase arg0, String arg1)
			throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase arg0)
			throws NotesApiException;

	public abstract void appendDocLink(NotesView arg0, String arg1)
			throws NotesApiException;

	public abstract void appendDocLink(NotesView arg0) throws NotesApiException;

	public abstract void appendDocLink(NotesDocument arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract void appendDocLink(NotesDatabase arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract void appendDocLink(NotesView arg0, String arg1, String arg2)
			throws NotesApiException;

	public abstract void appendRTItem(NotesRichTextItem arg0)
			throws NotesApiException;

	public abstract void appendStyle(NotesRichTextStyle arg0)
			throws NotesApiException;

	public abstract void appendParagraphStyle(NotesRichTextParagraphStyle arg0)
			throws NotesApiException;

	public abstract void appendText(String arg0) throws NotesApiException;

	public abstract NotesEmbeddedObject embedObject(int arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract NotesEmbeddedObject getEmbeddedObject(String arg0)
			throws NotesApiException;

	public abstract Vector getEmbeddedObjects() throws NotesApiException;

	public abstract String getFormattedText(boolean arg0, int arg1, int arg2)
			throws NotesApiException;

	public abstract void appendTable(int arg0, int arg1)
			throws NotesApiException;

	public abstract void appendTable(int arg0, int arg1, Vector arg2)
			throws NotesApiException;

	public abstract void appendTable(int arg0, int arg1, Vector arg2, int arg3,
			Vector arg4) throws NotesApiException;

	public abstract void beginInsert(NotesBase arg0) throws NotesApiException;

	public abstract void beginInsert(NotesBase arg0, boolean arg1)
			throws NotesApiException;

	public abstract void endInsert() throws NotesApiException;

	public abstract NotesRichTextNavigator createNavigator()
			throws NotesApiException;

	public abstract NotesRichTextRange createRange() throws NotesApiException;

	public abstract int getNotesFont(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void beginSection(String arg0) throws NotesApiException;

	public abstract void beginSection(String arg0, NotesRichTextStyle arg1)
			throws NotesApiException;

	public abstract void beginSection(String arg0, NotesRichTextStyle arg1,
			NotesColorObject arg2, boolean arg3) throws NotesApiException;

	public abstract void endSection() throws NotesApiException;

	public abstract void update() throws NotesApiException;

	public abstract void compact() throws NotesApiException;

	public abstract String getUnformattedText() throws NotesApiException;
}
