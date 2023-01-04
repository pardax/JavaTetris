package game_Utility;

public class Game_BlackList {
	
	int[][][] blackList = {
				{//Z mino 0 i j
					{1,0,3,4},	//land mode1 
					{0,0,3,4},	//land mode2
					{0,2,0,4},	//right mode1 
					{1,0,3,4},	//right mode2
					{1,0,3,0},	//left mode1
					{1,2,0,4}	//left mode2
				},
				{//L mino 1 i j
					{0,2,3,4}, //land mode1
					{0,0,3,4}, //land mode2
					{0,2,3,4}, //land mode3
					{1,0,0,4}, //land mode4
					{1,0,0,4}, //right mode1
					{1,2,0,4}, //right mode2
					{0,0,3,4}, //right mode3
					{0,2,3,4}, //right mode4
					{1,2,0,0}, //left mode1
					{1,2,3,0}, //left mode2
					{1,0,0,4}, //left mode3
					{1,0,3,4} //left mode4
				},
				{//O mino 2 i j
					{0,0,3,4}, //land mode
					{0,2,0,4}, //right mode
					{1,0,3,0}  //left mode
				},
				{//S mino 3 i j
					{0,2,3,4},	//land mode1 
					{0,2,0,4},	//land mode2
					{0,2,0,4},	//right mode1 
					{1,0,3,4},	//right mode2
					{1,0,3,0},	//left mode1
					{1,2,0,4}	//left mode2
				},
				{//I mino 4 i j
					{0,0,0,4},	//land mode1 
					{1,2,3,4},	//land mode2
					{1,2,3,4},	//right mode1 
					{0,0,0,4},	//right mode2
					{1,2,3,4},	//left mode1
					{1,0,0,0}	//left mode2
				},
				{//J mino 5 i j
					{0,2,3,4}, //land mode1
					{0,2,0,4}, //land mode2
					{1,2,0,4}, //land mode3
					{0,0,3,4}, //land mode4
					{1,0,0,4}, //right mode1
					{0,2,3,4}, //right mode2
					{0,0,3,4}, //right mode3
					{1,2,0,4}, //right mode4
					{1,2,0,0}, //left mode1
					{1,0,3,4}, //left mode2
					{1,0,0,4}, //left mode3
					{1,2,3,0} //left mode4
				},
				{//T mino 6 i j
					{0,2,3,4}, //land mode1
					{0,0,3,4}, //land mode2
					{1,0,3,4}, //land mode3
					{0,2,0,4}, //land mode4
					{1,0,0,4}, //right mode1
					{1,0,3,4}, //right mode2
					{0,0,3,4}, //right mode3
					{1,0,3,4}, //right mode4
					{1,2,0,0}, //left mode1
					{1,2,0,4}, //left mode2
					{1,0,0,4}, //left mode3
					{1,2,0,4} //left mode4
				}
			};
	
	public Game_BlackList() {
		
	}
	
	public int[][][] getBlackList() {
		return blackList;
	}
}
