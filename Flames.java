package zoho1;
import java.util.*;
public class Flames {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter boy name:");
		String name1=sc.nextLine();
		System.out.println("Enter girl name:");
		String name2=sc.nextLine();
		List<Character> l1=new ArrayList<>();
		List<Character> l2=new ArrayList<>();
		for(char c:name1.toCharArray()) {
			l1.add(c);
		}
		for(char c:name2.toCharArray()) {
			l2.add(c);
		}
		
		for(int i=0; i<l1.size();i++) {
			for(int j=0; j<l2.size();j++)
			if(l1.get(i).equals(l2.get(j))) {
				l1.set(i, '2');
				l2.set(j, '2');
			}
		}
		
		System.out.println(l1);
		System.out.println(l2);
		int c=0;
		List<Character> ans=new ArrayList<>(Arrays.asList('F','L','A','M','E','S'));
		
		for(char ch:l1) {
			if(ch!='2') {
				c=c+1;
			}
		}
		for(char ch:l2) {
			if(ch!='2') {
				c=c+1;
			}
		}
		System.out.println(c);
		
		int i=0;
		while(ans.size()!=1) {
			i=(i+(c-1))%ans.size();
			ans.remove(i);
		}
		System.out.println(ans);
	}

}
