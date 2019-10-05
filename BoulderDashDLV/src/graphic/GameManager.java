package graphic;

import javafx.scene.Scene;
import utility.Constants;

public class GameManager {

	private SceneManager manager;

	public GameManager() {
		manager = new SceneManager();
	}

	public void runGame(Scene scene) {
		update();
		draw();
		handleEvent(scene);
	}

	private void update() {
		manager.update();
	}

	private void draw() {
		manager.draw(Constants.context);
	}

	private void handleEvent(Scene scene) {
		manager.handleEvent(scene);
	}

}