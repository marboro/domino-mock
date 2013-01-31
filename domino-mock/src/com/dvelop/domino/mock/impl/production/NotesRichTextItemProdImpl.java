package com.dvelop.domino.mock.impl.production;

import java.util.Iterator;
import java.util.Vector;

import lotus.domino.EmbeddedObject;
import lotus.domino.NotesException;
import lotus.domino.RichTextItem;

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

public class NotesRichTextItemProdImpl extends NotesItemProdImpl implements
		NotesRichTextItem {

	private final RichTextItem richTextItem;

	public NotesRichTextItemProdImpl(RichTextItem richTextItem) {
		super();
		this.richTextItem = richTextItem;

	}

	public RichTextItem get() {
		return richTextItem;
	}

	@Override
	public void addNewLine(int arg0, boolean arg1) throws NotesApiException {
		try {
			richTextItem.addNewLine(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addNewLine(int arg0) throws NotesApiException {
		try {
			richTextItem.addNewLine(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addNewLine() throws NotesApiException {
		try {
			richTextItem.addNewLine();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addTab(int arg0) throws NotesApiException {
		try {
			richTextItem.addTab(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addTab() throws NotesApiException {
		try {
			richTextItem.addTab();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addPageBreak() throws NotesApiException {
		try {
			richTextItem.addPageBreak();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addPageBreak(NotesRichTextParagraphStyle arg0)
			throws NotesApiException {
		try {
			richTextItem
					.addPageBreak(((NotesRichTextParagraphStyleProdImpl) arg0)
							.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDocument arg0, String arg1)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDocumentProdImpl) arg0).get(),
					arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDocument arg0) throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDocumentProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDatabase arg0, String arg1)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDatabaseProdImpl) arg0).get(),
					arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDatabase arg0) throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDatabaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesView arg0, String arg1)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesViewProdImpl) arg0).get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesView arg0) throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesViewProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDocument arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDocumentProdImpl) arg0).get(),
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesDatabase arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesDatabaseProdImpl) arg0).get(),
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendDocLink(NotesView arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			richTextItem.appendDocLink(((NotesViewProdImpl) arg0).get(), arg1,
					arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendRTItem(NotesRichTextItem arg0) throws NotesApiException {
		try {
			richTextItem.appendRTItem(((NotesRichTextItemProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendStyle(NotesRichTextStyle arg0) throws NotesApiException {
		try {
			richTextItem.appendStyle(((NotesRichTextStyleProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendParagraphStyle(NotesRichTextParagraphStyle arg0)
			throws NotesApiException {
		try {
			richTextItem
					.appendParagraphStyle(((NotesRichTextParagraphStyleProdImpl) arg0)
							.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendText(String arg0) throws NotesApiException {
		try {
			richTextItem.appendText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesEmbeddedObject embedObject(int arg0, String arg1, String arg2,
			String arg3) throws NotesApiException {
		try {
			return new NotesEmbeddedObjectProdImpl(richTextItem.embedObject(
					arg0, arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesEmbeddedObject getEmbeddedObject(String arg0)
			throws NotesApiException {
		try {
			return new NotesEmbeddedObjectProdImpl(
					richTextItem.getEmbeddedObject(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getEmbeddedObjects() throws NotesApiException {
		try {
			Vector embeddedObjects = richTextItem.getEmbeddedObjects();
			Vector<NotesEmbeddedObject> vector = new Vector<NotesEmbeddedObject>();
			if (embeddedObjects.size() > 0) {
				if (embeddedObjects.get(0) instanceof EmbeddedObject) {
					Iterator iterator = embeddedObjects.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesEmbeddedObjectProdImpl(
								(EmbeddedObject) iterator.next()));
					}
					return vector;
				}
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFormattedText(boolean arg0, int arg1, int arg2)
			throws NotesApiException {
		try {
			return richTextItem.getFormattedText(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendTable(int arg0, int arg1) throws NotesApiException {
		try {
			richTextItem.appendTable(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendTable(int arg0, int arg1, Vector arg2)
			throws NotesApiException {
		try {
			richTextItem.appendTable(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void appendTable(int arg0, int arg1, Vector arg2, int arg3,
			Vector arg4) throws NotesApiException {
		try {
			richTextItem.appendTable(arg0, arg1, arg2, arg3, arg4);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void beginInsert(NotesBase arg0) throws NotesApiException {
		try {
			richTextItem.beginInsert(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void beginInsert(NotesBase arg0, boolean arg1)
			throws NotesApiException {
		try {
			richTextItem.beginInsert(((NotesBaseProdImpl) arg0).get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void endInsert() throws NotesApiException {
		try {
			richTextItem.endInsert();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextNavigator createNavigator() throws NotesApiException {
		try {
			return new NotesRichTextNavigatorProdImpl(
					richTextItem.createNavigator());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextRange createRange() throws NotesApiException {
		try {
			return new NotesRichTextRangeProdImpl(richTextItem.createRange());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNotesFont(String arg0, boolean arg1) throws NotesApiException {
		try {
			return richTextItem.getNotesFont(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void beginSection(String arg0) throws NotesApiException {
		try {
			richTextItem.beginSection(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void beginSection(String arg0, NotesRichTextStyle arg1)
			throws NotesApiException {
		try {
			richTextItem.beginSection(arg0,
					((NotesRichTextStyleProdImpl) arg1).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void beginSection(String arg0, NotesRichTextStyle arg1,
			NotesColorObject arg2, boolean arg3) throws NotesApiException {
		try {
			richTextItem.beginSection(arg0,
					((NotesRichTextStyleProdImpl) arg1).get(),
					((NotesColorObjectProdImpl) arg2).get(), arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void endSection() throws NotesApiException {
		try {
			richTextItem.endSection();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void update() throws NotesApiException {
		try {
			richTextItem.update();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void compact() throws NotesApiException {
		try {
			richTextItem.compact();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getUnformattedText() throws NotesApiException {
		try {
			return richTextItem.getUnformattedText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}