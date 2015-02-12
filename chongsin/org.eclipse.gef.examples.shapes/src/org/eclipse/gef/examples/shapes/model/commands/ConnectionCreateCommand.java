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
    �� ���� ���̿� ������ ����� �ش�. �� �ڸ��� ��� ���θ� �Ҽ� �մ�.
   �� �ڸ��� a GraphicalNodeEditPolicy�� ������ �������.
  �� �ڸ�带 ����ϱ� ���ؼ� ������ ������ �����ÿ�

   1. GraphicalNodeEditPolicy�� ����Ŭ������ �����϶�
   2. getConnectionCreateCommand(...)�� �������̵� �϶�
   3. the CreateConnectionRequest�ȿ� �� Ŭ������ ��ü�� �־��
   4. getConnectionCompleteCommand(...)�� �������̵��϶�. ��� : ConnectionRequest�� setTarget�̶�� �Ҹ��µ����� ���� 
      ������ endpoint�� target�� �����ϱ� ���ؼ�.
   5. 

 * @see org.eclipse.gef.examples.shapes.parts.ShapeEditPart#createEditPolicies()
 *      for an example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class ConnectionCreateCommand extends Command {
	
	private Connection connection;//���ᰴü
	private final int lineStyle;//���ε����� ��ü
	private final Shape source;//������ ���� endPoint ���ۺ� 
	private Shape target;//������ ���� endpoint Ÿ��

	/**
	 * �� �������̿� ������ �����Ҽ� �մ� ����� �ν��Ͻ�ȭ �϶�
	 * @param source : the source endpoint (a non-null Shape instance)
	 * @param lineStyle : the desired line style. See Connection#setLineStyle(int) for details
	 * @throws IllegalArgumentException -> if source is null
	 * @see Connection#setLineStyle(int)
	 */
	
	public ConnectionCreateCommand(Shape source, int lineStyle) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");//setText(text)�� �ű�� �յ�.
		this.source = source;
		this.lineStyle = lineStyle;
	}

	/* 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {//�����Ҽ� �հ� ��
		//connection�� �̿��Ͽ� ��ü�� ���������� ��� ���µ� ���࿡ Ÿ�ٰ� ���� ���.. false�̰� �� ���������� Ÿ���� �����Ƿ� true�� �ȴ�
		// disallow source -> source connections
		if (source.equals(target)) {
			return false;
		}
		//source -> target connection�� �̹� �����ϴ°�� false�� ������ �ش�.
		for (Iterator iter = source.getSourceConnections().iterator(); iter.hasNext();) {//hasNext():���� �����Ͱ� ������ return true;
			Connection conn = (Connection) iter.next();//�̰� ����?
			
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
	public void execute() {//����
		// create a new connection between source and target
		//�ҽ��� Ÿ�� ���̿� connection�� ����� �ش�.
		connection = new Connection(source, target);
		// use the supplied line style
		// ������ lineStyle�� �����Ѵ�.
		connection.setLineStyle(lineStyle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {//�ٽ� ����
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
	public void setTarget(Shape target) {//Ÿ���� �����Ѵ�.
		if (target == null) {//Ÿ���� ���ϰ��
			throw new IllegalArgumentException(); // throw : ������ Exception�� �߻���Ų��. InllegalArgumentException�� ���� ��� ������ ��.
		}
		this.target = target;//�ҷ��� Ÿ���� ����
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {//�ǵ�����
		connection.disconnect();//Ÿ���� ������ ���� �ش�.
	}
}
