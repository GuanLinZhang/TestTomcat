import Service.LoginService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String name = req.getParameter("userName");
        String password = req.getParameter("userPass");

        if (loginService.verifying(name,password)) {
            req.getRequestDispatcher("Link.html").include(req, resp);
            out.println("Login success");
            out.println("Welcome " + name);

            Cookie cookie = new Cookie("username", name);
            resp.addCookie(cookie);

        } else {
            out.println("error occur");
            req.getRequestDispatcher("Login.html").include(req, resp);
        }

        out.close();
    }
}
