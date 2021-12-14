package cs5004.animator.model;

import java.util.ArrayList;

/**
 * The interface for model operations.
 */
public interface IModel {

  /**
   * Return the canvas parameters of this model.
   *
   * @return the canvas parameters of this model.
   */
  Canvas getCanvas();

  /**
   * Return the shape list of this model.
   *
   * @return the shape list of this model.
   */
  ArrayList<Shape> getShapes();

}
