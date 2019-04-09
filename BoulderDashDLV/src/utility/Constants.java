package utility;

import java.io.File;
import java.io.FileReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Constants {
	public static int dimX = 48;
	public static int dimY = 48;
	public static int lunghezza = 30;
	public static int altezza = 18;
	public static GraphicsContext context;
	public static Image mappa = new Image ("res/mappa.png");
	public static Image bgmenu = new Image ("res/bgmenu.png");
	public static Image buttonplay = new Image ("res/buttons.png");
	public static Image wall = new Image ("res/wall.png");
	public static Image ground = new Image ("res/ground.png");
	public static Image player = new Image ("res/player.png");
	public static Image stone = new Image ("res/stone.png");
}
