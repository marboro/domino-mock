package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesPropertyBroker extends NotesBase {
	public abstract Vector getInputPropertyContext() throws NotesApiException;

	public abstract Vector getPropertyValue(String propertyName)
			throws NotesApiException;

	public abstract String getPropertyValueString(String propertyName)
			throws NotesApiException;

	public abstract NotesProperty setPropertyValue(String propertyName, Object propertyValue)
			throws NotesApiException;

	public abstract void publish() throws NotesApiException;

	public abstract void clearProperty(String propertyName) throws NotesApiException;

	public abstract boolean hasProperty(String propertyName) throws NotesApiException;

	public abstract NotesProperty getProperty(String arg0)
			throws NotesApiException;
}
