
public class Cont implements Operatiuni{
	String numarCont;
	float suma;
	public Cont()
	{}
	public Cont(String nC,float s)
	{
		this.numarCont=nC;
		this.suma=s;
	}
	public float  getSumaTotala()
	{
		return suma+getDobanda();
	}
	public float  getDobanda()
	{
		return suma+(float)0.1;
	}
	public void   depunere()
	{
		this.suma+=suma;
	}
	public void	  extragere()
	{
		this.suma-=suma;
		if(this.suma<0)
		{
			this.suma+=suma;
			throw new RuntimeException("Ilegal");
		}
	}
	public void transfer(Cont cb,float suma)
	{
		extragere();
		cb.depunere();
	}
}
