
package graphic;
import interfaces.GameScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import model.World;

public class PlayScene implements GameScene {
	
	protected SceneManager manager;
	private World world;
	/*private PlayerObject player;
	private ObstacleManager obManager;*/
	
	public PlayScene(SceneManager sceneManager) {
		this.manager = sceneManager;
		this.world = new World(1);
	/*	this.player = new PlayerObject(12, 7, this.world);
		this.obManager = new ObstacleManager(this.world);		*/
	}

	public void update() {
	//	world.update();
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
		/*obManager.draw();
		player.draw();*/
	}

	public void handleEvent(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent arg0) {
			/*	if(player.getJumping() == false) {
					switch(arg0.getCode()) {
					case UP:
						player.jump(Direction.UP);
						break;
					case DOWN:
						player.jump(Direction.DOWN);
						break;
					case LEFT:
						player.jump(Direction.LEFT);
						break;
					case RIGHT:
						player.jump(Direction.RIGHT);
						break;
					default:
						break;
					}
				}*/
			}
			
		});
	}

}