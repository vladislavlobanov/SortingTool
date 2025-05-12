package sorting;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SortingNumbers {

    Scanner scanner;
    String sortingType;
    FileWriter fileWriter;

    private void HandleSortingNumbers() {
        int counter = 0;

        ArrayList<Long> list = new ArrayList<>();

        while (scanner.hasNextLong()) {
            Long number = scanner.nextLong();
            list.add(number);
            counter++;
        }

        Collections.sort(list);

        System.out.println("Total numbers: " + counter + ".");

        if (sortingType.equals("natural")) {
            System.out.print("Sorted data: ");
            for (Long num : list) {
                System.out.print(num + " ");
            }
        }
        else {

            Map<Long, Integer> map = new HashMap<>();

            for (Long num : list) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
                else {
                    map.put(num, 1);
                }
            }

            List<Map.Entry<Long, Integer>> sortedList = new ArrayList<>(map.entrySet());
            sortedList.sort(Map.Entry.comparingByValue());


            for (Map.Entry<Long, Integer> item : sortedList) {
                Long num = item.getKey();
                Integer occurences = item.getValue();

                System.out.printf("%s: %s time(s), %s%%\n",
                        num,
                        occurences,
                        Math.round(((float) occurences / counter) * 100)
                );
            }
        }
    }

    public SortingNumbers(Scanner scanner, FileWriter fileWriter, String sortingType) {
        this.scanner = scanner;
        this.sortingType = sortingType;
        this.fileWriter = fileWriter;

        HandleSortingNumbers();
    }
}
