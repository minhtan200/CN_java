import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;

public class MAIN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MAIN() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS\\Downloads\\coffeehut_logo.png"));
		setTitle("Coffee Hut Management Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 11, 1244, 659);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("TỔNG QUAN", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("MENU", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("ĐẶT BÀN", null, tabbedPane_3, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("THANH TOÁN", null, tabbedPane_4, null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("NHÂN VIÊN", null, tabbedPane_5, null);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.addTab("KHO HÀNG", null, tabbedPane_6, null);
	}
}
