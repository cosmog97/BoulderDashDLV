package graphic;
import interfaces.*;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

public class SceneManager {
	
	private GameScene scene;
	
	public SceneManager() {
		this.scene = new MenuScene(this);
	}
	
	public void update() {
		scene.update();
	}
	
	public void draw(GraphicsContext context) {
		scene.draw();
	}
	
	public void handleEvent(Scene _scene) {
		scene.handleEvent(_scene);
	}

	public void switchToPlay(int level) {
		this.scene = new PlayScene(this, level);
	}
	
	
	public void switchToDLV() {
		//this.scene = new DLVScene(this);
	}
	
	public void switchToLevels() {
		this.scene = new LevelScene(this);
	}
	
	public void switchToVittoria(int level) {
		this.scene = new VittoriaScene(this,level);
	}
	public void switchToDie() {
		this.scene = new DieScene(this);
	}
	public void switchToMenu() {
		this.scene = new MenuScene(this);
	}
	
	public GameScene getGameScene() {
		return this.scene;
	}
}
