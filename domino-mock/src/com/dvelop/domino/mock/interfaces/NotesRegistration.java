package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRegistration extends NotesBase {
	public static final int ID_FLAT = 171;
	public static final int ID_HIERARCHICAL = 172;
	public static final int ID_CERTIFIER = 173;
	public static final int NOTES_LIMITED_CLIENT = 174;
	public static final int NOTES_DESKTOP_CLIENT = 175;
	public static final int NOTES_FULL_CLIENT = 176;
	public static final int REG_MAILSYSTEM_NOTES = 0;
	public static final int REG_MAILSYSTEM_POP = 1;
	public static final int REG_MAILSYSTEM_IMAP = 2;
	public static final int REG_MAILSYSTEM_INOTES = 3;
	public static final int REG_MAILSYSTEM_INTERNET = 4;
	public static final int REG_MAILSYSTEM_OTHER = 5;
	public static final int REG_MAILSYSTEM_NONE = 6;
	public static final int REG_MAIL_OWNER_ACL_MANAGER = 0;
	public static final int REG_MAIL_OWNER_ACL_DESIGNER = 1;
	public static final int REG_MAIL_OWNER_ACL_EDITOR = 2;
	public static final int REG_ROAMING_CLEANUP_NEVER = 0;
	public static final int REG_ROAMING_CLEANUP_EVERY_NDAYS = 1;
	public static final int REG_ROAMING_CLEANUP_AT_SHUTDOWN = 2;
	public static final int REG_ROAMING_CLEANUP_PROMPT = 3;
	public static final int PKSIZE_DEFAULT = 0;
	public static final int PKSIZE_630 = 630;
	public static final int PKSIZE_1024 = 1024;
	public static final int PKSIZE_2048 = 2048;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getCertifierIDFile() throws NotesApiException;

	public abstract void setCertifierIDFile(String arg0)
			throws NotesApiException;

	public abstract boolean getCreateMailDb() throws NotesApiException;

	public abstract void setCreateMailDb(boolean arg0) throws NotesApiException;

	public abstract NotesDateTime getExpiration() throws NotesApiException;

	public abstract void setExpiration(NotesDateTime arg0)
			throws NotesApiException;

	public abstract int getIDType() throws NotesApiException;

	public abstract void setIDType(int arg0) throws NotesApiException;

	public abstract int getMinPasswordLength() throws NotesApiException;

	public abstract void setMinPasswordLength(int arg0)
			throws NotesApiException;

	public abstract String getOrgUnit() throws NotesApiException;

	public abstract void setOrgUnit(String arg0) throws NotesApiException;

	public abstract String getRegistrationLog() throws NotesApiException;

	public abstract void setRegistrationLog(String arg0)
			throws NotesApiException;

	public abstract String getRegistrationServer() throws NotesApiException;

	public abstract void setRegistrationServer(String arg0)
			throws NotesApiException;

	public abstract boolean getStoreIDInAddressBook() throws NotesApiException;

	public abstract void setStoreIDInAddressBook(boolean arg0)
			throws NotesApiException;

	public abstract boolean isNorthAmerican() throws NotesApiException;

	public abstract void setNorthAmerican(boolean arg0)
			throws NotesApiException;

	public abstract boolean getUpdateAddressBook() throws NotesApiException;

	public abstract void setUpdateAddressBook(boolean arg0)
			throws NotesApiException;

	public abstract Vector getAltOrgUnit() throws NotesApiException;

	public abstract void setAltOrgUnit(Vector arg0) throws NotesApiException;

	public abstract Vector getAltOrgUnitLang() throws NotesApiException;

	public abstract void setAltOrgUnitLang(Vector arg0)
			throws NotesApiException;

	public abstract String getCertifierName() throws NotesApiException;

	public abstract void setCertifierName(String arg0) throws NotesApiException;

	public abstract String getMailACLManager() throws NotesApiException;

	public abstract void setMailACLManager(String arg0)
			throws NotesApiException;

	public abstract String getMailInternetAddress() throws NotesApiException;

	public abstract void setMailInternetAddress(String arg0)
			throws NotesApiException;

	public abstract String getMailTemplateName() throws NotesApiException;

	public abstract void setMailTemplateName(String arg0)
			throws NotesApiException;

	public abstract String getPolicyName() throws NotesApiException;

	public abstract void setPolicyName(String arg0) throws NotesApiException;

	public abstract String getRoamingServer() throws NotesApiException;

	public abstract void setRoamingServer(String arg0) throws NotesApiException;

	public abstract String getRoamingSubdir() throws NotesApiException;

	public abstract void setRoamingSubdir(String arg0) throws NotesApiException;

	public abstract String getShortName() throws NotesApiException;

	public abstract void setShortName(String arg0) throws NotesApiException;

	public abstract boolean isEnforceUniqueShortName() throws NotesApiException;

	public abstract void setEnforceUniqueShortName(boolean arg0)
			throws NotesApiException;

	public abstract boolean isRoamingUser() throws NotesApiException;

	public abstract void setRoamingUser(boolean arg0) throws NotesApiException;

	public abstract boolean isMailCreateFTIndex() throws NotesApiException;

	public abstract void setMailCreateFTIndex(boolean arg0)
			throws NotesApiException;

	public abstract boolean isNoIDFile() throws NotesApiException;

	public abstract void setNoIDFile(boolean arg0) throws NotesApiException;

	public abstract boolean isStoreIDInMailfile() throws NotesApiException;

	public abstract void setStoreIDInMailfile(boolean arg0)
			throws NotesApiException;

	public abstract boolean isSynchInternetPassword() throws NotesApiException;

	public abstract void setSynchInternetPassword(boolean arg0)
			throws NotesApiException;

	public abstract boolean isUseCertificateAuthority()
			throws NotesApiException;

	public abstract void setUseCertificateAuthority(boolean arg0)
			throws NotesApiException;

	public abstract int getMailQuotaSizeLimit() throws NotesApiException;

	public abstract void setMailQuotaSizeLimit(int arg0)
			throws NotesApiException;

	public abstract int getMailQuotaWarningThreshold() throws NotesApiException;

	public abstract void setMailQuotaWarningThreshold(int arg0)
			throws NotesApiException;

	public abstract int getMailOwnerAccess() throws NotesApiException;

	public abstract void setMailOwnerAccess(int arg0) throws NotesApiException;

	public abstract int getMailSystem() throws NotesApiException;

	public abstract void setMailSystem(int arg0) throws NotesApiException;

	public abstract int getRoamingCleanupPeriod() throws NotesApiException;

	public abstract void setRoamingCleanupPeriod(int arg0)
			throws NotesApiException;

	public abstract int getRoamingCleanupSetting() throws NotesApiException;

	public abstract void setRoamingCleanupSetting(int arg0)
			throws NotesApiException;

	public abstract Vector getGroupList() throws NotesApiException;

	public abstract void setGroupList(Vector arg0) throws NotesApiException;

	public abstract Vector getMailReplicaServers() throws NotesApiException;

	public abstract void setMailReplicaServers(Vector arg0)
			throws NotesApiException;

	public abstract int getPublicKeySize() throws NotesApiException;

	public abstract void setPublicKeySize(int arg0) throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String arg0)
			throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String arg0, String arg1)
			throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract boolean addServerToAddressBook(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract boolean addServerToAddressBook(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract boolean addServerToAddressBook(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8) throws NotesApiException;

	public abstract void addUserProfile(String arg0, String arg1)
			throws NotesApiException;

	public abstract boolean addUserToAddressBook(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract boolean addUserToAddressBook(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract boolean addUserToAddressBook(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, String arg9, String arg10)
			throws NotesApiException;

	public abstract boolean crossCertify(String arg0) throws NotesApiException;

	public abstract boolean crossCertify(String arg0, String arg1)
			throws NotesApiException;

	public abstract boolean crossCertify(String arg0, String arg1, String arg2)
			throws NotesApiException;

	public abstract void deleteIDOnServer(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void getIDFromServer(String arg0, String arg1, boolean arg2)
			throws NotesApiException;

	public abstract void getUserInfo(String arg0, StringBuffer arg1,
			StringBuffer arg2, StringBuffer arg3, StringBuffer arg4, Vector arg5)
			throws NotesApiException;

	public abstract boolean recertify(String arg0) throws NotesApiException;

	public abstract boolean recertify(String arg0, String arg1)
			throws NotesApiException;

	public abstract boolean recertify(String arg0, String arg1, String arg2)
			throws NotesApiException;

	public abstract boolean registerNewCertifier(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract boolean registerNewCertifier(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract boolean registerNewServer(String arg0, String arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract boolean registerNewServer(String arg0, String arg1,
			String arg2, String arg3, String arg4) throws NotesApiException;

	public abstract boolean registerNewServer(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, String arg9) throws NotesApiException;

	public abstract boolean registerNewUser(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract boolean registerNewUser(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5)
			throws NotesApiException;

	public abstract boolean registerNewUser(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, String arg9, String arg10)
			throws NotesApiException;

	public abstract boolean registerNewUser(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, String arg9, String arg10, String arg11,
			String arg12) throws NotesApiException;

	public abstract String switchToID(String arg0, String arg1)
			throws NotesApiException;
}
