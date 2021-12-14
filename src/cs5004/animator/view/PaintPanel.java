package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * ActionListener should be in controller
 */
public class PaintPanel extends JPanel implements Feature {

  private int curX;
  private int curY;
  private int curWidth;
  private int curHeight;
  private Color curColor;
  private ShapeType type;
  public static final int RENDERTIMES = 25;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(curColor);
    if (type.equals(ShapeType.RECTANGLE)) {
      g.fillRect(curX, curY, curWidth, curHeight);
    } else if (type.equals(ShapeType.OVAL)) {
      g.fillOval(curX, curY, curWidth, curHeight);
    }

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
  }

  @Override
  public void changeColor(Color startColor, Color endColor, int duration) {
    int red =
        (curColor.getRed() + ((endColor.getRed() - startColor.getRed()) / RENDERTIMES)) < 0 ? 0
            : curColor.getRed() + ((endColor.getRed() - startColor.getRed()) / RENDERTIMES);
    red = red > 255 ? 255 : red;
    int green =
        (curColor.getGreen() + ((endColor.getGreen() - startColor.getGreen()) / RENDERTIMES)) < 0
            ? 0
            : curColor.getGreen() + ((endColor.getGreen() - startColor.getGreen()) / RENDERTIMES);
    green = green > 255 ? 255 : green;
    int blue =
        (curColor.getBlue() + ((endColor.getBlue() - startColor.getBlue()) / RENDERTIMES)) < 0 ? 0
            : curColor.getBlue() + ((endColor.getBlue() - startColor.getBlue()) / RENDERTIMES);
    blue = blue > 255 ? 255 : blue;
    curColor = new Color(red, green, blue);
    repaint();
  }

  @Override
  public void scale(int startWidth, int startHeight, int endWidth, int endHeight, int duration) {
    curWidth += (endWidth - startWidth) / RENDERTIMES;
    curHeight += (endHeight - startHeight) / RENDERTIMES;
    repaint();
  }

  @Override
  public void move(Point startPoint, Point endPoint, int dur) {
    if (curX < endPoint.getX() || curY < endPoint.getY()) {
      curX += (endPoint.getX() - startPoint.getX()) / (RENDERTIMES);
      curY += (endPoint.getY() - startPoint.getY()) / (RENDERTIMES);
      repaint();
    }
  }

  public void paintInit(Point point, int width, int height, Color color, ShapeType type) {
    curX = point.getX();
    curY = point.getY();
    curWidth = width;
    curHeight = height;
    curColor = color;
    this.type = type;
  }

  public boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor) {
    return (Math.abs(curX - endPoint.getX()) <= 0.01 && Math.abs(curY - endPoint.getY()) <= 0.01)
        && (
        Math.abs(curWidth - endWidth) <= 0.01 && Math.abs(curHeight - endHeight) <= 0.01) && (
        Math.abs(curColor.getRed() - endColor.getRed()) <= 0.01
            && Math.abs(curColor.getGreen() - endColor.getGreen()) <= 0.01
            && Math.abs(curColor.getBlue() - endColor.getBlue()) <= 0.01);
  }
}
