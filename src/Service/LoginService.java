package Service;

import Entity.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    private Connection conn;

    public LoginService() {
        DBHelper dbHelper = new DBHelper();
        conn = dbHelper.getConn();
    }

    public boolean verifying(String name, String password) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("select username, password from test.userinfo where username = ? and password = ?");
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet set = pstmt.executeQuery();
            return set.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (pstmt != null) {
                    pstmt.close();
                    pstmt = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
