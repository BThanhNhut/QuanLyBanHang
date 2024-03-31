package database;

import java.util.List;

import model.ChiTietDonHangOnline;
import model.DonHangOnline;
import model.Loai;
import model.Menu;

public class testcode {

	public static void main(String[] args) {
		MenuDAO menu = new MenuDAO();
//		List<Menu> lstMenu = menu.getAllMenusById(5);
//		for (Menu item : lstMenu)
//		{
//			System.out.println(item.getTenMon());
//		}
//		List<Menu> lstMenu2 = menu.getAllMenus();
//		for (Menu item : lstMenu2)
//		{
//			System.out.println(item.getTenMon());
//		}
//		
//		LoaiDAO loai = new LoaiDAO();
//		List<Loai> lstLoai = loai.getAllLoai();
//		for(Loai item : lstLoai)
//		{
//			System.out.println(item.getTenloai());
//		}
		
		DonHangOnlineDAO donhangonline = new DonHangOnlineDAO();
		int a = donhangonline.countDonHang()+1;
		System.out.println("so lượng là " + a);
//		List<DonHangOnline> lst =  donhangonline.getAllDonHangOnline();
//		for(DonHangOnline a : lst)
//		{System.out.println("ket qua la " + a.getHoTen());
//		}
		
//		ChiTietDonHangOnlineDAO dao =  new ChiTietDonHangOnlineDAO();
//		List<ChiTietDonHangOnline> lst = dao.getAllChiTietDonHangOnline();
//		for(ChiTietDonHangOnline item : lst){
//			System.out.println(item.getIdMon());
//		}
		
		System.out.println("ket qua la" + menu.getMenuById(2));
	}

}
