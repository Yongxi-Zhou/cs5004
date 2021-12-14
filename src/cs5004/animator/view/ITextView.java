package cs5004.animator.view;

/**
 * The interface for text view class.
 */
public interface ITextView {

  /**
   * Show the appearance and disappearence time of the textView object.
   *
   * @param appearName the shape name of this shape.
   * @param startTime  the appearance name of this shape.
   * @param endTime    the disappearence name of this shape.
   */
  void appear(String appearName, int startTime, int endTime);

}
