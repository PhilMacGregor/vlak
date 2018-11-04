package cz.macgregor.vlak.core;

import java.awt.Image;
import java.awt.Point;

public class GameObject {
	private Sprite sprite;
	protected int layer;
	protected GameMap parent;
	protected Point coords;

	/**
	 * @param sprite
	 */
	public GameObject(Sprite sprite) {
		this.sprite = sprite;
	}

	public void move(int x, int y) {
		this.parent.moveObject(x, y, layer, this);
	}

	public void remove() {
		this.parent.removeObject(coords.x, coords.y, this);
	}

	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * @return the sprite
	 */
	public Image getImage() {
		return sprite.getIcon().getImage();
	}

	/**
	 * @param sprite
	 *            the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}

	/**
	 * @param layer
	 *            the layer to set
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}

	/**
	 * @return the parent
	 */
	public GameMap getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(GameMap parent) {
		this.parent = parent;
	}

	public Point getCoords() {
		return coords;
	}

	public void setCoords(Point coords) {
		this.coords = coords;
	}

}
