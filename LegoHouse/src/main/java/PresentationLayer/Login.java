package PresentationLayer;

import FunctionLayer.Login.LogicFacade;
import FunctionLayer.Login.LoginSampleException;
import FunctionLayer.Login.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("email", user.getEmail());
        if (user.isAdmin()) {
            session.setAttribute("role", "employee");
        return "employeepage";
        }
        else {
            session.setAttribute("role", "customer");
        return "customerpage";
        }
    }

}
