package PresentationLayer;

import FunctionLayer.Login.LogicFacade;
import FunctionLayer.Login.LoginSampleException;
import FunctionLayer.Login.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("email", user.getEmail());
            if (user.isAdmin()) {
                session.setAttribute("role", "employee");
                return "employeepage";
            } else {
                session.setAttribute("role", "customer");
                return "customerpage";
            }
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }

}
