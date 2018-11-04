package cz.macgregor.vlak.grf;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cz.macgregor.vlak.core.Inputs;

public class KeyInputsListener implements KeyListener {

	private final Inputs inputs;

	public KeyInputsListener(Inputs inputs) {
		this.inputs = inputs;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// nothing.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.inputs.addKey(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// nothing. The game logic will remove the pressed keys from the stack.
	}

}
