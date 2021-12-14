package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This class represents oval object, including name, type and animationList.
 */
public class Oval extends ShapeAbstraction {

  /**
   * Construct a oval object.
   *
   * @param name the name of this oval object.
   */
  public Oval(String name) {
    super(name);
    this.type = ShapeType.OVAL;
    this.animationList = new ArrayList<>();
  }


}
