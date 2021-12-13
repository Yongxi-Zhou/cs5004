package cs5004.animator.controller;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
  private IModel model;
  private IView view;
  public Controller(IModel m, IView v) {
    this.model = m;
    this.view = v;
    view.setActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
