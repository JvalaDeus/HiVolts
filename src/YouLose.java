import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class YouLose extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		YouLose gameOver = new YouLose();
		gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOver.setSize(300, 300);
		gameOver.setVisible(true);
		JPanel panel = new JPanel();
		gameOver.add(panel);
		gameOver.setResizable(false);
		JButton button = new JButton("Close game window");
		panel.add(button);
		button.addActionListener(e -> System.exit(0));
	}
}