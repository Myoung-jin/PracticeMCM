/**
 */
package opm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OPM Thing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link opm.OPMThing#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link opm.OPMThing#getOutgoingLinks <em>Outgoing Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see opm.OpmPackage#getOPMThing()
 * @model
 * @generated
 */
public interface OPMThing extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' containment reference list.
	 * The list contents are of type {@link opm.OPMLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' containment reference list.
	 * @see opm.OpmPackage#getOPMThing_IncomingLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<OPMLink> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' containment reference list.
	 * The list contents are of type {@link opm.OPMLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' containment reference list.
	 * @see opm.OpmPackage#getOPMThing_OutgoingLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<OPMLink> getOutgoingLinks();

} // OPMThing
