package cs5004.animator.model;

/**
 * This class represents Canvas object.
 */
public class Canvas {

  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * construct a canvas object.
   *
   * @param x      location X of this canvas object.
   * @param y      location Y of this canvas object.
   * @param width  width of this canvas object.
   * @param height height  of this canvas object.
   */
  public Canvas(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Return location X of this canvas object.
   *
   * @return location X of this canvas object.
   */
  public int getX() {
    return x;
  }

  /**
   * Return location Y of this canvas object.
   *
   * @return location Y of this canvas object.
   */
  public int getY() {
    return y;
  }

  /**
   * Return width of this canvas object.
   *
   * @return width of this canvas object.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Return height of this canvas object.
   *
   * @return height of this canvas object.
   */
  public int getHeight() {
    return height;
  }
}
