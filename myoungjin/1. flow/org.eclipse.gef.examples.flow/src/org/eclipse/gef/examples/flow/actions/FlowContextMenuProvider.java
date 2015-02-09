/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gef.examples.flow.actions;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class FlowContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry actionRegistry;
	public FlowContextMenuProvider(EditPartViewer viewer,
			ActionRegistry registry) {
		super(viewer);
		setActionRegistry(registry);
	}

	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);

		IAction action;
		
		action = getActionRegistry().getAction(ActionFactory.UNDO.getId());//undo 실행시 해당 객체의 undo실행후 메뉴 그룹에 모두 추가
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

		action = getActionRegistry().getAction(ActionFactory.REDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);

		action = getActionRegistry().getAction(ActionFactory.DELETE.getId());//해당 아이디를 가져와 삭제 붙일 필요 없다.
		
		
		if (action.isEnabled())
			menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

	}

	private ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	/**
	 * Sets the action registry
	 * 
	 * @param registry
	 *            the action registry
	 */
	public void setActionRegistry(ActionRegistry registry) {
		actionRegistry = registry;
	}

}
