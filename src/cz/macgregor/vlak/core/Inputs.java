package cz.macgregor.vlak.core;

import java.util.Collection;
import java.util.HashSet;

public class Inputs {

  private final Collection<Integer> keys;

  /**
   * constructor.
   * 
   * @param keys
   */
  public Inputs() {
    this.keys = new HashSet<>();
  }

  public void reset() {
    this.keys.clear();
  }

  public void addKey(int keyCode) {
    this.keys.add(keyCode);
  }

  public void removeKey(int keyCode) {
    this.keys.remove(keyCode);
  }

  /**
   * Getter.
   * 
   * @return the keys
   */
  public Collection<Integer> getKeys() {
    return keys;
  }

}
