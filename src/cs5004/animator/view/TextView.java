package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.io.IOException;

/**
 * This class represents TextView.
 */
public class TextView implements ITextView, IView {

  final Appendable out;

  /**
   * construct a TextView object.
   *
   * @param out the System.out of this TextView object.
   */
  public TextView(Appendable out) {
    this.out = out;
  }

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
  @Override
  public void create(Color startColor, ShapeType type, String name, Point startCorner,
      int startWidth, int startHeight) {
    if (type.equals(ShapeType.RECTANGLE)) {
      try {
        this.out.append(
            "Create " + startColor.toString() + " rectangle " + name + " with corner at ("
                + startCorner.getX() + "," + startCorner.getY() + "), width " + startWidth
                + " and height " + startHeight + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Add output error");
      }
    } else if (type.equals(ShapeType.OVAL)) {
      try {
        this.out.append(
            "Create " + startColor.toString() + " oval " + name + " with corner at ("
                + startCorner.getX() + "," + startCorner.getY() + "), radius " + startWidth
                + " and " + startHeight + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Add output error");
      }
    }
  }

  /**
   * Show the appearance and disappearence time of the textView object.
   *
   * @param appearName the shape name of this shape.
   * @param startTime  the appearance name of this shape.
   * @param endTime    the disappearence name of this shape.
   */
  @Override
  public void appear(String appearName, int startTime, int endTime) {
    try {
      this.out.append(
          appearName + " appears at time t=" + startTime + " and disappears at time t=" + endTime
              + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

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
  @Override
  public void run(int startTime, Point startPoint, int startWidth, int startHeight,
      Color startColor, int endTime, Point endPoint, int endWidth, int endHeight, Color endColor,
      String name) {
    if (startPoint.getX() != endPoint.getX() || startPoint.getY() != endPoint.getY()) {
      this.move(startPoint, endPoint, endTime, startTime, name);
    }

    if (startWidth != endWidth) {
      this.scaleWidth(startWidth, endWidth, endTime, startTime, name);
    }

    if (startHeight != endHeight) {
      this.scaleHeight(startHeight, endHeight, endTime, startTime, name);
    }

    if (!startColor.equals(endColor)) {
      this.changeColor(startColor, endColor, endTime, startTime, name);
    }
  }


  /**
   * The animation feature of changeColor.
   *
   * @param startColor startColor of this animation
   * @param endColor   endColor of this animation
   * @param startTime  startTime of this animation
   * @param endTime    endTime of this animation
   * @param name       name of this animation
   */
  private void changeColor(Color startColor, Color endColor, int endTime, int startTime,
      String name) {
    try {
      this.out.append(
          name + " changes from " + startColor.toString() + " to " + endColor.toString()
              + " from time t=" + startTime + " to t=" + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

  /**
   * The animation feature of scaleHeight.
   *
   * @param startHeight startHeight of this animation
   * @param endHeight   endHeight of this animation
   * @param startTime   startTime of this animation
   * @param endTime     endTime of this animation
   * @param name        name of this animation
   */
  private void scaleHeight(int startHeight, int endHeight, int endTime, int startTime,
      String name) {
    try {
      this.out.append(
          name + " changes height from " + startHeight + " to " + endHeight + " from time t="
              + startTime + " to t=" + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

  /**
   * The animation feature of scaleWidth.
   *
   * @param startWidth startWidth of this animation
   * @param endWidth   endWidth of this animation
   * @param startTime  startTime of this animation
   * @param endTime    endTime of this animation
   * @param name       name of this animation
   */
  private void scaleWidth(int startWidth, int endWidth, int endTime, int startTime, String name) {
    try {
      this.out.append(
          name + " changes width from " + startWidth + " to " + endWidth + " from time t="
              + startTime + " to t=" + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

  /**
   * The animation feature of move.
   *
   * @param startPoint startPoint of this animation
   * @param endPoint   endPoint of this animation
   * @param startTime  startTime of this animation
   * @param endTime    endTime of this animation
   * @param name       name of this animation
   */
  private void move(Point startPoint, Point endPoint, int endTime, int startTime, String name) {
    try {
      this.out.append(
          name + " moves from (" + startPoint.getX() + "," + startPoint.getY() + ") to ("
              + endPoint.getX() + "," + endPoint.getY() + ") from time t=" + startTime + " to t="
              + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }
}
