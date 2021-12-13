package cs5004.animator.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class View extends JFrame implements IView {

  private JButton pauseButton, exitButton;
  private JPanel panel;

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

    panel = new PaintPanel();
    this.add(panel);



    setSize(500, 300);
//    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }

  @Override
  public void setActionListener(ActionListener actionListener) {

  }

  @Override
  public int getStartShapeTime() {
    return 0;
  }

  @Override
  public int getStartShapeX() {
    return 0;
  }

  @Override
  public int getStartShapeY() {
    return 0;
  }

  @Override
  public int getStartShapeWidth() {
    return 0;
  }

  @Override
  public int getStartShapeHeight() {
    return 0;
  }

  @Override
  public Color getStartShapeColor() {
    return null;
  }

  @Override
  public int getEndShapeTime() {
    return 0;
  }

  @Override
  public int getEndShapeX() {
    return 0;
  }

  @Override
  public int getEndShapeY() {
    return 0;
  }

  @Override
  public int getEndShapeWidth() {
    return 0;
  }

  @Override
  public int getEndShapeHeight() {
    return 0;
  }

  @Override
  public Color getEndShapeColor() {
    return null;
  }
}
