//frmQuanLyHoaDon.java

package frmQLCafe;

import java.awt.*;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class frmQuanLyHoaDon extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel invoiceTableModel;
    private JTextField txtTenKH;
    private JTextField txtSoBan;
    private JTextField txtPTThanhToan;
    private JTable tableCTHoaDon;

    // Constructor không tham số
    public frmQuanLyHoaDon() {
        initialize("", "", "", 0.0, new Object[0][0]); // Sử dụng các giá trị mặc định hoặc trống
    }

    // Constructor chính, khởi tạo với các tham số cần thiết
    public frmQuanLyHoaDon(String customerName, String tableNumber, String paymentMethod, double total, Object[][] items) {
        initialize(customerName, tableNumber, paymentMethod, total, items);
    }

    private void initialize(String customerName, String tableNumber, String paymentMethod, double total, Object[][] items) {
        setTitle("Hóa Đơn Thanh Toán");
        setSize(800, 507);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 786, 51);
        getContentPane().add(panel);

        JLabel lblHan = new JLabel("HÓA ĐƠN ");
        lblHan.setForeground(Color.WHITE);
        lblHan.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblHan.setBounds(353, 10, 102, 31);
        panel.add(lblHan);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Tiết Hóa Đơn ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_2.setBounds(0, 50, 786, 287);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        tableCTHoaDon = new JTable();
        tableCTHoaDon.setBackground(new Color(242, 242, 242));
        tableCTHoaDon.setBounds(10, 25, 766, 252);
        panel_2.add(tableCTHoaDon);

        JLabel lblNewLabel_1 = new JLabel("Tên Khách Hàng : ");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(10, 340, 179, 22);
        getContentPane().add(lblNewLabel_1);

        txtTenKH = new JTextField();
        txtTenKH.setColumns(10);
        txtTenKH.setBounds(295, 343, 475, 19);
        getContentPane().add(txtTenKH);

        JLabel lblNewLabel_1_1 = new JLabel("Số Bàn : ");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(10, 372, 179, 22);
        getContentPane().add(lblNewLabel_1_1);

        txtSoBan = new JTextField();
        txtSoBan.setColumns(10);
        txtSoBan.setBounds(295, 375, 475, 19);
        getContentPane().add(txtSoBan);

        JLabel lblNewLabel_1_2 = new JLabel("Phương Thức Thanh Toán :");
        lblNewLabel_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(10, 404, 179, 22);
        getContentPane().add(lblNewLabel_1_2);

        txtPTThanhToan = new JTextField();
        txtPTThanhToan.setColumns(10);
        txtPTThanhToan.setBounds(295, 407, 475, 19);
        getContentPane().add(txtPTThanhToan);

        JLabel lblNewLabel_1_3 = new JLabel("Tổng Tiền :");
        lblNewLabel_1_3.setForeground(Color.BLACK);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_3.setBounds(10, 436, 179, 22);
        getContentPane().add(lblNewLabel_1_3);

        JTextArea textAreaTongTien = new JTextArea();
        textAreaTongTien.setBounds(295, 436, 475, 19);
        getContentPane().add(textAreaTongTien);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 50, 786, 420);
        getContentPane().add(panel_1);

        // Bảng hiển thị chi tiết hóa đơn
        String[] columns = {"Tên Sản Phẩm", "Số Lượng", "Giá ($)"};
        invoiceTableModel = new DefaultTableModel(columns, 0);

        for (Object[] item : items) {
            invoiceTableModel.addRow(item);
        }
        tableCTHoaDon.setModel(invoiceTableModel);
        txtTenKH.setText(customerName);
        txtSoBan.setText(tableNumber);
        txtPTThanhToan.setText(paymentMethod);
    }

    // Thêm phương thức main để chạy độc lập
    public static void main(String[] args) {
        // Tạo hóa đơn với constructor không tham số và hiển thị nó
        frmQuanLyHoaDon invoiceForm = new frmQuanLyHoaDon();
        invoiceForm.setVisible(true);
    }
}
