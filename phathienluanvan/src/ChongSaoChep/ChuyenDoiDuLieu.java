package ChongSaoChep;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChuyenDoiDuLieu extends JPanel {
	private JTextField txtNguon;
	private JTextField txtMau;
	private JTextField txtNoiLuu;

	/**
	 * Create the panel.
	 */
	public ChuyenDoiDuLieu() {
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblChuyniD = new JLabel("CHUYỂN ĐỔI DỮ LIỆU");
		lblChuyniD.setVerticalAlignment(SwingConstants.TOP);
		lblChuyniD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChuyniD.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChuyniD, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChuyniD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addGap(14))
		);
		
		JPanel panel = new JPanel();
		
		JLabel lblThMcNgun = new JLabel("Thư mục nguồn: ");
		
		txtNguon = new JTextField();
		txtNguon.setEnabled(false);
		txtNguon.setColumns(10);
		
		JButton btnNguon = new JButton("Browes...");
		
		JLabel lblKiuDLiu = new JLabel("Kiểu dữ liệu: ");
		
		JComboBox cmbbKieuDuLieu = new JComboBox();
		cmbbKieuDuLieu.setModel(new DefaultComboBoxModel(new String[] {"HTML", "PDF", "DOC"}));
		cmbbKieuDuLieu.setSelectedIndex(0);
		
		JRadioButton rdbtnNDHTML = new JRadioButton("Lấy theo nội dung:\r\n");
		
		rdbtnNDHTML.setSelected(true);
		
		JLabel lblMuBiVit = new JLabel("Mẫu bài viết: ");
		
		txtMau = new JTextField();
		txtMau.setEnabled(false);
		txtMau.setColumns(10);
		
		JButton btnMau = new JButton("Browes...");
		
		JLabel lblNiDungMu = new JLabel("Nội dung mẫu:");
		
		JTextArea txtANDMau = new JTextArea();
		
		JRadioButton rdbtnHTML = new JRadioButton("Lấy toàn bộ trang HTML: ");
		
		JLabel lblNiLu = new JLabel("Nơi Lưu:");
		
		txtNoiLuu = new JTextField();
		txtNoiLuu.setEnabled(false);
		txtNoiLuu.setColumns(10);
		
		JButton btnNoiLuu = new JButton("Browes...");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblThMcNgun)
										.addComponent(lblKiuDLiu, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMuBiVit, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNiDungMu, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtANDMau, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtMau, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
												.addComponent(cmbbKieuDuLieu, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNguon, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnMau)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(btnNguon)
													.addPreferredGap(ComponentPlacement.RELATED))))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(39)
											.addComponent(rdbtnNDHTML, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNiLu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNoiLuu, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
									.addGap(8)
									.addComponent(btnNoiLuu)))
							.addGap(5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(123)
							.addComponent(rdbtnHTML, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
							.addGap(47)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblThMcNgun, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNguon, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNguon, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKiuDLiu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbbKieuDuLieu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(rdbtnNDHTML)
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMuBiVit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMau, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMau, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNiDungMu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtANDMau, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(rdbtnHTML)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNiLu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNoiLuu, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNoiLuu, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JTextArea textArea = new JTextArea();
		
		JLabel lblDanhSchFile = new JLabel("Danh sách file đã lưu");
		
		JButton btnThucHien = new JButton("Thực hiện:");
		
		JButton btnDung = new JButton("Dừng lưu");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDanhSchFile, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
							.addGap(20)))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(246)
					.addComponent(btnThucHien, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnDung, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(230))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDanhSchFile, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnThucHien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDung, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
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
					txtMau.setEnabled(false);
					txtANDMau.setEnabled(false);
				}
				else{
					rdbtnNDHTML.setSelected(false);
					txtMau.setEnabled(false);
					txtANDMau.setEnabled(false);
				}
			}
		});
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
		setLayout(groupLayout);
		
	}
	
}
