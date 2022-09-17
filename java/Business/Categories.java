package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */

public class Categories {
    int catID;
    String catName;
    
    Categories() {
        catID =0;
        catName = "";
    }
    
    Categories(int tcatID, String tcatName){
        catID = tcatID;
        catName = tcatName;
    }
    
    //get and set variables
    public void setCatID(int tcatID) { catID = tcatID; }
    public int getCatID() { return catID; }
    
    public void setCatName(String tcatName) { catName = tcatName; }
    public String getCatName() { return catName; }
    
// Select DB //
    
    public void selectDB(int tcatID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Categories where CategoryID = " + tcatID);
            rs.next();
            setCatID(rs.getInt(1));
            setCatName(rs.getString(2));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    
    public void insertDB(int tcatID, String tcatName) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Orders (CategoryID, CategoryName) values (" + tcatID + ", '" + tcatName + "')";
            int n1 = stmt.executeUpdate(sql);
            setCatID(tcatID);
            setCatName(tcatName);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDB(String tcatName) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Categories set CategoryName = '" + tcatName + "' where CategoryID = " + catID;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDB(int tcatID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "delete from Categories where CategoryID = " + tcatID;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void display() {
        System.out.println("Category ID  : " + catID);
        System.out.println("Category Name: " + catName);
    }
}

