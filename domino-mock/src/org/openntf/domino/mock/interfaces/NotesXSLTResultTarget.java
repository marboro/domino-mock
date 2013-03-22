package org.openntf.domino.mock.interfaces;

import java.io.OutputStream;
import java.io.Writer;

import org.w3c.dom.Node;

public interface NotesXSLTResultTarget {
	// javax.xml.transform.Result result;
	// javax.xml.transform.stream.StreamResult stream;
	// javax.xml.transform.dom.DOMResult dom;

	// private void setStream();
	// 0 aload_0 [this]
	// 1 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 4 ifnonnull 18
	// 7 aload_0 [this]
	// 8 new javax.xml.transform.stream.StreamResult [2]
	// 11 dup
	// 12 invokespecial javax.xml.transform.stream.StreamResult() [3]
	// 15 putfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 18 aload_0 [this]
	// 19 aload_0 [this]
	// 20 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 23 putfield lotus.domino.XSLTResultTarget.result :
	// javax.xml.transform.Result [4]
	// 26 return

	// private boolean isStream();
	// 0 aload_0 [this]
	// 1 getfield lotus.domino.XSLTResultTarget.result :
	// javax.xml.transform.Result [4]
	// 4 instanceof javax.xml.transform.stream.StreamResult [2]
	// 7 ifeq 12
	// 10 iconst_1
	// 11 ireturn
	// 12 iconst_0
	// 13 ireturn

	// private void setDOM();
	// 0 aload_0 [this]
	// 1 getfield lotus.domino.XSLTResultTarget.dom :
	// javax.xml.transform.dom.DOMResult [5]
	// 4 ifnonnull 18
	// 7 aload_0 [this]
	// 8 new javax.xml.transform.dom.DOMResult [6]
	// 11 dup
	// 12 invokespecial javax.xml.transform.dom.DOMResult() [7]
	// 15 putfield lotus.domino.XSLTResultTarget.dom :
	// javax.xml.transform.dom.DOMResult [5]
	// 18 aload_0 [this]
	// 19 aload_0 [this]
	// 20 getfield lotus.domino.XSLTResultTarget.dom :
	// javax.xml.transform.dom.DOMResult [5]
	// 23 putfield lotus.domino.XSLTResultTarget.result :
	// javax.xml.transform.Result [4]
	// 26 return

	// private boolean isDOM();
	// 0 aload_0 [this]
	// 1 getfield lotus.domino.XSLTResultTarget.result :
	// javax.xml.transform.Result [4]
	// 4 instanceof javax.xml.transform.dom.DOMResult [6]
	// 7 ifeq 12
	// 10 iconst_1
	// 11 ireturn
	// 12 iconst_0
	// 13 ireturn

	public void NotesXSLTResultTarget();

	// 0 aload_0 [this]
	// 1 invokespecial java.lang.Object() [8]
	// 4 return

	public void NotesXSLTResultTarget(String str);

	// 0 aload_0 [this]
	// 1 invokespecial java.lang.Object() [8]
	// 4 aload_0 [this]
	// 5 aload_1 [arg0]
	// 6 invokevirtual
	// lotus.domino.XSLTResultTarget.setFileName(java.lang.String) : void [9]
	// 9 return

	public void NotesXSLTResultTarget(OutputStream bytestream);

	// 0 aload_0 [this]
	// 1 invokespecial java.lang.Object() [8]
	// 4 aload_0 [this]
	// 5 aload_1 [arg0]
	// 6 invokevirtual
	// lotus.domino.XSLTResultTarget.setByteStream(java.io.OutputStream) : void
	// [10]
	// 9 return

	public void NotesXSLTResultTarget(Writer charstream);

	// 0 aload_0 [this]
	// 1 invokespecial java.lang.Object() [8]
	// 4 aload_0 [this]
	// 5 aload_1 [arg0]
	// 6 invokevirtual
	// lotus.domino.XSLTResultTarget.setCharacterStream(java.io.Writer) : void
	// [11]
	// 9 return

	public void NotesXSLTResultTarget(Node node);

	// 0 aload_0 [this]
	// 1 invokespecial java.lang.Object() [8]
	// 4 aload_0 [this]
	// 5 aload_1 [arg0]
	// 6 invokevirtual lotus.domino.XSLTResultTarget.setNode(org.w3c.dom.Node) :
	// void [12]
	// 9 return

	public void setFileName(String filename);

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.setStream() : void [13]
	// 4 aload_0 [this]
	// 5 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 8 new java.io.File [14]
	// 11 dup
	// 12 aload_1 [arg0]
	// 13 invokespecial java.io.File(java.lang.String) [15]
	// 16 invokevirtual
	// javax.xml.transform.stream.StreamResult.setSystemId(java.io.File) : void
	// [16]
	// 19 return

	public String getFileName();

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.isStream() : boolean [17]
	// 4 ifeq 15
	// 7 aload_0 [this]
	// 8 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 11 invokevirtual javax.xml.transform.stream.StreamResult.getSystemId() :
	// java.lang.String [18]
	// 14 areturn
	// 15 aconst_null
	// 16 areturn

	public void setByteStream(OutputStream bytestream);

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.setStream() : void [13]
	// 4 aload_0 [this]
	// 5 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 8 aload_1 [arg0]
	// 9 invokevirtual
	// javax.xml.transform.stream.StreamResult.setOutputStream(java.io.OutputStream)
	// : void [19]
	// 12 return

	public OutputStream getByteStream();

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.isStream() : boolean [17]
	// 4 ifeq 15
	// 7 aload_0 [this]
	// 8 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 11 invokevirtual
	// javax.xml.transform.stream.StreamResult.getOutputStream() :
	// java.io.OutputStream [20]
	// 14 areturn
	// 15 aconst_null
	// 16 areturn

	public String getEncoding();

	// 0 aconst_null
	// 1 areturn

	public void setCharacterStream(Writer charstream);

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.setStream() : void [13]
	// 4 aload_0 [this]
	// 5 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 8 aload_1 [arg0]
	// 9 invokevirtual
	// javax.xml.transform.stream.StreamResult.setWriter(java.io.Writer) : void
	// [21]
	// 12 return

	public Writer getCharacterStream();

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.isStream() : boolean [17]
	// 4 ifeq 15
	// 7 aload_0 [this]
	// 8 getfield lotus.domino.XSLTResultTarget.stream :
	// javax.xml.transform.stream.StreamResult [1]
	// 11 invokevirtual javax.xml.transform.stream.StreamResult.getWriter() :
	// java.io.Writer [22]
	// 14 areturn
	// 15 aconst_null
	// 16 areturn

	public void setNode(Node node);

	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.setDOM() : void [23]
	// 4 aload_0 [this]
	// 5 getfield lotus.domino.XSLTResultTarget.dom :
	// javax.xml.transform.dom.DOMResult [5]
	// 8 aload_1 [arg0]
	// 9 invokevirtual
	// javax.xml.transform.dom.DOMResult.setNode(org.w3c.dom.Node) : void [24]
	// 12 return

	public Node getNode();
	// 0 aload_0 [this]
	// 1 invokespecial lotus.domino.XSLTResultTarget.isDOM() : boolean [25]
	// 4 ifeq 15
	// 7 aload_0 [this]
	// 8 getfield lotus.domino.XSLTResultTarget.dom :
	// javax.xml.transform.dom.DOMResult [5]
	// 11 invokevirtual javax.xml.transform.dom.DOMResult.getNode() :
	// org.w3c.dom.Node [26]
	// 14 areturn
	// 15 aconst_null
	// 16 areturn

}
