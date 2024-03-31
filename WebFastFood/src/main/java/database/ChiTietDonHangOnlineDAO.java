package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDonHangOnline;

public class ChiTietDonHangOnlineDAO {
    private Connection conn;

    public ChiTietDonHangOnlineDAO() {
    	DBConnect db = new DBConnect();
    	this.conn = db.getConnection(); // Get connection from DBConnect class
    }

    public boolean addChiTietDonHangOnline(ChiTietDonHangOnline chiTiet) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CHITIETDONHANGONLINE (id_dho, id_mon, sl, thanhtien, giaban) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, chiTiet.getIdDonHang());
            pstmt.setInt(2, chiTiet.getIdMon());
            pstmt.setInt(3, chiTiet.getSoLuong());
            pstmt.setInt(4, chiTiet.getThanhTien());
            pstmt.setInt(5, chiTiet.getGiaBan());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChiTietDonHangOnline(int idDonHang, int idMon) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CHITIETDONHANGONLINE WHERE id_dho = ? AND id_mon = ?");
            pstmt.setInt(1, idDonHang);
            pstmt.setInt(2, idMon);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateChiTietDonHangOnline(ChiTietDonHangOnline chiTiet) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE CHITIETDONHANGONLINE SET sl = ?, thanhtien = ?, giaban = ? WHERE id_dho = ? AND id_mon = ?");
            pstmt.setInt(1, chiTiet.getSoLuong());
            pstmt.setInt(2, chiTiet.getThanhTien());
            pstmt.setInt(3, chiTiet.getGiaBan());
            pstmt.setInt(4, chiTiet.getIdDonHang());
            pstmt.setInt(5, chiTiet.getIdMon());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ChiTietDonHangOnline> getAllChiTietDonHangOnline() {
        List<ChiTietDonHangOnline> chiTiets = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CHITIETDONHANGONLINE");

            while (rs.next()) {
                int idDonHang = rs.getInt("id_dho");
                int idMon = rs.getInt("id_mon");
                int soLuong = rs.getInt("sl");
                int thanhTien = rs.getInt("thanhtien");
                int giaBan = rs.getInt("giaban");

                ChiTietDonHangOnline chiTiet = new ChiTietDonHangOnline(idDonHang, idMon, soLuong, thanhTien, giaBan);
                chiTiets.add(chiTiet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTiets;
    }

}
