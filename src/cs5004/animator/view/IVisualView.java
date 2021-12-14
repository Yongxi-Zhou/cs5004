package cs5004.animator.view;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.Point;
import java.awt.Color;
import java.awt.event.ActionListener;

public interface IVisualView {
  void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight);

  boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor);

  void setListeners(ActionListener click);
}
