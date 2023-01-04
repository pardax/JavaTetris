package testing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class main extends JPanel{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("테트리스");
				frame.setSize(1000, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setContentPane(new screen());
				frame.setResizable(false);
				frame.setVisible(false);
				new main();
			}
		});
	}
}
