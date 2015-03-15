/**
 */
package opm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Proces Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link opm.ObjectProcesDiagram#getObjects <em>Objects</em>}</li>
 *   <li>{@link opm.ObjectProcesDiagram#getProcesses <em>Processes</em>}</li>
 *   <li>{@link opm.ObjectProcesDiagram#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see opm.OpmPackage#getObjectProcesDiagram()
 * @model
 * @generated
 */
public interface ObjectProcesDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link opm.OPMObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see opm.OpmPackage#getObjectProcesDiagram_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<OPMObject> getObjects();

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link opm.OPMProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see opm.OpmPackage#getObjectProcesDiagram_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<OPMProcess> getProcesses();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link opm.OPMLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see opm.OpmPackage#getObjectProcesDiagram_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<OPMLink> getLinks();

} // ObjectProcesDiagram
