package cz.macgregor.vlak.core;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {

	private Random randy = new Random();

	private Map<Integer, GameAction> keyMappings;

	private GameMap map;

	private Point currentDirection;

	private int turn;

	private int score;

	private TrainObject vlak;

	public Game(GameMap map) {
		this.map = map;
		this.keyMappings = new HashMap<>();
		keyMappings.put(KeyEvent.VK_UP, new ChangeDirectionAction(0, -1));
		keyMappings.put(KeyEvent.VK_DOWN, new ChangeDirectionAction(0, 1));
		keyMappings.put(KeyEvent.VK_LEFT, new ChangeDirectionAction(-1, 0));
		keyMappings.put(KeyEvent.VK_RIGHT, new ChangeDirectionAction(1, 0));
		keyMappings.put(KeyEvent.VK_R, new ResetAction());

		reset();
	}

	public void reset() {
		map.reset();

		this.score = 0;
		this.turn = 0;
		this.currentDirection = new Point(0, 0);

		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();
		addPassenger();

		this.vlak = new TrainObject(Sprite.LOCO);
		map.addObject(15, 5, Field.GROUND, vlak);

	}

	public void tick(GameMap map, Inputs inputs, Outputs outputs) {
		for (int key : inputs.getKeys()) {
			if (keyMappings.containsKey(key)) {
				boolean endTurn = keyMappings.get(key).doAction(this);

				if (endTurn) {
					inputs.getKeys().clear();
					outputs.setEnd(true);
					return;
				}
			}
		}
		inputs.getKeys().clear();

		int nextX = (vlak.getCoords().x + currentDirection.x) % map.getWidth();
		int nextY = (vlak.getCoords().y + currentDirection.y) % map.getHeight();

		vlak.move(nextX < 0 ? map.getWidth() - 1 : nextX, nextY < 0 ? map.getHeight() - 1 : nextY);

		GameObject passenger = map.findItem(vlak.getCoords().x, vlak.getCoords().y, "PASSENGER");
		if (passenger != null) {
			vlak.getLast().setNext(new TrainObject(Sprite.VAGON1));
			passenger.remove();
			score++;

			addPassenger();
		}
		GameObject vagon = map.findItem(vlak.getCoords().x, vlak.getCoords().y, "TRAIN");
		if (vagon != null) {
			System.out.println("BUM! (skore: " + score + ")");
			this.reset();
		}

		System.out.println("turn " + turn);
		turn++;
	}

	/**
	 * @return the currentDirection
	 */
	public Point getCurrentDirection() {
		return currentDirection;
	}

	/**
	 * @param currentDirection
	 *            the currentDirection to set
	 */
	public void setCurrentDirection(Point currentDirection) {
		this.currentDirection = currentDirection;
	}

	private void addPassenger() {
		map.addObject(randy.nextInt(map.getWidth()), randy.nextInt(map.getHeight()), Field.GROUND,
				new GameObject(Sprite.PASSENGER1));
	}

}
