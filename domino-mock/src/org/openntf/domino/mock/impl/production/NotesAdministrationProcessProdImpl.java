package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesAdministrationProcess;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesSession;

import lotus.domino.AdministrationProcess;
import lotus.domino.NotesException;


public class NotesAdministrationProcessProdImpl extends NotesBaseProdImpl
		implements NotesAdministrationProcess {

	private final AdministrationProcess administrationProcess;

	public NotesAdministrationProcessProdImpl(
			AdministrationProcess administrationProcess) {
		this.administrationProcess = administrationProcess;
	}

	public AdministrationProcess get() {
		return administrationProcess;
	}

	@Override
	public String getCertificateAuthorityOrg() throws NotesApiException {
		try {
			return administrationProcess.getCertificateAuthorityOrg();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCertificateAuthorityOrg(String arg0)
			throws NotesApiException {
		try {
			administrationProcess.setCertificateAuthorityOrg(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesDateTime getCertificateExpiration() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(
					administrationProcess.getCertificateExpiration());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCertificateExpiration(NotesDateTime arg0)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg0;
			administrationProcess.setCertificateExpiration(dateTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getCertifierFile() throws NotesApiException {
		try {
			return administrationProcess.getCertifierFile();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCertifierFile(String arg0) throws NotesApiException {
		try {
			administrationProcess.setCertifierFile(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getCertifierPassword() throws NotesApiException {
		try {
			return administrationProcess.getCertifierPassword();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCertifierPassword(String arg0) throws NotesApiException {
		try {
			administrationProcess.setCertifierPassword(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCertificateAuthorityAvailable() throws NotesApiException {
		try {
			return administrationProcess.isCertificateAuthorityAvailable();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isUseCertificateAuthority() throws NotesApiException {
		try {
			return administrationProcess.isUseCertificateAuthority();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUseCertificateAuthority(boolean arg0)
			throws NotesApiException {
		try {
			administrationProcess.setUseCertificateAuthority(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(administrationProcess.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String addGroupMembers(String arg0, Vector arg1)
			throws NotesApiException {
		try {
			return administrationProcess.addGroupMembers(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String addInternetCertificateToUser(String arg0, String arg1,
			String arg2) throws NotesApiException {
		try {
			return administrationProcess.addInternetCertificateToUser(arg0,
					arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String addInternetCertificateToUser(String arg0, String arg1,
			String arg2, NotesDateTime arg3) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg3;
			return administrationProcess.addInternetCertificateToUser(arg0,
					arg1, arg2, dateTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String addServerToCluster(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.addServerToCluster(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveDeletePersonInDirectory(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveDeletePersonInDirectory(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveDeleteServerInDirectory(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveDeleteServerInDirectory(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveDesignElementDeletion(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveDesignElementDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveMailFileDeletion(String arg0) throws NotesApiException {
		try {
			return administrationProcess.approveMailFileDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveMovedReplicaDeletion(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveMovedReplicaDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveNameChangeRetraction(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveNameChangeRetraction(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveRenamePersonInDirectory(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveRenamePersonInDirectory(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveRenameServerInDirectory(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveRenameServerInDirectory(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveReplicaDeletion(String arg0) throws NotesApiException {
		try {
			return administrationProcess.approveReplicaDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveResourceDeletion(String arg0) throws NotesApiException {
		try {
			return administrationProcess.approveResourceDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String approveHostedOrgStorageDeletion(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.approveHostedOrgStorageDeletion(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String changeHTTPPassword(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return administrationProcess.changeHTTPPassword(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String configureMailAgent(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.configureMailAgent(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String configureMailAgent(String arg0, String arg1, boolean arg2,
			boolean arg3) throws NotesApiException {
		try {
			return administrationProcess.configureMailAgent(arg0, arg1, arg2,
					arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String createReplica(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return administrationProcess.createReplica(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String createReplica(String arg0, String arg1, String arg2,
			String arg3, boolean arg4, boolean arg5) throws NotesApiException {
		try {
			return administrationProcess.createReplica(arg0, arg1, arg2, arg3,
					arg4, arg5);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteGroup(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return administrationProcess.deleteGroup(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteGroup(String arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		try {
			return administrationProcess.deleteGroup(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteReplicas(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.deleteReplicas(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteServer(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return administrationProcess.deleteServer(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteUser(String arg0, boolean arg1, int arg2, String arg3)
			throws NotesApiException {
		try {
			return administrationProcess.deleteUser(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String deleteUser(String arg0, boolean arg1, int arg2, String arg3,
			boolean arg4) throws NotesApiException {
		try {
			return administrationProcess.deleteUser(arg0, arg1, arg2, arg3,
					arg4);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String findGroupInDomain(String arg0) throws NotesApiException {
		try {
			return administrationProcess.findGroupInDomain(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String findServerInDomain(String arg0) throws NotesApiException {
		try {
			return administrationProcess.findServerInDomain(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String findUserInDomain(String arg0) throws NotesApiException {
		try {
			return administrationProcess.findUserInDomain(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveMailUser(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return administrationProcess.moveMailUser(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveMailUser(String arg0, String arg1, String arg2,
			boolean arg3, Vector arg4, boolean arg5) throws NotesApiException {
		try {
			return administrationProcess.moveMailUser(arg0, arg1, arg2, arg3,
					arg4, arg5);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveReplica(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return administrationProcess.moveReplica(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveReplica(String arg0, String arg1, String arg2,
			String arg3, boolean arg4, boolean arg5) throws NotesApiException {
		try {
			return administrationProcess.moveReplica(arg0, arg1, arg2, arg3,
					arg4, arg5);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveRoamingUser(String arg0, String arg1, String arg2)
			throws NotesApiException {
		try {
			return administrationProcess.moveRoamingUser(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveUserInHierarchyComplete(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.moveUserInHierarchyComplete(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveUserInHierarchyComplete(String arg0, String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6,
			String arg7, boolean arg8) throws NotesApiException {
		try {
			return administrationProcess.moveUserInHierarchyComplete(arg0,
					arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveUserInHierarchyRequest(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.moveUserInHierarchyRequest(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String moveUserInHierarchyRequest(String arg0, String arg1,
			boolean arg2) throws NotesApiException {
		try {
			return administrationProcess.moveUserInHierarchyRequest(arg0, arg1,
					arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String recertifyServer(String arg0) throws NotesApiException {
		try {
			return administrationProcess.recertifyServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String recertifyUser(String arg0) throws NotesApiException {
		try {
			return administrationProcess.recertifyUser(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String removeServerFromCluster(String arg0) throws NotesApiException {
		try {
			return administrationProcess.removeServerFromCluster(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String renameGroup(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.renameGroup(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String renameNotesUser(String arg0, String arg1, String arg2,
			String arg3, String arg4) throws NotesApiException {
		try {
			return administrationProcess.renameNotesUser(arg0, arg1, arg2,
					arg3, arg4);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String renameNotesUser(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6, String arg7,
			boolean arg8) throws NotesApiException {
		try {
			return administrationProcess.renameNotesUser(arg0, arg1, arg2,
					arg3, arg4, arg5, arg6, arg7, arg8);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String renameWebUser(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5, String arg6)
			throws NotesApiException {
		try {
			return administrationProcess.renameWebUser(arg0, arg1, arg2, arg3,
					arg4, arg5, arg6);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String setServerDirectoryAssistanceSettings(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.setServerDirectoryAssistanceSettings(
					arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String setUserPasswordSettings(String arg0, Integer arg1,
			Integer arg2, Integer arg3, Boolean arg4) throws NotesApiException {
		try {
			return administrationProcess.setUserPasswordSettings(arg0, arg1,
					arg2, arg3, arg4);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String signDatabaseWithServerID(String arg0, String arg1)
			throws NotesApiException {
		try {
			return administrationProcess.signDatabaseWithServerID(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String signDatabaseWithServerID(String arg0, String arg1,
			boolean arg2) throws NotesApiException {
		try {
			return administrationProcess.signDatabaseWithServerID(arg0, arg1,
					arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String upgradeUserToHierarchical(String arg0)
			throws NotesApiException {
		try {
			return administrationProcess.upgradeUserToHierarchical(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String upgradeUserToHierarchical(String arg0, String arg1,
			String arg2, String arg3, String arg4) throws NotesApiException {
		try {
			return administrationProcess.upgradeUserToHierarchical(arg0, arg1,
					arg2, arg3, arg4);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}