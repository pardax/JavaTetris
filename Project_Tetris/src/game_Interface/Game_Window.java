package game_Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game_Window extends JPanel{

	public Game_Window() {
		super();
	}
	
	public static void main(String[] args) {
		/*
		 EventQueue �� SwingUtilities ������ :
		 �̺�Ʈ�� ����, ������ �̺�Ʈ�� ������ Ŭ����
		*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("��Ʈ����");
				frame.setSize(420, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setContentPane(new Game_Screen());
				frame.setResizable(false);
				frame.setVisible(true);
				new Game_Window();
			}
		});
	}
		
	

}
