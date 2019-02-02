package Entity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
    Using JNDI(Java Naming and Directory Interface)
    Ref Guide:
        https://blog.csdn.net/jiangbingbo123/article/details/51398011

*/
public class DBHelper {
    private DataSource dataSource;

    public DBHelper() {
        try {
            InitialContext context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/mysql");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


}
