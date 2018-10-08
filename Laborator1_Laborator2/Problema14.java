import java.util.*;
import java.lang.*;
public class Problema14 {
	
	public static void main(String[] args) {
		
		StringBuffer str= new StringBuffer(8);
		str.append(args[0]);
		System.out.println(str.length());
			
		String str2=str.toString().replaceAll("i","I");
		
		str.delete(0, 8);
		str.append(str2);
		
		str2.replaceAll("I","i");
		System.out.println(str);
		System.out.println(str.substring(2,8));
		System.out.println(str2.toUpperCase());
		System.out.println(str.getClass().getSimpleName());
		System.out.println(str2.getClass().getSimpleName());
	}

}
