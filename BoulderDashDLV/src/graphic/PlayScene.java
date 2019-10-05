
package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.World;
import utility.Constants;
import utility.Direction;

public class PlayScene implements GameScene {

	protected SceneManager manager;
	private World world;
	private int level;
	private boolean indietroOn = false;

	public PlayScene(SceneManager sceneManager, int level) {
		this.manager = sceneManager;
		this.level = level;
		this.world = new World(this.level);
	}

	@Override
	public void update() {
		world.update();
		if (world.getWin()) {
			manager.switchToVittoria(level);
		}
		if (world.getDie()) {
			manager.switchToDie(level);
		}
	}

	@Override
	public void draw() {
		world.draw();
		if (indietroOn) {
			Constants.context.drawImage(Constants.indietroplay_on, 19, 720);
		} else {
			Constants.context.drawImage(Constants.indietroplay, 19, 720);
		}
	}

	@Override
	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				if (arg0.getX() >= 19 && arg0.getX() <= (19 + Constants.indietroplay_on.getWidth())
						&& arg0.getY() >= 720 && arg0.getY() <= (720 + Constants.indietroplay_on.getHeight())
						&& manager.getGameScene() instanceof PlayScene) {
					// manager.switchToPlay();
					indietroOn = true;
				} else {
					indietroOn = false;
				}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if (arg0.getX() >= 19 && arg0.getX() <= (19 + Constants.indietroplay_on.getWidth())
							&& arg0.getY() >= 720 && arg0.getY() <= (720 + Constants.indietroplay_on.getHeight())
							&& manager.getGameScene() instanceof PlayScene) {
						manager.switchToLevels();
					}
				}
			}
		});
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {

				switch (arg0.getCode()) {
				case UP:
					world.movePlayer(Direction.UP);
					break;
				case DOWN:
					world.movePlayer(Direction.DOWN);
					break;
				case LEFT:
					world.movePlayer(Direction.LEFT);
					break;
				case RIGHT:
					world.movePlayer(Direction.RIGHT);
					break;
				default:
					break;
				}

			}

		});
	}

}