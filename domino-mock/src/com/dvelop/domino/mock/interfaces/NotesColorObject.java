package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesColorObject extends NotesBase {
	public abstract int setRGB(int red, int green, int blue)
			throws NotesApiException;

	public abstract int setHSL(int hue, int saturation, int luminance)
			throws NotesApiException;

	public abstract int getRed() throws NotesApiException;

	public abstract int getGreen() throws NotesApiException;

	public abstract int getBlue() throws NotesApiException;

	public abstract int getHue() throws NotesApiException;

	public abstract int getSaturation() throws NotesApiException;

	public abstract int getLuminance() throws NotesApiException;

	public abstract int getNotesColor() throws NotesApiException;

	public abstract void setNotesColor(int notesColor) throws NotesApiException;
}
