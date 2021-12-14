package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Model;
import cs5004.animator.model.Model.Builder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.TextView;
import cs5004.animator.view.VisualView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EasyAnimator {

  public static void main(String[] args) throws FileNotFoundException {
    // read file to model
    File file = new File("src/cs5004/animator/smalldemo.txt");
//    File file = new File("src/cs5004/animator/hanoi.txt");
    AnimationReader.parseFile(new FileReader(file), new Builder());
    VisualView view = new VisualView("animation");
    TextView txtView = new TextView(System.out);
    IModel model = new Model();
    Controller controller = new Controller(model, view, txtView);
  }
}
