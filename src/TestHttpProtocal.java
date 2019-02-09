import java.io.*;
import java.net.Socket;

public class TestHttpProtocal {
    public static void main(String[] args) throws Exception {
        // establish the connection on server through socket
        // addr: localhost  port: 8080
        Socket s = new Socket("127.0.0.1",8080);

        /*
            write http header to the server,first,you need to have a writer write sth to
            the serve,but content of header are character,so need to convert char - byte that can writing to this socket
            so, need OutputStreamWriter
         */
        /*
            TODO: why use PrintWriter here, instead BufferedWriter?
            url: https://stackoverflow.com/questions/1747040/difference-between-java-io-printwriter-and-java-io-bufferedwriter
            alternative answers: the main advantage for that is PrintWriter doesn't throw exception
        */
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));


        //write http header to server through PrintWriter
        // /: refer to the url address i.e. GET /user?name=jack http 1.1
        pw.println("GET / HTTP/1.1");
        pw.println("Host: localhost");
        pw.println("Content-Type: text/html");
        pw.println();
        pw.flush();

        //init a buffer that handle response sent by the server
        String buffer = "";
        //read content from server
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //write response content to the specific file
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\guanl\\Desktop\\ResponseBody.html"));
        while ((buffer = br.readLine()) != null) {
            bw.write(buffer);
//            System.out.println(buffer);
        }

        //close connection
        bw.close();
        br.close();
        pw.close();
        s.close();

    }
}
