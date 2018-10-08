
public class CiurulLuiEratostene {
	
	static boolean prim(int n)
	{
		if(n<2)
			return false;
		for(int d=2;d<=Math.sqrt(n);d++)
			if(n%d==0)
				return false;
		
		return true;
	}
	public static void main(String[] args) {
		boolean[]prime=new boolean[100];
		for(int i=0;i<100;i++)
			if(prim(i)==true)
				System.out.print(i+" ");
	}

}
