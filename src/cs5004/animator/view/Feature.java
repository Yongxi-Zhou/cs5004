package cs5004.animator.view;

import cs5004.animator.model.Point;
import java.awt.Color;

/**
 * The interface for animation features.
 */
public interface Feature {

  /**
   * The animation feature of changeColor.
   *
   * @param startColor startColor of this animation
   * @param endColor   endColor of this animation
   * @param duration   duration of this animation
   */
  void changeColor(Color startColor, Color endColor, int duration);

  /**
   * The animation feature of scale width or height.
   *
   * @param startWidth  startWidth of this animation
   * @param startHeight startHeight of this animation
   * @param endWidth    endWidth of this animation
   * @param endHeight   endHeight of this animation
   * @param duration    duration of this animation
   */
  void scale(int startWidth, int startHeight, int endWidth, int endHeight, int duration);

  /**
   * The animation feature of move.
   *
   * @param startPoint startPoint of this animation
   * @param endPoint   endPoint of this animation
   * @param duration   duration of this animation
   */
  void move(Point startPoint, Point endPoint, int duration);
}
