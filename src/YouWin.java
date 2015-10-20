import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class YouWin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		YouWin gameOver = new YouWin();
		gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOver.setTitle("Game Over: You lost!");
		gameOver.setSize(340, 210);
		gameOver.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		gameOver.add(panel);
		gameOver.setResizable(false);

		TextField text = new TextField("Congradulations, you won! Would you like to play again?");
		text.setBounds(0, 0, 340, 120);
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