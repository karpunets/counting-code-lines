package com.karpunets.codelines;

import com.karpunets.codelines.analyze.FileAnalyzer;
import com.karpunets.codelines.report.AnalyzeReport;
import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.*;

import java.io.File;
import java.util.Optional;

@RequiredArgsConstructor
public class Application {
    private final HelpFormatter helpFormatter = new HelpFormatter();
    private final FileAnalyzer fileAnalyzer;

    public void run(String[] args) {
        getCountingCodeLines(args)
                .map(fileAnalyzer::analyze)
                .map(AnalyzeReport::getReport)
                .ifPresent(System.out::println);
    }

    private Optional<File> getCountingCodeLines(String[] args) {
        try {
            CommandLine commandLine = new DefaultParser().parse(CliOption.getCommonOptions(), args);
            if (commandLine.hasOption(CliOption.FILENAME.opt)) {
                String filename = commandLine.getOptionValue(CliOption.FILENAME.opt);
                return Optional.of(new File(filename));
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        helpFormatter.printHelp("java -jar code-lines.jar", CliOption.getCommonOptions(), true);
        return Optional.empty();
    }

    @RequiredArgsConstructor
    private enum CliOption {
        FILENAME("f", "filename", true, "file name to counting code lines");

        final String opt;
        final String longOpt;
        final boolean hasArg;
        final String description;

        public static Options getCommonOptions() {
            Options options = new Options();
            for (CliOption option : values()) {
                options.addOption(option.opt, option.longOpt, option.hasArg, option.description);
            }
            return options;
        }
    }
}
