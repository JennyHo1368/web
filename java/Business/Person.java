package Business;
import java.sql.*;

/*******************
 * Adv Sys Proj
 * Person.java
 ******************/

public class Person {

    String fname;
    String lname;
    String email;
    int phone;

    public Person(String fname, String lname, String email, int phone) {

        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    public Person() {

        fname = "";
        lname = "";
        email = "";
        phone = 0;
    }
    
    //testing
    public static void main(String arg[]) {
        Person p = new Person();
        p.selectDB("bob.steve@gmail.com");
        p.display();
        p.deleteDB();
    }

    
// Get, Set //

    public void setFname( String Fname ) { fname = Fname; }
    public String getFname() { return fname; }

    public void setLname( String Lname ) { lname = Lname; }
    public String getLname() { return lname; }

    public void setEmail( String Email ) { email = Email; }
    public String getEmail() { return email; }

    public void setPhone( int Phone ) { phone = Phone; }
    public int getPhone() { return phone; }

// Select DB //
    
    public void selectDB(String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Person where Email = '" + temail + "'");
            rs.next();
            setFname(rs.getString(4));
            setLname(rs.getString(1));
            setEmail(rs.getString(2));
            setPhone(rs.getInt(3));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(String tfname, String tlname, String temail, int tphone) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Person (FName, LName, Email, Phone) values ('" + tfname + "', '" + tlname + "', '" + temail + "', '" + tphone + "')";
            int n1 = stmt.executeUpdate(sql);
            setFname(tfname);
            setLname(tlname);
            setEmail(temail);
            setPhone(tphone);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    //update using email
    public void updateDB(String tfname, String tlname, int tphone) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Person set FName = '" + tfname + "', LName = '" + tlname + "', Phone = '" + tphone + "' where Email = '" + email + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    //update using phone number
    public void updateDB2(String tfname, String tlname, String temail) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Person set FName = '" + tfname + "', LName = '" + tlname + "', Email = '" + temail + "' where Phone = '" + phone + "'";
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
            String sql = "delete from Person where Email = '" + email + "'";
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Display //
    
    public void display() {
        System.out.println("First Name  : " + fname);
        System.out.println("Last Name   : " + lname);
        System.out.println("Email       : " + email);
        System.out.println("Phone Number: " + phone);
    }
}
