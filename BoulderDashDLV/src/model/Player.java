package model;

import javafx.scene.image.Image;
import utility.Constants;
import utility.Direction;
import utility.Type;
public class Player extends Object {


	public Player(int row, int column) {
		super(row, column, Type.PLAYER);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.player, 288 + this.column * 48, this.row * 48);
	}

	public boolean canWalk(Direction dir) {
		switch (dir) {
		case UP:
			if (row -1 >= 0) {
				return true;
			}
			break;
		case DOWN:
			if (row + 1 < Constants.altezza) {
				return true;
			}

			break;
		case LEFT:
			if (column -1 >= 0) {
				return true;
			}

			break;
		case RIGHT:
			if (column +1 < Constants.lunghezza) {
				return true;
			}
			break;
		}
		return false;
	}


}
