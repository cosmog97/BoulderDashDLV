
package graphic;

import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utility.Constants;

public class VittoriaSceneDLV implements GameScene {
	
	protected SceneManager manager;
	protected boolean menuOn = false;
	protected boolean randomOn = false;
	protected boolean proxOn = false;
	protected int level;
	
	public VittoriaSceneDLV(SceneManager manager, int level) {
		this.manager = manager;
		this.level = level;
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		Constants.context.drawImage(Constants.win , 0, 0);
		if (menuOn) {
			Constants.context.drawImage(Constants.buttonmenu_on, 558, 600);
		}
		else {
			Constants.context.drawImage(Constants.buttonmenu, 558, 600);
		}
		if (randomOn) {
			Constants.context.drawImage(Constants.livrandom_on, 1158, 600);
		}
		else {
			Constants.context.drawImage(Constants.livrandom, 1158, 600);
		}
		if (level < 3) {
			if (proxOn) {
				Constants.context.drawImage(Constants.livsucc_on, 858, 700);
			}
			else {
				Constants.context.drawImage(Constants.livsucc, 858, 700);
			}
		}
	}

	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if(arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth()) 
						&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
						&& manager.getGameScene() instanceof VittoriaSceneDLV) {
					//manager.switchToPlay();
					menuOn = true;
				} 
				else {
					menuOn = false;
				}
				
				if(arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.livrandom.getWidth()) 
						&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.livrandom.getHeight())
						&& manager.getGameScene() instanceof VittoriaSceneDLV) {
					//manager.switchToPlay();
					randomOn = true;
				} 
				else {
					randomOn = false;
				}
				
				if (level < 3) {
					if(arg0.getX() >= 858 && arg0.getX() <= (858 + Constants.livrandom.getWidth()) 
							&& arg0.getY() >= 700 && arg0.getY() <= (700 + Constants.livrandom.getHeight())
							&& manager.getGameScene() instanceof VittoriaSceneDLV) {
						//manager.switchToPlay();
						proxOn = true;
					} 
					else {
						proxOn = false;
					}
				}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if (arg0.isPrimaryButtonDown()) {
					if(arg0.getX() >= 558 && arg0.getX() <= (558 + Constants.buttonmenu.getWidth()) 
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.buttonmenu.getHeight())
							&& manager.getGameScene() instanceof VittoriaSceneDLV) {
						manager.switchToMenu();
					} 
					
					
					if(arg0.getX() >= 1158 && arg0.getX() <= (1158 + Constants.livrandom.getWidth()) 
							&& arg0.getY() >= 600 && arg0.getY() <= (600 + Constants.livrandom.getHeight())
							&& manager.getGameScene() instanceof VittoriaSceneDLV) {
						manager.switchToPlayDLV(4);
					} 
					
					
					if (level < 3) {
						if(arg0.getX() >= 858 && arg0.getX() <= (858 + Constants.livrandom.getWidth()) 
								&& arg0.getY() >= 700 && arg0.getY() <= (700 + Constants.livrandom.getHeight())
								&& manager.getGameScene() instanceof VittoriaSceneDLV) {
							manager.switchToPlayDLV(level+1);
						} 
						
					}
				}
			}
		});

	}

}