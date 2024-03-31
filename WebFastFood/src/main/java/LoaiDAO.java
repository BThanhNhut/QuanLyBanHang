import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DBConnect;
import model.Loai;

public class LoaiDAO {
    private Connection conn;

    public LoaiDAO() {
    	DBConnect db = new DBConnect();
    	this.conn = db.getConnection();// Lấy kết nối từ lớp DBConnect // Get connection from DBConnect class
    }

    public boolean addLoai(Loai loai) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO LOAI (id_loai, tenloai) VALUES (?, ?)");
            pstmt.setInt(1, loai.getId_loai());
            pstmt.setString(2, loai.getTenloai());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteLoai(int loaiId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM LOAI WHERE id_loai = ?");
            pstmt.setInt(1, loaiId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLoai(Loai loai) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE LOAI SET tenloai = ? WHERE id_loai = ?");
            pstmt.setString(1, loai.getTenloai());
            pstmt.setInt(2, loai.getId_loai());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Loai> getAllLoai() {
        List<Loai> loais = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM LOAI");

            while (rs.next()) {
                int id = rs.getInt("id_loai");
                String tenLoai = rs.getString("tenloai");

                Loai loai = new Loai(id, tenLoai);
                loais.add(loai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loais;
    }

}
