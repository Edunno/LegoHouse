/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Login;

import java.util.ArrayList;

/**
 *
 * @author Esben
 */
public class OrderList {

    private ArrayList<Order> a = new ArrayList();
    private int internCount = 0;
    private ArrayList printOrders = new ArrayList();

    public void addToArray(Order order) {
        a.add(order);
    }

    public Order getNextOrder() {
        return a.get(internCount++);
    }

    public ArrayList printOrders() {
        for (int i = 0; i < a.size(); i++) {
            Order g = a.get(i);
            printOrders.add(" Order nr: " + g.getOrderNr() + " Length: " + g.getLength() + " Width: " + g.getWidth() + " Height: " + g.getHeight() + " Band: " + g.getBandType());
        }
        return printOrders;
    }
}
