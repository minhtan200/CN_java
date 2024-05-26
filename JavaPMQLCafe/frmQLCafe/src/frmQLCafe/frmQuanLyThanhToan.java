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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;

public class frmQuanLyThanhToan extends JFrame  implements Serializable {

	 private static final long serialVersionUID = 1L;
	 private JTextField txtTenKH;
	 private JTextField txtSoBan;
	 private JTextField txtPTThanhToan;
	 private JTable table;
  
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
            	   frmQuanLyThanhToan window = new frmQuanLyThanhToan();
                   window.setVisible(true);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
   }

  
   public frmQuanLyThanhToan() {
       initialize();
   }

   
   private void initialize() {
       setTitle("Form Quản Lý Thanh Toán"); 
       setSize(794, 553); 
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       
       JPanel panel = new JPanel();
       panel.setBackground(new Color(0, 0, 0));
       panel.setBounds(0, 0, 780, 51);
       getContentPane().add(panel);
       panel.setLayout(null);
       
       JLabel lblNewLabel = new JLabel("THANH TOÁN ");
       lblNewLabel.setForeground(new Color(255, 255, 255));
       lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
       lblNewLabel.setBounds(324, 10, 138, 31);
       panel.add(lblNewLabel);
       
       JPanel panel_1 = new JPanel();
       panel_1.setBackground(new Color(255, 255, 255));
       panel_1.setBounds(0, 50, 780, 466);
       getContentPane().add(panel_1);
       panel_1.setLayout(null);
       
       JPanel panel_2 = new JPanel();
       panel_2.setBackground(new Color(255, 255, 255));
       panel_2.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt Thanh To\u00E1n ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
       panel_2.setBounds(0, 0, 780, 276);
       panel_1.add(panel_2);
       panel_2.setLayout(null);
       
       table = new JTable();
       table.setBackground(new Color(242, 242, 242));
       table.setBounds(10, 22, 760, 244);
       panel_2.add(table);
       
       JLabel lblNewLabel_1 = new JLabel("Tên Khách Hàng : ");
       lblNewLabel_1.setForeground(new Color(0, 0, 0));
       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1.setBounds(10, 286, 179, 22);
       panel_1.add(lblNewLabel_1);
       
       JLabel lblNewLabel_1_1 = new JLabel("Số Bàn : ");
       lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
       lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_1.setBounds(10, 318, 179, 22);
       panel_1.add(lblNewLabel_1_1);
       
       JLabel lblNewLabel_1_2 = new JLabel("Phương Thức Thanh Toán :");
       lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
       lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_2.setBounds(10, 350, 179, 22);
       panel_1.add(lblNewLabel_1_2);
       
       JLabel lblNewLabel_1_3 = new JLabel("Tổng Tiền :");
       lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
       lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
       lblNewLabel_1_3.setBounds(10, 382, 179, 22);
       panel_1.add(lblNewLabel_1_3);
       
       txtTenKH = new JTextField();
       txtTenKH.setBounds(295, 289, 475, 19);
       panel_1.add(txtTenKH);
       txtTenKH.setColumns(10);
       
       txtSoBan = new JTextField();
       txtSoBan.setColumns(10);
       txtSoBan.setBounds(295, 321, 475, 19);
       panel_1.add(txtSoBan);
       
       txtPTThanhToan = new JTextField();
       txtPTThanhToan.setColumns(10);
       txtPTThanhToan.setBounds(295, 353, 475, 19);
       panel_1.add(txtPTThanhToan);
       
       JButton btnXacNhanTT = new JButton("Xác Nhận Thanh Toán ");
       btnXacNhanTT.setForeground(new Color(255, 255, 255));
       btnXacNhanTT.setBackground(new Color(0, 0, 0));
       btnXacNhanTT.setFont(new Font("Tahoma", Font.BOLD, 12));
       btnXacNhanTT.setBounds(10, 427, 283, 29);
       panel_1.add(btnXacNhanTT);
       
       JTextArea textAreaTongTien = new JTextArea();
       textAreaTongTien.setBounds(295, 382, 475, 19);
       panel_1.add(textAreaTongTien);
   }
}

