package cs5004.animator.model;

public class ShapeSection {
 ShapeState start;
 ShapeState end;
 public ShapeSection(ShapeState start, ShapeState end) {
   this.start = start;
   this.end = end;
 }

  public ShapeState getStart() {
    return start;
  }

  public ShapeState getEnd() {
    return end;
  }
}
