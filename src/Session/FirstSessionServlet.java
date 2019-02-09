package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet(name = "FirstSessionServlet",urlPatterns = "/FirstSessionServlet")
public class FirstSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(true);


        String uname = req.getParameter("username");
        session.setAttribute("username", uname);

        out.println("<a href= 'SecondSessionServlet'>Visit</a>");
    }
}
