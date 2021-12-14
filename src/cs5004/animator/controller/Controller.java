package cs5004.animator.controller;

import cs5004.animator.model.Canvas;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Point;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeSection;
import cs5004.animator.model.ShapeState;
import cs5004.animator.model.ShapeType;
import cs5004.animator.view.IView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

  private IModel model;
  private IView view;

  private int startTime;
  private int endTime;
  private Point startPoint;
  private Point endPoint;
  private Color startColor;
  private Color endColor;
  private int startWidth;
  private int endWidth;
  private int startHeight;
  private int endHeight;
  private ShapeType type;


  public Controller(IModel m, IView v) {
    this.model = m;
    this.view = v;
    // set listeners
    view.setListeners(this);
    // set canvas
    Canvas canvas = model.getCanvas();
    int locationX = canvas.getX();
    int locationY = canvas.getY();
    int canvasWidth = canvas.getWidth();
    int canvasHeight = canvas.getHeight();
    view.setCanvas(locationX, locationY, canvasWidth, canvasHeight);
    runAnimation();
  }

  private void runAnimation() {
    ArrayList<Shape> shapes = model.getShapes();
    for (Shape shape : shapes) {
      type = shape.getType();
      ArrayList<ShapeSection> animationList = shape.getAnimationList();
      for (ShapeSection section : animationList) {
        ShapeState start = section.getStart();
        ShapeState end = section.getEnd();

        startTime = start.getTick();
        endTime = end.getTick();

        startPoint = start.getMinCorner();
        endPoint = end.getMinCorner();

        startColor = start.getColor();
        endColor = end.getColor();

        startWidth = start.getWidth();
        endWidth = end.getWidth();

        startHeight = start.getHeight();
        endHeight = end.getHeight();

        view.setTimer((endTime - startTime) * 100, this);
        view.init(new Point(startPoint.getX(), startPoint.getY()), startWidth, startHeight,
            startColor, type);
        System.out.println("endTime: " + endTime);
        System.out.println("startTime: " + startTime);
        try {
          Thread.sleep((endTime - startTime) * 100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
//    view.setTimer(5, this);
//    view.init(new Point(20, 20), 50, 50, Color.BLUE, ShapeType.OVAL);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    System.out.println(startTime);
    System.out.println(endTime);
//    System.out.println(startPoint.getX());
//    System.out.println(endPoint.getX());
//    System.out.println(startHeight);
//    System.out.println(endHeight);
    System.out.println("actionPerform!!!");
    view.run(startTime, startPoint, startWidth, startHeight, startColor, endTime, endPoint,
        endWidth, endHeight, endColor, this);

//    view.run(0, new Point(20, 20), 50, 50, Color.BLUE, 5, new Point(200, 200),
//        200, 200, Color.RED, this);

  }
}
