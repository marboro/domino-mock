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

	public abstract void setCertifierIDFile(String file)
			throws NotesApiException;

	public abstract boolean getCreateMailDb() throws NotesApiException;

	public abstract void setCreateMailDb(boolean flag) throws NotesApiException;

	public abstract NotesDateTime getExpiration() throws NotesApiException;

	public abstract void setExpiration(NotesDateTime date)
			throws NotesApiException;

	public abstract int getIDType() throws NotesApiException;

	public abstract void setIDType(int type) throws NotesApiException;

	public abstract int getMinPasswordLength() throws NotesApiException;

	public abstract void setMinPasswordLength(int len) throws NotesApiException;

	public abstract String getOrgUnit() throws NotesApiException;

	public abstract void setOrgUnit(String unit) throws NotesApiException;

	public abstract String getRegistrationLog() throws NotesApiException;

	public abstract void setRegistrationLog(String name)
			throws NotesApiException;

	public abstract String getRegistrationServer() throws NotesApiException;

	public abstract void setRegistrationServer(String server)
			throws NotesApiException;

	public abstract boolean getStoreIDInAddressBook() throws NotesApiException;

	public abstract void setStoreIDInAddressBook(boolean flag)
			throws NotesApiException;

	public abstract boolean isNorthAmerican() throws NotesApiException;

	public abstract void setNorthAmerican(boolean flag)
			throws NotesApiException;

	public abstract boolean getUpdateAddressBook() throws NotesApiException;

	public abstract void setUpdateAddressBook(boolean flag)
			throws NotesApiException;

	public abstract Vector getAltOrgUnit() throws NotesApiException;

	public abstract void setAltOrgUnit(Vector names) throws NotesApiException;

	public abstract Vector getAltOrgUnitLang() throws NotesApiException;

	public abstract void setAltOrgUnitLang(Vector languages)
			throws NotesApiException;

	public abstract String getCertifierName() throws NotesApiException;

	public abstract void setCertifierName(String name) throws NotesApiException;

	public abstract String getMailACLManager() throws NotesApiException;

	public abstract void setMailACLManager(String name)
			throws NotesApiException;

	public abstract String getMailInternetAddress() throws NotesApiException;

	public abstract void setMailInternetAddress(String name)
			throws NotesApiException;

	public abstract String getMailTemplateName() throws NotesApiException;

	public abstract void setMailTemplateName(String name)
			throws NotesApiException;

	public abstract String getPolicyName() throws NotesApiException;

	public abstract void setPolicyName(String name) throws NotesApiException;

	public abstract String getRoamingServer() throws NotesApiException;

	public abstract void setRoamingServer(String server)
			throws NotesApiException;

	public abstract String getRoamingSubdir() throws NotesApiException;

	public abstract void setRoamingSubdir(String server)
			throws NotesApiException;

	public abstract String getShortName() throws NotesApiException;

	public abstract void setShortName(String name) throws NotesApiException;

	public abstract boolean isEnforceUniqueShortName() throws NotesApiException;

	public abstract void setEnforceUniqueShortName(boolean flag)
			throws NotesApiException;

	public abstract boolean isRoamingUser() throws NotesApiException;

	public abstract void setRoamingUser(boolean flag) throws NotesApiException;

	public abstract boolean isMailCreateFTIndex() throws NotesApiException;

	public abstract void setMailCreateFTIndex(boolean flag)
			throws NotesApiException;

	public abstract boolean isNoIDFile() throws NotesApiException;

	public abstract void setNoIDFile(boolean flag) throws NotesApiException;

	public abstract boolean isStoreIDInMailfile() throws NotesApiException;

	public abstract void setStoreIDInMailfile(boolean flag)
			throws NotesApiException;

	public abstract boolean isSynchInternetPassword() throws NotesApiException;

	public abstract void setSynchInternetPassword(boolean flag)
			throws NotesApiException;

	public abstract boolean isUseCertificateAuthority()
			throws NotesApiException;

	public abstract void setUseCertificateAuthority(boolean flag)
			throws NotesApiException;

	public abstract int getMailQuotaSizeLimit() throws NotesApiException;

	public abstract void setMailQuotaSizeLimit(int limit)
			throws NotesApiException;

	public abstract int getMailQuotaWarningThreshold() throws NotesApiException;

	public abstract void setMailQuotaWarningThreshold(int threshold)
			throws NotesApiException;

	public abstract int getMailOwnerAccess() throws NotesApiException;

	public abstract void setMailOwnerAccess(int access)
			throws NotesApiException;

	public abstract int getMailSystem() throws NotesApiException;

	public abstract void setMailSystem(int system) throws NotesApiException;

	public abstract int getRoamingCleanupPeriod() throws NotesApiException;

	public abstract void setRoamingCleanupPeriod(int period)
			throws NotesApiException;

	public abstract int getRoamingCleanupSetting() throws NotesApiException;

	public abstract void setRoamingCleanupSetting(int setting)
			throws NotesApiException;

	public abstract Vector getGroupList() throws NotesApiException;

	public abstract void setGroupList(Vector grouplist)
			throws NotesApiException;

	public abstract Vector getMailReplicaServers() throws NotesApiException;

	public abstract void setMailReplicaServers(Vector servers)
			throws NotesApiException;

	public abstract int getPublicKeySize() throws NotesApiException;

	public abstract void setPublicKeySize(int pks) throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String idfile)
			throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String idfile,
			String password) throws NotesApiException;

	public abstract boolean addCertifierToAddressBook(String idfile,
			String password, String location, String comment)
			throws NotesApiException;

	public abstract boolean addServerToAddressBook(String idfile,
			String server, String domain) throws NotesApiException;

	public abstract boolean addServerToAddressBook(String idfile,
			String server, String domain, String userpw)
			throws NotesApiException;

	public abstract boolean addServerToAddressBook(String idfile,
			String server, String domain, String userpw, String network,
			String adminname, String title, String location, String comment)
			throws NotesApiException;

	public abstract void addUserProfile(String username, String profile)
			throws NotesApiException;

	public abstract boolean addUserToAddressBook(String idfile,
			String fullname, String lastn) throws NotesApiException;

	public abstract boolean addUserToAddressBook(String idfile,
			String fullname, String lastn, String userpw)
			throws NotesApiException;

	public abstract boolean addUserToAddressBook(String idfile,
			String fullname, String lastn, String userpw, String firstn,
			String middle, String mailserv, String mailfilepath,
			String fwdaddr, String location, String comment)
			throws NotesApiException;

	public abstract boolean crossCertify(String idfile)
			throws NotesApiException;

	public abstract boolean crossCertify(String idfile, String certpw)
			throws NotesApiException;

	public abstract boolean crossCertify(String idfile, String certpw,
			String comment) throws NotesApiException;

	public abstract void deleteIDOnServer(String username, boolean isserverid)
			throws NotesApiException;

	public abstract void getIDFromServer(String username, String filepath,
			boolean isserverid) throws NotesApiException;

	public abstract void getUserInfo(String username, StringBuffer mailserver,
			StringBuffer mailfile, StringBuffer maildomain,
			StringBuffer mailsystem, Vector profile) throws NotesApiException;

	public abstract boolean recertify(String idfile) throws NotesApiException;

	public abstract boolean recertify(String idfile, String certpw)
			throws NotesApiException;

	public abstract boolean recertify(String idfile, String certpw,
			String comment) throws NotesApiException;

	public abstract boolean registerNewCertifier(String org, String idfile,
			String certpw) throws NotesApiException;

	public abstract boolean registerNewCertifier(String org, String idfile,
			String certpw, String country) throws NotesApiException;

	public abstract boolean registerNewServer(String server, String idfile,
			String domain, String serverpw) throws NotesApiException;

	public abstract boolean registerNewServer(String server, String idfile,
			String domain, String serverpw, String certpw)
			throws NotesApiException;

	public abstract boolean registerNewServer(String server, String idfile,
			String domain, String serverpw, String certpw, String location,
			String comment, String network, String adminname, String title)
			throws NotesApiException;

	public abstract boolean registerNewUser(String lastn, String idfile,
			String server) throws NotesApiException;

	public abstract boolean registerNewUser(String lastn, String idfile,
			String server, String firstn, String middle, String certpw)
			throws NotesApiException;

	public abstract boolean registerNewUser(String lastn, String idfile,
			String server, String firstn, String middle, String certpw,
			String location, String comment, String maildbpath, String forward,
			String userpw) throws NotesApiException;

	public abstract boolean registerNewUser(String lastn, String idfile,
			String server, String firstn, String middle, String certpw,
			String location, String comment, String maildbpath, String forward,
			String userpw, String altname, String altnamelang)
			throws NotesApiException;

	public abstract String switchToID(String idfile, String userpw)
			throws NotesApiException;
}
