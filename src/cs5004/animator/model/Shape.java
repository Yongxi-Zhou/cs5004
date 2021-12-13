package cs5004.animator.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This interface contains all operations that all types of shapes should support.
 */
public interface Shape {

  String getName();

  ShapeType getType();

  ArrayList<ShapeSection> getAnimationList();

  void setAnimationList(ArrayList<ShapeSection> animationList);

}
