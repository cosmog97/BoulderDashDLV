package model;

import utility.Constants;
import utility.Type;

public class Closer extends Object {

	public Closer(int row, int column) {
		super(row, column,Type.DIAMANTI);
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
