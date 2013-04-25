package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Main Class for all Notes-Classes
 * 
 * @author Sven Dreher
 * 
 */
public interface NotesBase {
	/**
	 * The recycle method unconditionally destroys an object and returns its
	 * memory to the system.
	 * 
	 * All lotus.domino classes contain the following methods:
	 * 
	 * public void recycle()public void recycle(java.util.Vector objects)In the
	 * latter method, the vector contains the Domino Objects to be recycled.
	 * This method effectively batches recycle operations and is especially
	 * efficient for remote (IIOP) calls.
	 * 
	 * Java has no knowlege of the heavyweight back-end Domino Objects, only the
	 * lightweight Java objects representing them. Garbage collection has no
	 * effect on Domino Objects unless you first explicitly recycle them.
	 * 
	 * If you appear to have memory problems, try recycle but adhere to the
	 * following guidelines:
	 * 
	 * Recycle an object only if it is no longer needed. Recycle an object in
	 * the same thread in which it is created. Recycling a parent recycles all
	 * the children. In Session, call recycle() only after all other threads
	 * exit. Where NotesThread.sinitThread() and NotesThread.stermThread() are
	 * used, call recycle() before stermThread. Loops enumerating documents or
	 * items are good candidates for recycling.
	 * 
	 * In a remote (IIOP) environment, recycle releases resources on the server.
	 * Although a client-side cache exists, the Java object can no longer
	 * communicate with its remote counterpart.
	 * 
	 * In a remote (IIOP) environment, recycle can be called from any thread on
	 * any object.
	 * 
	 * If you create more than one object to represent the same Domino element,
	 * recycling one recycles all. For example:
	 * 
	 * <pre>
	 * View v1 = db.getView(&quot;All&quot;);
	 * View v2 = db.getView(&quot;All&quot;);
	 * v1.recycle(); // also recycles v2
	 * </pre>
	 * 
	 * Results are undefined if you attempt to use a recycled object. No error
	 * is guaranteed.
	 * 
	 * 
	 * @throws NotesApiException
	 */
	public abstract void recycle() throws NotesApiException;

	/**
	 * The recycle method unconditionally destroys an object and returns its
	 * memory to the system.
	 * 
	 * All lotus.domino classes contain the following methods:
	 * 
	 * <pre>
	 * public void recycle()
	 * public void recycle(java.util.Vector objects)
	 * </pre>
	 * 
	 * In the latter method, the vector contains the Domino Objects to be
	 * recycled. This method effectively batches recycle operations and is
	 * especially efficient for remote (IIOP) calls.
	 * 
	 * Java has no knowlege of the heavyweight back-end Domino Objects, only the
	 * lightweight Java objects representing them. Garbage collection has no
	 * effect on Domino Objects unless you first explicitly recycle them.
	 * 
	 * If you appear to have memory problems, try recycle but adhere to the
	 * following guidelines:
	 * 
	 * Recycle an object only if it is no longer needed. Recycle an object in
	 * the same thread in which it is created. Recycling a parent recycles all
	 * the children. In Session, call recycle() only after all other threads
	 * exit. Where NotesThread.sinitThread() and NotesThread.stermThread() are
	 * used, call recycle() before stermThread. Loops enumerating documents or
	 * items are good candidates for recycling.
	 * 
	 * In a remote (IIOP) environment, recycle releases resources on the server.
	 * Although a client-side cache exists, the Java object can no longer
	 * communicate with its remote counterpart.
	 * 
	 * In a remote (IIOP) environment, recycle can be called from any thread on
	 * any object.
	 * 
	 * If you create more than one object to represent the same Domino element,
	 * recycling one recycles all. For example:
	 * 
	 * <pre>
	 * View v1 = db.getView(&quot;All&quot;);
	 * View v2 = db.getView(&quot;All&quot;);
	 * v1.recycle(); // also recycles v2
	 * </pre>
	 * 
	 * Results are undefined if you attempt to use a recycled object. No error
	 * is guaranteed.
	 * 
	 * 
	 * @param objects
	 *            The Domino Objects to be recycled
	 * @throws NotesApiException
	 */
	public abstract void recycle(Vector<NotesBase> objects)
			throws NotesApiException;
}
