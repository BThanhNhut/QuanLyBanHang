package model;

import java.sql.Date;

public class DonHangOnline {
	private int id;
    private Date ngayDat;
    private String diaChi;
    private String hoTen;
    private String sdt;
    private int tongTien;
    private String phuongThucThanhToan;
    private int tinhTrangHoaDon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public int getTinhTrangHoaDon() {
		return tinhTrangHoaDon;
	}
	public void setTinhTrangHoaDon(int tinhTrangHoaDon) {
		this.tinhTrangHoaDon = tinhTrangHoaDon;
	}
	
	public DonHangOnline(int id, Date ngayDat, String diaChi, String hoTen, String sdt, int tongTien,
			String phuongThucThanhToan, int tinhTrangHoaDon) {
		super();
		this.id = id;
		this.ngayDat = ngayDat;
		this.diaChi = diaChi;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.tongTien = tongTien;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.tinhTrangHoaDon = tinhTrangHoaDon;
	}
	public DonHangOnline() {
		super();
	}
}
