package com.karpunets.codelines.report;

import java.io.File;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileReport implements AnalyzeReport {
  private final File file;
  private final long codeLines;

  @Override
  public long countCodeLines() {
    return codeLines;
  }

  @Override
  public String getReport() {
    return file.getName() + " : " + countCodeLines();
  }
}
