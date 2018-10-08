import java.util.Arrays;
import java.util.Random;

public class Problema11 {

	public Problema11() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int n;
		int arr1[]=new int[5];
		int arr2[]=new int[5];
		int matrix[][]=new int [5][5];
		Random r=new Random();
		for(int i=0;i<5;i++)
		{
			arr1[i]=r.nextInt(10)+1;
			arr2[i]=r.nextInt(10)+1;
		}
		System.out.println( Arrays.toString(arr1));
		System.out.println( Arrays.toString(arr2));
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				matrix[i][j]=arr1[i]*arr2[j];
		System.out.println();
		print2D(matrix);
		System.out.println();
		
		int arr[]=new int[5];
		for(int i=0;i<5;i++)
			arr[i]=Math.min(arr1[i], arr2[i]);
		
		System.out.println(Arrays.toString(arr));
		
	}
	public static void print2D(int mat[][])
	{
		for(int []row:mat)
		{
			System.out.println(Arrays.toString(row));
			
		}
		
	}
}
