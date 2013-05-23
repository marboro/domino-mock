package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a range of dates and times
 * 
 * @author Sven Dreher
 * @access To create a new DateRange object, use createDateRange in Session. To
 *         initialize the object, you can do one of the following:
 *         <ul>
 *         <li>Assign values to the createDateRange parameters.</li>
 *         <li>Assign to StartDateTime and EndDateTime DateTime values.</li>
 *         <li>Assign to Text a string value that represents a date range. This
 *         consists of two string representations of Domino-formatted date-time
 *         values separated by a hyphen (for example, "01/01/97 - 01/02/97").</li>
 *         </ul>
 * @usage When you assign StartDateTime or EndDateTime, its value replaces the
 *        corresponding value in Text, and vice versa
 * @example 1. This example sets the StartDateTime and EndDateTime properties of
 *          a DateRange object through the createDateRange parameters, then
 *          displays the value of the Text property
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
 * 			DateTime dtdb = db.getCreated();
 * 			DateTime dtnow = session.createDateTime(&quot;Today&quot;);
 * 			dtnow.setNow();
 * 			DateRange dr = session.createDateRange(dtdb, dtnow);
 * 			System.out.println(&quot;Creation date - now:&quot;);
 * 			System.out.println(&quot;  &quot; + dr.getText());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          2. This example sets the StartDateTime and EndDateTime properties of
 *          a DateRange object through the property methods, then displays the
 *          value of the Text property
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
 * 			DateTime dtdb = db.getCreated();
 * 			DateTime dtnow = session.createDateTime(&quot;Today&quot;);
 * 			dtnow.setNow();
 * 			DateRange dr = session.createDateRange();
 * 			dr.setStartDateTime(dtdb);
 * 			dr.setEndDateTime(dtnow);
 * 			System.out.println(&quot;Creation date - now:&quot;);
 * 			System.out.println(&quot;  &quot; + dr.getText());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          3. This example writes a value to the Text property, then displays
 *          the LocalTime property of the StartDateTime and EndDateTime
 *          properties (which are DateTime objects)
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
 * 			DateTime dtdb = db.getCreated();
 * 			DateTime dtnow = session.createDateTime(&quot;Today&quot;);
 * 			dtnow.setNow();
 * 			DateRange dr = session.createDateRange();
 * 			dr.setText(dtdb.getLocalTime() + &quot; - &quot; + dtnow.getLocalTime());
 * 			System.out.println(&quot;Start date = &quot;
 * 					+ dr.getStartDateTime().getLocalTime());
 * 			System.out.println(&quot;End date = &quot;
 * 					+ dr.getEndDateTime().getLocalTime());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          4. This example sets a value for a DateRange object, then changes
 *          the DateTime object that the EndDateTime property is based on. This
 *          implicitly changes the EndDateTime property
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
 * 			DateTime dtdb = db.getCreated();
 * 			DateTime dtplus = session.createDateTime(&quot;Today&quot;);
 * 			dtplus.setNow();
 * 			DateRange dr = session.createDateRange(dtdb, dtplus);
 * 			dtplus.adjustMonth(2);
 * 			System.out.println(&quot;Creation date - 2 months from now:&quot;);
 * 			System.out.println(&quot;  &quot; + dr.getText());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 */
public interface NotesDateRange extends NotesBase {
	/**
	 * The starting date-time of a range
	 * 
	 * @return The starting date-time of a range
	 * @throws NotesApiException
	 * @usage Modifying the DateTime object on which StartDateTime is based
	 *        implicitly modifies StartDateTime. This does not apply if
	 *        StartDateTime is based on a java.util.Date object.
	 * 
	 *        The DateTime object in setStartDateTime cannot be null
	 */
	NotesDateTime getStartDateTime() throws NotesApiException;

	/**
	 * The starting date-time of a range
	 * 
	 * @param start
	 *            The starting date-time of a range
	 * @throws NotesApiException
	 * @usage Modifying the DateTime object on which StartDateTime is based
	 *        implicitly modifies StartDateTime. This does not apply if
	 *        StartDateTime is based on a java.util.Date object.
	 * 
	 *        The DateTime object in setStartDateTime cannot be null
	 */
	void setStartDateTime(NotesDateTime start) throws NotesApiException;

	/**
	 * The ending date-time of a range
	 * 
	 * @return The ending date-time of a range
	 * @throws NotesApiException
	 * @usage Modifying the DateTime object on which EndDateTime is based
	 *        implicitly modifies EndDateTime. This does not apply if
	 *        EndDateTime is based on a java.util.Date object.
	 * 
	 *        The DateTime object in setEndDateTime cannot be null
	 */
	NotesDateTime getEndDateTime() throws NotesApiException;

	/**
	 * The ending date-time of a range
	 * 
	 * @param end
	 *            The ending date-time of a range
	 * @throws NotesApiException
	 * @usage Modifying the DateTime object on which EndDateTime is based
	 *        implicitly modifies EndDateTime. This does not apply if
	 *        EndDateTime is based on a java.util.Date object.
	 * 
	 *        The DateTime object in setEndDateTime cannot be null
	 */
	void setEndDateTime(NotesDateTime end) throws NotesApiException;

	/**
	 * The session that contains a DateRange object
	 * 
	 * @return The session that contains a DateRange object
	 * @throws NotesApiException
	 */
	NotesSession getParent() throws NotesApiException;

	/**
	 * The text associated with a range formatted as Domino date-time text
	 * 
	 * @return The text associated with a range formatted as Domino date-time
	 *         text
	 * @throws NotesApiException
	 */
	String getText() throws NotesApiException;

	/**
	 * The text associated with a range formatted as Domino date-time text
	 * 
	 * @param text
	 *            The text associated with a range formatted as Domino date-time
	 *            text
	 * @throws NotesApiException
	 */
	void setText(String text) throws NotesApiException;
}
