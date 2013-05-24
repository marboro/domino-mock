package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents the Notes directories on a specific server or local computer, each of which is associated with one or more directory navigators to allow directory lookups
 * 
 * @author Sven Dreher
 * @access You create a new Directory object using the name of the server you want to access. You can use the following: {@link NotesSession#getDirectory()} in Session
 * @example This agent prints the name of every person whose email address in the local directory contains the name John
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 *     try {
 *       Session session = getSession();
 *       AgentContext agentContext = session.getAgentContext();
 *       // (Your code goes here) 
 *       Directory dir = session.getDirectory(null);
 *       String server = dir.getName();
 *       if (server.equals(&quot;&quot;)) server = &quot;Local&quot;;
 *       System.out.println (&quot;People named John on server &quot; 
 *          + server + &quot;\n&quot;);
 *       DirEntryCollection direc = dir.lookupNames(&quot;Contacts&quot;,&quot;John&quot;,&quot;email&quot;);
 *       DirEntry dirent = direc.getFirstEntry()
 *       while (dirent != null) {
 *         String name = dirent.getItemValue(&quot;Name&quot;);
 *         System.out.println(name);
 *         dirent = direc.getNextEntry(); }
 *     } catch(Exception e) {
 *       e.printStackTrace();
 *     }
 *   }
 * }
 * </pre>
 */
public interface NotesDirectory extends NotesBase {
	/**
	 * The name of the server represented by the Directory
	 * 
	 * @return The name of the server represented by the Directory
	 * @throws NotesApiException
	 * @usage This property will contain the name of the server represented by the Directory
	 */
	String getServer() throws NotesApiException;

	/**
	 * The view name which has been looked up and cached
	 * 
	 * @return The view name which has been looked up and cached
	 * @throws NotesApiException
	 * @usage This property will contain the view name specified in the most recent LookupAllNames or LookupNames. If a Directory has been created but no lookups have been performed against it, this
	 *        property is null
	 */
	String getAvailableView() throws NotesApiException;

	/**
	 * Array of names which have been looked up and cached
	 * 
	 * @return Array of names which have been looked up and cached
	 * @throws NotesApiException
	 * @usage If the most recent lookup was LookupAllNames, this property will contain all names in the specified view. If the most recent lookup was LookupNames, this property will contain the
	 *        variant Names specified in that lookup. If a Directory has been created but no lookups have been performed against it, this property is null
	 * 
	 */
	Vector getAvailableNames() throws NotesApiException;

	/**
	 * Array of summary data items which have been looked up and cached
	 * 
	 * @return Array of summary data items which have been looked up and cached
	 * @throws NotesApiException
	 * @usage This property is set by the variant Items in methods LookupNames and LookupAllNames. If a Directory has been created but no lookups have been performed against it, this property is null
	 */
	Vector getAvailableItems() throws NotesApiException;

	/**
	 * Indicates if all directories will be searched by lookups
	 * 
	 * @return Indicates if all directories will be searched by lookups
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True (default) indicates lookups will search all directories</li>
	 *              <li>False indicates lookups will stop searching after the first directory containing the specified view name</li>
	 *              </ul>
	 * @usage This property works with the GroupAuthorizationOnly and TrustedOnly properties to limit which directories are searched in a lookup
	 */
	boolean isSearchAllDirectories() throws NotesApiException;

	/**
	 * Indicates if all directories will be searched by lookups
	 * 
	 * @param flag
	 *            Indicates if all directories will be searched by lookups
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True (default) indicates lookups will search all directories</li>
	 *              <li>False indicates lookups will stop searching after the first directory containing the specified view name</li>
	 *              </ul>
	 * @usage This property works with the GroupAuthorizationOnly and TrustedOnly properties to limit which directories are searched in a lookup
	 */
	void setSearchAllDirectories(boolean flag) throws NotesApiException;

	/**
	 * Indicates if only directories that contain trusted information will be searched by lookups.
	 * 
	 * @return Indicates if only directories that contain trusted information will be searched by lookups.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates lookups will search only directories containing trust information</li>
	 *              <li>False (default) indicates lookups will search all directories</li>
	 *              </ul>
	 * @usage This property works with the GroupAuthorizationOnly and SearchAllDirectories properties to limit which directories are searched in a lookup
	 */
	boolean isTrustedOnly() throws NotesApiException;

	/**
	 * Indicates if only directories that contain trusted information will be searched by lookups.
	 * 
	 * @param flag
	 *            Indicates if only directories that contain trusted information will be searched by lookups.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates lookups will search only directories containing trust information</li>
	 *              <li>False (default) indicates lookups will search all directories</li>
	 *              </ul>
	 * @usage This property works with the GroupAuthorizationOnly and SearchAllDirectories properties to limit which directories are searched in a lookup
	 */
	void setTrustedOnly(boolean flag) throws NotesApiException;

	/**
	 * Indicates if only those directories enabled for group authorization will be searched by lookups
	 * 
	 * @return Indicates if only those directories enabled for group authorization will be searched by lookups
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates lookups will only search directories marked "Enable for Group Authorization".</li>
	 *              <li>False (default) indicates lookups will search all directories</li>
	 *              </ul>
	 * @usage This property works with the SearchAllDirectories and TrustedOnly properties to limit which directories are searched in a lookup
	 */
	boolean isGroupAuthorizationOnly() throws NotesApiException;

	/**
	 * Indicates if only those directories enabled for group authorization will be searched by lookups
	 * 
	 * @param flage
	 *            Indicates if only those directories enabled for group authorization will be searched by lookups
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates lookups will only search directories marked "Enable for Group Authorization".</li>
	 *              <li>False (default) indicates lookups will search all directories</li>
	 *              </ul>
	 * @usage This property works with the SearchAllDirectories and TrustedOnly properties to limit which directories are searched in a lookup
	 */
	void setGroupAuthorizationOnly(boolean flage) throws NotesApiException;

	/**
	 * Indicates if the server of the context database will be used
	 * 
	 * @return Indicates if the server of the context database will be used
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates the server of the context database will be used, or local if the context database is local</li>
	 *              <li>False (default) indicates the server specified in lookup methods will be used</li>
	 *              </ul>
	 * @usage If true, this property will override the server specified in a lookup method with the server of the context database
	 */
	boolean isUseContextServer() throws NotesApiException;

	/**
	 * Indicates if the server of the context database will be used
	 * 
	 * @param flag
	 *            Indicates if the server of the context database will be used
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates the server of the context database will be used, or local if the context database is local</li>
	 *              <li>False (default) indicates the server specified in lookup methods will be used</li>
	 *              </ul>
	 * @usage If true, this property will override the server specified in a lookup method with the server of the context database
	 */
	void setUseContextServer(boolean flag) throws NotesApiException;

	/**
	 * Indicates if lookups match on partial names
	 * 
	 * @return Indicates if lookups match on partial names
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates lookups will match on partial names</li>
	 *              <li>False (default) indicates lookups will not match on partial names</li>
	 *              </ul>
	 * @usage This property is set by the optional PartialMatches parameter in the LookupNames method. It works with the LimitMatches property to control the number of results returned by a lookup
	 */
	boolean isPartialMatches() throws NotesApiException;

	/**
	 * Indicates if the results of lookups are limited to fifty entries
	 * 
	 * @return Indicates if the results of lookups are limited to fifty entries
	 * @throws NotesApiException
	 * @usage This property works with the PartialMatches property to control the number of results returned by a lookup
	 */
	boolean isLimitMatches() throws NotesApiException;

	/**
	 * Indicates if the results of lookups are limited to fifty entries
	 * 
	 * @param flag
	 *            Indicates if the results of lookups are limited to fifty entries
	 * @throws NotesApiException
	 * @usage This property works with the PartialMatches property to control the number of results returned by a lookup
	 */
	void setLimitMatches(boolean flag) throws NotesApiException;

	/**
	 * Looks up designated Items for specified Names contained in the specified View
	 * 
	 * @param view
	 *            The name of the view in which to look up names
	 * @param name
	 *            Either a single string, or an array of strings. The names to be searched in the view. Entries must match one of these names to be searched for items
	 * @param item
	 *            Either a single string, or an array of strings. Summary data items whose values will be returned by the lookup
	 * @return The newly created directory navigator, containing the values in items of entries whose name matches (or partially matches, if partialmatches is true) names
	 * @throws NotesApiException
	 * @usage This method will flush the Directory cache and reset all child navigators.<br>
	 * 
	 *        The items specified in this method can be:
	 *        <ul>
	 *        <li>1. the programmatic name of a column (the programmatic name is not necessarily the display name)</li>
	 *        <li>2. the programmatic name of a field in the note (names which are not columns in the specified view)</li>
	 *        <li>3. a computed item provided by NAMELookup (such as $$DbName)</li>
	 *        </ul>
	 *        For best performance, use column names from the specified view or computed items.
	 */
	NotesDirectoryNavigator lookupNames(String view, String name, String item) throws NotesApiException;

	/**
	 * Looks up designated Items for specified Names contained in the specified View
	 * 
	 * @param view
	 *            The name of the view in which to look up names
	 * @param names
	 *            Either a single string, or an array of strings. The names to be searched in the view. Entries must match one of these names to be searched for items
	 * @param items
	 *            Either a single string, or an array of strings. Summary data items whose values will be returned by the lookup
	 * @param partialMatches
	 *            Indicates partial matches of names are allowed
	 * @return The newly created directory navigator, containing the values in items of entries whose name matches (or partially matches, if partialmatches is true) names
	 * @throws NotesApiException
	 * @usage This method will flush the Directory cache and reset all child navigators.<br>
	 * 
	 *        The items specified in this method can be:
	 *        <ul>
	 *        <li>1. the programmatic name of a column (the programmatic name is not necessarily the display name)</li>
	 *        <li>2. the programmatic name of a field in the note (names which are not columns in the specified view)</li>
	 *        <li>3. a computed item provided by NAMELookup (such as $$DbName)</li>
	 *        </ul>
	 *        For best performance, use column names from the specified view or computed items.
	 */
	NotesDirectoryNavigator lookupNames(String view, Vector<String> names, Vector<String> items, boolean partialMatches) throws NotesApiException;

	/**
	 * Looks up designated Items for all Names contained in the specified View.<br>
	 * 
	 * <b>Caution</b> Large results will be limited by the system, according to settings in Notes.ini. This method is intended for views with limited scopes.
	 * 
	 * @param view
	 *            The name of the view in which to look up names
	 * @param item
	 *            Summary data item whose values will be returned by the lookup
	 * @return The newly created directory navigator, containing values of the specified lookup items for all names in the specified view
	 * @throws NotesApiException
	 * @usage This method will flush the Directory cache and reset all child navigators.<br>
	 * 
	 *        The items specified in this method can be:
	 *        <ul>
	 *        <li>1. the programmatic name of a column (the programmatic name is not necessarily the display name)</li>
	 *        <li>2. the programmatic name of a field in the note (names which are not columns in the specified view)</li>
	 *        <li>3. a computed item provided by NAMELookup (such as $$DbName)</li>
	 *        </ul>
	 *        For best performance, use column names from the specified view or computed items.<br>
	 * 
	 *        Since no names are furnished as input arguments, the DirectoryNavigator CurrentName property will be empty
	 */
	NotesDirectoryNavigator lookupAllNames(String view, String item) throws NotesApiException;

	/**
	 * Looks up designated Items for all Names contained in the specified View.<br>
	 * 
	 * <b>Caution</b> Large results will be limited by the system, according to settings in Notes.ini. This method is intended for views with limited scopes.
	 * 
	 * @param view
	 *            The name of the view in which to look up names
	 * @param items
	 *            Summary data items whose values will be returned by the lookup
	 * @return The newly created directory navigator, containing values of the specified lookup items for all names in the specified view
	 * @throws NotesApiException
	 * @usage This method will flush the Directory cache and reset all child navigators.<br>
	 * 
	 *        The items specified in this method can be:
	 *        <ul>
	 *        <li>1. the programmatic name of a column (the programmatic name is not necessarily the display name)</li>
	 *        <li>2. the programmatic name of a field in the note (names which are not columns in the specified view)</li>
	 *        <li>3. a computed item provided by NAMELookup (such as $$DbName)</li>
	 *        </ul>
	 *        For best performance, use column names from the specified view or computed items.<br>
	 * 
	 *        Since no names are furnished as input arguments, the DirectoryNavigator CurrentName property will be empty
	 */
	NotesDirectoryNavigator lookupAllNames(String view, Vector<String> items) throws NotesApiException;

	/**
	 * Creates a new directory navigator
	 * 
	 * @return The newly created directory navigator
	 * @throws NotesApiException
	 * @usage Calls to Lookup against a Directory return a resident DirectoryNavigator, with successive Lookups resetting the cache and associated navigator. The CreateNavigator method is used to
	 *        create additional DirectoryNavigators, allowing multiple simultaneous information retrievals
	 */
	NotesDirectoryNavigator createNavigator() throws NotesApiException;

	/**
	 * Frees memory in the current lookup buffer. Resets all Navigators
	 * 
	 * @throws NotesApiException
	 * @usage This method is used for memory management, since the namelookup buffer may be large
	 */
	void freeLookupBuffer() throws NotesApiException;

	/**
	 * Returns Mail data for the specified person
	 * 
	 * @param userName
	 *            The name of a user for whom mail information is requested
	 * @return Mail data for the specified person. Elements returned are as follows
	 *         <ul>
	 *         <li>Mail Server - Home mail server for the specified person.</li>
	 *         <li>BuildNumber - If getver is true, a string representation of the build number of the specified person's mail server, for example, "303". If getver is false, "".</li>
	 *         <li>DominoVersion - If getver is true, a string representation of the Domino version of the specified person's mail server, for example, "Build V80_07042006NP". If getver is false, "".</li>
	 *         <li>MailFile - Mail file for the specified person.</li>
	 *         <li>ShortName - Short form of the specified person's name.</li>
	 *         <li>MailDomain - Notes Domain of the specified person's mail address.</li>
	 *         <li>User Name - First entry in the list of user names honored for the specified person.</li>
	 *         <li>InternetMailAddress - Internet mail address for the specified person.</li>
	 *         <li>OutOfOffice - Out of Office service type. "1" indicates Agent, "2" indicates Service</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage For Directory lookups of mail information, the resident Server specified for the Directory class instance will be used, if present. If that fails, bootstrap information for the method
	 *        will be gleaned from the user's current operating environment.
	 * 
	 *        If errorOnMultipleMatches is True, and multiple matches for the same name are found, the error code that is thrown is error code 4751 "Directory contains multiple entries for this user."
	 * 
	 *        If no server responds to the lookup requests, the error code that is thrown is error code 4749 "Unable to access server."
	 * 
	 *        If username was not found in the Directory, the error code that is thrown is error code 4731 "User not found in Directory."
	 * 
	 *        If the method fails for any other reason, the error code that is thrown is error code 4730 "GetMailInfo failed."
	 * 
	 *        If getver is True and the specified person's home server is not available, BuildNumber and DominoVersion will be left blank
	 */
	Vector getMailInfo(String userName) throws NotesApiException;

	/**
	 * Returns Mail data for the specified person
	 * 
	 * @param userName
	 *            The name of a user for whom mail information is requested
	 * @param getVer
	 *            Flag to request build number and version information of the user's home mail server. Default value is False
	 * @param errorOnMultipleMatches
	 *            Flag to indicate how to handle multiple matches for the username. If this argument is True, multiple matches throw an error code. If this argument is False, if multiple matches
	 *            occur, the first match is used. Default value is True
	 * @return Mail data for the specified person. Elements returned are as follows
	 * @throws NotesApiException
	 */
	Vector getMailInfo(String userName, boolean getVer, boolean errorOnMultipleMatches) throws NotesApiException;

}
