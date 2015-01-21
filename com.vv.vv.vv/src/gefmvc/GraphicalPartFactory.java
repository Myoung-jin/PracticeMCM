package gefmvc;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
 
public class GraphicalPartFactory implements EditPartFactory {
 
	public EditPart createEditPart(EditPart iContext, Object iModel) {
		System.out.println("Called GraphicalPartFactory.createEditPart("
				+ iContext + "," + iModel + ")");
 
		EditPart editPart = null;
		if (iModel instanceof Model) {
			editPart = new TopEditPart();
		} else if (iModel instanceof NodeModel) {
			editPart = new AnodeEditPart();
		}
 
		if (editPart != null) {
			editPart.setModel(iModel);
		}
		return editPart;
	}
}