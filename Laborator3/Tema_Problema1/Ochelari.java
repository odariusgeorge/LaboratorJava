import java.util.*;
class Ochelari extends Tip{
	public String producator;
	public int pret;
	Ochelari()
	{	
		super("vedere");
		producator="Constructor implicit";
		pret=0;
		
	}
	Ochelari(String producator, int pret)
	{	
		super("soare");
		
		if(pret<0)
		{
			 throw new IllegalArgumentException("Parameters can't be null");
		}	
		
		this.pret=pret;
		
		this.producator=producator;
	}
	Ochelari(String producator, int pret,String tip)
	{	
		super("vedere");
		this.tip=tip;
		this.pret=pret;
		this.producator=producator;
		
	}
	static boolean compare(Ochelari o0,Ochelari o1)
	{
		if(o0.pret<o1.pret)
			return true;
		return false;
	}
	public String toString()
	{
		return producator+" "+pret+" "+getTip();
	}
	void increase(int x)
	{
		this.pret+=x;
	}
	public static void main(String[] args) {
		
		Ochelari o0=new Ochelari();
		System.out.println(o0);
		Ochelari o1=new Ochelari("A",20);
		System.out.println(o1);
		Ochelari o2=new Ochelari("B",50,"vedere");
		System.out.println(o2);
		System.out.println(compare(o1,o2));
		o2.increase(30);
		System.out.println(o2);
		
		
	
		
	}

}
