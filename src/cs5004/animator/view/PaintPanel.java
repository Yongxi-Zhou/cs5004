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
  final int RENDERTIMES = 25;

  public PaintPanel() {

  }

  private Timer tm;
  private int x = 0, velX = 20;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("paint");
    g.setColor(curColor);
    if (type.equals(ShapeType.RECTANGLE)) {
      g.fillRect(curX, curY, curWidth, curHeight);
    } else if (type.equals(ShapeType.OVAL)) {
      g.fillOval(curX, curY, curWidth, curHeight);
    }

  }


  public void setTimer(int duration, ActionListener timer) {
    System.out.println("setTimer");
    tm = new Timer(duration  / RENDERTIMES, timer);
    tm.start();
  }


  public void runAnimation(int startTime, cs5004.animator.model.Point startPoint, int startWidth,
      int startHeight, Color startColor, int endTime, cs5004.animator.model.Point endPoint,
      int endWidth,
      int endHeight, Color endColor, ActionListener timer) {

    if ((Math.abs(curX - endPoint.getX()) > 0.01 || Math.abs(curY - endPoint.getY()) > 0.01) && (
        startPoint.getX() != endPoint.getX() || startPoint.getY() != endPoint.getY())) {
      this.move(startPoint, endPoint, endTime - startTime);
    }

    if ((Math.abs(curWidth - endWidth) > 0.01 || Math.abs(curHeight - endHeight) > 0.01) && (
        startWidth != endWidth
            || startHeight != endHeight)) {
      this.scale(startWidth, startHeight, endWidth, endHeight, endTime - startTime);
    }

    if ((Math.abs(curColor.getRed() - endColor.getRed()) > 0.01
        || Math.abs(curColor.getGreen() - endColor.getGreen()) > 0.01
        || Math.abs(curColor.getBlue() - endColor.getBlue()) > 0.01) && (!startColor.equals(
        endColor))) {
      this.changeColor(startColor, endColor, endTime - startTime);
    }

    // remove timer
    if ((Math.abs(curX - endPoint.getX()) <= 0.01 && Math.abs(curY - endPoint.getY()) <= 0.01) && (
        Math.abs(curWidth - endWidth) <= 0.01 && Math.abs(curHeight - endHeight) <= 0.01) && (
        Math.abs(curColor.getRed() - endColor.getRed()) <= 0.01
            && Math.abs(curColor.getGreen() - endColor.getGreen()) <= 0.01
            && Math.abs(curColor.getBlue() - endColor.getBlue()) <= 0.01)) {
      System.out.println("stop");
      tm.removeActionListener(timer);
      tm.stop();
      System.out.println(tm.isRunning());
    }

  }

  @Override
  public void changeColor(Color startColor, Color endColor, int duration) {
    System.out.println("changeColor");

    int red = (curColor.getRed() + ((endColor.getRed() - startColor.getRed()) / RENDERTIMES)) < 0 ? 0
        : curColor.getRed() + ((endColor.getRed() - startColor.getRed()) / RENDERTIMES);
    red = red > 255 ? 255 : red;
    int green =
        (curColor.getGreen() + ((endColor.getGreen() - startColor.getGreen()) / RENDERTIMES)) < 0 ? 0
            : curColor.getGreen() + ((endColor.getGreen() - startColor.getGreen()) / RENDERTIMES);
    green = green > 255 ? 255 : green;
    int blue =
        (curColor.getBlue() + ((endColor.getBlue() - startColor.getBlue()) / RENDERTIMES)) < 0 ? 0
            : curColor.getBlue() + ((endColor.getBlue() - startColor.getBlue()) / RENDERTIMES);
    blue = blue > 255 ? 255 : blue;

    System.out.println(red);
    System.out.println(green);
    System.out.println(blue);
    curColor = new Color(red,green,blue);
    repaint();
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
    if (curX < endPoint.getX() || curY < endPoint.getY()) {
      System.out.println(curX);
      curX += (endPoint.getX() - startPoint.getX()) / (RENDERTIMES);
      curY += (endPoint.getY() - startPoint.getY()) / (RENDERTIMES);
      System.out.println(curX);
      System.out.println(curY);
      repaint();
    }

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
