package game_Utility;

import java.util.Random;

import game_Object.Game_FieldBlock;

public class Game_BlockControl {
	private Game_MinoFactory factory;
	private Game_CheckSensing chkSensing;
	private Game_BlockStateDeck deck;
	private Game_BlockManager manager;
	
	Game_FieldBlock Field[][];
	
	Random rand = new Random();
	
	int b1r, b1c, b2r, b2c, b3r, b3c, b4r, b4c;
	int posR = 0, posC = 4;
	int pastPosR = 0, pastPosC = 0;
	int[] blockArray, landingBlock;
	int[] chkExistRow, chkExistCol; 
	
	boolean checkBlockOverIndex = false;
	boolean over = false;

	/*블록 에디터*/
	// 0 ~ 6
	int blockSpeices = 6;
	// 0 ~ 1..3
	int blockState = 1;
	
	
	public Game_BlockControl(Game_FieldBlock blockfield[][], Game_BlockManager m) {
		this.Field = blockfield;
		this.manager = m;
		factory = new Game_MinoFactory(Field, this);
		chkSensing = new Game_CheckSensing(this, Field);
		deck = new Game_BlockStateDeck();
	}
	
	public void leftMove() {
		this.blockArray = factory.getBlockArray();
		checkBlockOverIndex = checkOverIndex(1);
		if(!checkBlockOverIndex) {
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 0);
			posC--;
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 1);
		}
	}
	public void RightMove() {
		this.blockArray = factory.getBlockArray();
		checkBlockOverIndex = checkOverIndex(0);
		if(!checkBlockOverIndex) {
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 0);
			posC++;
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 1);
		}
//		pastPosC = posC;
	}
	
	public boolean blockLanding() {
		landingBlock = factory.getBlockArrayRow();
		if(!chkSensing.checkLanding(blockSpeices, deck.getDownDeck(blockSpeices, blockState))) {
			factory.clearBlockTemp();
			restartBlock();
			chkGameOver();
			manager.controlDelay();
			return false;
		}
		return true;
	}
	
	public void blockDirectLand() {
		factory.minoManager(blockSpeices, blockState, pastPosR, posC, 0);
		factory.minoManager(blockSpeices, blockState, 
				chkSensing.chkDirectLanding(blockSpeices, blockState), posC, 1);
		factory.clearBlockTemp();
		manager.chainning();
		chkGameOver();
		manager.controlDelay();
		restartBlock();
	}
	
	public void blockCycle() {
		//이전 블록 지우기
		factory.minoManager(blockSpeices, blockState, pastPosR, posC, 0);
		//블록 내리기
		factory.minoManager(blockSpeices, blockState, posR, posC, 1);
		pastPosR = posR;
		posR++;
	}
	
	public void restartBlock() {
		posR = 0;
		posC = 4;
		pastPosR = 0;
		blockState = 0;
		blockSpeices = rand.nextInt(7);
	}

	
	public void setBlockState(int state) {
		this.blockState = state;
	}
	
	public boolean checkOverIndex(int side) {
		if(side == 0) {
			if(!chkSensing.checkRightSide(blockSpeices, deck.getRightDeck(blockSpeices, blockState))) {
				return true;
			}
			return false;
		}else {
			if(!chkSensing.checkLeftSide(blockSpeices, deck.getLeftDeck(blockSpeices, blockState))) {
				return true;
			}     
			return false;
		}
	}
	
	public void checkLand() {
		chkSensing.setInstance(factory.getBlockArrayRow(), factory.getBlockArray());
	}
	
	public Game_MinoFactory returnFactory() {
		return factory;
	}
	
	public void spinState() {
		if(chkSensing.changeState(blockSpeices, blockState)) {
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 0);
			blockStateList(blockSpeices, blockState);
			factory.minoManager(blockSpeices, blockState, pastPosR, posC, 1);
		}
	}
	
	public void blockStateList(int speices, int state) {
		if(speices == 2) {
			blockState = 0;
		}
		if(speices == 0 || speices == 3 || speices == 4) {
			if(blockState == 0) {
				blockState = 1;
			}else if(blockState == 1) {
				blockState = 0;
			}
		}
		if(speices == 1 || speices == 5 || speices == 6) {
			if(blockState == 0) {
				blockState = 1;
			}else if(blockState == 1) {
				blockState = 2;
			}else if(blockState == 2) {
				blockState = 3;
			}else if(blockState == 3) {
				blockState = 0;
			}
		}
	}
	public void chkGameOver() {
		if(!chkSensing.checkOver()) {
			manager.screenTimerStop();
			setGameOver();
		}
	}
	public void setGameOver() {
		this.over = true;
	}
	public boolean getGameOver() {
		return this.over;
	}
	
	
}
