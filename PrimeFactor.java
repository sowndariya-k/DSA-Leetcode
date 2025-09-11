package zoho1;
import java.util.*;
public class PrimeFactor {
	
	public static void Day2(int a,int num) {
		if(num==1) {
			return ;
		}
		while(num%a!=0) {
			a+=1;
		}
		System.out.println(a);
		Day2(a,num/a);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int a=sc.nextInt();
		Day2(a,num);			
	}

}
