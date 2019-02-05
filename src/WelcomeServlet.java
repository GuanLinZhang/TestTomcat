import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WelcomeServlet",urlPatterns = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("Link.html").include(req, resp);

        Cookie[] cookies = req.getCookies();


        Cookie c = cookies[0];
        if (c.getName().equals("username") && !c.getValue().equals("")) {
            out.println("Welcome " + c.getValue());
        } else {
            out.println("Please Login First");
            req.getRequestDispatcher("Login.html").include(req, resp);
        }
        out.close();
    }
}
