package org.openntf.domino.mock.impl.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesAdministrationProcess;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesSession;

/**
 * Mock-Implementation for {@link NotesAdministrationProcess}
 * 
 * @author Sven Dreher
 * 
 */
public class NotesAdministrationProcessMockImpl extends NotesBaseMockImpl
		implements NotesAdministrationProcess {

	private String certificateAuthorityOrg;
	private NotesDateTime certificateExpiration;
	private String certifierFile;
	private String certifierPassword;
	private boolean useCertificateAuthority;
	private boolean certificateAuthorityAvailable;
	private NotesSession parent;
	private Map<String, Vector> groups;
	private Map<String, Integer> groupNoteIDs;
	private String server;
	private NotesDatabase administrationRequestDB;

	/**
	 * Default-Constructor
	 */
	public NotesAdministrationProcessMockImpl() {
		groups = new HashMap<String, Vector>();
		groupNoteIDs = new HashMap<String, Integer>();
	}

	/**
	 * @param server
	 *            The Server for the AdministrationProcess
	 * @param parent
	 *            The parent Session
	 * @throws NotesApiException
	 */
	public NotesAdministrationProcessMockImpl(String server, NotesSession parent)
			throws NotesApiException {
		this();
		this.server = server;
		this.parent = parent;
		this.administrationRequestDB = parent.getDatabase(server, "admin4.nsf");
	}

	@Override
	public String getCertificateAuthorityOrg() throws NotesApiException {
		return certificateAuthorityOrg;
	}

	@Override
	public void setCertificateAuthorityOrg(String certificateAuthorityOrg)
			throws NotesApiException {
		this.certificateAuthorityOrg = certificateAuthorityOrg;
	}

	@Override
	public NotesDateTime getCertificateExpiration() throws NotesApiException {
		return certificateExpiration;
	}

	@Override
	public void setCertificateExpiration(NotesDateTime certificateExpiration)
			throws NotesApiException {
		this.certificateExpiration = certificateExpiration;
	}

	@Override
	public String getCertifierFile() throws NotesApiException {
		return certifierFile;
	}

	@Override
	public void setCertifierFile(String certifierFile) throws NotesApiException {
		this.certifierFile = certifierFile;
	}

	@Override
	public String getCertifierPassword() throws NotesApiException {
		return certifierPassword;
	}

	@Override
	public void setCertifierPassword(String certifierPassword)
			throws NotesApiException {
		this.certifierPassword = certifierPassword;
	}

	/**
	 * @param certificateAuthorityAvailable
	 */
	public void setCertificateAuthorityAvailable(
			boolean certificateAuthorityAvailable) {
		this.certificateAuthorityAvailable = certificateAuthorityAvailable;
	}

	@Override
	public boolean isCertificateAuthorityAvailable() throws NotesApiException {
		return certificateAuthorityAvailable;
	}

	@Override
	public boolean isUseCertificateAuthority() throws NotesApiException {
		return useCertificateAuthority;
	}

	@Override
	public void setUseCertificateAuthority(boolean useCertificateAuthority)
			throws NotesApiException {
		this.useCertificateAuthority = useCertificateAuthority;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		return parent;
	}

	/**
	 * @param groupName
	 * @param members
	 */
	public void addGroup(String groupName, Vector members) {
		groups.put(groupName, members);
		Random random = new Random();
		groupNoteIDs.put(groupName, Integer.valueOf(random.nextInt()));
	}

	@Override
	public String addGroupMembers(String group, Vector members)
			throws NotesApiException {
		if (groups.containsKey(group)) {
			Vector vector = groups.get(group);
			vector.addAll(members);
			groups.put(group, vector);
			return groupNoteIDs.get(group).toString();
		}
		return "";
	}

	@Override
	public String addInternetCertificateToUser(String user, String keyRingFile,
			String keyRingPassword) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addInternetCertificateToUser(String user, String keyRingFile,
			String keyRingPassword, NotesDateTime expiration)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addServerToCluster(String server, String cluster)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDeletePersonInDirectory(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDeleteServerInDirectory(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveDesignElementDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveMailFileDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveMovedReplicaDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveNameChangeRetraction(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveRenamePersonInDirectory(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveRenameServerInDirectory(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveReplicaDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveResourceDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String approveHostedOrgStorageDeletion(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeHTTPPassword(String userName, String oldPassword,
			String newPassword) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String configureMailAgent(String userName, String agentName)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String configureMailAgent(String userName, String agentName,
			boolean activatable, boolean enable) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReplica(String sourceserver, String sourcedbfile,
			String destserver) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReplica(String sourceserver, String sourcedbfile,
			String destserver, String destdbfile, boolean copyacl,
			boolean createftindex) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGroup(String groupName, boolean immediate)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGroup(String groupName, boolean immediate,
			boolean deleteWindowsGroup) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteReplicas(String serverName, String fileName)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteServer(String serverName, boolean immediate)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName, boolean immediate,
			int mailFileAction, String denyGroup) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userName, boolean immediate,
			int mailFileAction, String denyGroup, boolean deleteWindowsUser)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findGroupInDomain(String group) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findServerInDomain(String server) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserInDomain(String user) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveMailUser(String userName, String newHomeServer,
			String newHomeServerMailPath) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveMailUser(String userName, String newHomeServer,
			String newHomeServerMailPath, boolean useSCOS,
			Vector newClusterReplicas, boolean deleteOldClusterReplicas)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveReplica(String sourceServer, String sourceDbFile,
			String destServer) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveReplica(String sourceServer, String sourceDbFile,
			String destServer, String destDbFile, boolean copyACL,
			boolean createFTIndex) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveRoamingUser(String userName, String destServer,
			String destServerPath) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyComplete(String requestNoteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyComplete(String requestNoteID,
			String lastName, String firstName, String middleInitial,
			String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage, boolean renameWindowsUser)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyRequest(String userName,
			String targetCertifier) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String moveUserInHierarchyRequest(String userName,
			String targetCertifier, boolean allowPrimaryNameChange)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recertifyServer(String server) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recertifyUser(String user) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeServerFromCluster(String server)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameGroup(String group, String newGroup)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameNotesUser(String userName, String lastName,
			String firstName, String middleInitial, String orgUnit)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameNotesUser(String userName, String lastName,
			String firstName, String middleInitial, String orgUnit,
			String altCommonName, String altOrgUnit, String altLanguage,
			boolean renameWindowsUser) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameWebUser(String userName, String newFullName,
			String newLastName, String newFirstName, String newMiddleInitial,
			String newShortName, String newInternetAddress)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setServerDirectoryAssistanceSettings(String server,
			String dbFile) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setUserPasswordSettings(String userName,
			Integer notesPasswordCheckSetting,
			Integer notesPasswordChangeInterval,
			Integer notesPasswordGracePeriod,
			Boolean internetPasswordForceChange) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signDatabaseWithServerID(String server, String dbFile)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signDatabaseWithServerID(String server, String dbFile,
			boolean updateOnly) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upgradeUserToHierarchical(String userName)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upgradeUserToHierarchical(String userName, String orgUnit,
			String altCommonName, String altOrgUnit, String altLanguage)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

}