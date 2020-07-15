package com.karpunets.codelines;

import com.karpunets.codelines.analyze.FolderAnalyzer;
import com.karpunets.codelines.analyze.JavaFileAnalyzer;
import org.junit.jupiter.api.Test;

class ApplicationTest {

  @Test
  void whenAnalyzeAllSource_expectOk() {
    new Application(new FolderAnalyzer(new JavaFileAnalyzer()))
        .run(new String[] {"-f", "src/main/java/com/karpunets/codelines"});
  }

  @Test
  void whenNotFilenameProvided_expectHelp() {
    new Application(new JavaFileAnalyzer()).run(new String[] {});
  }
}
