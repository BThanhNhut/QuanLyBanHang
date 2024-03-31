using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QuanLyNhaHang
{
    public partial class cardThucAn : UserControl
    {
        public cardThucAn()
        {
            InitializeComponent();
            this.MouseDown += MyUserControl_MouseDown;
            this.MouseUp += MyUserControl_MouseUp;
            this.MouseEnter += MyUserControl_MouseEnter;
            this.MouseLeave += MyUserControl_MouseLeave;
            this.Click += CardThucAn_Click;
        }

        private void CardThucAn_Click(object sender, EventArgs e)
        {
            frmChiTiet frmchitiet = new frmChiTiet();
            frmchitiet.Show();
        }

        private void MyUserControl_MouseDown(object sender, MouseEventArgs e)
        {
            // Thay đổi màu sắc khi người dùng nhấn chuột
            this.BackColor = Color.Red;
        }

        private void MyUserControl_MouseUp(object sender, MouseEventArgs e)
        {
            // Đặt lại màu sắc khi người dùng thả nút chuột
            this.BackColor = Color.White;
        }
        private void MyUserControl_MouseEnter(object sender, EventArgs e)
        {
            // Thực hiện hành động khi con trỏ chuột rê tới
            this.BackColor = Color.Yellow;
        }
        private void MyUserControl_MouseLeave(object sender, EventArgs e)
        {
            // Thực hiện hành động khi con trỏ chuột rời khỏi vùng User Control
            this.BackColor = Color.White;
        }
    }
}
