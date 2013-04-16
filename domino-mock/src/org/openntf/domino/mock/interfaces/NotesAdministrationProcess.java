package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents the administration process.
 * 
 * @author Sven Dreher
 * @access To create an AdministrationProcess object, call {@link NotesSession#createAdministrationProcess(String)} in Session.
 * 
 *         All AdministrationProcess methods require unrestricted server access.
 * 
 * 
 */
public interface NotesAdministrationProcess extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int MAILFILE_DELETE_NONE = 0;
	/**
	 * {@value}
	 */
	public static final int MAILFILE_DELETE_HOME = 1;
	/**
	 * {@value}
	 */
	public static final int MAILFILE_DELETE_ALL = 2;
	/**
	 * {@value}
	 */
	public static final int PWD_CHK_DONTCHECKPASSWORD = 0;
	/**
	 * {@value}
	 */
	public static final int PWD_CHK_CHECKPASSWORD = 1;
	/**
	 * {@value}
	 */
	public static final int PWD_CHK_LOCKOUT = 2;

	/**
	 * The certifier when making requests to the certificate authority.
	 * 
	 * @return The certifier when making requests to the certificate authority.
	 * @throws NotesApiException
	 * @usage This property applies when {@link #isUseCertificateAuthority()} is true, a CA process is available, and a certifier is required.
	 */
	public abstract String getCertificateAuthorityOrg() throws NotesApiException;

	/**
	 * /** The certifier when making requests to the certificate authority.
	 * 
	 * @param org
	 *            The certifier when making requests to the certificate authority.
	 * @throws NotesApiException
	 * @usage This property applies when {@link #isUseCertificateAuthority()} is true, a CA process is available, and a certifier is required.
	 */
	public abstract void setCertificateAuthorityOrg(String org) throws NotesApiException;

	/**
	 * The expiration date for the certifier ID.
	 * 
	 * @return The expiration date for the certifier ID.
	 * @throws NotesApiException
	 * @usage If this property is not set, the expiration date is two years from the current date.
	 */
	public abstract NotesDateTime getCertificateExpiration() throws NotesApiException;

	/**
	 * * The expiration date for the certifier ID.
	 * 
	 * @param expiration
	 *            The expiration date for the certifier ID.
	 * @throws NotesApiException
	 * @usage If this property is not set, the expiration date is two years from the current date.
	 */
	public abstract void setCertificateExpiration(NotesDateTime expiration) throws NotesApiException;

	/**
	 * The file specification of the certifier ID file.
	 * 
	 * @return The file specification of the certifier ID file.
	 * @throws NotesApiException
	 * @usage The file specification can be a complete file specification or can be relative to the Domino data directory.
	 * 
	 *        This property applies when {@link #isUseCertificateAuthority()} is false and a certifier is required.
	 */
	public abstract String getCertifierFile() throws NotesApiException;

	/**
	 * The file specification of the certifier ID file.
	 * 
	 * @param fileSpec
	 *            The file specification of the certifier ID file.
	 * @throws NotesApiException
	 * @usage The file specification can be a complete file specification or can be relative to the Domino data directory.
	 * 
	 *        This property applies when {@link #isUseCertificateAuthority()} is false and a certifier is required.
	 */
	public abstract void setCertifierFile(String fileSpec) throws NotesApiException;

	/**
	 * The password of the certifier ID file.
	 * 
	 * @return The password of the certifier ID file.
	 * @throws NotesApiException
	 * @usage This property applies when {@link #isUseCertificateAuthority()} is false and a certifier is required.
	 */
	public abstract String getCertifierPassword() throws NotesApiException;

	/**
	 * The password of the certifier ID file.
	 * 
	 * @param password
	 *            The password of the certifier ID file.
	 * @throws NotesApiException
	 * @usage This property applies when {@link #isUseCertificateAuthority()} is false and a certifier is required.
	 */
	public abstract void setCertifierPassword(String password) throws NotesApiException;

	/**
	 * Indicates whether a certificate authority certifier is available.
	 * 
	 * @return Indicates whether a certificate authority certifier is available.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true in either of the following cases:
	 *              <ul>
	 *              <li>{@link #getCertificateAuthorityOrg()} is set and a certificate authority certifier is available for the specified organization.</li>
	 *              <li>{@link #getCertificateAuthorityOrg()} is not set and any certificate authority certifier is available.</li>
	 *              </ul>
	 *              </li>
	 *              <li>false otherwise</li>
	 *              </ul>
	 */
	public abstract boolean isCertificateAuthorityAvailable() throws NotesApiException;

	/**
	 * Indicates whether to use the certificate authority for certification.
	 * 
	 * @return Indicates whether to use the certificate authority for certification.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true to use the certificate authority</li>
	 *              <li>false (default) to use a certifier ID file</li>
	 *              </ul>
	 * @usage If you set this property to true, specify {@link #getCertificateAuthorityOrg()}. You can ensure that the certifier is available with {@link #isCertificateAuthorityAvailable()}.
	 * 
	 *        If you set this property to false, specify {@link #getCertifierFile()} and {@link #getCertifierPassword()}.
	 */
	public abstract boolean isUseCertificateAuthority() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setUseCertificateAuthority(boolean flag) throws NotesApiException;

	/**
	 * The session that created the AdministrationProcess object.
	 * 
	 * @return The session that created the AdministrationProcess object.
	 * @throws NotesApiException
	 */
	public abstract NotesSession getParent() throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to add members to a new or existing a group.
	 * 
	 * @param group
	 *            The name of the group.
	 * @param members
	 *            The names of the members in the group.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method enters the following administration request: Add or Modify Group in Domino Directory.
	 * 
	 *        If the group exists, the members are added to that group.
	 * 
	 *        If the group does not exist, a new multi-purpose group is created containing the members.
	 */
	public abstract String addGroupMembers(String group, Vector<String> members) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to add an Internet certificate to a user ID.
	 * 
	 * @param user
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param keyRingFile
	 *            The pathname of the key ring file containing the Internet certificate.
	 * @param keyRingPassword
	 *            The password of the key ring file.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage The administration process is a program that automates routine administrative tasks. For more information, see "Add Internet Certificate to Person Record" in Administration Help.
	 * 
	 *        If this method is used with the certifier ID process, it requires an Internet certificate in a key ring file. See "Creating a server key ring file" in Administration Help. If this method
	 *        is used with the CA process, no server key ring file is needed, the keyringname$ and keyringpassword$ parameters should be called with null text values "", and the
	 *        NotesAdministrationProcess object's UseCertificateAuthority property must be set to True prior to calling the method.
	 * 
	 */
	public abstract String addInternetCertificateToUser(String user, String keyRingFile, String keyRingPassword) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to add an Internet certificate to a user ID.
	 * 
	 * @param user
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param keyRingFile
	 *            The pathname of the key ring file containing the Internet certificate.
	 * @param keyRingPassword
	 *            The password of the key ring file.
	 * @param expiration
	 *            The expiration date for the certificate.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage The administration process is a program that automates routine administrative tasks. For more information, see "Add Internet Certificate to Person Record" in Administration Help.
	 * 
	 *        If this method is used with the certifier ID process, it requires an Internet certificate in a key ring file. See "Creating a server key ring file" in Administration Help. If this method
	 *        is used with the CA process, no server key ring file is needed, the keyringname$ and keyringpassword$ parameters should be called with null text values "", and the
	 *        NotesAdministrationProcess object's UseCertificateAuthority property must be set to True prior to calling the method.
	 */
	public abstract String addInternetCertificateToUser(String user, String keyRingFile, String keyRingPassword, NotesDateTime expiration) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to add a server to a cluster.
	 * 
	 * @param server
	 *            The full hierarchical name (can be abbreviated) of the server.
	 * @param cluster
	 *            The name of the cluster.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage If the cluster does not exist, a new cluster is created and the server added to it.
	 */
	public abstract String addServerToCluster(String server, String cluster) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveDeletePersonInDirectory(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveDeleteServerInDirectory(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveDesignElementDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveMailFileDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveMovedReplicaDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveNameChangeRetraction(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveRenamePersonInDirectory(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveRenameServerInDirectory(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveReplicaDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveResourceDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to continue a previously initiated request that is pending approval.
	 * 
	 * @param noteID
	 *            The note ID of the entry pending approval
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String approveHostedOrgStorageDeletion(String noteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to change a user's Internet password.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param oldPassword
	 *            The existing password
	 * @param newPassword
	 *            The new password.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String changeHTTPPassword(String userName, String oldPassword, String newPassword) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to configure an agent in a mail database on a user's home server.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param agentName
	 *            The name of the agent.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method specifies username as the value of "Run on behalf of" under the Security tab in the Agent Properties box. This is useful to allow scheduled agents on a mail database to run
	 *        under the authority of the mail user. If activatable is true, users with Editor access can enable and disable the agent without resigning it.
	 * 
	 *        After the agent is configured, you can use the {@link NotesAgent} class to reset activatable and enable.
	 */
	public abstract String configureMailAgent(String userName, String agentName) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to configure an agent in a mail database on a user's home server.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param agentName
	 *            The name of the agent.
	 * @param activatable
	 *            <ul>
	 *            <li>true (default) to make the agent activatable</li>
	 *            <li>false to make the agent not activatable</li>
	 *            </ul>
	 * @param enable
	 *            <ul>
	 *            <li>true (default) to enable the agent</li>
	 *            <li>false to disable the agent</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method specifies username as the value of "Run on behalf of" under the Security tab in the Agent Properties box. This is useful to allow scheduled agents on a mail database to run
	 *        under the authority of the mail user. If activatable is true, users with Editor access can enable and disable the agent without resigning it.
	 * 
	 *        After the agent is configured, you can use the {@link NotesAgent} class to reset activatable and enable.
	 */
	public abstract String configureMailAgent(String userName, String agentName, boolean activatable, boolean enable) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to create a replica.
	 * 
	 * @param sourceserver
	 *            The full hierarchical name (can be abbreviated) of the server containing the database being replicated. An empty string ("") means the local server.
	 * @param sourcedbfile
	 *            The pathname of the database being replicated relative to the data directory.
	 * @param destserver
	 *            The full hierarchical name (can be abbreviated) of the server containing the replica. An empty string ("") means the local server.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Check access" and "Create replica" administration process requests.
	 */
	public abstract String createReplica(String sourceserver, String sourcedbfile, String destserver) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to create a replica.
	 * 
	 * @param sourceserver
	 *            The full hierarchical name (can be abbreviated) of the server containing the database being replicated. An empty string ("") means the local server.
	 * @param sourcedbfile
	 *            The pathname of the database being replicated relative to the data directory.
	 * @param destserver
	 *            The full hierarchical name (can be abbreviated) of the server containing the replica. An empty string ("") means the local server.
	 * @param destdbfile
	 *            The pathname of the new database relative to the data directory. Defaults to the same pathname as the source file.
	 * @param copyacl
	 *            <ul>
	 *            <li>true (default) to copy the ACL</li>
	 *            <li>false to not copy the ACL</li>
	 *            </ul>
	 * @param createftindex
	 *            <ul>
	 *            <li>true to creates a full-text index</li>
	 *            <li>false (default) to not create a full-text index</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Check access" and "Create replica" administration process requests.
	 */
	public abstract String createReplica(String sourceserver, String sourcedbfile, String destserver, String destdbfile, boolean copyacl, boolean createftindex) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete a group.
	 * 
	 * @param groupName
	 *            The name of the group.
	 * @param immediate
	 *            <ul>
	 *            <li>true to delete all references to the group in the Domino Directory before issuing an administration process request</li>
	 *            <li>false to let the administration process make all deletions</li>
	 *            </ul>
	 * @return An empty String
	 * @throws NotesApiException
	 */
	public abstract String deleteGroup(String groupName, boolean immediate) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete a group.
	 * 
	 * @param groupName
	 *            The name of the group.
	 * @param immediate
	 *            <ul>
	 *            <li>true to delete all references to the group in the Domino Directory before issuing an administration process request</li>
	 *            <li>false to let the administration process make all deletions</li>
	 *            </ul>
	 * @param deleteWindowsGroup
	 *            <ul>
	 *            <li>True also deletes the corresponding Windows group. t</li>
	 *            <li>False (default) does not delete the corresponding Windows group.</li>
	 *            </ul>
	 * @return An empty String
	 * @throws NotesApiException
	 * @usage This method triggers "Delete group in Domino Directory," "Delete in Person documents," "Delete in Access Control List," and "Delete in Reader / Author fields" administration process
	 *        requests.
	 */
	public abstract String deleteGroup(String groupName, boolean immediate, boolean deleteWindowsGroup) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete all replicas of a database.
	 * 
	 * @param serverName
	 *            The name of a server containing one of the replicas.
	 * @param fileName
	 *            The name of the database.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Get replica information for deletion" and "Delete replica" administration process requests.
	 */
	public abstract String deleteReplicas(String serverName, String fileName) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete a server.
	 * 
	 * @param serverName
	 *            The name of the server.
	 * @param immediate
	 *            <ul>
	 *            <li>true to delete all references to the server in the Domino Directory before issuing an administration process request</li>
	 *            <li>false to let the administration process make all deletions</li>
	 *            </ul>
	 * @return An empty String
	 * @throws NotesApiException
	 * @usage This method triggers "Delete server in Domino Directory," "Delete in Person documents," "Delete in Access Control List," and "Delete in Reader / Author fields" administration process
	 *        requests.
	 */
	public abstract String deleteServer(String serverName, boolean immediate) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete a user.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param immediate
	 *            <ul>
	 *            <li>true to delete all references to the user in the Domino Directory before issuing an administration process request</li>
	 *            <li>false to let the administration process make all deletions</li>
	 *            </ul>
	 * @param mailFileAction
	 *            Indicates the disposition of the user's mail file:
	 *            <ul>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_ALL deletes the mail file on the user's home server and all replicas.</li>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_HOME deletes the mail file on the user's home server.</li>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_NONE leaves the user's mail file.</li>
	 *            </ul>
	 * @param denyGroup
	 *            The name of an existing group of type "Deny List Only" to which the name of the deleted user is added. The empty string means do not add the user name to any group.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Delete person in Domino Directory," "Delete in Person documents," "Delete in Access Control List," "Delete in Reader / Author fields,"
	 *        "Get information for deletion," "Approve file deletion," "Request file deletion," "Delete mail file," "Delete unlinked mail file," "Approve deletion of Private Design Elements,"
	 *        "Request to delete Private Design Elements," and "Delete Private Design Elements" administration process requests.
	 */
	public abstract String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to delete a user.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param immediate
	 *            <ul>
	 *            <li>true to delete all references to the user in the Domino Directory before issuing an administration process request</li>
	 *            <li>false to let the administration process make all deletions</li>
	 *            </ul>
	 * @param mailFileAction
	 *            Indicates the disposition of the user's mail file:
	 *            <ul>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_ALL deletes the mail file on the user's home server and all replicas.</li>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_HOME deletes the mail file on the user's home server.</li>
	 *            <li>AdministrationProcess.MAILFILE_DELETE_NONE leaves the user's mail file.</li>
	 *            </ul>
	 * @param denyGroup
	 *            The name of an existing group of type "Deny List Only" to which the name of the deleted user is added. The empty string means do not add the user name to any group.
	 * @param deleteWindowsUser
	 *            <ul>
	 *            <li>true to delete the corresponding Windows user</li>
	 *            <li>false (default) to not delete the corresponding Windows user</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Delete person in Domino Directory," "Delete in Person documents," "Delete in Access Control List," "Delete in Reader / Author fields,"
	 *        "Get information for deletion," "Approve file deletion," "Request file deletion," "Delete mail file," "Delete unlinked mail file," "Approve deletion of Private Design Elements,"
	 *        "Request to delete Private Design Elements," and "Delete Private Design Elements" administration process requests.
	 */
	public abstract String deleteUser(String userName, boolean immediate, int mailFileAction, String denyGroup, boolean deleteWindowsUser) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to find all occurrences of a group in a domain.
	 * 
	 * @param group
	 *            The name of the group.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers the "Find Name in Domain" administration process request.
	 * 
	 *        Results are posted to response documents in the Administration Requests database.
	 */
	public abstract String findGroupInDomain(String group) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to find all occurrences of a server in a domain.
	 * 
	 * @param server
	 *            The name of the server.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers the "Find Name in Domain" administration process request.
	 * 
	 *        Results are posted to response documents in the Administration Requests database.
	 */
	public abstract String findServerInDomain(String server) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to find all occurrences of a user name in a domain.
	 * 
	 * @param user
	 *            The name of the user.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers the "Find Name in Domain" administration process request.
	 * 
	 *        Results are posted to response documents in the Administration Requests database.
	 */
	public abstract String findUserInDomain(String user) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a user's mail file.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param newHomeServer
	 *            The full hierarchical name (can be abbreviated) of the new home server for the user's mail file.
	 * @param newHomeServerMailPath
	 *            The path name of the new directory or folder for the user's mail file relative to the server's data directory. The path name does not include the file name.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a user's mail file.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param newHomeServer
	 *            The full hierarchical name (can be abbreviated) of the new home server for the user's mail file.
	 * @param newHomeServerMailPath
	 *            The path name of the new directory or folder for the user's mail file relative to the server's data directory. The path name does not include the file name.
	 * @param useSCOS
	 *            <ul>
	 *            <li>true if the new mail file makes use of the shared mail feature</li>
	 *            <li>false (default) if the new mail file does not make use of the shared mail feature</li>
	 *            </ul>
	 * @param newClusterReplicas
	 *            Replicas of the mail file in the same cluster as the new home server. The vector must consist of pairs of elements. The first element of the pair specifies the name of a server in
	 *            the same cluster as the new home server. The second element specifies the path in the same form as the new home server mail path.
	 * @param deleteOldClusterReplicas
	 *            <ul>
	 *            <li>true to delete existing replicas of the mail file on servers in the same cluster as the existing home server</li>
	 *            <li>false (default) to not delete existing replicas of the mail file on servers in the same cluster as the existing home server</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String moveMailUser(String userName, String newHomeServer, String newHomeServerMailPath, boolean useSCOS, Vector<String> newClusterReplicas, boolean deleteOldClusterReplicas)
			throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a replica.
	 * 
	 * @param sourceServer
	 *            The full hierarchical name (can be abbreviated) of the server containing the database being moved. An empty string ("") means the local server.
	 * @param sourceDbFile
	 *            The pathname of the database being moved relative to the data directory.
	 * @param destServer
	 *            The full hierarchical name (can be abbreviated) of the server containing the moved replica. An empty string ("") means the local server.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Check access" and "Non-cluster move replica" administration process requests.
	 */
	public abstract String moveReplica(String sourceServer, String sourceDbFile, String destServer) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a replica.
	 * 
	 * @param sourceServer
	 *            The full hierarchical name (can be abbreviated) of the server containing the database being moved. An empty string ("") means the local server.
	 * @param sourceDbFile
	 *            The pathname of the database being moved relative to the data directory.
	 * @param destServer
	 *            The full hierarchical name (can be abbreviated) of the server containing the moved replica. An empty string ("") means the local server.
	 * @param destDbFile
	 *            The pathname of the moved database relative to the data directory. Defaults to the same pathname as the source file.
	 * @param copyACL
	 *            <ul>
	 *            <li>true (default) to copy the ACL</li>
	 *            <li>false to not copy the ACL</li>
	 *            </ul>
	 * @param createFTIndex
	 *            <ul>
	 *            <li>true to create a full-text index</li>
	 *            <li>false (default) to not create a full-text index</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Check access" and "Non-cluster move replica" administration process requests.
	 */
	public abstract String moveReplica(String sourceServer, String sourceDbFile, String destServer, String destDbFile, boolean copyACL, boolean createFTIndex) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a user's roaming files to another server.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param destServer
	 *            The full hierarchical name (can be abbreviated) of the server to receive the user's roaming files.
	 * @param destServerPath
	 *            The path name of the new directory or folder for the roaming files relative to the server's data directory. The path name does not include the file name.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage The user must be configured as a roaming user. The administrator calling this method must have Create Replica rights on the destination server.
	 */
	public abstract String moveRoamingUser(String userName, String destServer, String destServerPath) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a user based on a previous request to move the user in the hierarchy.
	 * 
	 * @param requestNoteID
	 *            The note ID of the previous request to move the user in the hierarchy.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        This is phase 2 of the move. See {@link #moveUserInHierarchyRequest(String, String, boolean)} for phase 1.
	 */
	public abstract String moveUserInHierarchyComplete(String requestNoteID) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a user based on a previous request to move the user in the hierarchy.
	 * 
	 * @param requestNoteID
	 *            The note ID of the previous request to move the user in the hierarchy.
	 * @param lastName
	 *            New last name. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param firstName
	 *            New first name. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param middleInitial
	 *            New middle initial. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param orgUnit
	 *            New organizational unit. An empty string means just that. An asterisk (*) means no change. Defaults to no change. Do not duplicate the targetcertifier from the
	 *            moveUserInHierarchyRequest method. Use this parameter to specify a qualifying organizational unit, such as "Industry" in the hierarchical name Alice Brown/Industry/Sales/Acme.
	 * @param altCommonName
	 *            New alternate common name. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param altOrgUnit
	 *            New alternate organizational unit. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param altLanguage
	 *            New alternate language. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param renameWindowsUser
	 *            <ul>
	 *            <li>true to also change the corresponding Windows user account full name The Domino user's net user name, if defined, or short name is used as the Windows user name. The new values
	 *            of lastname, firstname, and middleinitial (the common name in Domino) are used to specify the the Window user's new full name. You must specify at least one of these parameters;
	 *            unspecified parameters default to the user entry in the Domino Directory.</li>
	 *            <li>false (default) to not change the corresponding Windows user account full name</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        This is phase 2 of the move. See {@link #moveUserInHierarchyRequest(String, String, boolean)} for phase 1.
	 */
	public abstract String moveUserInHierarchyComplete(String requestNoteID, String lastName, String firstName, String middleInitial, String orgUnit, String altCommonName, String altOrgUnit,
			String altLanguage, boolean renameWindowsUser) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a user's name in the hierarchy.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param targetCertifier
	 *            The name of the new certifier.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        This is phase 1 of the move. See {@link #moveUserInHierarchyComplete(String, String, String, String, String, String, String, String, boolean)} for phase 2.
	 */
	public abstract String moveUserInHierarchyRequest(String userName, String targetCertifier) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to move a user's name in the hierarchy.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param targetCertifier
	 *            The name of the new certifier.
	 * @param allowPrimaryNameChange
	 *            <ul>
	 *            <li>true if the user's primary name can be changed when the name is moved This requires R5.04 or higher on all servers involved in the move.</li>
	 *            <li>false (default) if the user's primary name cannot be changed when the name is moved</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        This is phase 1 of the move. See {@link #moveUserInHierarchyComplete(String, String, String, String, String, String, String, String, boolean)} for phase 2.
	 */
	public abstract String moveUserInHierarchyRequest(String userName, String targetCertifier, boolean allowPrimaryNameChange) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to recertify a Notes server.
	 * 
	 * @param server
	 *            The full hierarchical name (can be abbreviated) of the server.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 */
	public abstract String recertifyServer(String server) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to recertify a Notes user.
	 * 
	 * @param user
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 */
	public abstract String recertifyUser(String user) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to remove a server from a cluster.
	 * 
	 * @param server
	 *            The name of the server.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String removeServerFromCluster(String server) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a group.
	 * 
	 * @param group
	 *            The name of the group.
	 * @param newGroup
	 *            The new name of the group.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage This method triggers "Rename group in Domino Directory," "Rename group in Person documents," "Rename group in Access Control List," and "Rename group in Reader / Author fields"
	 *        administration process requests.
	 */
	public abstract String renameGroup(String group, String newGroup) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a user.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param lastName
	 *            New last name. An empty string means just that. An asterisk (*) means no change.
	 * @param firstName
	 *            New first name. An empty string means just that. An asterisk (*) means no change.
	 * @param middleInitial
	 *            New middle initial. An empty string means just that. An asterisk (*) means no change.
	 * @param orgUnit
	 *            New organizational unit. An empty string means just that. An asterisk (*) means no change.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        You must specify at least one of these parameters: lastname, firstname, middleinitial, orgunit, altcommonname, altorgunit, or altlanguage.
	 */
	public abstract String renameNotesUser(String userName, String lastName, String firstName, String middleInitial, String orgUnit) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a user.
	 * 
	 * @param userName
	 *            The hierarchical name of the user in canonical or abbreviated form.
	 * @param lastName
	 *            New last name. An empty string means just that. An asterisk (*) means no change.
	 * @param firstName
	 *            New first name. An empty string means just that. An asterisk (*) means no change.
	 * @param middleInitial
	 *            New middle initial. An empty string means just that. An asterisk (*) means no change.
	 * @param orgUnit
	 *            New organizational unit. An empty string means just that. An asterisk (*) means no change.
	 * @param altCommonName
	 *            New alternate common name. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param altOrgUnit
	 *            New alternate organizational unit. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param altLanguage
	 *            New alternate language. An empty string means just that. An asterisk (*) means no change. Defaults to no change.
	 * @param renameWindowsUser
	 *            <ul>
	 *            <li>true to change the corresponding Windows user account full name The Domino user's net user name, if defined, or short name is used as the Windows user name. The new values of
	 *            lastname, firstname, and middleinitial (the common name in Domino) are used to specify the Window user's new full name. You must specify at least one of these parameters; unspecified
	 *            parameters default to the user entry in the Domino Directory.</li>
	 *            <li>false (default) to not change the corresponding Windows user account full name</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 * 
	 *        You must specify at least one of these parameters: lastname, firstname, middleinitial, orgunit, altcommonname, altorgunit, or altlanguage.
	 */
	public abstract String renameNotesUser(String userName, String lastName, String firstName, String middleInitial, String orgUnit, String altCommonName, String altOrgUnit, String altLanguage,
			boolean renameWindowsUser) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to rename a Web user.
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user.
	 * @param newFullName
	 *            New full hierarchical name (can be abbreviated).
	 * @param newLastName
	 *            New last name. An empty string means just that. An asterisk (*) means no change.
	 * @param newFirstName
	 *            New first name. An empty string means just that. An asterisk (*) means no change.
	 * @param newMiddleInitial
	 *            New middle initial. An empty string means just that. An asterisk (*) means no change.
	 * @param newShortName
	 *            New short name. An empty string means just that. An asterisk (*) means no change.
	 * @param newInternetAddress
	 *            New internet address. An empty string means just that. An asterisk (*) means no change.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String renameWebUser(String userName, String newFullName, String newLastName, String newFirstName, String newMiddleInitial, String newShortName, String newInternetAddress)
			throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to set the Directory Assistance field in a server document.
	 * 
	 * @param server
	 *            The name of the server on which to change the settings.
	 * @param dbFile
	 *            The pathname of the Directory Assistance replica on the server.
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String setServerDirectoryAssistanceSettings(String server, String dbFile) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to change the password management settings on the Administration tab of the user's person document
	 * 
	 * @param userName
	 *            The full hierarchical name (can be abbreviated) of the user
	 * @param notesPasswordCheckSetting
	 *            <ul>
	 *            <li>NotesAdministrationProcess.PWD_CHK_CHECKPASSWORD requires the user to enter a password when authenticating with servers that have password checking enabled</li>
	 *            <li>NotesAdministrationProcess.PWD_CHK_DONTCHECKPASSWORD does not require the user to enter a password when authenticating with other servers (default)</li>
	 *            <li>NotesAdministrationProcess.PWD_CHK_LOCKOUT prevents the user from accessing servers that have password checking enabled</li>
	 *            </ul>
	 * @param notesPasswordChangeInterval
	 *            Required change interval - number of days at which the user must supply a new password. Defaults to zero.
	 * @param notesPasswordGracePeriod
	 *            Grace period (in days) for changing the password. Defaults to zero.
	 * @param internetPasswordForceChange
	 *            <ul>
	 *            <li>true to force the user to change the password on next login</li>
	 *            <li>false to not force the user to change the password (default)</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 * @usage Specify null to take the default for the optional parameters 2-5.
	 * 
	 *        At least one optional parameter must be specified.
	 */
	public abstract String setUserPasswordSettings(String userName, Integer notesPasswordCheckSetting, Integer notesPasswordChangeInterval, Integer notesPasswordGracePeriod,
			Boolean internetPasswordForceChange) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to sign a database.
	 * 
	 * @param server
	 *            The full hierarchical name (can be abbreviated) of the server containing the database to be signed. The empty string ("") means the local server
	 * @param dbFile
	 *            New pathname of the database to be signed
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String signDatabaseWithServerID(String server, String dbFile) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to sign a database.
	 * 
	 * @param server
	 *            The full hierarchical name (can be abbreviated) of the server containing the database to be signed. The empty string ("") means the local server
	 * @param dbFile
	 *            New pathname of the database to be signed
	 * @param updateOnly
	 *            <ul>
	 *            <li>true to sign only existing signatures (faster)</li>
	 *            <li>false (default) to always sign the database</li>
	 *            </ul>
	 * @return The note ID of an entry created in the Administration Requests database.
	 * @throws NotesApiException
	 */
	public abstract String signDatabaseWithServerID(String server, String dbFile, boolean updateOnly) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to upgrade a user from a flat ID to a hierarchical ID.
	 * 
	 * @param userName
	 *            The flat name of the user.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 */
	public abstract String upgradeUserToHierarchical(String userName) throws NotesApiException;

	/**
	 * Enters a request in the Administration Requests database to upgrade a user from a flat ID to a hierarchical ID.
	 * 
	 * @param userName
	 *            The flat name of the user.
	 * @param orgUnit
	 *            New organizational unit.
	 * @param altCommonName
	 *            New alternate common name.
	 * @param altOrgUnit
	 *            New alternate organizational unit.
	 * @param altLanguage
	 *            New alternate language.
	 * @return The note ID of an entry created in the Administration Requests database, or an empty string if the certificate authority processes the request.
	 * @throws NotesApiException
	 * @usage The AdministrationProcess properties must specify a certifier.
	 */
	public abstract String upgradeUserToHierarchical(String userName, String orgUnit, String altCommonName, String altOrgUnit, String altLanguage) throws NotesApiException;
}