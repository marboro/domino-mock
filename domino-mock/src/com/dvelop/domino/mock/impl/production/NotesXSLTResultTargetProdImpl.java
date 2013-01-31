package com.dvelop.domino.mock.impl.production;

import java.io.OutputStream;
import java.io.Writer;

import lotus.domino.XSLTResultTarget;

import org.w3c.dom.Node;

import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesXSLTResultTargetProdImpl implements NotesXSLTResultTarget {

	private XSLTResultTarget xslResultTarget;

	public NotesXSLTResultTargetProdImpl(XSLTResultTarget xslResultTarget) {
		this.xslResultTarget = xslResultTarget;
	}

	public XSLTResultTarget get() {
		return xslResultTarget;
	}

	@Override
	public void NotesXSLTResultTarget() {
		xslResultTarget = new XSLTResultTarget();
	}

	@Override
	public void NotesXSLTResultTarget(String arg0) {
		xslResultTarget = new XSLTResultTarget(arg0);
	}

	@Override
	public void NotesXSLTResultTarget(OutputStream arg0) {
		xslResultTarget = new XSLTResultTarget(arg0);
	}

	@Override
	public void NotesXSLTResultTarget(Writer arg0) {
		xslResultTarget = new XSLTResultTarget(arg0);
	}

	@Override
	public void NotesXSLTResultTarget(Node arg0) {
		xslResultTarget = new XSLTResultTarget(arg0);
	}

	@Override
	public void setFileName(String arg0) {
		xslResultTarget.setFileName(arg0);
	}

	@Override
	public String getFileName() {
		return xslResultTarget.getFileName();
	}

	@Override
	public void setByteStream(OutputStream arg0) {
		xslResultTarget.setByteStream(arg0);
	}

	@Override
	public OutputStream getByteStream() {
		return xslResultTarget.getByteStream();
	}

	@Override
	public String getEncoding() {
		return xslResultTarget.getEncoding();
	}

	@Override
	public void setCharacterStream(Writer arg0) {
		xslResultTarget.setCharacterStream(arg0);
	}

	@Override
	public Writer getCharacterStream() {
		return xslResultTarget.getCharacterStream();
	}

	@Override
	public void setNode(Node arg0) {
		xslResultTarget.setNode(arg0);
	}

	@Override
	public Node getNode() {
		return xslResultTarget.getNode();
	}

}