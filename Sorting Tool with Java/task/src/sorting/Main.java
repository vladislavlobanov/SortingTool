package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws IOException {

        String sortingType = "natural";
        String dataType = null;
        File inputFile = null;
        FileWriter fileWriter = null;


        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-dataType":
                    if (i + 1 < args.length) {
                        String nextArg = args[++i];
                        if (nextArg.equals("long") || nextArg.equals("word") || nextArg.equals("line")) {
                            dataType = nextArg;
                        }
                    }
                    break;

                case "-sortingType":
                    if (i + 1 < args.length) {
                        String nextArg = args[++i];
                        if (nextArg.equals("byCount") || nextArg.equals("natural")) {
                            sortingType = nextArg;
                        }
                        else {
                            sortingType = null;
                        }
                    }
                    break;

                case "-inputFile":
                    if (i + 1 < args.length) {
                        String nextArg = args[++i];
                        inputFile = new File(nextArg);
                    }
                    break;

                case "-outputFile":
                    if (i + 1 < args.length) {
                        String nextArg = args[++i];

                        File outputFile = new File(nextArg);
                        fileWriter = new FileWriter(outputFile);
                    }
                    break;

                default:
                    System.out.println(args[i] + " is not a valid parameter. It will be skipped.");
                    break;
            }
        }

        if (sortingType == null) {
            System.out.println("No sorting type defined!");
        }

        if (dataType == null) {
            System.out.println("No data type defined!");
        }


        if (sortingType != null && dataType != null) {
            Scanner scanner;

            if (inputFile != null) {
                scanner = new Scanner(inputFile);
            }
            else {
                scanner = new Scanner(System.in);
            }

            switch (dataType) {
                case "long":
                    new SortingNumbers(scanner, fileWriter, sortingType);
                    break;
                case "word":
                    new SortingWords(scanner, fileWriter, sortingType);
                    break;
                case "line":
                    new SortingLines(scanner, fileWriter, sortingType);
                    break;
            }

            if (fileWriter != null) {
                fileWriter.close();
            }

            scanner.close();
        }
    }
}
