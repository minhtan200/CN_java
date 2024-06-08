	package frmQLCafe;
	
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	//import javax.swing.SwingConstants;
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
	import java.util.Vector;
	
	import javax.swing.JScrollPane;
	

	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	


	import javax.swing.event.DocumentEvent;
	import javax.swing.event.DocumentListener;
	


	import javax.swing.JOptionPane;
	
	import javax.swing.*;
	import javax.swing.table.DefaultTableCellRenderer;
	import java.awt.*;
	
	import javax.swing.table.TableRowSorter;


	
	public class frmQuanLyMenu extends JFrame  implements Serializable {
	
		 private static final long serialVersionUID = 1L;
		 
		 
		 private JTextField txtTimKiem;
		 private JTable tableCTDonHang;
		 private JScrollPane scrollPane_DSSP;
		 private JTable tableSanPham; 
		 private JPanel panel_DSSP;
		 private JTextArea textAreaTongTienCongLai;
		 private TableRowSorter<DefaultTableModel> rowSorter;
		 
		 
		 
		 private static final String URL = "jdbc:mysql://localhost:3306/cafe";
		    private static final String USER = "root";  // Thay thế bằng tên người dùng MySQL của bạn
		    private static final String PASSWORD = "minhtan2003";  // Thay thế bằng mật khẩu MySQL của bạn
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    frmQuanLyMenu window = new frmQuanLyMenu();
	                    window.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	
	    
	    public frmQuanLyMenu() {
	    	getContentPane().setBackground(new Color(255, 255, 255));
	        initialize();
	        loadDataToTable();
	        loadSanPhamToScrollPane();
	        calculateAndSetTotal();
	    }
	
	    
	  
	    private void initialize() {
	    	
	    	
	    	
	        setTitle("Form Quản Lý Menu"); 
	        setSize(1130, 780);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        getContentPane().setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setLayout(null);
	        panel.setBackground(Color.BLACK);
	        panel.setBounds(0, 0, 1116, 51);
	        getContentPane().add(panel);
	        
	        JLabel lblHan = new JLabel("MENU");
	        lblHan.setForeground(Color.WHITE);
	        lblHan.setFont(new Font("Tahoma", Font.BOLD, 20));
	        lblHan.setBounds(531, 10, 67, 31);
	        panel.add(lblHan);
	        
	        JLabel lblNewLabel_1 = new JLabel("Tìm kiếm : ");
	        lblNewLabel_1.setForeground(Color.BLACK);
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblNewLabel_1.setBounds(10, 61, 75, 22);
	        getContentPane().add(lblNewLabel_1);
	        
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
	        
	        JPanel panel_CTDH = new JPanel();
	        panel_CTDH.setBackground(new Color(255, 255, 255));
	        panel_CTDH.setBorder(new TitledBorder(null, "Chi Tiết Đơn Hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_CTDH.setBounds(567, 61, 539, 609);
	        getContentPane().add(panel_CTDH);
	        panel_CTDH.setLayout(null);
	        
	        JScrollPane scrollPane_CTDH = new JScrollPane();
	        scrollPane_CTDH.setBounds(10, 21, 519, 380);
	        panel_CTDH.add(scrollPane_CTDH);
	        
	        tableCTDonHang = new JTable();
	        tableCTDonHang.setBackground(new Color(242, 242, 242));
	        scrollPane_CTDH.setViewportView(tableCTDonHang);
	        
	        JLabel lblNewLabel_1_3 = new JLabel("Tổng Số Tiền Đã Mua :");
	        lblNewLabel_1_3.setForeground(Color.BLACK);
	        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblNewLabel_1_3.setBounds(18, 435, 179, 22);
	        panel_CTDH.add(lblNewLabel_1_3);
	        
	         textAreaTongTienCongLai = new JTextArea();
	        textAreaTongTienCongLai.setBounds(247, 435, 257, 19);
	        panel_CTDH.add(textAreaTongTienCongLai);
	        
	        JButton btnXoaDH = new JButton("Xóa Đơn Hàng");
	        btnXoaDH.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 int selectedRow = tableCTDonHang.getSelectedRow();
	                 if (selectedRow != -1) {
	                     int maChiTietDonHang = (int) tableCTDonHang.getValueAt(selectedRow, 0);

	                     DefaultTableModel modelCTDH = (DefaultTableModel) tableCTDonHang.getModel();
	                     modelCTDH.removeRow(selectedRow);

	                     try {
	                         Connection conn = getConnection();
	                         if (conn != null) {
	                             String deleteQuery = "DELETE FROM chitietdonhang WHERE MaChiTietDonHang = ?";
	                             PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
	                             pstmt.setInt(1, maChiTietDonHang);
	                             pstmt.executeUpdate();
	                             pstmt.close();
	                             conn.close();
	                         }
	                     } catch (SQLException ex) {
	                         ex.printStackTrace();
	                     }
	                 } else {
	                     JOptionPane.showMessageDialog(null, "Vui lòng chọn một đơn hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	                 }
	                 calculateAndSetTotal();
	        	}
	        });
	        btnXoaDH.setForeground(Color.WHITE);
	        btnXoaDH.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnXoaDH.setBackground(Color.BLACK);
	        btnXoaDH.setBounds(21, 480, 229, 47);
	        panel_CTDH.add(btnXoaDH);
	        
	        JButton btnThanhToan = new JButton("Thanh Toán ");
	        btnThanhToan.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 // Hiển thị form Quản Lý Thanh Toán
	                frmQuanLyThanhToan thanhToanForm = new frmQuanLyThanhToan();
	                thanhToanForm.setVisible(true);
	        	}
	        });
	        btnThanhToan.setForeground(Color.WHITE);
	        btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnThanhToan.setBackground(Color.BLACK);
	        btnThanhToan.setBounds(21, 547, 229, 47);
	        panel_CTDH.add(btnThanhToan);
	        
	        JButton btnXoaTatCaDonHang = new JButton("Xóa Tất Cả Đơn Hàng");
	        btnXoaTatCaDonHang.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tất cả đơn hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	                 if (confirmed == JOptionPane.YES_OPTION) {
	                     DefaultTableModel modelCTDH = (DefaultTableModel) tableCTDonHang.getModel();
	                     modelCTDH.setRowCount(0); // Xóa tất cả các dòng trong bảng

	                     try {
	                         Connection conn = getConnection();
	                         if (conn != null) {
	                             String deleteAllQuery = "DELETE FROM chitietdonhang";
	                             Statement stmt = conn.createStatement();
	                             stmt.executeUpdate(deleteAllQuery);
	                             stmt.close();
	                             conn.close();
	                         }
	                     } catch (SQLException ex) {
	                         ex.printStackTrace();
	                     }
	                 }
	                 calculateAndSetTotal();
	        	}
	        });
	        btnXoaTatCaDonHang.setForeground(Color.WHITE);
	        btnXoaTatCaDonHang.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnXoaTatCaDonHang.setBackground(Color.BLACK);
	        btnXoaTatCaDonHang.setBounds(275, 480, 229, 47);
	        panel_CTDH.add(btnXoaTatCaDonHang);
	        
	        JButton btnThemSanPham = new JButton("Thêm Sản Phẩm Mới ");
	        btnThemSanPham.setForeground(Color.WHITE);
	        btnThemSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnThemSanPham.setBackground(Color.BLACK);
	        btnThemSanPham.setBounds(275, 547, 229, 47);
	        panel_CTDH.add(btnThemSanPham);
	        
	        JButton btnThoat = 
	        		new JButton("Thoát ");
	        btnThoat.setBounds(784, 680, 95, 38);
	        getContentPane().add(btnThoat);
	        btnThoat.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
	                if (confirm == JOptionPane.YES_OPTION) {
	                    dispose(); // Đóng cửa sổ hiện tại
	                }
	            }
	        });
	        btnThoat.setForeground(Color.WHITE);
	        btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnThoat.setBackground(Color.BLACK);
	        
	        panel_DSSP = new JPanel(); // Gán giá trị mới cho panel_DSSP
	        panel_DSSP.setBackground(new Color(255, 255, 255));
	        panel_DSSP.setBorder(new TitledBorder(null, "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	        panel_DSSP.setBounds(10, 90, 547, 643);
	        getContentPane().add(panel_DSSP);
	        panel_DSSP.setLayout(null);
	        
	         scrollPane_DSSP = new JScrollPane();
	        scrollPane_DSSP.setBounds(10, 22, 429, 611);
	        panel_DSSP.add(scrollPane_DSSP);
	        
	     // Khai báo và khởi tạo tableSanPham
	         tableSanPham = new JTable();
	        // Thêm bảng vào một JScrollPane nếu cần
	        //JScrollPane scrollPaneSanPham = new JScrollPane(tableSanPham);
	         scrollPane_DSSP.setViewportView(tableSanPham);
	        // Thêm scroll pane vào giao diện người dùng của bạn
	         scrollPane_DSSP.setViewportView(tableSanPham);


	        
	        JButton btnThem = new JButton("Thêm");
	        btnThem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 // Lấy hàng được chọn từ bảng DSSP
	                int selectedRow = tableSanPham.getSelectedRow();

	                if (selectedRow != -1) { // Kiểm tra hàng đã được chọn hay chưa
	                    // Lấy thông tin của sản phẩm từ hàng được chọn
	                    int maSanPham = (int) tableSanPham.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là mã sản phẩm
	                    double giaSanPham = (double) tableSanPham.getValueAt(selectedRow, 2); // Giả sử cột thứ ba là giá sản phẩm

	                    // Kiểm tra sản phẩm đã tồn tại trong bảng CTDH chưa
	                    boolean productExists = false;
	                    DefaultTableModel modelCTDH = (DefaultTableModel) tableCTDonHang.getModel();
	                    for (int i = 0; i < modelCTDH.getRowCount(); i++) {
	                        int maSanPhamCTDH = (int) modelCTDH.getValueAt(i, 1); // Giả sử cột thứ hai là mã sản phẩm trong bảng CTDH
	                        if (maSanPhamCTDH == maSanPham) {
	                            // Nếu sản phẩm đã tồn tại, tăng số lượng và cập nhật tổng tiền
	                            int soLuong = (int) modelCTDH.getValueAt(i, 2); // Giả sử cột thứ ba là số lượng
	                            modelCTDH.setValueAt(soLuong + 1, i, 2); // Tăng số lượng lên 1
	                            double TongTienCongLai = giaSanPham * (soLuong + 1);
	                            modelCTDH.setValueAt(TongTienCongLai, i, 3); // Cập nhật tổng tiền

	                            // Cập nhật dữ liệu vào cơ sở dữ liệu
	                            try {
	                                Connection conn = getConnection();
	                                if (conn != null) {
	                                    String updateQuery = "UPDATE chitietdonhang SET SoLuong = ?, TongTienCongLai = ? WHERE MaSanPham = ?";
	                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
	                                    pstmt.setInt(1, soLuong + 1);
	                                    pstmt.setDouble(2, TongTienCongLai);
	                                    pstmt.setInt(3, maSanPham);
	                                    pstmt.executeUpdate();
	                                    pstmt.close();
	                                    conn.close();
	                                }
	                            } catch (SQLException ex) {
	                                ex.printStackTrace();
	                            }

	                            productExists = true;
	                            break;
	                        }
	                    }

	                    // Nếu sản phẩm chưa tồn tại trong bảng CTDH, thêm mới một hàng
	                    if (!productExists) {
	                        Vector<Object> newRow = new Vector<>();
	                        newRow.add(null); // MaChiTietDonHang sẽ được gán tự động bởi cơ sở dữ liệu
	                        newRow.add(maSanPham);
	                        newRow.add(1); // Số lượng ban đầu là 1
	                        newRow.add(giaSanPham); // Tổng tiền ban đầu bằng giá của sản phẩm
	                        modelCTDH.addRow(newRow);

	                        // Thêm dữ liệu mới vào cơ sở dữ liệu
	                        try {
	                            Connection conn = getConnection();
	                            if (conn != null) {
	                                String insertQuery = "INSERT INTO chitietdonhang (MaSanPham, SoLuong, TongTienCongLai) VALUES (?, ?, ?)";
	                                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
	                                pstmt.setInt(1, maSanPham);
	                                pstmt.setInt(2, 1); // Số lượng ban đầu là 1
	                                pstmt.setDouble(3, giaSanPham); // Tổng tiền ban đầu bằng giá của sản phẩm
	                                pstmt.executeUpdate();
	                                pstmt.close();
	                                conn.close();
	                            }
	                        } catch (SQLException ex) {
	                            ex.printStackTrace();
	                        }
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để thêm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	                }
	                
	                calculateAndSetTotal();
	        	}
	        });
	        btnThem.setForeground(Color.WHITE);
	        btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
	        btnThem.setBackground(Color.BLACK);
	        btnThem.setBounds(449, 22, 88, 611);
	        panel_DSSP.add(btnThem);
	        btnThemSanPham.addActionListener(e -> openQuanLySanPhamForm());
	        
	
	     // Xử lý sự kiện cho nút tìm kiếm
	        btnTimKiem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	            }
	        });
	        
	        
	     // Thêm DocumentListener cho txtTimKiem
	        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                // Không cần xử lý insertUpdate
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	 // Gọi phương thức để hiển thị lại tất cả các sản phẩm khi xóa văn bản tìm kiếm
	                String text = txtTimKiem.getText();
	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
	             
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                // Không cần xử lý changedUpdate
	            }
	        });

	    }
	

	    
	    private void loadDataToTable() {
	        Vector<Vector<Object>> data = getChiTietDonHang();
	        Vector<String> columnNames = new Vector<>();
	        columnNames.add("Mã Chi Tiết Đơn Hàng");
	       // columnNames.add("MaDonHang");
	        columnNames.add("Mã SP");
	        columnNames.add("Số Lượng");
	        columnNames.add("Tổng Tiền");
	
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        tableCTDonHang.setModel(model);
	    }
	
	    private Vector<Vector<Object>> getChiTietDonHang() {
	        Vector<Vector<Object>> data = new Vector<>();
	        Connection conn = getConnection();
	        
	        if (conn != null) {
	            try {
	                Statement stmt = conn.createStatement();
	                String query = "SELECT MaChiTietDonHang, MaSanPham, SoLuong, TongTienCongLai FROM chitietdonhang";
	                ResultSet rs = stmt.executeQuery(query);
	                
	                while (rs.next()) {
	                    Vector<Object> row = new Vector<>();
	                    row.add(rs.getInt("MaChiTietDonHang"));
	                    //row.add(rs.getInt("MaDonHang"));
	                    row.add(rs.getInt("MaSanPham"));
	                    row.add(rs.getInt("SoLuong"));
	                    row.add(rs.getDouble("TongTienCongLai"));
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
	    
	    
	    private void loadSanPhamToScrollPane() {
	        //JTable tableSanPham = new JTable();
	    	  // Thêm bảng vào một JScrollPane nếu cần
	        //JScrollPane scrollPaneSanPham = new JScrollPane(tableSanPham);
	        // Thêm scroll pane vào giao diện người dùng của bạn
	        //panel_DSSP.add(scrollPaneSanPham);
	        tableSanPham.setBackground(new Color(242, 242, 242));

	        DefaultTableModel modelSanPham = new DefaultTableModel();
	        modelSanPham.addColumn("Mã Sản Phẩm");
	        modelSanPham.addColumn("Tên Sản Phẩm");
	        modelSanPham.addColumn("Giá");
	        modelSanPham.addColumn("Hình Ảnh");

	        Vector<Vector<Object>> dataSanPham = getSanPhamData();

	        for (Vector<Object> row : dataSanPham) {
	            modelSanPham.addRow(row);
	        }

	        tableSanPham.setModel(modelSanPham);

	     // Áp dụng ImageRenderer cho cột LinkSP
	        tableSanPham.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

	        // Thiết lập chiều cao cho tất cả các hàng
	        int rowHeight = 110; // Chiều cao mong muốn của các hàng
	        tableSanPham.setRowHeight(rowHeight);

	        // Thiết lập TableRowSorter
	        rowSorter = new TableRowSorter<>(modelSanPham);
	        tableSanPham.setRowSorter(rowSorter);

	        scrollPane_DSSP.setViewportView(tableSanPham);

	        
	        
	    }


	    private Vector<Vector<Object>> getSanPhamData() {
	        Vector<Vector<Object>> data = new Vector<>();
	        Connection conn = getConnection();

	        if (conn != null) {
	            try {
	                Statement stmt = conn.createStatement();
	                String query = "SELECT MaSanPham, Ten, Gia, LinkSP FROM sanpham";
	                ResultSet rs = stmt.executeQuery(query);

	                while (rs.next()) {
	                    Vector<Object> row = new Vector<>();
	                    row.add(rs.getInt("MaSanPham"));
	                    row.add(rs.getString("Ten"));
	                    row.add(rs.getDouble("Gia"));
	                    row.add(rs.getString("LinkSP"));
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

	
	    private Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    

	    	class ImageRenderer extends DefaultTableCellRenderer {
		    private static final long serialVersionUID = 1L;
		
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        JLabel label = new JLabel();
		        if (value != null) {
		            String imagePath = value.toString();
		            try {
		                ImageIcon icon = new ImageIcon(imagePath);
		                // Chỉnh kích thước của hình ảnh
		                Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		                icon = new ImageIcon(image);
		                label.setIcon(icon);
		                // Đặt kích thước ảnh cho nhãn
		                label.setPreferredSize(new Dimension(50, 50));
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        return label;
		    }
		}

	    	class CustomCellRenderer extends DefaultTableCellRenderer {
		    private static final long serialVersionUID = 1L;
		    private int preferredHeight; // Chiều cao ưu tiên cho các ô trong cột
		
		    public CustomCellRenderer(int preferredHeight) {
		        this.preferredHeight = preferredHeight;
		    }
		
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        // Đặt chiều cao ưu tiên cho các ô trong cột
		        table.setRowHeight(row, preferredHeight);
		        return cellComponent;
		    }
		}
			 
	    	private void calculateAndSetTotal() {
	    	    DefaultTableModel model = (DefaultTableModel) tableCTDonHang.getModel();
	    	    double total = 0.0;
	    	    for (int i = 0; i < model.getRowCount(); i++) {
	    	        total += (double) model.getValueAt(i, 3); // Giả sử cột thứ tư là cột "TongTienCongLai"
	    	    }
	    	    textAreaTongTienCongLai.setText(String.valueOf(total));
	    	}
	    
	    private void openQuanLySanPhamForm() {
	        frmQuanLySanPham menuForm = new frmQuanLySanPham();
	        menuForm.setVisible(true);
	    }
	}
