package zoho1;
//clock program
import java.util.*;

public class Clock {

	public static void main(String[] args) throws InterruptException {
		Scanner sc=new Scanner(System.in);
		int h=sc.nextInt();
		int m=sc.nextInt();
		int s=sc.nextInt();
		
		while(true) {
			System.out.printf("\r%02d: %02d : %02d",h,m,s);
			System.out.flush();
			Thread.sleep(1000);
			
			s=s+1;
			if(s==60) {
				m=m+1;
				s=0;
			}
			if(m==60) {
				h=h+1;
				m=0;
				s=0;
			}
			if(h==13) {
				h=0;
				m=0;
				s=0;
			}
		}
		
	}

}
