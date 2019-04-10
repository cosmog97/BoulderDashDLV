package model;

import utility.Constants;
import utility.Type;

public class Diamond extends Object {

	public Diamond(int row, int column, World world) {
		super(row, column, world,Type.DIAMANTI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.diamond, 288 + this.column * 48, this.row * 48);
	}

}
