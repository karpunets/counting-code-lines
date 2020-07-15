package com.karpunets.codelines.report;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FolderReportTest {

  @Test
  void getFullReport() {
    List<AnalyzeReport> reports = new ArrayList<>(2);

    List<AnalyzeReport> subfolder1Reports = new ArrayList<>(2);
    subfolder1Reports.add(new FileReport(new File("Class1.java"), 65));
    subfolder1Reports.add(new FileReport(new File("Class2.java"), 75));
    reports.add(new FolderReport(new File("subfolder1"), subfolder1Reports));

    List<AnalyzeReport> subfolder2Reports = new ArrayList<>(2);
    subfolder2Reports.add(new FileReport(new File("Class3.java"), 102));
    subfolder2Reports.add(new FileReport(new File("Class4.java"), 59));
    reports.add(new FolderReport(new File("subfolder2"), subfolder2Reports));

    FolderReport root = new FolderReport(new File("root"), reports);

    String expect =
        "root : 301\n"
            + "\tsubfolder1 : 140\n"
            + "\t\tClass1.java : 65\n"
            + "\t\tClass2.java : 75\n"
            + "\tsubfolder2 : 161\n"
            + "\t\tClass3.java : 102\n"
            + "\t\tClass4.java : 59";
    assertEquals(expect, root.getReport());
  }
}
