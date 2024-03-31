package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Menu;

public class MenuDAO {
    private Connection conn;
    DBConnect db = new DBConnect();
    public MenuDAO() {
        this.conn = db.getConnection(); // Lấy kết nối từ lớp DBConnect
    }

    // Thêm menu vào cơ sở dữ liệu
    public boolean addMenu(Menu menu) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO MENU (id_loai, tenmon, giaban, ghichu, hinh) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, menu.getLoaiId());
            pstmt.setString(2, menu.getTenMon());
            pstmt.setInt(3, menu.getGiaBan());
            pstmt.setString(4, menu.getGhiChu());
            pstmt.setString(5, menu.getHinh());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xoá menu từ cơ sở dữ liệu dựa trên ID
    public boolean deleteMenu(int menuId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM MENU WHERE id_mon = ?");
            pstmt.setInt(1, menuId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin của menu trong cơ sở dữ liệu
    public boolean updateMenu(Menu menu) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE MENU SET id_loai = ?, tenmon = ?, giaban = ?, ghichu = ?, hinh = ? WHERE id_mon = ?");
            pstmt.setInt(1, menu.getLoaiId());
            pstmt.setString(2, menu.getTenMon());
            pstmt.setInt(3, menu.getGiaBan());
            pstmt.setString(4, menu.getGhiChu());
            pstmt.setString(5, menu.getHinh());
            pstmt.setInt(6, menu.getId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Hiển thị tất cả các menu từ cơ sở dữ liệu
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MENU");

            while (rs.next()) {
                int id = rs.getInt("id_mon");
                int loaiId = rs.getInt("id_loai");
                String tenMon = rs.getString("tenmon");
                int giaBan = rs.getInt("giaban");
                String ghiChu = rs.getString("ghichu");
                String hinh = rs.getString("hinh");

                Menu menu = new Menu(id, loaiId, tenMon, giaBan, ghiChu, hinh);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }
    
    
    public List<Menu> getAllMenusById(int idLoai) {
        List<Menu> menus = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu where id_loai ="+ idLoai);

            while (rs.next()) {
                int id = rs.getInt("id_mon");
                int loaiId = rs.getInt("id_loai");
                String tenMon = rs.getString("tenmon");
                int a = rs.getInt("giaban");
                String b = a+ "000";
                int giaBan = Integer.parseInt(b);
                String ghiChu = rs.getString("ghichu");
                String hinh = rs.getString("hinh");

                Menu menu = new Menu(id, loaiId, tenMon, giaBan, ghiChu, hinh);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }
    
    public Menu getMenuById(int idMon) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu where id_mon ="+ idMon);

            while (rs.next()) {
                int id = rs.getInt("id_mon");
                int loaiId = rs.getInt("id_loai");
                String tenMon = rs.getString("tenmon");
                int a = rs.getInt("giaban");
                String b = a+ "000";
                int giaBan = Integer.parseInt(b);
                String ghiChu = rs.getString("ghichu");
                String hinh = rs.getString("hinh");

                Menu menu = new Menu(id, loaiId, tenMon, giaBan, ghiChu, hinh);
                return menu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Đóng kết nối đến cơ sở dữ liệu
//    public void closeConnection() {
//        DBConnect.closeConnection(conn);
//    }
}
