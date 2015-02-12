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
 * Abstract prototype of a model element.
 * <p>
 * This class provides features necessary for all model elements, like:
 * </p>
 * <ul>
 * <li>property-change support (used to notify edit parts of model changes),</li>
 * <li>property-source support (used to display property values in the Property
 * View) and</li>
 * <li>serialization support (the model hierarchy must be serializable, so that
 * the editor can save and restore a binary representation. You might not need
 * this, if you store the model a non-binary form like XML).</li>
 * </ul>
 * 
 * @author Elias Volanakis
 */
public abstract class ModelElement implements IPropertySource, Serializable {
	//Serializable : ����.. ���ٷ�,,IPropertySource :�̺�Ʈ�� ������
	private static final IPropertyDescriptor[] EMPTY_ARRAY = new IPropertyDescriptor[0];
	private static final long serialVersionUID = 1;
	/** Delegate used to implemenent property-change-support. */
	//�Ӽ� ��ȭ ������ implement�ϴ� ��ǥ
	private transient PropertyChangeSupport pcsDelegate = new PropertyChangeSupport(this);
	/**
	 * Attach a non-null PropertyChangeListener to this object.
	 * @param l : a non-null PropertyChangeListener instance
	 * @throws IllegalArgumentException : if the parameter is null
	 */
	
	//synchronized : ����ȭ �ϴ�.
	//�����带 ����� ��� synchronized�� �ʿ��� ����.
	//�ڹٴ� �����ӵ��� �������Ѵ�. 
	//�׷��� ����ȭ�� �ؼ� �ߺ� ���� �Ǵ� ����� ���Ѵ�. 
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		if (l == null) {
			throw new IllegalArgumentException();
		}
		pcsDelegate.addPropertyChangeListener(l);
	}

	/**
	 * ����� �����ʿ��� Ư���� ��ȭ�� �����ϱ� ���� (�� : editparts)
	 * @param property : the programmatic name of the property that changed
	 * @param oldValue : the old value of this property
	 * @param newValue : the new value of this property
	 */
	
	protected void firePropertyChange(String property, Object oldValue,Object newValue) {
		if (pcsDelegate.hasListeners(property)) {//pcsDelegate : �Ӽ� ��ȭ�� �����Ѵ�.
			pcsDelegate.firePropertyChange(property, oldValue, newValue);
			//firePropertyChange��  ���� editpart�� ������� �˷� �ش�.
		}
	}

	/**
	 * proterty sheet�ȿ� ���� �Ǿ��� �� �ִ� property source�� ���� ���� ����. �� ��ü�� �ڱ� �ڽŵ��� �����ؾ� �Ѵ�.
	 * DimensionPropertySource ���� ����� �� IPropertySource�� ���� (GEF ���� �� ������ ) ���� ������ �� �� ��ȯ�ؾ��մϴ�.
	 * �ʿ��ϴٸ� �������̵� �϶� �׸��� �� ��ü�� ��ȯ�϶�
	 */
	public Object getEditableValue() {
		return this;
	}

	// �ڽ��� �̰��� �������̵� �Ѵ�.  ����Ʈ implementation�� �� �迭�� �����Ѵ�.
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return EMPTY_ARRAY;
	}
	
	 // �ڽ��� �̰��� �������̵� �ؾ��Ѵ�. ����Ʈ implementattion�� null�� �����Ѵ�.
	public Object getPropertyValue(Object id) {
		return null;
	}

	 // �ڽ��� �̰��� �������̵� �ؾ��Ѵ�. ����Ʈ implementattion�� false�� �����Ѵ�.
	public boolean isPropertySet(Object id) {
		return false;
	}

	// �� ����ȭ �������Դϴ�. transient �ʵ带 �ʱ�ȭ�մϴ� 
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		pcsDelegate = new PropertyChangeSupport(this);
	}

	/**
	 * �� ������ҷ� ���� propertyChangeListener�� ������
	 * @param l : a PropertyChangeListener instance
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		if (l != null) {//���� �ƴѰ�� propertyChangeListener�� ����
			pcsDelegate.removePropertyChangeListener(l);
		}
	}

	 // �ڽ��� �̰��� �������̵� �ؾ��Ѵ�. ����Ʈ implementation�� �ƹ��͵� �������� �ʾƵ� ��
	public void resetPropertyValue(Object id) {
		// do nothing
	}

	// �ڽ��� �̰��� �������̵� �ؾ��Ѵ�. ����Ʈ implementation�� �ƹ��͵� �������� �ʾƵ� ��
	public void setPropertyValue(Object id, Object value) {
		// do nothing
	}
}
