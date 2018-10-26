
public class Test {

	public static void main(String[] args) {
		Cont []cb=new Cont[3];
		cb[0]=new Cont("A",3);
		cb[1]=new Cont("B",5);
		cb[2]=new Cont("C",6);
		Client []c=new Client[3];
		c[0]=new Client("A","B",cb);
		Banca b=new Banca("BT",c);
		System.out.println(b);
	}

}
