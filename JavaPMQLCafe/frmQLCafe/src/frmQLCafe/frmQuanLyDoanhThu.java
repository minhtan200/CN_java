package frmQLCafe;

import java.awt.EventQueue;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout; // Thêm dòng này
import java.awt.FlowLayout; // Thêm dòng này

public class frmQuanLyDoanhThu extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;


    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private JTable tableDSDoanhThu;

    public frmQuanLyDoanhThu() {
        initialize();
    }

    private void initialize() {
        // Thiết lập giao diện
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setTitle("Quản Lý Doanh Thu");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Từ ngày:");
        panel_1.add(lblNewLabel_1);

        txtTuNgay = new JTextField();
        panel_1.add(txtTuNgay);
        txtTuNgay.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Đến ngày:");
        panel_1.add(lblNewLabel_1_1);

        txtDenNgay = new JTextField();
        panel_1.add(txtDenNgay);
        txtDenNgay.setColumns(10);

        JButton btnLoc = new JButton("Lọc");
        btnLoc.addActionListener(e -> {
            // Khi người dùng nhấn nút "Lọc", lấy dữ liệu doanh thu từ cơ sở dữ liệu và hiển thị lên bảng
            loadDoanhThu();
        });
        panel_1.add(btnLoc);

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        tableDSDoanhThu = new JTable();
        scrollPane.setViewportView(tableDSDoanhThu);
    }

    private void loadDoanhThu() {
        // Lấy thời gian từ ngày và đến ngày từ các trường nhập liệu
        String tuNgay = txtTuNgay.getText();
        String denNgay = txtDenNgay.getText();

        // Tạo kết nối tới cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "")) {
            // Tạo câu truy vấn SQL để lấy dữ liệu doanh thu từ các bảng liên quan
            String sql = "SELECT dh.MaDonHang, dh.NgayDatHang, sp.Ten AS TenSanPham, ctdh.SoLuong, sp.Gia, dh.TongTien " +
                    "FROM donhang dh " +
                    "INNER JOIN chitietdonhang ctdh ON dh.MaDonHang = ctdh.MaDonHang " +
                    "INNER JOIN sanpham sp ON ctdh.MaSanPham = sp.MaSanPham " +
                    "WHERE dh.NgayDatHang BETWEEN ? AND ?";
            
            // Chuẩn bị câu truy vấn
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Đặt giá trị cho các tham số trong câu truy vấn
                preparedStatement.setString(1, tuNgay);
                preparedStatement.setString(2, denNgay);

                // Thực thi truy vấn và lấy kết quả
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Tạo một DefaultTableModel để chứa dữ liệu từ ResultSet
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Mã Đơn Hàng");
                    model.addColumn("Ngày Đặt Hàng");
                    model.addColumn("Tên Sản Phẩm");
                    model.addColumn("Số Lượng");
                    model.addColumn("Giá");
                    model.addColumn("Tổng Tiền");

                    // Thêm dữ liệu từ ResultSet vào model
                    while (resultSet.next()) {
                        model.addRow(new Object[]{
                                resultSet.getInt("MaDonHang"),
                                resultSet.getDate("NgayDatHang"),
                                resultSet.getString("TenSanPham"),
                                resultSet.getInt("SoLuong"),
                                resultSet.getDouble("Gia"),
                                resultSet.getDouble("TongTien")
                        });
                    }

                    // Hiển thị dữ liệu trên bảng
                    tableDSDoanhThu.setModel(model);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tải dữ liệu doanh thu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // Kết nối tới cơ sở dữ liệu MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                frmQuanLyDoanhThu window = new frmQuanLyDoanhThu();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi khởi động ứng dụng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}