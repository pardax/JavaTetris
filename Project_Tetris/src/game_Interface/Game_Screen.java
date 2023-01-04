package game_Interface;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

import game_Utility.Game_BlockManager;
import game_Utility.Game_KeyManager;

public class Game_Screen extends JPanel{
	
	public static final int GAME_WAITING = 1;
	public static final int GAME_WORKING = 1;
	
	private Game_BlockManager blockManager;
	private Timer blockDropTimer;
	
	private boolean blockDroping = true; 
	private int GameState = GAME_WORKING;
	
	public Game_Screen() {
		blockManager = new Game_BlockManager(this);
		
		//Å° ÀÔ·Â
		setFocusable(true);
		addKeyListener(new Game_KeyManager(this, blockManager));
		setBlockDropTimer();
		startBlockDrop();
	}
		
	public void update() {
		if(blockDroping) {
			blockManager.update();
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, getWidth(), getHeight());
		blockManager.drawFieldRect(g);
	}
	
	public int getGameState() {
		return GameState;
	}
	
	public void setBlockDropTimer() {
		blockDropTimer = new Timer(300, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (GameState) {
				case 0:
					break;
				case 1:
					update();
					repaint();
					break;
				}
			}
		});
	}
	
	public void startBlockDrop() {
		blockDropTimer.start();
//		blockManager.setDefaultBlockPlace();
	}
	public void stopBlockDrop() {
		blockDropTimer.stop();
//		blockDroping = false;
	}
	public void setDelay(int count) {
		blockDropTimer.setDelay(300 - (count*10));
	}
}
