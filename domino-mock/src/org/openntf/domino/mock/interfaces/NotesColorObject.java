package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a color
 * 
 * @author Sven Dreher
 * @access To create a ColorObject object, use the
 *         {@link NotesSession#createColorObject()} method of Session.
 * 
 * @usage Domino defines colors numbered 0 through 240, as reflected in the
 *        read-write property NotesColor. Each Domino color maps to RGB (red,
 *        green, and blue) values in the range 0-255 and HSL (hue, saturation,
 *        and luminance) values in the range 0-240, as reflected in the
 *        remaining, read-only properties.
 * 
 *        NotesColor can be used as the value for the following properties:
 *        Color in RichTextStyle; BackgroundColor in View; FontColor and
 *        HeaderFontColor in ViewColumn.
 * 
 *        The following table lists the values for the first 16 Domino colors,
 *        which are defined by Java constants. See the example for code to
 *        generate the values for all 241 colors.
 * 
 *        <table border=1>
 *        <tr>
 *        <th>Notes</th>
 *        <th>Red</th>
 *        <th>Grn</th>
 *        <th>Blue</th>
 *        <th>Hue</th>
 *        <th>Sat</th>
 *        <th>Lum</th>
 *        <th>Constant</th>
 *        </tr>
 *        <tr>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>160</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>NotesRichTextStyle.COLOR_BLACK</td>
 *        </tr>
 *        <tr>
 *        <td>1</td>
 *        <td>255</td>
 *        <td>255</td>
 *        <td>255</td>
 *        <td>160</td>
 *        <td>0</td>
 *        <td>240</td>
 *        <td>NotesRichTextStyle.COLOR_WHITE</td>
 *        </tr>
 *        <tr>
 *        <td>2</td>
 *        <td>255</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_RED</td>
 *        </tr>
 *        <tr>
 *        <td>3</td>
 *        <td>0</td>
 *        <td>255</td>
 *        <td>0</td>
 *        <td>80</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_GREEN</td>
 *        </tr>
 *        <tr>
 *        <td>4</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>255</td>
 *        <td>160</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_BLUE</td>
 *        </tr>
 *        <tr>
 *        <td>5</td>
 *        <td>255</td>
 *        <td>0</td>
 *        <td>255</td>
 *        <td>200</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_MAGENTA</td>
 *        </tr>
 *        <tr>
 *        <td>6</td>
 *        <td>255</td>
 *        <td>255</td>
 *        <td>0</td>
 *        <td>40</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_YELLOW</td>
 *        </tr>
 *        <tr>
 *        <td>7</td>
 *        <td>0</td>
 *        <td>255</td>
 *        <td>255</td>
 *        <td>120</td>
 *        <td>240</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_CYAN</td>
 *        </tr>
 *        <tr>
 *        <td>8</td>
 *        <td>128</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_RED</td>
 *        </tr>
 *        <tr>
 *        <td>9</td>
 *        <td>0</td>
 *        <td>128</td>
 *        <td>0</td>
 *        <td>80</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_GREEN</td>
 *        </tr>
 *        <tr>
 *        <td>10</td>
 *        <td>0</td>
 *        <td>0</td>
 *        <td>128</td>
 *        <td>160</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_BLUE</td>
 *        </tr>
 *        <tr>
 *        <td>11</td>
 *        <td>128</td>
 *        <td>0</td>
 *        <td>128</td>
 *        <td>200</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_MAGENTA</td>
 *        </tr>
 *        <tr>
 *        <td>12</td>
 *        <td>128</td>
 *        <td>128</td>
 *        <td>0</td>
 *        <td>40</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_YELLOW</td>
 *        </tr>
 *        <tr>
 *        <td>13</td>
 *        <td>0</td>
 *        <td>128</td>
 *        <td>128</td>
 *        <td>120</td>
 *        <td>240</td>
 *        <td>60</td>
 *        <td>NotesRichTextStyle.COLOR_DARK_CYAN</td>
 *        </tr>
 *        <tr>
 *        <td>14</td>
 *        <td>128</td>
 *        <td>128</td>
 *        <td>128</td>
 *        <td>160</td>
 *        <td>0</td>
 *        <td>120</td>
 *        <td>NotesRichTextStyle.COLOR_GRAY</td>
 *        </tr>
 *        <tr>
 *        <td>15</td>
 *        <td>192</td>
 *        <td>192</td>
 *        <td>192</td>
 *        <td>160</td>
 *        <td>0</td>
 *        <td>181</td>
 *        <td>NotesRichTextStyle.COLOR_LIGHT_GRAY</td>
 *        </tr>
 *        </table>
 * 
 * @example This agent builds a rich text item that contains one line for each
 *          Domino color. The line identifies the Domino color, the RGB values,
 *          and the HSL values. The line displays in the color being represented
 *          so some lines are not visible depending on the background color of
 *          the form. The form, named Colors, has two fields named Subject
 *          (text) and Body (rich text).
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 
 * 	public void NotesMain() {
 * 
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 
 * 			// (Your code goes here)
 * 			Database db = agentContext.getCurrentDatabase();
 * 			Document doc = db.createDocument();
 * 			doc.replaceItemValue(&quot;Form&quot;, &quot;Colors&quot;);
 * 			doc.replaceItemValue(&quot;Subject&quot;, &quot;Colors&quot;);
 * 			ColorObject color = session.createColorObject();
 * 			RichTextItem rti = doc.createRichTextItem(&quot;Body&quot;);
 * 			RichTextStyle rts = session.createRichTextStyle();
 * 			rts.setFontSize(12);
 * 			rts.setBold(RichTextStyle.YES);
 * 			for (int i = 0; i &lt;= 240; i++) {
 * 				color.setNotesColor(i);
 * 				rts.setColor(i);
 * 				rti.appendStyle(rts);
 * 				rti.appendText(to3String(i));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Red &quot; + to3String(color.getRed()));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Green &quot; + to3String(color.getGreen()));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Blue &quot; + to3String(color.getBlue()));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Hue &quot; + to3String(color.getHue()));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Saturation &quot; + to3String(color.getSaturation()));
 * 				rti.addTab(1);
 * 				rti.appendText(&quot;Luminance &quot; + to3String(color.getLuminance()));
 * 				if (i != 240)
 * 					rti.addNewLine(1);
 * 			}
 * 			doc.save(true, true);
 * 
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * 
 * 	String str = new String();
 * 
 * 	String to3String(int i) {
 * 		str = str.valueOf(i);
 * 		if (str.length() == 3)
 * 			;
 * 		else if (str.length() == 2)
 * 			str = &quot;0&quot; + str;
 * 		else
 * 			str = &quot;00&quot; + str;
 * 		return (str);
 * 	}
 * }
 * </pre>
 */
public interface NotesColorObject extends NotesBase {
	/**
	 * Sets an RGB value to the closest Domino color and HSL value
	 * 
	 * @param red
	 *            Red component of the RGB value. Must be in the range 0-255
	 * @param green
	 *            Green component of the RGB value. Must be in the range 0-255
	 * @param blue
	 *            Blue component of the RGB value. Must be in the range 0-255
	 * @return Closest Domino color to the RGB value
	 * @throws NotesApiException
	 * @usage SetRGB sets NotesColor, in addition to the return value, to the
	 *        closest Domino color.
	 * 
	 *        SetRGB sets the RGB properties to the specifications of this
	 *        method.
	 * 
	 *        SetRGB sets the HSL properties to values that match the Domino
	 *        color.
	 * @example This form action uses the "Red," "Green," and "Blue" fields on a
	 *          form as parameters to setRGB, and writes the resulting property
	 *          values to the "NotesColor," "Red," "Green," "Blue," "Hue,"
	 *          "Saturation," and "Luminance" fields
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			ColorObject color = session.createColorObject();
	 * 			DocumentCollection dc = agentContext.getUnprocessedDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				int r = doc.getItemValueInteger(&quot;Red&quot;);
	 * 				int g = doc.getItemValueInteger(&quot;Green&quot;);
	 * 				int b = doc.getItemValueInteger(&quot;Blue&quot;);
	 * 				color.setRGB(r, g, b);
	 * 				Integer i = new Integer(color.getNotesColor());
	 * 				doc.replaceItemValue(&quot;NotesColor&quot;, i);
	 * 				i = new Integer(color.getRed());
	 * 				doc.replaceItemValue(&quot;Red&quot;, i);
	 * 				i = new Integer(color.getGreen());
	 * 				doc.replaceItemValue(&quot;Green&quot;, i);
	 * 				i = new Integer(color.getBlue());
	 * 				doc.replaceItemValue(&quot;Blue&quot;, i);
	 * 				i = new Integer(color.getHue());
	 * 				doc.replaceItemValue(&quot;Hue&quot;, i);
	 * 				i = new Integer(color.getSaturation());
	 * 				doc.replaceItemValue(&quot;Saturation&quot;, i);
	 * 				i = new Integer(color.getLuminance());
	 * 				doc.replaceItemValue(&quot;Luminance&quot;, i);
	 * 				doc.save(true, true);
	 * 				doc = dc.getNextDocument(doc);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int setRGB(int red, int green, int blue)
			throws NotesApiException;

	/**
	 * Sets an HSL value to the closest Domino color and RGB value.
	 * 
	 * @param hue
	 *            Hue component of the HSL value. Must be in the range 0-240.
	 * @param saturation
	 *            Saturation component of the HSL value. Must be in the range
	 *            0-240
	 * @param luminance
	 *            Luminance component of the HSL value. Must be in the range
	 *            0-240
	 * @return Closest Domino color to the HSL value
	 * @throws NotesApiException
	 * @usage SetHSL sets NotesColor, in addition to the return value, to the
	 *        closest Domino color.
	 * 
	 *        SetHSL sets the HSL properties to the specifications of this
	 *        method.
	 * 
	 *        SetHSL sets the RGB properties to values that match the Domino
	 *        color.
	 * @example This form action uses the "Hue," "Saturation," and "Luminance"
	 *          items in a document as parameters to setHSL, and writes the
	 *          resulting property values to the "NotesColor," "Red," "Green,"
	 *          "Blue," "Hue," "Saturation," and "Luminance" items
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			ColorObject color = session.createColorObject();
	 * 			DocumentCollection dc = agentContext.getUnprocessedDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				int h = doc.getItemValueInteger(&quot;Hue&quot;);
	 * 				int s = doc.getItemValueInteger(&quot;Saturation&quot;);
	 * 				int l = doc.getItemValueInteger(&quot;Luminance&quot;);
	 * 				color.setHSL(h, s, l);
	 * 				Integer i = new Integer(color.getNotesColor());
	 * 				doc.replaceItemValue(&quot;NotesColor&quot;, i);
	 * 				i = new Integer(color.getRed());
	 * 				doc.replaceItemValue(&quot;Red&quot;, i);
	 * 				i = new Integer(color.getGreen());
	 * 				doc.replaceItemValue(&quot;Green&quot;, i);
	 * 				i = new Integer(color.getBlue());
	 * 				doc.replaceItemValue(&quot;Blue&quot;, i);
	 * 				i = new Integer(color.getHue());
	 * 				doc.replaceItemValue(&quot;Hue&quot;, i);
	 * 				i = new Integer(color.getSaturation());
	 * 				doc.replaceItemValue(&quot;Saturation&quot;, i);
	 * 				i = new Integer(color.getLuminance());
	 * 				doc.replaceItemValue(&quot;Luminance&quot;, i);
	 * 				doc.save(true, true);
	 * 				doc = dc.getNextDocument(doc);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int setHSL(int hue, int saturation, int luminance)
			throws NotesApiException;

	/**
	 * The red component of the color's RGB value.
	 * 
	 * @return The red component of the color's RGB value.
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-255.
	 * @example This agent displays the red RGB value of the background color of
	 *          a view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Red value of Main View background = &quot;
	 * 					+ color.getRed());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getRed() throws NotesApiException;

	/**
	 * The green component of the color's RGB value.
	 * 
	 * @return The green component of the color's RGB value.
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-255.
	 * @example This agent displays the green RGB value of the background color
	 *          of a view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Green value of Main View background = &quot;
	 * 					+ color.getGreen());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getGreen() throws NotesApiException;

	/**
	 * The blue component of a color's RGB value
	 * 
	 * @return The blue component of a color's RGB value
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-255.
	 * @example This agent displays the blue RGB value of the background color
	 *          of a view.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Blue value of Main View background = &quot;
	 * 					+ color.getBlue());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getBlue() throws NotesApiException;

	/**
	 * The hue component of the color's HSL value.
	 * 
	 * @return The hue component of the color's HSL value.
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-240.
	 * @example This agent displays the hue RGB value of the background color of
	 *          a view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Hue value of Main View background = &quot;
	 * 					+ color.getHue());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getHue() throws NotesApiException;

	/**
	 * The saturation component of the color's HSL value
	 * 
	 * @return The saturation component of the color's HSL value
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-240.
	 * @example This agent displays the saturation RGB value of the background
	 *          color of a view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Saturation value of Main View background = &quot;
	 * 					+ color.getSaturation());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getSaturation() throws NotesApiException;

	/**
	 * The luminance component of the color's HSL value.
	 * 
	 * @return The luminance component of the color's HSL value.
	 * @throws NotesApiException
	 * @usage If you write to NotesColor, this property changes to reflect the
	 *        Domino color.
	 * 
	 *        This property is in the range 0-240.
	 * @example This agent displays the luminance RGB value of the background
	 *          color of a view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Main View&quot;);
	 * 			ColorObject color = session.createColorObject();
	 * 			color.setNotesColor(view.getBackgroundColor());
	 * 			System.out.println(&quot;Luminance value of Main View background = &quot;
	 * 					+ color.getLuminance());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getLuminance() throws NotesApiException;

	/**
	 * The color's Domino value.
	 * 
	 * @return The color's Domino value.
	 * @throws NotesApiException
	 * @usage The value of this property must be in the range 0-240.
	 * 
	 *        The methods setHSL and setRGB set this property.
	 * 
	 *        Setting this property sets the RGB and HSL properties.
	 * @example This agent writes to the NotesColor property based on user input
	 *          from the agent comment, then displays all the color properties
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			String ncStr = agentContext.getCurrentAgent().getComment();
	 * 			Integer nc = new Integer(ncStr);
	 * 			if (nc.intValue() &gt;= 0 &amp; nc.intValue() &lt;= 240) {
	 * 				ColorObject color = session.createColorObject();
	 * 				color.setNotesColor(nc.intValue());
	 * 				System.out.println(&quot;Domino color = &quot; + color.getNotesColor());
	 * 				System.out.println(&quot;RGB = &quot; + color.getRed() + &quot;, &quot;
	 * 						+ color.getGreen() + &quot;, &quot; + color.getBlue());
	 * 				System.out.println(&quot;HSL = &quot; + color.getHue() + &quot;, &quot;
	 * 						+ color.getSaturation() + &quot;, &quot; + color.getLuminance());
	 * 			} else
	 * 				System.out.println(&quot;Color number must be in range 0-240&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getNotesColor() throws NotesApiException;

	/**
	 * The color's Domino value
	 * 
	 * @param notesColor
	 *            The color's Domino value
	 * @throws NotesApiException
	 * @usage The value of this property must be in the range 0-240.
	 * 
	 *        The methods setHSL and setRGB set this property.
	 * 
	 *        Setting this property sets the RGB and HSL properties.
	 * @example This agent writes to the NotesColor property based on user input
	 *          from the agent comment, then displays all the color properties
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			String ncStr = agentContext.getCurrentAgent().getComment();
	 * 			Integer nc = new Integer(ncStr);
	 * 			if (nc.intValue() &gt;= 0 &amp; nc.intValue() &lt;= 240) {
	 * 				ColorObject color = session.createColorObject();
	 * 				color.setNotesColor(nc.intValue());
	 * 				System.out.println(&quot;Domino color = &quot; + color.getNotesColor());
	 * 				System.out.println(&quot;RGB = &quot; + color.getRed() + &quot;, &quot;
	 * 						+ color.getGreen() + &quot;, &quot; + color.getBlue());
	 * 				System.out.println(&quot;HSL = &quot; + color.getHue() + &quot;, &quot;
	 * 						+ color.getSaturation() + &quot;, &quot; + color.getLuminance());
	 * 			} else
	 * 				System.out.println(&quot;Color number must be in range 0-240&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setNotesColor(int notesColor) throws NotesApiException;
}
