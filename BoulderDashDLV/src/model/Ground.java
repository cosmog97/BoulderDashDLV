package model;

import utility.Constants;
import utility.Type;

public class Ground extends Object {

	public Ground(int row, int column, World world) {
		super(row, column, world, Type.TERRA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.ground, 288 + this.column * 48, this.row * 48);
		
	}

}
