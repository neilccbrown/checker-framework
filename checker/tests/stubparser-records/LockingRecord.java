import java.util.concurrent.locks.ReentrantLock;

public record LockingRecord(ReentrantLock lock) {
  public LockingRecord {
    // :: error : (method.guarantee.violated)
    lock.lock();
  }
}
