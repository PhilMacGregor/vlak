package cz.macgregor.vlak.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field {
  public static final int GRASS = 0;
  public static final int GROUND = 1;
  public static final int SKY = 2;

  private final Map<Integer, List<GameObject>> contents;
  private final Map<GameObject, Integer> allObjects;

  /**
   * @param background
   * @param ground
   * @param sky
   */
  public Field() {
    Map<Integer, List<GameObject>> contents = new HashMap<>();
    contents.put(GRASS, new ArrayList<>());
    contents.put(GROUND, new ArrayList<>());
    contents.put(SKY, new ArrayList<>());
    this.contents = contents;
    this.allObjects = new HashMap<>();
  }

  /**
   * @return the contents
   */
  public Map<Integer, List<GameObject>> getContents() {
    return this.contents;
  }

  public void addItem(int layer, GameObject what) {
    List<GameObject> list = this.contents.get(layer);
    if (list == null) {
      throw new IllegalArgumentException("Invalid layer number: " + layer + " for the game map.");
    } else {
      list.add(what);
      this.allObjects.put(what, layer);
    }
  }

  public Integer removeItem(GameObject what) {
    Integer layer = this.allObjects.remove(what);
    if (layer != null) {
      this.contents.get(layer).remove(what);
    }
    return layer;
  }

}
