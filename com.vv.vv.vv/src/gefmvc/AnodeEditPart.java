package gefmvc;


import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.graphics.Color;

public class AnodeEditPart extends AbstractGraphicalEditPart{

	
//	The figure's anchor
	private ChopboxAnchor m_anchor;
	
	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		
		System.out.println("Called HelloEditPart.createFigure()");
		IFigure rectangle = new RectangleFigure();
		//RectagleFigure에
		//draw2d 를 호출하여 사각형을 색칠한다.
		rectangle.setBackgroundColor(new Color(null,200,200,200));//alpha, R,,G,B
		m_anchor = new ChopboxAnchor(rectangle);
		
		return rectangle;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		System.out.println("Called HelloEditPart.createEditPoicies");
	}
	protected void refreshVishals(){
		NodeModel node = (NodeModel)getModel();
		//this is where the actual drawing is done
		//simply a rectagle with text
		
		Rectangle bounds = new Rectangle(50,50,50,50);
		getFigure().setBounds(bounds);
		Label label = new Label(node.getLabel());
		label.setTextAlignment(PositionConstants.CENTER);;
		label.setBounds(bounds.crop(IFigure.NO_INSETS));
		getFigure().add(label);
	}

	public void propertyChange(PropertyChangeEvent evt){
		
	}
	
	protected List getModelSourceConnections(){
		
		List sourceConnections = ((NodeModel)getModel()).getSourceConnections();
		return sourceConnections;
		
	}
	
	protected List getModelTargetConncetions(){
		
		List targetConnection  = ((NodeModel)getModel()).getTargetConnections();
		return targetConnections;
		
	}
	
	protected ConnectionEditPart createConnection(Object iModel) {
		NodeConnectionEditPart connectPart = (NodeConnectionEditPart) getRoot()
				.getViewer().getEditPartRegistry().get(iModel);
		if (connectPart == null) {
			connectPart = new NodeConnectionEditPart();
			connectPart.setModel(iModel);
		}
		return connectPart;
	}
}
