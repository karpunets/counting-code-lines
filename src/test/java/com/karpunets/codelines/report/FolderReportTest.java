package com.karpunets.codelines.report;

import com.karpunets.codelines.analyze.FileAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FolderReportTest {

    @Test
    void getFullReport() {
        Set<AnalyzeReport> reports = new HashSet<>();

        Set<AnalyzeReport> subfolder1Reports = new HashSet<>();
        subfolder1Reports.add(new FileReport(new File("Class1.java"), 65));
        subfolder1Reports.add(new FileReport(new File("Class2.java"), 75));
        reports.add(new FolderReport(new File("subfolder1"), subfolder1Reports));

        Set<AnalyzeReport> subfolder2Reports = new HashSet<>();
        subfolder2Reports.add(new FileReport(new File("Class3.java"), 102));
        subfolder2Reports.add(new FileReport(new File("Class4.java"), 59));
        reports.add(new FolderReport(new File("subfolder2"), subfolder2Reports));

        FolderReport root = new FolderReport(new File("root"), reports);

        String expect = "root : 301\n" +
                "\tsubfolder2 : 161\n" +
                "\t\tClass4.java : 59\n" +
                "\t\tClass3.java : 102\n" +
                "\tsubfolder1 : 140\n" +
                "\t\tClass2.java : 75\n" +
                "\t\tClass1.java : 65";
        assertEquals(expect, root.getReport());
    }
}