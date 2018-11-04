package cz.macgregor.vlak.core;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class GameMap {

	private final Field[][] map;

	private final Map<GameObject, Point> objectLocations;

	public GameMap(int width, int height) {
		this.map = new Field[width][height];
		this.objectLocations = new HashMap<>();
		reset();
	}

	public void reset() {
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[0].length; j++) {
				map[i][j] = new Field();
			}
		}
		this.objectLocations.clear();
	}

	public void addObject(int x, int y, int layer, GameObject what) {
		map[x][y].addItem(layer, what);
		objectLocations.put(what, new Point(x, y));
		what.setLayer(layer);
		what.setParent(this);
		what.setCoords(new Point(x, y));
	}

	public void removeObject(int x, int y, GameObject what) {
		Point pt = objectLocations.remove(what);
		if (pt != null) {
			map[pt.x][pt.y].removeItem(what);
		}
	}

	public void moveObject(int x, int y, int layer, GameObject what) {
		removeObject(x, y, what);
		addObject(x, y, layer, what);
	}

	public GameObject findItem(int x, int y, String itemType) {
		for (GameObject obj : map[x][y].getAllObjects().keySet()) {
			if (obj.getSprite().getType().equals(itemType)) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * @return the map
	 */
	public Field[][] getMap() {
		return this.map;
	}

	public int getWidth() {
		return map.length;
	}

	public int getHeight() {
		return map[0].length;
	}

}
