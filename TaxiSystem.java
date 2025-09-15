package zoho1;
import java.util.*;

//Booking class to store ride details
class Booking {
 int customerId;
 char pickupPoint;
 char dropPoint;
 int pickupTime;
 int dropTime;
 int fare;
 int taxiId;

 Booking(int customerId, char pickupPoint, char dropPoint, int pickupTime,
         int dropTime, int fare, int taxiId) {
     this.customerId = customerId;
     this.pickupPoint = pickupPoint;
     this.dropPoint = dropPoint;
     this.pickupTime = pickupTime;
     this.dropTime = dropTime;
     this.fare = fare;
     this.taxiId = taxiId;
 }

 @Override
 public String toString() {
     return "Customer " + customerId + " : " + pickupPoint + " -> " + dropPoint +
             " | Pickup: " + pickupTime + " | Drop: " + dropTime +
             " | Fare: " + fare;
 }
}

//Taxi class to represent each taxi
class Taxi {
 int id;
 char currentPoint;
 int freeAtTime;
 int totalEarnings;
 List<Booking> history;

 Taxi(int id) {
     this.id = id;
     this.currentPoint = 'A'; // all taxis start at A
     this.freeAtTime = 0;
     this.totalEarnings = 0;
     this.history = new ArrayList<>();
 }

 // Add a booking to this taxi
 void addBooking(Booking b) {
     history.add(b);
     totalEarnings += b.fare;
     currentPoint = b.dropPoint;
     freeAtTime = b.dropTime;
 }

 void printDetails() {
     System.out.println("\nTaxi-" + id + " | Total Earnings: Rs. " + totalEarnings);
     if (history.isEmpty()) {
         System.out.println("  No bookings yet.");
     } else {
         for (Booking b : history) {
             System.out.println("  " + b);
         }
     }
 }
}

//Main application
public class TaxiSystem {

 static Scanner sc = new Scanner(System.in);
 static List<Taxi> taxis = new ArrayList<>();

 public static void main(String[] args) {
     // Initialize 4 taxis
     for (int i = 1; i <= 4; i++) {
         taxis.add(new Taxi(i));
     }

     while (true) {
         // Print menu
         System.out.println("\n===== TAXI BOOKING MENU =====");
         System.out.println("1. Book Taxi");
         System.out.println("2. Display Taxi Details");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");

         int choice = sc.nextInt();

         switch (choice) {
             case 1:
                 bookTaxi();
                 break;

             case 2:
                 displayTaxiDetails();
                 break;

             case 3:
                 System.out.println("Exiting... Thank you!");
                 System.exit(0);

             default:
                 System.out.println("Invalid choice! Please try again.");
         }
     }
 }

 // Handle booking
 public static void bookTaxi() {
 System.out.print("Enter Customer ID: ");
 int customerId = sc.nextInt();

 System.out.print("Enter Pickup Point (A-F): ");
 char pickup = sc.next().toUpperCase().charAt(0);

 System.out.print("Enter Drop Point (A-F): ");
 char drop = sc.next().toUpperCase().charAt(0);

 // 🚨 Validation
 if (pickup < 'A' || pickup > 'F' || drop < 'A' || drop > 'F') {
     System.out.println("Invalid pickup or drop point! Please enter between A-F.");
     return;
 }
 if (pickup == drop) {
     System.out.println("Pickup and drop cannot be the same!");
     return;
 }

 System.out.print("Enter Pickup Time (hour): ");
 int pickupTime = sc.nextInt();
//----------
 Taxi chosenTaxi = findTaxi(pickup, pickupTime);

 if (chosenTaxi == null) {
     System.out.println("No taxi available for this booking.");
     return;
 }

 int distance = calculateDistance(pickup, drop);
 int travelTime = distance / 15; // each 15 km = 1 hour
 int dropTime = pickupTime + travelTime;
 int fare = calculateFare(distance);

 Booking b = new Booking(customerId, pickup, drop, pickupTime, dropTime, fare, chosenTaxi.id);
 chosenTaxi.addBooking(b);

 System.out.println("Taxi-" + chosenTaxi.id + " is allocated. Fare: Rs. " + fare);
}


 // Select best taxi
 public static Taxi findTaxi(char pickup, int pickupTime) {
     List<Taxi> available = new ArrayList<>();

     for (Taxi t : taxis) {
         if (t.freeAtTime <= pickupTime) {
             available.add(t);
         }
     }

     if (available.isEmpty()) return null;

     // Choose nearest taxi
     int minDistance = Integer.MAX_VALUE;
     List<Taxi> nearest = new ArrayList<>();

     for (Taxi t : available) {
         int d = Math.abs(pointIndex(t.currentPoint) - pointIndex(pickup));
         if (d < minDistance) {
             minDistance = d;
             nearest.clear();
             nearest.add(t);
         } else if (d == minDistance) {
             nearest.add(t);
         }
     }

     // If multiple, choose with lowest earnings
     Taxi chosen = nearest.get(0);
     for (Taxi t : nearest) {
         if (t.totalEarnings < chosen.totalEarnings) {
             chosen = t;
         }
     }
     return chosen;
 }

 // Convert point A-F to number
 public static int pointIndex(char p) {
     return p - 'A'; // A=0, B=1, C=2, ...
 }

 // Calculate distance between points
 public static int calculateDistance(char p1, char p2) {
     return Math.abs(pointIndex(p1) - pointIndex(p2)) * 15;
 }

 // Calculate fare based on distance
 public static int calculateFare(int distance) {
     if (distance <= 5) return 100;
     return 100 + (distance - 5) * 10;
 }

 // Display taxi details
 public static void displayTaxiDetails() {
     for (Taxi t : taxis) {
         t.printDetails();
     }
 }
}
