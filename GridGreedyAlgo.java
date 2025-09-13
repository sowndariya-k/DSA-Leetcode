package zoho1;

import java.util.*;

public class GridGreedyAlgo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		char a[][]=new char[m][n];
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				if(j==0 || j==n-1) {
					a[i][j]='*';
				System.out.print(a[i][j]);
				}
				else if(i==j && i<5){
					a[i][j]='*';
					System.out.print(a[i][j]);
				}else if(i+j==8 &&i<5) {
					a[i][j]='*';
					System.out.print(a[i][j]);
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
