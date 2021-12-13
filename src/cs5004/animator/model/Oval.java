package cs5004.animator.model;

import java.util.ArrayList;

public class Oval extends ShapeAbstraction {

  public Oval(String name) {
    super(name);
    this.type = ShapeType.OVAL;
    this.animationList = new ArrayList<>();
  }


}
