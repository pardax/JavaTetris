package game_Utility;

import java.util.ArrayList;

import game_Object.Game_FieldBlock;

public class Game_BlockChain {
	
	Game_FieldBlock field[][];
	Game_MinoFactory factory;
	Game_BlockManager manager;
	ArrayList<Integer> lstRow = new ArrayList<>();
	int columnCount = 0;
	int tempColorID = 0;
	int delay = 0;
	
	public Game_BlockChain(Game_FieldBlock[][] f, Game_BlockManager m) {
		this.field = f;
		this.manager = m;
	}
	
	public void chkChain() {
		//20개의 행 조회
		for(int i = 0; i < 20; i++) {
			//10개의 열 조회
			for(int j = 0; j < 10; j++) {
				if(field[i][j].getBlockState()) {
					columnCount++;
				}
			}
			//열이 가득 찬 경우
			if(columnCount == 10) {
				lstRow.add(i);
			}
			columnCount = 0;
		}
		Chainning();
		
	}
	
	public void Chainning() {
		if(lstRow.size() >= 1) {
			for(int i = 0; i < lstRow.size(); i++) {
				for(int j = 0; j < 10; j++){
					field[lstRow.get(i)][j].clearBlock();
				}
			}
			recovering();
			lstRow.clear();
			countingDelay();
		}
	}
	
	public void recovering() {
		getFactory();
		
		for(int i = 0; i < lstRow.get(lstRow.size()-1); i++) {
			for(int j = 0; j < 10; j++) {
				if((lstRow.get(0)-1)-i < 0) {
					break;
				}
				tempColorID = field[(lstRow.get(0)-1)-i][j].getColorID();
				factory.moveBlock(
						lstRow.get(lstRow.size()-1)-i, j, tempColorID);
				factory.removeBlock((lstRow.get(0)-1)-i, j);
			}
		}
		
		/*	틀
		int c1 = field[17][0].getColorID();
		int c2 = field[17][1].getColorID();
		
		System.out.println(c1);
		System.out.println(c2);
		
		factory.moveBlock(18, 0, c1);
		factory.moveBlock(18, 1, c2);
		
		factory.removeBlock(17, 0);
		factory.removeBlock(17, 1);
		*/
	}
	
	public void getFactory() {
		this.factory = manager.returnFactory();
	}
	
	public void countingDelay() {
		if(delay < 20) {
			delay++;
		}
	}
	public int returnDelayCount() {
		if(delay >= 1) {
			return 20;
		}else {
			return 0;
		}
//		return delay;
	}
}
