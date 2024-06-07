package frmQLCafe;

import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class frmQuanLyKhoHang extends JFrame  implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private JTable tableKhoHang;
	 private JTextField txtTimKiem;

   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   frmQuanLyKhoHang window = new frmQuanLyKhoHang();
                   window.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }

   
   public frmQuanLyKhoHang() {
   	getContentPane().setBackground(new Color(255, 255, 255));
       initialize();
   }

   
   private void initialize() {
       setTitle("Form Quản Lý Menu"); 
       setSize(1094, 703); 
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
       JPanel panel = new JPanel();
       panel.setBounds(0, 0, 1080, 51);
       panel.setLayout(null);
       panel.setBackground(Color.BLACK);
       getContentPane().add(panel);
       
       JLabel lblNhnVin = new JLabel("KHO HÀNG ");
       lblNhnVin.setForeground(Color.WHITE);
       lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
       lblNhnVin.setBounds(483, 10, 127, 31);
       panel.add(lblNhnVin);
       
       tableKhoHang = new JTable();
       tableKhoHang.setBackground(new Color(242, 242, 242));
       tableKhoHang.setBounds(10, 115, 1060, 497);
       getContentPane().add(tableKhoHang);
       
       JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Danh mục : ");
       lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
       lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_1_1_1_1.setBounds(561, 70, 88, 22);
       getContentPane().add(lblNewLabel_1_1_1_1_1);
       
       JComboBox<String> cbDanhMuc = new JComboBox<String>();
       cbDanhMuc.setBackground(Color.WHITE);
       cbDanhMuc.setBounds(659, 72, 137, 21);
       getContentPane().add(cbDanhMuc);
       
       txtTimKiem = new JTextField();
       txtTimKiem.setColumns(10);
       txtTimKiem.setBounds(209, 73, 314, 19);
       getContentPane().add(txtTimKiem);
       
       JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tìm kiếm : ");
       lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
       lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_1_1_1_1_1.setBounds(114, 70, 88, 22);
       getContentPane().add(lblNewLabel_1_1_1_1_1_1);
       
       JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Số lượng sản phẩm : 0");
       lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.BLACK);
       lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_1_1_1_1_1_1.setBounds(488, 634, 153, 22);
       getContentPane().add(lblNewLabel_1_1_1_1_1_1_1);
   }
}
