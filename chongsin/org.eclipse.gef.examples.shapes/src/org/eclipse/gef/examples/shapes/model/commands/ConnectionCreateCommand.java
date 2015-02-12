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
    두 셰잎 사이에 연결을 만들어 준다. 이 코멘드는 언두 리두를 할수 잇다.
   이 코멘드는 a GraphicalNodeEditPolicy를 가지고 만들었다.
  이 코멘드를 사용하기 위해서 다음의 스텝을 따르시오

   1. GraphicalNodeEditPolicy의 서브클래스를 생성하라
   2. getConnectionCreateCommand(...)를 오버라이딩 하라
   3. the CreateConnectionRequest안에 이 클래스의 객체를 넣어라
   4. getConnectionCompleteCommand(...)를 오버라이드하라. 방법 : ConnectionRequest에 setTarget이라고 불리는데에서 얻어라 
      연결의 endpoint의 target을 설정하기 위해서.
   5. 

 * @see org.eclipse.gef.examples.shapes.parts.ShapeEditPart#createEditPolicies()
 *      for an example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class ConnectionCreateCommand extends Command {
	
	private Connection connection;//연결객체
	private final int lineStyle;//라인디자인 객체
	private final Shape source;//연결을 위한 endPoint 시작부 
	private Shape target;//연결을 위한 endpoint 타겟

	/**
	 * 두 도형사이에 연결을 생성할수 잇는 명령을 인스턴스화 하라
	 * @param source : the source endpoint (a non-null Shape instance)
	 * @param lineStyle : the desired line style. See Connection#setLineStyle(int) for details
	 * @throws IllegalArgumentException -> if source is null
	 * @see Connection#setLineStyle(int)
	 */
	
	public ConnectionCreateCommand(Shape source, int lineStyle) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");//setText(text)에 옮길수 잇따.
		this.source = source;
		this.lineStyle = lineStyle;
	}

	/* 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {//실행할수 잇게 함
		//connection을 이용하여 객체와 있을때까지 계속 도는데 만약에 타겟과 같을 경우.. false이고 맨 마지막에서 타겟이 없으므로 true가 된다
		// disallow source -> source connections
		if (source.equals(target)) {
			return false;
		}
		//source -> target connection이 이미 존재하는경우 false를 리턴해 준다.
		for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();) {//hasNext():다음 데이터가 있으면 return true;
			Connection conn = (Connection) iter.next();//이게 뭐지?
			
			if (conn.getTarget().equals(target)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {//실행
		// create a new connection between source and target
		//소스와 타겟 사이에 connection을 만들어 준다.
		connection = new Connection(source, target);
		// use the supplied line style
		// 설정한 lineStyle을 지정한다.
		connection.setLineStyle(lineStyle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {//다시 연결
		connection.reconnect();
	}

	/**
	 * Set the target endpoint for the connection.
	 * 
	 * @param target
	 *            that target endpoint (a non-null Shape instance)
	 * @throws IllegalArgumentException
	 *             if target is null
	 */
	public void setTarget(Shape target) {//타겟을 지정한다.
		if (target == null) {//타겟이 널일경우
			throw new IllegalArgumentException(); // throw : 강제로 Exception을 발생시킨다. InllegalArgumentException은 널인 경우 나오게 함.
		}
		this.target = target;//불러운 타겟을 저장
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {//되돌리기
		connection.disconnect();//타겟은 연결을 끊어 준다.
	}
}
