package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesColorObject;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesEmbeddedObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesRichTextNavigator;
import com.dvelop.domino.mock.interfaces.NotesRichTextParagraphStyle;
import com.dvelop.domino.mock.interfaces.NotesRichTextRange;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;
import com.dvelop.domino.mock.interfaces.NotesView;

public class NotesRichTextItemMockImpl extends NotesItemMockImpl implements
		NotesRichTextItem {

	private Vector<NotesEmbeddedObject> embeddedObjects;

	public NotesRichTextItemMockImpl(String name) {
		super(name);
		embeddedObjects = new Vector();
	}

	@Override
	public void addNewLine(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewLine(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewLine() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTab(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTab() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPageBreak() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPageBreak(NotesRichTextParagraphStyle arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDocument arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDatabase arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDatabase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesView arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesView arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDocument arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesDatabase arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendDocLink(NotesView arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendRTItem(NotesRichTextItem arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendStyle(NotesRichTextStyle arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendParagraphStyle(NotesRichTextParagraphStyle arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendText(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesEmbeddedObject embedObject(int arg0, String arg1, String arg2,
			String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<NotesEmbeddedObject> getEmbeddedObjects()
			throws NotesApiException {
		return embeddedObjects;
	}

	@Override
	public String getFormattedText(boolean arg0, int arg1, int arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendTable(int arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendTable(int arg0, int arg1, Vector arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendTable(int arg0, int arg1, Vector arg2, int arg3,
			Vector arg4) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beginInsert(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beginInsert(NotesBase arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endInsert() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesRichTextNavigator createNavigator() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextRange createRange() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNotesFont(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void beginSection(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beginSection(String arg0, NotesRichTextStyle arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beginSection(String arg0, NotesRichTextStyle arg1,
			NotesColorObject arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endSection() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void compact() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUnformattedText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeEmbeddedObject(NotesEmbeddedObject embeddedObject) {
		embeddedObjects.remove(embeddedObject);
	}

	@Override
	public NotesEmbeddedObject getEmbeddedObject(String name)
			throws NotesApiException {
		for (NotesEmbeddedObject embeddedObject : embeddedObjects) {
			if (name.equalsIgnoreCase(embeddedObject.getName())) {
				return embeddedObject;
			}
		}
		return null;
	}
}