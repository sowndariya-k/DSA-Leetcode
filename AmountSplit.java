package zoho1;
import java.util.*;
public class AmountSplit {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the amount: ");
    int amount=sc.nextInt();
    int coins[]= {500,200,100,50,20,10,2,1};
    for(int i=0; i<coins.length;i++) {
    	while(amount>=coins[i]) {
    		System.out.println(coins[i]);
    		amount-=coins[i];
    	}
    }

	}

}
