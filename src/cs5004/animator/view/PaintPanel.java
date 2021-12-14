package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class represents the PaintPanel.
 */
public class PaintPanel extends JPanel implements Feature {

  private int curX;
  private int curY;
  private int curWidth;
  private int curHeight;
  private Color curColor;
  private ShapeType type;
  public static final int RENDERTIMES = 25;

  /**
   * Paint the component on the JPanel.
   *
   * @param g the Graphic object
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(curColor);
    if (type.equals(ShapeType.RECTANGLE)) {
      g.fillRect(curX, curY, curWidth, curHeight);
    } else if (type.equals(ShapeType.OVAL)) {
      g.fillOval(curX, curY, curWidth, curHeight);
    }

  }


  /**
   * Run the animation of the shape in this view.
   *
   * @param startTime   the appearance time of this shape in this view
   * @param startPoint  the startPoint of this shape in this view
   * @param startWidth  the startWidth of this shape in this view
   * @param startHeight the startHeight of this shape in this view
   * @param startColor  the startColor of this shape in this view
   * @param endTime     the endTime of this shape in this view
   * @param endPoint    the endPoint of this shape in this view
   * @param endWidth    the endWidth of this shape in this view
   * @param endHeight   the endHeight of this shape in this view
   * @param endColor    the endColor of this shape in this view
   */
  public void runAnimation(int startTime, cs5004.animator.model.Point startPoint, int startWidth,
      int startHeight, Color startColor, int endTime, cs5004.animator.model.Point endPoint,
      int endWidth,
      int endHeight, Color endColor) {

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


  /**
   * The animation feature of changeColor.
   *
   * @param startColor startColor of this animation
   * @param endColor   duration of this animation
   * @param duration   duration of this animation
   */
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


  /**
   * The animation feature of scale width or height.
   *
   * @param startWidth  startWidth of this animation
   * @param startHeight startHeight of this animation
   * @param endWidth    endWidth of this animation
   * @param endHeight   endHeight of this animation
   * @param duration    duration of this animation
   */
  @Override
  public void scale(int startWidth, int startHeight, int endWidth, int endHeight, int duration) {
    curWidth += (endWidth - startWidth) / RENDERTIMES;
    curHeight += (endHeight - startHeight) / RENDERTIMES;
    repaint();
  }

  /**
   * The animation feature of move.
   *
   * @param startPoint startPoint of this animation
   * @param endPoint   endPoint of this animation
   * @param dur        duration of this animation
   */
  @Override
  public void move(Point startPoint, Point endPoint, int dur) {
    if (curX < endPoint.getX() || curY < endPoint.getY()) {
      curX += (endPoint.getX() - startPoint.getX()) / (RENDERTIMES);
      curY += (endPoint.getY() - startPoint.getY()) / (RENDERTIMES);
      repaint();
    }
  }

  /**
   * Paint the initial shape on this paintPanel.
   *
   * @param point  the position of this initial shape.
   * @param width  the width of this initial shape.
   * @param height the height of this initial shape.
   * @param color  the color of this initial shape.
   * @param type   the type of this initial shape.
   */
  public void paintInit(Point point, int width, int height, Color color, ShapeType type) {
    curX = point.getX();
    curY = point.getY();
    curWidth = width;
    curHeight = height;
    curColor = color;
    this.type = type;
  }

  /**
   * Return true if the animation is finished.
   *
   * @param endPoint  the end position of this shape in this view.
   * @param endWidth  the end width of this shape in this view.
   * @param endHeight the end height of this shape in this view.
   * @param endColor  the end color of this shape in this view.
   * @return true if the animation is finished.
   */
  public boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor) {
    return (Math.abs(curX - endPoint.getX()) <= 0.01 && Math.abs(curY - endPoint.getY()) <= 0.01)
        && (
        Math.abs(curWidth - endWidth) <= 0.01 && Math.abs(curHeight - endHeight) <= 0.01) && (
        Math.abs(curColor.getRed() - endColor.getRed()) <= 0.01
            && Math.abs(curColor.getGreen() - endColor.getGreen()) <= 0.01
            && Math.abs(curColor.getBlue() - endColor.getBlue()) <= 0.01);
  }
}
