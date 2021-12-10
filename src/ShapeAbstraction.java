public abstract class ShapeAbstraction {
  protected String name;
  protected ShapeType type;
  protected Point minCorner;
  protected Color color;
  protected int appearTime;
  protected int endTime;

  public ShapeAbstraction(String name, Point minCorner, Color color, int appearTime, int endTime) {
    this.type = ShapeType.OVAL;
    this.name = name;
    this.minCorner = minCorner;
    this.color = color;
    this.appearTime = appearTime;
    this.endTime = endTime;
  }
}
