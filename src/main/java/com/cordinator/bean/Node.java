package com.cordinator.bean;

public class Node {

	private int x;
	private int y;
	private boolean isObstracle;
	private boolean isVisited ;
	private Character character;
	private static int xMax;
	private static int yMax;

	public Node() {
	}

	public interface NodeType {
		public static final Character OPEN_NODE = '.';
		public static final Character START_NODE = 'S';
		public static final Character END_NODE = 'E';
		public static final Character WRONG_NODE = 'W';
		public static final Character VISITED_NODE = '"';
	}

	public Node(int x, int y, boolean isObstracle) {
		this.x = x;
		this.y = y;
		this.isObstracle = isObstracle;
	}

	public Node(int x, int y, Character character) {
		this.x = x;
		this.y = y;
		if (character != null) {
			if (Node.NodeType.OPEN_NODE.equals(character)) {
				this.isObstracle = false;
				this.character = character;
			}
			if (Node.NodeType.END_NODE.equals(character)) {
				this.isObstracle = false;
				this.character = character;
			}
			if (Node.NodeType.START_NODE.equals(character)) {
				this.isObstracle = false;
				this.character = character;
			}
			if (Node.NodeType.WRONG_NODE.equals(character)) {
				this.isObstracle = true;
				this.character = character;
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isObstracle() {
		return isObstracle;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void setObstracle(boolean isObstracle) {
		this.isObstracle = isObstracle;
	}

	public boolean getIsVisited() {
		return isVisited;
	}

	public void setIsVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public static int getxMax() {
		return xMax;
	}

	public static void setxMax(int xMax) {
		Node.xMax = xMax;
	}

	public static int getyMax() {
		return yMax;
	}

	public static void setyMax(int yMax) {
		Node.yMax = yMax;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", isObstracle=" + isObstracle + ", isVisited=" + isVisited
				+ ", character=" + character + "]";
	}
}
