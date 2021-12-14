package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;

/**
 * The interface for view class(both textView and visualView class).
 */
public interface IView {

  /**
   * Run the animation of the shape in this view.
   *
   * @param startTime   the appearance time of this shape in this view
   * @param startPoint  the startPoint of this shape in this view
   * @param startWidth  the startWidth of this shape in this view
   * @param startHeight the startHeight of this shape in this view
   * @param startColor  the startColor of this shape in this view
   * @param endTime     the endTime of this shape in this view
   * @param endPoint    the endPoint of this shape in this view
   * @param endWidth    the endWidth of this shape in this view
   * @param endHeight   the endHeight of this shape in this view
   * @param endColor    the endColor of this shape in this view
   * @param name        the name of this shape in this view
   */
  void run(int startTime, Point startPoint, int startWidth, int startHeight, Color startColor,
      int endTime, Point endPoint, int endWidth, int endHeight, Color endColor, String name
  );

  /**
   * Create shape on this view.
   *
   * @param startColor  the color of the shape to be created.
   * @param type        the type of the shape to be created.
   * @param name        the name of the shape to be created.
   * @param startCorner the corner of the shape to be created.
   * @param startWidth  the width of the shape to be created.
   * @param startHeight the height of the shape to be created.
   */
  void create(Color startColor, ShapeType type, String name, Point startCorner,
      int startWidth, int startHeight);

}
