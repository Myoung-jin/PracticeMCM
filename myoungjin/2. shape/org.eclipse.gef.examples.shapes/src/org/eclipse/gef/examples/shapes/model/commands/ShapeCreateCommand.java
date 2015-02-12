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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.examples.shapes.model.Shape;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;

/**
 * ShapeDiagram���� �������� �߰��ϱ� ���� ���. redo�� undo�� �����ϴ�
 * @author Elias Volanakis
 */
public class ShapeCreateCommand extends Command {

	private Shape newShape;//���ο� ����
	private final ShapesDiagram parent;//ShapeDiagram�� �߰��ϱ� ����
	private Rectangle bounds;//������ ���

	/**
	 * ShapeDiagram�� �� ������ �߰��� ����� ������
	 * @param newShape : the new Shape that is to be added
	 * @param parent : the ShapesDiagram that will hold the new element
	 * @param bounds : the bounds of the new shape; the size can be (-1, -1) if not known
	 * @throws IllegalArgumentException : if any parameter is null, or the request does not provide a new Shape instance
	 */
	
	public ShapeCreateCommand(Shape newShape, ShapesDiagram parent,Rectangle bounds) {//ShapeCreateCommand�� ������
		this.newShape = newShape;
		this.parent = parent;
		this.bounds = bounds;
		setLabel("shape creation");
	}
	
	 // @see org.eclipse.gef.commands.Command#canExecute()
	
	public boolean canExecute() {//�� �Ű������� ��� �����Ұ�� ����
		return newShape != null && parent != null && bounds != null;
	}

	// @see org.eclipse.gef.commands.Command#execute()
	
	public void execute() {
		newShape.setLocation(bounds.getLocation());
		Dimension size = bounds.getSize();
		if (size.width > 0 && size.height > 0) newShape.setSize(size);
		redo();
	}

	 // @see org.eclipse.gef.commands.Command#redo()

	public void redo() {//�ǵ�����
		parent.addChild(newShape);//Parent�� ���ο� Shape�� addChild�� �߰��� �ش�.
	}

	 // @see org.eclipse.gef.commands.Command#undo()

	public void undo() {//�������
		parent.removeChild(newShape);//���ο� Shape�� ����
	}

}