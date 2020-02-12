package main;

import java.io.IOException;

public class PatternFinderService {

    public static void findAndWriteToFile(String patternLog, String pathToLog, String nameResultFile) throws IOException {

        PatternFinder patternFinder = new PatternFinder(patternLog, pathToLog, nameResultFile);
        patternFinder.findStringByPattern();

    }

    public static void replaceAndWriteToFile(String pattern, String pathToFile,
                                             String nameResultFile, String replaceFor) throws IOException {

        PatternFinder patternFinder = new PatternFinder(pattern, pathToFile, nameResultFile, replaceFor);
        patternFinder.replace();
    }
}
