package com.karpunets.codelines.analyze;

import com.karpunets.codelines.report.AnalyzeReport;
import com.karpunets.codelines.report.FolderReport;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class FolderAnalyzer implements FileAnalyzer {
    private final FileAnalyzer decorated;

    @Override
    public AnalyzeReport analyze(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            Stream<File> streamFiles = listFiles == null ? Stream.empty() : Arrays.stream(listFiles);
            Set<AnalyzeReport> reports = streamFiles
                    .map(this::analyze)
                    .collect(Collectors.toSet());
            return new FolderReport(file, reports);
        } else {
            return decorated.analyze(file);
        }
    }
}
