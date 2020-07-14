package com.karpunets.codelines.report;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
public class FolderReport implements AnalyzeReport {
    private final File folder;
    private final List<AnalyzeReport> reports;

    @Override
    public long countCodeLines() {
        return reports.stream()
                .mapToLong(AnalyzeReport::countCodeLines)
                .sum();
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder()
                .append(folder.getName())
                .append(" : ")
                .append(countCodeLines());
        reports.forEach(report -> builder
                .append(System.lineSeparator())
                .append("\t")
                .append(report.getReport().replace(System.lineSeparator() + "\t", System.lineSeparator() + "\t\t")));
        return builder.toString();
    }
}
