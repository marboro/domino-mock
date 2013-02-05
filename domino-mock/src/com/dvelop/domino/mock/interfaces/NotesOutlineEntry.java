package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesOutlineEntry extends NotesBase {
	public static final int OUTLINE_OTHER_VIEWS_TYPE = 1588;
	public static final int OUTLINE_OTHER_FOLDERS_TYPE = 1589;
	public static final int OUTLINE_OTHER_UNKNOWN_TYPE = 1591;
	public static final int OUTLINE_TYPE_URL = 2185;
	public static final int OUTLINE_TYPE_NOTELINK = 2186;
	public static final int OUTLINE_TYPE_NAMEDELEMENT = 2187;
	public static final int OUTLINE_TYPE_ACTION = 2188;
	public static final int OUTLINE_CLASS_UNKNOWN = 2189;
	public static final int OUTLINE_CLASS_DOCUMENT = 2190;
	public static final int OUTLINE_CLASS_VIEW = 2191;
	public static final int OUTLINE_CLASS_FORM = 2192;
	public static final int OUTLINE_CLASS_NAVIGATOR = 2193;
	public static final int OUTLINE_CLASS_DATABASE = 2194;
	public static final int OUTLINE_CLASS_FRAMESET = 2195;
	public static final int OUTLINE_CLASS_PAGE = 2196;
	public static final int OUTLINE_CLASS_FOLDER = 2197;

	public abstract boolean setNoteLink(NotesDatabase db)
			throws NotesApiException;

	public abstract boolean setNoteLink(NotesView doc)
			throws NotesApiException;

	public abstract boolean setNoteLink(NotesDocument view)
			throws NotesApiException;

	public abstract boolean setURL(String url) throws NotesApiException;

	public abstract boolean setNamedElement(NotesDatabase db, String elementName,
			int entryClass) throws NotesApiException;

	public abstract boolean setAction(String formula) throws NotesApiException;

	public abstract NotesDatabase getDatabase() throws NotesApiException;

	public abstract NotesView getView() throws NotesApiException;

	public abstract NotesDocument getDocument() throws NotesApiException;

	public abstract String getNamedElement() throws NotesApiException;

	public abstract String getFormula() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract boolean hasChildren() throws NotesApiException;

	public abstract boolean isInThisDB() throws NotesApiException;

	public abstract boolean isHidden() throws NotesApiException;

	public abstract boolean isHiddenFromNotes() throws NotesApiException;

	public abstract boolean isHiddenFromWeb() throws NotesApiException;

	public abstract boolean isPrivate() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract int getEntryClass() throws NotesApiException;

	public abstract String getLabel() throws NotesApiException;

	public abstract String getImagesText() throws NotesApiException;

	public abstract String getFrameText() throws NotesApiException;

	public abstract int getLevel() throws NotesApiException;

	public abstract String getAlias() throws NotesApiException;

	public abstract boolean getKeepSelectionFocus() throws NotesApiException;

	public abstract boolean getUseHideFormula() throws NotesApiException;

	public abstract String getHideFormula() throws NotesApiException;

	public abstract NotesOutline getParent() throws NotesApiException;

	public abstract void setHidden(boolean value) throws NotesApiException;

	public abstract void setHiddenFromNotes(boolean value)
			throws NotesApiException;

	public abstract void setHiddenFromWeb(boolean value)
			throws NotesApiException;

	public abstract void setLabel(String value) throws NotesApiException;

	public abstract void setAlias(String value) throws NotesApiException;

	public abstract void setImagesText(String value) throws NotesApiException;

	public abstract void setFrameText(String value) throws NotesApiException;

	public abstract void setKeepSelectionFocus(boolean value)
			throws NotesApiException;

	public abstract void setUseHideFormula(boolean value)
			throws NotesApiException;

	public abstract void setHideFormula(String value) throws NotesApiException;
}
