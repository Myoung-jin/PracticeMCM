/**
 */
package opm.impl;

import opm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OpmFactoryImpl extends EFactoryImpl implements OpmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OpmFactory init() {
		try {
			OpmFactory theOpmFactory = (OpmFactory)EPackage.Registry.INSTANCE.getEFactory(OpmPackage.eNS_URI);
			if (theOpmFactory != null) {
				return theOpmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OpmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OpmPackage.OBJECT_PROCES_DIAGRAM: return createObjectProcesDiagram();
			case OpmPackage.OPM_OBJECT: return createOPMObject();
			case OpmPackage.OPM_PROCESS: return createOPMProcess();
			case OpmPackage.OPM_LINK: return createOPMLink();
			case OpmPackage.OPM_THING: return createOPMThing();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProcesDiagram createObjectProcesDiagram() {
		ObjectProcesDiagramImpl objectProcesDiagram = new ObjectProcesDiagramImpl();
		return objectProcesDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMObject createOPMObject() {
		OPMObjectImpl opmObject = new OPMObjectImpl();
		return opmObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMProcess createOPMProcess() {
		OPMProcessImpl opmProcess = new OPMProcessImpl();
		return opmProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMLink createOPMLink() {
		OPMLinkImpl opmLink = new OPMLinkImpl();
		return opmLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThing createOPMThing() {
		OPMThingImpl opmThing = new OPMThingImpl();
		return opmThing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpmPackage getOpmPackage() {
		return (OpmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OpmPackage getPackage() {
		return OpmPackage.eINSTANCE;
	}

} //OpmFactoryImpl
