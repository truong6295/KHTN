package ChongSaoChep;

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

public class SfMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SfMain window = new SfMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SfMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Chức năng");
		menuBar.add(mnFile);
		
		JMenuItem mnitemLayDuLieu = new JMenuItem("Lấy dữ liệu\r\n");
		mnitemLayDuLieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mnitemLayDuLieu);
		
		JMenuItem mnitemChuyenDoiDuLieu = new JMenuItem("Chuyển đổi Dữ liệu");
		mnitemChuyenDoiDuLieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mnitemChuyenDoiDuLieu);
		
		JMenuItem mnitemDanhChiMuc = new JMenuItem("Đánh chỉ mục");
		mnitemDanhChiMuc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mnitemDanhChiMuc);
		
		JMenuItem mnitemSoSanhDoTuongDong = new JMenuItem("So sánh độ tương đồng");
		mnitemSoSanhDoTuongDong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mnitemSoSanhDoTuongDong);
		
		JMenuItem mnitemThoat = new JMenuItem("Thoát");
		mnitemThoat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnFile.add(mnitemThoat);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		toolBar.setMinimumSize(new Dimension(5, 5));
		toolBar.setMaximumSize(new Dimension(5, 5));
		toolBar.setFocusTraversalKeysEnabled(false);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnLayDuLieu = new JButton("Lấy dữ liệu");
		toolBar.add(btnLayDuLieu);
		
		JButton btnChuyenDoiDuLieu = new JButton("Chuyển đổi dữ liệu");
		toolBar.add(btnChuyenDoiDuLieu);
		
		JButton btnDanhChiMuc = new JButton("Đánh chỉ mục");
		toolBar.add(btnDanhChiMuc);
		
		JButton btnSoSanhDoTuongDong = new JButton("So sánh độ tương đồng");
		toolBar.add(btnSoSanhDoTuongDong);
		
		JPanel jpMainDisplay = new JPanel();
		jpMainDisplay.setPreferredSize(new Dimension(500, 500));
		jpMainDisplay.setMinimumSize(new Dimension(500, 500));
		jpMainDisplay.setSize(new Dimension(500, 500));
		frame.getContentPane().add(jpMainDisplay, BorderLayout.CENTER);
		jpMainDisplay.setLayout(new BorderLayout(0, 0));
		
		//-------------------------------------bat su kien ----------------------
												/*su kien menu*/
		//su kien lay du lieu----------
		mnitemLayDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel1=new ChongSaoChep.LayDuLieu();
				jpMainDisplay.removeAll();
				jpMainDisplay.add(Jpanel1);
				jpMainDisplay.validate();
			}
		});
		//su kien chuyen doi du lieu----------
		mnitemChuyenDoiDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel12=new ChongSaoChep.ChuyenDoiDuLieu();
				jpMainDisplay.removeAll();
				jpMainDisplay.add(Jpanel12);
				jpMainDisplay.validate();
				
			}
		});
		//su kien danh chi muc---------
		mnitemDanhChiMuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//su kien so sanh do tuong dong------------
		mnitemSoSanhDoTuongDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// su kien thoat chuong trinh------------
		mnitemThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
											/*su kien button*/
		//su kien button lay du lieu------------
		btnLayDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel1=new ChongSaoChep.LayDuLieu();
				jpMainDisplay.removeAll();
				jpMainDisplay.add(Jpanel1);
				jpMainDisplay.validate();
			}
		});
		//su kien button chuyen doi du lieu ------------
		btnChuyenDoiDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel12=new ChongSaoChep.ChuyenDoiDuLieu();
				jpMainDisplay.removeAll();
				jpMainDisplay.add(Jpanel12);
				jpMainDisplay.validate();
			}
		});
		//su kien button danh chi muc----------------
		btnDanhChiMuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//su kien button so sanh do tuong dong
		btnSoSanhDoTuongDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
