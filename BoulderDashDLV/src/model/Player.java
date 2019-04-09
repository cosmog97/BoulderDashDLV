package model;

import javafx.scene.image.Image;
import utility.Constants;
import utility.Direction;
import utility.Type;
public class Player extends Object {

	
	private Direction direction;
	private Image player;
	
	public Player(int row, int column, World world) {
		super(row, column, world, Type.PLAYER);
		this.direction = Direction.IDLE;
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.player, 288 + this.column * 48, this.row * 48);
	}
	
	public void walk(Direction dir) {
		if (dir == Direction.UP) {
			if (this.column - 1 >= 0) {
				this.column -= 1;
			}
		}
		else if (dir == Direction.DOWN) {
			if (this.column + 1 < world.getColumn()) {
				this.column += 1;
			}
		}
		else if (dir == Direction.LEFT) {
			if (this.row - 1 >= 0 ) {
				this.row -= 1;
			}
		}
		else if (dir == Direction.RIGHT) {
			if (this.row + 1 < world.getRow()) {
				this.row += 1;
			}
		}
		this.direction = dir;
	}

}
