
public class Banca {
	String codBancar;
	Client [] clienti;
	public Banca()
	{
		
	}
	public Banca(String cB,Client []c)
	{
		this.codBancar=cB;
		this.clienti=c;
	}
	public void setClienti(Client [] c)
	{
		this.clienti=c;
	}
}
