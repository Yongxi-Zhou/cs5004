package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This abstract class represents ShapeAbstraction.
 */
public abstract class ShapeAbstraction implements Shape {

  protected String name;
  protected ArrayList<ShapeSection> animationList;
  protected ShapeType type;

  /**
   * The subclass can construct object with this method.
   *
   * @param name the name of this shape
   */
  public ShapeAbstraction(String name) {
    this.name = name;
  }

  /**
   * Return the name of this shape.
   *
   * @return the name of this shape.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Return the animation list of this shape.
   *
   * @return the animation list of this shape.
   */
  @Override
  public ArrayList<ShapeSection> getAnimationList() {
    return animationList;
  }

  /**
   * Set  the animation list of this shape.
   *
   * @param animationList the animation list of this shape to be set.
   */
  @Override
  public void setAnimationList(ArrayList<ShapeSection> animationList) {
    this.animationList = animationList;
  }

  /**
   * Return the shape type of this shape.
   *
   * @return the shape type of this shape.
   */
  @Override
  public ShapeType getType() {
    return type;
  }

  /**
   * Return the string represent this shape.
   *
   * @return the string represent this shape.
   */
  @Override
  public String toString() {
    String name = "Name:" + this.name + "\n";
    String type = "Type:" + this.type + "\n";
    String list = "List: " + this.animationList + "\n";
    return name + type + list;
  }

}
