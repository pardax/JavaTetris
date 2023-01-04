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
		 EventQueue 와 SwingUtilities 차이점 :
		 이벤트는 단일, 스윙은 이벤트를 포함한 클래스
		*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("테트리스");
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
