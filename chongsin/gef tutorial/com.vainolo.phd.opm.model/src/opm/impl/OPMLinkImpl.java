/**
 */
package opm.impl;

import opm.OPMLink;
import opm.OPMThing;
import opm.ObjectProcessDiagram;
import opm.OpmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OPM Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link opm.impl.OPMLinkImpl#getOpd <em>Opd</em>}</li>
 *   <li>{@link opm.impl.OPMLinkImpl#getSource <em>Source</em>}</li>
 *   <li>{@link opm.impl.OPMLinkImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPMLinkImpl extends MinimalEObjectImpl.Container implements OPMLink {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OPMThing source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected OPMThing target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OpmPackage.Literals.OPM_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcessDiagram getOpd() {
		if (eContainerFeatureID() != OpmPackage.OPM_LINK__OPD) return null;
		return (ObjectProcessDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpd(ObjectProcessDiagram newOpd, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOpd, OpmPackage.OPM_LINK__OPD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpd(ObjectProcessDiagram newOpd) {
		if (newOpd != eInternalContainer() || (eContainerFeatureID() != OpmPackage.OPM_LINK__OPD && newOpd != null)) {
			if (EcoreUtil.isAncestor(this, newOpd))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOpd != null)
				msgs = ((InternalEObject)newOpd).eInverseAdd(this, OpmPackage.OBJECT_PROCESS_DIAGRAM__LINKS, ObjectProcessDiagram.class, msgs);
			msgs = basicSetOpd(newOpd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpmPackage.OPM_LINK__OPD, newOpd, newOpd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThing getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (OPMThing)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OpmPackage.OPM_LINK__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThing basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OPMThing newSource) {
		OPMThing oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpmPackage.OPM_LINK__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThing getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (OPMThing)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OpmPackage.OPM_LINK__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThing basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(OPMThing newTarget) {
		OPMThing oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpmPackage.OPM_LINK__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OpmPackage.OPM_LINK__OPD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOpd((ObjectProcessDiagram)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OpmPackage.OPM_LINK__OPD:
				return basicSetOpd(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OpmPackage.OPM_LINK__OPD:
				return eInternalContainer().eInverseRemove(this, OpmPackage.OBJECT_PROCESS_DIAGRAM__LINKS, ObjectProcessDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OpmPackage.OPM_LINK__OPD:
				return getOpd();
			case OpmPackage.OPM_LINK__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case OpmPackage.OPM_LINK__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OpmPackage.OPM_LINK__OPD:
				setOpd((ObjectProcessDiagram)newValue);
				return;
			case OpmPackage.OPM_LINK__SOURCE:
				setSource((OPMThing)newValue);
				return;
			case OpmPackage.OPM_LINK__TARGET:
				setTarget((OPMThing)newValue);
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
			case OpmPackage.OPM_LINK__OPD:
				setOpd((ObjectProcessDiagram)null);
				return;
			case OpmPackage.OPM_LINK__SOURCE:
				setSource((OPMThing)null);
				return;
			case OpmPackage.OPM_LINK__TARGET:
				setTarget((OPMThing)null);
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
			case OpmPackage.OPM_LINK__OPD:
				return getOpd() != null;
			case OpmPackage.OPM_LINK__SOURCE:
				return source != null;
			case OpmPackage.OPM_LINK__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //OPMLinkImpl
