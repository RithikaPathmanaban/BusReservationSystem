import java.sql.SQLException;
import java.util.Scanner;

public class BusMain {

	public static void main(String[] args) throws SQLException {
	    BusDAO busDao = new BusDAO();
	    try {
	        busDao.displayBusInfo();
	        int userOpt = 1;
	        Scanner sc = new Scanner(System.in);
	        while (userOpt == 1) {
	            System.out.println("Enter 1 for booking and 2 to exit: ");
	            if (sc.hasNextInt()) {
	                userOpt = sc.nextInt();
	                sc.nextLine();
	            } else {
	                System.out.println("Invalid input. Valid inputs are 1 and 2");
	                sc.nextLine();
	                continue;
	            }
	            if (userOpt == 1) {
	                Booking booking = new Booking(sc);
	                if (booking.isAvailable()) {
	                    BookingDAO bookingDao = new BookingDAO();
	                    bookingDao.addBooking(booking);
	                    int updatedCapacity = busDao.getCapacity(booking.BusNo);
	                    System.out.println("Your booking is confirmed. Remaining seats: " + updatedCapacity);
	                } else {
	                    System.out.println("Sorry. Bus is full or unavailable. Try another bus or date.");
	                }
	            }
	        }
	        System.out.println("Thank you!");
	        sc.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

}
