package frmQLCafe;

import java.awt.EventQueue;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmQuanLyKhoHang extends JFrame implements Serializable {

    private static final long serialVersionUID = 1L;
    private JTable tableKhoHang;
    private JTextField txtTimKiem;
    private JLabel lblSoLuongSanPham; // Thêm JLabel cho số lượng sản phẩm

    private static final String URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String USER = "root";
    private static final String PASSWORD = "";

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
        loadKhoHangData("");
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 115, 1060, 497);
        getContentPane().add(scrollPane);

        tableKhoHang = new JTable();
        tableKhoHang.setBackground(new Color(242, 242, 242));
        scrollPane.setViewportView(tableKhoHang);

        txtTimKiem = new JTextField();
        txtTimKiem.setColumns(10);
        txtTimKiem.setBounds(413, 74, 314, 19);
        getContentPane().add(txtTimKiem);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tìm kiếm : ");
        lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1_1_1_1_1.setBounds(318, 71, 88, 22);
        getContentPane().add(lblNewLabel_1_1_1_1_1_1);

        lblSoLuongSanPham = new JLabel("Số lượng sản phẩm : 0"); // Khởi tạo JLabel cho số lượng sản phẩm
        lblSoLuongSanPham.setForeground(Color.BLACK);
        lblSoLuongSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSoLuongSanPham.setBounds(488, 634, 153, 22);
        getContentPane().add(lblSoLuongSanPham);

        txtTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = txtTimKiem.getText();
                loadKhoHangData(searchText);
            }
        });
    }

    private void loadKhoHangData(String searchText) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Kho Hàng");
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Số Lượng");
        model.addColumn("Ngày Nhập Hàng");

        int totalProducts = 0; // Biến để đếm tổng số lượng sản phẩm

        try {
            Connection conn = getConnection();
            if (conn != null) {
                String query = "SELECT k.MaKhoHang, k.MaSanPham, s.Ten AS TenSanPham, k.SoLuong, k.NgayNhapHang " +
                               "FROM khohang k " +
                               "JOIN sanpham s ON k.MaSanPham = s.MaSanPham";
                if (searchText != null && !searchText.trim().isEmpty()) {
                    query += " WHERE s.Ten LIKE '%" + searchText + "%'";
                }
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int maKhoHang = rs.getInt("MaKhoHang");
                    int maSanPham = rs.getInt("MaSanPham");
                    String tenSanPham = rs.getString("TenSanPham");
                    int soLuong = rs.getInt("SoLuong");
                    String ngayNhapHang = rs.getString("NgayNhapHang");
                    model.addRow(new Object[]{maKhoHang, maSanPham, tenSanPham, soLuong, ngayNhapHang});
                    totalProducts += soLuong; // Cộng dồn số lượng sản phẩm
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableKhoHang.setModel(model);
        lblSoLuongSanPham.setText("Số lượng sản phẩm : " + totalProducts); // Cập nhật nhãn với tổng số lượng sản phẩm
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
