package com.karpunets.codelines.analyze;

import com.karpunets.codelines.report.AnalyzeReport;

import java.io.File;

public interface FileAnalyzer {

    AnalyzeReport analyze(File file);
}
