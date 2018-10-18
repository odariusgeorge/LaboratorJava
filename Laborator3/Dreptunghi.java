
public class Dreptunghi extends Figura {
	private int lungime;
	private int latime;
	public Dreptunghi()
	{
		
	}
	public Dreptunghi(int l1,int l2)
	{
		this.lungime=l1;
		this.latime=l2;
	}
	public double arie()
	{
		return this.lungime*this.latime;
	}
	public double perimetru()
	{
		return 2*this.lungime+2*this.latime;
	}
	public String toString()
	{
		return "Dreptunghi: "+arie()+" "+perimetru();
	}
	public void show()
	{
		System.out.println("Dreptunghi: "+arie()+" "+perimetru());
	}
}
