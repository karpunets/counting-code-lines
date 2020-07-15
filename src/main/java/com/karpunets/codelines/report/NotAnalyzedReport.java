package com.karpunets.codelines.report;

import java.io.File;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotAnalyzedReport implements AnalyzeReport {
  private final File file;

  @Override
  public long countCodeLines() {
    return 0;
  }

  @Override
  public String getReport() {
    return file.getName() + " : not analyzed";
  }
}
