package model;

import utility.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class World {

	private Object[][] world;
	private Player player;
	private int contGemme = 0;
	private int maxGemme;
	private boolean win = false;
	private boolean die = false;

	public World() {
		this.world = new Object[this.getRow()][this.getColumn()];
	}

	public World(int level) {
		this.world = new Object[this.getRow()][this.getColumn()];
		BufferedReader reader = null;
		try {
			switch (level) {
			case 1:
				reader = new BufferedReader(
						new FileReader(Paths.get("").toAbsolutePath() + "\\src\\res\\level\\level01.txt"));
				break;
			case 2:
				reader = new BufferedReader(
						new FileReader(Paths.get("").toAbsolutePath() + "\\src\\res\\level\\level02.txt"));
				break;
			case 3:
				reader = new BufferedReader(
						new FileReader(Paths.get("").toAbsolutePath() + "\\src\\res\\level\\level03.txt"));
				break;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int cont = 0; cont < getRow(); cont++) {
			char[] line = null;
			try {
				line = reader.readLine().toCharArray();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < getColumn(); i++) {

				switch (line[i]) {
				case '0':
					this.world[cont][i] = new Empty(cont, i);
					break;
				case '1':
					this.world[cont][i] = new Ground(cont, i);
					break;
				case '2':
					this.world[cont][i] = new Stone(cont, i);
					break;
				case '3':
					this.world[cont][i] = new Wall(cont, i);
					break;
				case '4':
					this.world[cont][i] = new Diamond(cont, i);
					maxGemme++;
					break;
				case '5':
					this.world[cont][i] = null; // new Enemy(cont, i, this);
					break;
				case '6':
					this.world[cont][i] = null; // new Door(cont, i, this);
					break;

				}
			}

		}
		this.player = new Player(1, 0);
		this.world[1][0] = new Empty(1, 0);
	}

	public int getRow() {
		return Constants.altezza;
	}

	public int getColumn() {
		return Constants.lunghezza;
	}

	public Object getElement(int row, int column) {
		return this.world[row][column];
	}

	public void draw() {

		Constants.context.drawImage(Constants.mappa, 0, 0);
		Constants.context.strokeText("Gemme raccolte " + contGemme, 10, 50);
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getColumn(); j++) {
				world[i][j].draw();
			}

		}
		player.draw();

		
	}

	public boolean getWin() {
		return win;
	}
	public boolean getDie() {
		return die;
	}

	public void update() {
		if (contGemme == maxGemme) {
			win = true;
		}
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getColumn(); j++) {
				if (world[i][j] instanceof Stone) {
					if (world[i + 1][j] instanceof Empty
							&& !(player.getRowIndex() == i + 1 && player.getColumnIndex() == j)) {
						world[i + 1][j] = world[i][j];
						world[i + 1][j].setRow(i + 1);
						world[i][j] = new Empty(i, j);
						if(player.getRowIndex() == i + 2 && player.getColumnIndex() == j) {
							die = true;
						}
						
					}

					else if (world[i + 1][j] instanceof Stone && world[i][j - 1] instanceof Empty
							&& world[i + 1][j - 1] instanceof Empty) {
						world[i][j - 1] = world[i][j];
						world[i][j - 1].setColumn(j - 1);
						world[i][j] = new Empty(i, j);
					}

					else if (world[i + 1][j] instanceof Stone && world[i][j + 1] instanceof Empty
							&& world[i + 1][j + 1] instanceof Empty) {
						world[i][j + 1] = world[i][j];
						world[i][j + 1].setColumn(j + 1);
						world[i][j] = new Empty(i, j);
					}
				}
			}
		}
	}

	public void changeGround(int x, int y) {
		world[x][y] = new Empty(x, y);
	}

	public boolean moveWallorStone(int x, int y) {
		if (world[x][y] instanceof Wall) {
			return false;
		} else
			return true;
	}

	public void movePlayer(Direction dir) {
		switch (dir) {
		case UP:
			if (player.canWalk(dir) && moveWallorStone(player.getRowIndex() - 1, player.getColumnIndex())) {
				if(world[player.getRowIndex() - 1][player.getColumnIndex()] instanceof Empty) {
					player.setRow(player.getRowIndex() - 1);
				}
				else if (world[player.getRowIndex() - 1][player.getColumnIndex()] instanceof Ground) {
					changeGround(player.getRowIndex() - 1, player.getColumnIndex());
					player.setRow(player.getRowIndex() - 1);
				} else if (world[player.getRowIndex() - 1][player.getColumnIndex()] instanceof Diamond) {
					changeGround(player.getRowIndex() - 1, player.getColumnIndex());
					contGemme++;
					player.setRow(player.getRowIndex() - 1);
				}
			}
			break;
		case DOWN:
			if (player.canWalk(dir) && moveWallorStone(player.getRowIndex() + 1, player.getColumnIndex())) {
				if(world[player.getRowIndex() + 1][player.getColumnIndex()] instanceof Empty) {
					player.setRow(player.getRowIndex() + 1);
				}
				else if (world[player.getRowIndex() + 1][player.getColumnIndex()] instanceof Ground) {
					changeGround(player.getRowIndex() + 1, player.getColumnIndex());
					player.setRow(player.getRowIndex() + 1);
				} else if (world[player.getRowIndex() + 1][player.getColumnIndex()] instanceof Diamond) {
					changeGround(player.getRowIndex() + 1, player.getColumnIndex());
					contGemme++;
					player.setRow(player.getRowIndex() + 1);
				}
			}

			break;
		case LEFT:
			if (player.canWalk(dir) && moveWallorStone(player.getRowIndex(), player.getColumnIndex() - 1)) {
				if(world[player.getRowIndex()][player.getColumnIndex()-1] instanceof Empty) {
					player.setColumn(player.getColumnIndex() - 1);
				}
				else if (world[player.getRowIndex()][player.getColumnIndex() - 1] instanceof Ground) {
					changeGround(player.getRowIndex(), player.getColumnIndex() - 1);
					player.setColumn(player.getColumnIndex() - 1);
				} else if (world[player.getRowIndex()][player.getColumnIndex() - 1] instanceof Diamond) {
					changeGround(player.getRowIndex(), player.getColumnIndex() - 1);
					contGemme++;
					player.setColumn(player.getColumnIndex() - 1);
				} else if (world[player.getRowIndex()][player.getColumnIndex() - 1] instanceof Stone
						&& world[player.getRowIndex()][player.getColumnIndex() - 2] instanceof Empty) {
					System.out.println("Entrato L");
					world[player.getRowIndex()][player.getColumnIndex()
							- 2] = world[player.getRowIndex()][player.getColumnIndex() - 1];
					world[player.getRowIndex()][player.getColumnIndex() - 2].setColumn(player.getColumnIndex() - 2);
					world[player.getRowIndex()][player.getColumnIndex() - 1] = new Empty(player.getRowIndex(),
							player.getColumnIndex() - 1);
					player.setColumn(player.getColumnIndex() - 1);
				}
			}

			break;
		case RIGHT:
			if (player.canWalk(dir) && moveWallorStone(player.getRowIndex(), player.getColumnIndex() + 1)) {
				if(world[player.getRowIndex()][player.getColumnIndex()+1] instanceof Empty) {
					player.setColumn(player.getColumnIndex() + 1);
				}
				else if (world[player.getRowIndex()][player.getColumnIndex() + 1] instanceof Ground) {
					changeGround(player.getRowIndex(), player.getColumnIndex() + 1);
					player.setColumn(player.getColumnIndex() + 1);

				} else if (world[player.getRowIndex()][player.getColumnIndex() + 1] instanceof Diamond) {
					changeGround(player.getRowIndex(), player.getColumnIndex() + 1);
					contGemme++;
					player.setColumn(player.getColumnIndex() + 1);

				} else if (world[player.getRowIndex()][player.getColumnIndex() + 1] instanceof Stone
						&& world[player.getRowIndex()][player.getColumnIndex() + 2] instanceof Empty) {
					System.out.println("Entrato R");
					world[player.getRowIndex()][player.getColumnIndex()
							+ 2] = world[player.getRowIndex()][player.getColumnIndex() + 1];
					world[player.getRowIndex()][player.getColumnIndex() + 2].setColumn(player.getColumnIndex() + 2);
					world[player.getRowIndex()][player.getColumnIndex() + 1] = new Empty(player.getRowIndex(),
							player.getColumnIndex() + 1);
					player.setColumn(player.getColumnIndex() + 1);
				}
			}

			break;
		}

	}
}
