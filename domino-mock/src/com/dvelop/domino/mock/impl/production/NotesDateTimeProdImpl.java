package com.dvelop.domino.mock.impl.production;

import java.util.Calendar;
import java.util.Date;

import lotus.domino.DateTime;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesDateTimeProdImpl extends NotesBaseProdImpl implements
		NotesDateTime {

	private final DateTime dateTime;

	public NotesDateTimeProdImpl(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public DateTime get() {
		return dateTime;
	}

	@Override
	public void adjustHour(int arg0) throws NotesApiException {
		try {
			dateTime.adjustHour(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustHour(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustHour(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void adjustMinute(int arg0) throws NotesApiException {
		try {
			dateTime.adjustMinute(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustMinute(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustMinute(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustSecond(int arg0) throws NotesApiException {
		try {
			dateTime.adjustSecond(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustSecond(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustSecond(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustDay(int arg0) throws NotesApiException {
		try {
			dateTime.adjustDay(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustDay(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustDay(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustMonth(int arg0) throws NotesApiException {
		try {
			dateTime.adjustMonth(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustMonth(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustMonth(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustYear(int arg0) throws NotesApiException {
		try {
			dateTime.adjustYear(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void adjustYear(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.adjustYear(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void convertToZone(int arg0, boolean arg1) throws NotesApiException {
		try {
			dateTime.convertToZone(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setAnyDate() throws NotesApiException {
		try {
			dateTime.setAnyDate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setAnyTime() throws NotesApiException {
		try {
			dateTime.setAnyTime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setNow() throws NotesApiException {
		try {
			dateTime.setNow();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int timeDifference(NotesDateTime arg0) throws NotesApiException {
		try {
			NotesDateTimeProdImpl argTime = (NotesDateTimeProdImpl) arg0;
			return dateTime.timeDifference(argTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double timeDifferenceDouble(NotesDateTime arg0)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl argTime = (NotesDateTimeProdImpl) arg0;
			return dateTime.timeDifference(argTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLocalDate(int arg0, int arg1, int arg2)
			throws NotesApiException {
		try {
			dateTime.setLocalDate(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setLocalDate(int arg0, int arg1, int arg2, boolean arg3)
			throws NotesApiException {
		try {
			dateTime.setLocalDate(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setLocalTime(int arg0, int arg1, int arg2, int arg3)
			throws NotesApiException {
		try {
			dateTime.setLocalTime(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setLocalTime(Date arg0) throws NotesApiException {
		try {
			dateTime.setLocalTime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setLocalTime(Calendar arg0) throws NotesApiException {
		try {
			dateTime.setLocalTime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getGMTTime() throws NotesApiException {
		try {
			return dateTime.getGMTTime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDST() throws NotesApiException {
		try {
			return dateTime.isDST();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getLocalTime() throws NotesApiException {
		try {
			return dateTime.getLocalTime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLocalTime(String arg0) throws NotesApiException {
		try {
			dateTime.setLocalTime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getTimeZone() throws NotesApiException {
		try {
			return dateTime.getTimeZone();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getZoneTime() throws NotesApiException {
		try {
			return dateTime.getZoneTime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDateOnly() throws NotesApiException {
		try {
			return dateTime.getDateOnly();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(dateTime.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTimeOnly() throws NotesApiException {
		try {
			return dateTime.getTimeOnly();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Date toJavaDate() throws NotesApiException {
		try {
			return dateTime.toJavaDate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}