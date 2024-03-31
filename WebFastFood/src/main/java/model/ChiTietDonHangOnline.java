package model;

public class ChiTietDonHangOnline {
	private int idDonHang;
    private int idMon;
    private int soLuong;
    private int thanhTien;
    private int giaBan;
    
	public int getIdDonHang() {
		return idDonHang;
	}
	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}
	public int getIdMon() {
		return idMon;
	}
	public void setIdMon(int idMon) {
		this.idMon = idMon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	
	public ChiTietDonHangOnline(int idDonHang, int idMon, int soLuong, int thanhTien, int giaBan) {
		super();
		this.idDonHang = idDonHang;
		this.idMon = idMon;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.giaBan = giaBan;
	}
	public ChiTietDonHangOnline() {
		super();
	}
    
    
}
