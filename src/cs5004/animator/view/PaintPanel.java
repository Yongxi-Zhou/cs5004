package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * ActionListener should be in controller
 */
public class PaintPanel extends JPanel implements ActionListener {

  // 放到controller
  Timer tm = new Timer(50, this);
  int x = 0, velX = 20;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
//    System.out.println(x);
    if (x > 400) {
      tm.removeActionListener(this);
    }
    System.out.println("paint");
    g.setColor(new Color(0.4f, 0.4f, 0.5f));
    g.fillRect(x, 30, x, 30);

    tm.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (x <0 || x > 550) {
      velX = -velX;
    }
    x = x + velX;
    repaint();
  }
}
