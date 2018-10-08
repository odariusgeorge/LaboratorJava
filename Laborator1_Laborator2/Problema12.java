import java.util.*;
public class Problema12 {

	public static void main(String[] args) {
		
		String s=args[0];
		String cuvant="Programator";
		int index=cuvant.indexOf(s);
		while(index>=0)
		{
		
			System.out.println(index);
			index=cuvant.indexOf(s,index+1);
		
		}
	}
	

}
