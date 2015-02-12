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
package org.eclipse.gef.examples.shapes.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A container for multiple shapes. This is the "root" of the model data
 * structure.
 * 
 * @author Elias Volanakis
 */
public class ShapesDiagram extends ModelElement {
	//ShapesDiagram-ModelElement-shape-ellipse 
	//getModel에서 ShapesDiagram만 저장하면 그 child class들이 자동저장..
	//graphicalEditor에서는 ModelElement만 필요.. shapes자식이 있기 때문이다.
	/** Property ID to use when a child is added to this diagram. */
	public static final String CHILD_ADDED_PROP = "ShapesDiagram.ChildAdded";	 //상수처리 (변수에 들어있는 값을 다른곳에서 다른값으로 변경 불가.)
	/** Property ID to use when a child is removed from this diagram. */
	public static final String CHILD_REMOVED_PROP = "ShapesDiagram.ChildRemoved";//상수처리
	private static final long serialVersionUID = 1;
	private List shapes = new ArrayList();			//List 타입의 shapes 생성

	/**
	 * Add a shape to this diagram.
	 * 
	 * @param s
	 *            a non-null shape instance
	 * @return true, if the shape was added, false otherwise
	 */
	public boolean addChild(Shape s) {//bool타입의 addchild 함수(자식으로 추가되는것에 따라 어떤 속성을 변경하고 TRUE혹은 FALSE 리턴.)
		if (s != null && shapes.add(s)) {//Shape타입의 s가 Null이 아니고 s을 받아와 List타입의 shapes에 추가하는 상황			
			firePropertyChange(CHILD_ADDED_PROP, null, s);	//firePropertyChange(프로퍼티이름, 변경전값, 변경후값);
			return true;
		}
		return false; //if문에 해당 되지 않으면 false를 리턴한다.
	}

	/**
	 * Return a List of Shapes in this diagram. The returned List should not be
	 * modified.
	 */
	public List getChildren() {	//자식의 것을 받는다 (List타입의 shapes로)
		return shapes;
	}

	/**
	 * Remove a shape from this diagram.
	 * 
	 * @param s
	 *            a non-null shape instance;
	 * @return true, if the shape was removed, false otherwise
	 */
	public boolean removeChild(Shape s) {	//자식을 제것하는경우
		if (s != null && shapes.remove(s)) {//Shape타입의 s가 Null이 아니고 s을 받아와 List타입의 shapes로부터 제거하는 상황.
			firePropertyChange(CHILD_REMOVED_PROP, null, s);//firePropertyChange(프로퍼티이름, 변경전값, 변경후값);
			return true;
		}
		return false;
	}
}