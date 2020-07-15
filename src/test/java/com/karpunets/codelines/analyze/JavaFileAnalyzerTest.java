package com.karpunets.codelines.analyze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.karpunets.codelines.report.AnalyzeReport;
import java.io.File;
import org.junit.jupiter.api.Test;

class JavaFileAnalyzerTest {

  @Test
  void analyze_case1() {
    AnalyzeReport report =
        new JavaFileAnalyzer().analyze(new File("src/test/resources/File3Lines.java"));
    assertEquals(3, report.countCodeLines());
  }

  @Test
  void analyze_case2() {
    AnalyzeReport report =
        new JavaFileAnalyzer().analyze(new File("src/test/resources/File5Lines.java"));
    assertEquals(5, report.countCodeLines());
  }
}
