package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDateRange;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesSession;

/**
 * Mock-Implementation of NotesDateRange
 * 
 * @author Sven Dreher
 * @see NotesDateRange
 * 
 */
public class NotesDateRangeMockImpl extends NotesBaseMockImpl implements
		NotesDateRange {

	private NotesDateTime start;
	private NotesDateTime end;
	private NotesSession parent;
	private String text;

	/**
	 * @param startt
	 *            Start-Time
	 * @param endt
	 *            End-Time
	 * @param parent
	 *            Parent session
	 */
	public NotesDateRangeMockImpl(NotesDateTime startt, NotesDateTime endt,
			NotesSession parent) {
		this.start = startt;
		this.end = endt;
		this.parent = parent;
	}

	@Override
	public NotesDateTime getStartDateTime() throws NotesApiException {
		return start;
	}

	@Override
	public void setStartDateTime(NotesDateTime start) throws NotesApiException {
		this.start = start;
	}

	@Override
	public NotesDateTime getEndDateTime() throws NotesApiException {
		return end;
	}

	@Override
	public void setEndDateTime(NotesDateTime end) throws NotesApiException {
		this.end = end;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public String getText() throws NotesApiException {
		return text;
	}

	@Override
	public void setText(String text) throws NotesApiException {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

}