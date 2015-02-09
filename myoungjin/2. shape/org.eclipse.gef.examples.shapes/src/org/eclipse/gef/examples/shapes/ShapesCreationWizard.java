/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
?* All rights reserved. This program and the accompanying materials
?* are made available under the terms of the Eclipse Public License v1.0
?* which accompanies this distribution, and is available at
?* http://www.eclipse.org/legal/epl-v10.html
?*
?* Contributors:
?*????Elias Volanakis - initial API and implementation
?*******************************************************************************/
package org.eclipse.gef.examples.shapes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.gef.examples.shapes.model.ShapesDiagram;
/**
 * Create new new .shape-file. Those files can be used with the ShapesEditor
 * (see plugin.xml).
 * @author Elias Volanakis
 */
public class ShapesCreationWizard extends Wizard implements INewWizard {
	private static int fileCount = 1;
	private CreationPage page1;
	/*
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		//이 메소드는 반드시 있어야 한다. 위자드에 사용될 위자드 페이지들을 등록하는 역활을 수행한다. 
		//페이지가 하나밖에 없다면 하나만 등록하면 되고, 여러개가 있다면 차례로 계속 등록을 하면 된다
		// add pages to this wizard
		addPage(page1);
	}
	/*
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// create pages for this wizard
		page1 = new CreationPage(workbench, selection);
	}
	/*
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */	
/*	이 메소드는 위자드가 "Finish"버튼으로 종료되었을때 호출되어진다. 
 * 즉, 위자드가 종료되었을때 어떤 일을 해야하는지 작성하는 곳이라 할 수 있겠다.
 * 이 클립스에서 지원하는 NewFile 위자드 템플릿이 자동으로 생성하는 소스코드는 다음과 같다.
 *  일반적으로 새파일 생성하기 위한 위자드라면 수정없이 사용해도 무방하다.
 *   이 메소드에서 사용하는 Progress Monitor는 이클립스 Ant에서 지원해 주는 기능으로,
 *    길게 동작하는 태스크에 대한 행위를 관찰 할 수 있다는 장점을 가지고 있다.
*/
	public boolean performFinish() {
		return page1.finish();
	}

	/**
	 * This WizardPage can create an empty .shapes file for the ShapesEditor.
	 */
	private class CreationPage extends WizardNewFileCreationPage 
	{
		private static final String DEFAULT_EXTENSION = ".shapes";
		private final IWorkbench workbench;

		/**
		 * Create a new wizard page instance.
		 * 
		 * @param workbench
		 *            the current workbench
		 * @param selection
		 *            the current object selection
		 * @see ShapesCreationWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) 
		{
			super("shapeCreationPage1", selection);//파라메터로 페이지 내용을 작성
			this.workbench = workbench;
			setTitle("Create a new " + DEFAULT_EXTENSION + " file");//페이지의 제목으로 사용될 스트링
			setDescription("Create a new " + DEFAULT_EXTENSION + " file");//페이지 설명글

/*우 선 넘오오는 파라메터가 두개이다. 
 * JFace의 ISelection이 사용된다.
 * 이는 List나 Tree View에서 선택된 항목들에 대한 결과를 관리하기 위해서 사용되는 인터페이스이다.
 * selection은 ISelection 인터페이스가 아니고, IStructuredSelection 인터페이스를 사용한다.
 *  그러나 별 차이가 없다. IStructredSelection은 ISelection의 서브 인터페이스이기 때문에 기능상 차이점이 없다.
 *  하지만 첫번째 워크벤치 인터페이스가 넘어온다는점과 이 인터페이스를 저장한다는 사실이 첫번째 방법과 다르다
*/	
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl(org
		 * .eclipse.swt.widgets.Composite)
		 */
		
/*	createControl 메소드는 위자드 페이지에 반드시 존재해야하는 메소드이다. 
 * 이 메소드 안에 SWT를 이용하여 컨트롤들을 작성하면 된다. 
 * 템플릿을 사용하는 첫번째 방법에서는 자동으로 이 메소드의 내용을 채워주지만, 
 * 그 외의 방법에서는 직접 SWT로 페이지를 디자인 해야 한다.
 * 아래의 createControl의 경우 위자드 페이지를 구성한다.
 * 특화된 클래스를 상속받아 부모에게 역할을 넘긴다.
*/
		public void createControl(Composite parent) {
			
			//부모에게 많은 부분을 위임한다.
			super.createControl(parent);
			setFileName("shapesExample" + fileCount + DEFAULT_EXTENSION);
			 // 페이지에 충분한 정보가 기재되었는가를 알리는 함수를 사용한다.
		    // setPageComplete(ture)가 되면, 페이지전환이 가능하게 된다
			setPageComplete(validatePage());
		}

		/** Return a new ShapesDiagram instance. */
		private Object createDefaultContent() {
			return new ShapesDiagram();
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see ShapesCreationWizard#performFinish()
		 */
		boolean finish() 
		{
			// create a new file, result != null if successful
			IFile newFile = createNewFile();
			fileCount++;

			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			if (newFile != null && page != null) {
				try {
					IDE.openEditor(page, newFile, true);
				} catch (PartInitException e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
		 */
		protected InputStream getInitialContents() {
			ByteArrayInputStream bais = null;
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(createDefaultContent()); // argument must be
															// Serializable
				oos.flush();
				oos.close();
				bais = new ByteArrayInputStream(baos.toByteArray());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return bais;
		}

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null
					&& getFileName().endsWith(DEFAULT_EXTENSION)) {
				return true;
			}
			setErrorMessage("The 'file' name must end with "
					+ DEFAULT_EXTENSION);
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		
		/*
		 메소드는 validatePage() 이다.
		  setPageComplete 메소드와 함께 사용된 것을 기억할 수 있을 것이다.
		   실제로 WizardNewFileCreationPage 클래스는 위자드 페이지에 포함된 정보를 검사하는 
		   validatePage()메소드를 가지고 있다. 그래서 이 메소드의 경우 부모가 가진 메소드에서
		    대부분을 처리하지만 처리 못하는 부분에 대해서 처리를 하기 위해서 작성된 일종의 랩퍼 함수라 
		    할 수 있다.
		*/
		protected boolean validatePage() {
			return super.validatePage() && validateFilename();
			
			//super.validatePage();
		    // 부모 메소드에서 처리하지 못하는 확장자에 대한 검사 실시

		}
	}
}
