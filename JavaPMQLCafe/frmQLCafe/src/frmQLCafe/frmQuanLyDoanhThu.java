package frmQLCafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class frmQuanLyDoanhThu extends JFrame implements Serializable {

	  private static final long serialVersionUID = 1L;
	//private JFrame frame;
	private JTextField txtTuNgay;
	private JTextField txtDenNgay;
	private JTable tableDSDoanhThu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyDoanhThu window = new frmQuanLyDoanhThu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmQuanLyDoanhThu() {
		getContentPane().setBackground(new Color(255, 255, 255));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 847, 467);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 833, 51);
		getContentPane().add(panel);
		
		JLabel lblDoanhThu = new JLabel("DOANH THU ");
		lblDoanhThu.setForeground(Color.WHITE);
		lblDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoanhThu.setBounds(354, 10, 138, 31);
		panel.add(lblDoanhThu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "L\u1ECDc Doanh Thu ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 279, 323);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Từ ngày : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 126, 77, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đến ngày : ");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 159, 77, 22);
		panel_1.add(lblNewLabel_1_1);
		
		txtTuNgay = new JTextField();
		txtTuNgay.setColumns(10);
		txtTuNgay.setBounds(104, 129, 165, 19);
		panel_1.add(txtTuNgay);
		
		txtDenNgay = new JTextField();
		txtDenNgay.setColumns(10);
		txtDenNgay.setBounds(104, 162, 165, 19);
		panel_1.add(txtDenNgay);
		
		JButton btnLoc = new JButton("Lọc ");
		btnLoc.setForeground(Color.WHITE);
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoc.setBackground(Color.BLACK);
		btnLoc.setBounds(22, 202, 65, 29);
		panel_1.add(btnLoc);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Doanh Thu ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(299, 61, 524, 323);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		tableDSDoanhThu = new JTable();
		tableDSDoanhThu.setBackground(new Color(242, 242, 242));
		tableDSDoanhThu.setBounds(10, 23, 504, 290);
		panel_1_1.add(tableDSDoanhThu);
		
		JButton btnXuatBaoCao = new JButton("Xuất báo cáo ");
		btnXuatBaoCao.setForeground(Color.WHITE);
		btnXuatBaoCao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXuatBaoCao.setBackground(Color.BLACK);
		btnXuatBaoCao.setBounds(669, 393, 137, 29);
		getContentPane().add(btnXuatBaoCao);
		
		
	}
	
	
}
