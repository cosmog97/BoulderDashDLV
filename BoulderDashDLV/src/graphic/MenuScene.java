
package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class MenuScene implements GameScene {
	
	protected SceneManager manager;
	
	public MenuScene(SceneManager manager) {
		this.manager = manager;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		Constants.context.drawImage(Constants.bgmenu , 0, 0);
		Constants.context.drawImage(Constants.buttonplayer, 156, 429);
		Constants.context.drawImage(Constants.buttonplayer, 156, 546);
	}

	public void handleEvent(Scene scene) {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				if(arg0.isPrimaryButtonDown()) {
					if(arg0.getX() >= 156 && arg0.getX() <= (456) 
							&& arg0.getY() >= 429 && arg0.getY() <= (495)
							&& manager.getGameScene() instanceof MenuScene) {
						manager.switchToPlay();
					}
				}
			}
		});
	}

}