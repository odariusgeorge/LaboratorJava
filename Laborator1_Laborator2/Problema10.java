import java.util.*;

public class Problema10 {

	public Problema10() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		int [] arr=new int[10];
		Random r=new Random();
		for(int i=0;i<10;i++)
			arr[i]=r.nextInt();
		
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
