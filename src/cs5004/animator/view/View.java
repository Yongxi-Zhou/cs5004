package cs5004.animator.view;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame implements IView {

  private JButton pauseButton, exitButton;
  private PaintPanel paintPanel;

  public View(String caption) {
    super(caption);

    //this.setResizable(false);
//		this.setMinimumSize(new Dimension(300,300));

//    this.setLayout(new FlowLayout());

    //pausebutton
//    pauseButton = new JButton("Pause");
//    pauseButton.setActionCommand("Pause Button");
//    this.add(pauseButton);

    //exit button
//    exitButton = new JButton("Exit");
//    exitButton.setActionCommand("Exit Button");
//    this.add(exitButton);

    paintPanel = new PaintPanel();
    this.add(paintPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }


  @Override
  public void setListeners(ActionListener timer) {

  }

  @Override
  public void run(int startTime, Point startPoint, int startWidth, int startHeight,
      Color startColor, int endTime, Point endPoint, int endWidth, int endHeight, Color endColor,
      ActionListener timer) {
    paintPanel.runAnimation(startTime, startPoint, startWidth, startHeight, startColor, endTime, endPoint,
        endWidth, endHeight, endColor, timer);
  }

  @Override
  public void setTimer(int duration, ActionListener timer) {
    paintPanel.setTimer(duration, timer);
  }

  @Override
  public void init(Point point, int width, int height, Color color, ShapeType type) {
    paintPanel.paintTest(point, width, height, color, type);
  }


  @Override
  public void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight) {
    setSize(canvasWidth, canvasHeight);
    setLocation(locationX, locationY);
  }

}
