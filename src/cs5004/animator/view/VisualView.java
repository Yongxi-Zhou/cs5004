package cs5004.animator.view;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.Point;
import cs5004.animator.model.ShapeType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VisualView extends JFrame implements IView, IVisualView {

  private JPanel menu;
  private JButton startButton, pauseButton, exitButton;
  private PaintPanel paintPanel;
  private JScrollPane scrollPane;

  public VisualView(String caption) {
    super(caption);
    // menu
    menu = new JPanel();

    //    startButton
    startButton = new JButton("Start");
    startButton.setActionCommand("Start Button");
    menu.add(startButton);

//    pauseButton
    pauseButton = new JButton("Pause");
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


  @Override
  public void run(int startTime, Point startPoint, int startWidth, int startHeight,
      Color startColor, int endTime, Point endPoint, int endWidth, int endHeight, Color endColor,
      ActionListener timer) {
    paintPanel.runAnimation(startTime, startPoint, startWidth, startHeight, startColor, endTime,
        endPoint,
        endWidth, endHeight, endColor, timer);
  }


  @Override
  public void init(Point point, int width, int height, Color color, ShapeType type) {
    paintPanel.paintInit(point, width, height, color, type);
  }

  @Override
  public boolean isFinish(Point endPoint, int endWidth, int endHeight, Color endColor) {
    return paintPanel.isFinish(endPoint, endWidth, endHeight, endColor);
  }

  @Override
  public void setListeners(ActionListener click) {
    this.startButton.addActionListener(click);
    this.pauseButton.addActionListener(click);
    this.exitButton.addActionListener(click);
  }


  @Override
  public void setCanvas(int locationX, int locationY, int canvasWidth, int canvasHeight) {
    setSize(canvasWidth, canvasHeight);
    setLocation(locationX, locationY);
  }
}
