package frmQLCafe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;

public class frmMain {

    private JFrame frame;
    private JLabel lblTime;
    private JLabel lblDay;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmMain window = new frmMain();
                    window.frame.setVisible(true);
                    window.startClock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frmMain() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 993, 678);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(668, 120, 273, 140);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        lblDay = new JLabel("Thursday,00/00/0000");
        lblDay.setForeground(new Color(0, 0, 0));
        lblDay.setFont(new Font("SimSun", Font.BOLD, 20));
        lblDay.setBounds(24, 75, 239, 50);
        panel.add(lblDay);
        
                lblTime = new JLabel("00 : 00 : 00 AM");
                lblTime.setBounds(52, 20, 211, 50);
                panel.add(lblTime);
                lblTime.setForeground(new Color(0, 0, 0));
                lblTime.setFont(new Font("SimSun", Font.BOLD, 20));
                
                JPanel panel_1_1_1 = new JPanel();
                panel_1_1_1.setLayout(null);
                panel_1_1_1.setBackground(new Color(255, 255, 255));
                panel_1_1_1.setBounds(28, 101, 564, 72);
                frame.getContentPane().add(panel_1_1_1);
                
                JLabel lblNewLabel_1_1_1 = new JLabel("QUẢN LÝ");
                lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
                lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 24));
                lblNewLabel_1_1_1.setBounds(221, 10, 117, 52);
                panel_1_1_1.add(lblNewLabel_1_1_1);
                
                JPanel panel_1_1 = new JPanel();
                panel_1_1.setLayout(null);
                panel_1_1.setBackground(new Color(0, 0, 0));
                panel_1_1.setBounds(668, 69, 273, 51);
                frame.getContentPane().add(panel_1_1);
                
                JLabel lblNewLabel_1_1 = new JLabel("THỜI GIAN");
                lblNewLabel_1_1.setForeground(Color.WHITE);
                lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 22));
                lblNewLabel_1_1.setBounds(85, 10, 122, 31);
                panel_1_1.add(lblNewLabel_1_1);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBackground(new Color(0, 0, 0));
                panel_2.setBounds(28, 172, 565, 350);
                frame.getContentPane().add(panel_2);
                panel_2.setLayout(null);
                
                        JButton btnMenu = new JButton("Menu");
                        btnMenu.setBounds(35, 46, 131, 43);
                        panel_2.add(btnMenu);
                        btnMenu.setBackground(new Color(255, 255, 255));
                        btnMenu.setForeground(new Color(0, 0, 0));
                        btnMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
                        
                                JButton btnDatBan = new JButton("Đặt bàn ");
                                btnDatBan.setBounds(218, 46, 131, 43);
                                panel_2.add(btnDatBan);
                                btnDatBan.setBackground(new Color(255, 255, 255));
                                btnDatBan.setFont(new Font("Tahoma", Font.BOLD, 12));
                                
                                        JButton btnThanhToan = new JButton("Thanh toán ");
                                        btnThanhToan.setBounds(403, 46, 131, 43);
                                        panel_2.add(btnThanhToan);
                                        btnThanhToan.setBackground(new Color(255, 255, 255));
                                        btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
                                        
                                                JButton btnNhanVien = new JButton("Nhân viên ");
                                                btnNhanVien.setBounds(35, 155, 131, 43);
                                                panel_2.add(btnNhanVien);
                                                btnNhanVien.setBackground(new Color(255, 255, 255));
                                                btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                

                                                JButton btnKhoHang = new JButton("Kho hàng ");
                                                btnKhoHang.setBounds(218, 155, 131, 43);
                                                panel_2.add(btnKhoHang);
                                                btnKhoHang.setBackground(new Color(255, 255, 255));
                                                btnKhoHang.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                
                                                JButton btnHoaDon = new JButton("Hóa đơn ");
                                                btnHoaDon.setBounds(403, 155, 131, 43);
                                                panel_2.add(btnHoaDon);
                                                btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                btnHoaDon.setBackground(Color.WHITE);
                                                
                                                
                                                JButton btnDoanhThu = new JButton("Doanh Thu ");
                                                btnDoanhThu.setBounds(35, 263, 131, 43);
                                                panel_2.add(btnDoanhThu);
                                                btnDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                btnDoanhThu.setBackground(Color.WHITE);
                                                
                                                JButton btnMuaBan = new JButton("Mua Bán ");
                                                btnMuaBan.setBounds(218, 263, 131, 43);
                                                panel_2.add(btnMuaBan);
                                                btnMuaBan.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                btnMuaBan.setBackground(Color.WHITE);
                                                
                                                JButton btnSanPham = new JButton("Sản phẩm ");
                                                btnSanPham.setBounds(403, 263, 131, 43);
                                                panel_2.add(btnSanPham);
                                                btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                btnSanPham.setBackground(Color.WHITE);
                                                btnSanPham.addActionListener(e -> openQuanLySanPhamForm());
                                                btnMuaBan.addActionListener(e -> openQuanLyMuaBanForm());
                                                btnDoanhThu.addActionListener(e -> openQuanLyDoanhThuForm());
                                                btnHoaDon.addActionListener(e -> openQuanLyHoaDonForm());
                                                btnKhoHang.addActionListener(e -> openQuanLyKhoHangForm());
                                                btnNhanVien.addActionListener(e -> openQuanLyNhanVienForm());
                                        btnThanhToan.addActionListener(e -> openQuanLyThanhToanForm());
                                btnDatBan.addActionListener(e -> openQuanLyDatBanForm());
                        btnMenu.addActionListener(e -> openQuanLyMenuForm());
                
        JButton btnDangXuat = new JButton("Đăng xuất  ");
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setBackground(new Color(0, 0, 0));
        btnDangXuat.setBounds(419, 573, 174, 37);
        frame.getContentPane().add(btnDangXuat);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(168, 84, 0));
        panel_1.setBounds(0, 0, 979, 51);
        frame.getContentPane().add(panel_1);
        
        JLabel lblNewLabel_1 = new JLabel("IT COFFEE");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(453, 13, 113, 31);
        panel_1.add(lblNewLabel_1);


        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\JavaPMQLCafe (2)\\JavaPMQLCafe\\frmQLCafe\\src\\icon\\backgr.jpg"));
        lblNewLabel.setBounds(0, 0, 979, 641);
        frame.getContentPane().add(lblNewLabel);
        
       
        
       
        
        
        
       
        
     
        

        
     
        
        
    }

    private void startClock() {
        Thread clockThread = new Thread() {
            public void run() {
                try {
                    while (true) {
                        SimpleDateFormat sdfTime = new SimpleDateFormat("hh : mm : ss a");
                        SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE,dd/MM/yyyy");
                        Date now = new Date();
                        String time = sdfTime.format(now);
                        String day = sdfDay.format(now);
                        lblTime.setText(time);
                        lblDay.setText(day);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clockThread.start();
    }
    private void openQuanLyMenuForm() {
       
        frmQuanLyMenu menuForm = new frmQuanLyMenu();
        menuForm.setVisible(true);
    }
    private void openQuanLyDatBanForm() {
     
        frmQuanLyDatBan menuForm = new frmQuanLyDatBan();
        menuForm.setVisible(true);
    }
    private void openQuanLyThanhToanForm() {
     
        frmQuanLyThanhToan menuForm = new frmQuanLyThanhToan();
        menuForm.setVisible(true);
    }
    private void openQuanLyNhanVienForm() {
    
        frmQuanLyNhanVien menuForm = new frmQuanLyNhanVien();
        menuForm.setVisible(true);
    }
    private void openQuanLyKhoHangForm() {
      
        frmQuanLyKhoHang menuForm = new frmQuanLyKhoHang();
        menuForm.setVisible(true);
    }
    private void openQuanLyHoaDonForm() {
        frmQuanLyHoaDon menuForm = new frmQuanLyHoaDon();
        menuForm.setVisible(true);
    }
    
    private void openQuanLyDoanhThuForm() {
        frmQuanLyDoanhThu menuForm = new frmQuanLyDoanhThu();
        menuForm.setVisible(true);
    }
    
    private void openQuanLyMuaBanForm() {
        frmQuanLyMuaBan menuForm = new frmQuanLyMuaBan();
        menuForm.setVisible(true);
    }
    
    private void openQuanLySanPhamForm() {
        frmQuanLySanPham menuForm = new frmQuanLySanPham();
        menuForm.setVisible(true);
    }
}
