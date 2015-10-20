import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouLose extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		YouLose gameOver = new YouLose();
		gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOver.setTitle("Game Over: You lost!");
		gameOver.setSize(340, 210);
		gameOver.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		gameOver.add(panel);
		panel.setBackground(Color.ORANGE);
		gameOver.setResizable(false);

		JLabel text = new JLabel("Im sorry, you lost! Play again?");
		text.setFont(new Font("Serif", Font.BOLD, 25));
		text.setForeground(Color.RED);
		text.setBounds(10, 0, 340, 120);
		panel.add(text);

		JButton giveUp = new JButton("Close all game windows");
		giveUp.setBounds(160, 120, 180, 60);
		panel.add(giveUp);
		giveUp.addActionListener(e -> System.exit(0));

		JButton playAgain = new JButton("Play again");
		playAgain.setBounds(0, 120, 160, 60);
		panel.add(playAgain);
		// playAgain.addActionListener(e -> gameOver.dispatchEvent(new
		// WindowEvent(gameOver, WindowEvent.WINDOW_CLOSING)));
		playAgain.addActionListener(e -> Grid.main(args));
	}
}