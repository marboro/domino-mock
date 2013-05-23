package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Allows lookups of a specific associated Notes directory on a specific server
 * or local computer
 * 
 * @author Sven Dreher
 * @access To create a new NotesDirectoryNavigator object you can use the
 *         following:<br>
 * 
 *         {@link NotesDirectory#createNavigator()} in Directory<br>
 * 
 *         Lookups performed against a Directory replace the existing
 *         DirectoryNavigator for that directory with a new navigator. To
 *         replace a DirectoryNavigator object you can use the following:<br>
 * 
 *         {@link NotesDirectory#lookupAllNames(String, String)} in Directory<br>
 * 
 *         {@link NotesDirectory#lookupNames(String, String, String)} in
 *         Directory<br>
 */
public interface NotesDirectoryNavigator extends NotesBase {
	/**
	 * The name of the cached view
	 * 
	 * @return The name of the cached view
	 * @throws NotesApiException
	 * @usage This property will contain the name of the cached directory view
	 *        used to create the directory navigator. It is updated by directory
	 *        lookups
	 */
	String getCurrentView() throws NotesApiException;

	/**
	 * The iteration index into the internal match list of the current match to
	 * which the navigator is pointing
	 * 
	 * @return The iteration index into the internal match list of the current
	 *         match to which the navigator is pointing
	 * @throws NotesApiException
	 * @usage This property will contain the iteration index into the internal
	 *        match list of all matches for a given Name to which the directory
	 *        navigator is pointing. It is updated by the FindFirstMatch,
	 *        FindNextMatch and FindNthMatch methods
	 */
	long getCurrentMatch() throws NotesApiException;

	/**
	 * The number of matches found for the current name
	 * 
	 * @return The number of matches found for the current name
	 * @throws NotesApiException
	 * @usage This property will contain the number of matches found for the
	 *        CurrentName in the directory navigator. If the navigator was
	 *        created by the lookupAllNames method, so that CurrentName is
	 *        blank, CurrentMatches will contain the number of matches returned
	 *        from the findFirstName call
	 */
	long getCurrentMatches() throws NotesApiException;

	/**
	 * The name of the current item in the current match to which the navigator
	 * is pointing
	 * 
	 * @return The name of the current item in the current match to which the
	 *         navigator is pointing
	 * @throws NotesApiException
	 * @usage This property will contain the name of the current item in the
	 *        current match to which the directory navigator is pointing. It is
	 *        updated by the getNextItemValue and getNthItemValue methods
	 */
	String getCurrentItem() throws NotesApiException;

	/**
	 * Indicates success of finding a name
	 * 
	 * @return Indicates success of finding a name
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates name was successfully located</li>
	 *              <li>False indicates name was not located</li>
	 *              </ul>
	 * @usage This property is set by the findFirstName, findNextName, and
	 *        findNthName methods
	 */
	boolean isNameLocated() throws NotesApiException;

	/**
	 * Indicates success of most recent match.
	 * 
	 * @return Indicates success of most recent match.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>True indicates match was successful</li>
	 *              <li>False indicates match was unsuccessful</li>
	 *              </ul>
	 * @usage This property is set by the findFirstMatch, findNextMatch, and
	 *        findNthMatch methods
	 */
	boolean isMatchLocated() throws NotesApiException;

	/**
	 * The name of the current match to which the navigator is pointing
	 * 
	 * @return The name of the current match to which the navigator is pointing
	 * @throws NotesApiException
	 * @usage This property will contain the name of the current match to which
	 *        the directory navigator is pointing. It is updated by the
	 *        findFirstMatch, findNextMatch and findNthMatch methods.
	 * 
	 *        If the directory navigator was created with the lookupAllNames
	 *        method, this property will be an empty string.
	 */
	String getCurrentName() throws NotesApiException;

	/**
	 * Positions navigator to the first name in the navigator and returns number
	 * of matches
	 * 
	 * @return The number of matches found in the navigator
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the first match of the first
	 *        name, and sets the NameLocated property to true if the method
	 *        succeeds. If the method fails, the NameLocated property is set to
	 *        false. Does not change the current match.
	 * 
	 *        Lookups automatically position the navigator at the first match of
	 *        the first name.
	 */
	long findFirstName() throws NotesApiException;

	/**
	 * Positions navigator to the next name in the namelist and returns number
	 * of matches
	 * 
	 * @return The number of matches found in the navigator
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the next name in the
	 *        namelist, and sets the NameLocated property to true if the method
	 *        succeeds. If the method fails, the NameLocated property is set to
	 *        false. Does not change the current match
	 */
	long findNextName() throws NotesApiException;

	/**
	 * Positions navigator to the nth name in the namelist and returns number of
	 * matches
	 * 
	 * @param n
	 *            The number of the name at which to position the navigator,
	 *            starting with 1.
	 * @return The number of matches found in the navigator
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the nth name in the namelist,
	 *        and sets the NameLocated property to true if the method succeeds.
	 *        If the method fails, the NameLocated property is set to false.
	 *        Does not change the current match
	 */
	long findNthName(int n) throws NotesApiException;

	/**
	 * Positions navigator to first match of the current name in the navigator
	 * 
	 * @return True if a match was found in the navigator. False if no match was
	 *         found
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the first match, and sets the
	 *        CurrentName property with the name found in that match. Lookups
	 *        automatically position the navigator at the first match of the
	 *        first name
	 */
	boolean findFirstMatch() throws NotesApiException;

	/**
	 * Positions navigator to next match of the current name in the navigator
	 * 
	 * @return True if a match was found in the navigator. False if no match was
	 *         found
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the next match for the
	 *        current name
	 */
	boolean findNextMatch() throws NotesApiException;

	/**
	 * Positions navigator to nth match of the current name in the navigator
	 * 
	 * @param n
	 *            The number of the match at which to position the navigator,
	 *            starting with 1
	 * @return True if a match was found in the navigator. False if no match was
	 *         found
	 * @throws NotesApiException
	 * @usage Positions the directory navigator at the nth match for the current
	 *        name
	 */
	boolean findNthMatch(long n) throws NotesApiException;

	/**
	 * Returns the value of the first item of the current match
	 * 
	 * @return The value of the first item of the current match
	 * @throws NotesApiException
	 * @usage Lookups automatically position the navigator at the first match of
	 *        the first name.
	 * 
	 *        This method always returns an array. If it is a single valued
	 *        item, only the first value of the array will be populated
	 */
	Vector getFirstItemValue() throws NotesApiException;

	/**
	 * Returns the value of the next item of the current match
	 * 
	 * @return The value of the next item of the current match
	 * @throws NotesApiException
	 * @usage Positions navigator to next item within current match, and updates
	 *        the CurrentItem property with the item name.
	 * 
	 *        Lookups automatically position the navigator at the first match of
	 *        the first name.
	 * 
	 *        This method always returns an array. If it is a single valued
	 *        item, only the first value of the array will be populated
	 */
	Vector getNextItemValue() throws NotesApiException;

	/**
	 * Positions navigator to nth match of the current name in the navigator and
	 * returns the value of the current item
	 * 
	 * @param n
	 *            The number of the match at which to position the navigator,
	 *            starting with 1
	 * @return The value of the current item of the nth match
	 * @throws NotesApiException
	 * @usage Positions navigator to the nth match of the current name, and
	 *        updates the CurrentItem property with the item name.
	 * 
	 *        The only way to advance the current item is by use of the
	 *        getNextItemValue method.
	 * 
	 *        This method always returns an array. If it is a single valued
	 *        item, only the first value of the array will be populated
	 */
	Vector getNthItemValue(int n) throws NotesApiException;
}
