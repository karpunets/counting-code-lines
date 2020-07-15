package com.karpunets.codelines.analyze;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import org.junit.jupiter.api.Test;

class FolderAnalyzerTest {

  @Test
  void analyze() {
    FileAnalyzer mock = mock(FileAnalyzer.class);
    new FolderAnalyzer(mock).analyze(new File("src/test/resources/folder"));
    verify(mock).analyze(eq(new File("src/test/resources/folder/test.txt")));
  }
}
