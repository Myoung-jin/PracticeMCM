/**
 */
package opm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see opm.OpmFactory
 * @model kind="package"
 * @generated
 */
public interface OpmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "opm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.vainolo.com/phd/opm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "opm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OpmPackage eINSTANCE = opm.impl.OpmPackageImpl.init();

	/**
	 * The meta object id for the '{@link opm.impl.ObjectProcesDiagramImpl <em>Object Proces Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.ObjectProcesDiagramImpl
	 * @see opm.impl.OpmPackageImpl#getObjectProcesDiagram()
	 * @generated
	 */
	int OBJECT_PROCES_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCES_DIAGRAM__OBJECTS = 0;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCES_DIAGRAM__PROCESSES = 1;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCES_DIAGRAM__LINKS = 2;

	/**
	 * The number of structural features of the '<em>Object Proces Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCES_DIAGRAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Object Proces Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROCES_DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link opm.impl.OPMThingImpl <em>OPM Thing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMThingImpl
	 * @see opm.impl.OpmPackageImpl#getOPMThing()
	 * @generated
	 */
	int OPM_THING = 4;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING__INCOMING_LINKS = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING__OUTGOING_LINKS = 1;

	/**
	 * The number of structural features of the '<em>OPM Thing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>OPM Thing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_THING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link opm.impl.OPMObjectImpl <em>OPM Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMObjectImpl
	 * @see opm.impl.OpmPackageImpl#getOPMObject()
	 * @generated
	 */
	int OPM_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__INCOMING_LINKS = OPM_THING__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__OUTGOING_LINKS = OPM_THING__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__NAME = OPM_THING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT__OPD = OPM_THING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OPM Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>OPM Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_OBJECT_OPERATION_COUNT = OPM_THING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link opm.impl.OPMProcessImpl <em>OPM Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMProcessImpl
	 * @see opm.impl.OpmPackageImpl#getOPMProcess()
	 * @generated
	 */
	int OPM_PROCESS = 2;

	/**
	 * The feature id for the '<em><b>Incoming Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__INCOMING_LINKS = OPM_THING__INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__OUTGOING_LINKS = OPM_THING__OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__NAME = OPM_THING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS__OPD = OPM_THING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>OPM Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS_FEATURE_COUNT = OPM_THING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>OPM Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_PROCESS_OPERATION_COUNT = OPM_THING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link opm.impl.OPMLinkImpl <em>OPM Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see opm.impl.OPMLinkImpl
	 * @see opm.impl.OpmPackageImpl#getOPMLink()
	 * @generated
	 */
	int OPM_LINK = 3;

	/**
	 * The feature id for the '<em><b>Opd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__OPD = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK__TARGET = 2;

	/**
	 * The number of structural features of the '<em>OPM Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>OPM Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPM_LINK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link opm.ObjectProcesDiagram <em>Object Proces Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Proces Diagram</em>'.
	 * @see opm.ObjectProcesDiagram
	 * @generated
	 */
	EClass getObjectProcesDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcesDiagram#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see opm.ObjectProcesDiagram#getObjects()
	 * @see #getObjectProcesDiagram()
	 * @generated
	 */
	EReference getObjectProcesDiagram_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcesDiagram#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see opm.ObjectProcesDiagram#getProcesses()
	 * @see #getObjectProcesDiagram()
	 * @generated
	 */
	EReference getObjectProcesDiagram_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.ObjectProcesDiagram#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see opm.ObjectProcesDiagram#getLinks()
	 * @see #getObjectProcesDiagram()
	 * @generated
	 */
	EReference getObjectProcesDiagram_Links();

	/**
	 * Returns the meta object for class '{@link opm.OPMObject <em>OPM Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPM Object</em>'.
	 * @see opm.OPMObject
	 * @generated
	 */
	EClass getOPMObject();

	/**
	 * Returns the meta object for the attribute '{@link opm.OPMObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see opm.OPMObject#getName()
	 * @see #getOPMObject()
	 * @generated
	 */
	EAttribute getOPMObject_Name();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMObject#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opd</em>'.
	 * @see opm.OPMObject#getOpd()
	 * @see #getOPMObject()
	 * @generated
	 */
	EReference getOPMObject_Opd();

	/**
	 * Returns the meta object for class '{@link opm.OPMProcess <em>OPM Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPM Process</em>'.
	 * @see opm.OPMProcess
	 * @generated
	 */
	EClass getOPMProcess();

	/**
	 * Returns the meta object for the attribute '{@link opm.OPMProcess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see opm.OPMProcess#getName()
	 * @see #getOPMProcess()
	 * @generated
	 */
	EAttribute getOPMProcess_Name();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMProcess#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opd</em>'.
	 * @see opm.OPMProcess#getOpd()
	 * @see #getOPMProcess()
	 * @generated
	 */
	EReference getOPMProcess_Opd();

	/**
	 * Returns the meta object for class '{@link opm.OPMLink <em>OPM Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPM Link</em>'.
	 * @see opm.OPMLink
	 * @generated
	 */
	EClass getOPMLink();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMLink#getOpd <em>Opd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opd</em>'.
	 * @see opm.OPMLink#getOpd()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Opd();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see opm.OPMLink#getSource()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Source();

	/**
	 * Returns the meta object for the reference '{@link opm.OPMLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see opm.OPMLink#getTarget()
	 * @see #getOPMLink()
	 * @generated
	 */
	EReference getOPMLink_Target();

	/**
	 * Returns the meta object for class '{@link opm.OPMThing <em>OPM Thing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OPM Thing</em>'.
	 * @see opm.OPMThing
	 * @generated
	 */
	EClass getOPMThing();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.OPMThing#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Incoming Links</em>'.
	 * @see opm.OPMThing#getIncomingLinks()
	 * @see #getOPMThing()
	 * @generated
	 */
	EReference getOPMThing_IncomingLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link opm.OPMThing#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing Links</em>'.
	 * @see opm.OPMThing#getOutgoingLinks()
	 * @see #getOPMThing()
	 * @generated
	 */
	EReference getOPMThing_OutgoingLinks();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OpmFactory getOpmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link opm.impl.ObjectProcesDiagramImpl <em>Object Proces Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.ObjectProcesDiagramImpl
		 * @see opm.impl.OpmPackageImpl#getObjectProcesDiagram()
		 * @generated
		 */
		EClass OBJECT_PROCES_DIAGRAM = eINSTANCE.getObjectProcesDiagram();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCES_DIAGRAM__OBJECTS = eINSTANCE.getObjectProcesDiagram_Objects();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCES_DIAGRAM__PROCESSES = eINSTANCE.getObjectProcesDiagram_Processes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROCES_DIAGRAM__LINKS = eINSTANCE.getObjectProcesDiagram_Links();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMObjectImpl <em>OPM Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMObjectImpl
		 * @see opm.impl.OpmPackageImpl#getOPMObject()
		 * @generated
		 */
		EClass OPM_OBJECT = eINSTANCE.getOPMObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPM_OBJECT__NAME = eINSTANCE.getOPMObject_Name();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_OBJECT__OPD = eINSTANCE.getOPMObject_Opd();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMProcessImpl <em>OPM Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMProcessImpl
		 * @see opm.impl.OpmPackageImpl#getOPMProcess()
		 * @generated
		 */
		EClass OPM_PROCESS = eINSTANCE.getOPMProcess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPM_PROCESS__NAME = eINSTANCE.getOPMProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_PROCESS__OPD = eINSTANCE.getOPMProcess_Opd();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMLinkImpl <em>OPM Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMLinkImpl
		 * @see opm.impl.OpmPackageImpl#getOPMLink()
		 * @generated
		 */
		EClass OPM_LINK = eINSTANCE.getOPMLink();

		/**
		 * The meta object literal for the '<em><b>Opd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_LINK__OPD = eINSTANCE.getOPMLink_Opd();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_LINK__SOURCE = eINSTANCE.getOPMLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_LINK__TARGET = eINSTANCE.getOPMLink_Target();

		/**
		 * The meta object literal for the '{@link opm.impl.OPMThingImpl <em>OPM Thing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see opm.impl.OPMThingImpl
		 * @see opm.impl.OpmPackageImpl#getOPMThing()
		 * @generated
		 */
		EClass OPM_THING = eINSTANCE.getOPMThing();

		/**
		 * The meta object literal for the '<em><b>Incoming Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_THING__INCOMING_LINKS = eINSTANCE.getOPMThing_IncomingLinks();

		/**
		 * The meta object literal for the '<em><b>Outgoing Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPM_THING__OUTGOING_LINKS = eINSTANCE.getOPMThing_OutgoingLinks();

	}

} //OpmPackage
