
public class TestFigura {

	public static void main(String[] args) {
		Patrat p=new Patrat(3);
		Figura [] tab =new Figura[3];
		tab[0]=new Dreptunghi(2,4);
		tab[1]=new Patrat(2);
		tab[2]=new Cerc(3);
		for(int i=0;i<tab.length;i++)
		{
			System.out.println(tab[i]);
		}
		int contor=0;
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i] instanceof Cerc)
				contor++;
			
		}
		System.out.println(contor);
		for(int i=0;i<tab.length;i++)
		{
			if( tab[i] instanceof Patrat )
				System.out.println(((Patrat)tab[i]).getLatura());
			
		}
	}

}
