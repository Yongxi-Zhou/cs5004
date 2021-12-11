package cs5004.animator;

import cs5004.animator.model.Model;
import cs5004.animator.model.Model.Builder;
import cs5004.animator.util.AnimationReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EasyAnimator {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("src/cs5004/animator/smalldemo.txt");
    AnimationReader.parseFile(new FileReader(file), new Builder());
  }
}
