/**
 */
package opm.impl;

import java.util.Collection;

import opm.OPMLink;
import opm.OPMObject;
import opm.OPMProcess;
import opm.ObjectProcesDiagram;
import opm.OpmPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Proces Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link opm.impl.ObjectProcesDiagramImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link opm.impl.ObjectProcesDiagramImpl#getProcesses <em>Processes</em>}</li>
 *   <li>{@link opm.impl.ObjectProcesDiagramImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectProcesDiagramImpl extends MinimalEObjectImpl.Container implements ObjectProcesDiagram {
	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<OPMObject> objects;

	/**
	 * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<OPMProcess> processes;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<OPMLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectProcesDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OpmPackage.Literals.OBJECT_PROCES_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPMObject> getObjects() {
		if (objects == null) {
			objects = new EObjectContainmentEList<OPMObject>(OPMObject.class, this, OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPMProcess> getProcesses() {
		if (processes == null) {
			processes = new EObjectContainmentEList<OPMProcess>(OPMProcess.class, this, OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES);
		}
		return processes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OPMLink> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<OPMLink>(OPMLink.class, this, OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS:
				return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
			case OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES:
				return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
			case OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS:
				return getObjects();
			case OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES:
				return getProcesses();
			case OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS:
				return getLinks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends OPMObject>)newValue);
				return;
			case OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES:
				getProcesses().clear();
				getProcesses().addAll((Collection<? extends OPMProcess>)newValue);
				return;
			case OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends OPMLink>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS:
				getObjects().clear();
				return;
			case OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES:
				getProcesses().clear();
				return;
			case OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS:
				getLinks().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM__OBJECTS:
				return objects != null && !objects.isEmpty();
			case OpmPackage.OBJECT_PROCES_DIAGRAM__PROCESSES:
				return processes != null && !processes.isEmpty();
			case OpmPackage.OBJECT_PROCES_DIAGRAM__LINKS:
				return links != null && !links.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectProcesDiagramImpl
