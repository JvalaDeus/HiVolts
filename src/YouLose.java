import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouLose extends JFrame {
	/**
	 * This creates a window that tells the player if they lost. It also asks if
	 * they would like to play again, and presents two buttons. "play again"
	 * opens a new game, and "close all windows", well, it closes all windows.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
	
		// Creates the JFrame and size, also puts a title.
		YouLose gameOver = new YouLose();
		gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOver.setTitle("Game Over: You lost!");
		gameOver.setSize(340, 210);
		gameOver.setVisible(true);
		
		// Creates a JPanel that is not resizable and colors the background orange
		JPanel panel = new JPanel();
		panel.setLayout(null);
		gameOver.add(panel);
		panel.setBackground(Color.ORANGE);
		gameOver.setResizable(false);
		
		// creates text in the window at a certain size in the color red.
		JLabel text = new JLabel("Im sorry, you lost! Play again?");
		text.setFont(new Font("Serif", Font.BOLD, 25));
		text.setForeground(Color.RED);
		text.setBounds(10, 0, 340, 120);
		panel.add(text);
		
		// button that closes everything by going to system exit
		JButton giveUp = new JButton("Close all game windows");
		giveUp.setBounds(160, 120, 180, 60);
		panel.add(giveUp);
		giveUp.addActionListener(e -> System.exit(0));
		
		// opens up a new game by running the main of Grid
		JButton playAgain = new JButton("Play again");
		playAgain.setBounds(0, 120, 160, 60);
		panel.add(playAgain);
		
		// supposed to close the original window, but it didnt work, it closed
		// all the windows.
		// playAgain.addActionListener(e -> gameOver.dispatchEvent(new
		// WindowEvent(gameOver, WindowEvent.WINDOW_CLOSING)));
		playAgain.addActionListener(e -> Grid.main(args));
	}
}