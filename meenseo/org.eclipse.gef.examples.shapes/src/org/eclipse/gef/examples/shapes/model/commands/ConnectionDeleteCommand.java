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
 * 이 command는 두 endpoints사이에 연결을 제거하기 위함이다. 그리고 undo와 redo를 할 수 있다.
 */
public class ConnectionDeleteCommand extends Command {
	private final Connection connection;//disconnect를 하기 위한 연결 인스턴스

	/**
	 * Create a command that will disconnect a connection from its endpoints
	 * @param conn : the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException : if conn is null
	 */
	public ConnectionDeleteCommand(Connection conn) {//연결지우기 명령
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection deletion");
		this.connection = conn;
	}
	public void execute() {//disconnect 싦행
		connection.disconnect();
	}
	public void undo() {//undo실행
		connection.reconnect();
	}
}
