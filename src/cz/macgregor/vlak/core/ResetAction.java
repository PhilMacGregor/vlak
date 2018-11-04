package cz.macgregor.vlak.core;

public class ResetAction implements GameAction {

	@Override
	public boolean doAction(Game game) {
		game.reset();
		return true;
	}

}
