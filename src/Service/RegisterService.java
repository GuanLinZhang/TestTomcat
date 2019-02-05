package Service;

import Entity.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {
    private Connection conn;


    public void signUp(String name,String password) {
        DBHelper helper = new DBHelper();
        conn = helper.getConn();

        try {
            //insert data
            PreparedStatement pstmt = conn.prepareStatement("insert into test.userinfo values (?,?);");
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            //update
            pstmt.executeUpdate();

            //close connection
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
