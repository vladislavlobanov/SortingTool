package sorting;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortingWords {

    Scanner scanner;
    String sortingType;
    FileWriter fileWriter;

    private void HandleSortingWords() {
        int counter = 0;

        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            list.add(word);
            counter++;
        }


        System.out.println("Total words: " + counter + ".");

        Collections.sort(list);

        if (sortingType.equals("natural")) {

            System.out.print("Sorted data: ");
            for (String word : list) {
                System.out.print(word);
            }
        }
        else {

            Map<String, Integer> map = new HashMap<>();

            for (String num : list) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
                else {
                    map.put(num, 1);
                }
            }

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
            sortedList.sort((entry1, entry2) -> {
                int countComparison = entry1.getValue().compareTo(entry2.getValue());

                if (countComparison == 0) {
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                return countComparison;
            });

            for (Map.Entry<String, Integer> item : sortedList) {
                String num = item.getKey();
                Integer occurences = item.getValue();

                System.out.printf("%s: %s time(s), %s%%\n",
                        num,
                        occurences,
                        Math.round(((float) occurences / counter) * 100)
                );
            }
        }
    }

    public SortingWords(Scanner scanner, FileWriter fileWriter, String sortingType) {
        this.scanner = scanner;
        this.sortingType = sortingType;
        this.fileWriter = fileWriter;

        HandleSortingWords();
    }
}
