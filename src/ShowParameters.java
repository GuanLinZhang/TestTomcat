import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ShowParameters", urlPatterns = "/ShowParameters")
public class ShowParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String title = "Reading All Request Parameters";
        out.println("<html><head><title>Reading All Request Parameters</title></head>"
                + "<body bgColor= '#FDF5E6'>\n" + "<h1 align= center>" + title
                + "</h1>\n" + "<table border= 1 align= center>\n"
                + "<tr bgColor=\"#FFAD00\">\n"
                + "<th>Parameter Name<th>Parameter Values(s)");

        for (Map.Entry<String, String[]> stringEntry : req.getParameterMap().entrySet()) {
            String paramName = stringEntry.getKey();
            out.println("<tr><td>" + paramName + "</td>");

            String[] paramValues = stringEntry.getValue();

            if (paramValues.length == 1) {
                String v = paramValues[0];
                if (v.length() == 0) {
                    out.println("<td><i>No value</i></td>");
                } else {
                    out.println("<td>" + v + "</td>");
                }
            } else {
                out.println("<td><ul>");
                for(String s : paramValues) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ul></td>");
            }
        }
        out.close();
    }
}
