/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import FunctionLayer.Login.BandCalculator;
import FunctionLayer.Login.LoginSampleException;
import FunctionLayer.Login.Order;
import FunctionLayer.Login.OrderList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import FunctionLayer.Login.User;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Esben
 */
public class DataMapper {

        /***For testing only***/ 
    public static void main(String[] args) {
        DataMapper d = new DataMapper();
        OrderList a = d.getOrders("Esben@hotmail.com");
        System.out.println(a.getNextOrder().getLength());
    }
    public User getUserInfo(String email, String password) {
        User aUser = null;
        try {
            Connection c = new DBConnector().getConnection();
            Statement st = c.createStatement();
            String query
                    = "SELECT Password, IsAdmin FROM Users WHERE Email = '" + email + "';";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                String pass = res.getString("Password");
                boolean isAdmin = res.getBoolean("IsAdmin");
                if (pass.equals(password)) {
                    aUser = new User(email, isAdmin);
                } else {
                    throw new LoginSampleException("Unknown username or invalid password.");
                }
            }
        } catch (Exception ex) {
            aUser = new User("Error", false);
            return aUser;
        }
        return aUser;
    }

    public boolean insertUser(String email, String pass) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                    = "INSERT INTO `Users` (Email, Password, IsAdmin) "
                    + "values('" + email + "', '" + pass + "'," + false + ");";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to create user");
            return false;
        }
        return true;
    }

    public boolean setUserAdmin(String name) {
        try {
            Connection c = new DBConnector().getConnection();
            Statement stmt = c.createStatement();
            String comm
                    = "UPDATE Users "
                    + "set IsAdmin = true "
                    + "where Email = '" + name + "';";
            stmt.execute(comm);
        } catch (Exception ex) {
            System.out.println("Error, unable to edit user");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int insertOrder(Order order) {
        int id = 0;
        try {
            Connection c = new DBConnector().getConnection();
            String sql = "INSERT INTO `HouseOrders` (Height, Length, Width, Band, BrickQty, Costumer) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Integer.toString(order.getHeight()));
            ps.setString(2, Integer.toString(order.getLength()));
            ps.setString(3, Integer.toString(order.getWidth()));
            ps.setString(4, order.getBandType());
            ps.setString(5, Integer.toString(order.getX4() + order.getX2() + order.getX1()));
            ps.setString(6, order.getUserName());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);
            return id;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public OrderList getOrders(String userName) {
        OrderList newList = new OrderList();
        try {
            Connection c = new DBConnector().getConnection();
            String sql = "SELECT * FROM `HouseOrders WHERE Costumer =?;";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("here12");
                int oID = rs.getInt("OrderId");
                int height = rs.getInt("Height");
                int length = rs.getInt("Length");
                int width = rs.getInt("Width");
                String band = rs.getString("Band");
                BandCalculator bc = new BandCalculator();
                int bandNumber = bc.bandType(band);
                int[] gX = bc.makeBands(width, length, height, bandNumber);
                Order newOrd = new Order(width, length, height, band, gX[0], gX[1], gX[2], userName);
                System.out.println(width+""+ length+""+ height+""+ band+""+ gX[0]+""+ gX[1]+""+ gX[2]+""+ userName);
                newList.addToArray(newOrd);
            }
        } catch (Exception ex) {

        }
        return newList;
    }
}
