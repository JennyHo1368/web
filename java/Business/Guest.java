package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */
public class Guest extends Person{
    String guestID;
    int orderNo;
    
    public Guest() {
        guestID = "";
        orderNo = 0;
    }
    
    public Guest(String tguestID, int torderNo) {
        guestID = tguestID;
        orderNo = torderNo;
    }
    
    //testing
    public static void main(String arg[]) {
        Guest g = new Guest();
        g.selectDBG("12345678");
        g.displayG();
        g.deleteDBG();
    }
    
    //get and set variables
    public void setGuestID(String tguestID) { guestID = tguestID; }
    public String getGuestID() { return guestID; }
    
    public void setOrderNo(int torderNo) { orderNo = torderNo; }
    public int getOrderNo() { return orderNo; }
    
// Select DB //
    
    public void selectDBG(String tguestID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Guests where GuestID = '" + tguestID + "'");
            rs.next();
            setGuestID(rs.getString(1));
            setOrderNo(rs.getInt(2));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDBG(String tguestID, int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Guests (GuestID, OrderNo) values ('" + tguestID + "', " + torderNo + ")";
            int n1 = stmt.executeUpdate(sql);
            setGuestID(tguestID);
            setOrderNo(torderNo);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    //the only thing I can think to update is the order number if we even need to update it
    public void updateDBG(String tguestID, int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Guests set OrderNo = " + torderNo + "where GuestID = '" + tguestID + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDBG() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "delete from Guests where GuestID = '" + guestID + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void displayG() {
        System.out.println("Guest ID    : " + guestID);
        System.out.println("Order Number: " + orderNo);
    }
}
