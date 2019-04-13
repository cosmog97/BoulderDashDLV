
package graphic;
import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import model.World;
import utility.Direction;

public class PlaySceneDLV implements GameScene {
	
	protected SceneManager manager;
	private World world;
	private int level;
	
	public PlaySceneDLV(SceneManager sceneManager, int level) {
		this.manager = sceneManager;
		this.level = level;
		this.world = new World(this.level);  //world DLV
	}

	public void update() {
		world.update();
		if (world.getWin()) {
			manager.switchToVittoriaDLV(level);
		}
		if (world.getDie()) {
			manager.switchToDieDLV(level);
		}
	}

	public void draw() {
		world.draw();
		
	}

	public void handleEvent(Scene scene) {  //eventi tastiera
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent arg0) {
		
					switch(arg0.getCode()) {
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