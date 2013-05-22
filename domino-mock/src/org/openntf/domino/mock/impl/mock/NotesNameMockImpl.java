package org.openntf.domino.mock.impl.mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesName;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesNameMockImpl extends NotesBaseMockImpl implements NotesName {

	private String nameCanonical = "";
	private String nameAddr = "";
	private String name;
	private String lang = "";
	private final NotesSession parent;
	private boolean isHierarchical = false;

	private Map<String, String> parameterMap = new HashMap<String, String>();

	public NotesNameMockImpl(String name, String lang, NotesSession parent) {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/S=Goode/G=John/I=B/Q=Jr/A=acmeadmd/P=acmeprmd",
		// "fr-CA";
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "CN=John B Goode/OU4=Guitars/OU3=Music/OU2=Sales/OU1=East/O=Acme/C=US"
		isHierarchical = false;
		if (name.matches("CN=")) {
			String sList[];
			int occurences = 0;
			nameCanonical = name;

			for (int index = name.indexOf("OU=", 0); index != -1; index = name.indexOf("OU=", index + 1))
				occurences++;

			sList = name.split("/");
			int numOu = occurences;
			for (String s : sList) {
				int theIndex = s.indexOf("=");
				String parKey = s.substring(0, theIndex);
				if (occurences > 1)
					if (parKey.substring(0, theIndex).compareTo("Ou=") == 0) {
						parKey = "OU" + numOu + "=";
						numOu--;
					}

				parameterMap.put(parKey, s.substring(theIndex, s.length()));

			}
			isHierarchical = true;
		} else if (name.matches("@")) {
			nameAddr = name;
			parameterMap.clear();
		}

		this.name = name;
		this.parent = parent;
		if (lang != null)
			this.lang = lang;

	}

	@Override
	public String getADMD() throws NotesApiException {
		// A=acmeadmd (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("A=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getAbbreviated() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/A=acmeadmd/P=acmeprmd"
		// John B Goode/Sales/East/Acme/US (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			Collection<String> cresult = parameterMap.values();

			for (String elem : cresult)
				result = result + "/" + elem;

			if (result.substring(result.length()).contains("/"))
				result = result.substring(0, result.length() - 1);
		}

		return result;
	}

	@Override
	public String getCountry() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/A=acmeadmd/P=acmeprmd"
		// US (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("C=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getCanonical() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/A=acmeadmd/P=acmeprmd"
		// CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US (out)
		return nameCanonical;
	}

	@Override
	public String getCommon() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/A=acmeadmd/P=acmeprmd"
		// John B Goode (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("CN=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getGeneration() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/S=Goode/G=John/I=B/Q=Jr"
		// Jr (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("Q=");
			if (result == null)
				result = "";
		}

		return result;

	}

	@Override
	public String getGiven() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/S=Goode/G=John/I=B/Q=Jr"
		// John (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("CN=");
			if (result == null)
				result = "";
			else
				result = result.substring(0, result.indexOf(" "));
		}
		return result;
	}

	@Override
	public String getInitials() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/S=Goode/G=John/I=B/Q=Jr"
		// B (out)
		String result = "";
		result = nameAddr.split("(?<= )(.*?)(?= )")[0];
		if (result.isEmpty())
			result = "";

		return result;
	}

	@Override
	public String getAddr822LocalPart() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// jbgoode (out)
		String result = "";
		result = nameAddr.split("(?<=<)(.*?)(?=@)")[0];
		if (result.isEmpty())
			result = "";

		return result;
	}

	@Override
	public String getAddr822Phrase() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "John B Goode" (out)
		String result = "";
		result = nameAddr.split("(?<=\")(.*?)(?=\")")[0];
		if (result.isEmpty())
			result = "";

		return result;
	}

	@Override
	public String getAddr821() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "jbgoode@us.acme.com" (out)
		String result = "";
		result = nameAddr.split("(?<=<)(.*?)(?=>)")[0];
		if (result.isEmpty())
			result = "";

		return result;
	}

	@Override
	public String getAddr822Comment1() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "Guitars" (out)
		String result = "";
		if (!nameAddr.isEmpty()) {
			String listEntrys[] = nameAddr.split("(?<=\\()(.*?)(?=\\))");

			result = listEntrys[0];
			if (listEntrys.length < 1)
				result = "";
		}
		return result;
	}

	@Override
	public String getAddr822Comment2() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "Music" (out)
		String result = "";
		if (!nameAddr.isEmpty()) {
			String listEntrys[] = nameAddr.split("(?<=\\()(.*?)(?=\\))");

			if (listEntrys.length > 1)
				result = listEntrys[1];
			else
				result = "";
		}
		return result;
	}

	@Override
	public String getAddr822Comment3() throws NotesApiException {
		// "\"John B Goode\" <jbgoode@us.acme.com> (Guitars) (Music) (East)"
		// "East" (out)
		String result = "";
		if (!nameAddr.isEmpty()) {
			String listEntrys[] = nameAddr.split("(?<=\\()(.*?)(?=\\))");

			if (listEntrys.length > 2)
				result = listEntrys[2];
			else
				result = "";
		}
		return result;
	}

	@Override
	public String getLanguage() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US", "fr-CA";
		// "fr-CA" (out)
		return this.lang;
	}

	@Override
	public String getKeyword() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US"
		// "US\Acme\East\Sales" (out)

		String result = "";
		if (!parameterMap.isEmpty()) {
			String addString = "";
			Collection<String> cresult = parameterMap.values();

			for (int i = parameterMap.size(); i > 1; i--)
				addString = addString + "\\";

			if (addString.substring(addString.length()).contains("\\"))
				result = addString.substring(0, addString.length() - 1);

			if (result == null)
				result = "";

		}
		return result;

	}

	@Override
	public String getOrganization() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US"
		// "Acme" (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("O=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getOrgUnit1() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US"
		// "East" (Out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("OU1=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getOrgUnit2() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US"
		// "Sales" (Out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("OU2=");
			if (result == null)
				result = "";
		}
		return result;
	}

	@Override
	public String getOrgUnit3() throws NotesApiException {
		// "CN=John B Goode/OU=Guitars/OU=Music/OU=Sales/OU=East/O=Acme/C=US"
		// "Music" (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("OU3=");
			if (result == null)
				result = "";
		}
		return result;

	}

	@Override
	public String getOrgUnit4() throws NotesApiException {
		// "CN=John B Goode/OU=Guitars/OU=Music/OU=Sales/OU=East/O=Acme/C=US"
		// "Guitars" (Out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("OU4=");
			if (result == null)
				result = "";
		}
		return result;

	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// parent (out)
		return parent;
	}

	@Override
	public String getPRMD() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/A=acmeadmd/P=acmeprmd"
		// "acmeprmd" (Out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("P=");

			if (result == null)
				result = "";
		}
		return result;

	}

	@Override
	public String getSurname() throws NotesApiException {
		// "CN=John B Goode/OU=Sales/OU=East/O=Acme/C=US/S=Goode/G=John/I=B/Q=Jr"
		// John (out)
		String result = "";
		if (!parameterMap.isEmpty()) {
			result = parameterMap.get("S=");
			if (result == null)
				result = "";
			else
				result = result.substring(0, result.indexOf(" "));
		}
		return result;
	}

	@Override
	public boolean isHierarchical() throws NotesApiException {
		return isHierarchical;
	}

	@Override
	public String toString() {
		try {
			return getCanonical();
		} catch (NotesApiException e) {
			e.printStackTrace();
			return "";
		}

	}
}