package frmQLCafe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class frmQuanLyNhanVien extends JFrame implements Serializable {

    private static final long serialVersionUID = 1L;
    private JTextField txtTimKiem;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtDT;
    private JTextField txtEmail;
    private JTextField txtChucVu;
    private JTable tableDSNV;
    private JTextArea textAreaTongNV;

    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "minh123@";
    
    private int selectedRow = -1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
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
        loadDataToTable();
        addDocumentListenerToTimKiem();
        demTongNhanVien();
    }

    // Kết nối đến cơ sở dữ liệu
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initialize() {
        setTitle("Form Quản Lý Nhân Viên");
        setSize(1088, 714);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(0, 61, 412, 570);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
        lblMaNV.setForeground(Color.BLACK);
        lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMaNV.setBounds(10, 186, 111, 22);
        panel_1.add(lblMaNV);

        JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
        lblTenNV.setForeground(Color.BLACK);
        lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTenNV.setBounds(10, 218, 111, 22);
        panel_1.add(lblTenNV);

        JLabel lblDT = new JLabel("Điện Thoại:");
        lblDT.setForeground(Color.BLACK);
        lblDT.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDT.setBounds(10, 250, 111, 22);
        panel_1.add(lblDT);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEmail.setBounds(10, 282, 111, 22);
        panel_1.add(lblEmail);

        JLabel lblChucVu = new JLabel("Chức Vụ:");
        lblChucVu.setForeground(Color.BLACK);
        lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblChucVu.setBounds(10, 314, 111, 22);
        panel_1.add(lblChucVu);

        txtMaNV = new JTextField();
        txtMaNV.setColumns(10);
        txtMaNV.setBounds(131, 189, 259, 19);
        panel_1.add(txtMaNV);

        txtTenNV = new JTextField();
        txtTenNV.setColumns(10);
        txtTenNV.setBounds(131, 221, 259, 19);
        panel_1.add(txtTenNV);

        txtDT = new JTextField();
        txtDT.setColumns(10);
        txtDT.setBounds(131, 253, 259, 19);
        panel_1.add(txtDT);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(131, 285, 259, 19);
        panel_1.add(txtEmail);

        txtChucVu = new JTextField();
        txtChucVu.setColumns(10);
        txtChucVu.setBounds(131, 317, 259, 19);
        panel_1.add(txtChucVu);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 1074, 51);
        getContentPane().add(panel);

        JLabel lblNhanVien = new JLabel("NHÂN VIÊN");
        lblNhanVien.setForeground(Color.WHITE);
        lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNhanVien.setBounds(483, 10, 127, 31);
        panel.add(lblNhanVien);

        JLabel lblTimKiem = new JLabel("Tìm kiếm:");
        lblTimKiem.setForeground(Color.BLACK);
        lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTimKiem.setBounds(422, 73, 75, 22);
        getContentPane().add(lblTimKiem);

        txtTimKiem = new JTextField();
        txtTimKiem.setBackground(new Color(255, 255, 255));
        txtTimKiem.setColumns(10);
        txtTimKiem.setBounds(489, 76, 237, 19);
        getContentPane().add(txtTimKiem);

        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTimKiem.setBackground(Color.BLACK);
        btnTimKiem.setBounds(736, 73, 125, 29);
        getContentPane().add(btnTimKiem);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBorder(new TitledBorder(null, "Danh Sách Nhân Viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

        JLabel lblTongNV = new JLabel("Tổng Số Nhân Viên:");
        lblTongNV.setBounds(145, 10, 220, 31);
        panel_3.add(lblTongNV);
        lblTongNV.setForeground(Color.WHITE);
        lblTongNV.setFont(new Font("Tahoma", Font.BOLD, 20));

        textAreaTongNV = new JTextArea();
        textAreaTongNV.setFont(new Font("Tahoma", Font.BOLD, 20));
        textAreaTongNV.setBackground(new Color(255, 255, 255));
        textAreaTongNV.setBounds(360, 11, 88, 31);
        panel_3.add(textAreaTongNV);

        JButton btnThem = new JButton("Thêm");
        btnThem.setForeground(Color.WHITE);
        btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnThem.setBackground(Color.BLACK);
        btnThem.setBounds(589, 638, 75, 29);
        getContentPane().add(btnThem);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                txtMaNV.setText("");
                txtTenNV.setText("");
                txtDT.setText("");
                txtEmail.setText("");
                txtChucVu.setText("");
            }
        });
        
        btnXoa.setForeground(Color.WHITE);
        btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnXoa.setBackground(Color.BLACK);
        btnXoa.setBounds(674, 638, 75, 29);
        getContentPane().add(btnXoa);

        JButton btnSua = new JButton("Sửa");
        btnSua.setForeground(Color.WHITE);
        btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSua.setBackground(Color.BLACK);
        btnSua.setBounds(759, 638, 75, 29);
        getContentPane().add(btnSua);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.setForeground(Color.WHITE);
        btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLuu.setBackground(Color.BLACK);
        btnLuu.setBounds(844, 638, 75, 29);
        getContentPane().add(btnLuu);

        btnThem.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	themNhanVien();
                loadDataToTable();
                demTongNhanVien();
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	xoaNhanVien();
                loadDataToTable();
                demTongNhanVien();
            }
        });
        
        btnLuu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	luuThayDoi();
                loadDataToTable();
                demTongNhanVien();
            }
        });
        
        btnSua.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	suaNhanVien();
                loadDataToTable();
                demTongNhanVien();
            }
        });
        
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	timKiemNhanVien();
            }
        });
        
        tableDSNV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableDSNV.getSelectedRow();
                if (selectedRow != -1) {
                	// Lấy dữ liệu từ hàng được chọn
                    String maNV = tableDSNV.getValueAt(selectedRow, 0).toString();
                    String tenNV = tableDSNV.getValueAt(selectedRow, 1).toString();
                    String dt = tableDSNV.getValueAt(selectedRow, 2).toString();
                    String email = tableDSNV.getValueAt(selectedRow, 3).toString();
                    String chucVu = tableDSNV.getValueAt(selectedRow, 4).toString();

                    // Hiển thị thông tin nhân viên lên các trường
                    txtMaNV.setText(maNV);
                    txtTenNV.setText(tenNV);
                    txtDT.setText(dt);
                    txtEmail.setText(email);
                    txtChucVu.setText(chucVu);
                } else {
                	clearFields();
                }
            }
        });
    }
    private void clearFields() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtDT.setText("");
        txtEmail.setText("");
        txtChucVu.setText("");
    }
    
    private void themNhanVien() {
    	String MaNhanVienStr = txtMaNV.getText();
        String Ten = txtTenNV.getText();
        String DienThoai = txtDT.getText();
        String Email = txtEmail.getText();
        String ChucVu = txtChucVu.getText();
        
        if (MaNhanVienStr.isEmpty() || Ten.isEmpty() || DienThoai.isEmpty() || Email.isEmpty() || ChucVu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int MaNhanVien;
        try {
            MaNhanVien = Integer.parseInt(MaNhanVienStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải là một số nguyên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidPhoneNumber(DienThoai)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidEmail(Email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Connection conn = getConnection();
        if (conn != null) {
            try {
            	 if (maNhanVienTonTai(conn, MaNhanVien)) {
                     JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                     return;
                 }
            	String query = "INSERT INTO nhanvien (MaNhanVien, Ten, DienThoai, Email, ChucVu) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, MaNhanVien);
                pstmt.setString(2, Ten);
                pstmt.setString(3, DienThoai);
                pstmt.setString(4, Email);
                pstmt.setString(5, ChucVu);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
                loadDataToTable();
                demTongNhanVien();
                txtMaNV.setText("");
                txtTenNV.setText("");
                txtDT.setText("");
                txtEmail.setText("");
                txtChucVu.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void xoaNhanVien() {
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Connection conn = getConnection();
            if (conn != null) {
                try {
                    String query = "DELETE FROM nhanvien WHERE MaNhanVien=?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, Integer.parseInt(tableDSNV.getValueAt(selectedRow, 0).toString()));
                    pstmt.executeUpdate();
                    pstmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    
                    loadDataToTable();
                    demTongNhanVien();
                    txtMaNV.setText("");
                    txtTenNV.setText("");
                    txtDT.setText("");
                    txtEmail.setText("");
                    txtChucVu.setText("");
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Xóa nhân vien thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void suaNhanVien() {
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String MaNhanVienStr = txtMaNV.getText();
        String Ten = txtTenNV.getText();
        String DienThoai = txtDT.getText();
        String Email = txtEmail.getText();
        String ChucVu = txtChucVu.getText();
        
        if (MaNhanVienStr.isEmpty() || Ten.isEmpty() || DienThoai.isEmpty() || Email.isEmpty() || ChucVu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidPhoneNumber(DienThoai)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidEmail(Email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Connection conn = getConnection();
        if (conn != null) {
            try {
                String query = "UPDATE nhanvien SET Ten=?, DienThoai=?, Email=?, ChucVu=? WHERE MaNhanVien=?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, Ten);
                pstmt.setString(2, DienThoai);
                pstmt.setString(3, Email);
                pstmt.setString(4, ChucVu);
                pstmt.setInt(5, Integer.parseInt(tableDSNV.getValueAt(selectedRow, 0).toString()));
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDataToTable();
                demTongNhanVien();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

 // Lưu các thay đổi của nhân viên
    private void luuThayDoi() {
        String maNV = txtMaNV.getText();
        String tenNV = txtTenNV.getText();
        String dt = txtDT.getText();
        String email = txtEmail.getText();
        String chucVu = txtChucVu.getText();

        if (maNV.isEmpty() || tenNV.isEmpty() || dt.isEmpty() || email.isEmpty() || chucVu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE nhanvien SET Ten = ?, DienThoai = ?, Email = ?, ChucVu = ? WHERE MaNhanVien = ?")) {

            pstmt.setString(1, tenNV);
            pstmt.setString(2, dt);
            pstmt.setString(3, email);
            pstmt.setString(4, chucVu);
            pstmt.setString(5, maNV);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Lưu thay đổi thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tìm kiếm nhân viên
    private void timKiemNhanVien() {
        String keyword = txtTimKiem.getText();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM nhanvien WHERE MaNhanVien LIKE ? OR Ten LIKE ? OR DienThoai LIKE ? OR Email LIKE ? OR ChucVu LIKE ?")) {

            String queryKeyword = "%" + keyword + "%";
            pstmt.setString(1, queryKeyword);
            pstmt.setString(2, queryKeyword);
            pstmt.setString(3, queryKeyword);
            pstmt.setString(4, queryKeyword);
            pstmt.setString(5, queryKeyword);

            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Mã NV", "Tên NV", "Điện Thoại", "Email", "Chức Vụ"}, 0);

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("MaNhanVien"));
                row.add(rs.getString("Ten"));
                row.add(rs.getString("DienThoai"));
                row.add(rs.getString("Email"));
                row.add(rs.getString("ChucVu"));
                model.addRow(row);
            }

            tableDSNV.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadDataToTable() {
        Vector<Vector<Object>> data = getNhanVien();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Mã Nhân Viên");
        columnNames.add("Tên Nhân Viên");
        columnNames.add("Số Điện Thoại");
        columnNames.add("Email");
        columnNames.add("Chức Vụ");

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        tableDSNV.setModel(model);
    }
    
    private Vector<Vector<Object>> getNhanVien() {
        Vector<Vector<Object>> data = new Vector<>();
        Connection conn = getConnection();

        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String query = "SELECT MaNhanVien, Ten, DienThoai, Email, ChucVu FROM nhanvien"; 
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("MaNhanVien"));
                    row.add(rs.getString("Ten"));
                    row.add(rs.getString("DienThoai"));
                    row.add(rs.getString("Email"));
                    row.add(rs.getString("ChucVu"));
                    data.add(row);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    private void demTongNhanVien() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM nhanvien")) {

            if (rs.next()) {
                int total = rs.getInt("total");
                textAreaTongNV.setText(String.valueOf(total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean isValidPhoneNumber(String phone) {
        String regex = "^(\\+84|0)\\d{9,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private void addDocumentListenerToTimKiem() {
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (txtTimKiem.getText().trim().isEmpty()) {
                    loadDataToTable();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtTimKiem.getText().trim().isEmpty()) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (txtTimKiem.getText().trim().isEmpty()) {
                    loadDataToTable();
                }
            }
        });
    }
    private boolean maNhanVienTonTai(Connection conn, int maNhanVien) throws SQLException {
        String query = "SELECT * FROM nhanvien WHERE MaNhanVien = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, maNhanVien);
        ResultSet rs = pstmt.executeQuery();
        boolean exists = rs.next();
        rs.close();
        pstmt.close();
        return exists;
    }
}
