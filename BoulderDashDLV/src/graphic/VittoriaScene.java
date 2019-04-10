
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
	
	public VittoriaScene(SceneManager manager) {
		this.manager = manager;
;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		Constants.context.drawImage(Constants.win , 0, 0);
		if (menuOn) {
			Constants.context.drawImage(Constants.buttonmenu_on, 0, 0);
		}
		else {
			Constants.context.drawImage(Constants.buttonmenu, 0, 0);
		}
		if (randomOn) {
			Constants.context.drawImage(Constants.livrandom_on, 500, 0);
		}
		else {
			Constants.context.drawImage(Constants.livrandom, 500, 0);
		}
		
	}

	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if(arg0.getX() >= 0 && arg0.getX() <= (0 + Constants.buttonmenu.getWidth()) 
						&& arg0.getY() >= 0 && arg0.getY() <= (0 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof VittoriaScene) {
					//manager.switchToPlay();
					menuOn = true;
				} 
				else {
					menuOn = false;
				}
				
				if(arg0.getX() >= 500 && arg0.getX() <= (500 + Constants.livrandom.getWidth()) 
						&& arg0.getY() >= 0 && arg0.getY() <= (0 + Constants.livrandom.getHeight())
						&& manager.getGameScene() instanceof VittoriaScene) {
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
				
				
			}
		});
	}

}