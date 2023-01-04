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
			//�˻� �� ��� Ž��
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//�˻� �� ����� �Ʒ� Ž��
				if(posC[i] >= 9) { //�ٴ��� ����
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
			//�˻� �� ��� Ž��
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//�˻� �� ����� �Ʒ� Ž��
				if(posC[i] <= 0) { //�ٴ��� ����
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
		//���� �̳��� ��ǥ �迭�� ������
		control.checkLand();
		for(int i = 0; i < 4; i++) {
			//�˻� �� ��� Ž��
			if(blackList[species][mode][i] == field[posR[i]][posC[i]].getBlockID()) {
				//�˻� �� ����� �Ʒ� Ž��
				if(posR[i] >= 19) { //�ٴ��� ����
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
		//��� ���� ��ǥ�� ������
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
			//�˻� �� ����� �Ʒ� Ž��
			if(posR[i] >= 19) { //�ٴ��� ����
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
		
		//�ε��� �ʰ� �˻�
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
			
		//���� �˻�
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
