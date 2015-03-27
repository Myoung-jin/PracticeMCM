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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * Abstract 모델요소의 프로토타입
 * 이 클래스는 모든 모델요소를 위한 필수적인 특징을 제공한다.
 * 1. property-change support (모델변경의 에디트파트 부분을 알려주기위해 ),
 * 2. property-source support (속성뷰안의 속성값들을 보여주기 위해) 
 * 3. serialization support (모델계층을 직렬화되게 하기 위해)
 *  이 편집기는 저장할수 있고 재저장도 가능하다 binary 대표로..
 * 만약 당신이 non-binary라고 XML같은 폼에 자장해 놨다면 필요 없을 수도 있다.
 */
public abstract class ModelElement implements IPropertySource, Serializable {
	//Serializable : 저장.. 한줄로,,IPropertySource :이벤트를 날리는
	private static final IPropertyDescriptor[] EMPTY_ARRAY = new IPropertyDescriptor[0];
	private static final long serialVersionUID = 1;
	//속성 - 변화 - 지원을 implement하는 대표
	private transient PropertyChangeSupport pcsDelegate = new PropertyChangeSupport(this);
	/**
	 * non-null PropertyChangeListener를 이 객체에 붙여라
	 * @param l : a non-null PropertyChangeListener instance
	 * @throws IllegalArgumentException : if the parameter is null
	 */
	
	//synchronized : 동기화 하다.
	//쓰레드를 사용할 경우 synchronized가 필요해 진다.
	//자바는 빠른속도로 컴파일한다. 
	//그래서 동기화를 해서 중복 응답 또는 결과를 피한다. 
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		if (l == null) {
			throw new IllegalArgumentException();
		}
		pcsDelegate.addPropertyChangeListener(l);
	}

	/**
	 * 저장된 리스너에서 특성의 변화를 보도하기 위해 (예 : editparts)
	 * @param property : the programmatic name of the property that changed
	 * @param oldValue : the old value of this property
	 * @param newValue : the new value of this property
	 */
	
	protected void firePropertyChange(String property, Object oldValue,Object newValue) {
		if (pcsDelegate.hasListeners(property)) {//pcsDelegate : 속성 변화를 지원한다.
			pcsDelegate.firePropertyChange(property, oldValue, newValue);
			//firePropertyChange를  통해 editpart에 변경됨을 알려 준다.
		}
	}

	/**
	 * proterty sheet안에 편집 되어질 수 있는 property source를 위한 값을 리턴. 모델 객체는 자기 자신들을 리턴해야 한다.
	 * DimensionPropertySource 같은 사용자 의 IPropertySource를 구현 (GEF 로직 의 예에서 ) 편집 가능한 값 을 반환해야합니다.
	 * 필요하다면 오버라이드 하라 그리고 그 객체를 반환하라
	 */
	public Object getEditableValue() {
		return this;
	}

	// 자식은 이것을 오버라이드 한다.  디펄트 implementation은 빈 배열을 리턴한다.
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return EMPTY_ARRAY;
	}
	
	 // 자식은 이곳을 오버라이드 해야한다. 디펄트 implementattion은 null을 리턴한다.
	public Object getPropertyValue(Object id) {
		return null;
	}

	 // 자식은 이곳을 오버라이드 해야한다. 디펄트 implementattion은 false을 리턴한다.
	public boolean isPropertySet(Object id) {
		return false;
	}

	// 역 직렬화 생성자입니다. transient 필드를 초기화합니다 
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		pcsDelegate = new PropertyChangeSupport(this);
	}

	/**
	 * 이 구성요소로 부터 propertyChangeListener를 지워라
	 * @param l : a PropertyChangeListener instance
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		if (l != null) {//널이 아닌경우 propertyChangeListener을 삭제
			pcsDelegate.removePropertyChangeListener(l);
		}
	}

	 // 자식은 이곳을 오버라이드 해야한다. 디펄트 implementation은 아무것도 리턴하지 않아도 됨
	public void resetPropertyValue(Object id) {
		// do nothing
	}

	// 자식은 이곳을 오버라이드 해야한다. 디펄트 implementation은 아무것도 리턴하지 않아도 됨
	public void setPropertyValue(Object id, Object value) {
		// do nothing
	}
}
