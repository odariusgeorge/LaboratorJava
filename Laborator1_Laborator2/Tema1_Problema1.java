import java.util.*;
import java.lang.*;
public class Tema1_Problema1 {

	public static void main(String[] args) {
		
		Random r=new Random();
		int matrix[][]=new int [5][5];
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				matrix[i][j]=r.nextInt(10)+1;
		print2D(matrix);
		
		System.out.println(prime(matrix));
		System.out.println(impare(matrix));
		afisare_div5(matrix);
		System.out.println(min_coloana(matrix));
		
	}
	public static void print2D(int mat[][])
	{
		for(int []row:mat)
		{
			System.out.println(Arrays.toString(row));			
		}
		
	}
	static boolean prim(int n)
	{
		if(n<2)
			return false;
		
		for(int d=2;d<=Math.sqrt(n);d++)
			if(n%d==0)
				return false;
		return true;
		
	}
	static int prime(int mat[][])
	{	
		int contor=0;
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(prim(mat[i][j]))
					contor++;
		
		return contor;
		
	}
	static int impare(int mat[][])
	{
		
		int contor=0;
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(mat[i][j]%2==1)
					contor++;
		
		
		return contor;
	}
	static void afisare_div5(int mat[][])
	{
		
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(mat[i][j]%5==0)
					System.out.println("Numarul divizibil cu 5: " + mat[i][j] +" pozitia: "+i+" "+j);
				
	}
	static int min_coloana(int mat[][])
	{
		
		int coloana=0;
		int suma_min=9999;
		int sum=0;
		for(int j=0;j<5;j++)
		{
			sum=0;
			for(int i=0;i<5;i++)
			{
				
				sum+=mat[i][j];
				
			}
			if(sum<suma_min)
			{
				suma_min=sum;
				coloana=j;
			}
		}
		coloana++;
		System.out.println("Suma minima se afla pe coloana: " + coloana);
		return suma_min;
	}
	
}
