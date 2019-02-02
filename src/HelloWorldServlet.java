import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld",urlPatterns = "/HelloWorld",loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //set the content type in MIME type sent to client
        resp.setContentType("text/html");


        //get the stream to write data
        PrintWriter pw = resp.getWriter();
        pw.print("<html><body><p>Hot Deployed</p></body></html>");
        pw.println();

        //close the stream
        pw.close();
    }
}
