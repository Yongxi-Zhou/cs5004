package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;
import java.awt.Color;
import java.util.ArrayList;

/**
 * This class represents model object, including canvas and shape list.
 */
public class Model implements IModel {

  private static Canvas canvasBuilder;
  private static ArrayList<Shape> shapesBuilder = new ArrayList<>();

  private Canvas canvas;
  private ArrayList<Shape> shapes;

  /**
   * Construct a model object and pass parameters from the file.
   */
  public Model() {
    canvas = canvasBuilder;
    shapes = shapesBuilder;
  }

  /**
   * This class to save parameters from the reading file.
   */
  public static final class Builder implements AnimationBuilder<IModel> {

    private Shape shapeBuilder;
    private ArrayList<ShapeSection> animationList;

    @Override
    public IModel build() {
      System.out.println("build");
      System.out.println(shapesBuilder.toString());
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

      shapesBuilder.add(shapeBuilder);
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

      ShapeState startState = new ShapeState(t1, new Point(x1, y1), w1, h1, new Color(r1, g1, b1));

      System.out.println("time:" + t2);
      ShapeState endState = new ShapeState(t2, new Point(x2, y2), w2, h2, new Color(r2, g2, b2));

      animationList.add(new ShapeSection(startState, endState));

      System.out.println("-----------------------------");

      return null;
    }
  }

  /**
   * Return the canvas parameters of this model.
   *
   * @return the canvas parameters of this model.
   */
  @Override
  public Canvas getCanvas() {
    return canvasBuilder;
  }


  /**
   * Return the shape list of this model.
   *
   * @return the shape list of this model.
   */
  @Override
  public ArrayList<Shape> getShapes() {
    return shapes;
  }

}
