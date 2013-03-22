package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesProperty;

import lotus.domino.NotesException;


public class NotesPropertyProdImpl extends NotesBaseProdImpl implements
		NotesProperty {

	private final lotus.domino.NotesProperty property;

	public NotesPropertyProdImpl(lotus.domino.NotesProperty property) {
		this.property = property;
	}

	public lotus.domino.NotesProperty get() {
		return property;
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return property.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNamespace() throws NotesApiException {
		try {
			return property.getNamespace();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getValues() throws NotesApiException {
		try {
			return property.getValues();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getValueString() throws NotesApiException {
		try {
			return property.getValueString();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTypeName() throws NotesApiException {
		try {
			return property.getTypeName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isInput() throws NotesApiException {
		try {
			return property.isInput();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTitle() throws NotesApiException {
		try {
			return property.getTitle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDescription() throws NotesApiException {
		try {
			return property.getDescription();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void publish() throws NotesApiException {
		try {
			property.publish();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void clear() throws NotesApiException {
		try {
			property.clear();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}