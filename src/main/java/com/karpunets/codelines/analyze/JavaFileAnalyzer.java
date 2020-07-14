package com.karpunets.codelines.analyze;

import com.karpunets.codelines.report.AnalyzeReport;
import com.karpunets.codelines.report.FileReport;
import com.karpunets.codelines.report.NotAnalyzedReport;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class JavaFileAnalyzer implements FileAnalyzer {

    @Override
    public AnalyzeReport analyze(File file) {
        AtomicBoolean commentStart = new AtomicBoolean();
        try (Stream<String> lines = Files.lines(file.toPath())) {
            long count = lines
                    .map(String::trim)
                    .filter(l -> !l.isEmpty())
                    .map(StringBuilder::new)
                    .peek(line -> removeStringContent(line, 0))
                    .peek(line -> removeMultipleComment(line, commentStart))
                    .peek(JavaFileAnalyzer::removeSingleComment)
                    .map(StringBuilder::toString)
                    .map(String::trim)
                    .filter(l -> !l.isEmpty())
                    .count();
            return new FileReport(file, count);
        } catch (Exception e) {
            return new NotAnalyzedReport(file);
        }
    }

    private static void removeStringContent(StringBuilder line, int fromIndex) {
        int startIndex = line.indexOf("\"", fromIndex);
        if (startIndex == -1) {
            return;
        }
        int endIndex = line.indexOf("\"", startIndex + "\"".length());
        if (endIndex == -1) {
            return;
        }
        removeStringContent(line.delete(startIndex + 1, endIndex), endIndex);
    }

    private static void removeMultipleComment(StringBuilder line, AtomicBoolean commentStart) {
        int startIndex = 0;
        int endFromIndex = 0;
        if (!commentStart.get()) {
            startIndex = line.indexOf("/*");
            if (startIndex == -1) {
                return;
            }
            endFromIndex = startIndex + "/*".length();
        }
        int endIndex = line.indexOf("*/", endFromIndex);
        if (endIndex == -1) {
            commentStart.set(true);
            line.delete(startIndex, line.length());
            return;
        }
        commentStart.set(false);
        removeMultipleComment(line.delete(startIndex, endIndex + "*/".length()), commentStart);
    }

    private static void removeSingleComment(StringBuilder line) {
        int startIndex = line.indexOf("//");
        if (startIndex == -1) {
            return;
        }
        line.delete(startIndex, line.length());
    }
}
