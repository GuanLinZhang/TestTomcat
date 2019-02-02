import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "/Context",urlPatterns = "/Context")
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        ServletContext context = getServletContext();
        Enumeration<String> eArray = context.getInitParameterNames();

        while (eArray.hasMoreElements()) {
            String e = eArray.nextElement();
            out.println(e);
            out.println(context.getInitParameter(e));
        }

        out.close();
    }
}
