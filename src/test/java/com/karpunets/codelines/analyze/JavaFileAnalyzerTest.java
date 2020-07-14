package com.karpunets.codelines.analyze;

import com.karpunets.codelines.report.AnalyzeReport;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JavaFileAnalyzerTest {

    @Test
    void analyze_case1() {
        AnalyzeReport report = new JavaFileAnalyzer().analyze(new File("src/test/resources/File3Lines.java"));
        assertEquals(3, report.countCodeLines());
    }

    @Test
    void analyze_case2() {
        AnalyzeReport report = new JavaFileAnalyzer().analyze(new File("src/test/resources/File5Lines.java"));
        assertEquals(5, report.countCodeLines());
    }
}