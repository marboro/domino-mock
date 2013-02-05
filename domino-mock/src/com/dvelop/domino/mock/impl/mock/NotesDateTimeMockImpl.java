package com.dvelop.domino.mock.impl.mock;

import java.util.Calendar;
import java.util.Date;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesDateTimeMockImpl extends NotesBaseMockImpl implements NotesDateTime {

	private final Date date;

	public NotesDateTimeMockImpl(Date date) {
		this.date = date;
	}

	@Override
	public void adjustHour(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustHour(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustMinute(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustMinute(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustSecond(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustSecond(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustDay(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustDay(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustMonth(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustMonth(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustYear(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustYear(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToZone(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

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
	public int timeDifference(NotesDateTime arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double timeDifferenceDouble(NotesDateTime arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLocalDate(int arg0, int arg1, int arg2) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalDate(int arg0, int arg1, int arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(int arg0, int arg1, int arg2, int arg3) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(Date arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLocalTime(Calendar arg0) throws NotesApiException {
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
	public void setLocalTime(String arg0) throws NotesApiException {
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