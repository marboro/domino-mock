package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesColorObject;

public class NotesColorObjectMockImpl extends NotesBaseMockImpl implements
		NotesColorObject {

	// TODO NotesColor ermitteln

	private int red;
	private int green;
	private int blue;
	private int hue;
	private int saturation;
	private int luminance;
	private int notesColor;

	@Override
	public int setRGB(int red, int green, int blue) throws NotesApiException {
		this.red = red;
		this.green = green;
		this.blue = blue;
		calculateHSL();
		return 0;
	}

	@Override
	public int setHSL(int hue, int saturation, int luminance)
			throws NotesApiException {
		this.hue = hue;
		this.saturation = saturation;
		this.luminance = luminance;
		calculateRGB();
		return 0;
	}

	@Override
	public int getRed() throws NotesApiException {
		return red;
	}

	@Override
	public int getGreen() throws NotesApiException {
		return green;
	}

	@Override
	public int getBlue() throws NotesApiException {
		return blue;
	}

	@Override
	public int getHue() throws NotesApiException {
		return hue;
	}

	@Override
	public int getSaturation() throws NotesApiException {
		return saturation;
	}

	@Override
	public int getLuminance() throws NotesApiException {
		return luminance;
	}

	@Override
	public int getNotesColor() throws NotesApiException {
		return notesColor;
	}

	@Override
	public void setNotesColor(int notesColor) throws NotesApiException {
		this.notesColor = notesColor;
	}

	// Helper-Functions for calculations

	/**
	 * Convert the RGB values to it corresponding HSL values.
	 */
	private void calculateHSL() {
		// Get RGB values in the range 0 - 1
		float r = red;
		float g = green;
		float b = blue;

		// Minimum and Maximum RGB values are used in the HSL calculations

		float min = Math.min(r, Math.min(g, b));
		float max = Math.max(r, Math.max(g, b));

		// Calculate the Hue

		float h = 0;

		if (max == min)
			h = 0;
		else if (max == r)
			h = ((60 * (g - b) / (max - min)) + 360) % 360;
		else if (max == g)
			h = (60 * (b - r) / (max - min)) + 120;
		else if (max == b)
			h = (60 * (r - g) / (max - min)) + 240;

		// Calculate the Luminance

		float l = (max + min) / 2;
		System.out.println(max + " : " + min + " : " + l);

		// Calculate the Saturation

		float s = 0;

		if (max == min)
			s = 0;
		else if (l <= .5f)
			s = (max - min) / (max + min);
		else
			s = (max - min) / (2 - max - min);
		this.hue = (int) (h + 0.5);
		this.saturation = (int) s * 100;
		this.luminance = (int) l * 100;
	}

	/**
	 * Convert HSL values to its corresponding RGB values.
	 */
	private void calculateRGB() {
		float alpha = 1.0f;
		float h = hue;
		float s = saturation;
		float l = luminance;
		if (s < 0.0f || s > 100.0f) {
			String message = "Color parameter outside of expected range - Saturation";
			throw new IllegalArgumentException(message);
		}

		if (l < 0.0f || l > 100.0f) {
			String message = "Color parameter outside of expected range - Luminance";
			throw new IllegalArgumentException(message);
		}

		if (alpha < 0.0f || alpha > 1.0f) {
			String message = "Color parameter outside of expected range - Alpha";
			throw new IllegalArgumentException(message);
		}

		// Formula needs all values between 0 - 1.

		h = h % 360.0f;
		h /= 360f;
		s /= 100f;
		l /= 100f;

		float q = 0;

		if (l < 0.5)
			q = l * (1 + s);
		else
			q = (l + s) - (s * l);

		float p = 2 * l - q;

		float r = Math.max(0, HueToRGB(p, q, h + (1.0f / 3.0f)));
		float g = Math.max(0, HueToRGB(p, q, h));
		float b = Math.max(0, HueToRGB(p, q, h - (1.0f / 3.0f)));

		r = Math.min(r, 1.0f);
		g = Math.min(g, 1.0f);
		b = Math.min(b, 1.0f);

		this.red = (int) r;
		this.green = (int) g;
		this.blue = (int) b;
	}

	private float HueToRGB(float p, float q, float h) {
		if (h < 0)
			h += 1;
		if (h > 1)
			h -= 1;
		if (6 * h < 1) {
			return p + ((q - p) * 6 * h);
		}
		if (2 * h < 1) {
			return q;
		}
		if (3 * h < 2) {
			return p + ((q - p) * 6 * ((2.0f / 3.0f) - h));
		}
		return p;
	}

}