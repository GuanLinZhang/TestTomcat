import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ConfigServlet",
            urlPatterns = "/ConfigServlet",
            initParams = {@WebInitParam(name = "ConfigServlet",value = "Config")})
public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        ServletConfig config = getServletConfig();
        PrintWriter out = resp.getWriter();

        Enumeration<String> eArray = config.getInitParameterNames();

        while (eArray.hasMoreElements()) {
            String el = eArray.nextElement();
            System.out.println("name: " + el);
            System.out.println("value: "+ config.getInitParameter(el));
        }
        out.close();

    }
}
