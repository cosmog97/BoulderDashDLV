package model;
import utility.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.image.Image;

public class World {
	
	private Object [][] world;

	
	
	public World(){
		this.world = new Object [this.getRow()][this.getColumn()];
	}	
	
	public World(int level) {
		this.world = new Object [this.getRow()][this.getColumn()];
		
		
		/*	Scanner s = null; 
			
			switch (level) {
				case 1:
					s = new Scanner(new File("levels/level01"));
					break;
				case 2:
					s = new Scanner(new File("levels/level02"));
					break;
				default:
					break;
			}
			int cont = 0;*/


			for (int cont = 0; cont < getRow(); cont++) {
			
				for (int i = 0; i < getColumn(); i++) {
						int val = 0;
						if (i == 15 && cont == 15) {
							val = 7;
						} else if (cont < 3 && i < 3) {
							val = 1;
						}
					
						switch (val) {
						case 0:
							this.world[cont][i] = new Empty(cont, i, this);
							break;
						case 1:
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
						case 7:
							this.world[cont][i] = new Player(cont, i, this); //new Door(cont, i, this);
							break;
					}
				}
				
			}
		
		
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

	}
}
