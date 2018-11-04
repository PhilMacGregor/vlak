package cz.macgregor.vlak;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import cz.macgregor.vlak.core.Game;
import cz.macgregor.vlak.core.GameMap;
import cz.macgregor.vlak.core.Inputs;
import cz.macgregor.vlak.core.Outputs;
import cz.macgregor.vlak.grf.KeyInputsListener;
import cz.macgregor.vlak.grf.MapLabel;

public class VlakMain {

	public static void main(String[] args) {
		int width = 32;
		int height = 16;
		int fieldWidth = 40;
		int fieldHeight = 40;

		GameMap map = new GameMap(width, height);

		Game game = new Game(map);
		Inputs inputs = new Inputs();
		Outputs outputs = new Outputs();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vlak");

		MapLabel label = new MapLabel(map, fieldWidth, fieldHeight);
		frame.add(label, BorderLayout.CENTER);
		label.addKeyListener(new KeyInputsListener(inputs));
		label.setFocusable(true);

		frame.pack();
		Utils.moveFrameToCenter(frame);
		frame.setVisible(true);

		TimerTask gameTick = new TimerTask() {
			@Override
			public void run() {
				game.tick(map, inputs, outputs);
				frame.repaint();
			}
		};
		Timer tiktak = new Timer();
		tiktak.scheduleAtFixedRate(gameTick, 0, 50);

	}

}
