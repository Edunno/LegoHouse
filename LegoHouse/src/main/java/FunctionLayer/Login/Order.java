/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Login;

import java.sql.Date;

/**
 *
 * @author Esben
 */
public class Order {
 private int orderNr;
 private int width;
 private int length;
 private int height;
 private String bandType;
 private int x4;
 private int x2;
 private int x1;
 private boolean isShipped = false;
 private Date shipDate;
 private String userName;
 private String whoShipped;

    public Order( int width, int length, int height, String bandType, int x4, int x2, int x1, String userName) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.bandType = bandType;
        this.x4 = x4;
        this.x2 = x2;
        this.x1 = x1;
        this.userName = userName;
    }

    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public void setWhoShipped(String whoShipped) {
        this.whoShipped = whoShipped;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public String getBandType() {
        return bandType;
    }

    public int getX4() {
        return x4;
    }

    public int getX2() {
        return x2;
    }

    public int getX1() {
        return x1;
    }

    public boolean isIsShipped() {
        return isShipped;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getWhoShipped() {
        return whoShipped;
    }
 
    
 
}
