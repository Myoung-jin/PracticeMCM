/**
 */
package opm.impl;

import opm.OPMProcess;
import opm.ObjectProcesDiagram;
import opm.OpmPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OPM Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link opm.impl.OPMProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link opm.impl.OPMProcessImpl#getOpd <em>Opd</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OPMProcessImpl extends OPMThingImpl implements OPMProcess {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOpd() <em>Opd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpd()
	 * @generated
	 * @ordered
	 */
	protected ObjectProcesDiagram opd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OpmPackage.Literals.OPM_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpmPackage.OPM_PROCESS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcesDiagram getOpd() {
		if (opd != null && opd.eIsProxy()) {
			InternalEObject oldOpd = (InternalEObject)opd;
			opd = (ObjectProcesDiagram)eResolveProxy(oldOpd);
			if (opd != oldOpd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OpmPackage.OPM_PROCESS__OPD, oldOpd, opd));
			}
		}
		return opd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcesDiagram basicGetOpd() {
		return opd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpd(ObjectProcesDiagram newOpd) {
		ObjectProcesDiagram oldOpd = opd;
		opd = newOpd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OpmPackage.OPM_PROCESS__OPD, oldOpd, opd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OpmPackage.OPM_PROCESS__NAME:
				return getName();
			case OpmPackage.OPM_PROCESS__OPD:
				if (resolve) return getOpd();
				return basicGetOpd();
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
			case OpmPackage.OPM_PROCESS__NAME:
				setName((String)newValue);
				return;
			case OpmPackage.OPM_PROCESS__OPD:
				setOpd((ObjectProcesDiagram)newValue);
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
			case OpmPackage.OPM_PROCESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OpmPackage.OPM_PROCESS__OPD:
				setOpd((ObjectProcesDiagram)null);
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
			case OpmPackage.OPM_PROCESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OpmPackage.OPM_PROCESS__OPD:
				return opd != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OPMProcessImpl
