package org.checkerframework.checker.test.junit;

import java.io.File;
import java.util.List;
import org.checkerframework.framework.test.CheckerFrameworkPerDirectoryTest;
import org.junit.runners.Parameterized.Parameters;

/** JUnit tests for the Index Checker. */
public class IndexTest extends CheckerFrameworkPerDirectoryTest {

  /**
   * Create an IndexTest.
   *
   * @param testFiles the files containing test code, which will be type-checked
   */
  public IndexTest(List<File> testFiles) {
    super(testFiles, org.checkerframework.checker.index.IndexChecker.class, "index", "-Anomsgtext");
  }

  @Parameters
  public static String[] getTestDirs() {
    // Check for JDK 16+ without using a library:
    if (System.getProperty("java.version").matches("^(1[6-9]|[2-9][0-9])\\..*"))
      return new String[] {"index", "index-records", "all-systems"};
    else return new String[] {"index", "all-systems"};
  }
}
