/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import DBConnector.DBConnector;
import DBConnector.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author KimPPedersen
 */
public class OrderMapper {

    public User getUserInfo(String uName, String password) {
        User aUser = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT pw FROM users WHERE username = '" + uName + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                String pass = res.getString("pw");
                if (pass.equals(password)) {
                    aUser = new User("Works", 100);
                } else {
                    aUser = new User("Wrong pass", 0);
                }
            }
        } catch (Exception ex) {
            aUser = new User("Error", 0);
            return aUser;

        }
        return aUser;
    }

    public Order getOrderByID(int orderID, int userID, int price, int qty, String pname, String username, String customername) {
        Order oID = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT * "
                    + "FROM orders "
                    + "WHERE orderID = '"+ oID +"';" ;
            ResultSet res = st.executeQuery(query);
            userID = res.getInt(orderID);
            price = res.getInt("price");
            pname = res.getString("variant");
        } catch (Exception ex) {
            return null;
        }
            
        
        
        return oID;
    }
    
    
}