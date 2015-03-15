/**
 */
package opm.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import opm.ObjectProcesDiagram;
import opm.OpmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Object Proces Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectProcesDiagramTest extends TestCase {

	/**
	 * The fixture for this Object Proces Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectProcesDiagram fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ObjectProcesDiagramTest.class);
	}

	/**
	 * Constructs a new Object Proces Diagram test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcesDiagramTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Object Proces Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ObjectProcesDiagram fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Object Proces Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectProcesDiagram getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OpmFactory.eINSTANCE.createObjectProcesDiagram());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ObjectProcesDiagramTest
