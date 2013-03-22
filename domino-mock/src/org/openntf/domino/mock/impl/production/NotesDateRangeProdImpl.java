package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDateRange;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesSession;

import lotus.domino.DateRange;
import lotus.domino.NotesException;


public class NotesDateRangeProdImpl extends NotesBaseProdImpl implements
		NotesDateRange {

	private final DateRange dateRange;

	public NotesDateRangeProdImpl(DateRange createDateRange) {
		this.dateRange = createDateRange;
	}

	public DateRange get() {
		return dateRange;
	}

	@Override
	public NotesDateTime getStartDateTime() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(dateRange.getStartDateTime());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setStartDateTime(NotesDateTime arg0) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg0;
			dateRange.setStartDateTime(dateTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getEndDateTime() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(dateRange.getEndDateTime());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEndDateTime(NotesDateTime arg0) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg0;
			dateRange.setEndDateTime(dateTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(dateRange.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getText() throws NotesApiException {
		try {
			return dateRange.getText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setText(String arg0) throws NotesApiException {
		try {
			dateRange.setText(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

}