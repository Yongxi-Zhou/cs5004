package cs5004.animator.view;

import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class represents VisualView.
 */
public class VisualView extends JFrame implements IView, IVisualView {

  private JPanel menu;
  private JButton startButton, pauseButton, exitButton;
  private PaintPanel paintPanel;
  private JScrollPane scrollPane;

  /**
   * Construct a VisualView object.
   *
   * @param caption the caption title of this VisualView object.
   */
  public VisualView(String caption) {
    super(caption);
    // menu
    menu = new JPanel();

    //    startButton
    startButton = new JButton("5 times faster");
    startButton.setActionCommand("Start Button");
    menu.add(startButton);

//    pauseButton
    pauseButton = new JButton("10 times faster");
    pauseButton.setActionCommand("Pause Button");
    menu.add(pauseButton);

//    exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    menu.add(exitButton);

    this.add(menu, BorderLayout.NORTH);

    paintPanel = new PaintPanel();
    paintPanel.setPreferredSize(new Dimension(800, 910));
    scrollPane = new JScrollPane(paintPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }


  /**
   * Run the animation of the shape in this view.
   *
   * @param startTime   the appearance time of this shape in this view
   * @param startPoint  the startPoint of this shape in this view
   * @param startWidth  the startWidth of this shape in this view
   * @param startHeight the startHeight of this shape in this view
   * @param startColor  the startColor of this shape in this view
   * @param endTime     the endTime of this shape in this view
   * @param endPoint    the endPoint of this shape in this view
   * @param endWidth    the endWidth of this shape in this view
   * @param endHeight   the endHeight of this shape in this view
   * @param endColor    the endColor of this shape in this view
   * @param name        the name of this shape in this view
   */
  @Override
  public void run(int startTime, Point startPoint, int startWidth, int startHeight,
      Color startColor, int endTime, Point endPoint, int endWidth, int endHeight, Color endColor,
      String name) {
    paintPanel.runAnimation(startTime, startPoint, startWidth, startHeight, startColor, endTime,
        endPoint,
        endWidth, endHeight, endColor);
  }


  /**
   * Create shape on this view.
   *
   * @param startColor  the color of the shape to be created.
   * @param type        the type of the shape to be created.
   * @param name        the name of the shape to be created.
   * @param startCorner the corner of the shape to be created.
   * @param startWidth  the width of the shape to be created.
   * @param startHeight the height of the shape to be created.
   */
  @Override
  public void create(Color startColor, ShapeType type, String name, Point startCorner,
      int startWidth, int startHeight) {
    paintPanel.paintInit(startCorner, startWidth, startHeight, startColor, type);
  }


  /**
   * Return true if the animation is finished.
   *
   * @param endPoint  the end position of this shape in this view.
   * @param endWidth  the end width of this shape in this view.
   * @param endHeight the end height of this shape in this view.
   * @param endColor  the end color of this shape in this view.
   * @return true if the animation is finished.
   */
  @Override
  public boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor) {
    return paintPanel.isFinish(endPoint, endWidth, endHeight, endColor);
  }

  /**
   * Set listener for this view.
   *
   * @param click the actionListener to be bounded for this view.
   */
  @Override
  public void setListeners(ActionListener click) {
    this.startButton.addActionListener(click);
    this.pauseButton.addActionListener(click);
    this.exitButton.addActionListener(click);
  }

  /**
   * Set the canvas location and size.
   *
   * @param locationX    locationX of this view's canvas
   * @param locationY    locationY of this view's canvas
   * @param canvasWidth  canvasWidth of this view's canvas
   * @param canvasHeight canvasHeight of this view's canvas
   */
  @Override
  public void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight) {
    setSize(canvasWidth, canvasHeight);
    setLocation(locationX, locationY);
  }
}
