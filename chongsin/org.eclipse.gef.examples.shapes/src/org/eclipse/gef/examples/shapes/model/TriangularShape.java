
package org.eclipse.gef.examples.shapes.model;

import org.eclipse.swt.graphics.Image;


public class TriangularShape extends Shape {
	/** A 16x16 pictogram of a rectangular shape. */
	private static final Image TRIANGLE_ICON = createImage("icons/rectangle16.gif");

	private static final long serialVersionUID = 1;

	public Image getIcon() {
		return TRIANGLE_ICON;
	}

	public String toString() {
		return "Triangle " + hashCode();
	}
}
