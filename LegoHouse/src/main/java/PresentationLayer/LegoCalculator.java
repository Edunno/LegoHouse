/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Login.BandCalculator;
import FunctionLayer.Login.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esben
 *
 * This class will acces functions to calculate amount of bricks on the order.
 */
public class LegoCalculator extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        int band = Integer.parseInt(request.getParameter("band"));
        HttpSession session = request.getSession();
        session.setAttribute("height", height);
        session.setAttribute("length", length);
        session.setAttribute("width", width);
        session.setAttribute("band", band);
        BandCalculator bc = new BandCalculator();
        switch (band) {
            case 1:
                int[] lego = bc.halfBand(width, length, height);
                session.setAttribute("x4", lego[0]);
                session.setAttribute("x2", lego[1]);
                session.setAttribute("x1", lego[2]);
                break;
            case 2:
            default:
        }
        return "customerpage";
    }

}