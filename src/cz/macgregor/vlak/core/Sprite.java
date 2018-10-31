package cz.macgregor.vlak.core;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public enum Sprite {

  LOCO("loco.png"), VAGON1("vagon.png");

  /** the icon encapsulated by the sprite. */
  private final ImageIcon icon;

  Sprite(String url) {
    URL path = Sprite.class.getClassLoader().getResource(url);
    this.icon = new ImageIcon(path);
  }

  /**
   * @return the icon
   */
  public ImageIcon getIcon() {
    return icon;
  }

}
