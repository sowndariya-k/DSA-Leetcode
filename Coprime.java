package zoho1;
import java.util.*;
public class Coprime {
	
	
	public static boolean cop(int a,int b) {
	     return gcd(a,b)==1;
	}
	
	public static int gcd(int a,int b) {
		while(b!=0) {
			int rem=a%b;
			a=b;
			b=rem;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		for(int i=5;i<a;i++) {
			for(int j=4;j<i;j++) {
				for(int k=3;k<j;k++) {
					if(j*j+k*k==i*i && cop(i,j)&& cop(j,k) && cop(k,i)) {
						System.out.println(k+" "+j+" "+i+" ");
					}
				}
			}
		}

	}

}
