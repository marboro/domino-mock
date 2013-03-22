package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesName extends NotesBase {
	public abstract String getADMD() throws NotesApiException;

	public abstract String getAbbreviated() throws NotesApiException;

	public abstract String getCountry() throws NotesApiException;

	public abstract String getCanonical() throws NotesApiException;

	public abstract String getCommon() throws NotesApiException;

	public abstract String getGeneration() throws NotesApiException;

	public abstract String getGiven() throws NotesApiException;

	public abstract String getInitials() throws NotesApiException;

	public abstract String getAddr822LocalPart() throws NotesApiException;

	public abstract String getAddr822Phrase() throws NotesApiException;

	public abstract String getAddr821() throws NotesApiException;

	public abstract String getAddr822Comment1() throws NotesApiException;

	public abstract String getAddr822Comment2() throws NotesApiException;

	public abstract String getAddr822Comment3() throws NotesApiException;

	public abstract String getLanguage() throws NotesApiException;

	public abstract String getKeyword() throws NotesApiException;

	public abstract String getOrganization() throws NotesApiException;

	public abstract String getOrgUnit1() throws NotesApiException;

	public abstract String getOrgUnit2() throws NotesApiException;

	public abstract String getOrgUnit3() throws NotesApiException;

	public abstract String getOrgUnit4() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getPRMD() throws NotesApiException;

	public abstract String getSurname() throws NotesApiException;

	public abstract boolean isHierarchical() throws NotesApiException;
}
