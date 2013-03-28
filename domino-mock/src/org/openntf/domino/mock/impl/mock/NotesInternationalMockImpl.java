package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesInternational;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesInternationalMockImpl extends NotesBaseMockImpl implements
		NotesInternational {

	private final NotesSession parent;

	public NotesInternationalMockImpl(NotesSession parent) {
		this.parent = parent;
	}

	@Override
	public String getAMString() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrencyDigits() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrencySymbol() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDateSep() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDecimalSep() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPMString() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getThousandsSep() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeSep() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTimeZone() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getToday() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTomorrow() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getYesterday() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCurrencySuffix() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrencySpace() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrencyZero() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateMDY() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateDMY() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDateYMD() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDST() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTime24Hour() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}
}