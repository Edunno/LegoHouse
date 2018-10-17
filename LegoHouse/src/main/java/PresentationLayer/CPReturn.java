/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Login.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esben
 */
public class CPReturn extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            if ((String)request.getSession().getAttribute("email") != null ) {
                return "customerpage";
            }
        } catch (Exception ex){
            throw new LoginSampleException("Acces denied. User timed out.");
        }
        return null;
    }

}
