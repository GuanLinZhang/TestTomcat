package Service;

import Entity.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    private Connection conn;

    public boolean verifying(String name, String password) {
        DBHelper helper = new DBHelper();
        conn = helper.getConn();
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
        return false;
    }
}
