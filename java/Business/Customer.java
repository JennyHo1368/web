package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */
public class Customer extends Person {
    String custID, username, password, email;
    
    public Customer() {
        custID = "";
        username = "";
        password = "";
        email = "";
    }
    
    public Customer(String tcustID, String tusername, String tpassword, String temail) {
        custID = tcustID;
        username = tusername;
        password = tpassword;
        email = temail;
    }
    
    //testing
    public static void main(String arg[]) {
        Customer c = new Customer();
        c.selectDBC("12345678");
        c.deleteDBC();
    }

    
    //get and set variables
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setUsername(String tusername) { username = tusername; }
    public String getUsername() { return username; }
    
    public void setPassword(String tpassword) { password = tpassword; }
    public String getPassword() { return password; }
    
    public void setEmail(String temail) { email = temail; }
    public String getEmail() { return email; }

// Select DB //
    
    public void selectDBC(String tcustID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Customers where CustID = '" + tcustID + "'");
            rs.next();
            setCustID(rs.getString(2));
            setUsername(rs.getString(1));
            setPassword(rs.getString(3));
            setEmail(rs.getString(4));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDBC(String tcustID, String tusername, String tpassword, String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Customers (CustID, UserName, Password, Email) values ('" + tcustID + "', '" + tusername + "', '" + tpassword + "', '" + temail + "')";
            int n1 = stmt.executeUpdate(sql);
            setCustID(tcustID);
            setUsername(tusername);
            setPassword(tpassword);
            setEmail(temail);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDBC(String tusername, String tpassword, String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Customers set UserName = '" + tusername + "', Password = '" + tpassword + "', Email = '" + temail + "' where CustID = '" + custID + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDBC() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "delete from Customers where CustID = '" + custID + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void displayC() {
        System.out.println("Customer ID: " + custID);
        System.out.println("Username   : " + username);
        System.out.println("Password   : " + password);
        System.out.println("Email      : " + email);
    }
}
