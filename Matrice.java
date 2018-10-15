import java.util.*;
import java.util.Arrays;
public class Matrice 
{
	private int n;
	private int m;
	private double [][] data = null ;
	Matrice(int n, int m)
	{
		
		data=new double[n][m];
		this.n=n;
		this.m=m;
		
	}
	Matrice(double[][]data)
	{
		this.data=data.clone();
		n=this.data.length;
		m=this.data[0].length;
	}
	public boolean patratica()
	{
		return n==m;
	}
	void display()
	{
		for(int i=0;i<this.n;i++)
			{for(int j=0;j<this.m;j++)
				{System.out.print(data[i][j]+ " ");}
				System.out.println();}
	}
	void display(int linie,int coloana)
	{
		System.out.println(data[linie][coloana]);
	}
	void display(int linie)
	{
		for(int i=0;i<=linie;i++)
		System.out.print(data[linie][i]+" ");
		
	}
	double sum(double a, double b)
	{
		return a+b;
	}
	static Matrice aduna(Matrice m1,Matrice m2)
	{
		double [][] matrice= new double[m1.n][m1.m];
		Matrice a=new Matrice(matrice);
		for(int i=0;i<m1.n;i++)
			for(int j=0;j<m1.m;j++)
			{
				a.data[i][j]=m1.data[i][j]+m2.data[i][j];
			}
		return a;
	}
	Matrice inmultire(double c)
	{
		
		for(int i=0;i<this.n;i++)
			for(int j=0;j<this.m;j++)
				this.data[i][j]*=c;
		
		return this;
	}
	Matrice transpusa()
	{
		
		Matrice rez=new Matrice(n,m);
		for(int i=0;i<n;i++)
			{for(int j=0;j<m;j++)
			{rez.data[j][i]=data[i][j];}}
		
		
		return rez;
		
	}
	public static void main(String[] args) {
		double [][] a1= new double [3][3];
		for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
            	a1[row][col] = row*col;

		
		double [][] a2= new double [3][3];
		for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
            	a2[row][col] = row+col;
		
		
		Matrice m1=new Matrice(a1);
		Matrice m2=new Matrice(a2);
		Matrice m3=new Matrice(a1);
		m1.display();
		m1.display(1, 1);
		m1.display(2);
		System.out.println();
		m3=aduna(m1,m2);
		m3.display();
		m3.inmultire(3);
		m3.display();
		System.out.println();
		m1=m3.transpusa();
		m1.display();
	}

}
