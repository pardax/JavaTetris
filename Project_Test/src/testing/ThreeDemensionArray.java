package testing;

public class ThreeDemensionArray {

	public static void main(String[] args) {
		int[][][] blackList = {
				{
					{1,2,3,4}, {13,14,15,16}
				},
				{{5,6,7,8}},
				{{9,10,11,12}}
				};
		
		System.out.println(blackList[0][0][0]);
	}

}
