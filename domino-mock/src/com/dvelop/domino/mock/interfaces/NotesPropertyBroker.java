package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesPropertyBroker extends NotesBase {
	public abstract Vector getInputPropertyContext() throws NotesApiException;

	public abstract Vector getPropertyValue(String arg0)
			throws NotesApiException;

	public abstract String getPropertyValueString(String arg0)
			throws NotesApiException;

	public abstract NotesProperty setPropertyValue(String arg0, Object arg1)
			throws NotesApiException;

	public abstract void publish() throws NotesApiException;

	public abstract void clearProperty(String arg0) throws NotesApiException;

	public abstract boolean hasProperty(String arg0) throws NotesApiException;

	public abstract NotesProperty getProperty(String arg0)
			throws NotesApiException;
}
