import Service.RegisterService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private RegisterService registerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        registerService = new RegisterService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get account data
        String n = req.getParameter("userName");
        String p = req.getParameter("userPass");

        //sign up
        registerService.signUp(n,p);

        resp.addCookie(new Cookie("username", n));
        //redirect
        resp.sendRedirect("/test/WelcomeServlet");
    }
}
