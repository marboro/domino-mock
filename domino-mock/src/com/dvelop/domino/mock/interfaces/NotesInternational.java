package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesInternational extends NotesBase {
	public abstract String getAMString() throws NotesApiException;

	public abstract int getCurrencyDigits() throws NotesApiException;

	public abstract String getCurrencySymbol() throws NotesApiException;

	public abstract String getDateSep() throws NotesApiException;

	public abstract String getDecimalSep() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getPMString() throws NotesApiException;

	public abstract String getThousandsSep() throws NotesApiException;

	public abstract String getTimeSep() throws NotesApiException;

	public abstract int getTimeZone() throws NotesApiException;

	public abstract String getToday() throws NotesApiException;

	public abstract String getTomorrow() throws NotesApiException;

	public abstract String getYesterday() throws NotesApiException;

	public abstract boolean isCurrencySuffix() throws NotesApiException;

	public abstract boolean isCurrencySpace() throws NotesApiException;

	public abstract boolean isCurrencyZero() throws NotesApiException;

	public abstract boolean isDateMDY() throws NotesApiException;

	public abstract boolean isDateDMY() throws NotesApiException;

	public abstract boolean isDateYMD() throws NotesApiException;

	public abstract boolean isDST() throws NotesApiException;

	public abstract boolean isTime24Hour() throws NotesApiException;
}
