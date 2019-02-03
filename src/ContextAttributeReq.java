import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContextAttributeReq",urlPatterns = "/ContextAttributeReq")
public class ContextAttributeReq extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        ServletContext context = getServletContext();
        context.setAttribute("company", "IBM");
        out.println("Welcome to first servlet");
        out.println("<a href='ContextAttributeResp'>visit</a>");
        out.close();
    }
}
