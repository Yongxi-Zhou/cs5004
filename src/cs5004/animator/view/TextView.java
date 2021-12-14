package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.io.IOException;

public class TextView implements ITextView {

  final Appendable out;

  public TextView(Appendable out) {
    this.out = out;
  }

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

  private void scaleHeight(int startHeight, int endHeight, int endTime, int startTime,
      String name) {
    try {
      this.out.append(
          name + " changes height from " + startHeight + " to " + startHeight + " from time t="
              + startTime + " to t=" + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

  private void scaleWidth(int startWidth, int endWidth, int endTime, int startTime, String name) {
    try {
      this.out.append(
          name + " changes width from " + startWidth + " to " + endWidth + " from time t="
              + startTime + " to t=" + endTime + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Add output error");
    }
  }

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
