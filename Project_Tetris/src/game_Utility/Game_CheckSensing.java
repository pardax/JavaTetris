package game_Utility;

import game_Object.Game_FieldBlock;

public class Game_CheckSensing {
	
	Game_FieldBlock[][] field;
	Game_BlackList bLst;
	Game_BlockControl control;
	Game_BlockStateDeck deck;
	
	int[][][] blackList;
	int[][][] stateRowDeck;
	int[][][] stateColDeck;
	int[] posR, posC;
	int blockState, blockMode;
	
	boolean testbool;
	
	public Game_CheckSensing(Game_BlockControl control, Game_FieldBlock[][] field) {
		this.control = control;
		this.field = field;
		bLst = new Game_BlackList();
		blackList = bLst.getBlackList();
		deck = new Game_BlockStateDeck();
		stateRowDeck = deck.getRowDeck();
		stateColDeck = deck.getColDeck();
		
	}
	
	public boolean checkRightSide(int species, int mode) {
		control.checkLand();
		for(int i = 0; i < 4; i++) {
			//검사 할 블록 탐색
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//검사 할 블록의 아래 탐색
				if(posC[i] >= 9) { //바닥을 감지
					return false;
				}
				if(field[posR[i]][posC[i]+1].getBlockState()) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	public boolean checkLeftSide(int species, int mode) {
		control.checkLand();
		for(int i = 0; i < 4; i++) {
			//검사 할 블록 탐색
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//검사 할 블록의 아래 탐색
				if(posC[i] <= 0) { //바닥을 감지
					return false;
				}
				if(field[posR[i]][posC[i]-1].getBlockState()) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	public boolean checkLanding(int species, int mode) {
		//현재 미노의 좌표 배열을 가져옴
		control.checkLand();
		for(int i = 0; i < 4; i++) {
			//검사 할 블록 탐색
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//검사 할 블록의 아래 탐색
				if(posR[i] >= 19) { //바닥을 감지
					return false;
				}
				if(field[posR[i]+1][posC[i]].getBlockState()) {
					return false;
				}
				
			}
		}
		return true;
	}
	
	public boolean checkOver() {
		for(int i = 0; i < 10; i++) {
			if(field[1][i].getBlockState()) {
				for(int j = 0; j < 4; j++) {
					if(posR[j] <= 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public int chkDirectLanding(int species, int mode) {
		//블록 현재 좌표를 가져옴
		control.checkLand();
		for(int i = 0; i < 19; i++) {
			posR[0] += 1;
			posR[1] += 1;
			posR[2] += 1;
			posR[3] += 1;
			if(!chkNext(species, mode)) {
				break;
			}
		}
		return posR[0];
	}
	
	public boolean chkNext(int species, int mode) {
		for(int i = 0; i < 4; i++) {
			//검사 할 블록의 아래 탐색
			if(posR[i] >= 19) { //바닥을 감지
				return false;
			}
			if(field[posR[i]+1][posC[i]].getBlockState()) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public void setInstance(int[] r, int[] c) {
		this.posR = r;
		this.posC = c;
	}
	
	public boolean changeState(int species, int state) {
		control.checkLand();
		
		//인덱스 초과 검사
		if(posR[3] >= 19 || posR[0] == 0) {
			return false;
		}
		for(int i = 0; i < 4; i++) {
			if(posC[0] >= 9 ||
					posC[1] >= 9 ||
					posC[2] >= 9 ||
					posC[3] >= 9) {
				return false;
			}
			if(stateRowDeck[species][state][i] == 0 && 
					stateColDeck[species][state][i] == 0) {
				continue;
			}
			
			if(posR[i]+stateRowDeck[species][state][i] >= 20 && 
					posC[i]+stateColDeck[species][state][i] >= 10) {
				return false;
			}
			
		//선점 검사
			if(field
					[posR[i]+stateRowDeck[species][state][i]]
					[posC[i]+stateColDeck[species][state][i]].getBlockState()
					) {
				return false;
			}
		}
		return true;
	}
	

	
	public void testPrint(int species, int mode) {
	}
}
