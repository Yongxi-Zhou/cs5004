package cs5004.animator.model;

import java.util.HashMap;

public interface IModel {

  Canvas getCanvas();

  HashMap getData();

  boolean isMove();

  boolean isChangeColor();

  boolean isScale();
}
