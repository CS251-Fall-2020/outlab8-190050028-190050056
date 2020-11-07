import java.io.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
    private JFrame frame;
    private JButton select;
    private JButton process;
    private JTable tb;
    private File fl; 

    public GUI() {
	frame = new JFrame("Tester");
	frame.setSize(400,400);
	select = new JButton("Select file");
	select.addActionListener(this);
	select.setBounds(50, 10, 95, 30);
	process = new JButton("process");
	process.addActionListener(this);
	process.setBounds(200, 10, 95, 30);
	frame.add(select);
	frame.add(process);
	frame.setLayout(null);
	frame.setVisible(true);
	// fl = new File("MD5sums");
    }

    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == select) {
	    System.out.println("Select pressed");
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(this);
		if (i == JFileChooser.APPROVE_OPTION) fl = fc.getSelectedFile();
	}
	else if (e.getSource() == process) {
	    System.out.println("Process pressed");
	    String[] columns = { "plain-text", "result" };
	    String[][] data = MD5.getResults(fl);
	    for (String[] row : data) {
		System.out.printf("%s | %s\n", row[0], row[1]);
	    }
	    tb = new JTable(data, columns);
	    tb.setBounds(30, 50, 200, 300);
	    frame.add(tb);
	    frame.setVisible(true);
	}
    }

	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
