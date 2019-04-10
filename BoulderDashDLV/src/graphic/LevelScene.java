package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class LevelScene implements GameScene {
	
	protected SceneManager manager;
	protected boolean uno;
	protected boolean due;
	protected boolean tre;
	protected boolean random;
	
	public LevelScene(SceneManager manager) {
		this.manager = manager;
		this.uno = false;
		this.due = false;
		this.tre = false;
		this.random = false;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		Constants.context.drawImage(Constants.bglevels , 0, 0);
		if (uno) {
			Constants.context.drawImage(null, 256, 540);
		}
		else {
			Constants.context.drawImage(null, 256, 540);
		}
		if (due) {
			Constants.context.drawImage(null, 256, 650);
		}
		else {
			Constants.context.drawImage(null, 256, 650);
		}
		if (tre) {
			Constants.context.drawImage(null, 256, 650);
		}
		else {
			Constants.context.drawImage(null, 256, 650);
		}
		if (random) {
			Constants.context.drawImage(null, 256, 650);
		}
		else {
			Constants.context.drawImage(null, 256, 650);
		}
	}

	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {

				/*	if(arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) 
							&& arg0.getY() >= 540 && arg0.getY() <= (540 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						//manager.switchToPlay();
						playerOn = true;
					} 
					else {
						playerOn = false;
					}
					
					if(arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) 
							&& arg0.getY() >= 650 && arg0.getY() <= (650 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						//manager.switchToPlay();
						dlvOn = true;
					} 
					else {
						dlvOn = false;
					}
				*/
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				manager.switchToPlay(2);
			/*	if(arg0.isPrimaryButtonDown()) {
					if(arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) 
							&& arg0.getY() >= 540 && arg0.getY() <= (540 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						manager.switchToPlay(2);
						
					}
					else if(arg0.getX() >= 256 && arg0.getX() <= (256 + Constants.buttonplayer.getWidth()) 
							&& arg0.getY() >= 650 && arg0.getY() <= (650 + Constants.buttonplayer.getHeight())
							&& manager.getGameScene() instanceof MenuScene) {
						manager.switchToDLV();
						
					}
				}*/
			}
		});
	}

}