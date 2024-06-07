package frmQLCafe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.io.Serializable;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

public class frmQuanLyKhoHang extends JFrame implements Serializable {

    private static final long serialVersionUID = 1L;
    private JTextField txtTimKiem;
    private JTable tableSanPham; 
    private JPanel panel_DSSP;
    private JTextArea textAreaTongSoLuong;
    private TableRowSorter<DefaultTableModel> rowSorter;

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
        loadSanPhamToScrollPane();
        calculateAndSetTotal();
    }

    private void initialize() {
        setTitle("Form Quản Lý Kho"); 
        setSize(1130, 780);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 1116, 51);
        getContentPane().add(panel);

        JLabel lblTitle = new JLabel("QUẢN LÝ KHO");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(531, 10, 200, 31);
        panel.add(lblTitle);

        JLabel lblTimKiem = new JLabel("Tìm kiếm : ");
        lblTimKiem.setForeground(Color.BLACK);
        lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTimKiem.setBounds(10, 61, 75, 22);
        getContentPane().add(lblTimKiem);

        txtTimKiem = new JTextField();
        txtTimKiem.setColumns(10);
        txtTimKiem.setBounds(77, 64, 237, 19);
        getContentPane().add(txtTimKiem);

        JButton btnTimKiem = new JButton("Tìm Kiếm ");
        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = txtTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTimKiem.setBackground(Color.BLACK);
        btnTimKiem.setBounds(324, 58, 125, 30);
        getContentPane().add(btnTimKiem);

        JPanel panel_CTSP = new JPanel();
        panel_CTSP.setBackground(new Color(255, 255, 255));
        panel_CTSP.setBorder(new TitledBorder(null, "Chi Tiết Kho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_CTSP.setBounds(567, 61, 539, 609);
        getContentPane().add(panel_CTSP);
        panel_CTSP.setLayout(null);

        JLabel lblTongSoLuong = new JLabel("Tổng Số Lượng :");
        lblTongSoLuong.setForeground(Color.BLACK);
        lblTongSoLuong.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTongSoLuong.setBounds(18, 435, 179, 22);
        panel_CTSP.add(lblTongSoLuong);

        textAreaTongSoLuong = new JTextArea();
        textAreaTongSoLuong.setBounds(247, 435, 257, 19);
        panel_CTSP.add(textAreaTongSoLuong);

        JButton btnThoat = new JButton("Thoát ");
        btnThoat.setBounds(784, 680, 95, 38);
        getContentPane().add(btnThoat);
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
        btnThoat.setForeground(Color.WHITE);
        btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnThoat.setBackground(Color.BLACK);

        panel_DSSP = new JPanel();
        panel_DSSP.setBackground(new Color(255, 255, 255));
        panel_DSSP.setBorder(new TitledBorder(null, "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_DSSP.setBounds(10, 90, 547, 643);
        getContentPane().add(panel_DSSP);
        panel_DSSP.setLayout(null);

        JScrollPane scrollPane_DSSP = new JScrollPane();
        scrollPane_DSSP.setBounds(10, 22, 429, 611);
        panel_DSSP.add(scrollPane_DSSP);

        tableSanPham = new JTable();
        scrollPane_DSSP.setViewportView(tableSanPham);
    }

    private void loadSanPhamToScrollPane() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Đơn Giá");

        try {
            Connection conn = getConnection();
            if (conn != null) {
                String query = "SELECT * FROM sanpham";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int maSanPham = rs.getInt("MaSanPham");
                    String tenSanPham = rs.getString("TenSanPham");
                    double donGia = rs.getDouble("DonGia");
                    model.addRow(new Object[]{maSanPham, tenSanPham, donGia});
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        tableSanPham.setModel(model);
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void calculateAndSetTotal() {
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        int totalQuantity = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalQuantity += (int) model.getValueAt(i, 2);
        }
        textAreaTongSoLuong.setText(String.valueOf(totalQuantity));
    }
}
