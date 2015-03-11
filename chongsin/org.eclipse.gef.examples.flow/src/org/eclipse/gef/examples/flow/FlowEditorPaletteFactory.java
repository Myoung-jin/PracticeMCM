/*******************************************************************************
 * Copyright (c) 2003, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gef.examples.flow;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.examples.flow.model.Activity;
import org.eclipse.gef.examples.flow.model.ParallelActivity;
import org.eclipse.gef.examples.flow.model.SequentialActivity;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Handles the creation of the palette for the Flow Editor.
 * 
 * @author Daniel Lee
 */

//palette�� Draw2D�����̾ƴ� swt�����̴�. 
//Canvas�� Widget ��ü�� �ö󰡼� pallete�� �����Ѵ�.

public class FlowEditorPaletteFactory {

	private static List createCategories(PaletteRoot root) {
		List categories = new ArrayList();
		categories.add(createControlGroup(root));	//control ���� �� ��������(��� root��Ұ� �ʿ��ϴ�.)
		categories.add(createComponentsDrawer());	//component ������ �ְڴ�.
		return categories;
	}
	
	//Componet�� �������ִ� �༮�̴�.(���⼱ PaletteDrawer=�����ų� ������ ������ ����)
	private static PaletteContainer createComponentsDrawer() {	

		PaletteDrawer drawer = new PaletteDrawer("Components", null);//�ȷ�Ʈ Components��Ҹ� �ۼ��Ѵ�.

		List entries = new ArrayList();//����Ʈ���� �ۼ�.

		CombinedTemplateCreationEntry combined = new CombinedTemplateCreationEntry(
				"Activity", "Create a new Activity Node", Activity.class,
				new SimpleFactory(Activity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/gear16.gif"), ImageDescriptor.createFromFile(
						Activity.class, "images/gear16.gif"));//Component �� Activity�׸��� �߰��Ѵ�.
		entries.add(combined);//entries(����Ʈ ����)�� ������ Activity ������ ����ִ´�.

		combined = new CombinedTemplateCreationEntry("Sequential Activity",
				"Create a Sequential Activity", SequentialActivity.class,
				new SimpleFactory(SequentialActivity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/sequence16.gif"),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/sequence16.gif"));
		entries.add(combined);//Activity�� ������ ����.

		combined = new CombinedTemplateCreationEntry("Parallel Activity",
				"Create a  Parallel Activity", ParallelActivity.class,
				new SimpleFactory(ParallelActivity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/parallel16.gif"),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/parallel16.gif"));
		entries.add(combined);//Activity�� ������ ����.


		drawer.addAll(entries);//drawer������ Componets�� ������ PaletteDrawer Ÿ������ ��������.
		return drawer;
	}
	
	//���������� Control�׷��� �����Ѵ�.(���⼱ PaletteGroup=����� �״�� �����ִ� ����)
	private static PaletteContainer createControlGroup(PaletteRoot root) {
		PaletteGroup controlGroup = new PaletteGroup("Control Group");

		List entries = new ArrayList();

		ToolEntry tool = new SelectionToolEntry();//select ��Ҹ� �����Ѵ�.
		entries.add(tool);
		root.setDefaultEntry(tool);//root�� ����ϴ� �����̴�.

		tool = new MarqueeToolEntry();//marquee ��Ҹ� �����Ѵ�.
		entries.add(tool);
		//���� �γ༮(select,marqee) �ؿ� �ٷ� separate�Ѵ�.
		PaletteSeparator sep = new PaletteSeparator(
				"org.eclipse.gef.examples.flow.flowplugin.sep2");
		sep.setUserModificationPermission(PaletteEntry.PERMISSION_NO_MODIFICATION);
		entries.add(sep);

		tool = new ConnectionCreationToolEntry("Connection Creation",
				"Creating connections", null, ImageDescriptor.createFromFile(
						FlowPlugin.class, "images/connection16.gif"),	//class ������ �� �����Ѵ�.
				ImageDescriptor.createFromFile(Activity.class,
						"images/connection16.gif"));
		entries.add(tool);
		controlGroup.addAll(entries);
		return controlGroup;
	}

	/**
	 * Creates the PaletteRoot and adds all Palette elements.
	 * 
	 * @return the root
	 */
	public static PaletteRoot createPalette() {			//
		PaletteRoot flowPalette = new PaletteRoot();
		flowPalette.addAll(createCategories(flowPalette));
		return flowPalette;
	}

}
