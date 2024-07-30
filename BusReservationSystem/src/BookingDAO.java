import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {
    public int getBookedCount(int BusNo, java.sql.Date date) throws SQLException {
        String query = "SELECT COUNT(*) FROM Booking WHERE BusNo = ? AND Travel_Date = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, BusNo);
        pst.setDate(2, date);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int bookedCount = rs.getInt(1);
        rs.close();
        pst.close();
        con.close();
        return bookedCount;
    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO Booking(PassengerName, BusNo, Travel_Date) VALUES (?, ?, ?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
            pst.setString(1, booking.passengerName);
            pst.setInt(2, booking.BusNo);
            pst.setDate(3, sqlDate);
            pst.executeUpdate();

            // Reduce the capacity
            BusDAO busDao = new BusDAO();
            int currentCapacity = busDao.getCapacity(booking.BusNo);
            if (currentCapacity > 0) {
                busDao.updateCapacity(booking.BusNo, currentCapacity - 1);
            }
        }
    }

}
