package com.dvelop.domino.mock.impl.mock;

import java.util.Calendar;
import java.util.Date;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesDateTimeMockImpl extends NotesBaseMockImpl implements NotesDateTime {

	private Calendar calendar;

	public NotesDateTimeMockImpl(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
	}

	@Override
	public void adjustHour(int n) throws NotesApiException {
		calendar.roll(Calendar.HOUR_OF_DAY, n);

	}

	@Override
	public void adjustHour(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.HOUR_OF_DAY, n);

	}

	@Override
	public void adjustMinute(int n) throws NotesApiException {
		calendar.roll(Calendar.MINUTE, n);

	}

	@Override
	public void adjustMinute(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.MINUTE, n);

	}

	@Override
	public void adjustSecond(int n) throws NotesApiException {
		calendar.roll(Calendar.SECOND, n);
	}

	@Override
	public void adjustSecond(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.SECOND, n);
	}

	@Override
	public void adjustDay(int n) throws NotesApiException {
		calendar.roll(Calendar.DAY_OF_MONTH, n);
	}

	@Override
	public void adjustDay(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.DAY_OF_MONTH, n);
	}

	@Override
	public void adjustMonth(int n) throws NotesApiException {
		calendar.roll(Calendar.MONTH, n);
	}

	@Override
	public void adjustMonth(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.MONTH, n);
	}

	@Override
	public void adjustYear(int n) throws NotesApiException {
		calendar.roll(Calendar.YEAR, n);
	}

	@Override
	public void adjustYear(int n, boolean preserveLocalTime) throws NotesApiException {
		calendar.roll(Calendar.YEAR, n);
	}

	@Override
	public void convertToZone(int zone, boolean isDST) throws NotesApiException {
		// TODO oh shit
	}

	@Override
	public void setAnyDate() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAnyTime() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNow() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int timeDifference(NotesDateTime dt) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double timeDifferenceDouble(NotesDateTime dt) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLocalDate(int year, int month, int day) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalDate(int year, int month, int day, boolean preserveLocalTime) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(int hour, int minute, int second, int hundreth) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(Date dt) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(Calendar dt) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getGMTTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDST() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLocalTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocalTime(String dt) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTimeZone() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getZoneTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDateOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date toJavaDate() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

}