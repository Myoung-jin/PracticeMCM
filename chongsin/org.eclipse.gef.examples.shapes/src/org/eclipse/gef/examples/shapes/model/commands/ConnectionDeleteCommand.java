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

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.examples.shapes.model.Connection;

/**
 * �� command�� �� endpoints���̿� ������ �����ϱ� �����̴�. �׸��� undo�� redo�� �� �� �ִ�.
 */
public class ConnectionDeleteCommand extends Command {
	private final Connection connection;//disconnect�� �ϱ� ���� ���� �ν��Ͻ�

	/**
	 * Create a command that will disconnect a connection from its endpoints
	 * @param conn : the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException : if conn is null
	 */
	public ConnectionDeleteCommand(Connection conn) {//��������� ���
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection deletion");
		this.connection = conn;
	}
	public void execute() {//disconnect ����
		connection.disconnect();
	}
	public void undo() {//undo����
		connection.reconnect();
	}
}
