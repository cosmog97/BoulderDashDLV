package model;

import utility.Constants;
import utility.Type;

public class Wall extends Object {

	public Wall(int row, int column, World world) {
		super(row, column, world,Type.MURO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Constants.context.drawImage(Constants.wall, 288 + this.column * 48, this.row * 48);
	}

}
