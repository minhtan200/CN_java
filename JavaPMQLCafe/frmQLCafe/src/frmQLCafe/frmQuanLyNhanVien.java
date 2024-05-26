package frmQLCafe;

import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class frmQuanLyNhanVien extends JFrame  implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private JTextField txtTimKiem;
	 private JTextField txtMaNV;
	 private JTextField txtTenNV;
	 private JTextField txtChucDanh;
	 private JTextField txtLuong;
	 private JTextField txtCaLamViec;
	 private JTable tableDSNV;
  
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
            	   frmQuanLyNhanVien window = new frmQuanLyNhanVien();
                   window.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }

   
   public frmQuanLyNhanVien() {
   	getContentPane().setBackground(new Color(255, 255, 255));
       initialize();
   }


   private void initialize() {
       setTitle("Form Quản Lý Menu"); 
       setSize(1088, 714); 
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
       JPanel panel_1 = new JPanel();
       panel_1.setBackground(new Color(255, 255, 255));
       panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
       panel_1.setBounds(0, 61, 412, 570);
       getContentPane().add(panel_1);
       panel_1.setLayout(null);
       
       JLabel lblNewLabel_1_1 = new JLabel("Mã Nhân Viên :");
       lblNewLabel_1_1.setForeground(Color.BLACK);
       lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_1.setBounds(10, 186, 111, 22);
       panel_1.add(lblNewLabel_1_1);
       
       JLabel lblNewLabel_1_2 = new JLabel("Tên Nhân Viên :");
       lblNewLabel_1_2.setForeground(Color.BLACK);
       lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_2.setBounds(10, 218, 111, 22);
       panel_1.add(lblNewLabel_1_2);
       
       JLabel lblNewLabel_1_3 = new JLabel("Chức Danh :");
       lblNewLabel_1_3.setForeground(Color.BLACK);
       lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_3.setBounds(10, 250, 111, 22);
       panel_1.add(lblNewLabel_1_3);
       
       JLabel lblNewLabel_1_4 = new JLabel("Lương : ");
       lblNewLabel_1_4.setForeground(Color.BLACK);
       lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_4.setBounds(10, 282, 111, 22);
       panel_1.add(lblNewLabel_1_4);
       
       JLabel lblNewLabel_1_5 = new JLabel("Ca Làm Việc :");
       lblNewLabel_1_5.setForeground(Color.BLACK);
       lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_5.setBounds(10, 314, 111, 22);
       panel_1.add(lblNewLabel_1_5);
       
       txtMaNV = new JTextField();
       txtMaNV.setColumns(10);
       txtMaNV.setBounds(131, 189, 259, 19);
       panel_1.add(txtMaNV);
       
       txtTenNV = new JTextField();
       txtTenNV.setColumns(10);
       txtTenNV.setBounds(131, 221, 259, 19);
       panel_1.add(txtTenNV);
       
       txtChucDanh = new JTextField();
       txtChucDanh.setColumns(10);
       txtChucDanh.setBounds(131, 253, 259, 19);
       panel_1.add(txtChucDanh);
       
       txtLuong = new JTextField();
       txtLuong.setColumns(10);
       txtLuong.setBounds(131, 285, 259, 19);
       panel_1.add(txtLuong);
       
       txtCaLamViec = new JTextField();
       txtCaLamViec.setColumns(10);
       txtCaLamViec.setBounds(131, 317, 259, 19);
       panel_1.add(txtCaLamViec);
       
       JPanel panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.BLACK);
       panel.setBounds(0, 0, 1074, 51);
       getContentPane().add(panel);
       
       JLabel lblNhnVin = new JLabel("NHÂN VIÊN ");
       lblNhnVin.setForeground(Color.WHITE);
       lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
       lblNhnVin.setBounds(483, 10, 127, 31);
       panel.add(lblNhnVin);
       
       JLabel lblNewLabel_1 = new JLabel("Tìm kiếm : ");
       lblNewLabel_1.setForeground(Color.BLACK);
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1.setBounds(422, 73, 75, 22);
       getContentPane().add(lblNewLabel_1);
       
       txtTimKiem = new JTextField();
       txtTimKiem.setBackground(new Color(255, 255, 255));
       txtTimKiem.setColumns(10);
       txtTimKiem.setBounds(489, 76, 237, 19);
       getContentPane().add(txtTimKiem);
       
       JButton btnTimKiem = new JButton("Tìm Kiếm ");
       btnTimKiem.setForeground(Color.WHITE);
       btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnTimKiem.setBackground(Color.BLACK);
       btnTimKiem.setBounds(736, 73, 125, 29);
       getContentPane().add(btnTimKiem);
       
       JPanel panel_2 = new JPanel();
       panel_2.setBackground(new Color(255, 255, 255));
       panel_2.setBorder(new TitledBorder(null, "Danh S\u00E1ch Nh\u00E2n Vi\u00EAn ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
       panel_2.setBounds(422, 119, 642, 461);
       getContentPane().add(panel_2);
       panel_2.setLayout(null);
       
       tableDSNV = new JTable();
       tableDSNV.setBackground(new Color(242, 242, 242));
       tableDSNV.setBounds(10, 22, 622, 429);
       panel_2.add(tableDSNV);
       
       JPanel panel_3 = new JPanel();
       panel_3.setBackground(new Color(0, 0, 0));
       panel_3.setBounds(422, 577, 641, 51);
       getContentPane().add(panel_3);
       panel_3.setLayout(null);
       
       JLabel lblTngSNhn = new JLabel("Tổng Số Nhân Viên : ");
       lblTngSNhn.setBounds(145, 10, 220, 31);
       panel_3.add(lblTngSNhn);
       lblTngSNhn.setForeground(Color.WHITE);
       lblTngSNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
       
       JTextArea textAreaTongNV = new JTextArea();
       textAreaTongNV.setBackground(new Color(255, 255, 255));
       textAreaTongNV.setBounds(358, 10, 88, 31);
       panel_3.add(textAreaTongNV);
       
       JButton btnThem = new JButton("Thêm ");
       btnThem.setForeground(Color.WHITE);
       btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnThem.setBackground(Color.BLACK);
       btnThem.setBounds(732, 638, 75, 29);
       getContentPane().add(btnThem);
       
       JButton btnXoa = new JButton("Xóa");
       btnXoa.setForeground(Color.WHITE);
       btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnXoa.setBackground(Color.BLACK);
       btnXoa.setBounds(819, 638, 75, 29);
       getContentPane().add(btnXoa);
       
       JButton btnSua = new JButton("Sửa ");
       btnSua.setForeground(Color.WHITE);
       btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnSua.setBackground(Color.BLACK);
       btnSua.setBounds(904, 638, 75, 29);
       getContentPane().add(btnSua);
       
       JButton btnLuu = new JButton("Lưu ");
       btnLuu.setForeground(Color.WHITE);
       btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnLuu.setBackground(Color.BLACK);
       btnLuu.setBounds(989, 638, 75, 29);
       getContentPane().add(btnLuu);
   }
}
