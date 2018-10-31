package cz.macgregor.vlak.grf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JLabel;

import cz.macgregor.vlak.core.Field;
import cz.macgregor.vlak.core.GameMap;
import cz.macgregor.vlak.core.GameObject;

public class MapLabel extends JLabel {

  private GameMap map;

  private int fieldWidth;

  private int fieldHeight;

  public MapLabel(GameMap map, int fieldWidth, int fieldHeight) {
    super();

    this.fieldWidth = fieldWidth;
    this.fieldHeight = fieldHeight;

    this.map = map;
    this.setPreferredSize(new Dimension(map.getWidth() * fieldWidth, map.getHeight() * fieldHeight));
    this.setOpaque(true);
    this.setBackground(Color.BLACK);
  }

  /**
   * @param map
   *          the map to set
   */
  public void setMap(GameMap map) {
    this.map = map;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < map.getWidth(); i++) {
      for (int j = 0; j < map.getHeight(); j++) {
        Field fld = map.getMap()[i][j];
        for (List<GameObject> layer : fld.getContents().values()) {
          for (GameObject obj : layer) {

            g.drawImage(obj.getImage(), i * fieldWidth, j * fieldHeight, null);

          }
        }
      }
    }
  }

}
