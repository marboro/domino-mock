package com.dvelop.domino.mock.impl.production;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import lotus.domino.NotesException;
import lotus.domino.Session;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAdministrationProcess;
import com.dvelop.domino.mock.interfaces.NotesAgentContext;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesColorObject;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateRange;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDbDirectory;
import com.dvelop.domino.mock.interfaces.NotesDirectory;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesDxlExporter;
import com.dvelop.domino.mock.interfaces.NotesDxlImporter;
import com.dvelop.domino.mock.interfaces.NotesInternational;
import com.dvelop.domino.mock.interfaces.NotesLog;
import com.dvelop.domino.mock.interfaces.NotesName;
import com.dvelop.domino.mock.interfaces.NotesNewsletter;
import com.dvelop.domino.mock.interfaces.NotesPropertyBroker;
import com.dvelop.domino.mock.interfaces.NotesRegistration;
import com.dvelop.domino.mock.interfaces.NotesRichTextParagraphStyle;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;
import com.dvelop.domino.mock.interfaces.NotesSession;
import com.dvelop.domino.mock.interfaces.NotesStream;

public class NotesSessionProdImpl extends NotesBaseProdImpl implements
		NotesSession {

	private final Session session;

	NotesSessionProdImpl(Session session) {
		this.session = session;

	}

	@Override
	public NotesDateRange createDateRange() throws NotesApiException {
		try {
			return new NotesDateRangeProdImpl(session.createDateRange());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateRange createDateRange(NotesDateTime arg0, NotesDateTime arg1)
			throws NotesApiException {
		NotesDateTimeProdImpl arg0Converted = (NotesDateTimeProdImpl) arg0;
		NotesDateTimeProdImpl arg1Converted = (NotesDateTimeProdImpl) arg1;
		try {
			return new NotesDateRangeProdImpl(session.createDateRange(
					arg0Converted.get(), arg1Converted.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateRange createDateRange(Date arg0, Date arg1)
			throws NotesApiException {
		try {
			return new NotesDateRangeProdImpl(session.createDateRange(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime createDateTime(Date arg0) throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(session.createDateTime(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime createDateTime(Calendar arg0) throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(session.createDateTime(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime createDateTime(String arg0) throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(session.createDateTime(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesLog createLog(String arg0) throws NotesApiException {
		try {
			return new NotesLogProdImpl(session.createLog(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesName createName(String arg0) throws NotesApiException {
		try {
			return new NotesNameProdImpl(session.createName(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesName createName(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesNameProdImpl(session.createName(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesNewsletter createNewsletter(NotesDocumentCollection arg0)
			throws NotesApiException {
		NotesDocumentCollectionProdImpl docCol = (NotesDocumentCollectionProdImpl) arg0;
		try {
			return new NotesNewsletterProdImpl(session.createNewsletter(docCol
					.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRegistration createRegistration() throws NotesApiException {
		try {
			return new NotesRegistrationProdImpl(session.createRegistration());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextStyle createRichTextStyle() throws NotesApiException {
		try {
			return new NotesRichTextStyleProdImpl(session.createRichTextStyle());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextParagraphStyle createRichTextParagraphStyle()
			throws NotesApiException {
		try {
			return new NotesRichTextParagraphStyleProdImpl(
					session.createRichTextParagraphStyle());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesStream createStream() throws NotesApiException {
		try {
			return new NotesStreamProdImpl(session.createStream());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDxlExporter createDxlExporter() throws NotesApiException {
		try {
			return new NotesDxlExporterProdImpl(session.createDxlExporter());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDxlImporter createDxlImporter() throws NotesApiException {
		try {
			return new NotesDxlImporterProdImpl(session.createDxlImporter());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesColorObject createColorObject() throws NotesApiException {
		try {
			return new NotesColorObjectProdImpl(session.createColorObject());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesAdministrationProcess createAdministrationProcess(String arg0)
			throws NotesApiException {
		try {
			return new NotesAdministrationProcessProdImpl(
					session.createAdministrationProcess(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector evaluate(String arg0) throws NotesApiException {
		try {
			return session.evaluate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector evaluate(String arg0, NotesDocument arg1)
			throws NotesApiException {
		NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg1;
		try {
			return session.evaluate(arg0, doc.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector freeTimeSearch(NotesDateRange arg0, int arg1, Object arg2,
			boolean arg3) throws NotesApiException {
		NotesDateRangeProdImpl dateRange = (NotesDateRangeProdImpl) arg0;
		try {
			return session.freeTimeSearch(dateRange.get(), arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAddressBooks() throws NotesApiException {
		try {
			return session.getAddressBooks();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesAgentContext getAgentContext() throws NotesApiException {
		try {
			return new NotesAgentContextProdImpl(session.getAgentContext());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCommonUserName() throws NotesApiException {
		try {
			return session.getCommonUserName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConvertMime() throws NotesApiException {
		try {
			return session.isConvertMime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConvertMIME() throws NotesApiException {
		try {
			return session.isConvertMIME();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setConvertMime(boolean arg0) throws NotesApiException {
		try {
			session.setConvertMime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setConvertMIME(boolean arg0) throws NotesApiException {
		try {
			session.setConvertMime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesDatabase getDatabase(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(session.getDatabase(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getDatabase(String arg0, String arg1, boolean arg2)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(session.getDatabase(arg0, arg1,
					arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDbDirectory getDbDirectory(String arg0)
			throws NotesApiException {
		try {
			return new NotesDbDirectoryProdImpl(session.getDbDirectory(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getEnvironmentString(String arg0) throws NotesApiException {
		try {
			return session.getEnvironmentString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getEnvironmentString(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return session.getEnvironmentString(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getEnvironmentValue(String arg0) throws NotesApiException {
		try {
			return session.getEnvironmentValue(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getEnvironmentValue(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return session.getEnvironmentValue(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEnvironmentVar(String arg0, Object arg1)
			throws NotesApiException {
		try {
			session.setEnvironmentVar(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEnvironmentVar(String arg0, Object arg1, boolean arg2)
			throws NotesApiException {
		try {
			session.setEnvironmentVar(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesInternational getInternational() throws NotesApiException {
		try {
			return new NotesInternationalProdImpl(session.getInternational());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesVersion() throws NotesApiException {
		try {
			return session.getNotesVersion();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPlatform() throws NotesApiException {
		try {
			return session.getPlatform();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getServerName() throws NotesApiException {
		try {
			return session.getServerName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getURLDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(session.getURLDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getUserName() throws NotesApiException {
		try {
			return session.getUserName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getEffectiveUserName() throws NotesApiException {
		try {
			return session.getEffectiveUserName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesName getUserNameObject() throws NotesApiException {
		try {
			return new NotesNameProdImpl(session.getUserNameObject());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isOnServer() throws NotesApiException {
		try {
			return session.isOnServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase resolve(String arg0) throws NotesApiException {
		try {
			return new NotesBaseProdImpl(session.resolve(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getUserNameList() throws NotesApiException {
		try {
			return session.getUserNameList();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return session.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return session.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSessionToken() throws NotesApiException {
		try {
			return session.getSessionToken();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSessionToken(String arg0) throws NotesApiException {
		try {
			return session.getSessionToken(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getCredentials() throws NotesApiException {
		try {
			return session.getCredentials();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrgDirectoryPath() throws NotesApiException {
		try {
			return session.getOrgDirectoryPath();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getCurrentDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(session.getCurrentDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isValid() {
		return session.isValid();
	}

	@Override
	public Vector getUserGroupNameList() throws NotesApiException {
		try {
			return session.getUserGroupNameList();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String sendConsoleCommand(String arg0, String arg1)
			throws NotesApiException {
		try {
			return session.sendConsoleCommand(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getUserPolicySettings(String arg0, String arg1,
			int arg2) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(session.getUserPolicySettings(
					arg0, arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getUserPolicySettings(String arg0, String arg1,
			int arg2, String arg3) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(session.getUserPolicySettings(
					arg0, arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String hashPassword(String arg0) throws NotesApiException {
		try {
			return session.hashPassword(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean verifyPassword(String arg0, String arg1)
			throws NotesApiException {
		try {
			return session.verifyPassword(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesPropertyBroker getPropertyBroker() throws NotesApiException {
		try {
			return new NotesPropertyBrokerProdImpl(session.getPropertyBroker());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectory getDirectory() throws NotesApiException {
		try {
			return new NotesDirectoryProdImpl(session.getDirectory());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectory getDirectory(String arg0) throws NotesApiException {
		try {
			return new NotesDirectoryProdImpl(session.getDirectory(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isTrustedSession() throws NotesApiException {
		try {
			return session.isTrustedSession();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isRestricted() throws NotesApiException {
		try {
			return session.isRestricted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean resetUserPassword(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return session.resetUserPassword(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean resetUserPassword(String arg0, String arg1, String arg2,
			int arg3) throws NotesApiException {
		try {
			return session.resetUserPassword(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}