/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DB.DataMapper;
import FunctionLayer.Login.LoginSampleException;
import FunctionLayer.Login.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Esben Stores the current order as placed in the database.
 */
public class PlaceOrder extends Command {

    public PlaceOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession();
        int x4 = (int) ses.getAttribute("x4");
        int x2 = (int) ses.getAttribute("x2");
        int x1 = (int) ses.getAttribute("x1");
        String cus = (String) ses.getAttribute("email");
        int height = (int) ses.getAttribute("height");
        int length = (int) ses.getAttribute("length");
        int width = (int) ses.getAttribute("width");
        String band = "";
        switch ((int) ses.getAttribute("band")) {
            case 1:
                band = "½-stensforbandt";
                break;
            case 2:
                band = "1/4-stensforbandt";
                break;
            case 3:
                band = "Blok forbandt";
                break;
            case 4:
                band = "Kryds forbandt";
                break;
            case 5:
                band = "Engelsk forbandt";
                break;
        }
        Order newOrd = new Order(width, length, height, band, x4, x2, x1, cus);
        DataMapper dm = new DataMapper();
        int id = dm.insertOrder(newOrd);
        newOrd.setOrderNr(id);
        if (id != 0) {
            ses.setAttribute("lastorder", newOrd.getOrderNr());
            return "neworderpage";
        } else {
            return "customerpage";
        }
    }
}
