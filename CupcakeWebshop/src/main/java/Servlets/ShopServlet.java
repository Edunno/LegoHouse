/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DBConnector.*;
import Orders.Order;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * This servlet handles feeding shop.jsp the Cupcake options from the database using the DataMapper object
 * Also creates a new Order object for the user, if it doesn't exist
 * 
 * 
 * @author caspe
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

    User currentUser;
    Order currentOrder;
    DataMapper dm = new DataMapper();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<CupcakeTopping> ct = dm.getAllToppings();
            session.setAttribute("toppings", ct);
            ArrayList<CupcakeBottom> cb = dm.getAllBottoms();
            session.setAttribute("bottoms", cb);
            currentUser = (User) session.getAttribute("user");
            if (currentUser.getUserOrder() == null) {
                currentUser.setUserOrder(new Order());
                session.setAttribute("user", currentUser);
            }

            // request.getRequestDispatcher("mainPage.jsp").forward(request, response);
            response.sendRedirect("/CupcakeWebshop-1.0-SNAPSHOT/shop.jsp");

        }
    }

    //Not working yet - is going to add cash to balance
    private int updateBalance(HttpServletRequest req) throws Exception {
        String balance = req.getParameter("balance");
        int blc = Integer.parseInt(balance);
        return blc;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //   doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
