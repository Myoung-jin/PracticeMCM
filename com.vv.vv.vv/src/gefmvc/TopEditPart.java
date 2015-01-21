package gefmvc;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class TopEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		//루트 피겨 설정
		//FreeformLayout은 xyLayout을 상속 받는다 시작 위치를 0,0으로 지정한것 외에는 xyLayout과 별반 다르지 않다.
		//XYLayout은 자유롭게 배치가 가능한 Layout이다.
		
		Figure f = new FreeformLayer();
		
		f.setLayoutManager(new FreeformLayout());//레이아웃을 FreeFormLayout으로 설정
		//Layout은 화면에 보여질 배치를 지정
		//즉 다이어 그램이 가지고 있는 child Model들을 배치해서 지정하게 된다.
		
		f.setBorder(new MarginBorder(1));//Border를 1로 설정
		//Create a layout for the graphical screen
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;//행을 3으로 설정한다.
		gridLayout.horizontalSpacing = 40;//수평간격을 40으로 설정
		gridLayout.verticalSpacing = 40;
		gridLayout.marginHeight = 20;//높이 여백을 20으로 한다.
		gridLayout.marginWidth = 20;
		f.setLayoutManager(gridLayout);//레이아웃에 gridLayout포함
		f.setOpaque(true);//투명도 설정
		return f;
		
		
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}
	protected List<NodeModel> getModelChildren(){
		List<NodeModel> children = ((Model)getModel()).getNodes();
		return children;
		
	}

}
