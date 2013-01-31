package com.dvelop.domino.mock.impl.production;

import lotus.domino.Name;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesName;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesNameProdImpl extends NotesBaseProdImpl implements NotesName {

	private final Name name;

	public NotesNameProdImpl(Name name) {
		this.name = name;
	}

	public Name get() {
		return name;
	}

	@Override
	public String getADMD() throws NotesApiException {
		try {
			return name.getADMD();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAbbreviated() throws NotesApiException {
		try {
			return name.getAbbreviated();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCountry() throws NotesApiException {
		try {
			return name.getCountry();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCanonical() throws NotesApiException {
		try {
			return name.getCanonical();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCommon() throws NotesApiException {
		try {
			return name.getCommon();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getGeneration() throws NotesApiException {
		try {
			return name.getGeneration();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getGiven() throws NotesApiException {
		try {
			return name.getGiven();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getInitials() throws NotesApiException {
		try {
			return name.getInitials();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr822LocalPart() throws NotesApiException {
		try {
			return name.getAddr822LocalPart();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr822Phrase() throws NotesApiException {
		try {
			return name.getAddr822Phrase();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr821() throws NotesApiException {
		try {
			return name.getAddr821();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr822Comment1() throws NotesApiException {
		try {
			return name.getAddr822Comment1();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr822Comment2() throws NotesApiException {
		try {
			return name.getAddr822Comment2();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAddr822Comment3() throws NotesApiException {
		try {
			return name.getAddr822Comment3();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getLanguage() throws NotesApiException {
		try {
			return name.getLanguage();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getKeyword() throws NotesApiException {
		try {
			return name.getKeyword();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrganization() throws NotesApiException {
		try {
			return name.getOrganization();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrgUnit1() throws NotesApiException {
		try {
			return name.getOrgUnit1();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrgUnit2() throws NotesApiException {
		try {
			return name.getOrgUnit2();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrgUnit3() throws NotesApiException {
		try {
			return name.getOrgUnit3();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOrgUnit4() throws NotesApiException {
		try {
			return name.getOrgUnit4();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(name.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPRMD() throws NotesApiException {
		try {
			return name.getPRMD();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSurname() throws NotesApiException {
		try {
			return name.getSurname();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isHierarchical() throws NotesApiException {
		try {
			return name.isHierarchical();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}