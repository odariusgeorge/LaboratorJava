
public class Tip{
	public String tip;
	
	Tip(String tip)
	{
		this.tip=tip;
	}
	public String toString()
	{
		return tip;
	}
	public String getTip()
	{
		return tip;
	}
	public static void main(String[] args) {
		Tip tip=new Tip("vedere");
		System.out.println(tip);

	}

}
