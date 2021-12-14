package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.event.ActionListener;

public interface ITextView {

  void create(Color startColor, ShapeType type, String name, Point startCorner,
      int startWidth, int startHeight);

  void appear(String appearName, int startTime, int endTime);

  void run(int startTime, Point startPoint, int startWidth, int startHeight, Color startColor,
      int endTime, Point endPoint, int endWidth, int endHeight, Color endColor, String name
  );

}
