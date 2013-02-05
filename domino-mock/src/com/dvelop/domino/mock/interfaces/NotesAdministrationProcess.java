package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesAdministrationProcess extends NotesBase {
	public static final int MAILFILE_DELETE_NONE = 0;
	public static final int MAILFILE_DELETE_HOME = 1;
	public static final int MAILFILE_DELETE_ALL = 2;
	public static final int PWD_CHK_DONTCHECKPASSWORD = 0;
	public static final int PWD_CHK_CHECKPASSWORD = 1;
	public static final int PWD_CHK_LOCKOUT = 2;

	public abstract String getCertificateAuthorityOrg()
			throws NotesApiException;

	public abstract void setCertificateAuthorityOrg(String org)
			throws NotesApiException;

	public abstract NotesDateTime getCertificateExpiration()
			throws NotesApiException;

	public abstract void setCertificateExpiration(NotesDateTime expiration)
			throws NotesApiException;

	public abstract String getCertifierFile() throws NotesApiException;

	public abstract void setCertifierFile(String fileSpec)
			throws NotesApiException;

	public abstract String getCertifierPassword() throws NotesApiException;

	public abstract void setCertifierPassword(String password)
			throws NotesApiException;

	public abstract boolean isCertificateAuthorityAvailable()
			throws NotesApiException;

	public abstract boolean isUseCertificateAuthority()
			throws NotesApiException;

	public abstract void setUseCertificateAuthority(boolean flag)
			throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String addGroupMembers(String group, Vector members)
			throws NotesApiException;

	public abstract String addInternetCertificateToUser(String user,
			String keyRingFile, String keyRingPassword)
			throws NotesApiException;

	public abstract String addInternetCertificateToUser(String user,
			String keyRingFile, String keyRingPassword, NotesDateTime expiration)
			throws NotesApiException;

	public abstract String addServerToCluster(String server, String cluster)
			throws NotesApiException;

	public abstract String approveDeletePersonInDirectory(String noteID)
			throws NotesApiException;

	public abstract String approveDeleteServerInDirectory(String noteID)
			throws NotesApiException;

	public abstract String approveDesignElementDeletion(String noteID)
			throws NotesApiException;

	public abstract String approveMailFileDeletion(String noteID)
			throws NotesApiException;

	public abstract String approveMovedReplicaDeletion(String noteID)
			throws NotesApiException;

	public abstract String approveNameChangeRetraction(String noteID)
			throws NotesApiException;

	public abstract String approveRenamePersonInDirectory(String noteID)
			throws NotesApiException;

	public abstract String approveRenameServerInDirectory(String noteID)
			throws NotesApiException;

	public abstract String approveReplicaDeletion(String noteID)
			throws NotesApiException;

	public abstract String approveResourceDeletion(String noteID)
			throws NotesApiException;

	public abstract String approveHostedOrgStorageDeletion(String noteID)
			throws NotesApiException;

	public abstract String changeHTTPPassword(String userName,
			String oldPassword, String newPassword) throws NotesApiException;

	public abstract String configureMailAgent(String userName, String agentName)
			throws NotesApiException;

	public abstract String configureMailAgent(String userName,
			String agentName, boolean activatable, boolean enable)
			throws NotesApiException;

	public abstract String createReplica(String sourceserver,
			String sourcedbfile, String destserver) throws NotesApiException;

	public abstract String createReplica(String sourceserver,
			String sourcedbfile, String destserver, String destdbfile,
			boolean copyacl, boolean createftindex) throws NotesApiException;

	public abstract String deleteGroup(String groupName, boolean immediate)
			throws NotesApiException;

	public abstract String deleteGroup(String groupName, boolean immediate,
			boolean deleteWindowsGroup) throws NotesApiException;

	public abstract String deleteReplicas(String serverName, String fileName)
			throws NotesApiException;

	public abstract String deleteServer(String serverName, boolean immediate)
			throws NotesApiException;

	public abstract String deleteUser(String userName, boolean immediate,
			int mailFileAction, String denyGroup) throws NotesApiException;

	public abstract String deleteUser(String userName, boolean immediate,
			int mailFileAction, String denyGroup, boolean deleteWindowsUser)
			throws NotesApiException;

	public abstract String findGroupInDomain(String group)
			throws NotesApiException;

	public abstract String findServerInDomain(String server)
			throws NotesApiException;

	public abstract String findUserInDomain(String user)
			throws NotesApiException;

	public abstract String moveMailUser(String userName, String newHomeServer,
			String newHomeServerMailPath) throws NotesApiException;

	public abstract String moveMailUser(String userName, String newHomeServer,
			String newHomeServerMailPath, boolean useSCOS,
			Vector newClusterReplicas, boolean deleteOldClusterReplicas)
			throws NotesApiException;

	public abstract String moveReplica(String sourceServer,
			String sourceDbFile, String destServer) throws NotesApiException;

	public abstract String moveReplica(String sourceServer,
			String sourceDbFile, String destServer, String destDbFile,
			boolean copyACL, boolean createFTIndex) throws NotesApiException;

	public abstract String moveRoamingUser(String userName, String destServer,
			String destServerPath) throws NotesApiException;

	public abstract String moveUserInHierarchyComplete(String requestNoteID)
			throws NotesApiException;

	public abstract String moveUserInHierarchyComplete(String requestNoteID,
			String lastName, String firstName, String middleInitial,
			String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage, boolean renameWindowsUser)
			throws NotesApiException;

	public abstract String moveUserInHierarchyRequest(String userName,
			String targetCertifier) throws NotesApiException;

	public abstract String moveUserInHierarchyRequest(String userName,
			String targetCertifier, boolean allowPrimaryNameChange)
			throws NotesApiException;

	public abstract String recertifyServer(String server)
			throws NotesApiException;

	public abstract String recertifyUser(String user) throws NotesApiException;

	public abstract String removeServerFromCluster(String server)
			throws NotesApiException;

	public abstract String renameGroup(String group, String newGroup)
			throws NotesApiException;

	public abstract String renameNotesUser(String userName, String lastName,
			String firstName, String middleInitial, String orgUnit)
			throws NotesApiException;

	public abstract String renameNotesUser(String userName, String lastName,
			String firstName, String middleInitial, String orgUnit,
			String altCommonName, String altOrgUnit, String altLanguage,
			boolean renameWindowsUser) throws NotesApiException;

	public abstract String renameWebUser(String userName, String newFullName,
			String newLastName, String newFirstName, String newMiddleInitial,
			String newShortName, String newInternetAddress)
			throws NotesApiException;

	public abstract String setServerDirectoryAssistanceSettings(String server,
			String dbFile) throws NotesApiException;

	public abstract String setUserPasswordSettings(String userName,
			Integer notesPasswordCheckSetting,
			Integer notesPasswordChangeInterval,
			Integer notesPasswordGracePeriod,
			Boolean internetPasswordForceChange) throws NotesApiException;

	public abstract String signDatabaseWithServerID(String server, String dbFile)
			throws NotesApiException;

	public abstract String signDatabaseWithServerID(String server,
			String dbFile, boolean updateOnly) throws NotesApiException;

	public abstract String upgradeUserToHierarchical(String userName)
			throws NotesApiException;

	public abstract String upgradeUserToHierarchical(String userName,
			String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage) throws NotesApiException;
}
