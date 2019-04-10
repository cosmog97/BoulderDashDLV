package model;

import utility.Constants;
import utility.Type;

public class Empty extends Object {

	public Empty(int row, int column) {
		super(row, column, Type.VUOTO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Constants.context.drawImage(null , 288 + this.column * 48, this.row * 48);
		
	}
	

}
