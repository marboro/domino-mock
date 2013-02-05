package com.dvelop.domino.mock.impl.mock;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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

public class NotesSessionMockImpl extends NotesBaseMockImpl implements
		NotesSession {

	@Override
	public NotesDateRange createDateRange() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateRange createDateRange(NotesDateTime arg0, NotesDateTime arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateRange createDateRange(Date arg0, Date arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime createDateTime(Date arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime createDateTime(Calendar arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime createDateTime(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesLog createLog(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesName createName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesName createName(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesNewsletter createNewsletter(NotesDocumentCollection arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRegistration createRegistration() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextStyle createRichTextStyle() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextParagraphStyle createRichTextParagraphStyle()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesStream createStream() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDxlExporter createDxlExporter() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDxlImporter createDxlImporter() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesColorObject createColorObject() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesAdministrationProcess createAdministrationProcess(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector evaluate(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector evaluate(String arg0, NotesDocument arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector freeTimeSearch(NotesDateRange arg0, int arg1, Object arg2,
			boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAddressBooks() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesAgentContext getAgentContext() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommonUserName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConvertMime() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConvertMIME() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setConvertMime(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConvertMIME(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDatabase getDatabase(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getDatabase(String arg0, String arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDbDirectory getDbDirectory(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvironmentString(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnvironmentString(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEnvironmentValue(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnvironmentVar(String arg0, Object arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnvironmentVar(String arg0, Object arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesInternational getInternational() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesVersion() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlatform() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
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
	public NotesBase resolve(String arg0) throws NotesApiException {
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
	public String getSessionToken(String arg0) throws NotesApiException {
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
	public String sendConsoleCommand(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getUserPolicySettings(String arg0, String arg1,
			int arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getUserPolicySettings(String arg0, String arg1,
			int arg2, String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hashPassword(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyPassword(String arg0, String arg1)
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
	public NotesDirectory getDirectory(String arg0) throws NotesApiException {
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
	public boolean resetUserPassword(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetUserPassword(String arg0, String arg1, String arg2,
			int arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}
}