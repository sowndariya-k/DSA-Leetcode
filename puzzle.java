package zoho1;

import java.util.*;

public class puzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of legs:");
        int l = sc.nextInt();

        System.out.println("Enter number of heads:");
        int h = sc.nextInt();

        int cow = 0, hen = 0;
        boolean found = false;

        for (int c = 0; c <= h; c++) {   // try possible cow counts
            int hens = h - c;
            int legs = (c * 4) + (hens * 2);

            if (legs == l) {
                cow = c;
                hen = hens;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("No of cows: " + cow);
            System.out.println("No of hens: " + hen);
        } else {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}
