package phathienluanvan;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HienThiLayDuLieu extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public HienThiLayDuLieu() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(185, 286, 173, -131);
		add(table);
		JOptionPane.showMessageDialog(null, "hay lam");
	}
}
