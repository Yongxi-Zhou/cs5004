package cs5004.animator.view;

import cs5004.animator.model.Point;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 * The interface for visual view class.
 */
public interface IVisualView {

  /**
   * Set the canvas location and size.
   *
   * @param locationX    locationX of this view's canvas
   * @param locationY    locationY of this view's canvas
   * @param canvasWidth  canvasWidth of this view's canvas
   * @param canvasHeight canvasHeight of this view's canvas
   */
  void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight);

  /**
   * Return true if the animation is finished.
   *
   * @param endPoint  the end position of this shape in this view.
   * @param endWidth  the end width of this shape in this view.
   * @param endHeight the end height of this shape in this view.
   * @param endColor  the end color of this shape in this view.
   * @return true if the animation is finished.
   */
  boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor);

  /**
   * Set listener for this view.
   *
   * @param click the actionListener to be bounded for this view.
   */
  void setListeners(ActionListener click);
}
