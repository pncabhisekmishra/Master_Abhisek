package com.coordinator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coordinator.io.MapReader;
import com.cordinator.bean.Node;

public class NodeUtil {

	private static List<Map<Integer, List<Map<Integer, Node>>>> nodeList;
	private Node startNode;
	public NodeTree<Node> getNodeTree() {
		MapReader reader = new MapReader();
		nodeList = reader.read();
		startNode = reader.getStartNode();
		return NodeUtil.findChild(new NodeTree<Node>(startNode));
	}
	
	private Node getNode(Integer xCord, Integer yCord) {
		Node node = null;
			for (int index = 0; index < nodeList.size(); index++) {
				Map<Integer, List<Map<Integer, Node>>> nodeCoordinateMap = nodeList.get(index);
				for (Integer key : nodeCoordinateMap.keySet()) {
					List<Map<Integer, Node>> nodes = nodeCoordinateMap.get(key);
					for (int idx = 0; idx < nodes.size(); idx++) {
						Map<Integer, Node> nodeMap = nodes.get(idx);
						for (Integer k : nodeMap.keySet()) {
							Node _node = nodeMap.get(k);
							if (xCord.equals(_node.getX()) && yCord.equals(_node.getY())) {
								node = _node;
							}
						}
					}
				}
			}
		return node;
	}

	private static NodeTree<Node> findChild(NodeTree<Node> nodeTree) {
		
		int x = nodeTree.getData().getX();
		int y = nodeTree.getData().getY();

		int x1 = nodeTree.getData().getX() - 1;
		int x2 = nodeTree.getData().getX() + 1; 
		int y1 = nodeTree.getData().getY() - 1;
		int y2 = nodeTree.getData().getY() + 1;
		List<NodeTree<Node>> childrenNodes = new ArrayList<NodeTree<Node>>();
		
		nodeTree.getData().setIsVisited(true);
		if (x1 >= 0) { 
			Node n = new NodeUtil().getNode(x1, y);
			//System.out.println("Left-Node"+n);
			if (!n.isObstracle()  &&  ! n.getIsVisited()) {
				n.setIsVisited(true);
				childrenNodes.add(nodeTree.addChild(new NodeTree<Node>(n)));
			}
		} //Left
		if (x2 < Node.getxMax()) {
			Node n = new NodeUtil().getNode(x2, y);
			//System.out.println("Right-Node"+n);
			if (!n.isObstracle()  &&  ! n.getIsVisited()) {
				n.setIsVisited(true);
				childrenNodes.add(nodeTree.addChild(new NodeTree<Node>(n)));
			}
		} //Right
		if (y1 >= 0) {
			Node n = new NodeUtil().getNode(x, y1);
			//System.out.println("Bottom-Node: "+n);
			if (!n.isObstracle()  &&  ! n.getIsVisited()) { 
				n.setIsVisited(true);
				childrenNodes.add(nodeTree.addChild(new NodeTree<Node>(n)));
			} 
		} //Bottom
		if (y2 < Node.getyMax()) {
			Node n = new NodeUtil().getNode(x, y2);
			//System.out.println("Top-Node: "+n);
			if (!n.isObstracle()  &&  ! n.getIsVisited()) {
				n.setIsVisited(true);
				childrenNodes.add(nodeTree.addChild(new NodeTree<Node>(n)));
			} 
		} //Top
		if (childrenNodes.size() > 0) {
			for (int idx = 0; idx < childrenNodes.size(); idx++) {
				NodeTree<Node> n = childrenNodes.get(idx);
				findChild(n);
			}
		}
		
		return nodeTree;
	}

}
