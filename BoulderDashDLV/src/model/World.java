package model;
import utility.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import javafx.scene.image.Image;

public class World {
	
	private Object [][] world;
	private Player player;
	
	
	public World(){
		this.world = new Object [this.getRow()][this.getColumn()];
	}	
	
	public World(int level) {
		this.world = new Object [this.getRow()][this.getColumn()];
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\cosmo\\git\\BoulderDashDLV\\BoulderDashDLV\\src\\res\\cazzo.txt"));
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
							this.world[cont][i] = new Empty(cont, i, this);
							break;
						case '1':
							this.world[cont][i] = new Ground(cont, i, this);
							break;
						case '2':
							this.world[cont][i] = new Stone(cont, i, this);
							break;
						case '3':
							this.world[cont][i] = new Wall(cont, i, this);
							break;
						case '4':
							this.world[cont][i] = new Diamond(cont, i, this);
							break;
						case '5':
							this.world[cont][i] = null; //new Enemy(cont, i, this);
							break;
						case '6':
							this.world[cont][i] = null; //new Door(cont, i, this);
							break;

					}
				}
				
			}
		this.player = new Player(0, 0, this); 
		
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
	
	public void draw () {
		Constants.context.drawImage( Constants.mappa,0, 0 );

	    for (int i = 0; i < getRow(); i++) {
	    	for (int j = 0; j < getColumn(); j++) {
	    		world[i][j].draw();
	    	}

	    }
	    player.draw();

	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void movePlayer(Direction dir) {
		switch (dir) {
		case UP:
			player.setRow(player.getRowIndex()-1);
			break;
		case DOWN:
			player.setRow(player.getRowIndex()+1);
			break;
		case LEFT:
			player.setColumn(player.getColumnIndex()-1);
			break;
		case RIGHT:
			player.setColumn(player.getColumnIndex()+1);
			break;
		case IDLE:
			break;
		}
		
	}
}
