
public class Mho extends Grid {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
	}

	public void mhoMovement() {
		int newX = 0;
		int newY = 0;
		int mhoArrayIndex = 0;
		
		for (int mho = 0; mho < 12; mho++) {
			mhoArrayIndex++;
		}
		originalMhoPositionX = mhoCoord[mhoArrayIndex][0];
		originalMhoPositionY = mhoCoord[mhoArrayIndex][1];
		if (mhoCoord[mhoArrayIndex][0] == playerCell[0]) {
			directionY = (mhoCoord[mhoArrayIndex][1] - playerCell[1]);
			if (directionY > 0) {
				newX = mhoCoord[mhoArrayIndex][0];
				newY = mhoCoord[mhoArrayIndex][1] - 1;
			}
			if (directionY < 0) {
				newX = mhoCoord[mhoArrayIndex][0];
				newY = mhoCoord[mhoArrayIndex][1] + 1;
			}
		}
		if (mhoCoord[mhoArrayIndex][1] == playerCell[1]) {
			directionX = (mhoCoord[mhoArrayIndex][0] - playerCell[0]);
			if (directionX > 0) {
				newX = mhoCoord[mhoArrayIndex][0] + 1;
				newY = mhoCoord[mhoArrayIndex][1];
			}
			if (directionX < 0) {
				newX = mhoCoord[mhoArrayIndex][0] - 1;
				newY = mhoCoord[mhoArrayIndex][1];
			}
		}
		if (mhoCoord[mhoArrayIndex][0] != playerCell[0] && mhoCoord[mhoArrayIndex][1] != playerCell[1]) {
			directionX = mhoCoord[mhoArrayIndex][0] - playerCell[0];
			directionY = mhoCoord[mhoArrayIndex][1] - playerCell[1];
			if (directionX > 0 && directionY > 0) {
				newX = mhoCoord[mhoArrayIndex][0] - 1;
				newY = mhoCoord[mhoArrayIndex][1] - 1;
			}
			if (directionX < 0 && directionY > 0) {
				newX = mhoCoord[mhoArrayIndex][0] + 1;
				newY = mhoCoord[mhoArrayIndex][1] - 1;
			}
			if (directionX > 0 && directionY < 0) {
				newX = mhoCoord[mhoArrayIndex][0] - 1;
				newY = mhoCoord[mhoArrayIndex][1] + 1;
			}
			if (directionX < 0 && directionY < 0) {
				newX = mhoCoord[mhoArrayIndex][0] + 1;
				newY = mhoCoord[mhoArrayIndex][1] + 1;
			}
		}

		if (cells[newX][newY] == playerNum) {
			YouLose.main(null);
		} else if (cells[newX][newY] == FenceNum) {
			cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
			mhoStatus[mhoArrayIndex] = dead;
		} else if (cells[newX][newY] == unoccupied) {
			cells[newX][newY] = mhoNum;
			cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
		}
		repaint();
	}
}