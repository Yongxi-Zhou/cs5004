package cs5004.animator.controller;

import cs5004.animator.model.Canvas;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Point;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeSection;
import cs5004.animator.model.ShapeState;
import cs5004.animator.model.ShapeType;
import cs5004.animator.view.PaintPanel;
import cs5004.animator.view.TextView;
import cs5004.animator.view.VisualView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * This class represents controller.
 */
public class Controller implements ActionListener {

  private IModel model;
  private VisualView view;
  private TextView txtView;

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
  private String name;
  private ActionListener taskPerformer;

  private Timer tm;
  private int duration;

  /**
   * Constructs a controller with given model and views.
   *
   * @param m       the model given to construct the controller
   * @param v       the visual view given to construct the controller
   * @param txtView the text view given to construct the controller
   */
  public Controller(IModel m, VisualView v, TextView txtView) {
    this.model = m;
    this.view = v;
    this.txtView = txtView;
    // set listeners
    view.setListeners(this);
    // set canvas
    Canvas canvas = model.getCanvas();
    int locationX = canvas.getX();
    int locationY = canvas.getY();
    int canvasWidth = canvas.getWidth();
    int canvasHeight = canvas.getHeight();
    view.setCanvas(locationX, locationY, canvasWidth, canvasHeight);

    this.runAnimation();
  }

  /**
   * Control the model and view to appear.
   */
  private void appear() {
    ArrayList<Shape> shapes = model.getShapes();
    for (Shape shape : shapes) {
      String name = shape.getName();
      ArrayList<ShapeSection> animationList = shape.getAnimationList();
      int len = animationList.size();
      ShapeState start = animationList.get(0).getStart();
      ShapeState end = animationList.get(len - 1).getEnd();
      int startTime = start.getTick();
      int endTime = end.getTick();
      txtView.appear(name, startTime, endTime);
    }
  }


  /**
   * Control the model and view to create animation.
   */
  private void create() {
    ArrayList<Shape> shapes = model.getShapes();
    for (Shape shape : shapes) {
      String name = shape.getName();
      ShapeType type = shape.getType();
      ArrayList<ShapeSection> animationList = shape.getAnimationList();
      ShapeState start = animationList.get(0).getStart();
      Color startColor = start.getColor();
      Point startCorner = start.getMinCorner();
      int startWidth = start.getWidth();
      int startHeight = start.getHeight();

      txtView.create(startColor, type, name, startCorner, startWidth, startHeight);
    }
  }


  /**
   * Control the model and view to runAnimation.
   */
  private void runAnimation() {
    ArrayList<Shape> shapes = model.getShapes();
    for (Shape shape : shapes) {
      name = shape.getName();
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

        duration = (endTime - startTime) * 100;

        taskPerformer = evt -> {
          view.run(startTime, startPoint, startWidth, startHeight, startColor, endTime, endPoint,
              endWidth, endHeight, endColor, name);
          txtView.run(startTime, startPoint, startWidth, startHeight, startColor, endTime, endPoint,
              endWidth, endHeight, endColor, name);
        };
        tm = new Timer(duration / PaintPanel.RENDERTIMES, taskPerformer);
        tm.start();

        this.create();
        this.appear();
        view.create(startColor, type, name, new Point(startPoint.getX(), startPoint.getY()),
            startWidth, startHeight);

        if (view.isFinish(endPoint, endWidth, endHeight, endColor)) {
          tm.stop();
          tm.removeActionListener(taskPerformer);
          System.out.println("finish!!!!");
        }
        try {
          Thread.sleep(duration);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()) {
      case "Start Button":
        System.out.println("start!!");
        duration /= 20;
        break;
      case "Pause Button":
        duration /= 10;
        break;
      case "Exit Button":
        System.exit(0);
        break;
    }

  }
}
