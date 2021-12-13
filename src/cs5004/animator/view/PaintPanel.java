package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ActionListener should be in controller
 */
public class PaintPanel extends JPanel implements Feature {

  private int duration;

  private int curX;
  private int curY;
  private int curWidth;
  private int curHeight;
  private Color curColor;
  private ShapeType type;
  final int RENDERTIMES = 100;

  public PaintPanel() {

  }

  private Timer tm;
  private int x = 0, velX = 20;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("paint");
    g.setColor(curColor);
    g.fillRect(curX, curY, curWidth, curHeight);

    tm.start();
  }

//  public void runAnimation() {
//    if (x <0 || x > 550) {
//      velX = -velX;
//    }
//    x = x + velX;
//    repaint();
//  }

  public void setTimer(int duration, ActionListener timer) {
    tm = new Timer(duration * 1000 / RENDERTIMES, timer);
  }


  public void runAnimation(int startTime, cs5004.animator.model.Point startPoint, int startWidth,
      int startHeight, Color startColor, int endTime, cs5004.animator.model.Point endPoint,
      int endWidth,
      int endHeight, Color endColor, ActionListener timer) {

    if ((curX <= endPoint.getX() && curY <= endPoint.getY()) && (
        startPoint.getX() != endPoint.getX() || startPoint.getY() != endPoint.getY())) {
      this.move(startPoint, endPoint, endTime - startTime);
    }
    if ((curWidth <= endWidth && curHeight <= endHeight) && (startWidth != endWidth
        || startHeight != endHeight)) {
      this.scale(startWidth, startHeight, endWidth, endHeight, endTime - startTime);
    }
    if (!startColor.equals(endColor)) {
      this.changeColor(startColor, endColor, endTime - startTime);
      if (curColor.equals(endColor)) {
        tm.removeActionListener(timer);
      }
    }

  }

  @Override
  public void changeColor(Color startColor, Color endColor, int duration) {
    System.out.println("changeColor");
    int red = curColor.getRed() + ((endColor.getRed() - startColor.getRed()) / RENDERTIMES);
    int green = curColor.getGreen() + ((endColor.getGreen() - startColor.getGreen()) / RENDERTIMES);
    int blue = curColor.getBlue() + ((endColor.getBlue() - startColor.getBlue()) / RENDERTIMES);
    curColor = new Color(red, green, blue);
  }

  @Override
  public void scale(int startWidth, int startHeight, int endWidth, int endHeight, int duration) {
    System.out.println("scale");
    curWidth += (endWidth - startWidth) / RENDERTIMES;
    curHeight += (endHeight - startHeight) / RENDERTIMES;
    repaint();
    System.out.println("-----------------scale--------------------");
  }

  @Override
  public void move(Point startPoint, Point endPoint, int dur) {
    curX += (endPoint.getX() - startPoint.getX()) / (RENDERTIMES);
    curY += (endPoint.getY() - endPoint.getY()) / (RENDERTIMES);
    repaint();
  }

  public void paintTest(Point point, int width, int height, Color color, ShapeType type) {
    curX = point.getX();
    curY = point.getY();
    curWidth = width;
    curHeight = height;
    curColor = color;
    this.type = type;
  }
}
