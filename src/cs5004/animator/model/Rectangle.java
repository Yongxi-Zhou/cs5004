package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This class represents rectangle object, including name, type and animationList.
 */
public class Rectangle extends ShapeAbstraction {

  /**
   * Construct a Rectangle object.
   *
   * @param name the name of this Rectangle object.
   */
  public Rectangle(String name) {
    super(name);
    this.type = ShapeType.RECTANGLE;
    this.animationList = new ArrayList<>();
  }

}
