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

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.examples.shapes.model.Connection;
import org.eclipse.gef.examples.shapes.model.Shape;

/**
 * �ٸ� ������ �Ǵ� ������ �ٽ� ������ �ϱ� ����  reconnect command, redo�� undo�� �� �� �ִ�
 * �� ����� GraphicalNodeEditPolicy�� ������ ���Ǿ���.
 * �� ����� �����ϱ� ����ϱ� ���ؼ� ���� ������ ��������
 * 1. GraphicalNodeEditPolicy�� subclass�� ������
 * 2. getReconnectSourceCommand(...)�� �������̵� �϶� .. 
 *    ��� : ���⿡ RecconectRequest�� ���� ���� �� ��Ҹ� ���,
 *         ConnectionReconnectCommand�� �����,
 *          setNewSource(Shape)�� ���� ���ο� connection�� ���϶�->��� : command ��ü�� �����϶�
 * 3.getReconnectTargetCommand(...)�� �������̵� �϶�
 *   ��� : ���⿡ ReconnectRequest�κ��� connection �� ��Ҹ� ���, ConnectionReconnectCommand�� ������
 *    ���� setNewTarget(Shape)��� �Ҹ��� ���ο� connection�� ���϶�(���� : command instance)
 *    
 * @see org.eclipse.gef.examples.shapes.parts.ShapeEditPart#createEditPolicies()
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @see #setNewSource(Shape)
 * @see #setNewTarget(Shape)
 * @author Elias Volanakis
 */
public class ConnectionReconnectCommand extends Command {
	private Connection connection;//reconnect ��ü ����
	private Shape newSource;//���ο� source endpoint
	private Shape newTarget;//���ο� target endpoint
	private final Shape oldSource;//old source endpoint	
	private final Shape oldTarget;//old source endpoint
	/**
	 * �ٸ� �ҽ� �Ǵ� endPoint���̿� Connection�ν��Ͻ��� �ٽ� �����Ҽ� �ִ� command�� �ν��Ͻ�ȭ �϶�
	 * @param conn : the connection instance to reconnect (non-null)
	 * @throws IllegalArgumentException : if conn is null
	 */
	public ConnectionReconnectCommand(Connection conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		this.connection = conn;
		this.oldSource = conn.getSource();
		this.oldTarget = conn.getTarget();
	}
	 // @see org.eclipse.gef.commands.Command#canExecute()
	public boolean canExecute() {//���ذ� �� �ȵ�...
		if (newSource != null) {//���ο� source endpoint�� ���� �ƴѰ��
			return checkSourceReconnection();
		} else if (newTarget != null) {//���ο� target endpoint�� ���� �ƴѰ��
			return checkTargetReconnection();
		}
		return false;
	}

	/**
	 * Return true, if reconnecting the connection-instance to newSource is
	 * allowed.
	 */
	private boolean checkSourceReconnection() {
		//�ҽ��翬�� üũ
		//���� endpoint�� �ݵ�� �ٸ� �����̾�� �Ѵ�.
		if (newSource.equals(oldTarget)) {//���ο� �ҽ� endpoint�� oldTarget�� ������� false
			return false;
		}
		//���࿡ ������ �̹� �����ϴ� ��� return false
		for (Iterator iter = newSource.getSourceConnections().iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			//a newSource -> oldTarget connection�� �̹� ���� �Ѵٸ� return false
			//the connection-field���̿��� �װ͵��� �ٸ� ��ü�̴�.
			if (conn.getTarget().equals(oldTarget) && !conn.equals(connection)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true, if reconnecting the connection-instance to newTarget is allowed.
	 */
	private boolean checkTargetReconnection() {
		// connection endpoints must be different Shapes
		if (newTarget.equals(oldSource)) {
			return false;
		}
		// return false, if the connection exists already
		for (Iterator iter = newTarget.getTargetConnections().iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			// return false if a oldSource -> newTarget connection exists already
			// and it is a differenct instance that the connection-field
			if (conn.getSource().equals(oldSource) && !conn.equals(connection)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Reconnect the connection to newSource (if setNewSource(...) was invoked
	 * before) or newTarget (if setNewTarget(...) was invoked before).
	 */
	public void execute() {
		if (newSource != null) {//���ҽ��� ���� �ƴϸ�
			connection.reconnect(newSource, oldTarget);//�ٽÿ���
		} else if (newTarget != null) {
			connection.reconnect(oldSource, newTarget);
		} else {
			throw new IllegalStateException("Should not happen");
		}
	}

	/**
	 * ���ο� ������ ���� ���ο� �ҽ� endpoint�� ���϶�. 
	 * execute�� ȣ��Ǹ� �� source�� ������ endpoint�� shape ��ü�� ������ ���̴�.
	 * 
	 * Note: �̷��� ����� �翬�� target endpoint�� �翬�� ��Ȱ��ȭ ��� �θ���.
	 * �� ����� ���� ��ü�� ���� source �Ǵ� target endpoint�� �翬�Ḹ �����ϴ�.
	 * 
	 * @param connectionSource : a non-null Shape instance, to be used as a new source endpoint
	 * @throws IllegalArgumentException : if connectionSource is null
	 */
	public void setNewSource(Shape connectionSource) {//���ο� �ҽ��� ���� �ҽ��� �־��ְ� Ÿ�ٿ��� ���� �ȴ�.
		if (connectionSource == null) {
			throw new IllegalArgumentException();
		}
		setLabel("move connection startpoint");
		newSource = connectionSource;
		newTarget = null;
	}

	/**
	 * Set a new target endpoint for this connection When execute() is invoked,
	 * the target endpoint of the connection will be attached to the supplied
	 * Shape instance.
	 * <p>
	 * Note: Calling this method, deactivates reconnection of the <i>source</i>
	 * endpoint. A single instance of this command can only reconnect either the
	 * source or the target endpoint.
	 * </p>
	 * 
	 * @param connectionTarget
	 *            a non-null Shape instance, to be used as a new target endpoint
	 * @throws IllegalArgumentException
	 *             if connectionTarget is null
	 */
	public void setNewTarget(Shape connectionTarget) {//���ο� Ÿ���� ����.
		if (connectionTarget == null) {
			throw new IllegalArgumentException();
		}
		setLabel("move connection endpoint");
		newSource = null;
		newTarget = connectionTarget;
	}

	public void undo() {//�����ҽ��� Ÿ�� endpoint�� �翬��
		connection.reconnect(oldSource, oldTarget);
	}

}
