public class Rectangle extends ShapeAbstraction implements Shape {

  private double width;
  private double height;

  public Rectangle(String name, Point minCorner, Color color, int appearTime, int endTime,
      double width, double height) {
    super(name, minCorner, color, appearTime, endTime);
    this.width = width;
    this.height = height;
  }


  @Override
  public Shape move(Point startPoint, Point endPoint, int startTime, int endTime) {
    return new Rectangle(this.name, endPoint, this.color, startTime, endTime, this.width,
        this.height);

  }

  @Override
  public Shape changeColor(Color startColor, Color endColor, int startTime, int endTime) {
    return new Rectangle(this.name, this.minCorner, endColor, startTime, endTime, this.width,
        this.height);
  }

  @Override
  public Shape scale(double xArm, double yArm, int startTime, int endTime) {
    return new Rectangle(this.name, this.minCorner, this.color, startTime, endTime, xArm,
        yArm);
  }

  @Override
  public String toString() {
    String name = "Name:" + this.name + "\n";
    String type = "Type:" + this.type + "\n";
    String MinCorner =
        "Min corner:(" + this.minCorner.getX() + "," + this.minCorner.getY() + "), Width:"
            + this.width + ", Height:" + this.height + ", Color: (" + this.color.getRed() +
            "," + this.color.getGreen() + "," + this.color.getBlue() + ") \n";
    String appear = "Appears at t=" + this.appearTime + "\n";
    String end = "Disappears at t=" + this.endTime + "\n";
    return name + type + MinCorner + appear + end;
  }
}
