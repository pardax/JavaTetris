package prac;

public class Test_3d {
	public static void main(String[] args) {
		int[][][] a = new int[][][]{
			 {
                 {1, 0, 0},
                 {1, 0, 0},
                 {5, 1, 0},
         },
         {
                 {1, 1, 1},
                 {1, 0, 0},
                 {0, 0, 0},
         },
         {
                 {1, 1, 0},
                 {0, 1, 0},
                 {0, 1, 0},
         },
         {
                 {0, 0, 0},
                 {0, 0, 1},
                 {1, 1, 1},
         }
		};
		
		System.out.println(a[3][2][0]);
                
    
        
	}
}
