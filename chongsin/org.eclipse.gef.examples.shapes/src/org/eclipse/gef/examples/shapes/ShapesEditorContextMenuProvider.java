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
package org.eclipse.gef.examples.shapes;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;

/**
 * Provides context menu actions for the ShapesEditor.
 * 
 * @author Elias Volanakis
 */
class ShapesEditorContextMenuProvider extends ContextMenuProvider {

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;
	//ActionRegistry : 에디터 의 행동에 대한 컨테이너입니다. 
	//그들이 편집자에게 사용할 수 있습니다 전에 조치를 등록해야합니다.
	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer
	 * and ActionRegistry.
	 * 
	 * @param viewer
	 *            the editor's graphical viewer
	 * @param registry
	 *            the editor's action registry
	 * @throws IllegalArgumentException
	 *             if registry is <tt>null</tt>.
	 */
	public ShapesEditorContextMenuProvider(EditPartViewer viewer,
			ActionRegistry registry) {
		super(viewer);
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		actionRegistry = registry;
	}

	/**
	 * Called when the context menu is about to show. Actions, whose state is
	 * enabled, will appear in the context menu.
	 * 상황에 맞는 메뉴 가 표시 하려 할 때 호출됩니다. 동작 , 상태는 활성화 , 상황에 맞는 메뉴 에 표시됩니다.
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);

		// Add actions to the menu
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO,
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));
		
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}

}
