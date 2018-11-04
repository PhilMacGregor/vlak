package cz.macgregor.vlak.core;

import java.net.URL;

import javax.swing.ImageIcon;

public enum Sprite {

	LOCO("loco.png", "LOCO"), VAGON1("vagon.png", "TRAIN"), VAGON2("vagon2.png", "TRAIN"), PASSENGER1("gentleman.png",
			"PASSENGER");

	/** the icon encapsulated by the sprite. */
	private final ImageIcon icon;
	/** the item type. */
	private final String type;

	Sprite(String url, String type) {
		URL path = Sprite.class.getClassLoader().getResource(url);
		this.icon = new ImageIcon(path);
		this.type = type;
	}

	/**
	 * @return the icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}

	public String getType() {
		return type;
	}

}
