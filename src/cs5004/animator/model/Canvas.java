package cs5004.animator.model;

public class Canvas {

  private int x;
  private int y;
  private int width;
  private int height;

  public Canvas() {
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
  }


  public Canvas(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
