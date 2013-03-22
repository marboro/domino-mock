package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesColorObject;

import lotus.domino.ColorObject;
import lotus.domino.NotesException;


public class NotesColorObjectProdImpl extends NotesBaseProdImpl implements
		NotesColorObject {

	private final ColorObject colorObject;

	public NotesColorObjectProdImpl(ColorObject colorObject) {
		this.colorObject = colorObject;
	}

	public ColorObject get() {
		return colorObject;
	}

	@Override
	public int setRGB(int arg0, int arg1, int arg2) throws NotesApiException {
		try {
			return colorObject.setRGB(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int setHSL(int arg0, int arg1, int arg2) throws NotesApiException {
		try {
			return colorObject.setHSL(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getRed() throws NotesApiException {
		try {
			return colorObject.getRed();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getGreen() throws NotesApiException {
		try {
			return colorObject.getGreen();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getBlue() throws NotesApiException {
		try {
			return colorObject.getBlue();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getHue() throws NotesApiException {
		try {
			return colorObject.getHue();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSaturation() throws NotesApiException {
		try {
			return colorObject.getSaturation();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getLuminance() throws NotesApiException {
		try {
			return colorObject.getLuminance();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getNotesColor() throws NotesApiException {
		try {
			return colorObject.getNotesColor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setNotesColor(int arg0) throws NotesApiException {
		try {
			colorObject.setNotesColor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}