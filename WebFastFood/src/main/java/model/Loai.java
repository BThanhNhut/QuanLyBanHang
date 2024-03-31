package model;

public class Loai {
	private int id_loai;
	private String tenloai;
	
	public Loai() {
		super();
	}
	public int getId_loai() {
		return id_loai;
	}
	public void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public Loai(int id_loai, String tenloai) {
		super();
		this.id_loai = id_loai;
		this.tenloai = tenloai;
	}
}
