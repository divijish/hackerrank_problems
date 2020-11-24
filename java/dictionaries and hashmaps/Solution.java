import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, Integer> geoMap = new HashMap<>();

        arr.forEach(item -> {
            Integer value = geoMap.get(item);
            if (value != null) {
                geoMap.put(item, ++value);
            } else {
                geoMap.put(item, 1);
            }
        });

        long counter = 0;

        for (Map.Entry<Long, Integer> entry : geoMap.entrySet()) {
            long item = entry.getKey();
            Integer totalIndices = entry.getValue();

            long secondItem = r * item;
            long thirdItem = r * r * item;
            Integer secondItemTotalIndices = geoMap.get(secondItem);
            Integer thirdItemTotalIndices = geoMap.get(thirdItem);
            if (secondItemTotalIndices == null || thirdItemTotalIndices == null) {
                continue;
            }
            /*
             * System.out.println(String.
             * format("first value = %d second value = %d third value = %d ", item,
             * secondItemTotalIndices, thirdItemTotalIndices));
             */
            counter += totalIndices * secondItemTotalIndices * thirdItemTotalIndices;

        }

        return counter;

    }

    public static void main(String[] args) throws IOException {

        Path path = FileSystems.getDefault().getPath("input06.txt");
        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));// new

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
