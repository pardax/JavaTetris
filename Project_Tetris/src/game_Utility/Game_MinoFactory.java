package game_Utility;

import java.awt.image.BufferedImage;

import game_Object.Game_FieldBlock;

public class Game_MinoFactory {
	
	//빨주노초파남보
	private final int Z_MINO = 0;
	private final int L_MINO = 1;
	private final int O_MINO = 2;
	private final int S_MINO = 3;
	private final int I_MINO = 4;
	private final int J_MINO = 5;
	private final int T_MINO = 6;
	
	
	private BufferedImage redBlock, orangeBlock, yellowBLock, greenBlock,
	blueBlock, indigoBlock, violetBlock;
	
	private Game_FieldBlock blockField[][];
	private Game_BlockControl blockControl;
	
	int[] blockArrayC, blockArrayR;
	int nowSpeices = 0;
	
	public Game_MinoFactory(Game_FieldBlock blockfield[][],
			Game_BlockControl blockControl) {
		this.blockField = blockfield;
		this.blockControl = blockControl;
		blockArrayC = new int[4];
		blockArrayR = new int[4];
		setBlockImg();
	}
	
	/*
	 *	블럭을 총괄적으로 관리하는 메소드, 0은 초기화 1은 생성 
	 */
	public void minoManager(int mino_index, int minoState
			, int r, int c, int mode) {
		if(mode == 0) {
			switch (mino_index) {
			case Z_MINO:
				clearZmino(minoState, r, c);
				break;
			case L_MINO:
				clearLmino(minoState, r, c);
				break;
			case O_MINO:
				clearOmino(r, c);
				break;
			case S_MINO:
				clearSmino(minoState, r, c);
				break;
			case I_MINO:
				clearImino(minoState, r, c);
				break;
			case J_MINO:
				clearJmino(minoState, r, c);
				break;
			case T_MINO:
				clearTmino(minoState, r, c);
				break;
			}
		}else {
			switch (mino_index) {
			case Z_MINO:
				makeZmino(minoState, r, c);
				break;
			case L_MINO:
				makeLmino(minoState, r, c);
				break;
			case O_MINO:
				makeOmino(r, c);
				break;
			case S_MINO:
				makeSmino(minoState, r, c);
				break;
			case I_MINO:
				makeImino(minoState, r, c);
				break;
			case J_MINO:
				makeJmino(minoState, r, c);
				break;
			case T_MINO:
				makeTmino(minoState, r, c);
				break;
			}
		}
	}
	//좌우 인덱스 오버 확인
	public void setPosCInstance(int b1c,int b2c,int b3c, int b4c) {
		blockArrayC[0] = b1c;
		blockArrayC[1] = b2c;
		blockArrayC[2] = b3c;
		blockArrayC[3] = b4c;
	}
	
	public int[] getBlockArray() {
		return blockArrayC;
	}
	
	//행 인덱스 오버 확인
	public void setPosRInstance(int b1r,int b2r,int b3r, int b4r) {
		blockArrayR[0] = b1r;
		blockArrayR[1] = b2r;
		blockArrayR[2] = b3r;
		blockArrayR[3] = b4r;
	}
	
	public int[] getBlockArrayRow() {
		return blockArrayR;
	}
	
	public void clearBlockTemp() {
		blockArrayR[0] = 0;
		blockArrayR[1] = 0;
		blockArrayR[2] = 0;
		blockArrayR[3] = 0;
		
		blockArrayC[0] = 0;
		blockArrayC[1] = 0;
		blockArrayC[2] = 0;
		blockArrayC[3] = 0;
	}
	
	
	// r = Row, c = Column
	// ------------------블록 만들기------------------
	public void makeImino(int minoState, int r, int c) { //좌표 + 배치임
		switch (minoState) {
		case 0: 
			//정
			blockField[r+0][c].setBlockState(blueBlock, 1, 5);
			blockField[r+1][c].setBlockState(blueBlock, 2, 5);
			blockField[r+2][c].setBlockState(blueBlock, 3, 5);
			blockField[r+3][c].setBlockState(blueBlock, 4, 5);
			setPosCInstance(c, c, c, c);
			setPosRInstance(r, r+1, r+2, r+3);
			break;
		case 1: 
			//2
			blockField[r][c].setBlockState(blueBlock, 1, 5);
			blockField[r][c+1].setBlockState(blueBlock, 2, 5);
			blockField[r][c+2].setBlockState(blueBlock, 3, 5);
			blockField[r][c+3].setBlockState(blueBlock, 4, 5);
			setPosCInstance(c, c+1, c+2, c+3);
			setPosRInstance(r, r, r, r);
			break;
		}
	}
	
	//메인 개발 블록
	public void makeZmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//정
			blockField[r][c].setBlockState(redBlock, 1, 1);
			blockField[r][c+1].setBlockState(redBlock, 2, 1);
			blockField[r+1][c+1].setBlockState(redBlock, 3, 1);
			blockField[r+1][c+2].setBlockState(redBlock, 4, 1);
			setPosCInstance(c, c+1, c+1, c+2);
			setPosRInstance(r, r, r+1, r+1);
			break;
		case 1: 
			//2
			blockField[r][c+1].setBlockState(redBlock, 1, 1);
			blockField[r+1][c].setBlockState(redBlock, 2, 1);
			blockField[r+1][c+1].setBlockState(redBlock, 3, 1);
			blockField[r+2][c].setBlockState(redBlock, 4, 1);
			setPosCInstance(c+1, c, c+1, c);
			setPosRInstance(r, r+1, r+1, r+2);
			break;
		}
	}
	public void makeSmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//정
			blockField[r][c+1].setBlockState(greenBlock, 1, 4);
			blockField[r][c+2].setBlockState(greenBlock, 2, 4);
			blockField[r+1][c].setBlockState(greenBlock, 3, 4);
			blockField[r+1][c+1].setBlockState(greenBlock, 4, 4);
			setPosCInstance(c+1, c+2, c, c+1);
			setPosRInstance(r, r, r+1, r+1);
			break;
		case 1: 
			//2
			blockField[r][c].setBlockState(greenBlock, 1, 4);
			blockField[r+1][c].setBlockState(greenBlock, 2, 4);
			blockField[r+1][c+1].setBlockState(greenBlock, 3, 4);
			blockField[r+2][c+1].setBlockState(greenBlock, 4, 4);
			setPosCInstance(c, c, c+1, c+1);
			setPosRInstance(r, r+1, r+1, r+2);
			break;
		}
	}
	public void makeJmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//ㄴ
			blockField[r][c].setBlockState(indigoBlock, 1, 6);
			blockField[r+1][c].setBlockState(indigoBlock, 2, 6);
			blockField[r+1][c+1].setBlockState(indigoBlock, 3, 6);
			blockField[r+1][c+2].setBlockState(indigoBlock, 4, 6);
			setPosCInstance(c, c, c+1, c+2);
			setPosRInstance(r, r+1, r+1, r+1);
			break;
		case 1:
			//ㄱ
			blockField[r][c].setBlockState(indigoBlock, 1, 6);
			blockField[r][c+1].setBlockState(indigoBlock, 2, 6);
			blockField[r+1][c].setBlockState(indigoBlock, 3, 6);
			blockField[r+2][c].setBlockState(indigoBlock, 4, 6);
			setPosCInstance(c, c+1, c, c);
			setPosRInstance(r, r, r+1, r+2);
			break;
		case 2:
			blockField[r][c].setBlockState(indigoBlock, 1, 6);
			blockField[r][c+1].setBlockState(indigoBlock, 2, 6);
			blockField[r][c+2].setBlockState(indigoBlock, 3, 6);
			blockField[r+1][c+2].setBlockState(indigoBlock, 4, 6);
			setPosCInstance(c, c+1, c+2, c+2);
			setPosRInstance(r, r, r, r+1);
			break;
		case 3: 
			blockField[r][c+1].setBlockState(indigoBlock, 1, 6);
			blockField[r+1][c+1].setBlockState(indigoBlock, 2, 6);
			blockField[r+2][c].setBlockState(indigoBlock, 3, 6);
			blockField[r+2][c+1].setBlockState(indigoBlock, 4, 6);
			setPosCInstance(c+1, c+1, c, c+1);
			setPosRInstance(r, r+1, r+2, r+2);
			break;
		}
		
	}
	public void makeLmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			blockField[r][c+2].setBlockState(orangeBlock, 1, 2);
			blockField[r+1][c].setBlockState(orangeBlock, 2, 2);
			blockField[r+1][c+1].setBlockState(orangeBlock, 3, 2);
			blockField[r+1][c+2].setBlockState(orangeBlock, 4, 2);
			setPosCInstance(c+2, c, c+1, c+2);
			setPosRInstance(r, r+1, r+1, r+1);
			break;
		case 1: 
			blockField[r][c].setBlockState(orangeBlock, 1, 2);
			blockField[r+1][c].setBlockState(orangeBlock, 2, 2);
			blockField[r+2][c].setBlockState(orangeBlock, 3, 2);
			blockField[r+2][c+1].setBlockState(orangeBlock, 4, 2);
			setPosCInstance(c, c, c, c+1);
			setPosRInstance(r, r+1, r+2, r+2);
			break;
		case 2: 
			blockField[r][c].setBlockState(orangeBlock, 1, 2);
			blockField[r][c+1].setBlockState(orangeBlock, 2, 2);
			blockField[r][c+2].setBlockState(orangeBlock, 3, 2);
			blockField[r+1][c].setBlockState(orangeBlock, 4, 2);
			setPosCInstance(c, c+1, c+2, c);
			setPosRInstance(r, r, r, r+1);
			break;
		case 3: 
			blockField[r][c].setBlockState(orangeBlock, 1, 2);
			blockField[r][c+1].setBlockState(orangeBlock, 2, 2);
			blockField[r+1][c+1].setBlockState(orangeBlock, 3, 2);
			blockField[r+2][c+1].setBlockState(orangeBlock, 4, 2);
			setPosCInstance(c, c+1, c+1, c+1);
			setPosRInstance(r, r, r+1, r+2);
			break;
		}
	}
	public void makeTmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//ㅗ
			blockField[r][c+1].setBlockState(violetBlock, 1, 7);
			blockField[r+1][c].setBlockState(violetBlock, 2, 7);
			blockField[r+1][c+1].setBlockState(violetBlock, 3, 7);
			blockField[r+1][c+2].setBlockState(violetBlock, 4, 7);
			setPosCInstance(c+1, c, c+1, c+2);
			setPosRInstance(r, r+1, r+1, r+1);
			break;
		case 1:
			//ㅏ
			blockField[r][c].setBlockState(violetBlock, 1, 7);
			blockField[r+1][c].setBlockState(violetBlock, 2, 7);
			blockField[r+1][c+1].setBlockState(violetBlock, 3, 7);
			blockField[r+2][c].setBlockState(violetBlock, 4, 7);
			setPosCInstance(c, c, c+1, c);
			setPosRInstance(r, r+1, r+1, r+2);
			break;
		case 2: 
			//ㅜ
			blockField[r][c].setBlockState(violetBlock, 1, 7);
			blockField[r][c+1].setBlockState(violetBlock, 2, 7);
			blockField[r][c+2].setBlockState(violetBlock, 3, 7);
			blockField[r+1][c+1].setBlockState(violetBlock, 4, 7);
			setPosCInstance(c, c+1, c+2, c+1);
			setPosRInstance(r, r, r, r+1);
			break;
		case 3:
			//ㅓ
			blockField[r][c+1].setBlockState(violetBlock, 1, 7);
			blockField[r+1][c].setBlockState(violetBlock, 2, 7);
			blockField[r+1][c+1].setBlockState(violetBlock, 3, 7);
			blockField[r+2][c+1].setBlockState(violetBlock, 4, 7);
			setPosCInstance(c+1, c, c+1, c+1);
			setPosRInstance(r, r+1, r+1, r+2);
			break;
		}
	}
	public void makeOmino(int r, int c) {
		blockField[r][c].setBlockState(yellowBLock, 1, 3);
		blockField[r][c+1].setBlockState(yellowBLock, 2, 3);
		blockField[r+1][c].setBlockState(yellowBLock, 3, 3);
		blockField[r+1][c+1].setBlockState(yellowBLock, 4, 3);
		setPosCInstance(c, c+1, c, c+1);
		setPosRInstance(r, r, r+1, r+1);
	}
	
	// ------------------블록 지우기------------------
	
	public void clearImino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//정
			blockField[r+0][c].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+2][c].clearBlock();
			blockField[r+3][c].clearBlock();
			break;
		case 1: 
			//2
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r][c+2].clearBlock();
			blockField[r][c+3].clearBlock();
			break;
		}
	}
	public void clearZmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//정
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+1][c+2].clearBlock();
			break;
		case 1: 
			//2
			blockField[r][c+1].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c].clearBlock();
			break;
		}
	}
	public void clearSmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//정
			blockField[r][c+1].clearBlock();
			blockField[r][c+2].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			break;
		case 1: 
			//2
			blockField[r][c].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c+1].clearBlock();
			break;
		}
	}
	public void clearJmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//ㄴ
			blockField[r][c].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+1][c+2].clearBlock();
			break;
		case 1:
			//ㄱ
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+2][c].clearBlock();
			break;
		case 2:
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r][c+2].clearBlock();
			blockField[r+1][c+2].clearBlock();
			break;
		case 3: 
			blockField[r][c+1].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c].clearBlock();
			blockField[r+2][c+1].clearBlock();
			break;
		}
		
	}
	public void clearLmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			blockField[r][c+2].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+1][c+2].clearBlock();
			break;
		case 1: 
			blockField[r][c].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+2][c].clearBlock();
			blockField[r+2][c+1].clearBlock();
			break;
		case 2: 
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r][c+2].clearBlock();
			blockField[r+1][c].clearBlock();
			break;
		case 3: 
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c+1].clearBlock();
			break;
		}
	}
	public void clearTmino(int minoState, int r, int c) {
		switch (minoState) {
		case 0: 
			//ㅗ
			blockField[r][c+1].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+1][c+2].clearBlock();
			break;
		case 1:
			//ㅏ
			blockField[r][c].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c].clearBlock();
			break;
		case 2: 
			//ㅜ
			blockField[r][c].clearBlock();
			blockField[r][c+1].clearBlock();
			blockField[r][c+2].clearBlock();
			blockField[r+1][c+1].clearBlock();
			break;
		case 3:
			//ㅓ
			blockField[r][c+1].clearBlock();
			blockField[r+1][c].clearBlock();
			blockField[r+1][c+1].clearBlock();
			blockField[r+2][c+1].clearBlock();
			break;
		}
	}
	public void clearOmino(int r, int c) {
		blockField[r][c].clearBlock();
		blockField[r][c+1].clearBlock();
		blockField[r+1][c].clearBlock();
		blockField[r+1][c+1].clearBlock();
	}

	public void getField(Game_FieldBlock blockfield[][]) {
		this.blockField = blockfield;
	}
	
	
	public int getMinoSpeices() {
		return this.nowSpeices;
	}
	
	public void moveBlock(int row, int col, int color) {
		switch (color) {
		case 1: {
			blockField[row][col].setBlockState(redBlock, 0, 1);
			break;
		}
		case 2: {
			blockField[row][col].setBlockState(orangeBlock, 0, 2);
			break;
		}
		case 3: {
			blockField[row][col].setBlockState(yellowBLock, 0, 3);
			break;
		}
		case 4: {
			blockField[row][col].setBlockState(greenBlock, 0, 4);
			break;
		}
		case 5: {
			blockField[row][col].setBlockState(blueBlock, 0, 5);
			break;
		}
		case 6: {
			blockField[row][col].setBlockState(indigoBlock, 0, 6);
			break;
		}
		case 7: {
			blockField[row][col].setBlockState(violetBlock, 0, 7);
			break;
		}
		default:
			
		}
	}
	public void removeBlock(int row, int col) {
		blockField[row][col].clearBlock();
	}
	
	public void setBlockImg() {
		redBlock = Game_LoadImage.getImg("img/redBlock.png");
		orangeBlock = Game_LoadImage.getImg("img/orangeBlock.png");
		yellowBLock = Game_LoadImage.getImg("img/yellowBlock.png");
		greenBlock = Game_LoadImage.getImg("img/greenBlock.png");
		blueBlock = Game_LoadImage.getImg("img/blueBlock.png");
		indigoBlock = Game_LoadImage.getImg("img/indigoBlock.png");
		violetBlock = Game_LoadImage.getImg("img/violetBlock.png");
	}
	
}
