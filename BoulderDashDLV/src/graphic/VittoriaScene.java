
package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class VittoriaScene implements GameScene {

	protected SceneManager manager;
	protected boolean menuOn = false;
	protected boolean randomOn = false;
	protected boolean proxOn = false;
	protected int level;

	public VittoriaScene(SceneManager manager, int level) {
		this.manager = manager;
		this.level = level;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.win, 0, 0);
		if (level < 3) {
			if (menuOn) {
				Constants.context.drawImage(Constants.buttonmenu_on, 558, 600);
			} else {
				Constants.context.drawImage(Constants.buttonmenu, 558, 600);
			}

			if (proxOn) {
				Constants.context.drawImage(Constants.livsucc_on, 1158, 600);
			} else {
				Constants.context.drawImage(Constants.livsucc, 1158, 600);
			}
		} else {
			if (menuOn) {
				Constants.context.drawImage(Constants.buttonmenu_on, 714, 600);
			} else {
				Constants.context.drawImage(Constants.buttonmenu, 714, 600);
			}
		}
	}

	@Override
	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (level < 3) {
					if (arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth())
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof VittoriaScene) {
						// manager.switchToPlay();
						menuOn = true;
					} else {
						menuOn = false;
					}
					if (arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.livrandom.getWidth())
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.livrandom.getHeight())
							&& manager.getGameScene() instanceof VittoriaScene) {
						// manager.switchToPlay();
						proxOn = true;
					} else {
						proxOn = false;
					}
				} else {
					if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.buttonmenu.getWidth())
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof VittoriaScene) {
						// manager.switchToPlay();
						menuOn = true;
					} else {
						menuOn = false;
					}
				}

			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if (level < 3) {
						if (arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth())
								&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
								&& manager.getGameScene() instanceof VittoriaScene) {
							manager.switchToMenu();
						}
						if (arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.livrandom.getWidth())
								&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.livrandom.getHeight())
								&& manager.getGameScene() instanceof VittoriaScene) {
							manager.switchToPlayDLV(level + 1);
						}
					} else {
						if (arg0.getX() >= 714 && arg0.getX() <= (714 + Constants.buttonmenu.getWidth())
								&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
								&& manager.getGameScene() instanceof VittoriaScene) {
							manager.switchToMenu();
						}
					}

				}
			}
		});

	}

}