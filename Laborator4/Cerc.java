import java.text.DecimalFormat;
public class Cerc extends Figura{
	public final double pi=3.14;
	int raza;
	Cerc(int r)
	{
		this.raza=r;
	}
	public double arie()
	{	
		double arie=pi*raza*raza;
		arie= Double.parseDouble(new DecimalFormat(".##").format(arie));
		return arie;
	}
	public double perimetru()
	{
		return 2*pi*raza;
		
	}
	public String toString()
	{
		return "Cerc: "+arie()+" "+perimetru();
	}

}
