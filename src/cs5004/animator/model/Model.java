package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;

public class Model implements IModel {
  private Shape s1;
  private Shape s2;

  public static final class Builder implements AnimationBuilder<IModel> {

    @Override
    public IModel build() {
      return null;
    }

    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      return null;
    }

    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type) {
      return null;
    }

    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
        int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
      System.out.println(t1);
      return null;
    }
  }

  @Override
  public boolean isMove() {
    return false;
  }

  @Override
  public boolean isChangeColor() {
    return false;
  }

  @Override
  public boolean isScale() {
    return false;
  }
}
