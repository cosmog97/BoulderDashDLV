
package graphic;
import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import model.World;
import utility.Direction;

public class PlayScene implements GameScene {
	
	protected SceneManager manager;
	private World world;
	private int level;
	/*private PlayerObject player;
	private ObstacleManager obManager;*/
	
	public PlayScene(SceneManager sceneManager, int level) {
		this.manager = sceneManager;
		this.level = level;
		this.world = new World(this.level);
	/*	this.player = new PlayerObject(12, 7, this.world);
		this.obManager = new ObstacleManager(this.world);		*/
	}

	public void update() {
		world.update();
		if (world.getWin()) {
			manager.switchToVittoria(level);
		}
		if (world.getDie()) {
			manager.switchToDie();
		}
	/*	player.update();
		obManager.update();
		if((player.jumpInWater() && obManager.voidBelow(player.row, player.column)) || obManager.collide(player.row, player.column)) {
			player.removeLife();
		}
		if(player.checkWin() || player.isDead()) {
			manager.switchToMenu();
		}
		//world.print();*/
	}

	public void draw() {
		world.draw();
		
	}

	public void handleEvent(Scene scene) {
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