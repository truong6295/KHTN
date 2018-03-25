package ChongSaoChep;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;

public class LayDuLieu extends JPanel {
	private JTextField txtURL;
	private JTextField txtNoiLuu;
	private Thread thread1;
	private Thread thread2;
	private Thread thread3;
	private Thread thread4;
	//private Set<String> sls1 = new CopyOnWriteArraySet<String>();
	//private Set<String> sls2 = new CopyOnWriteArraySet<String>();
	//private Set<String> sls3 = new CopyOnWriteArraySet<String>();
	private HashSet<String> sls1=new HashSet<String>();
	private HashSet<String> sls2=new HashSet<String>();
	private JTextArea txtaDanhSachLink;
	private JTextArea txtaFileHTML;
	/**
	 * Create the panel.
	 */
	
	public LayDuLieu(){
		initialize();
	}

	public void initialize() {
		
		JLabel lblLyDLiu = new JLabel("L\u1EA4Y D\u1EEE LI\u1EC6U");
		lblLyDLiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLyDLiu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel jpKhung = new JPanel();
		jpKhung.setBackground(SystemColor.control);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBackground(SystemColor.control);
		
		txtURL = new JTextField();
		txtURL.setColumns(10);
		
		JLabel lblKiuDLiu = new JLabel("Ki\u1EC3u d\u1EEF li\u1EC7u:");
		
		JComboBox cmbbKieuDuLieu = new JComboBox();
		cmbbKieuDuLieu.setModel(new DefaultComboBoxModel(new String[] {"HTML", "PDF", "DOC"}));
		cmbbKieuDuLieu.setSelectedIndex(0);
		cmbbKieuDuLieu.setToolTipText("HTML\r\nPDF\r\nDOC");
		
		JLabel lblNiLu = new JLabel("N\u01A1i l\u01B0u:");
		
		txtNoiLuu = new JTextField();
		txtNoiLuu.setEnabled(false);
		txtNoiLuu.setColumns(10);
		
		JButton btnBrowes = new JButton("Browes...");
		
		JButton btnThucHien = new JButton("Th\u1EF1c Hi\u1EC7n");
		
		JLabel lblDanhSchLink = new JLabel("Danh sách link lấy được:");
		
		JButton btnDung = new JButton("Dừng");
		
		
		JLabel lblDanhSchHtml = new JLabel("Danh sách html đã lưu");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_jpKhung = new GroupLayout(jpKhung);
		gl_jpKhung.setHorizontalGroup(
			gl_jpKhung.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jpKhung.createSequentialGroup()
					.addGroup(gl_jpKhung.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblUrl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNiLu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblKiuDLiu, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jpKhung.createSequentialGroup()
									.addComponent(txtNoiLuu, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBrowes, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_jpKhung.createSequentialGroup()
									.addComponent(cmbbKieuDuLieu, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_jpKhung.createSequentialGroup()
									.addComponent(txtURL, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnThucHien, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(128)))
					.addGroup(gl_jpKhung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDanhSchLink, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(lblDanhSchHtml, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addGap(113)
							.addComponent(btnDung, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_jpKhung.setVerticalGroup(
			gl_jpKhung.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpKhung.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDanhSchLink, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(gl_jpKhung.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtURL, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKiuDLiu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbbKieuDuLieu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_jpKhung.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNiLu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNoiLuu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBrowes, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_jpKhung.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDanhSchHtml, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_jpKhung.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDung, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThucHien, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(138))
		);
		
		txtaFileHTML = new JTextArea();
		scrollPane_1.setViewportView(txtaFileHTML);
		
		txtaDanhSachLink = new JTextArea();
		scrollPane.setViewportView(txtaDanhSachLink);
		gl_jpKhung.setAutoCreateGaps(true);
		gl_jpKhung.setAutoCreateContainerGaps(true);
		jpKhung.setLayout(gl_jpKhung);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpKhung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
						.addComponent(lblLyDLiu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblLyDLiu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(jpKhung, GroupLayout.PREFERRED_SIZE, 317, Short.MAX_VALUE)
					.addGap(27))
		);
		setLayout(groupLayout);
				//thuc hien 
		btnThucHien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(cmbbKieuDuLieu.getSelectedIndex()){
					case 0:
						try {
							hienthi1();
							thread2=new Thread(){
								public void run(){
									while(true){
										if(thread1.isAlive()==false){
											try {
												hienthi2();
											} catch (InterruptedException e) {
											}
											break;
										}
										try {
											thread2.sleep(100);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
										}
									}
								}
							};
							thread2.start();
							thread2.join(400);
						} catch (InterruptedException e1) {}
						break;
					case 1:
						System.out.println("PDF");
						break;
					case 2:
						System.out.println("Doc");
						break;
				}
				
			}
		});
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
		//dung
		btnDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				thread1.stop();
				thread3.stop();
			}
		});
	}
	public void hienthi1() throws InterruptedException{
		thread1=new Thread(){
			public void run(){
				Document doc = null;
				try {
					doc = Jsoup.connect(txtURL.getText()).timeout(50000).get();
				} catch (IOException e) {
				}
				Elements links = doc.select("a[href]");
				for (Element link : links) {
					Pattern pattern1 = Pattern.compile("^"+txtURL.getText());
					Matcher matcher1=pattern1.matcher(link.attr("abs:href"));
					if(matcher1.find()){
		        		sls1.add(link.attr("abs:href"));
					}
				}
				
				//luu cac link vao 1 danh sach
				Response response;
				Document doc1;
				int i=1;
				for(String ds:sls1){
					try {
						response = Jsoup.connect(ds).followRedirects(false).execute();
		        		if (200==response.statusCode()) {
							doc1 = Jsoup.connect(ds).timeout(50000).get();
		        			Elements links1 = doc1.select("a[href]");
		        			for (Element link1 : links1) {
		        				Pattern pattern1 = Pattern.compile("^"+txtURL.getText());
		        				Matcher matcher1=pattern1.matcher(link1.attr("abs:href"));
		        				if(matcher1.find()){
		        					if(sls2.contains(link1.attr("abs:href"))==false){
		        						txtaDanhSachLink.setText(txtaDanhSachLink.getText()+link1.attr("abs:href")+"\n");
		        						
		       							System.out.println("thread1: "+i);
		       							sls2.add(link1.attr("abs:href"));
		       							i++;
		       							try {
		       								thread1.sleep(5);
		       							}catch (InterruptedException e) {}
		       							
		        					}
		        				}
		       				}
		        			
		        		}
		        		;
					}catch (IOException  e1) {}
		        }
				//////////////
			}
		};
		thread1.start();
		thread1.join(30);
		
	}
	public void hienthi2() throws InterruptedException{
		
		// luong luu file
		thread3 = new Thread() {
			Response response;
			public void run() {
				System.out.println(sls2.size());
				// in ra vao file
				for(String ds:sls2){
					try {
						response = Jsoup.connect(ds).followRedirects(false).execute();
					} catch (IOException e1) {
					}
					if (200 == response.statusCode()) {
						try {
							gets.savesfilehtml(ds, txtNoiLuu.getText());
							txtaFileHTML.setText(txtaFileHTML.getText() + ds + "\n");
							System.out.println("thread3"+sls2.size());
						} catch ( IOException e) {
							System.out.println("loi"+ds);
						}
						try {
						thread3.sleep(40);
					} catch (InterruptedException e) {}
					}
					
				}
				System.out.println("ket thuc");
			}
		};
		thread3.start();
		thread3.join(100);
	}
	
}
