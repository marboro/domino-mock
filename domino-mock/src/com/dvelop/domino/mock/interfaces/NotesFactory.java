package com.dvelop.domino.mock.interfaces;

import java.io.BufferedReader;
import java.util.Properties;

import org.omg.CORBA.ORB;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesFactory {
	// public abstract NotesTrace trace;
	// public abstract final transient Hashtable m_serverCache;
	// public abstract int m_serverCacheMinsValid;
	// abstract synthetic Class class$lotus$domino$NotesFactory;
	// public NotesFactory();

	public abstract NotesSession createSessionWithFullAccess()
			throws NotesApiException;

	public abstract NotesSession createSessionWithFullAccess(String arg0)
			throws NotesApiException;

	public abstract NotesSession createTrustedSession()
			throws NotesApiException;

	public abstract NotesSession createSession() throws NotesApiException;

	public abstract NotesSession createSession(String arg0)
			throws NotesApiException;

	public abstract NotesSession createSession(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract NotesSession createSession(String arg0, String[] arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract NotesSession createSession(String arg0, ORB arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0)
			throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0, String arg1,
			String arg2) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0,
			String[] arg1, String arg2, String arg3) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0, ORB arg1,
			String arg2, String arg3) throws NotesApiException;

	public abstract NotesSession createSession(java.applet.Applet arg0,
			String arg1, String arg2) throws NotesApiException;

	public abstract NotesSession createSession(java.applet.Applet arg0,
			ORB arg1, String arg2, String arg3) throws NotesApiException;

	public abstract NotesSession createSession(String arg0, Object arg1)
			throws NotesApiException;

	public abstract NotesSession createSession(String arg0, String[] arg1,
			Object arg2) throws NotesApiException;

	public abstract NotesSession createSession(String arg0, ORB arg1,
			Object arg2) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0, Object arg1)
			throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0,
			String[] arg1, Object arg2) throws NotesApiException;

	public abstract NotesSession createSessionWithIOR(String arg0, ORB arg1,
			Object arg2) throws NotesApiException;

	public abstract NotesSession createSessionUP(String arg0, String arg1,
			String[] arg2, ORB arg3, String arg4, String arg5)
			throws NotesApiException;

	public abstract NotesSession createSessionC(String arg0, String arg1,
			String[] arg2, ORB arg3, Object arg4) throws NotesApiException;

	public abstract ORB createORB();

	public abstract ORB createORB(String[] arg0);

	public abstract ORB createORB(Properties arg0);

	public abstract String getIOR(String arg0) throws NotesApiException;

	public abstract String getIOR(String arg0, String arg1, String arg2)
			throws NotesApiException;

	public abstract String getIOR(String arg0, String[] arg1)
			throws NotesApiException;

	public abstract String getIOR(String arg0, String[] arg1, String arg2,
			String arg3) throws NotesApiException;

	public abstract String getIOR(String arg0, String arg1, String[] arg2,
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
