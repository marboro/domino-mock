package org.openntf.domino.mock.interfaces;

import java.util.Calendar;
import java.util.Date;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a date and time
 * 
 * @author Sven Dreher
 * @access To create a new DateTime object, use {@link NotesSession#createDateTime(Date)} in Session
 * @usage After creating a DateTime object with {@link NotesSession#createDateTime(Date)}, you can reset the date and time with {@link #setLocalTime(int, int, int, int)} and
 *        {@link #setLocalDate(int, int, int)}. The {@link NotesSession#createDateTime(Date)} method takes a String, java.util.Date, or java.util.Calendar parameter. One form of
 *        {@link #setLocalTime(String)} takes a String parameter, another form takes a java.util.Date parameter, and a third form takes a java.util.Calendar parameter. Other forms of
 *        {@link #setLocalTime(int, int, int, int)} and {@link #setLocalDate(int, int, int, boolean)} take multiple int parameters.<br>
 * 
 *        The String form of the date parameter is a date, followed by a space, followed by a time. You can specify a date without a time, and a time without a date, but the time zone will not be set
 *        (see "Time zones" below).<br>
 * 
 *        The following applies when setting a date and time from a String value:<br>
 *        <ul>
 *        <li>
 *        The date and time components are interpreted according to the regional settings of the operating system if possible. For example, if the regional setting for dates is M/d/yy, then "3/4/05"
 *        means 4 March 2005.</li>
 *        <li>If the date or time cannot be interpreted using the regional setting, alternate settings are tried until one works. For example, if the regional setting for dates is M/d/yy, then
 *        "13/4/05" means 13 April 2005 (using d/M/yy as the alternate setting) and "13/33/05" means 13 May 2033 (using d/yy/M as the alternate setting).</li>
 *        <li>If the date or time cannot be interpreted using any setting, the following exception is thrown: NOTES_ERR_INVALID_DATE (4045).</li>
 *        </ul>
 *        The java.util.Calendar class can be used to avoid dependencies on regional settings. For example, you can use getInstance and one of the set methods to create the parameter for
 *        {@link NotesSession#createDateTime(Date)}.
 * 
 *        <b>Time zones</b><br>
 *        When you create a new DateTime object, the time zone setting in Domino determines the {@link #getTimeZone()} property. For example, if the code runs on a computer where the Domino time zone
 *        is set to Eastern Standard Time, the TimeZone property of any new DateTime object is automatically set to 5. The time zone setting also affects the GMTTime and LSGMTTime properties.<br>
 * 
 *        If you create a date without a time component or without a date component, the time zone is invalid and the TimeZone property returns 0. In this case, both LocalTime and GMTTime return the
 *        same time value without a time zone appended. If you apply {@link #convertToZone(int, boolean)}, the time zone remains invalid and TimeZone remains 0; no error occurs.<br>
 * 
 *        <b>Today, Tomorrow, and Yesterday</b><br>
 *        When you create a new DateTime object using an expression such as "Today," "Tommorow," or "Yesterday," the value of the date is determined using the current date setting in Domino. These
 *        expressions have no effect on the time component of a DateTime object. To set a DateTime to the current date and time, specify the time after "Today" or "Yesterday" (for example,
 *        "Today 12:00:00 AM") or use {@link #setNow()}.<br>
 * 
 *        <b>Access</b><br>
 *        To access a date-time value stored in an item in a Domino document, use {@link NotesItem#getDateTimeValue()} in Item.<br>
 * 
 *        You can get the operating system date and time separators, and time zone settings through the {@link NotesInternational} class.<br>
 * @example 1. This agent creates a DateTime object that represents 4 March 2005 at 6:07:08 AM. The use of java.util.Calendar eliminates dependencies on regional settings
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			java.util.Calendar jdt = java.util.Calendar.getInstance();
 * 			jdt.set(2005, 2, 4, 6, 7, 8);
 * 			DateTime dt = session.createDateTime(jdt);
 * 			System.out.println(&quot;Local time = &quot; + dt.getLocalTime());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          2. This agent creates a NotesDateTime object that represents 4 March 2005 at 6:07:08 if the regional setting is appropriate, for example, M/d/yy h:mm:ss. When you set the date from a
 *          String, you must be sure that the regional settings of the user's computer are appropriate to the String value
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			if ((session.getInternational().isDateMDY()) &amp;&amp; (session.getInternational().getDateSep().equals(&quot;/&quot;)) &amp;&amp; (session.getInternational().getTimeSep().equals(&quot;:&quot;))) {
 * 				DateTime dt = session.createDateTime(&quot;3/4/05 6:07:08&quot;);
 * 				System.out.println(&quot;Local time = &quot; + dt.getLocalTime());
 * 			} else
 * 				System.out.println(&quot;Date format not MDY with / and :&quot;);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          3. This agent creates a new DateTime object that represents today's date. The time component of the DateTime object is not set
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
 * 			System.out.println(dt.getLocalTime());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          4. This agent creates a new DateTime object that represents the current date and time
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
 * 			dt.setNow();
 * 			System.out.println(dt.getLocalTime());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          5. This agent gets the value of the PurgeDate item in a document and places it into a DateTime object. The time zone setting of PurgeDate is preserved. For example, if PurgeDate has a
 *          value of 03/21/96 04:54:33 PM in Eastern Standard Time, the DateTime object represents 03/21/96 04:54:33 PM and its TimeZone property equals 5
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Document doc = agentContext.getDocumentContext();
 * 			Item item = doc.getFirstItem(&quot;PurgeDate&quot;);
 * 			DateTime dt = item.getDateTimeValue();
 * 			System.out.println(&quot;Local time = &quot; + dt.getLocalTime() + &quot; TZ&quot; + dt.getTimeZone());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 */
public interface NotesDateTime extends NotesBase {
	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustHour(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustHour(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustMinute(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustMinute(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustSecond(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustSecond(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustDay(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustDay(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustMonth(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustMonth(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param n
	 * @throws NotesApiException
	 */
	public abstract void adjustYear(int n) throws NotesApiException;

	/**
	 * @param n
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void adjustYear(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param zone
	 * @param isDST
	 * @throws NotesApiException
	 */
	public abstract void convertToZone(int zone, boolean isDST) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void setAnyDate() throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void setAnyTime() throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void setNow() throws NotesApiException;

	/**
	 * @param dt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int timeDifference(NotesDateTime dt) throws NotesApiException;

	/**
	 * @param dt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double timeDifferenceDouble(NotesDateTime dt) throws NotesApiException;

	/**
	 * @param year
	 * @param month
	 * @param day
	 * @throws NotesApiException
	 */
	public abstract void setLocalDate(int year, int month, int day) throws NotesApiException;

	/**
	 * @param year
	 * @param month
	 * @param day
	 * @param preserveLocalTime
	 * @throws NotesApiException
	 */
	public abstract void setLocalDate(int year, int month, int day, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * @param hour
	 * @param minute
	 * @param second
	 * @param hundreth
	 * @throws NotesApiException
	 */
	public abstract void setLocalTime(int hour, int minute, int second, int hundreth) throws NotesApiException;

	/**
	 * @param dt
	 * @throws NotesApiException
	 */
	public abstract void setLocalTime(Date dt) throws NotesApiException;

	/**
	 * @param dt
	 * @throws NotesApiException
	 */
	public abstract void setLocalTime(Calendar dt) throws NotesApiException;

	/**
	 * A string representing a date-time, converted to Greenwich Mean Time (timezone 0).
	 * 
	 * @return A string representing a date-time, converted to Greenwich Mean Time (timezone 0).
	 * @throws NotesApiException
	 * @usage The GMT time for a date created from a string is determined using the operating system time zone setting, unless the date string specifies a time zone
	 * @example This agent prints the creation date and time of the current database in GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sGMTTime = createdDateTime.getGMTTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle() + &quot;\&quot; was created on &quot; + sGMTTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getGMTTime() throws NotesApiException;

	/**
	 * Indicates whether the time reflects daylight-saving time
	 * 
	 * @return Indicates whether the time reflects daylight-saving time
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the current computer is set to observe daylight-saving time, and daylight-saving time is currently in effect (for example, from mid-April to mid-October)</li>
	 *              <li>false if the current computer is set to observe daylight-saving time, but daylight-saving time is not currently in effect (for example, from mid-October to mid-April); the
	 *              current computer is not set to observe daylight-saving time; the DateTime object has no date component; or the DateTime object has no time component</li>
	 *              </ul>
	 * @usage For remote (IIOP) operations, the current computer is the Domino server. For local operations, the current computer is the computer on which the program is running.
	 * 
	 *        The {@link #convertToZone(int, boolean)} method and {@link #getLocalTime()} property may modify the value of this property
	 * 
	 * @example This agent prints one message or another depending on whether daylight-saving time is in effect
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			if (dt.isDST())
	 * 				System.out.println(&quot;Enjoy the long days&quot;);
	 * 			else
	 * 				System.out.println(&quot;Endure the darkness&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isDST() throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @return A string representing a date-time in the local time zone. Additional methods let you set the local time with Date, integer, and Boolean values
	 * @throws NotesApiException
	 */
	public abstract String getLocalTime() throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param dt
	 *            A string representation of the date
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time that the object represents, and therefore affects the GMTTime property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth parameters specify the new time. The preserveLocalTime parameter affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or decrement the GMT time by one hour so that a 24-hour adjustment yields the same local time in the new day. If this parameter
	 *        is false or omitted, GMT time remains as adjusted and local time gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also change the time zone
	 */
	public abstract void setLocalTime(String dt) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getTimeZone() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getZoneTime() throws NotesApiException;

	/**
	 * A string representation of the date part of the time-date
	 * 
	 * @return A string representation of the date part of the time-date
	 * @throws NotesApiException
	 * @example This agent prints the creation date of the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sCreatedDate = createdDateTime.getDateOnly();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle() + &quot;\&quot; was created on &quot; + sCreatedDate + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getDateOnly() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesSession getParent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getTimeOnly() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Date toJavaDate() throws NotesApiException;
}
