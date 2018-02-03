package com.cordinator.bean;

public class NodeCost {
	
	/**f= g + h*/
	private float f;
	/**g = the movement cost to move from the starting point to a given square on the grid,*/
	private float g;
	/** the estimated movement cost to move from that given square on the grid to the final destination
	 * h= abs (current_cell.x – goal.x) + abs (current_cell.y – goal.y) */
	private float h;

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public NodeCost() {
	}

}
