package org.openntf.domino.mock.interfaces;

import java.util.Calendar;
import java.util.Date;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a date and time
 * 
 * @author Sven Dreher
 * @access To create a new DateTime object, use
 *         {@link NotesSession#createDateTime(Date)} in Session
 * @usage After creating a DateTime object with
 *        {@link NotesSession#createDateTime(Date)}, you can reset the date and
 *        time with {@link #setLocalTime(int, int, int, int)} and
 *        {@link #setLocalDate(int, int, int)}. The
 *        {@link NotesSession#createDateTime(Date)} method takes a String,
 *        java.util.Date, or java.util.Calendar parameter. One form of
 *        {@link #setLocalTime(String)} takes a String parameter, another form
 *        takes a java.util.Date parameter, and a third form takes a
 *        java.util.Calendar parameter. Other forms of
 *        {@link #setLocalTime(int, int, int, int)} and
 *        {@link #setLocalDate(int, int, int, boolean)} take multiple int
 *        parameters.<br>
 * 
 *        The String form of the date parameter is a date, followed by a space,
 *        followed by a time. You can specify a date without a time, and a time
 *        without a date, but the time zone will not be set (see "Time zones"
 *        below).<br>
 * 
 *        The following applies when setting a date and time from a String
 *        value:<br>
 *        <ul>
 *        <li>
 *        The date and time components are interpreted according to the regional
 *        settings of the operating system if possible. For example, if the
 *        regional setting for dates is M/d/yy, then "3/4/05" means 4 March
 *        2005.</li>
 *        <li>If the date or time cannot be interpreted using the regional
 *        setting, alternate settings are tried until one works. For example, if
 *        the regional setting for dates is M/d/yy, then "13/4/05" means 13
 *        April 2005 (using d/M/yy as the alternate setting) and "13/33/05"
 *        means 13 May 2033 (using d/yy/M as the alternate setting).</li>
 *        <li>If the date or time cannot be interpreted using any setting, the
 *        following exception is thrown: NOTES_ERR_INVALID_DATE (4045).</li>
 *        </ul>
 *        The java.util.Calendar class can be used to avoid dependencies on
 *        regional settings. For example, you can use getInstance and one of the
 *        set methods to create the parameter for
 *        {@link NotesSession#createDateTime(Date)}.
 * 
 *        <b>Time zones</b><br>
 *        When you create a new DateTime object, the time zone setting in Domino
 *        determines the {@link #getTimeZone()} property. For example, if the
 *        code runs on a computer where the Domino time zone is set to Eastern
 *        Standard Time, the TimeZone property of any new DateTime object is
 *        automatically set to 5. The time zone setting also affects the GMTTime
 *        and LSGMTTime properties.<br>
 * 
 *        If you create a date without a time component or without a date
 *        component, the time zone is invalid and the TimeZone property returns
 *        0. In this case, both LocalTime and GMTTime return the same time value
 *        without a time zone appended. If you apply
 *        {@link #convertToZone(int, boolean)}, the time zone remains invalid
 *        and TimeZone remains 0; no error occurs.<br>
 * 
 *        <b>Today, Tomorrow, and Yesterday</b><br>
 *        When you create a new DateTime object using an expression such as
 *        "Today," "Tommorow," or "Yesterday," the value of the date is
 *        determined using the current date setting in Domino. These expressions
 *        have no effect on the time component of a DateTime object. To set a
 *        DateTime to the current date and time, specify the time after "Today"
 *        or "Yesterday" (for example, "Today 12:00:00 AM") or use
 *        {@link #setNow()}.<br>
 * 
 *        <b>Access</b><br>
 *        To access a date-time value stored in an item in a Domino document,
 *        use {@link NotesItem#getDateTimeValue()} in Item.<br>
 * 
 *        You can get the operating system date and time separators, and time
 *        zone settings through the {@link NotesInternational} class.<br>
 * @example 1. This agent creates a DateTime object that represents 4 March 2005
 *          at 6:07:08 AM. The use of java.util.Calendar eliminates dependencies
 *          on regional settings
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * class JavaAgent extends AgentBase {
 * 	void NotesMain() {
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
 *          2. This agent creates a NotesDateTime object that represents 4 March
 *          2005 at 6:07:08 if the regional setting is appropriate, for example,
 *          M/d/yy h:mm:ss. When you set the date from a String, you must be
 *          sure that the regional settings of the user's computer are
 *          appropriate to the String value
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * class JavaAgent extends AgentBase {
 * 	void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			if ((session.getInternational().isDateMDY())
 * 					&amp;&amp; (session.getInternational().getDateSep().equals(&quot;/&quot;))
 * 					&amp;&amp; (session.getInternational().getTimeSep().equals(&quot;:&quot;))) {
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
 *          3. This agent creates a new DateTime object that represents today's
 *          date. The time component of the DateTime object is not set
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * class JavaAgent extends AgentBase {
 * 	void NotesMain() {
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
 *          4. This agent creates a new DateTime object that represents the
 *          current date and time
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * class JavaAgent extends AgentBase {
 * 	void NotesMain() {
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
 *          5. This agent gets the value of the PurgeDate item in a document and
 *          places it into a DateTime object. The time zone setting of PurgeDate
 *          is preserved. For example, if PurgeDate has a value of 03/21/96
 *          04:54:33 PM in Eastern Standard Time, the DateTime object represents
 *          03/21/96 04:54:33 PM and its TimeZone property equals 5
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * class JavaAgent extends AgentBase {
 * 	void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Document doc = agentContext.getDocumentContext();
 * 			Item item = doc.getFirstItem(&quot;PurgeDate&quot;);
 * 			DateTime dt = item.getDateTimeValue();
 * 			System.out.println(&quot;Local time = &quot; + dt.getLocalTime() + &quot; TZ&quot;
 * 					+ dt.getTimeZone());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 */
public interface NotesDateTime extends NotesBase {
	/**
	 * Increments a date-time by the number of hours you specify
	 * 
	 * @param n
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect.
	 * 
	 *        The number of hours by which you increment a DateTime object can
	 *        cause the date component to be adjusted, too. For example, if the
	 *        adjustment is +24, the date component changes to the next calendar
	 *        day.
	 * @example This agent decrements the time by 10 hours
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustHour(-10, true);
	 * 			System.out.println(&quot;Ten hours ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustHour(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of hours you specify
	 * 
	 * @param n
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect.
	 * 
	 *        The number of hours by which you increment a DateTime object can
	 *        cause the date component to be adjusted, too. For example, if the
	 *        adjustment is +24, the date component changes to the next calendar
	 *        day.
	 * @example This agent decrements the time by 10 hours
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustHour(-10, true);
	 * 			System.out.println(&quot;Ten hours ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustHour(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * Increments a date-time by the number of minutes you specify
	 * 
	 * @param n
	 *            The number of minutes by which to increment the date-time. Can
	 *            be positive or negative
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect.
	 * 
	 *        The number of minutes by which you increment a DateTime object can
	 *        cause the date component to be adjusted, too. For example, if the
	 *        adjustment is +1440, the date component changes to the next
	 *        calendar day
	 * @example This agent decrements the time by 10 minutes
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustMinute(-10, true);
	 * 			System.out.println(&quot;Ten minutes ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustMinute(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of minutes you specify
	 * 
	 * @param n
	 *            The number of minutes by which to increment the date-time. Can
	 *            be positive or negative
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect.
	 * 
	 *        The number of minutes by which you increment a DateTime object can
	 *        cause the date component to be adjusted, too. For example, if the
	 *        adjustment is +1440, the date component changes to the next
	 *        calendar day
	 * @example This agent decrements the time by 10 minutes
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustMinute(-10, true);
	 * 			System.out.println(&quot;Ten minutes ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustMinute(int n, boolean preserveLocalTime)
			throws NotesApiException;

	/**
	 * Increments a date-time by the number of seconds you specify
	 * 
	 * @param n
	 *            The number of seconds by which to increment the date-time. Can
	 *            be positive or negative
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect
	 * @example This agent decrements the time by 10 seconds
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustSecond(-10, true);
	 * 			System.out.println(&quot;Ten seconds ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustSecond(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of seconds you specify
	 * 
	 * @param n
	 *            The number of seconds by which to increment the date-time. Can
	 *            be positive or negative
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a date component, this
	 *        method has no effect
	 * @example This agent decrements the time by 10 seconds
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Now: &quot; + dt.getLocalTime());
	 * 			dt.adjustSecond(-10, true);
	 * 			System.out.println(&quot;Ten seconds ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustSecond(int n, boolean preserveLocalTime)
			throws NotesApiException;

	/**
	 * Increments a date-time by the number of days you specify
	 * 
	 * @param n
	 *            The number of days by which to increment the date-time. Can be
	 *            positive or negative
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of days by which you increment a DateTime object can
	 *        cause the month to be incremented
	 * @example This agent decrements the date by 10 days
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustDay(-10, true);
	 * 			System.out.println(&quot;Ten days ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 */
	void adjustDay(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of days you specify
	 * 
	 * @param n
	 *            The number of days by which to increment the date-time. Can be
	 *            positive or negative
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of days by which you increment a DateTime object can
	 *        cause the month to be incremented
	 * @example This agent decrements the date by 10 days
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustDay(-10, true);
	 * 			System.out.println(&quot;Ten days ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustDay(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * Increments a date-time by the number of months you specify
	 * 
	 * @param n
	 *            The number of months by which to increment the date-time. Can
	 *            be positive or negative
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of months by which you increment a DateTime object can
	 *        cause the year to be incremented. For example, if the adjustment
	 *        is +12, the date component changes to the next calendar year
	 * @example This agent decrements the date by 10 months
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustMonth(-10, true);
	 * 			System.out.println(&quot;Ten months ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustMonth(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of months you specify
	 * 
	 * @param n
	 *            The number of months by which to increment the date-time. Can
	 *            be positive or negative
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of months by which you increment a DateTime object can
	 *        cause the year to be incremented. For example, if the adjustment
	 *        is +12, the date component changes to the next calendar year
	 * @example This agent decrements the date by 10 months
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustMonth(-10, true);
	 * 			System.out.println(&quot;Ten months ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustMonth(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * Increments a date-time by the number of years you specify
	 * 
	 * @param n
	 *            The number of years by which to increment the date-time. Can
	 *            be positive or negative
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of years by which you increment a DateTime object can
	 *        cause the century to change. If this happens, the year is
	 *        represented as a string with four digits instead of two, such as
	 *        08/18/2001
	 * @example This agent decrements the date by 10 years
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustYear(-10, true);
	 * 			System.out.println(&quot;Ten years ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustYear(int n) throws NotesApiException;

	/**
	 * Increments a date-time by the number of years you specify
	 * 
	 * @param n
	 *            The number of years by which to increment the date-time. Can
	 *            be positive or negative
	 * @param preserveLocalTime
	 *            Affects adjustments that cross a daylight-saving time
	 *            boundary. Specify true to increment or decrement the GMT time
	 *            by one hour such that a 24-hour adjustment yields the same
	 *            local time in the new day. If this parameter is false or
	 *            omitted, GMT time remains as adjusted and local time gains or
	 *            loses an hour
	 * @throws NotesApiException
	 * @usage If the DateTime object consists of only a time component, this
	 *        method has no effect.
	 * 
	 *        The number of years by which you increment a DateTime object can
	 *        cause the century to change. If this happens, the year is
	 *        represented as a string with four digits instead of two, such as
	 *        08/18/2001
	 * @example This agent decrements the date by 10 years
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			System.out.println(&quot;Today: &quot; + dt.getLocalTime());
	 * 			dt.adjustYear(-10, true);
	 * 			System.out.println(&quot;Ten years ago: &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void adjustYear(int n, boolean preserveLocalTime) throws NotesApiException;

	/**
	 * Changes the TimeZone and IsDST properties as specified
	 * 
	 * @param zone
	 *            A time zone -12 through 12
	 * @param isDST
	 *            Indicates whether daylight-saving time is in effect (true) or
	 *            not (false).
	 * @throws NotesApiException
	 * @usage These changes also affect the ZoneTime property.<br>
	 * 
	 *        These changes do not affect the GMTTime and the LocalTime
	 *        properties.<br>
	 * 
	 *        This method has no effect on an invalid TimeZone (because the
	 *        DateTime object lacks the date or the time). TimeZone continues to
	 *        return 0.<br>
	 * 
	 *        <b>Caution</b> This method uses the daylight saving time rules of
	 *        the zone being converted from, not the zone being converted to. <br>
	 * 
	 *        Daylight saving time is a world-wide practice of decreasing energy
	 *        consumption by adjusting clocks forward an hour, changing the
	 *        offset from GMT. The TimeZone property indicates the base offset
	 *        from GMT. For example, standard time in New York City is GMT -5,
	 *        but when daylight savings is in effect, New York City is GMT -4<br>
	 * 
	 * @example This agent converts today at 6:00 AM to all the time zones using
	 *          daylight-saving time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 
	 * 	void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today 06:00&quot;);
	 * 			System.out.println(&quot;Zone\tTime&quot;);
	 * 			for (int i = -12; i &lt;= 12; i++) {
	 * 				dt.convertToZone(i, true);
	 * 				System.out.println(dt.getTimeZone() + &quot;\t&quot; + dt.getZoneTime());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void convertToZone(int zone, boolean isDST) throws NotesApiException;

	/**
	 * Sets the date component to a wildcard value, which means that it matches
	 * any date. The time component is unaffected
	 * 
	 * @throws NotesApiException
	 * @usage This method is useful when passing the object as an argument to
	 *        other methods.
	 * 
	 *        A DateTime object for which you have invoked this method may not
	 *        be convertible to string format.
	 * @example This agent sets the date component to any date, then sets the
	 *          time component to any time.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			dt.setAnyDate(); // Set date part to any date
	 * 			System.out.println(&quot;Time = &quot; + dt.getLocalTime());
	 * 			dt.setNow();
	 * 			dt.setAnyTime(); // Sets time part to any time
	 * 			System.out.println(&quot;Date = &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setAnyDate() throws NotesApiException;

	/**
	 * Sets the time component to a wildcard value, which means that it matches
	 * any time. The date component is unaffected
	 * 
	 * @throws NotesApiException
	 * @usage This method is useful when passing the object as an argument to
	 *        other methods.
	 * 
	 *        A date-time object for which you have invoked this method may not
	 *        be convertible to string format
	 * 
	 * @example This agent sets the date component to any date, then sets the
	 *          time component to any time.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			dt.setAnyDate(); // Set date part to any date
	 * 			System.out.println(&quot;Time = &quot; + dt.getLocalTime());
	 * 			dt.setNow();
	 * 			dt.setAnyTime(); // Sets time part to any time
	 * 			System.out.println(&quot;Date = &quot; + dt.getLocalTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setAnyTime() throws NotesApiException;

	/**
	 * Sets the value of a date-time to now (today's date and current time)
	 * 
	 * @throws NotesApiException
	 * @usage For remote (IIOP) operations, the date-time value is based on the
	 *        host computer. For local operations, the date-time value is based
	 *        on the computer on which the program is running.
	 * 
	 *        This method works by taking a snapshot of the current date-time at
	 *        the moment that the method is executed. After the method executes,
	 *        the value of the DateTime object does not update itself to always
	 *        reflect the current date-time. Its value only changes if you
	 *        change it explicitly
	 * @example This agent increments the current time by 2 months and appends
	 *          this value to the PurgeDate item
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Document doc = db.createDocument();
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			dt.adjustMonth(2, true);
	 * 			doc.appendItemValue(&quot;Form&quot;, &quot;Main Topic&quot;);
	 * 			doc.appendItemValue(&quot;Subject&quot;, &quot;2-month document&quot;);
	 * 			doc.appendItemValue(&quot;PurgeDate&quot;, dt);
	 * 			doc.save(true, true);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setNow() throws NotesApiException;

	/**
	 * Finds the difference in seconds between one date-time and another
	 * 
	 * @param dt
	 *            Any date-time value
	 * @return The date-time of the object minus the date-time of the parameter,
	 *         in seconds
	 * @throws NotesApiException
	 * @example This agent calculates the number of days since a document was
	 *          created
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			DateTime nowDateTime = session.createDateTime(&quot;Today&quot;);
	 * 			nowDateTime.setNow();
	 * 			int daysSinceCreated = nowDateTime.timeDifference(createdDateTime) / 86400;
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created &quot; + daysSinceCreated + &quot; days ago.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int timeDifference(NotesDateTime dt) throws NotesApiException;

	/**
	 * Finds the difference in seconds between one date-time and another
	 * 
	 * @param dt
	 *            Any date-time value
	 * @return The date-time of the object minus the date-time of the parameter,
	 *         in seconds
	 * @throws NotesApiException
	 * @example This agent calculates the number of days since a document was
	 *          created
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			DateTime nowDateTime = session.createDateTime(&quot;Today&quot;);
	 * 			nowDateTime.setNow();
	 * 			int daysSinceCreated = nowDateTime.timeDifference(createdDateTime) / 86400;
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created &quot; + daysSinceCreated + &quot; days ago.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	double timeDifferenceDouble(NotesDateTime dt) throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param year
	 *            The year
	 * @param month
	 *            The month
	 * @param day
	 *            The day
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalDate(int year, int month, int day) throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param year
	 *            The year
	 * @param month
	 *            The month
	 * @param day
	 *            The day
	 * @param preserveLocalTime
	 *            Affects adjustments from the existing date that cross a
	 *            daylight-saving time boundary
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalDate(int year, int month, int day, boolean preserveLocalTime)
			throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param hour
	 *            The hour
	 * @param minute
	 *            The minute
	 * @param second
	 *            The second
	 * @param hundreth
	 *            The hundreth of a second
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalTime(int hour, int minute, int second, int hundreth)
			throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param dt
	 *            A string representation of the date
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalTime(Date dt) throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param dt
	 *            A string representation of the date
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalTime(Calendar dt) throws NotesApiException;

	/**
	 * A string representing a date-time, converted to Greenwich Mean Time
	 * (timezone 0).
	 * 
	 * @return A string representing a date-time, converted to Greenwich Mean
	 *         Time (timezone 0).
	 * @throws NotesApiException
	 * @usage The GMT time for a date created from a string is determined using
	 *        the operating system time zone setting, unless the date string
	 *        specifies a time zone
	 * @example This agent prints the creation date and time of the current
	 *          database in GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sGMTTime = createdDateTime.getGMTTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sGMTTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getGMTTime() throws NotesApiException;

	/**
	 * Indicates whether the time reflects daylight-saving time
	 * 
	 * @return Indicates whether the time reflects daylight-saving time
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the current computer is set to observe
	 *              daylight-saving time, and daylight-saving time is currently
	 *              in effect (for example, from mid-April to mid-October)</li>
	 *              <li>false if the current computer is set to observe
	 *              daylight-saving time, but daylight-saving time is not
	 *              currently in effect (for example, from mid-October to
	 *              mid-April); the current computer is not set to observe
	 *              daylight-saving time; the DateTime object has no date
	 *              component; or the DateTime object has no time component</li>
	 *              </ul>
	 * @usage For remote (IIOP) operations, the current computer is the Domino
	 *        server. For local operations, the current computer is the computer
	 *        on which the program is running.
	 * 
	 *        The {@link #convertToZone(int, boolean)} method and
	 *        {@link #getLocalTime()} property may modify the value of this
	 *        property
	 * 
	 * @example This agent prints one message or another depending on whether
	 *          daylight-saving time is in effect
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
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
	boolean isDST() throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @return A string representing a date-time in the local time zone.
	 *         Additional methods let you set the local time with Date, integer,
	 *         and Boolean values
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getLocalTime() throws NotesApiException;

	/**
	 * A string representing a date-time in the local time zone. Additional
	 * methods let you set the local time with Date, integer, and Boolean values
	 * 
	 * @param dt
	 *            A string representation of the date
	 * @throws NotesApiException
	 * @usage When you set this property, it changes the value of the date-time
	 *        that the object represents, and therefore affects the GMTTime
	 *        property.
	 * 
	 *        The dt, year, month, day, hour, minute, second, and hundredth
	 *        parameters specify the new time. The preserveLocalTime parameter
	 *        affects adjustments from the existing date that cross a
	 *        daylight-saving time boundary. Specify true to increment or
	 *        decrement the GMT time by one hour so that a 24-hour adjustment
	 *        yields the same local time in the new day. If this parameter is
	 *        false or omitted, GMT time remains as adjusted and local time
	 *        gains or loses an hour.
	 * 
	 *        Setting this property with a java.util.Calendar object may also
	 *        change the time zone
	 * @example 1. This agent prints the creation date and time of the current
	 *          database in local time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sLocalTime = createdDateTime.getLocalTime();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sLocalTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the local date and time, then prints the date
	 *          and time in local time and GMT
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalTime(&quot;12/12/97 04:30:00 PM&quot;);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent is the same as above but passes the date and time
	 *          as integer values to setLocalDate and setLocalTime, rather than
	 *          as a string to setLocalTime
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setLocalDate(1997, 12, 12, true);
	 * 			dt.setLocalTime(1, 30, 0, 0);
	 * 			System.out.println(dt.getLocalTime());
	 * 			System.out.println(dt.getGMTTime());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLocalTime(String dt) throws NotesApiException;

	/**
	 * An integer representing the time zone of a date-time. This integer
	 * indicates the number of hours that must be added to the time to get
	 * Greenwich Mean Time when daylight-saving time is not in effect. May be
	 * positive or negative
	 * 
	 * @return An integer representing the time zone of a date-time. This
	 *         integer indicates the number of hours that must be added to the
	 *         time to get Greenwich Mean Time when daylight-saving time is not
	 *         in effect. May be positive or negative
	 * @throws NotesApiException
	 * @usage When you create a new DateTime object, this property is set
	 *        according to the time zone setting of the computer on which the
	 *        program runs or, for remote (IIOP) operations, the Domino server.
	 * 
	 *        This property is not set and returns 0 if the DateTime object does
	 *        not include both a time and a date.
	 * 
	 *        When you access a date-time value from an item in a document using
	 *        the DateTimeValue property in Item, this property is set according
	 *        to the time zone stored in the item.
	 * 
	 *        The convertToZone method and LocalTime property may modify the
	 *        value of this property
	 * @example This agent prints the time zone in the CreationDateSaved item of
	 *          each document in the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DocumentCollection dc = db.getAllDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				Vector dtv = doc.getItemValue(&quot;CreationDateSaved&quot;);
	 * 				DateTime cds = (DateTime) dtv.firstElement();
	 * 				int zone = cds.getTimeZone();
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;)
	 * 						+ &quot; was created in time zone &quot; + zone);
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 */
	int getTimeZone() throws NotesApiException;

	/**
	 * A string representation of the time adjusted for the TimeZone and IsDST
	 * properties
	 * 
	 * @return A string representation of the time adjusted for the TimeZone and
	 *         IsDST properties
	 * @throws NotesApiException
	 * @usage Initially ZoneTime is the same as LocalTime. If you use the
	 *        convertToZone method or LocalTime, changes to TimeZone and IsDST
	 *        are reflected in ZoneTime, but LocalTime stays the same
	 * @example This agent converts today at 6:00 AM to all the time zones using
	 *          daylight-saving time
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 
	 * 	void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			DateTime dt = session.createDateTime(&quot;Today 06:00&quot;);
	 * 			System.out.println(&quot;Zone\tTime&quot;);
	 * 			for (int i = -12; i &lt;= 12; i++) {
	 * 				dt.convertToZone(i, true);
	 * 				System.out.println(dt.getTimeZone() + &quot;\t&quot; + dt.getZoneTime());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getZoneTime() throws NotesApiException;

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
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sCreatedDate = createdDateTime.getDateOnly();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created on &quot; + sCreatedDate + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getDateOnly() throws NotesApiException;

	/**
	 * The Notes session that contains a DateTime object
	 * 
	 * @return The Notes session that contains a DateTime object
	 * @throws NotesApiException
	 */
	NotesSession getParent() throws NotesApiException;

	/**
	 * A string representation of the time part of the date-time
	 * 
	 * @return A string representation of the time part of the date-time
	 * @throws NotesApiException
	 * @example This agent prints the creation time of the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			DateTime createdDateTime = db.getCreated();
	 * 			String sCreatedTime = createdDateTime.getTimeOnly();
	 * 			System.out.println(&quot;Database \&quot;&quot; + db.getTitle()
	 * 					+ &quot;\&quot; was created at &quot; + sCreatedTime + &quot;.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getTimeOnly() throws NotesApiException;

	/**
	 * Converts a Notes date and time into a java.util.Date object
	 * 
	 * @return The date-time of the object in Java format
	 * @throws NotesApiException
	 */
	Date toJavaDate() throws NotesApiException;
}
