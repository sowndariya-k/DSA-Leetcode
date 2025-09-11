package zoho1;
import java.util.*;
public class GuessNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		List<Integer> list=new ArrayList<>();
		System.out.println("Enter player1 name: ");
		String name1=sc.nextLine();
		System.out.println("Enter player2 name: ");
		String name2=sc.nextLine();
		
		System.out.println("Lets Start the game...");
		while(list.size()!=5) {
		int d=r.nextInt(10);
		if(!list.contains(d))
		list.add(d);
		}
		
		List<Integer> player1=new ArrayList<>();
		List<Integer> player2=new ArrayList<>();
		int p1=0,p2=0;
		for(int i=0; i<3;i++) {
		System.out.println("Enter player1 choice: ");
		int ch=sc.nextInt();
		while(player1.contains(ch) || player2.contains(ch)) {
			System.out.println("It's already taken Enter again..");
			ch=sc.nextInt();
		}
		player1.add(ch);
		if(list.contains(ch)) {
			System.out.println("CORRECT");
			p1++;
		}else {
			System.out.println("WRONG");
		}
		
		
		System.out.println("Enter player2 choice: ");
		int c=sc.nextInt();
		while(player1.contains(c) || player2.contains(c)) {
			System.out.println("It's already taken Enter again..");
			c=sc.nextInt();
		}
		player2.add(c);
		if(list.contains(c)) {
			System.out.println("CORRECT");
			p2++;
		}else {
			System.out.println("WRONG");
		}
	}	
	
		System.out.println("Computer guess : "+list);
		System.out.println("Player1 Score : "+player1);
		System.out.println("Player1 Score : "+p1);
		System.out.println("Player1 Score : "+player2);
		System.out.println("Player2 Score : "+p2);
        if(p1>p2) {
        	System.out.println("Player1 wins");
        }else if(p1<p2){
        	System.out.println("Player2 wins");
        }else {
        	System.out.println("Draw");
        }
}
}
