package model;
import utility.Constants;
import utility.Type;

public class Stone extends Object{

	public Stone(int cont, int i, World world) {
		super(cont,i,world,Type.SASSI);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Constants.context.drawImage(Constants.stone, 288 + this.column * 48, this.row * 48);
	}

}
