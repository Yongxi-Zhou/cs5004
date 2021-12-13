package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Model implements IModel {

  private static Canvas canvasBuilder;
  private static ArrayList<Shape> shapes = new ArrayList<>();

  public Model() {

  }


  public static final class Builder implements AnimationBuilder<IModel> {

    private Shape shapeBuilder;
    private ArrayList<ShapeSection> animationList;

    @Override
    public IModel build() {
      System.out.println("build");
      System.out.println(shapes.toString());
      return null;
    }

    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      System.out.println("Canvas:" + x + " " + y + " " + width + " " + height);
      canvasBuilder = new Canvas(x, y, width, height);
      return null;
    }

    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type) {

      if (type.equals("rectangle")) {
        System.out.println(123);
        shapeBuilder = new Rectangle(name);
      } else {
        shapeBuilder = new Oval(name);
      }

      shapes.add(shapeBuilder);
      animationList = new ArrayList<>();
      shapeBuilder.setAnimationList(animationList);

      System.out.println("name:" + name);
      System.out.println("type:" + type);

      return null;
    }

    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
        int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
      System.out.println("time:" + t1);

      ShapeState startState = new ShapeState(t1,new Point(x1, y1), w1, h1, new Color(r1, g1, b1) );

      System.out.println("time:" + t2);
      ShapeState endState = new ShapeState(t2,new Point(x2, y2), w2, h2, new Color(r2, g2, b2) );

      animationList.add(new ShapeSection(startState, endState));

      System.out.println("-----------------------------");

      return null;
    }
  }


  @Override
  public Canvas getCanvas() {
    return canvasBuilder;
  }

  @Override
  public HashMap getData() {
    return null;
  }

  @Override
  public boolean isMove() {
    return false;
  }

  @Override
  public boolean isChangeColor() {
    return false;
  }

  @Override
  public boolean isScale() {
    return false;
  }
}
