package phathienluanvan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Sfmain {

	private JFrame frmMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sfmain window = new Sfmain();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sfmain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Ph\u00E1t hi\u1EC7n lu\u1EADn v\u0103n");
		frmMain.setBounds(100, 100, 614, 547);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		JMenuBar mnBar = new JMenuBar();
		mnBar.setBorderPainted(false);
		mnBar.setBounds(0, 0, 598, 21);
		frmMain.getContentPane().add(mnBar);
		
		JMenu mnChucNang = new JMenu("Ch\u1EE9c n\u0103ng");
		mnBar.add(mnChucNang);
		
		JMenuItem mnLayDuLieu = new JMenuItem("L\u1EA5y d\u1EEF li\u1EC7u");
		mnLayDuLieu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnChucNang.add(mnLayDuLieu);
		
		JMenuItem mnDanhChiMuc = new JMenuItem("\u0110\u00E1nh ch\u1EC9 m\u1EE5c");
		mnDanhChiMuc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnChucNang.add(mnDanhChiMuc);
		
		JMenuItem mnSoSanhTD = new JMenuItem("So s\u00E1nh \u0111\u1ED9 t\u01B0\u01A1ng \u0111\u1ED3ng");
		mnSoSanhTD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnChucNang.add(mnSoSanhTD);
		
		JMenuItem mnChuyenDoi = new JMenuItem("Chuyển đổi dữ liệu");
		mnChuyenDoi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnChucNang.add(mnChuyenDoi);
		
		JMenuItem mnThoat = new JMenuItem("Tho\u00E1t");
		mnThoat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnChucNang.add(mnThoat);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		toolBar.setToolTipText("");
		toolBar.setBounds(0, 21, 598, 28);
		frmMain.getContentPane().add(toolBar);
		
		JButton btnLayDuLieu = new JButton("L\u1EA5y d\u1EEF li\u1EC7u");
		toolBar.add(btnLayDuLieu);
		
		JButton btnChuyenDoi = new JButton("Chuyển đổi dữ liệu");
		btnChuyenDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBar.add(btnChuyenDoi);
		
		
		JButton btnDanhChiMuc = new JButton("\u0110\u00E1nh ch\u1EC9 m\u1EE5c");
		toolBar.add(btnDanhChiMuc);
		
		JButton btnSoSanhTD = new JButton("So s\u00E1nh \u0111\u1ED9 t\u01B0\u01A1ng \u0111\u1ED3ng");
		toolBar.add(btnSoSanhTD);
		
		JPanel JpNoiDung = new JPanel();
		JpNoiDung.setBounds(0, 49, 612, 457);
		frmMain.getContentPane().add(JpNoiDung);
		JpNoiDung.setLayout(new BorderLayout(0, 0));
		

		btnLayDuLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel12=new LayDuLieu();
				JpNoiDung.removeAll();
				JpNoiDung.add(Jpanel12);
				JpNoiDung.validate();
			}
		});
		
		btnChuyenDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel Jpanel12=new ChuyenDoiDuLieu();
				JpNoiDung.removeAll();
				JpNoiDung.add(Jpanel12);
				JpNoiDung.validate();
			}
		});
	}
}
