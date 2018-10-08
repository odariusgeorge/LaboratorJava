
public class p4 {
	public static void main(String[] args) 
	{
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		while(a!=b)
		{
			if(a>b)
				a=a-b;
			else
				b=b-a;
		}
		System.out.println(recursiv(a,b));
	}
	public static int recursiv(int a,int b)
	{
		if(a>b)
			return recursiv(a,a-b);
		else if(b>a)
			return recursiv(b-a,b);
		else
			return a;
		
	}
}
