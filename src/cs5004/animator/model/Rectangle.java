package cs5004.animator.model;

import java.util.ArrayList;

public class Rectangle extends ShapeAbstraction {

  public Rectangle(String name) {
    super(name);
    this.type = ShapeType.RECTANGLE;
    this.animationList = new ArrayList<>();
  }

}
