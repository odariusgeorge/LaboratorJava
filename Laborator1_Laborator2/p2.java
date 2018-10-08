
public class p2 {
	public static void main(String[] args) 
	{
		int n=Integer.parseInt(args[0]);
		int s=1;
		
		for(int i=1;i<=n;i++)
			s=s*i;
		
		System.out.println(s);
		
	}
}
