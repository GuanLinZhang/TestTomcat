import Service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login",urlPatterns = "/Login")
public class Login extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        loginService = new LoginService();
    }


    /**
        Can not be done in post method when send redirect to welcome page
        REMEMBER: resp.senRedirect() ALWAYS using GET method

        Ref Guide:
            https://stackoverflow.com/questions/14039121/can-sendredirect-act-as-a-post-method-instead-of-get-jsp-servlets

     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String n = req.getParameter("userName");
        String p = req.getParameter("userPass");

        if (loginService.verifying(n, p)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("Welcome");
            dispatcher.forward(req, resp);
        } else {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd= req.getRequestDispatcher("/ShowParameters.html");
            rd.include(req, resp);
        }
    }
}
