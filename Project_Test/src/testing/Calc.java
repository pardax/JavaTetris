package testing;

public class Calc {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {5,6,7,8};
		int[][] c = {
				{a[0],b[0]},
				{a[1],b[1]},
				{a[2],b[2]},
				{a[3],b[3]}
				};
				
		
		for(int i = 0; i < c.length; i++) {
			System.out.println("------------" + (i+1) + "За");
			for(int j = 0; j < 2; j++) {
				System.out.println(c[i][j] + " "+(j+1)+"ї­");
			}
		}

	}

}
