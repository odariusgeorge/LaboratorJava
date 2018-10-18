
public class Patrat extends Figura {
	private int latura;
	public Patrat()
	{
		
	}
	public Patrat(int l)
	{
		this.latura=l;
	}
	public double arie()
	{
		return this.latura*this.latura;
	}
	public double perimetru()
	{
		return 4*this.latura;
	}
	public String toString()
	{
		return "Patrat: "+arie()+" "+perimetru();
	}
	public void show()
	{
		System.out.println("Patrat: "+arie()+" "+perimetru());
	}
	public int getLatura()
	{
		return this.latura;
	}
	public static void main(String[] args) {
		

	}

}
