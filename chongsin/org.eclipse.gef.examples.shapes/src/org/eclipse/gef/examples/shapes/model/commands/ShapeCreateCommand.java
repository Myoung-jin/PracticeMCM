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
 * ShapeDiagram에서 쉐이프를 추가하기 위한 명령. redo와 undo가 가능하다
 * @author Elias Volanakis
 */
public class ShapeCreateCommand extends Command {

	private Shape newShape;//새로운 도형
	private final ShapesDiagram parent;//ShapeDiagram을 추가하기 위함
	private Rectangle bounds;//도형의 경계

	/**
	 * ShapeDiagram에 새 도형을 추가할 명령을 만들어라
	 * @param newShape : the new Shape that is to be added
	 * @param parent : the ShapesDiagram that will hold the new element
	 * @param bounds : the bounds of the new shape; the size can be (-1, -1) if not known
	 * @throws IllegalArgumentException : if any parameter is null, or the request does not provide a new Shape instance
	 */
	
	public ShapeCreateCommand(Shape newShape, ShapesDiagram parent,Rectangle bounds) {//ShapeCreateCommand의 생성자
		this.newShape = newShape;
		this.parent = parent;
		this.bounds = bounds;
		setLabel("shape creation");
	}
	
	 // @see org.eclipse.gef.commands.Command#canExecute()
	
	public boolean canExecute() {//세 매개변수가 모드 존재할경우 리턴
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

	public void redo() {//되돌리기
		parent.addChild(newShape);//Parent에 새로운 Shape를 addChild로 추가해 준다.
	}

	 // @see org.eclipse.gef.commands.Command#undo()

	public void undo() {//실행취소
		parent.removeChild(newShape);//새로운 Shape를 제거
	}

}