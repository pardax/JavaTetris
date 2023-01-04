package game_Utility;

public class Game_BlockStateDeck {
	
	int blockSpeices = 0;
	int blockState = 0;
	int[][] stateDownDeck = {
			{0,1,0,0}, //Z
			{0,1,2,3}, //L
			{0,0,0,0}, //O
			{0,1,0,0}, //S
			{0,1,0,0}, //I
			{0,1,2,3}, //J
			{0,1,2,3}  //T
			};
	int[][] stateRightDeck = {
			{2,3,0,0}, //Z
			{4,5,6,7}, //L
			{1,0,0,0}, //O
			{2,3,0,0}, //S
			{2,3,0,0}, //I
			{4,5,6,7}, //J
			{4,5,6,7}  //T
	};
	int[][] stateLeftDeck = {
			{4,5,0,0}, //Z
			{8,9,10,11}, //L 
			{2,0,0,0}, //O
			{4,5,0,0}, //S
			{4,5,0,0}, //I
			{8,9,10,11}, //J
			{8,9,10,11}  //T
	};
	
	int[][][] stateCheckRowDeck = {
			{	//Z
				{0,1,0,1},
				{0,0,0,-1}
			},
			{	//L
				{0,0,1,1},
				{0,-1,0,-2},
				{0,0,1,1},
				{0,1,0,-1}
			},
			{	//O
				{0,0,0,0}
			},
			{	//S
				{0,0,0,1},
				{0,-1,0,-2}
			},
			{	//I
				{0,-1,-2,-3},
				{0,1,2,3}
			},
			{	//J
				{0,-1,0,1},
				{0,0,-1,-1},
				{0,1,2,1},
				{0,0,0,-1}
			},
			{	//T
				{0,0,0,1},
				{0,-1,-1,0},
				{0,1,0,1},
				{0,0,0,-1}
			}
	};
	
	int[][][] stateCheckColDeck = {
			{	//Z
				{0,-1,0,-2},
				{-1,0,0,2}

			},
			{	//L
				{-2,0,-1,-1},
				{0,1,0,1},
				{0,0,-1,1},
				{2,-1,0,1}
			},
			{	//O
				{0,0,0,0}
			},
			{	//S
				{-1,0,0,0},
				{2,1,0,1}
			},
			{	//I
				{0,1,2,3},
				{0,-1,-2,-3}
			},
			{	//J
				{0,1,0,-2},
				{0,0,2,2},
				{0,0,-2,-1},
				{-1,-1,0,2}
			},
			{	//T
				{-1,0,0,-2},
				{0,1,1,0},
				{0,-1,0,0},
				{0,0,0,1}
			}
	};
	
	public Game_BlockStateDeck() {
		
	}
	
	public int getDownDeck(int species, int state) {
		return stateDownDeck[species][state];
	}
	public int getRightDeck(int species, int state) {
		return stateRightDeck[species][state];
	}
	public int getLeftDeck(int species, int state) {
		return stateLeftDeck[species][state];
	}
	public int[][][] getRowDeck() {
		return stateCheckRowDeck;
	}
	public int[][][] getColDeck() {
		return stateCheckColDeck;
	}
}
