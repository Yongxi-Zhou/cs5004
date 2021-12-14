package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents shapeState in animation, including position, color, width, height and
 * time.
 */
public class ShapeState {

  private Point minCorner;
  private Color color;
  private int tick;
  private int width;
  private int height;

  /**
   * Constructs a shapeState object.
   *
   * @param t     this shapeState at time t.
   * @param point this shape at position point
   * @param w     the width of this shape in this shapeState
   * @param h     the height of this shape in this shapeState
   * @param color the color of this shape in this shapeState
   */
  public ShapeState(int t, Point point, int w, int h, Color color) {
    this.tick = t;
    this.minCorner = point;
    this.width = w;
    this.height = h;
    this.color = color;
  }

  /**
   * Return the time of this shapeState.
   *
   * @return the time of this shapeState.
   */
  public int getTick() {
    return tick;
  }

  /**
   * Return the position of the shape in this shapeState.
   *
   * @return the position of the shape in this shapeState.
   */
  public Point getMinCorner() {
    return minCorner;
  }

  /**
   * Return the width of the shape in this shapeState.
   *
   * @return the width of the shape in this shapeState.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Return the height of the shape in this shapeState.
   *
   * @return the height of the shape in this shapeState.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Return the color of the shape in this shapeState.
   *
   * @return the color of the shape in this shapeState.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Return the string of the shape in this shapeState.
   * @return the string of the shape in this shapeState.
   */
  @Override
  public String toString() {
    String ticks = "Tick:" + this.tick + "\n";
    String point = "Point:" + this.minCorner + "\n";
    String width = "width: " + this.width + "\n";
    String height = "height: " + this.height + "\n";
    String color = "color" + this.color + "\n";
    return ticks + point + width + height + color;
  }
}
