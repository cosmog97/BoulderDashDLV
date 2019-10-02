
package graphic;

import interfaces.GameScene;

import dlv_model.*;
import javafx.scene.Scene;
import model.Diamond;
import model.Empty;
import model.Ground;
import model.Stone;
import model.Wall;
import model.World;
import utility.Direction;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class PlaySceneDLV implements GameScene {

	protected SceneManager manager;
	private World world;
	private int level;
	private Closer_dlv newCloser = new Closer_dlv(20,25);
	private boolean first = true;
	private static String encodingResource = "/home/paolo/git/BoulderDashDLV/BoulderDashDLV/src/res/encodings/rules";
	private static Handler handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));
	InputProgram facts = new ASPInputProgram();
	InputProgram encoding = new ASPInputProgram();

	public PlaySceneDLV(SceneManager sceneManager, int level) {
		this.manager = sceneManager;
		this.level = level;
		this.world = new World(this.level); // world DLV

	}

	public void update() {
		System.out.println("STO AGGIORNANDO IL MOVIMENTO PLAYER");
		if (this.world.isNewCloserGem()) {
			first = true;
			newCloser = calcola_closer();
			this.world.setNewCloserGem(false);
		}
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
						if (first) System.out.println("stone(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO PIETRA
				} else if (world.getElement(i, j) instanceof Diamond) {
					try {
						facts.addObjectInput(new Diamond_dlv(i, j));
						if (first) System.out.println("gem(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				} else if (world.getElement(i, j) instanceof Wall) {
					try {
						facts.addObjectInput(new Wall_dlv(i, j));
						if (first) System.out.println("wall(" + i + "," + j + ").");

					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				} else if (world.getElement(i, j) instanceof Ground || world.getElement(i, j) instanceof Empty) {
					try {
						facts.addObjectInput(new Ground_dlv(i, j));
						if (first) System.out.println("ground(" + i + "," + j + ").");

					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				}
			}
		}
		try {
			facts.addObjectInput(newCloser);
			System.out.println("closer(" + newCloser.getRow() + "," + newCloser.getColumn() + ").");

		} catch (Exception e) {		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ASPMapper.getInstance().registerClass(Up_dlv.class);
			ASPMapper.getInstance().registerClass(Down_dlv.class);
			ASPMapper.getInstance().registerClass(Left_dlv.class);
			ASPMapper.getInstance().registerClass(Right_dlv.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		handler.addProgram(facts);
		encoding.addFilesPath(encodingResource);
		handler.addProgram(encoding);
		Output o = handler.startSync();
		AnswerSets answers = (AnswerSets) o;


		for (AnswerSet a : answers.getAnswersets()) { 
			System.out.println(a); 
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
		first = false;
		handler.removeAll();
		handler.addProgram(facts);
		handler.addProgram(encoding);
	}

	private Closer_dlv calcola_closer() {
		System.out.println("STO AGGIORNANDO gemma");

		String encodingResource2 = "/home/paolo/git/BoulderDashDLV/BoulderDashDLV/src/res/encodings/rules2";
		Handler handler2 = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));
		InputProgram facts2 = new ASPInputProgram();
		InputProgram encoding2 = new ASPInputProgram();
		Closer_dlv new_closer_temp = new Closer_dlv(20,20);

		facts2.clearAll();

		for (int i = 0; i < world.getRow(); i++) {
			for (int j = 0; j < world.getColumn(); j++) {
				if (world.player.getColumnIndex() == j && world.player.getRowIndex() == i) {
					try {
						facts2.addObjectInput(new Player_dlv(i, j));
						System.out.println("player(" + i + "," + j + ").");

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (world.getElement(i, j) instanceof Stone) {
					try {
						facts2.addObjectInput(new Stone_dlv(i, j));
						System.out.println("stone(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO PIETRA
				} else if (world.getElement(i, j) instanceof Diamond) {
					try {
						facts2.addObjectInput(new Diamond_dlv(i, j));
						System.out.println("gem(" + i + "," + j + ").");
					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				} else if (world.getElement(i, j) instanceof Wall) {
					try {
						facts2.addObjectInput(new Wall_dlv(i, j));
						System.out.println("wall(" + i + "," + j + ").");

					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				} else if (world.getElement(i, j) instanceof Ground || world.getElement(i, j) instanceof Empty) {
					try {
						facts2.addObjectInput(new Ground_dlv(i, j));
						System.out.println("ground(" + i + "," + j + ").");

					} catch (Exception e) {
						e.printStackTrace();
					} // CREAZIONE DEL FATTO
				}
			}
		}
		try {
			ASPMapper.getInstance().registerClass(Closer_dlv.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		handler2.addProgram(facts2);
		encoding2.addFilesPath(encodingResource2);
		handler2.addProgram(encoding2);
		Output o2 = handler2.startSync();
		AnswerSets answers2 = (AnswerSets) o2;

		for (AnswerSet a : answers2.getAnswersets()) { 
			System.out.println(a); 
			try {
				for (Object obj : a.getAtoms()) {
					if ((obj instanceof Closer_dlv)) {
						new_closer_temp = (Closer_dlv) obj;
					}
				}
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}

		handler2.removeAll();
		handler2.addProgram(facts2);
		handler2.addProgram(encoding2);

		return new_closer_temp;
	}

	public void draw() {
		world.draw();
	}

	public void handleEvent(Scene scene) {
	}
}