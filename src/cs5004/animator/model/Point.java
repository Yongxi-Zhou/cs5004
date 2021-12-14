package cs5004.animator.model;


/**
 * This class represents point object, including x and y.
 */
public class Point {

  private int x;
  private int y;

  /**
   * Construct a point object.
   *
   * @param x position X of this point.
   * @param y position Y of this point.
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return  position X of this point.
   *
   * @return position X of this point.
   */
  public int getX() {
    return x;
  }

  /**
   * Return position Y of this point.
   *
   * @return position Y of this point.
   */
  public int getY() {
    return y;
  }
}
