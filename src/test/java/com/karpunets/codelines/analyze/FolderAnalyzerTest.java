package com.karpunets.codelines.analyze;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.mockito.Mockito.*;

class FolderAnalyzerTest {

    @Test
    void analyze() {
        FileAnalyzer mock = mock(FileAnalyzer.class);
        new FolderAnalyzer(mock).analyze(new File("src/test/resources/folder"));
        verify(mock).analyze(eq(new File("src/test/resources/folder/test.txt")));
    }
}