package org.openntf.domino.mock.impl.mock;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesRegistration;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesRegistrationMockImpl extends NotesBaseMockImpl implements
		NotesRegistration {

	private final NotesSession parent;

	public NotesRegistrationMockImpl(NotesSession parent) {
		this.parent = parent;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCertifierIDFile() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCertifierIDFile(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getCreateMailDb() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCreateMailDb(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDateTime getExpiration() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExpiration(NotesDateTime arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getIDType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIDType(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMinPasswordLength() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMinPasswordLength(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOrgUnit() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrgUnit(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRegistrationLog() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRegistrationLog(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRegistrationServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRegistrationServer(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getStoreIDInAddressBook() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setStoreIDInAddressBook(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNorthAmerican() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setNorthAmerican(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getUpdateAddressBook() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUpdateAddressBook(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getAltOrgUnit() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAltOrgUnit(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getAltOrgUnitLang() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAltOrgUnitLang(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCertifierName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCertifierName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMailACLManager() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMailACLManager(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMailInternetAddress() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMailInternetAddress(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMailTemplateName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMailTemplateName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPolicyName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPolicyName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRoamingServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoamingServer(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRoamingSubdir() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoamingSubdir(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getShortName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShortName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnforceUniqueShortName() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnforceUniqueShortName(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRoamingUser() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRoamingUser(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMailCreateFTIndex() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMailCreateFTIndex(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNoIDFile() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setNoIDFile(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStoreIDInMailfile() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setStoreIDInMailfile(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSynchInternetPassword() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSynchInternetPassword(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUseCertificateAuthority() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUseCertificateAuthority(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMailQuotaSizeLimit() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMailQuotaSizeLimit(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMailQuotaWarningThreshold() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMailQuotaWarningThreshold(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMailOwnerAccess() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMailOwnerAccess(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMailSystem() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMailSystem(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRoamingCleanupPeriod() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRoamingCleanupPeriod(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRoamingCleanupSetting() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRoamingCleanupSetting(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getGroupList() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGroupList(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getMailReplicaServers() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMailReplicaServers(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPublicKeySize() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPublicKeySize(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addCertifierToAddressBook(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCertifierToAddressBook(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCertifierToAddressBook(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addServerToAddressBook(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addUserProfile(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addUserToAddressBook(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToAddressBook(String arg0, String arg1, String arg2,
			String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserToAddressBook(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7,
			String arg8, String arg9, String arg10) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crossCertify(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteIDOnServer(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getIDFromServer(String arg0, String arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getUserInfo(String arg0, StringBuffer arg1, StringBuffer arg2,
			StringBuffer arg3, StringBuffer arg4, Vector arg5)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean recertify(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recertify(String arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recertify(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewCertifier(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewCertifier(String arg0, String arg1, String arg2,
			String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String arg0, String arg1, String arg2,
			String arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String arg0, String arg1, String arg2,
			String arg3, String arg4) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewServer(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7,
			String arg8, String arg9) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String arg0, String arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7,
			String arg8, String arg9, String arg10) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerNewUser(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7,
			String arg8, String arg9, String arg10, String arg11, String arg12)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String switchToID(String arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}