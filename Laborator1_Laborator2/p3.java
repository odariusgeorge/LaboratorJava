import java.util.Random;
public class p3 {
	public static void main(String[] args) 
	{	
		int contor=0;
		Random r=new Random();
		int n=Integer.parseInt(args[0]);
		int nr;
		for(int i=0;i<n;i++)
		{	
			nr=r.nextInt()+1;
			if(nr>7)
			{
				contor++;
			}
			System.out.println(nr);
		}
		System.out.println();
		System.out.print("Numere mai mari decat n:");
		System.out.println(contor);
	}
}
