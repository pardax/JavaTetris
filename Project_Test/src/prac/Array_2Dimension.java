package prac;

public class Array_2Dimension {
	
	int array2d[][];
//			= new int[5][5];
	int array[];

	
	public Array_2Dimension() {
		array2d = new int[5][5];
		array = new int[5];
	}
	
	
	public static void main(String[] args) {
		int[][] array2d = new int[20][10];
		
		
		//������ �迭 �� ���� ���ϱ�
		for(int i = 0; i < array2d.length; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("--------");
		
		//������ �迭 �� ���� ���ϱ�
		for(int i = 0; i < array2d[0].length; i++) {
			System.out.print(i + " ");
		}
		
		

	}
}
