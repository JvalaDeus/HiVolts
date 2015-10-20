
public class Mho<mhoCell> extends Grid {

	public static void main(String[] args) {
		for (int i = 0; i < 12; i++) {
			mhoArray[i] = new Mho();
		}
	}

	public Mho() {
		
	}

	public void mhoMovement() {
		int newX = 0;
		int newY = 0;

		originalMhoPositionX = mhoCell[0];
		originalMhoPositionY = mhoCell[1];
		if (playerCell[0] == playerCell[0]) {
			directionY = (mhoCell[1] - playerCell[1]);
			if (directionY > 0) {
				newX = playerCell[0];
				newY = mhoCell[1] - 1;
			}
			if (directionY < 0) {
				newX = playerCell[0];
				newY = mhoCell[1] + 1;
			}
		}
		if (mhoCell[1] == playerCell[1]) {
			directionX = (playerCell[0] - playerCell[0]);
			if (directionX > 0) {
				newX = playerCell[0] + 1;
				newY = mhoCell[1];
			}
			if (directionX < 0) {
				newX = playerCell[0] - 1;
				newY = mhoCell[1];
			}
		}
		if (playerCell[0] != playerCell[0] && mhoCell[1] != playerCell[1]) {
			directionX = playerCell[0] - playerCell[0];
			directionY = mhoCell[1] - playerCell[1];
			if (directionX > 0 && directionY > 0) {
				newX = playerCell[0] - 1;
				newY = mhoCell[1] - 1;
			}
			if (directionX < 0 && directionY > 0) {
				newX = playerCell[0] + 1;
				newY = mhoCell[1] - 1;
			}
			if (directionX > 0 && directionY < 0) {
				newX = playerCell[0] - 1;
				newY = mhoCell[1] + 1;
			}
			if (directionX < 0 && directionY < 0) {
				newX = playerCell[0] + 1;
				newY = mhoCell[1] + 1;
			}
		}

		if (cells[newX][newY] == playerNum) {
			YouLose.main(null);
		} else if (cells[newX][newY] == FenceNum) {
			cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
		} else if (cells[newX][newY] == unoccupied) {
			cells[newX][newY] = mhoNum;
			cells[originalMhoPositionX][originalMhoPositionY] = unoccupied;
		}

		repaint();
	}
}