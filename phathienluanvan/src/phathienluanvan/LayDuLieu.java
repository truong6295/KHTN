package phathienluanvan;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.transform.Templates;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import phathienluanvan.gets;

public class LayDuLieu extends JPanel {
	private JTextField txtURL;
	private JTextField txtNoiLuu;
	/**
	 * Create the panel.
	 */
	public LayDuLieu() {
		setLayout(null);
		
		JLabel lblLyDLiu = new JLabel("L\u1EA4Y D\u1EEE LI\u1EC6U");
		lblLyDLiu.setBounds(219, 11, 107, 27);
		add(lblLyDLiu);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(48, 83, 35, 27);
		add(lblUrl);
		
		txtURL = new JTextField();
		txtURL.setBounds(96, 83, 426, 27);
		add(txtURL);
		txtURL.setColumns(10);
		
		JLabel lblKiuDLiu = new JLabel("Ki\u1EC3u d\u1EEF li\u1EC7u:");
		lblKiuDLiu.setBounds(10, 148, 85, 27);
		add(lblKiuDLiu);
		
		JComboBox cmbbKieuDuLieu = new JComboBox();
		cmbbKieuDuLieu.setModel(new DefaultComboBoxModel(new String[] {"HTML", "PDF", "DOC"}));
		cmbbKieuDuLieu.setSelectedIndex(0);
		cmbbKieuDuLieu.setToolTipText("HTML\r\nPDF\r\nDOC");
		cmbbKieuDuLieu.setBounds(96, 148, 163, 27);
		add(cmbbKieuDuLieu);
		
		JLabel lblNiLu = new JLabel("N\u01A1i l\u01B0u:");
		lblNiLu.setBounds(33, 206, 51, 27);
		add(lblNiLu);
		
		txtNoiLuu = new JTextField();
		txtNoiLuu.setEnabled(false);
		txtNoiLuu.setColumns(10);
		txtNoiLuu.setBounds(97, 206, 247, 27);
		add(txtNoiLuu);
		
		JButton btnThucHien = new JButton("Th\u1EF1c Hi\u1EC7n");
		
		btnThucHien.setBounds(217, 266, 109, 36);
		add(btnThucHien);
		
		JButton btnBrowes = new JButton("Browes...");
		btnBrowes.addActionListener(new ActionListener() {
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
		btnBrowes.setBounds(354, 206, 89, 27);
		add(btnBrowes);

		btnThucHien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtURL.getText().matches("\\s*"))
					JOptionPane.showMessageDialog(null,"Không được để trống phần URL!","Thông báo",JOptionPane.ERROR_MESSAGE);
				else if(txtNoiLuu.getText().matches("\\s*"))
					JOptionPane.showMessageDialog(null,"Chọn nơi cần lưu!","Thông báo",JOptionPane.ERROR_MESSAGE);
				//----layfile
				else if(cmbbKieuDuLieu.getSelectedIndex()==0){
					try {
						//String ketthuc=JOptionPane.showInputDialog("dng xu ly ban co muon ket thuc ? y/n");
						//gets.setkiemtra(ketthuc.equals("y"));
						gets.gethtmls(txtURL.getText(), txtNoiLuu.getText());
						
							
					} catch (IOException e1) {
						//e1.printStackTrace();
					}
				}
			}
		});
	}
}
