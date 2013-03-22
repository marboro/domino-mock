package org.openntf.domino.mock.interfaces;

import java.util.Calendar;
import java.util.Date;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesDateTime extends NotesBase {
	public abstract void adjustHour(int n) throws NotesApiException;

	public abstract void adjustHour(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void adjustMinute(int n) throws NotesApiException;

	public abstract void adjustMinute(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void adjustSecond(int n) throws NotesApiException;

	public abstract void adjustSecond(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void adjustDay(int n) throws NotesApiException;

	public abstract void adjustDay(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void adjustMonth(int n) throws NotesApiException;

	public abstract void adjustMonth(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void adjustYear(int n) throws NotesApiException;

	public abstract void adjustYear(int n, boolean preserveLocalTime)
			throws NotesApiException;

	public abstract void convertToZone(int zone, boolean isDST)
			throws NotesApiException;

	public abstract void setAnyDate() throws NotesApiException;

	public abstract void setAnyTime() throws NotesApiException;

	public abstract void setNow() throws NotesApiException;

	public abstract int timeDifference(NotesDateTime dt)
			throws NotesApiException;

	public abstract double timeDifferenceDouble(NotesDateTime dt)
			throws NotesApiException;

	public abstract void setLocalDate(int year, int month, int day)
			throws NotesApiException;

	public abstract void setLocalDate(int year, int month, int day,
			boolean preserveLocalTime) throws NotesApiException;

	public abstract void setLocalTime(int hour, int minute, int second,
			int hundreth) throws NotesApiException;

	public abstract void setLocalTime(Date dt) throws NotesApiException;

	public abstract void setLocalTime(Calendar dt) throws NotesApiException;

	public abstract String getGMTTime() throws NotesApiException;

	public abstract boolean isDST() throws NotesApiException;

	public abstract String getLocalTime() throws NotesApiException;

	public abstract void setLocalTime(String dt) throws NotesApiException;

	public abstract int getTimeZone() throws NotesApiException;

	public abstract String getZoneTime() throws NotesApiException;

	public abstract String getDateOnly() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getTimeOnly() throws NotesApiException;

	public abstract Date toJavaDate() throws NotesApiException;
}
