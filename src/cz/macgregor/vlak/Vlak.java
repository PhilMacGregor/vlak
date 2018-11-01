package cz.macgregor.vlak;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import cz.macgregor.vlak.core.Field;
import cz.macgregor.vlak.core.GameMap;
import cz.macgregor.vlak.core.GameObject;
import cz.macgregor.vlak.core.Sprite;
import cz.macgregor.vlak.grf.MapLabel;

public class Vlak {

  public static void main(String[] args) {
    int width = 32;
    int height = 16;
    int fieldWidth = 40;
    int fieldHeight = 40;

    GameMap map = new GameMap(width, height);
    map.addObject(10, 10, Field.GROUND, new GameObject(Sprite.LOCO));
    map.addObject(11, 10, Field.GROUND, new GameObject(Sprite.VAGON1));
    map.addObject(12, 10, Field.GROUND, new GameObject(Sprite.VAGON1));
    map.addObject(13, 10, Field.GROUND, new GameObject(Sprite.VAGON1));
    map.addObject(20, 15, Field.GROUND, new GameObject(Sprite.PASSENGER1));
    map.addObject(23, 8, Field.GROUND, new GameObject(Sprite.PASSENGER1));
    map.addObject(8, 12, Field.GROUND, new GameObject(Sprite.PASSENGER1));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Vlak");

    MapLabel label = new MapLabel(map, fieldWidth, fieldHeight);
    frame.add(label, BorderLayout.CENTER);

    frame.pack();
    Utils.moveFrameToCenter(frame);
    frame.setVisible(true);

    label.repaint();

  }

}
