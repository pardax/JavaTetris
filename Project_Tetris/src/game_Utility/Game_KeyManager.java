package game_Utility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game_Interface.Game_Screen;


public class Game_KeyManager extends KeyAdapter{
	
	private Game_Screen screen;
	private Game_BlockManager manager;
	private Game_BlockControl blockControl;
	private int GameState;
	
	
	public Game_KeyManager(Game_Screen sc, Game_BlockManager manager) {
		this.screen = sc;
		this.manager = manager;
		this.blockControl = manager.sendControl();
//		super();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object obj = e.getKeyCode();
		if(obj.equals(KeyEvent.VK_RIGHT)) {
			if(!blockControl.getGameOver()) {
				blockControl.RightMove();
				screen.repaint();
			}
		}
		if(obj.equals(KeyEvent.VK_LEFT)) {
			if(!blockControl.getGameOver()) {
				blockControl.leftMove();
				screen.repaint();
			}
		}
		if(obj.equals(KeyEvent.VK_SPACE)) {
			if(!blockControl.getGameOver()) {
				blockControl.blockDirectLand();
			}
		}
		if(obj.equals(KeyEvent.VK_A)) {
			if(!blockControl.getGameOver()) {
				blockControl.spinState();
				screen.repaint();
			}
		}
//		if(obj.equals(KeyEvent.VK_A)) {
//			System.out.println("���� �ڵ� �۵� A");
//			screen.startBlockDrop();
//		}
//		if(obj.equals(KeyEvent.VK_S)) {
//			System.out.println("���� �ڵ� �۵� S");
//			screen.stopBlockDrop();
//		}
//		if(obj.equals(KeyEvent.VK_D)) {
//			System.out.println("���� �ڵ� �۵� D");
//			blockControl.blockDirectLand();
//		}
//		if(obj.equals(KeyEvent.VK_Q)) {
//			System.out.println("���� �ڵ� �۵� Q");
//			blockControl.spinState();
//			screen.repaint();
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
