package com.karpunets.codelines.report;

import java.io.File;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FolderReport implements AnalyzeReport {
  private static final String SUBFOLDER_REPORT_TARGET = System.lineSeparator() + "\t";
  private static final String SUBFOLDER_REPORT_REPLACEMENT = SUBFOLDER_REPORT_TARGET + "\t";
  private final File folder;
  private final List<AnalyzeReport> reports;

  @Override
  public long countCodeLines() {
    return reports.stream().mapToLong(AnalyzeReport::countCodeLines).sum();
  }

  @Override
  public String getReport() {
    StringBuilder builder =
        new StringBuilder().append(folder.getName()).append(" : ").append(countCodeLines());
    reports.forEach(
        report ->
            builder
                .append(System.lineSeparator())
                .append("\t")
                .append(
                    report
                        .getReport()
                        .replace(SUBFOLDER_REPORT_TARGET, SUBFOLDER_REPORT_REPLACEMENT)));
    return builder.toString();
  }
}
