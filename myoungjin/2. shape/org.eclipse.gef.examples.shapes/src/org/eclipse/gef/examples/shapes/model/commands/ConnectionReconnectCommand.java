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
 * 다른 시작점 또는 끝쩜에 다시 연결을 하기 위한  reconnect command, redo와 undo를 할 수 있다
 * 이 명령은 GraphicalNodeEditPolicy를 가지고 사용되었다.
 * 이 명령을 적절하기 사용하기 위해서 다음 과정을 따르세요
 * 1. GraphicalNodeEditPolicy의 subclass를 만들어라
 * 2. getReconnectSourceCommand(...)를 오버라이딩 하라 .. 
 *    방법 : 여기에 RecconectRequest로 부터 연결 모델 요소를 얻고,
 *         ConnectionReconnectCommand를 만들고,
 *          setNewSource(Shape)로 부터 새로운 connection을 정하라->방법 : command 객체를 리턴하라
 * 3.getReconnectTargetCommand(...)를 오버라이드 하라
 *   방법 : 여기에 ReconnectRequest로부터 connection 모델 요소를 얻고, ConnectionReconnectCommand를 만들어라
 *    그후 setNewTarget(Shape)라고 불리는 새로운 connection을 정하라(리턴 : command instance)
 *    
 * @see org.eclipse.gef.examples.shapes.parts.ShapeEditPart#createEditPolicies()
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @see #setNewSource(Shape)
 * @see #setNewTarget(Shape)
 * @author Elias Volanakis
 */
public class ConnectionReconnectCommand extends Command {
	private Connection connection;//reconnect 객체 연결
	private Shape newSource;//새로운 source endpoint
	private Shape newTarget;//새로운 target endpoint
	private final Shape oldSource;//old source endpoint	
	private final Shape oldTarget;//old source endpoint
	/**
	 * 다른 소스 또는 endPoint사이에 Connection인스턴스를 다시 연결할수 있는 command를 인스턴스화 하라
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
	public boolean canExecute() {//이해가 잘 안됨...
		if (newSource != null) {//새로운 source endpoint가 널이 아닌경우
			return checkSourceReconnection();
		} else if (newTarget != null) {//새로운 target endpoint가 널이 아닌경우
			return checkTargetReconnection();
		}
		return false;
	}

	/**
	 * Return true, if reconnecting the connection-instance to newSource is
	 * allowed.
	 */
	private boolean checkSourceReconnection() {
		//소스재연결 체크
		//연결 endpoint는 반드시 다른 도형이어야 한다.
		if (newSource.equals(oldTarget)) {//새로운 소스 endpoint와 oldTarget이 같을경우 false
			return false;
		}
		//만약에 연결이 이미 존재하는 경우 return false
		for (Iterator iter = newSource.getSourceConnections().iterator(); iter.hasNext();) {
			Connection conn = (Connection) iter.next();
			//a newSource -> oldTarget connection이 이미 존재 한다면 return false
			//the connection-field사이에서 그것들은 다른 객체이다.
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
		if (newSource != null) {//새소스가 널이 아니면
			connection.reconnect(newSource, oldTarget);//다시연결
		} else if (newTarget != null) {
			connection.reconnect(oldSource, newTarget);
		} else {
			throw new IllegalStateException("Should not happen");
		}
	}

	/**
	 * 새로운 연결을 위한 새로운 소스 endpoint를 정하라. 
	 * execute가 호출되면 그 source의 연결의 endpoint가 shape 객체에 부착될 것이다.
	 * 
	 * Note: 이러한 방법을 재연결 target endpoint의 재연결 비활성화 라고 부른다.
	 * 이 명령의 단일 객체는 오직 source 또는 target endpoint의 재연결만 가능하다.
	 * 
	 * @param connectionSource : a non-null Shape instance, to be used as a new source endpoint
	 * @throws IllegalArgumentException : if connectionSource is null
	 */
	public void setNewSource(Shape connectionSource) {//새로운 소스에 연결 소스를 넣어주고 타겟에는 널이 된다.
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
	public void setNewTarget(Shape connectionTarget) {//새로운 타겟을 설정.
		if (connectionTarget == null) {
			throw new IllegalArgumentException();
		}
		setLabel("move connection endpoint");
		newSource = null;
		newTarget = connectionTarget;
	}

	public void undo() {//원래소스와 타겟 endpoint에 재연결
		connection.reconnect(oldSource, oldTarget);
	}

}
