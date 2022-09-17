package Business;
import java.sql.*;

/*******************
 * Adv Sys Proj
 * Admin.java
 ******************/

public class Admin {
    
    int id;
    String username;
    String password;

    public Admin( int id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Admin() {

        id = 0;
        username = "";
        password = "";
    }

    //testing
    public static void main(String arg[]) {
        Admin a = new Admin();
        a.selectDB(123);
        a.display();
        
    }
    
// Get Set //

    public void setId( int Id ) { id = Id; }
    public int getId() { return id; }

    public void setUsername( String Username ) { username = Username; }
    public String getUsername() { return username; }

    public void setPassword( String Password ) { password = Password; }
    public String getPassword() { return password; }

// Select DB //
    
    public void selectDB(int tid) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Admin where AdminID = " + Integer.toString(tid));
            rs.next();
            setId(Integer.parseInt(rs.getString(3)));
            setUsername(rs.getString(1));
            setPassword(rs.getString(2));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(int tid, String tusername, String tpassword) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Admin (AdminID, UserName, Password) values (" + tid + ", '" + tusername + "', '" + tpassword + "')";
            int n1 = stmt.executeUpdate(sql);
            setId(tid);
            setUsername(tusername);
            setPassword(tpassword);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDB(String tusername, String tpassword) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Guests set UserName = '" + tusername + "', Password = '" + tpassword + "', where AdminID = " + id;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "delete from Admin where AdminID = " + id;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void display() {
        System.out.println("Admin ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }
}
