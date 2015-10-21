import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		rules.setSize(540, 550);
		rules.setVisible(true);
		
		JPanel panel = new JPanel();	
		panel.setLayout(null);
		rules.add(panel);
		panel.setBackground(Color.CYAN);
		rules.setResizable(false);
		
		JLabel title = new JLabel("Rules");
		title.setBounds(150, -20, 340, 120);
		title.setFont(new Font("Serif", Font.BOLD, 50));
		title.setForeground(Color.BLACK);
		panel.add(title);
		
		JLabel upLeft = new JLabel("Q: up and left");
		upLeft.setBounds(15, 30, 340, 120);
		upLeft.setFont(new Font("Serif", Font.BOLD, 20));
		upLeft.setForeground(Color.BLACK);
		panel.add(upLeft);
		
		JLabel up = new JLabel("W: up");
		up.setBounds(15, 60, 340, 120);
		up.setFont(new Font("Serif", Font.BOLD, 20));
		up.setForeground(Color.BLACK);
		panel.add(up);
		
		JLabel upRight = new JLabel("E: up and right");
		upRight.setBounds(15, 90, 340, 120);
		upRight.setFont(new Font("Serif", Font.BOLD, 20));
		upRight.setForeground(Color.BLACK);
		panel.add(upRight);
		
		JLabel left = new JLabel("A: left");
		left.setBounds(15, 120, 340, 120);
		left.setFont(new Font("Serif", Font.BOLD, 20));
		left.setForeground(Color.BLACK);
		panel.add(left);
		
		JLabel sit = new JLabel("S: sit (do nothing for one turn)");
		sit.setBounds(15, 150, 340, 120);
		sit.setFont(new Font("Serif", Font.BOLD, 20));
		sit.setForeground(Color.BLACK);
		panel.add(sit);
		
		JLabel right = new JLabel("D: right");
		right.setBounds(15, 180, 340, 120);
		right.setFont(new Font("Serif", Font.BOLD, 20));
		right.setForeground(Color.BLACK);
		panel.add(right);
		
		JLabel down = new JLabel("X: down");
		down.setBounds(15, 210, 340, 120);
		down.setFont(new Font("Serif", Font.BOLD, 20));
		down.setForeground(Color.BLACK);
		panel.add(down);
		
		JLabel downRight = new JLabel("C: down and right");
		downRight.setBounds(15, 240, 340, 120);
		downRight.setFont(new Font("Serif", Font.BOLD, 20));
		downRight.setForeground(Color.BLACK);
		panel.add(downRight);
		
		JLabel downLeft = new JLabel("Z: down and left");
		downLeft.setBounds(15, 270, 340, 120);
		downLeft.setFont(new Font("Serif", Font.BOLD, 20));
		downLeft.setForeground(Color.BLACK);
		panel.add(downLeft);
		
		JLabel jump = new JLabel("J: Jump onto a random Mho or empty space, but not a fence");
		jump.setBounds(15, 300, 570, 120);
		jump.setFont(new Font("Serif", Font.BOLD, 20));
		jump.setForeground(Color.BLACK);
		panel.add(jump);

		JLabel buttonIsHere = new JLabel("Click here");
		buttonIsHere.setBounds(125, 450, 175, 25);
		buttonIsHere.setFont(new Font("Serif", Font.BOLD, 20));
		buttonIsHere.setForeground(Color.BLACK);
		panel.add(buttonIsHere);
		
		JButton startGame = new JButton("Start Playing");
		startGame.setBounds(125, 450, 175, 25);
		startGame.addActionListener(e -> Grid.main(args));
		panel.add(startGame);
		startGame.setVisible(true);
	}

}
