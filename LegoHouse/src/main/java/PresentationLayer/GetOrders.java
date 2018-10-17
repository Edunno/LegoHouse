/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DB.DataMapper;
import FunctionLayer.Login.LoginSampleException;
import FunctionLayer.Login.OrderList;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esben
 */
public class GetOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        DataMapper dm = new DataMapper();
        OrderList a = dm.getOrders((String)request.getSession().getAttribute("email"));
        ArrayList b = a.printOrders();
        request.getSession().setAttribute("orderList", b);
        return "orderpage";
    }

    
    
}
