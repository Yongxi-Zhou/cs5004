package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Model;
import cs5004.animator.model.Model.Builder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EasyAnimator {

  public static void main(String[] args) throws FileNotFoundException {
    // read file to model
    File file = new File("src/cs5004/animator/smalldemo.txt");
    AnimationReader.parseFile(new FileReader(file), new Builder());
    IView view = new View("animation");
    IModel model = new Model();
    Controller controller = new Controller(model, view);
  }
}
