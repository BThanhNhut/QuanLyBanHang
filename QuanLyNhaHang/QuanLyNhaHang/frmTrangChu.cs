using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QuanLyNhaHang
{
    public partial class btnMenu : Form
    {
        frmTaiQuay frmtaiquay;
        frmTaiBan frmtaiban;
        frmBaoCao frmbaocao;
        frmKhachHang frmkhachhang;
        frmNhapHang frmnhaphang;
        public btnMenu()
        {
            InitializeComponent();
            mdiProp();
        }

        private void mdiProp()
        {
            this.SetBevel(false);
            Controls.OfType<MdiClient>().FirstOrDefault().BackColor = Color.FromArgb(232,234,237);
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
        bool menuExpand = false;
        private void MenuTransiton_Tick(object sender, EventArgs e)
        {
            if (menuExpand == false)
            {
                menuContainer.Height += 10;
                if (menuContainer.Height >= 232)
                {
                    MenuTransiton.Stop();
                    menuExpand = true;
                }
            }
            else{
                menuContainer.Height -= 10;
                if (menuContainer.Height <= 58) {
                    MenuTransiton.Stop();
                    menuExpand = false;
                }
            }
        }
        private void btnThongKe_Click(object sender, EventArgs e)
        {
            MenuTransiton.Start();
        }


        bool sidebarExpand = true;

        private void sidebarTransaction_Tick(object sender, EventArgs e)
        {
            if (sidebarExpand)
            {
                sidebar.Width -= 10;
                if (sidebar.Width <= 60)
                {
                    sidebarExpand = false;
                    sidebarTransaction.Stop();

                    btnTaiBan.Width = sidebar.Width;
                    btnTaiQuay.Width = sidebar.Width;
                    btnBaoCao.Width = sidebar.Width;
                    btnKhachHang.Width = sidebar.Width;
                    btnThem.Width = sidebar.Width;
                    btnNhapHang.Width = sidebar.Width;
                }
            }
            else {
                sidebar.Width += 10;
                if (sidebar.Width >= 275)
                {
                    sidebarExpand = true;
                    sidebarTransaction.Stop();

                    btnTaiBan.Width = sidebar.Width;
                    btnTaiQuay.Width = sidebar.Width;
                    btnBaoCao.Width = sidebar.Width;
                    btnKhachHang.Width = sidebar.Width;
                    btnThem.Width = sidebar.Width;
                    btnNhapHang.Width = sidebar.Width;

                }
            }
        }

        private void btnMenu2_Click(object sender, EventArgs e)
        {
            sidebarTransaction.Start();
        }

        private void sidebar_Paint(object sender, PaintEventArgs e)
        {

        }

        private void btnTaiQuay_Click(object sender, EventArgs e)
        {
            if (frmtaiquay == null)
            {
                frmtaiquay = new frmTaiQuay();
                frmtaiquay.FormClosed += Frmtaiquay_FormClosed;
                frmtaiquay.MdiParent = this;
                frmtaiquay.Dock = DockStyle.Fill;
                frmtaiquay.Show();
            }
            else
            {
                frmtaiquay.Activate();
            }
        }

        private void Frmtaiquay_FormClosed(object sender, FormClosedEventArgs e)
        {
            
        }

        private void btnTaiBan_Click(object sender, EventArgs e)
        {
            if (frmtaiban == null)
            {
                frmtaiban = new frmTaiBan();
                frmtaiban.FormClosed += Frmtaiban_FormClosed;
                frmtaiban.MdiParent = this;
                frmtaiban.Dock = DockStyle.Fill;
                frmtaiban.Show();
            }
            else {
                frmtaiban.Activate();
            }
        }

        private void Frmtaiban_FormClosed(object sender, FormClosedEventArgs e)
        {
            frmtaiban = null;
        }

        private void btnNhapHang_Click(object sender, EventArgs e)
        {
            if (frmnhaphang == null)
            {
                frmnhaphang = new frmNhapHang();
                frmnhaphang.FormClosed += Frmnhaphang_FormClosed;
                frmnhaphang.MdiParent = this;
                frmnhaphang.Dock = DockStyle.Fill;
                frmnhaphang.Show();
            }
            else
            {
                frmnhaphang.Activate();
            }
        }

        private void Frmnhaphang_FormClosed(object sender, FormClosedEventArgs e)
        {
            frmnhaphang = null;
        }
    }
}
