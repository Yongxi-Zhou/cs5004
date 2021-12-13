package cs5004.animator.view;

import cs5004.animator.model.Point;
import java.awt.Color;

public interface Feature {

  void changeColor(Color startColor, Color endColor, int duration);

  void scale(int startWidth, int startHeight, int endWidth, int endHeight, int duration);

  void move(Point startPoint, Point endPoint, int duration);
}
