package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesInternational;
import org.openntf.domino.mock.interfaces.NotesSession;

import lotus.domino.International;
import lotus.domino.NotesException;


public class NotesInternationalProdImpl extends NotesBaseProdImpl implements
		NotesInternational {

	private final International international;

	public NotesInternationalProdImpl(International international) {
		this.international = international;
	}

	public International get() {
		return international;
	}

	@Override
	public String getAMString() throws NotesApiException {
		try {
			return international.getAMString();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getCurrencyDigits() throws NotesApiException {
		try {
			return international.getCurrencyDigits();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCurrencySymbol() throws NotesApiException {
		try {
			return international.getCurrencySymbol();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDateSep() throws NotesApiException {
		try {
			return international.getDateSep();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDecimalSep() throws NotesApiException {
		try {
			return international.getDecimalSep();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(international.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPMString() throws NotesApiException {
		try {
			return international.getPMString();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getThousandsSep() throws NotesApiException {
		try {
			return international.getThousandsSep();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTimeSep() throws NotesApiException {
		try {
			return international.getTimeSep();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTimeZone() throws NotesApiException {
		try {
			return international.getTimeZone();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getToday() throws NotesApiException {
		try {
			return international.getToday();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTomorrow() throws NotesApiException {
		try {
			return international.getTomorrow();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getYesterday() throws NotesApiException {
		try {
			return international.getYesterday();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCurrencySuffix() throws NotesApiException {
		try {
			return international.isCurrencySuffix();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCurrencySpace() throws NotesApiException {
		try {
			return international.isCurrencySpace();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCurrencyZero() throws NotesApiException {
		try {
			return international.isCurrencyZero();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDateMDY() throws NotesApiException {
		try {
			return international.isDateMDY();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDateDMY() throws NotesApiException {
		try {
			return international.isDateDMY();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDateYMD() throws NotesApiException {
		try {
			return international.isDateYMD();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDST() throws NotesApiException {
		try {
			return international.isDST();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isTime24Hour() throws NotesApiException {
		try {
			return international.isTime24Hour();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}