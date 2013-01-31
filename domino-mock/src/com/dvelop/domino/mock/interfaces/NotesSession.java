package com.dvelop.domino.mock.interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesSession extends NotesBase {
	public static final int POLICYSETTINGS_ARCHIVE = 2;
	public static final int POLICYSETTINGS_DESKTOP = 4;
	public static final int POLICYSETTINGS_REGISTRATION = 0;
	public static final int POLICYSETTINGS_SECURITY = 3;
	public static final int POLICYSETTINGS_SETUP = 1;
	public static final int POLICYSETTINGS_MAIL = 5;

	public abstract NotesDateRange createDateRange() throws NotesApiException;

	public abstract NotesDateRange createDateRange(NotesDateTime arg0,
			NotesDateTime arg1) throws NotesApiException;

	public abstract NotesDateRange createDateRange(Date arg0, Date arg1)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(Date arg0)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(Calendar arg0)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(String arg0)
			throws NotesApiException;

	public abstract NotesLog createLog(String arg0) throws NotesApiException;

	public abstract NotesName createName(String arg0) throws NotesApiException;

	public abstract NotesName createName(String arg0, String arg1)
			throws NotesApiException;

	public abstract NotesNewsletter createNewsletter(
			NotesDocumentCollection arg0) throws NotesApiException;

	public abstract NotesRegistration createRegistration()
			throws NotesApiException;

	public abstract NotesRichTextStyle createRichTextStyle()
			throws NotesApiException;

	public abstract NotesRichTextParagraphStyle createRichTextParagraphStyle()
			throws NotesApiException;

	public abstract NotesStream createStream() throws NotesApiException;

	public abstract NotesDxlExporter createDxlExporter()
			throws NotesApiException;

	public abstract NotesDxlImporter createDxlImporter()
			throws NotesApiException;

	public abstract NotesColorObject createColorObject()
			throws NotesApiException;

	public abstract NotesAdministrationProcess createAdministrationProcess(
			String arg0) throws NotesApiException;

	public abstract Vector evaluate(String arg0) throws NotesApiException;

	public abstract Vector evaluate(String arg0, NotesDocument arg1)
			throws NotesApiException;

	public abstract Vector freeTimeSearch(NotesDateRange arg0, int arg1,
			Object arg2, boolean arg3) throws NotesApiException;

	public abstract Vector getAddressBooks() throws NotesApiException;

	public abstract NotesAgentContext getAgentContext()
			throws NotesApiException;

	public abstract String getCommonUserName() throws NotesApiException;

	public abstract boolean isConvertMime() throws NotesApiException;

	public abstract boolean isConvertMIME() throws NotesApiException;

	public abstract void setConvertMime(boolean arg0) throws NotesApiException;

	public abstract void setConvertMIME(boolean arg0) throws NotesApiException;

	public abstract NotesDatabase getDatabase(String arg0, String arg1)
			throws NotesApiException;

	public abstract NotesDatabase getDatabase(String arg0, String arg1,
			boolean arg2) throws NotesApiException;

	public abstract NotesDbDirectory getDbDirectory(String arg0)
			throws NotesApiException;

	public abstract String getEnvironmentString(String arg0)
			throws NotesApiException;

	public abstract String getEnvironmentString(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract Object getEnvironmentValue(String arg0)
			throws NotesApiException;

	public abstract Object getEnvironmentValue(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void setEnvironmentVar(String arg0, Object arg1)
			throws NotesApiException;

	public abstract void setEnvironmentVar(String arg0, Object arg1,
			boolean arg2) throws NotesApiException;

	public abstract NotesInternational getInternational()
			throws NotesApiException;

	public abstract String getNotesVersion() throws NotesApiException;

	public abstract String getPlatform() throws NotesApiException;

	public abstract String getServerName() throws NotesApiException;

	public abstract NotesDatabase getURLDatabase() throws NotesApiException;

	public abstract String getUserName() throws NotesApiException;

	public abstract String getEffectiveUserName() throws NotesApiException;

	public abstract NotesName getUserNameObject() throws NotesApiException;

	public abstract boolean isOnServer() throws NotesApiException;

	public abstract NotesBase resolve(String arg0) throws NotesApiException;

	public abstract Vector getUserNameList() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract String getSessionToken() throws NotesApiException;

	public abstract String getSessionToken(String arg0)
			throws NotesApiException;

	public abstract Object getCredentials() throws NotesApiException;

	public abstract String getOrgDirectoryPath() throws NotesApiException;

	public abstract NotesDatabase getCurrentDatabase() throws NotesApiException;

	public abstract boolean isValid();

	public abstract Vector getUserGroupNameList() throws NotesApiException;

	public abstract String sendConsoleCommand(String arg0, String arg1)
			throws NotesApiException;

	public abstract NotesDocument getUserPolicySettings(String arg0,
			String arg1, int arg2) throws NotesApiException;

	public abstract NotesDocument getUserPolicySettings(String arg0,
			String arg1, int arg2, String arg3) throws NotesApiException;

	public abstract String hashPassword(String arg0) throws NotesApiException;

	public abstract boolean verifyPassword(String arg0, String arg1)
			throws NotesApiException;

	public abstract NotesPropertyBroker getPropertyBroker()
			throws NotesApiException;

	public abstract NotesDirectory getDirectory() throws NotesApiException;

	public abstract NotesDirectory getDirectory(String arg0)
			throws NotesApiException;

	public abstract boolean isTrustedSession() throws NotesApiException;

	public abstract boolean isRestricted() throws NotesApiException;

	public abstract boolean resetUserPassword(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract boolean resetUserPassword(String arg0, String arg1,
			String arg2, int arg3) throws NotesApiException;
}
