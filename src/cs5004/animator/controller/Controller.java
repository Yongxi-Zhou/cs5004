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
//    for (Shape shape : shapes) {
//      ShapeType type = shape.getType();
//      ArrayList<ShapeSection> animationList = shape.getAnimationList();
//      for (ShapeSection section : animationList) {
//        ShapeState start = section.getStart();
//        ShapeState end = section.getEnd();
//
//        int startTime = start.getTick();
//        int endTime = end.getTick();
//
//        view.setTimer((endTime - startTime) ,this);
//
//      }
//    }
    view.setTimer(5, this);
    view.init(new Point(20, 20), 50, 50, Color.BLUE, ShapeType.RECTANGLE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

//    ArrayList<Shape> shapes = model.getShapes();
//    for (Shape shape : shapes) {
//      ShapeType type = shape.getType();
//      ArrayList<ShapeSection> animationList = shape.getAnimationList();
//      for (ShapeSection section : animationList) {
//        ShapeState start = section.getStart();
//        ShapeState end = section.getEnd();
//
//        int startTime = start.getTick();
//        int endTime = end.getTick();
//
//        Point startPoint = start.getMinCorner();
//        Point endPoint = end.getMinCorner();
//
//        Color startColor = start.getColor();
//        Color endColor = end.getColor();
//
//        int startWidth = start.getWidth();
//        int endWidth = end.getWidth();
//
//        int startHeight = start.getHeight();
//        int endHeight = end.getHeight();
//
//        view.run(startTime, startPoint, startWidth, startHeight, startColor, endTime, endPoint,
//            endWidth, endHeight, endColor, this);
//      }
//    }

    view.run(0, new Point(20, 20), 50, 50, Color.BLUE, 5, new Point(200, 200),
        200, 200, Color.RED, this);


  }
}
