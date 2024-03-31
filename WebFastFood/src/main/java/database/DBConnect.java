package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    // Các thông tin cần thiết để kết nối với cơ sở dữ liệu SQL Server
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://103.183.121.70:1433;databaseName=QuanLyNhaHang;trustServerCertificate=true";
    private static final String USER = "admin_nhahang";
    private static final String PASS = "123";

    // Phương thức để thiết lập kết nối với cơ sở dữ liệu
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Kiểm tra nếu kết nối thành công, in ra thông báo
            if (conn != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Xử lý lỗi theo ý của bạn
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
