package database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.DonHangOnline;

public class DonHangOnlineDAO {
    private Connection conn;

    public DonHangOnlineDAO() {
    	DBConnect db = new DBConnect();
    	this.conn = db.getConnection();// Get connection from DBConnect class
    }

    public boolean addDonHangOnline(DonHangOnline donHang) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DONHANGONLINE (ngaydat, diachi, hoten, sdt, tongtien, phuongthucthanhtoan, tinhtranghoadon) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setDate(1, donHang.getNgayDat());
            pstmt.setString(2, donHang.getDiaChi());
            pstmt.setString(3, donHang.getHoTen());
            pstmt.setString(4, donHang.getSdt());
            pstmt.setInt(5, donHang.getTongTien());
            pstmt.setString(6, donHang.getPhuongThucThanhToan());
            pstmt.setInt(7, donHang.getTinhTrangHoaDon());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDonHangOnline(int id) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM DONHANGONLINE WHERE id_dho = ?");
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDonHangOnline(DonHangOnline donHang) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE DONHANGONLINE SET ngaydat = ?, diachi = ?, hoten = ?, sdt = ?, tongtien = ?, phuongthucthanhtoan = ?, tinhtranghoadon = ? WHERE id_dho = ?");
            pstmt.setDate(1, donHang.getNgayDat());
            pstmt.setString(2, donHang.getDiaChi());
            pstmt.setString(3, donHang.getHoTen());
            pstmt.setString(4, donHang.getSdt());
            pstmt.setInt(5, donHang.getTongTien());
            pstmt.setString(6, donHang.getPhuongThucThanhToan());
            pstmt.setInt(7, donHang.getTinhTrangHoaDon());
            pstmt.setInt(8, donHang.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DonHangOnline> getAllDonHangOnline() {
        List<DonHangOnline> donHangs = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DONHANGONLINE");

            while (rs.next()) {
                int id = rs.getInt("id_dho");
                Date ngayDat = rs.getDate("ngaydat");
                String diaChi = rs.getString("diachi");
                String hoTen = rs.getString("hoten");
                String sdt = rs.getString("sdt");
                int tongTien = rs.getInt("tongtien");
                String phuongThucThanhToan = rs.getString("phuongthucthanhtoan");
                int tinhTrangHoaDon = rs.getInt("tinhtranghoadon");

                DonHangOnline donHang = new DonHangOnline(id, ngayDat, diaChi, hoTen, sdt, tongTien, phuongThucThanhToan, tinhTrangHoaDon);
                donHangs.add(donHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donHangs;
    }
    
    public int countDonHang() {
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM DONHANGONLINE");

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
