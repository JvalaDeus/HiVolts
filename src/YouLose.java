import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class YouLose extends YouWin {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		YouLose gameOver = new YouLose();
		gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOver.setTitle("Game Over: You lost!");
		gameOver.setSize(300, 210);
		gameOver.setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		gameOver.add(panel);
		gameOver.setResizable(false);
		
		TextField text = new TextField("Im sorry, you lost! Would you like to play again?");
		text.setBounds(0,0,300,100);
		panel.add(text);

		JButton giveUp = new JButton("Close game window");
		giveUp.setBounds(150, 120, 150, 60);
		panel.add(giveUp);
		giveUp.addActionListener(e -> System.exit(0));

		JButton playAgain = new JButton("Play again");
		playAgain.setBounds(0, 120, 150, 60);
		panel.add(playAgain);
	//	playAgain.addActionListener(e -> gameOver.dispatchEvent(new WindowEvent(gameOver, WindowEvent.WINDOW_CLOSING)));
		playAgain.addActionListener(e -> Grid.main(args));
	}
}