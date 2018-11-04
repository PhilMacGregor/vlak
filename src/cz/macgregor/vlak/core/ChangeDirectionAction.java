package cz.macgregor.vlak.core;

import java.awt.Point;

public class ChangeDirectionAction implements GameAction {

	private final Point newDirection;

	public ChangeDirectionAction(Point newDirection) {
		this.newDirection = newDirection;
	}

	public ChangeDirectionAction(int x, int y) {
		this.newDirection = new Point(x, y);
	}

	@Override
	public boolean doAction(Game game) {
		if (!isOpposite(newDirection, game.getCurrentDirection())) {
			game.setCurrentDirection(newDirection);
		}
		return false;
	}

	private boolean isOpposite(Point dir1, Point dir2) {
		return dir1.x == dir2.x * -1 && dir1.y == dir2.y * -1;
	}

}
