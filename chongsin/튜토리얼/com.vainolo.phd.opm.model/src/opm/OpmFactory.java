/**
 */
package opm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see opm.OpmPackage
 * @generated
 */
public interface OpmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OpmFactory eINSTANCE = opm.impl.OpmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Object Proces Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Proces Diagram</em>'.
	 * @generated
	 */
	ObjectProcesDiagram createObjectProcesDiagram();

	/**
	 * Returns a new object of class '<em>OPM Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPM Object</em>'.
	 * @generated
	 */
	OPMObject createOPMObject();

	/**
	 * Returns a new object of class '<em>OPM Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPM Process</em>'.
	 * @generated
	 */
	OPMProcess createOPMProcess();

	/**
	 * Returns a new object of class '<em>OPM Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPM Link</em>'.
	 * @generated
	 */
	OPMLink createOPMLink();

	/**
	 * Returns a new object of class '<em>OPM Thing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OPM Thing</em>'.
	 * @generated
	 */
	OPMThing createOPMThing();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OpmPackage getOpmPackage();

} //OpmFactory
