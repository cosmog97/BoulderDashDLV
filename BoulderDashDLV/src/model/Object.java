package model;

import utility.Type;

public abstract class Object {

	protected int row;
	protected int column;
	protected Type t;

	public Object(int row, int column, Type t) {
		this.row = row;
		this.column = column;
		this.t = t;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRowIndex() {
		return this.row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getColumnIndex() {
		return this.column;
	}

	public abstract void update();

	public abstract void draw();
}