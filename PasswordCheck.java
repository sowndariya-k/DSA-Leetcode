package zoho1;
import java.util.*;
public class PasswordCheck {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		if(str.length()>7) {
			int up=0,lc=0,sc=0,d=0;
			for(char c:str.toCharArray()) {
				if(Character.isLowerCase(c)) {
					lc++;
				}else if(Character.isUpperCase(c)) {
					up++;
				}else if(Character.isDigit(c)) {
					d++;
				}else {
					sc++;
				}
			}
			
			if(up>0 && lc>0 && d>0 && sc>0) {
				System.out.println("Good");
			}else {
				System.out.println("Invalid password");
			}
		}else {
			System.out.println("Invalid password");
		}

	}

}
