package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This interface contains all operations that all types of shapes should support.
 */
public interface Shape {

  /**
   * Return the name of this shape.
   *
   * @return the name of this shape.
   */
  String getName();

  /**
   * Return the shape type of this shape.
   *
   * @return the shape type of this shape.
   */
  ShapeType getType();

  /**
   * Return the animation list of this shape.
   *
   * @return the animation list of this shape.
   */
  ArrayList<ShapeSection> getAnimationList();

  /**
   * Set  the animation list of this shape.
   *
   * @param animationList the animation list of this shape to be set.
   */
  void setAnimationList(ArrayList<ShapeSection> animationList);

}
