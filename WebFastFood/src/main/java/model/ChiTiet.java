package model;

public class ChiTiet {
	int id_mon;
	String tenmon;
	String hinh;
	int sl;
	int giaban;
	int thanhtien;
	
	public int getId_mon() {
		return id_mon;
	}
	public void setId_mon(int id_mon) {
		this.id_mon = id_mon;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public int getGiaban() {
		return giaban;
	}
	public void setGiaban(int giaban) {
		this.giaban = giaban;
	}
	public int getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	public ChiTiet(int id_mon, String tenmon, String hinh, int sl, int giaban, int thanhtien) {
		super();
		this.id_mon = id_mon;
		this.tenmon = tenmon;
		this.hinh = hinh;
		this.sl = sl;
		this.giaban = giaban;
		this.thanhtien = thanhtien;
	}
	public ChiTiet() {
		super();
	}
}
