package cs5004.animator.model;

import java.awt.Color;

public class ShapeState {
  private Point minCorner;
  private Color color;
  private int tick;
  private int width;
  private int height;

  public ShapeState(int t, Point point, int w, int h, Color color) {
    this.tick = t;
    this.minCorner = point;
    this.width = w;
    this.height = h;
    this.color = color;
  }

  public int getTick() {
    return tick;
  }

  public Point getMinCorner() {
    return minCorner;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Color getColor() {
    return color;
  }


  @Override
  public String toString() {
    String ticks = "Name:" + this.tick + "\n";
    String point = "Type:" + this.minCorner + "\n";
    String width = "List: " + this.width + "\n";
    String height = "height: " + this.height + "\n";
    String color = "color" + this.color + "\n";
    return ticks + point + width + height + color;
  }
}
