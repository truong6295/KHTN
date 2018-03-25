package phathienluanvan;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChuyenDoiDuLieu extends JPanel {
	private JTextField txtNguon;
	private JTextField txtMau;
	private JTextField txtNoiLuu;

	/**
	 * Create the panel.
	 */
	public ChuyenDoiDuLieu() {
		setLayout(null);
		
		JLabel lblChuyniD = new JLabel("CHUYỂN ĐỔI DỮ LIỆU");
		lblChuyniD.setBounds(190, 11, 178, 37);
		add(lblChuyniD);
		
		JLabel lblThMcNgun = new JLabel("Thư mục nguồn: ");
		lblThMcNgun.setBounds(50, 57, 119, 34);
		add(lblThMcNgun);
		
		txtNguon = new JTextField();
		txtNguon.setEnabled(false);
		txtNguon.setBounds(146, 55, 245, 37);
		add(txtNguon);
		txtNguon.setColumns(10);
		
		JButton btnNguon = new JButton("Browes...");
		
		btnNguon.setBounds(434, 55, 89, 38);
		add(btnNguon);
		
		JLabel lblKiuDLiu = new JLabel("Kiểu dữ liệu: ");
		lblKiuDLiu.setBounds(60, 102, 89, 31);
		add(lblKiuDLiu);
		
		JComboBox cmbbKieuDuLieu = new JComboBox();
		cmbbKieuDuLieu.setModel(new DefaultComboBoxModel(new String[] {"HTML", "PDF", "DOC"}));
		cmbbKieuDuLieu.setSelectedIndex(0);
		cmbbKieuDuLieu.setBounds(146, 102, 168, 34);
		add(cmbbKieuDuLieu);
		
		JRadioButton rdbtnNDHTML = new JRadioButton("Lấy theo nội dung:\r\n");
		
		rdbtnNDHTML.setSelected(true);
		rdbtnNDHTML.setBounds(179, 143, 168, 33);
		add(rdbtnNDHTML);
		
		JLabel lblMuBiVit = new JLabel("Mẫu bài viết: ");
		lblMuBiVit.setBounds(50, 185, 81, 30);
		add(lblMuBiVit);
		
		txtMau = new JTextField();
		txtMau.setEnabled(false);
		txtMau.setBounds(146, 184, 246, 33);
		add(txtMau);
		txtMau.setColumns(10);
		
		JLabel lblNiDungMu = new JLabel("Nội dung mẫu:");
		lblNiDungMu.setBounds(50, 236, 89, 37);
		add(lblNiDungMu);
		
		JTextArea txtANDMau = new JTextArea();
		txtANDMau.setBounds(146, 232, 338, 54);
		add(txtANDMau);
		
		JButton btnMau = new JButton("Browes...");
		
		btnMau.setBounds(434, 183, 89, 34);
		add(btnMau);
		
		JRadioButton rdbtnHTML = new JRadioButton("Lấy toàn bộ trang HTML: ");
		
		rdbtnHTML.setBounds(190, 300, 168, 23);
		add(rdbtnHTML);
		
		JButton btnThucHien = new JButton("Thực hiện:");
		btnThucHien.setBounds(190, 385, 127, 45);
		add(btnThucHien);
		
		txtNoiLuu = new JTextField();
		txtNoiLuu.setEnabled(false);
		txtNoiLuu.setColumns(10);
		txtNoiLuu.setBounds(146, 331, 246, 33);
		add(txtNoiLuu);
		
		JLabel lblNiLu = new JLabel("Nơi Lưu:");
		lblNiLu.setBounds(68, 332, 81, 30);
		add(lblNiLu);
		
		JButton btnNoiLuu = new JButton("Browes...");
		
		btnNoiLuu.setBounds(434, 330, 89, 34);
		add(btnNoiLuu);
		//--lay nguon 
		btnNguon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Lựa chọn đường dẫn");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      txtNguon.setText(chooser.getSelectedFile().toString());
			      chooser.setCurrentDirectory(chooser.getSelectedFile());
			    } else {
			    	txtNguon.setText(chooser.getCurrentDirectory().toString());
			    }
			}
		});

		btnNoiLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Lựa chọn đường dẫn");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			      txtNoiLuu.setText(chooser.getSelectedFile().toString());
			      chooser.setCurrentDirectory(chooser.getSelectedFile());
			    } else {
			    	txtNoiLuu.setText(chooser.getCurrentDirectory().toString());
			    }
			}
		});
		//lay mau
		btnMau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbbKieuDuLieu.getSelectedIndex()==0)
					txtMau.setText(gets.selectFiles("html"));
			}
		});
		//-------dieu kien cua radio button
		rdbtnNDHTML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNDHTML.isSelected()){
					rdbtnHTML.setSelected(false);
					txtMau.setEnabled(true);
					txtANDMau.setEnabled(false);
				}
				else{
					rdbtnNDHTML.setSelected(false);
					txtMau.setEnabled(false);
					txtANDMau.setEnabled(false);
				}
			}
		});
		
		rdbtnHTML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnHTML.isSelected()){
					rdbtnNDHTML.setSelected(false);
					txtMau.setEnabled(false);
					txtANDMau.setEnabled(false);
				}
				else{
					rdbtnHTML.setSelected(false);
					txtMau.setEnabled(false);
					txtANDMau.setEnabled(true);
				}
				
			}
		});
		
	}
	
}
