import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContextAttributeResp",urlPatterns = "/ContextAttributeResp")
public class ContextAttributeResp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        ServletContext context = req.getServletContext();
        String attribute = (String) context.getAttribute("company");
        out.println("Welcome to " + attribute);
        out.close();
    }
}
