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

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;

import org.eclipse.gef.examples.shapes.model.Shape;


 // resize�ϰų� shape�� �����̴� ����̴�. �� ����� undo�� redo�� �����ϴ�.
 
public class ShapeSetConstraintCommand extends Command {
	private final Rectangle newBounds;//���ο� ����� �����ϴ� ���... �ٵ� �� rectagle����? ������ ���������ΰ�?
	private Rectangle oldBounds;//���� ����� �����Ѵ�.
	private final ChangeBoundsRequest request;//move/resize�� �ϱ����� editPart ��û
	private final Shape shape;//shape ����
	/**
	 * resize�� move�� �� �� �ִ� ����� ������
	 * @param shape : the shape to manipulate
	 * @param req : the move and resize request
	 * @param newBounds : the new size and location
	 * @throws IllegalArgumentException : if any of the parameters is null
	 */
	
	//������
	public ShapeSetConstraintCommand(Shape shape, ChangeBoundsRequest req,Rectangle newBounds) {
		if (shape == null || req == null || newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.shape = shape;
		this.request = req;
		this.newBounds = newBounds.getCopy();
		setLabel("move / resize");
	}

	 // @see org.eclipse.gef.commands.Command#canExecute()
	public boolean canExecute() {
		//������ ��ü�� ������ ��� ������ ����. ��û�� ������ Ÿ���� ���.
		Object type = request.getType();
		return (RequestConstants.REQ_MOVE.equals(type)
				|| RequestConstants.REQ_MOVE_CHILDREN.equals(type)
				|| RequestConstants.REQ_RESIZE.equals(type) || RequestConstants.REQ_RESIZE_CHILDREN.equals(type));
	}

	// @see org.eclipse.gef.commands.Command#execute()
	public void execute() {//��ġ�� ����ǰų� ����� ����� ��ü�� ���� ����� ��ü�� �����Ѵ�.
		oldBounds = new Rectangle(shape.getLocation(), shape.getSize());
		redo();
	}


	 // @see org.eclipse.gef.commands.Command#redo()
	public void redo() {
		shape.setSize(newBounds.getSize());
		shape.setLocation(newBounds.getLocation());
	}
 
	 // @see org.eclipse.gef.commands.Command#undo()
	public void undo() {
		shape.setSize(oldBounds.getSize());
		shape.setLocation(oldBounds.getLocation());
	}
}
