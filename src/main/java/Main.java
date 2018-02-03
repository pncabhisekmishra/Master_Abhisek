import java.util.List;

import com.coordinator.util.NodeTree;
import com.coordinator.util.NodeUtil;
import com.cordinator.bean.Node;

public class Main {
	
	NodeTree<Node> data(NodeTree<Node> nodeTree){
		List<NodeTree<Node>> children = nodeTree.getChildren();
		NodeTree<Node> nnn = null;
		for (NodeTree<Node> nt : children) {
			nnn = nt;
			System.out.println("Child data: "+nt.getData());
		}
		data(nnn);
		return nodeTree;
		
	}

	public static void main(String[] args) {
		NodeUtil n = new NodeUtil();
		NodeTree<Node> nodeTree = n.getNodeTree();
		new Main().data(nodeTree);
	} 
}
