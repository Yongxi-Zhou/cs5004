public class Oval extends ShapeAbstraction implements Shape {

  private double radiusX;
  private double radiusY;

  public Oval(String name, Point minCorner, Color color, int appearTime, int endTime,
      double radiusX, double radiusY) {
    super(name, minCorner, color, appearTime, endTime);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }


  @Override
  public Shape move(Point startPoint, Point endPoint, int startTime, int endTime) {
    return new Oval(name, endPoint, this.color, startTime, endTime, this.radiusX, this.radiusY);
  }

  @Override
  public Shape changeColor(Color startColor, Color endColor, int startTime, int endTime) {
    return new Oval(name, this.minCorner, endColor, startTime, endTime, this.radiusX, this.radiusY);
  }

  @Override
  public Shape scale(double xArm, double yArm, int startTime, int endTime) {
    return new Oval(name, minCorner, this.color, startTime, endTime, xArm, yArm);
  }

  @Override
  public String toString() {
    String name = "Name:" + this.name + "\n";
    String type = "Type:" + this.type + "\n";
    String MinCorner =
        "Min corner:(" + this.minCorner.getX() + "," + this.minCorner.getY() + "), X radius:"
            + this.radiusX + ", Y radius:" + this.radiusY + ", Color: (" + this.color.getRed() +
    "," + this.color.getGreen() + "," + this.color.getBlue() + ") \n";
    String appear = "Appears at t=" + this.appearTime + "\n";
    String end = "Disappears at t=" + this.endTime + "\n";
    return name + type + MinCorner + appear + end;
  }
}
