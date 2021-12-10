/**
 * This interface contains all operations that all types of shapes should support.
 */
public interface Shape {

  Shape move(Point startPoint, Point endPoint, int startTime, int endTime);

  Shape changeColor(Color startColor, Color endColor, int startTime, int endTime);

  Shape scale(double xArm, double yArm, int startTime, int endTime);

}
