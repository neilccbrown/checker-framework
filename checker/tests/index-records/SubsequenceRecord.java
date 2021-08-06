import org.checkerframework.checker.index.qual.HasSubsequence;
import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.IndexOrHigh;

// Example copied from HasSubsequence documentation
public record SubsequenceRecord(
    @HasSubsequence(subsequence = "this", from = "this.start", to = "this.end") int[] array,
    @IndexFor("this.array") int start,
    @IndexOrHigh("this.array") int end) {
  public SubsequenceRecord {
    // HasSubsequence only applies to fields, so this should be fine because it's the parameter:
    array = new int[10];
    start = 5;
    end = 15;
    // This is also fine because it matches:
    array = new int[20];
  }
}
