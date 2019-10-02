package main;

import utility.Constants;



import graphic.GameManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Main extends Application { 
   @Override     
   public void start(Stage primaryStage) throws Exception {            
	   Group root = new Group();
	   
	   final Scene scene = new Scene(root, 1728, 864);
	   Canvas canvas = new Canvas(scene.getWidth(),scene.getHeight());
	   Constants.context = canvas.getGraphicsContext2D();
	   root.getChildren().add(canvas);
	   primaryStage.setTitle("BoulderDashDLV");
	   primaryStage.getIcons().add(Constants.icon);
	  
	   primaryStage.setResizable(false);

	   primaryStage.setScene(scene);
	   primaryStage.centerOnScreen();
	   primaryStage.show();
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

/*333333333333333333333333333333
311113144113111113111113111413
311113111113111113111113122223
311113111113111113111113111113
333312133311133312233311133313
311113111113111113112213111113
322213144113111113114113111413
344113111113122213111113111113
311113111113111113111113111113
333311133311133311133321133313
311113111113222113111113111113
311113111113114113111113111113
311213114113122213111113111113
311113111113111113111113111113
333311133311133311133312233313
314113111113111113111113111113
311223111113112113111413111413
333333333333333333333333333333*/