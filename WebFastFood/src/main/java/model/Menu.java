package model;

public class Menu {
    private int id;
    private int loaiId;
    private String tenMon;
    private int giaBan;
    private String ghiChu;
    private String hinh;

    public Menu(int id, int loaiId, String tenMon, int giaBan, String ghiChu, String hinh) {
        this.id = id;
        this.loaiId = loaiId;
        this.tenMon = tenMon;
        this.giaBan = giaBan;
        this.ghiChu = ghiChu;
        this.hinh = hinh;
    }

    // Các phương thức getter và setter cho các thuộc tính

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoaiId() {
        return loaiId;
    }

    public void setLoaiId(int loaiId) {
        this.loaiId = loaiId;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", loaiId=" + loaiId +
                ", tenMon='" + tenMon + '\'' +
                ", giaBan=" + giaBan +
                ", ghiChu='" + ghiChu + '\'' +
                ", hinh='" + hinh + '\'' +
                '}';
    }
}

