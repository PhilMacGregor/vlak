package cz.macgregor.vlak.core;

import java.awt.Image;

public class GameObject {
  private Sprite sprite;

  /**
   * @param sprite
   */
  public GameObject(Sprite sprite) {
    this.sprite = sprite;
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
   *          the sprite to set
   */
  public void setSprite(Sprite sprite) {
    this.sprite = sprite;
  }
}
