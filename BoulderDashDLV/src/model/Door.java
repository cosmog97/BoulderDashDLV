package model;

import utility.Constants;
import utility.Type;

public class Door extends Object {

	public Door(int row, int column) {
		super(row, column,Type.PORTA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.door, 288 + this.column * 48, this.row * 48);
	}

}
