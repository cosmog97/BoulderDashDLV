package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class LevelSceneDLV implements GameScene {

	protected SceneManager manager;
	protected boolean uno;
	protected boolean due;
	protected boolean tre;
	protected boolean random;
	protected boolean indietro;

	public LevelSceneDLV(SceneManager manager) {
		this.manager = manager;
		this.uno = false;
		this.due = false;
		this.tre = false;
		this.random = false;
		this.indietro = false;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.bglevels, 0, 0);
		if (indietro) {
			Constants.context.drawImage(Constants.indietro_on, 714, 750);
		} else {
			Constants.context.drawImage(Constants.indietro, 714, 750);
		}

		if (uno) {
			Constants.context.drawImage(Constants.liv_uno_on, 214, 380);
		} else {
			Constants.context.drawImage(Constants.liv_uno, 214, 380);
		}
		if (due) {
			Constants.context.drawImage(Constants.liv_due_on, 714, 380);
		} else {
			Constants.context.drawImage(Constants.liv_due, 714, 380);
		}
		if (tre) {
			Constants.context.drawImage(Constants.liv_tre_on, 1214, 380);
		} else {
			Constants.context.drawImage(Constants.liv_tre, 1214, 380);
		}

	}

	@Override
	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {

				if (arg0.getX() >= 214 && arg0.getX() <= (214 + Constants.liv_uno.getWidth()) && arg0.getY() >= 380
						&& arg0.getY() <= (380 + Constants.liv_uno.getHeight())
						&& manager.getGameScene() instanceof LevelSceneDLV) {
					// manager.switchToPlay();
					uno = true;
				} else {
					uno = false;
				}

				if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.liv_uno.getWidth()) && arg0.getY() >= 380
						&& arg0.getY() <= (380 + Constants.liv_uno.getHeight())
						&& manager.getGameScene() instanceof LevelSceneDLV) {
					// manager.switchToPlay();
					due = true;
				} else {
					due = false;
				}

				if (arg0.getX() >= 1214 && arg0.getX() <= (1214 + Constants.liv_uno.getWidth()) && arg0.getY() >= 380
						&& arg0.getY() <= (380 + Constants.liv_uno.getHeight())
						&& manager.getGameScene() instanceof LevelSceneDLV) {
					// manager.switchToPlay();
					tre = true;
				} else {
					tre = false;
				}

				if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.indietro.getWidth()) && arg0.getY() >= 750
						&& arg0.getY() <= (750 + Constants.indietro.getHeight())
						&& manager.getGameScene() instanceof LevelSceneDLV) {
					indietro = true;
				} else {
					indietro = false;
				}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if (arg0.getX() >= 214 && arg0.getX() <= (214 + Constants.liv_uno.getWidth()) && arg0.getY() >= 380
							&& arg0.getY() <= (380 + Constants.liv_uno.getHeight())
							&& manager.getGameScene() instanceof LevelSceneDLV) {
						manager.switchToPlayDLV(1);
					}

					if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.liv_uno.getWidth()) && arg0.getY() >= 380
							&& arg0.getY() <= (380 + Constants.liv_uno.getHeight())
							&& manager.getGameScene() instanceof LevelSceneDLV) {
						manager.switchToPlayDLV(2);
					}

					if (arg0.getX() >= 1214 && arg0.getX() <= (1214 + Constants.liv_uno.getWidth())
							&& arg0.getY() >= 380 && arg0.getY() <= (380 + Constants.liv_uno.getHeight())
							&& manager.getGameScene() instanceof LevelSceneDLV) {
						manager.switchToPlayDLV(3);
					}

					if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.indietro.getWidth()) && arg0.getY() >= 750
							&& arg0.getY() <= (750 + Constants.indietro.getHeight())
							&& manager.getGameScene() instanceof LevelSceneDLV) {
						manager.switchToMenu();
					}
				}
			}
		});
	}

}