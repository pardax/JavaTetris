package game_Utility;

import java.awt.Graphics;
import java.awt.Rectangle;

import game_Interface.Game_Screen;
import game_Object.Game_FieldBlock;

public class Game_BlockManager{
	
	public static final int BLOCK_X_INTERVAL = 30;
	public static final int BLOCK_Y_INTERVAL = 30;
	public static final int BLOCK_W_SCALE = 30;
	public static final int BLOCK_H_SCALE = 30;

	private final int MARGIN_TOP = 25;
	private final int MARGIN_LEFT = 50;
	
	private Game_FieldBlock blockField[][];
	private Game_BlockControl blockControl;
	private Game_Screen screen;
	private Game_BlockChain chain;
	
	public Game_BlockManager(Game_Screen sc) {
		this.screen = sc;
		blockField = new Game_FieldBlock[20][10];
		setField();
		
		chain = new Game_BlockChain(blockField, this);
		blockControl = new Game_BlockControl(blockField, this);
		
	}
	
	//��ũ�����κ��� ���� �� ����
	public void update() {
		//��� ���� Ȯ��
		if(blockControl.blockLanding()) {
			//��� ����
			blockControl.blockCycle();
		}else { //����� ����������
			chainning();
			controlDelay();
		}
	}
	
	//��� �ʵ� �ʱ�ȭ
	public void setField() {
		//�� �迭 �ʵ��� ����
		for(int i = 0; i < blockField.length; i++) {
			//�� �迭 �ʵ��� ����
			for(int j = 0; j < blockField[i].length; j++) {
				blockField[i][j] = new Game_FieldBlock(
						(MARGIN_LEFT+(j*BLOCK_X_INTERVAL))
						, (MARGIN_TOP+(i*BLOCK_Y_INTERVAL))
					);
			}
		}
	}
	
	public void chainning() {
		chain.chkChain();
	}
	
	public void drawFieldRect(Graphics g) {
		for(int i = 0; i < blockField.length; i++) {
			for(int j = 0; j < blockField[i].length; j++) {
				blockField[i][j].drawRect(g);
			}
		}
	}
	
	public Rectangle getBound() {
		return null;
	}
	
	public Game_BlockControl sendControl() {
		return blockControl;
	}
	
	public void screenTimerStop() {
		screen.stopBlockDrop();
	}
	
	public Game_MinoFactory returnFactory() {
		Game_MinoFactory fac = blockControl.returnFactory();
		return fac;
	}
	public void controlDelay() {
		screen.stopBlockDrop();
		screen.setDelay(chain.returnDelayCount());
		screen.startBlockDrop();
	}
	
}
