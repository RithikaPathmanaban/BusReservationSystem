import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int BusNo;
    Date date;

    Booking(Scanner sc) {
        System.out.println("Enter passenger name: ");
        passengerName = sc.nextLine();
        while (true) {
            System.out.println("Enter bus number:");
            if (sc.hasNextInt()) {
                BusNo = sc.nextInt();
                sc.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Enter a valid bus number");
                sc.nextLine(); // Consume invalid input
            }
        }
        System.out.println("Enter date (dd-mm-yyyy):");
        String dateInput = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public boolean isAvailable() throws SQLException {
        BusDAO busDao = new BusDAO();
        BookingDAO bookingDao = new BookingDAO();
        int capacity = busDao.getCapacity(BusNo); // Get current capacity
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int bookedCount = bookingDao.getBookedCount(BusNo, sqlDate); // Get booked count
        return bookedCount < capacity || (bookedCount == capacity && capacity > 0); // Allow booking if capacity is 0 during current process
    }
}
