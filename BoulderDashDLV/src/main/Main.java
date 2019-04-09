package main;

import utility.Constants;

import java.io.BufferedReader;
import java.io.FileReader;

import graphic.GameManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color; 
import javafx.stage.Stage;
import model.World;  

public class Main extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {            
	   Group root = new Group();
	   
	   final Scene scene = new Scene(root, 1728, 864);
	   Canvas canvas = new Canvas(scene.getWidth(),scene.getHeight());
	   Constants.context = canvas.getGraphicsContext2D();
	   root.getChildren().add(canvas);
	   primaryStage.setTitle("BoulderDashDLV");
	   primaryStage.show();
	   primaryStage.centerOnScreen();
	   primaryStage.setScene(scene);
	   final GameManager game = new GameManager();
		
		new AnimationTimer() {
			public void handle(long now) {
				game.runGame(scene);
			}
				
		}.start();
           
   }    
   public static void main(String args[]){          
      launch(args);     
   }         
}