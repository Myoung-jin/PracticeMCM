package gefmvc;

import java.util.ArrayList;
import java.util.List;
public class NodeModel {
	 
	private List<NodeConnectionModel> sourceConnections = new ArrayList<NodeConnectionModel>();
	private List<NodeConnectionModel> targetConnections = new ArrayList<NodeConnectionModel>();
 
	public NodeModel(String s) {
		label = s;
	}
 
	public String getLabel() {
		return label;
	}
 
 
	private final String label;
 
 
	public List<NodeConnectionModel> getSourceConnections() {
		return sourceConnections;
	}
 
	public List<NodeConnectionModel> getTargetConnections() {
		return targetConnections;
	}
 
	public void addSourceConnection(NodeConnectionModel iConnection) {
		sourceConnections.add(iConnection);
	} 
 
	public void addTargetConnection(NodeConnectionModel iConnection) {
		targetConnections.add(iConnection);
	}
}
