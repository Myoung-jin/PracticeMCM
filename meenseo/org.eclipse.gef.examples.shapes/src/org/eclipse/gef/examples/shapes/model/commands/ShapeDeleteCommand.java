/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
?* All rights reserved. This program and the accompanying materials
?* are made available under the terms of the Eclipse Public License v1.0
?* which accompanies this distribution, and is available at
?* http://www.eclipse.org/legal/epl-v10.html
?*
?* Contributors:
?*????Elias Volanakis - initial API and implementation
?*******************************************************************************/
package org.eclipse.gef.examples.shapes.model.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.examples.shapes.model.Connection;
import org.eclipse.gef.examples.shapes.model.Shape;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;

 // A command to remove a shape from its parent. The command can be undone or redone. 
 
public class ShapeDeleteCommand extends Command {

	private final Shape child;//������ child
	private final ShapesDiagram parent;//������ child�� �θ� shape	/** ShapeDiagram to remove from. */
	private List sourceConnections;//child�� ����� ���� ������ ...	/** Holds a copy of the outgoing connections of child. */
	private List targetConnections;//child�� ����� ���� ������ ...	/** Holds a copy of the incoming connections of child. */
	private boolean wasRemoved;//child�� �װ��� �θ�κ��� ���� �Ǿ��� ��� t or f�� ����

	/**
	 * child�� �θ� shape�� ������ command�� create�϶�
	 * @param parent : the ShapesDiagram containing the child
	 * @param child : the Shape to remove
	 * @throws IllegalArgumentException : if any parameter is null
	 */
	
	public ShapeDeleteCommand(ShapesDiagram parent, Shape child) {//���� ���
		if (parent == null || child == null) {
			throw new IllegalArgumentException();
		}
		setLabel("shape deletion");
		this.parent = parent;//���� �θ� �ִ´�.
		this.child = child;//�ڽĳֱ�
	}

	/**
	 * �װ͵��� ���� endpoint���� ������ ���Ḯ��Ʈ�� �����϶�
	 * @param connections : a non-null List of connections
	 */
	private void addConnections(List connections) {//���Ḯ��Ʈ�� �޾ƿ´�.
		for (Iterator iter = connections.iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			conn.reconnect();
		}//����Ʈ�� ���������� ��ü�� ���� �� ��� reconnect�� ���ش�.
	}

	// @see org.eclipse.gef.commands.Command#canUndo()
	public boolean canUndo() {
		return wasRemoved;//canUndo ȣ��� ����������.
	}

	 // @see org.eclipse.gef.commands.Command#execute()
	public void execute() {
		
		//�������� ���Ű� �۽� ���� ī�Ǻ��� �����Ͽ� �����Ѵ�. 		
		sourceConnections = child.getSourceConnections();
		targetConnections = child.getTargetConnections();
		
		redo();
	}


	 // @see org.eclipse.gef.commands.Command#redo()
	public void redo() {
		// remove the child and disconnect its connections
		wasRemoved = parent.removeChild(child);
		if (wasRemoved) {
			removeConnections(sourceConnections);
			removeConnections(targetConnections);
		}
	}

	/**
	 * �װ��� endpoints�κ��� ���Ḯ��Ʈ�� �����.
	 * @param connections : a non-null List of connections
	 */
	private void removeConnections(List connections) {
		for (Iterator iter = connections.iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			conn.disconnect();
		}
	}

	 // @see org.eclipse.gef.commands.Command#undo()
	public void undo() {
		//�װ��� ������ �翬���ϰ� �ڽ��� �߰���Ų��.
		if (parent.addChild(child)) {
			addConnections(sourceConnections);
			addConnections(targetConnections);
		}
	}
}