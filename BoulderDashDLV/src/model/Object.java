package model;

import utility.Type;

public abstract class Object {
	
	protected int row; //posizione colonna
	protected int column; //posizione riga
	protected World world;
	protected Type t;
	
	public Object(int row, int column, World world, Type t) {
		this.row = row;
		this.column = column;
		this.world = world;
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
	
	public World getWorld() {
		return this.world;
	}
	
	public abstract void update();
	
	public abstract void draw();
}