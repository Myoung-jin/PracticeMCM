/**
 */
package opm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OPM Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link opm.OPMProcess#getName <em>Name</em>}</li>
 *   <li>{@link opm.OPMProcess#getOpd <em>Opd</em>}</li>
 * </ul>
 * </p>
 *
 * @see opm.OpmPackage#getOPMProcess()
 * @model
 * @generated
 */
public interface OPMProcess extends OPMThing {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see opm.OpmPackage#getOPMProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link opm.OPMProcess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Opd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opd</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opd</em>' reference.
	 * @see #setOpd(ObjectProcesDiagram)
	 * @see opm.OpmPackage#getOPMProcess_Opd()
	 * @model
	 * @generated
	 */
	ObjectProcesDiagram getOpd();

	/**
	 * Sets the value of the '{@link opm.OPMProcess#getOpd <em>Opd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opd</em>' reference.
	 * @see #getOpd()
	 * @generated
	 */
	void setOpd(ObjectProcesDiagram value);

} // OPMProcess
