package cs5004.animator.view;

import java.awt.Color;
import java.awt.event.ActionListener;

public interface IView {
  void setActionListener(ActionListener actionListener);
  int getStartShapeTime();

  int getStartShapeX();

  int getStartShapeY();

  int getStartShapeWidth();

  int getStartShapeHeight();

  Color getStartShapeColor();

  int getEndShapeTime();

  int getEndShapeX();
  int getEndShapeY();
  int getEndShapeWidth();
  int getEndShapeHeight();
  Color getEndShapeColor();
}
