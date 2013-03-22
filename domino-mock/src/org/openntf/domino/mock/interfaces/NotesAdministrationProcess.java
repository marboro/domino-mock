package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesAdministrationProcess extends NotesBase {
	/**
	 * 
	 */
	public static final int MAILFILE_DELETE_NONE = 0;
	/**
	 * 
	 */
	public static final int MAILFILE_DELETE_HOME = 1;
	/**
	 * 
	 */
	public static final int MAILFILE_DELETE_ALL = 2;
	/**
	 * 
	 */
	public static final int PWD_CHK_DONTCHECKPASSWORD = 0;
	/**
	 * 
	 */
	public static final int PWD_CHK_CHECKPASSWORD = 1;
	/**
	 * 
	 */
	public static final int PWD_CHK_LOCKOUT = 2;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getCertificateAuthorityOrg() throws NotesApiException;

	/**
	 * @param org
	 * @throws NotesApiException
	 */
	public abstract void setCertificateAuthorityOrg(String org) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getCertificateExpiration() throws NotesApiException;

	/**
	 * @param expiration
	 * @throws NotesApiException
	 */
	public abstract void setCertificateExpiration(NotesDateTime expiration) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getCertifierFile() throws NotesApiException;

	/**
	 * @param fileSpec
	 * @throws NotesApiException
	 */
	public abstract void setCertifierFile(String fileSpec) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getCertifierPassword() throws NotesApiException;

	/**
	 * @param password
	 * @throws NotesApiException
	 */
	public abstract void setCertifierPassword(String password) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCertificateAuthorityAvailable() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isUseCertificateAuthority() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setUseCertificateAuthority(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesSession getParent() throws NotesApiException;

	/**
	 * @param group
	 * @param members
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String addGroupMembers(String group, Vector members) throws NotesApiException;

	/**
	 * @param user
	 * @param keyRingFile
	 * @param keyRingPassword
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String addInternetCertificateToUser(String user, String keyRingFile, String keyRingPassword) throws NotesApiException;

	/**
	 * @param user
	 * @param keyRingFile
	 * @param keyRingPassword
	 * @param expiration
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String addInternetCertificateToUser(String user, String keyRingFile, String keyRingPassword, NotesDateTime expiration) throws NotesApiException;

	/**
	 * @param server
	 * @param cluster
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String addServerToCluster(String server, String cluster) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveDeletePersonInDirectory(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveDeleteServerInDirectory(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveDesignElementDeletion(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveMailFileDeletion(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveMovedReplicaDeletion(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveNameChangeRetraction(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveRenamePersonInDirectory(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveRenameServerInDirectory(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveReplicaDeletion(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveResourceDeletion(String noteID) throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String approveHostedOrgStorageDeletion(String noteID) throws NotesApiException;

	/**
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String changeHTTPPassword(String userName, String oldPassword, String newPassword) throws NotesApiException;

	/**
	 * @param userName
	 * @param agentName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String configureMailAgent(String userName, String agentName) throws NotesApiException;

	/**
	 * @param userName
	 * @param agentName
	 * @param activatable
	 * @param enable
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String configureMailAgent(String userName, String agentName, boolean activatable, boolean enable) throws NotesApiException;

	/**
	 * @param sourceserver
	 * @param sourcedbfile
	 * @param destserver
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String createReplica(String sourceserver, String sourcedbfile, String destserver) throws NotesApiException;

	/**
	 * @param sourceserver
	 * @param sourcedbfile
	 * @param destserver
	 * @param destdbfile
	 * @param copyacl
	 * @param createftindex
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String createReplica(String sourceserver, String sourcedbfile, String destserver, String destdbfile, boolean copyacl, boolean createftindex) throws NotesApiException;

	/**
	 * @param groupName
	 * @param immediate
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteGroup(String groupName, boolean immediate) throws NotesApiException;

	/**
	 * @param groupName
	 * @param immediate
	 * @param deleteWindowsGroup
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteGroup(String groupName, boolean immediate, boolean deleteWindowsGroup) throws NotesApiException;

	/**
	 * @param serverName
	 * @param fileName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteReplicas(String serverName, String fileName) throws NotesApiException;

	/**
	 * @param serverName
	 * @param immediate
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteServer(String serverName, boolean immediate) throws NotesApiException;

	/**
	 * @param userName
	 * @param immediate
	 * @param mailFileAction
	 * @param denyGroup
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup) throws NotesApiException;

	/**
	 * @param userName
	 * @param immediate
	 * @param mailFileAction
	 * @param denyGroup
	 * @param deleteWindowsUser
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup, boolean deleteWindowsUser) throws NotesApiException;

	/**
	 * @param group
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String findGroupInDomain(String group) throws NotesApiException;

	/**
	 * @param server
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String findServerInDomain(String server) throws NotesApiException;

	/**
	 * @param user
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String findUserInDomain(String user) throws NotesApiException;

	/**
	 * @param userName
	 * @param newHomeServer
	 * @param newHomeServerMailPath
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath) throws NotesApiException;

	/**
	 * @param userName
	 * @param newHomeServer
	 * @param newHomeServerMailPath
	 * @param useSCOS
	 * @param newClusterReplicas
	 * @param deleteOldClusterReplicas
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath, boolean useSCOS, Vector newClusterReplicas, boolean deleteOldClusterReplicas)
			throws NotesApiException;

	/**
	 * @param sourceServer
	 * @param sourceDbFile
	 * @param destServer
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveReplica(String sourceServer, String sourceDbFile, String destServer) throws NotesApiException;

	/**
	 * @param sourceServer
	 * @param sourceDbFile
	 * @param destServer
	 * @param destDbFile
	 * @param copyACL
	 * @param createFTIndex
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveReplica(String sourceServer, String sourceDbFile, String destServer, String destDbFile, boolean copyACL, boolean createFTIndex) throws NotesApiException;

	/**
	 * @param userName
	 * @param destServer
	 * @param destServerPath
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveRoamingUser(String userName, String destServer, String destServerPath) throws NotesApiException;

	/**
	 * @param requestNoteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveUserInHierarchyComplete(String requestNoteID) throws NotesApiException;

	/**
	 * @param requestNoteID
	 * @param lastName
	 * @param firstName
	 * @param middleInitial
	 * @param orgUnit
	 * @param altCommonName
	 * @param altOrgUnit
	 * @param altLanguage
	 * @param renameWindowsUser
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveUserInHierarchyComplete(String requestNoteID, String lastName, String firstName, String middleInitial, String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage, boolean renameWindowsUser) throws NotesApiException;

	/**
	 * @param userName
	 * @param targetCertifier
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveUserInHierarchyRequest(String userName, String targetCertifier) throws NotesApiException;

	/**
	 * @param userName
	 * @param targetCertifier
	 * @param allowPrimaryNameChange
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String moveUserInHierarchyRequest(String userName, String targetCertifier, boolean allowPrimaryNameChange) throws NotesApiException;

	/**
	 * @param server
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String recertifyServer(String server) throws NotesApiException;

	/**
	 * @param user
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String recertifyUser(String user) throws NotesApiException;

	/**
	 * @param server
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String removeServerFromCluster(String server) throws NotesApiException;

	/**
	 * @param group
	 * @param newGroup
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String renameGroup(String group, String newGroup) throws NotesApiException;

	/**
	 * @param userName
	 * @param lastName
	 * @param firstName
	 * @param middleInitial
	 * @param orgUnit
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String renameNotesUser(String userName, String lastName, String firstName, String middleInitial, String orgUnit) throws NotesApiException;

	/**
	 * @param userName
	 * @param lastName
	 * @param firstName
	 * @param middleInitial
	 * @param orgUnit
	 * @param altCommonName
	 * @param altOrgUnit
	 * @param altLanguage
	 * @param renameWindowsUser
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String renameNotesUser(String userName, String lastName, String firstName, String middleInitial, String orgUnit, String altCommonName, String altOrgUnit, String altLanguage,
			boolean renameWindowsUser) throws NotesApiException;

	/**
	 * @param userName
	 * @param newFullName
	 * @param newLastName
	 * @param newFirstName
	 * @param newMiddleInitial
	 * @param newShortName
	 * @param newInternetAddress
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String renameWebUser(String userName, String newFullName, String newLastName, String newFirstName, String newMiddleInitial, String newShortName, String newInternetAddress)
			throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String setServerDirectoryAssistanceSettings(String server, String dbFile) throws NotesApiException;

	/**
	 * @param userName
	 * @param notesPasswordCheckSetting
	 * @param notesPasswordChangeInterval
	 * @param notesPasswordGracePeriod
	 * @param internetPasswordForceChange
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String setUserPasswordSettings(String userName, Integer notesPasswordCheckSetting, Integer notesPasswordChangeInterval, Integer notesPasswordGracePeriod,
			Boolean internetPasswordForceChange) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String signDatabaseWithServerID(String server, String dbFile) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param updateOnly
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String signDatabaseWithServerID(String server, String dbFile, boolean updateOnly) throws NotesApiException;

	/**
	 * @param userName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String upgradeUserToHierarchical(String userName) throws NotesApiException;

	/**
	 * @param userName
	 * @param orgUnit
	 * @param altCommonName
	 * @param altOrgUnit
	 * @param altLanguage
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String upgradeUserToHierarchical(String userName, String orgUnit, String altCommonName, String altOrgUnit, String altLanguage) throws NotesApiException;
}
