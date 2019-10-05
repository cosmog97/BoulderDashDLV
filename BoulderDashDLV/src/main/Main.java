package main;

import graphic.GameManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import utility.Constants;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();

		final Scene scene = new Scene(root, 1728, 864);
		Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
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
			@Override
			public void handle(long now) {
				game.runGame(scene);
			}

		}.start();

	}

	public static void main(String args[]) {
		launch(args);
	}
}