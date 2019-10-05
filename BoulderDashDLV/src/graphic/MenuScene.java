
package graphic;

import interfaces.GameScene;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class MenuScene implements GameScene {

	protected SceneManager manager;
	protected boolean playerOn;
	protected boolean dlvOn;
	protected boolean esciOn;

	public MenuScene(SceneManager manager) {
		this.manager = manager;
		this.dlvOn = false;
		this.playerOn = false;
		this.esciOn = false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.bgmenu, 0, 0);
		Constants.context.drawImage(Constants.credits, 1300, 780);
		if (playerOn) {
			Constants.context.drawImage(Constants.buttonplayer_on, 256, 540);
		} else {
			Constants.context.drawImage(Constants.buttonplayer, 256, 540);
		}
		if (dlvOn) {
			Constants.context.drawImage(Constants.buttondlv_on, 256, 650);
		} else {
			Constants.context.drawImage(Constants.buttondlv, 256, 650);
		}
		if (esciOn) {
			Constants.context.drawImage(Constants.esci_on, 1172, 595);
		} else {
			Constants.context.drawImage(Constants.esci, 1172, 595);
		}
	}

	@Override
	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {

				if (arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) && arg0.getY() >= 540
						&& arg0.getY() <= (540 + Constants.buttonplayer.getHeight())
						&& manager.getGameScene() instanceof MenuScene) {
					// manager.switchToPlay();
					playerOn = true;
				} else {
					playerOn = false;
				}

				if (arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) && arg0.getY() >= 650
						&& arg0.getY() <= (650 + Constants.buttonplayer.getHeight())
						&& manager.getGameScene() instanceof MenuScene) {
					// manager.switchToPlay();
					dlvOn = true;
				} else {
					dlvOn = false;
				}
				if (arg0.getX() >= 1172 && arg0.getX() <= (1172 + Constants.buttonplayer.getWidth())
						&& arg0.getY() >= 628 && arg0.getY() <= (628 + Constants.buttonplayer.getHeight())
						&& manager.getGameScene() instanceof MenuScene) {
					esciOn = true;

				} else {
					esciOn = false;
				}

			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if (arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth())
							&& arg0.getY() >= 540 && arg0.getY() <= (540 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						manager.switchToLevels();

					} else if (arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth())
							&& arg0.getY() >= 650 && arg0.getY() <= (650 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						manager.switchToLevelsDLV();

					} else if (arg0.getX() >= 1172 && arg0.getX() <= (1172 + Constants.buttonplayer.getWidth())
							&& arg0.getY() >= 628 && arg0.getY() <= (628 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						Platform.exit();

					}
				}
			}
		});
	}

}