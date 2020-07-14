package com.karpunets.codelines.report;

import lombok.RequiredArgsConstructor;

import java.io.File;

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
