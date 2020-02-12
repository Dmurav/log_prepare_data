package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        /* for DEBUG
        String re = ".*WARN.*";
        String inFile = "/home/dima/Documents/JAVA_PRACTICA/JAVA_files/main.log.2014-11-17";
        String outFile = "result.log";
        */

        /*
        String pattern = "/S";
        String inFile = "/home/dima/Documents/JAVA_PRACTICA/JAVA_files/main.log.2014-11-17";
        String outFile = "result.log";
        String replaceFor = ";";
        */

        Scanner in = new Scanner(System.in);
        String action = null;

        while (true){
            System.out.println("Please enter need action: 1 - find and write to file, 2 - find and replace, 3 - EXIT");
            action = in.next();
            if (action.equals("3")){
                System.exit(0);
                break;
            }
            if (action.equals("1") || action.equals("2")){
                break;
            }
        }

        switch (action) {

            case "1":
                while (true){
                    System.out.println("Please enter regular expression: example - .*WARN.*");
                    String re = in.next();
                    System.out.println("Please enter absolut path to log: example - /home/....");
                    String inFile = in.next();
                    System.out.println("Please enter name result log: example - result.log");
                    String outFile = in.next();
                    if (!(inFile.equals(null) && re.equals(null) && outFile.equals(null))){
                        PatternFinderService.findAndWriteToFile(re, inFile, outFile);
                        break;
                    }
                }
                break;
            case "2":
                while (true){
                    System.out.println("Please enter pattern: example - /S ");
                    String pattern = in.next();
                    System.out.println("Please enter absolut path to log: example - /home/....");
                    String inFile = in.next();
                    System.out.println("Please enter name result log: example - result.log");
                    String outFile = in.next();
                    System.out.println("Please enter replace for: example - ;");
                    String replaceFor = in.next();
                    if (!(inFile.equals(null) && pattern.equals(null) && outFile.equals(null) && replaceFor.equals(null))){
                        PatternFinderService.replaceAndWriteToFile(pattern, inFile, outFile, replaceFor);
                        break;
                    }
                }
            default:
                break;
        }
    }
}