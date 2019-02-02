import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet implements Servlet {
    private ServletConfig config = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("servlet is initialized");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");

        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("<b>hello simple servlet </b>");
        out.print("</body></html>");


    }

    @Override
    public String getServletInfo() {
        return "Copyright 2019";
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is destroyed");
    }
}
