package com.karpunets.codelines.analyze;

import com.karpunets.codelines.report.AnalyzeReport;
import com.karpunets.codelines.report.FolderReport;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FolderAnalyzer implements FileAnalyzer {
  private final FileAnalyzer decorated;

  @Override
  public AnalyzeReport analyze(File file) {
    if (file.isDirectory()) {
      File[] listFiles = file.listFiles();
      Stream<File> streamFiles = listFiles == null ? Stream.empty() : Arrays.stream(listFiles);
      List<AnalyzeReport> reports = streamFiles.map(this::analyze).collect(Collectors.toList());
      return new FolderReport(file, reports);
    } else {
      return decorated.analyze(file);
    }
  }
}
