package cs5004.animator.model;

import java.util.ArrayList;

public abstract class ShapeAbstraction implements Shape {

  protected String name;
  protected ArrayList<ShapeSection> animationList;
  protected ShapeType type;

  public ShapeAbstraction(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ArrayList<ShapeSection> getAnimationList() {
    return animationList;
  }

  @Override
  public void setAnimationList(ArrayList<ShapeSection> animationList) {
    this.animationList = animationList;
  }


  @Override
  public ShapeType getType() {
    return type;
  }

  @Override
  public String toString() {
    String name = "Name:" + this.name + "\n";
    String type = "Type:" + this.type + "\n";
    String list = "List: " + this.animationList + "\n";
    return name + type + list;
  }

}
