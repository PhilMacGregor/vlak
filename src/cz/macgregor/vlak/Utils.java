package cz.macgregor.vlak;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

public class Utils {
  /**
   * move the frame to the center of the screen.
   * 
   * @param frame
   *          frame
   */
  public static void moveFrameToCenter(JFrame frame) {
    Point stred = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    stred.move(stred.x - (frame.getSize().width / 2), stred.y - (frame.getSize().height / 2));
    frame.setLocation(stred);
  }
}
