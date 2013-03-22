package org.openntf.domino.mock.interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesSession extends NotesBase {
	public static final int POLICYSETTINGS_ARCHIVE = 2;
	public static final int POLICYSETTINGS_DESKTOP = 4;
	public static final int POLICYSETTINGS_REGISTRATION = 0;
	public static final int POLICYSETTINGS_SECURITY = 3;
	public static final int POLICYSETTINGS_SETUP = 1;
	public static final int POLICYSETTINGS_MAIL = 5;

	public abstract NotesDateRange createDateRange() throws NotesApiException;

	public abstract NotesDateRange createDateRange(NotesDateTime startt,
			NotesDateTime endt) throws NotesApiException;

	public abstract NotesDateRange createDateRange(Date startt, Date endt)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(Date date)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(Calendar date)
			throws NotesApiException;

	public abstract NotesDateTime createDateTime(String date)
			throws NotesApiException;

	public abstract NotesLog createLog(String name) throws NotesApiException;

	public abstract NotesName createName(String name) throws NotesApiException;

	public abstract NotesName createName(String name, String lang)
			throws NotesApiException;

	public abstract NotesNewsletter createNewsletter(
			NotesDocumentCollection collection) throws NotesApiException;

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
			String server) throws NotesApiException;

	public abstract Vector evaluate(String formula) throws NotesApiException;

	public abstract Vector evaluate(String formula, NotesDocument doc)
			throws NotesApiException;

	public abstract Vector freeTimeSearch(NotesDateRange window, int duration,
			Object names, boolean firstfit) throws NotesApiException;

	public abstract Vector getAddressBooks() throws NotesApiException;

	public abstract NotesAgentContext getAgentContext()
			throws NotesApiException;

	public abstract String getCommonUserName() throws NotesApiException;

	public abstract boolean isConvertMime() throws NotesApiException;

	public abstract boolean isConvertMIME() throws NotesApiException;

	public abstract void setConvertMime(boolean flag) throws NotesApiException;

	public abstract void setConvertMIME(boolean flag) throws NotesApiException;

	public abstract NotesDatabase getDatabase(String server, String db)
			throws NotesApiException;

	public abstract NotesDatabase getDatabase(String server, String db,
			boolean createonfail) throws NotesApiException;

	public abstract NotesDbDirectory getDbDirectory(String server)
			throws NotesApiException;

	public abstract String getEnvironmentString(String vname)
			throws NotesApiException;

	public abstract String getEnvironmentString(String vname, boolean issystem)
			throws NotesApiException;

	public abstract Object getEnvironmentValue(String vname)
			throws NotesApiException;

	public abstract Object getEnvironmentValue(String vname, boolean issystem)
			throws NotesApiException;

	public abstract void setEnvironmentVar(String vname, Object value)
			throws NotesApiException;

	public abstract void setEnvironmentVar(String vname, Object value,
			boolean issystem) throws NotesApiException;

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

	public abstract NotesBase resolve(String url) throws NotesApiException;

	public abstract Vector getUserNameList() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract String getSessionToken() throws NotesApiException;

	public abstract String getSessionToken(String serverName)
			throws NotesApiException;

	public abstract Object getCredentials() throws NotesApiException;

	public abstract String getOrgDirectoryPath() throws NotesApiException;

	public abstract NotesDatabase getCurrentDatabase() throws NotesApiException;

	public abstract boolean isValid();

	public abstract Vector getUserGroupNameList() throws NotesApiException;

	public abstract String sendConsoleCommand(String servername,
			String consolecommand) throws NotesApiException;

	public abstract NotesDocument getUserPolicySettings(String server,
			String name, int type) throws NotesApiException;

	public abstract NotesDocument getUserPolicySettings(String server,
			String name, int type, String explicitpolicy)
			throws NotesApiException;

	public abstract String hashPassword(String password)
			throws NotesApiException;

	public abstract boolean verifyPassword(String password,
			String hashedpassword) throws NotesApiException;

	public abstract NotesPropertyBroker getPropertyBroker()
			throws NotesApiException;

	public abstract NotesDirectory getDirectory() throws NotesApiException;

	public abstract NotesDirectory getDirectory(String server)
			throws NotesApiException;

	public abstract boolean isTrustedSession() throws NotesApiException;

	public abstract boolean isRestricted() throws NotesApiException;

	public abstract boolean resetUserPassword(String servername,
			String username, String password) throws NotesApiException;

	public abstract boolean resetUserPassword(String servername,
			String username, String password, int downloadcount)
			throws NotesApiException;
}
