package org.openntf.domino.mock.interfaces;

import java.applet.Applet;
import java.io.BufferedReader;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesFactory {
	// public abstract NotesTrace trace;
	// public abstract final transient Hashtable m_serverCache;
	// public abstract int m_serverCacheMinsValid;
	// abstract synthetic Class class$lotus$domino$NotesFactory;
	// public NotesFactory();

	public abstract NotesSession createSessionWithFullAccess()
			throws NotesApiException;

	public abstract NotesSession createSessionWithFullAccess(String passwd)
			throws NotesApiException;

	public abstract NotesSession createTrustedSession()
			throws NotesApiException;

	public abstract NotesSession createSession() throws NotesApiException;

	public abstract NotesSession createSession(String host)
			throws NotesApiException;

	public abstract NotesSession createSession(String host, String user,
			String passwd) throws NotesApiException;

	public abstract NotesSession createSession(String host, String[] args,
			String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSession(String host, ORB orb,
			String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR)
			throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR, String user,
			String passwd) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR,
			String[] args, String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR, ORB orb,
			String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSession(Applet app,
			String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSession(Applet app,
			ORB orb, String user, String passwd) throws NotesApiException;

	public abstract NotesSession createSession(String host, Object cookie)
			throws NotesApiException;

	public abstract NotesSession createSession(String host, String[] args,
			Object cookie) throws NotesApiException;

	public abstract NotesSession createSession(String host, ORB orb,
			Object cookie) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR, Object cookie)
			throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR,
			String[] args, Object cookie) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String iOR, ORB orb,
			Object cookie) throws NotesApiException;

	public abstract NotesSession createSessionUP(String arg0, String arg1,
			String[] arg2, ORB arg3, String arg4, String arg5)
			throws NotesApiException;

	public abstract NotesSession createSessionC(String arg0, String arg1,
			String[] arg2, ORB arg3, Object arg4) throws NotesApiException;

	public abstract ORB createORB();

	public abstract ORB createORB(String[] args);

	public abstract ORB createORB(Properties props);

	public abstract String getIOR(String host) throws NotesApiException;

	public abstract String getIOR(String host, String user, String passwd)
			throws NotesApiException;

	public abstract String getIOR(String host, String[] args)
			throws NotesApiException;

	public abstract String getIOR(String host, String[] args, String user,
			String passwd) throws NotesApiException;

	public abstract String getIOR(String host, String arg1, String[] arg2,
			String arg3, String arg4) throws NotesApiException;

	public abstract String requestIORUsingArgs(String arg0, String[] arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract String requestIORPlain(String arg0, String arg1, String arg2)
			throws NotesApiException;

	public abstract String requestIORUsingSSL(String arg0, String[] arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract String parseForIOR(BufferedReader arg0)
			throws NotesApiException;

	public abstract boolean isLocal(String arg0, String arg1);

}
