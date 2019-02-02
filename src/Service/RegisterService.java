package Service;

import Entity.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {
    private Connection conn;

    public RegisterService() {
        DBHelper dbHelper = new DBHelper();
        conn = dbHelper.getConn();
    }

    public void signUp(String name,String password) {

        try {
            //insert data
            PreparedStatement pstmt = conn.prepareStatement("insert into test.userinfo values (?,?);");
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            //update
            pstmt.executeUpdate();

            //close connection
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
