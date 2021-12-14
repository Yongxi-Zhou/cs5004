package cs5004.animator.model;

/**
 * This class represents shapeState in animation, including position, color, width, height and
 * time.
 */
public class ShapeSection {

  ShapeState start;
  ShapeState end;

  /**
   * Construct a ShapeSection object.
   *
   * @param start the start state of this ShapeSection object.
   * @param end   the end state of this ShapeSection object.
   */
  public ShapeSection(ShapeState start, ShapeState end) {
    this.start = start;
    this.end = end;
  }

  /**
   * Return the start state of this ShapeSection object.
   *
   * @return the start state of this ShapeSection object.
   */
  public ShapeState getStart() {
    return start;
  }

  /**
   * Return the end state of this ShapeSection object.
   *
   * @return the end state of this ShapeSection object.
   */
  public ShapeState getEnd() {
    return end;
  }
}
