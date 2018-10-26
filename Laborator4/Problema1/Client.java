
public class Client {
	String nume;
	String adresa;
	Cont [] conturi;
	
	Client()
	{}
	Client(String n,String a,Cont [] c)
	{
		this.nume=n;
		this.adresa=a;
		this.conturi=c;
		if(this.conturi.length>5)
			throw new RuntimeException("Ilegal");
	}
	public void setContBancar(Cont[] cont)
	{
		this.conturi=cont;
	}
}
