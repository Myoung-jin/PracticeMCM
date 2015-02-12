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


 // resize하거나 shape를 움직이는 명령이다. 이 명령은 undo와 redo가 가능하다.
 
public class ShapeSetConstraintCommand extends Command {
	private final Rectangle newBounds;//새로운 사이즈를 저장하는 장소... 근데 왜 rectagle이지? 사이즈 조절때문인가?
	private Rectangle oldBounds;//이전 사이즈를 저장한다.
	private final ChangeBoundsRequest request;//move/resize를 하기위한 editPart 요청
	private final Shape shape;//shape 조작
	/**
	 * resize와 move를 할 수 있는 명령을 만들어라
	 * @param shape : the shape to manipulate
	 * @param req : the move and resize request
	 * @param newBounds : the new size and location
	 * @throws IllegalArgumentException : if any of the parameters is null
	 */
	
	//생성자
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
		//세가지 객체가 존재할 경우 실행이 가능. 요청이 가능한 타입일 경우.
		Object type = request.getType();
		return (RequestConstants.REQ_MOVE.equals(type)
				|| RequestConstants.REQ_MOVE_CHILDREN.equals(type)
				|| RequestConstants.REQ_RESIZE.equals(type) || RequestConstants.REQ_RESIZE_CHILDREN.equals(type));
	}

	// @see org.eclipse.gef.commands.Command#execute()
	public void execute() {//위치가 변경되거나 사이즈가 변경된 객체를 새로 만들어 객체에 삽입한다.
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
