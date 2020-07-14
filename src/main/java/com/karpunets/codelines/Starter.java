package com.karpunets.codelines;

import com.karpunets.codelines.analyze.FolderAnalyzer;
import com.karpunets.codelines.analyze.JavaFileAnalyzer;

public class Starter {

    public static void main(String[] args) {
        JavaFileAnalyzer javaFileAnalyzer = new JavaFileAnalyzer();
        FolderAnalyzer folderAnalyzer = new FolderAnalyzer(javaFileAnalyzer);
        new Application(folderAnalyzer).run(args);
    }
}
