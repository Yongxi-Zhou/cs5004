package cs5004.animator.view;

import cs5004.animator.controller.Controller;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.event.ActionListener;

public interface IView {
  void setListeners(ActionListener e);

  void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight);

  void run(int startTime, Point startPoint, int startWidth, int startHeight, Color startColor,
      int endTime, Point endPoint, int endWidth, int endHeight, Color endColor,
      ActionListener e);

  void setTimer(int duration, ActionListener e);

  void init(Point point, int width, int height, Color color, ShapeType type);
}
