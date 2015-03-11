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

//palette는 Draw2D영역이아닌 swt영역이다. 
//Canvas에 Widget 개체가 올라가서 pallete를 구성한다.

public class FlowEditorPaletteFactory {

	private static List createCategories(PaletteRoot root) {
		List categories = new ArrayList();
		categories.add(createControlGroup(root));	//control 집합 을 먼저놓고(얘는 root요소가 필요하다.)
		categories.add(createComponentsDrawer());	//component 집합을 넣겠다.
		return categories;
	}
	
	//Componet를 생성해주는 녀석이다.(여기선 PaletteDrawer=접히거나 펼쳐진 공간을 가짐)
	private static PaletteContainer createComponentsDrawer() {	

		PaletteDrawer drawer = new PaletteDrawer("Components", null);//팔레트 Components요소를 작성한다.

		List entries = new ArrayList();//리스트구조 작성.

		CombinedTemplateCreationEntry combined = new CombinedTemplateCreationEntry(
				"Activity", "Create a new Activity Node", Activity.class,
				new SimpleFactory(Activity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/gear16.gif"), ImageDescriptor.createFromFile(
						Activity.class, "images/gear16.gif"));//Component 속 Activity항목을 추가한다.
		entries.add(combined);//entries(리스트 변수)에 생성한 Activity 정보를 집어넣는다.

		combined = new CombinedTemplateCreationEntry("Sequential Activity",
				"Create a Sequential Activity", SequentialActivity.class,
				new SimpleFactory(SequentialActivity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/sequence16.gif"),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/sequence16.gif"));
		entries.add(combined);//Activity와 과정이 같다.

		combined = new CombinedTemplateCreationEntry("Parallel Activity",
				"Create a  Parallel Activity", ParallelActivity.class,
				new SimpleFactory(ParallelActivity.class),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/parallel16.gif"),
				ImageDescriptor.createFromFile(FlowPlugin.class,
						"images/parallel16.gif"));
		entries.add(combined);//Activity와 과정이 같다.


		drawer.addAll(entries);//drawer변수는 Componets를 생성한 PaletteDrawer 타입임을 읻지말자.
		return drawer;
	}
	
	//마찬가지로 Control그룹을 생성한다.(여기선 PaletteGroup=목록을 그대로 보여주는 역할)
	private static PaletteContainer createControlGroup(PaletteRoot root) {
		PaletteGroup controlGroup = new PaletteGroup("Control Group");

		List entries = new ArrayList();

		ToolEntry tool = new SelectionToolEntry();//select 요소를 생성한다.
		entries.add(tool);
		root.setDefaultEntry(tool);//root를 사용하는 이유이다.

		tool = new MarqueeToolEntry();//marquee 요소를 생성한다.
		entries.add(tool);
		//위에 두녀석(select,marqee) 밑에 줄로 separate한다.
		PaletteSeparator sep = new PaletteSeparator(
				"org.eclipse.gef.examples.flow.flowplugin.sep2");
		sep.setUserModificationPermission(PaletteEntry.PERMISSION_NO_MODIFICATION);
		entries.add(sep);

		tool = new ConnectionCreationToolEntry("Connection Creation",
				"Creating connections", null, ImageDescriptor.createFromFile(
						FlowPlugin.class, "images/connection16.gif"),	//class 정보를 다 포함한다.
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
