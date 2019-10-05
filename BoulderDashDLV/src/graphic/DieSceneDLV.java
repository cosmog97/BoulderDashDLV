package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class DieSceneDLV implements GameScene {

	protected SceneManager manager;
	protected boolean menuOn = false;
	protected boolean randomOn = false;
	protected boolean riprovaOn = false;
	protected int level;

	public DieSceneDLV(SceneManager manager, int level) {
		this.manager = manager;
		this.level = level;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		Constants.context.drawImage(Constants.die, 0, 0);
		if (menuOn) {
			Constants.context.drawImage(Constants.buttonmenu_on, 558, 600);
		} else {
			Constants.context.drawImage(Constants.buttonmenu, 558, 600);
		}
		if (riprovaOn) {
			Constants.context.drawImage(Constants.buttonriprova_on, 1158, 600);
		} else {
			Constants.context.drawImage(Constants.buttonriprova, 1158, 600);
		}
	}

	@Override
	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth()) && arg0.getY() >= 600
						&& arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof DieSceneDLV) {
					// manager.switchToPlay();
					menuOn = true;
				} else {
					menuOn = false;
				}

				if (arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.buttonmenu.getWidth()) && arg0.getY() >= 600
						&& arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof DieSceneDLV) {
					// manager.switchToPlay();
					riprovaOn = true;
				} else {
					riprovaOn = false;
				}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if (arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth())
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof DieSceneDLV) {
						manager.switchToMenu();
					}
					if (arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.buttonmenu.getWidth())
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof DieSceneDLV) {
						// manager.switchToPlay();
						manager.switchToPlayDLV(level);
					}
				}
			}
		});
	}

}