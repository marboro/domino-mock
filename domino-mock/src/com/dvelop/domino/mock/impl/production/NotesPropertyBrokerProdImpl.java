package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.NotesException;
import lotus.domino.PropertyBroker;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesProperty;
import com.dvelop.domino.mock.interfaces.NotesPropertyBroker;

public class NotesPropertyBrokerProdImpl extends NotesBaseProdImpl implements
		NotesPropertyBroker {

	private final PropertyBroker propertyBroker;

	public NotesPropertyBrokerProdImpl(PropertyBroker propertyBroker) {
		this.propertyBroker = propertyBroker;
	}

	public PropertyBroker get() {
		return propertyBroker;
	}

	@Override
	public Vector getInputPropertyContext() throws NotesApiException {
		try {
			return propertyBroker.getInputPropertyContext();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getPropertyValue(String arg0) throws NotesApiException {
		try {
			return propertyBroker.getPropertyValue(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPropertyValueString(String arg0) throws NotesApiException {
		try {
			return propertyBroker.getPropertyValueString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesProperty setPropertyValue(String arg0, Object arg1)
			throws NotesApiException {
		try {
			return new NotesPropertyProdImpl(propertyBroker.setPropertyValue(
					arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void publish() throws NotesApiException {
		try {
			propertyBroker.publish();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void clearProperty(String arg0) throws NotesApiException {
		try {
			propertyBroker.clearProperty(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean hasProperty(String arg0) throws NotesApiException {
		try {
			return propertyBroker.hasProperty(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesProperty getProperty(String arg0) throws NotesApiException {
		try {
			return new NotesPropertyProdImpl(propertyBroker.getProperty(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}