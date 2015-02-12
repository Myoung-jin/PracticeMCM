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

	private final Shape child;//제거할 child
	private final ShapesDiagram parent;//제거할 child의 부모 shape	/** ShapeDiagram to remove from. */
	private List sourceConnections;//child의 연결로 부터 나가는 ...	/** Holds a copy of the outgoing connections of child. */
	private List targetConnections;//child의 연결로 부터 나가는 ...	/** Holds a copy of the incoming connections of child. */
	private boolean wasRemoved;//child가 그것의 부모로부터 제거 되었을 경우 t or f를 리턴

	/**
	 * child의 부모 shape를 제거할 command를 create하라
	 * @param parent : the ShapesDiagram containing the child
	 * @param child : the Shape to remove
	 * @throws IllegalArgumentException : if any parameter is null
	 */
	
	public ShapeDeleteCommand(ShapesDiagram parent, Shape child) {//제거 명령
		if (parent == null || child == null) {
			throw new IllegalArgumentException();
		}
		setLabel("shape deletion");
		this.parent = parent;//현재 부모를 넣는다.
		this.child = child;//자식넣기
	}

	/**
	 * 그것들의 현재 endpoint들을 가지고 연결리스트를 연결하라
	 * @param connections : a non-null List of connections
	 */
	private void addConnections(List connections) {//연결리스트를 받아온다.
		for (Iterator iter = connections.iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			conn.reconnect();
		}//리스트의 마지막까지 객체가 존재 할 경우 reconnect를 해준다.
	}

	// @see org.eclipse.gef.commands.Command#canUndo()
	public boolean canUndo() {
		return wasRemoved;//canUndo 호출시 지워버린다.
	}

	 // @see org.eclipse.gef.commands.Command#execute()
	public void execute() {
		
		//진행전의 수신과 송신 전의 카피본을 복사하여 저장한다. 		
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
	 * 그것의 endpoints로부터 연결리스트를 지운다.
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
		//그것의 연결을 재연결하고 자식을 추가시킨다.
		if (parent.addChild(child)) {
			addConnections(sourceConnections);
			addConnections(targetConnections);
		}
	}
}