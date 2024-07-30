import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
    public void displayBusInfo() throws SQLException {
        String query = "SELECT * FROM Bus";
        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("BusNo: " + rs.getInt(1));
            if (rs.getInt(2) == 0) {
                System.out.println("AC : Non AC bus");
            } else {
                System.out.println("AC : AC bus");
            }
            System.out.println("Capacity of the bus: " + rs.getInt(3));
        }
        rs.close();
        st.close();
        con.close();
    }

    public int getCapacity(int id) throws SQLException {
        String query = "SELECT Capacity FROM Bus WHERE ID = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int capacity = rs.getInt(1);
        rs.close();
        pst.close();
        con.close();
        return capacity;
    }

    public void updateCapacity(int busNo, int newCapacity) throws SQLException {
        String query = "UPDATE Bus SET Capacity = ? WHERE ID = ?";
        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, newCapacity);
        pst.setInt(2, busNo);
        pst.executeUpdate();
        pst.close();
        con.close();
    }
}
