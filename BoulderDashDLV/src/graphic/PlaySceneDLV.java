
package graphic;

import interfaces.GameScene;

import java.nio.file.Paths;

import dlv_model.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import model.Diamond;
import model.Empty;
import model.Ground;
import model.Stone;
import model.Wall;
import model.World;
import utility.Constants;
import utility.Direction;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class PlaySceneDLV implements GameScene {

	protected SceneManager manager;
	private World world;
	private int level;
	private boolean indietroOn = false;
	
	private static String encodingResource = Paths.get("").toAbsolutePath().toString() + "/src/res/encodings/rules";
	private static Handler handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));
	InputProgram facts = new ASPInputProgram();
	InputProgram encoding = new ASPInputProgram();

	public PlaySceneDLV(SceneManager sceneManager, int level) {
		this.manager = sceneManager;
		this.level = level;
		this.world = new World(this.level); // world DLV

	}

	public void update() {
		world.update();
		facts.clearAll();
		
		for (int i = 0; i < world.getRow(); i++) {
			for (int j = 0; j < world.getColumn(); j++) {
				if (world.player.getColumnIndex() == j && world.player.getRowIndex() == i) {
					try {
						facts.addObjectInput(new Player_dlv(i, j));
						System.out.println("player(" + i + "," + j + ").");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (world.getElement(i, j) instanceof Stone) {
					try {
						facts.addObjectInput(new Stone_dlv(i, j));
						//System.out.println("stone(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO PIETRA
				} else if (world.getElement(i, j) instanceof Diamond) {
					try {
						facts.addObjectInput(new Diamond_dlv(i, j));
						//System.out.println("gem(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				} else if (world.getElement(i, j) instanceof Wall) {
					try {
						facts.addObjectInput(new Wall_dlv(i, j));
						//System.out.println("wall(" + i + "," + j + ").");

					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				}
			}
		}
		try {
			ASPMapper.getInstance().registerClass(Up_dlv.class);
			ASPMapper.getInstance().registerClass(Down_dlv.class);
			ASPMapper.getInstance().registerClass(Left_dlv.class);
			ASPMapper.getInstance().registerClass(Right_dlv.class);
		} catch(Exception e) {
			e.printStackTrace();
		}
		handler.addProgram(facts);
		encoding.addFilesPath(encodingResource);
		handler.addProgram(encoding);
		Output o = handler.startSync();
		AnswerSets answers = (AnswerSets) o;

		for (AnswerSet a : answers.getAnswersets()) {
			//System.out.println(a);
			try {
				for (Object obj : a.getAtoms()) {

					if ((obj instanceof Up_dlv)) {
						world.movePlayer(Direction.UP);
						System.out.println("UP");
					} else if ((obj instanceof Down_dlv)) {
						world.movePlayer(Direction.DOWN);
						System.out.println("DOWN");
					} else if ((obj instanceof Right_dlv)) {
						world.movePlayer(Direction.RIGHT);
						System.out.println("RIGHT");
					} else if ((obj instanceof Left_dlv)) {
						world.movePlayer(Direction.LEFT);
						System.out.println("LEFT");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (world.getWin()) {
			manager.switchToVittoriaDLV(level);
		}
		if (world.getDie()) {
			manager.switchToDieDLV(level);
		}

		handler.removeAll();
		handler.addProgram(facts);
		handler.addProgram(encoding);
	}

	public void draw() {
		world.draw();
		if (indietroOn) {
			Constants.context.drawImage(Constants.indietroplay_on, 19, 720);
		} else {
			Constants.context.drawImage(Constants.indietroplay, 19, 720);
		}
	}

	public void handleEvent(Scene scene) {
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {

					if(arg0.getX() >= 19 && arg0.getX() <= (19 + Constants.indietroplay_on.getWidth()) 
							&& arg0.getY() >= 720 && arg0.getY() <= (720 + Constants.indietroplay_on.getHeight())
							&& manager.getGameScene() instanceof PlaySceneDLV) {
						//manager.switchToPlay();
						indietroOn = true;
					} 
					else {
						indietroOn = false;
					}
			}
		});
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent arg0) {
				if(arg0.isPrimaryButtonDown()) {
					if(arg0.getX() >= 19 && arg0.getX() <= (19 + Constants.indietroplay_on.getWidth()) 
							&& arg0.getY() >= 720 && arg0.getY() <= (720 + Constants.indietroplay_on.getHeight())
							&& manager.getGameScene() instanceof PlaySceneDLV) {
						manager.switchToLevelsDLV();
					}
				}
			}
		});
	}
}