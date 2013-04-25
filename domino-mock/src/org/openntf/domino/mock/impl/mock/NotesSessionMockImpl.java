package org.openntf.domino.mock.impl.mock;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesAdministrationProcess;
import org.openntf.domino.mock.interfaces.NotesAgentContext;
import org.openntf.domino.mock.interfaces.NotesBase;
import org.openntf.domino.mock.interfaces.NotesColorObject;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateRange;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDbDirectory;
import org.openntf.domino.mock.interfaces.NotesDirectory;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesDxlExporter;
import org.openntf.domino.mock.interfaces.NotesDxlImporter;
import org.openntf.domino.mock.interfaces.NotesInternational;
import org.openntf.domino.mock.interfaces.NotesLog;
import org.openntf.domino.mock.interfaces.NotesName;
import org.openntf.domino.mock.interfaces.NotesNewsletter;
import org.openntf.domino.mock.interfaces.NotesPropertyBroker;
import org.openntf.domino.mock.interfaces.NotesRegistration;
import org.openntf.domino.mock.interfaces.NotesRichTextParagraphStyle;
import org.openntf.domino.mock.interfaces.NotesRichTextStyle;
import org.openntf.domino.mock.interfaces.NotesSession;
import org.openntf.domino.mock.interfaces.NotesStream;

/**
 * Mock-Implementation of NotesSession
 * 
 * @author Sven Dreher
 * @see NotesSession
 */
public class NotesSessionMockImpl extends NotesBaseMockImpl implements
		NotesSession {

	private Vector addressBooks;
	private String commonUserName;
	private boolean isConvertMime;
	private String notesVersion;
	private String platform;
	private String serverName;

	@Override
	public NotesDateRange createDateRange() throws NotesApiException {
		return createDateRange(new Date(), new Date());
	}

	@Override
	public NotesDateRange createDateRange(NotesDateTime startt,
			NotesDateTime endt) throws NotesApiException {
		if (startt == null)
			throw new NotesApiException(new IllegalArgumentException(
					"Missing start time"));
		if (endt == null)
			throw new NotesApiException(new IllegalArgumentException(
					"Missing end time"));
		return new NotesDateRangeMockImpl(startt, endt, this);
	}

	@Override
	public NotesDateRange createDateRange(Date startt, Date endt)
			throws NotesApiException {
		return createDateRange(new NotesDateTimeMockImpl(startt, this),
				new NotesDateTimeMockImpl(endt, this));
	}

	@Override
	public NotesDateTime createDateTime(Date date) throws NotesApiException {
		return createDateTime(date);
	}

	@Override
	public NotesDateTime createDateTime(Calendar date) throws NotesApiException {
		return new NotesDateTimeMockImpl(date, this);
	}

	@Override
	public NotesDateTime createDateTime(String date) throws NotesApiException {
		return createDateTime(new Date(date));
	}

	@Override
	public NotesLog createLog(String name) throws NotesApiException {
		return new NotesLogMockImpl(name, this);
	}

	@Override
	public NotesName createName(String name) throws NotesApiException {
		return createName(name, null);
	}

	@Override
	public NotesName createName(String name, String lang)
			throws NotesApiException {
		return new NotesNameMockImpl(name, lang, this);
	}

	@Override
	public NotesNewsletter createNewsletter(NotesDocumentCollection collection)
			throws NotesApiException {
		return new NotesNewsletterMockImpl(collection, this);
	}

	@Override
	public NotesRegistration createRegistration() throws NotesApiException {
		return new NotesRegistrationMockImpl(this);
	}

	@Override
	public NotesRichTextStyle createRichTextStyle() throws NotesApiException {
		return new NotesRichTextStyleMockImpl(this);
	}

	@Override
	public NotesRichTextParagraphStyle createRichTextParagraphStyle()
			throws NotesApiException {
		return new NotesRichTextParagraphStyleMockImpl(this);
	}

	@Override
	public NotesStream createStream() throws NotesApiException {
		return new NotesStreamMockImpl(this);
	}

	@Override
	public NotesDxlExporter createDxlExporter() throws NotesApiException {
		return new NotesDxlExporterMockImpl();
	}

	@Override
	public NotesDxlImporter createDxlImporter() throws NotesApiException {
		return new NotesDxlImporterMockImpl();
	}

	@Override
	public NotesColorObject createColorObject() throws NotesApiException {
		return new NotesColorObjectMockImpl();
	}

	@Override
	public NotesAdministrationProcess createAdministrationProcess(String server)
			throws NotesApiException {
		return new NotesAdministrationProcessMockImpl(server, this);
	}

	@Override
	public Vector evaluate(String formula) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector evaluate(String formula, NotesDocument doc)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector freeTimeSearch(NotesDateRange window, int duration,
			Object names, boolean firstfit) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAddressBooks() throws NotesApiException {
		return addressBooks;
	}

	@Override
	public NotesAgentContext getAgentContext() throws NotesApiException {
		return new NotesAgentContextMockImpl();
	}

	@Override
	public String getCommonUserName() throws NotesApiException {
		return commonUserName;
	}

	@Override
	public boolean isConvertMime() throws NotesApiException {
		return isConvertMime;
	}

	@Override
	public boolean isConvertMIME() throws NotesApiException {
		return isConvertMime();
	}

	@Override
	public void setConvertMime(boolean flag) throws NotesApiException {
		isConvertMime = flag;
	}

	@Override
	public void setConvertMIME(boolean flag) throws NotesApiException {
		setConvertMime(flag);
	}

	@Override
	public NotesDatabase getDatabase(String server, String db)
			throws NotesApiException {
		return getDatabase(server, db, true);
	}

	@Override
	public NotesDatabase getDatabase(String server, String db,
			boolean createonfail) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDbDirectory getDbDirectory(String server)
			throws NotesApiException {
		return new NotesDbDirectoryMockImpl(server, this);
	}

	@Override
	public String getEnvironmentString(String vname) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvironmentString(String vname, boolean issystem)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String vname) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String vname, boolean issystem)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnvironmentVar(String vname, Object value)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnvironmentVar(String vname, Object value, boolean issystem)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesInternational getInternational() throws NotesApiException {
		return new NotesInternationalMockImpl(this);
	}

	@Override
	public String getNotesVersion() throws NotesApiException {
		return notesVersion;
	}

	@Override
	public String getPlatform() throws NotesApiException {
		return platform;
	}

	@Override
	public String getServerName() throws NotesApiException {
		return serverName;
	}

	@Override
	public NotesDatabase getURLDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectiveUserName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesName getUserNameObject() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOnServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesBase resolve(String url) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getUserNameList() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSessionToken() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSessionToken(String serverName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOrgDirectoryPath() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getCurrentDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector getUserGroupNameList() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendConsoleCommand(String servername, String consolecommand)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getUserPolicySettings(String server, String name,
			int type) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getUserPolicySettings(String server, String name,
			int type, String explicitpolicy) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hashPassword(String password) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyPassword(String password, String hashedpassword)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesPropertyBroker getPropertyBroker() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectory getDirectory() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectory getDirectory(String server) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTrustedSession() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRestricted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetUserPassword(String servername, String username,
			String password) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetUserPassword(String servername, String username,
			String password, int downloadcount) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

}