package com.coordinator.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.cordinator.bean.Node;
import com.cordinator.bean.NodeCost;

public class MapReader {

	private static String resource = null;
	static {
		MapReader.resource = new StringBuilder().append(new File("").getAbsolutePath()).append("//")
				.append("src//main//resources").toString();
	}

	private Node startNode = null;
	private Node endNode = null;

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getEndNode() {
		return endNode;
	}

	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

	public List<Map<Integer, List<Map<Integer, Node>>>> read() {
		Stream<String> nodeStream = null;
		String line = null;
		List<Map<Integer, List<Map<Integer, Node>>>> nodeCoordinatorList = new ArrayList<Map<Integer, List<Map<Integer, Node>>>>();
		try {
			nodeStream = Files.lines(Paths.get(MapReader.resource + "//map.txt"));
			Iterator<String> lines = nodeStream.iterator();
			int y_Coordinate = 0;
			int x_Coordinate = 0;
			// Each line represents y coordinate.
			Map<Integer, List<Map<Integer, Node>>> nodeCoordinator = null;
			while (lines.hasNext()) {
				// Removing white space characters.
				line = lines.next().replaceAll("\\s+", "");
				nodeCoordinator = new HashMap<Integer, List<Map<Integer, Node>>>();

				// Each cell num represents x coordinate.
				List<Map<Integer, Node>> mapCellList = new ArrayList<Map<Integer, Node>>();
				for (x_Coordinate = 0; x_Coordinate < line.length(); x_Coordinate++) {
					char ch = line.charAt(x_Coordinate);
					Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
					if (Node.NodeType.START_NODE.equals(ch)) {
						this.setStartNode(new Node(x_Coordinate, y_Coordinate, ch));
					}
					if (Node.NodeType.END_NODE.equals(ch)) {
						this.setEndNode(new Node(x_Coordinate, y_Coordinate, ch));
					}
					nodeMap.put(x_Coordinate, new Node(x_Coordinate, y_Coordinate, ch));
					// finder.setxMax(x_Coordinate);
					mapCellList.add(nodeMap);
				}
				nodeCoordinator.put(y_Coordinate, mapCellList);
				nodeCoordinatorList.add(nodeCoordinator);
				y_Coordinate++;
				// finder.setyMax(y_Coordinate);
			}
			
			Node.setxMax(x_Coordinate);
			Node.setyMax(y_Coordinate);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (nodeStream != null) {
				nodeStream.close();
			}
		}
		return nodeCoordinatorList;
	}

	/*
	 * public static void main(String[] args) { new MapReader().read(); }
	 */
}
