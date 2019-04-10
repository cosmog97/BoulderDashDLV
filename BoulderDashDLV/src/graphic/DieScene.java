
package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class DieScene implements GameScene {
	
	protected SceneManager manager;
	protected boolean menuOn = false;
	protected boolean randomOn = false;
	public DieScene(SceneManager manager) {
		this.manager = manager;
;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		Constants.context.drawImage(Constants.die , 0, 0);
		if (menuOn) {
			Constants.context.drawImage(Constants.buttonmenu_on, 558, 600);
		}
		else {
			Constants.context.drawImage(Constants.buttonmenu, 558, 600);
		}
		if (randomOn) {
			Constants.context.drawImage(Constants.buttonriprova_on, 1158, 600);
		}
		else {
			Constants.context.drawImage(Constants.buttonriprova, 1158, 600);
		}
	}

	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if(arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth()) 
						&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof DieScene) {
					//manager.switchToPlay();
					menuOn = true;
				} 
				else {
					menuOn = false;
				}
				
				if(arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.buttonmenu.getWidth()) 
						&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof DieScene) {
					//manager.switchToPlay();
					randomOn = true;
				} 
				else {
					randomOn = false;
				}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if(arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth()) 
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof DieScene) {
						manager.switchToMenu();
					}
				}
				
			}
		});
	}

}