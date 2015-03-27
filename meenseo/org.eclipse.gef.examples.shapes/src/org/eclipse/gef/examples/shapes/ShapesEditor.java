/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
?*******************************************************************************/
package org.eclipse.gef.examples.shapes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;
import org.eclipse.gef.examples.shapes.parts.ShapesEditPartFactory;
import org.eclipse.gef.examples.shapes.parts.ShapesTreeEditPartFactory;

/**
 * A graphical editor with flyout palette that can edit .shapes files. The
 * binding between the .shapes file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
/*
 * ���� ���̱� ���ؼ��� �������� �׷����� ������ ����� Diagram�� �ʿ��ϴ�.
 *  Diagram�� ��ȭ���� ������ �Ѵٰ� �����ϸ� �ȴ�.
 *  �׸��� ���� �� ���� Ư�� ũ�⸸ŭ �׸��� �Ǵ� ���̴�.		
 *  Diagram���� �׷����� ���� Diagram���� �˰� �־�� �Ѵ�. 
 *  �׷��� ���ΰ�ħ�� �ǰų�, �ڽ��� �̵��� ������, �ٽ� �׷��� �� �ִ�.
 *  �� ����� Diagram���� List�� ������ �Ѵ�.
 * */
public class ShapesEditor extends GraphicalEditorWithFlyoutPalette {

	/** This is the root of the editor's model. */
	//ShapeDiagram : �׷����� ��ü�� List�� ����, List�� ������ �׷����� �߿��ϰ� ���ȴ�.
	//���� ���� ������ �� ������� ���� �ö���� �Ʒ��� �������� List ������ ���� �����ϰ� �ȴ�                      
	private ShapesDiagram diagram;
	/** Palette component, holding the tools and shapes. */

	/*   �� ��Ʈ ������ ���ؼ� �ۼ��� Ŭ������ �ִ� ��ǥ�� "Palette Root"��� �ȷ�Ʈ �ֻ��� ��ü��
	 *   �ȷ�Ʈ ������ �䱸�� �����Ϳ��� �ǵ����ִ� ���̴�.
	 *   �׷��Ƿ� �ݵ�� �ȷ�Ʈ�� ��Ʈ�� �ǵ��� �ִ� �޼ҵ尡 �ʿ�� �Ѵ�.
	 *   ���� �ҽ������� 2���� �޼ҵ带 �ۼ��ߴµ� ���� getPaletteRoot()�� ���� �޼ҵ带 
	 *   ����� �ʿ���� ������ ���ÿ� �ȷ�Ʈ ��Ʈ�� ��ȯ�ϸ� �ȴ�.*/
	private static PaletteRoot PALETTE_MODEL;

	/** Create a new ShapesEditor instance.
	 *  This is called by the Workspace. */
	//���ο� ShapesEditor �ν��Ͻ��� �����մϴ�. �� �۾� ������ ���� ȣ��ȴ�.
	public ShapesEditor() {				//������
		setEditDomain(new DefaultEditDomain(this));
		//setEditDomain : �̺�Ʈ�� ����.
		// EditDomain : �信���� �̺�Ʈ�� ����
	}

	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>
	 * This is the place to choose an appropriate RootEditPart and
	 * EditPartFactory for your editor. 
	 * The RootEditPart determines the behavior
	 * of the editor's "work-area". For example, GEF includes zoomable and
	 * scrollable root edit parts. The EditPartFactory maps model elements to
	 * edit parts (controllers).
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	protected void configureGraphicalViewer() {
		//configureGraphicalViewer() : �׸��� �׸��� ����.. factory
		super.configureGraphicalViewer();
		//GraphicalViewer : ���� �׷��� �׸��� ���� �ִ� �� , ù �������̰� ���⼭ ���� �׸��� �׸�
		// ���콺 Ŭ���� ������� Input�� �޾� ���̸� ������ �̺�Ʈ �ڵ鷯�� ����
		//EditDomain�� ���� ���۷����� ����-vEditDomain��  GraphicalViewer�� �߰��ϸ� EditDomain�� �ٽ� GraphicalViewer�� �ڽ��� ��� 
		//ScrollingGraphicalViewer - GraphicalViewer�� ��� ����, ��ũ�ѹٰ� �ڵ����� ���������� �������. 
		//                         - Draw2D�� FigureCanvas�� ����Ͽ� ����


		//rootEditPart : ���� ��..
		//EditPartFactory :  
		//�ΰ��� �뵵�� ����ѵ� �ι�°�� �ٸ� ������ �����.. �̿��ڸ� ����.
		
		GraphicalViewer viewer = getGraphicalViewer(); 
		
		viewer.setEditPartFactory(new ShapesEditPartFactory());
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, true);
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);

		// ���ؽ�Ʈ �޴� �����ڸ� �����Ѵ�.
		ContextMenuProvider cmProvider 
			= new ShapesEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);

		configureZoomLevel(); 
	    configureKeyHandler(); 
	}

	private void configureZoomLevel(){
		GraphicalViewer viewer = getGraphicalViewer();
		
		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		
		double[] zoomlevels = new double[]{
				0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0 ,10.0, 20.0
		};
		
		manager.setZoomLevels(zoomlevels);
		
		List<String> contributions = new ArrayList<String>();
		contributions.add(ZoomManager.FIT_ALL);
		contributions.add(ZoomManager.FIT_HEIGHT);
		contributions.add(ZoomManager.FIT_WIDTH);
		manager.setZoomLevelContributions(contributions);
			
	}
	
	private void configureKeyHandler(){
		GraphicalViewer viewer = getGraphicalViewer();
		KeyHandler keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		keyHandler.put(KeyStroke.getPressed('+',SWT.KEYPAD_ADD,0), getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		keyHandler.put(KeyStroke.getPressed('-',SWT.KEYPAD_SUBTRACT,0),getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		
		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.NONE), MouseWheelZoomHandler.SINGLETON);
		viewer.setKeyHandler(keyHandler);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.ui.parts.GraphicalEditor#commandStackChanged(java.util
	 * .EventObject)
	 */
	
	//����Ʈ �������� �信 �ִ� ��� ���� �Ѱ�..
	//�ڸེ ���ÿ� �̺�Ʈ�� ������� �� ������ ���� 
	
	public void commandStackChanged(EventObject event) {
		//������ ������ ����Ǹ�, 
		//workbench�� firePropertyChange(PROP_DIRTY)����
		//���� ��Ʈ�� �˷���� �Ѵ�.
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	private void createOutputStream(OutputStream os) throws IOException {//createOutputStream : ���� ����
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(getModel());//top�� �ϳ��� ������ ���� �ڽ� �𵨵��� ������ ������ ��.
		oos.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#
	 * createPaletteViewerProvider()
	 */
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				//�ȷ�Ʈ�� ���� �巡�� �ҽ� �����ʸ� �����. ������ Ÿ�� ��� Ÿ�� �����ʰ� Ȱ��ȭ �ȴ�.
				//������ �ȿ� �ȷ�Ʈ�� ���� �巡�� �Ͽ� CombinatedTemplateCreationEntries �� �伭 ����
				super.configurePaletteViewer(viewer);
				// create a drag source listener for this palette viewer
				// together with an appropriate transfer drop target listener,
				// this will enable
				// model element creation by dragging a
				// CombinatedTemplateCreationEntries
				// from the palette into the editor
				// @see ShapesEditor#createTransferDropTargetListener()
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(
						viewer));
			}
		};
	}

	/**
	 * Create a transfer drop target listener. When using a
	 * CombinedTemplateCreationEntry tool in the palette, this will enable model
	 * element creation by dragging from the palette.
	 * 
	 * @see #createPaletteViewerProvider()
	 */
	private TransferDropTargetListener createTransferDropTargetListener() {
		return new TemplateTransferDropTargetListener(getGraphicalViewer()) {
			protected CreationFactory getFactory(Object template) {
				return new SimpleFactory((Class) template);
			}
		};
	}//���ο� ������ Ŭ���� ��ü�� ���� ����.. 

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor
	 * )
	 */
	public void doSave(IProgressMonitor monitor) {//�����ϱ�
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			createOutputStream(out);
			IFile file = ((IFileEditorInput) getEditorInput()).getFile();
			file.setContents(new ByteArrayInputStream(out.toByteArray()), true, // keep
																				// saving,
																				// even
																				// if
																				// IFile
																				// is
																				// out
																				// of
																				// sync
																				// with
																				// the
																				// Workspace
					false, // dont keep history
					monitor); // progress monitor
			getCommandStack().markSaveLocation();
		} catch (CoreException ce) {
			ce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {//�ٸ� �̸����� �����ϱ�
		// Show a SaveAs dialog
		Shell shell = getSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();

		IPath path = dialog.getResult();
		if (path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(path);
			try {
				new ProgressMonitorDialog(shell).run(false, // don't fork
						false, // not cancelable
						new WorkspaceModifyOperation() { // run this operation
							public void execute(final IProgressMonitor monitor) {
								try {
									ByteArrayOutputStream out = new ByteArrayOutputStream();
									createOutputStream(out);
									file.create(
											new ByteArrayInputStream(out
													.toByteArray()), // contents
											true, // keep saving, even if IFile
													// is out of sync with the
													// Workspace
											monitor); // progress monitor
								} catch (CoreException ce) {
									ce.printStackTrace();
								} catch (IOException ioe) {
									ioe.printStackTrace();
								}
							}
						});
				// set input to the new file
				setInput(new FileEditorInput(file));
				getCommandStack().markSaveLocation();
			} catch (InterruptedException ie) {
				// should not happen, since the monitor dialog is not cancelable
				ie.printStackTrace();
			} catch (InvocationTargetException ite) {
				ite.printStackTrace();
			}
		}
	}

	//�̺κ��� ����� ��.
	public Object getAdapter(Class type) {
		
		if (type == SnapToHelper.class) {   
		     List snaps = new ArrayList();   
		     Boolean val =(Boolean) getGraphicalViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);   
		    if(val != null && val.booleanValue()) snaps.add(new SnapToGrid((GraphicalEditPart) this));
		    
		    if (snaps.size() == 0) return null;   
		   	if (snaps.size() == 1) return snaps.get(0);   
    
		//if (type == IContentOutlinePage.class)
		//	return new ShapesOutlinePage(new TreeViewer());
		}
		
		if(type == ZoomManager.class)			
			return ((ScalableRootEditPart) getGraphicalViewer().getRootEditPart()).getZoomManager();   
		else 	
			return super.getAdapter(type);
	}	
	ShapesDiagram getModel() { 
		return diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot
	 * ()
	 */
	protected PaletteRoot getPaletteRoot() {//PaletteRoot�� ������ �ش�.
		if (PALETTE_MODEL == null)
			PALETTE_MODEL = ShapesEditorPaletteFactory.createPalette();
		return PALETTE_MODEL;
	}

	private void handleLoadException(Exception e) {
		System.err.println("** Load failed. Using default model. **");
		e.printStackTrace();
		diagram = new ShapesDiagram();
	}

	/**
	 * Set up the editor's inital content (after creation).
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(getModel()); // set the contents of this editor

		// listen for dropped parts
		viewer.addDropTargetListener(createTransferDropTargetListener());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) //�ҷ�����..
	{
		super.setInput(input);
		try {
			IFile file = ((IFileEditorInput) input).getFile();
			ObjectInputStream in = new ObjectInputStream(file.getContents());
			diagram = (ShapesDiagram) in.readObject();
			in.close();
			setPartName(file.getName());
		} catch (IOException e) {
			handleLoadException(e);
		} catch (CoreException e) {
			handleLoadException(e);
		} catch (ClassNotFoundException e) {
			handleLoadException(e);
		}
	}

	/**
	 * Creates an outline pagebook for this editor.
	 */
	public class ShapesOutlinePage extends ContentOutlinePage {
		/**
		 * Create a new outline page for the shapes editor.
		 * 
		 * @param viewer
		 *            a viewer (TreeViewer instance) used for this outline page
		 * @throws IllegalArgumentException
		 *             if editor is null
		 */
		public ShapesOutlinePage(EditPartViewer viewer) {
			super(viewer);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite
		 * )
		 */
		public void createControl(Composite parent) {//��Ʈ�� �޴��� ����� �ش�.
			// create outline viewer page
			getViewer().createControl(parent);
			// configure outline viewer
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new ShapesTreeEditPartFactory());
			// configure & add context menu to viewer
			ContextMenuProvider cmProvider = new ShapesEditorContextMenuProvider(
					getViewer(), getActionRegistry());
			getViewer().setContextMenu(cmProvider);
			getSite().registerContextMenu(
					"org.eclipse.gef.examples.shapes.outline.contextmenu",
					cmProvider, getSite().getSelectionProvider());
			// hook outline viewer
			getSelectionSynchronizer().addViewer(getViewer());
			// initialize outline viewer with model
			getViewer().setContents(getModel());
			// show outline viewer
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#dispose()
		 */
		public void dispose() {//����
			// unhook outline viewer
			getSelectionSynchronizer().removeViewer(getViewer());
			// dispose
			super.dispose();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#getControl()
		 */
		public Control getControl() {
			return getViewer().getControl();
		}

		/**
		 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
		 */
		public void init(IPageSite pageSite) {//�׼ǹٿ��� undo redo delete���� ����� �ش�.
			super.init(pageSite);
			ActionRegistry registry = getActionRegistry();
			IActionBars bars = pageSite.getActionBars();
			String id = ActionFactory.UNDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.REDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.DELETE.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
		}
	}

}