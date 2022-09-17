package Business;
import java.sql.*;

/**
 * Advance System Project
 * Constantaras / Blaine
 */

public class Order {
    int orderNo, productNo, quantity;
    String custID;
    
    public Order() {
        orderNo = 0;
        custID = "";
        productNo = 0;
        quantity = 0;
    }
    
    public Order(int torderNo, String tcustID, int tproductNo, int tquantity) {
        orderNo = torderNo;
        custID = tcustID;
        productNo = tproductNo;
        quantity = tquantity;
    }
    
    //testing
    public static void main(String arg[]) {
        Order o = new Order();
        o.insertDB(123, "12345678", 123, 12);
        o.display();
    }
    
    //get and set variables
    public void setOrderNo(int torderNo) { orderNo = torderNo;}
    public int getOrderNo() { return orderNo; }
    
    public void setCustID(String tcustID) { custID = tcustID; }
    public String getCustID() { return custID; }
    
    public void setProductNo(int tproductNo) { productNo = tproductNo; }
    public int getProductNo() { return productNo;}
    
    public void setQuantity(int tquantity) { quantity = tquantity; }
    public int getQuantity() { return quantity; }
    
// Select DB //
    
    public void selectDB(int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Orders where OrderNo = " + Integer.toString(torderNo));
            rs.next();
            setOrderNo(Integer.parseInt(rs.getString(1)));
            setCustID(rs.getString(2));
            setProductNo(Integer.parseInt(rs.getString(3)));
            setQuantity(Integer.parseInt(rs.getString(4)));
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Insert DB //
    // I do not know how to insert because of the foreign key I think?
    public void insertDB(int torderNo, String tcustID, int tproductNo, int tquantity) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "insert into Orders (OrderNo, CustID, ProductNo, Quantity) values (" + torderNo + ", '" + tcustID + "', " + tproductNo + ", " + tquantity + ")";
            int n1 = stmt.executeUpdate(sql);
            con.close();
            setOrderNo(torderNo);
            setCustID(tcustID);
            setProductNo(tproductNo);
            setQuantity(tquantity);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

// Update DB //
    
    public void updateDB(String tcustID, int tproductNo, int tquantity) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "update Orders set CustID = '" + tcustID + "', ProductNo = " + tproductNo + ", Quantity = " + tquantity + "where OrderNo = " + orderNo;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Delete DB //
    
    public void deleteDB(int torderNo) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:\\Users\\joshu\\Desktop\\database jars\\WebSysProject.accdb");
            Statement stmt = con.createStatement();
            String sql = "delete from Orders where OrderNo = " + torderNo;
            int n1 = stmt.executeUpdate(sql);
            con.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
// Display //
    
    public void display() {
        System.out.println("Order Number  : " + orderNo);
        System.out.println("Customer ID   : " + custID);
        System.out.println("Product Number: " + productNo);
        System.out.println("Quantity      : " + quantity);
    }
}
