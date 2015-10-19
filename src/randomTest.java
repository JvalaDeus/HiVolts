import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class randomTest extends JFrame {

	public static void main(String[] args) {
		int min = 1;
		int max = 10;
		int mynum = randInt(min, max);
		System.out.println(mynum);

	}

	public static int randInt(int min, int max) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

		return randomNum;
	}
}