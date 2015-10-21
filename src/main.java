import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the main program. It first creates a window that displays the rules.
 * Win you click the "okay" button, it runs the Grid program, which runs the
 * game.
 */

public class main extends JFrame{

	public static void main(String[] args) {
		main rules = new main();
		rules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rules.setTitle("HiVolts Game Rules");
		rules.setSize(340, 210);
		rules.setVisible(true);
		
		JPanel panel = new JPanel();	
	}

}
