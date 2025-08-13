import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TopK {
    private static final Pattern space = Pattern.compile("\s+");

    public static Map<String, Long> getTopKWords(String sentence, int k) {
        var words = space.split(sentence);
        var frequencyMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static void main(String[] args) {
        var paragraph = "apple banana apple pomegranate orange orange pomegranate  apple orange";
        var results = getTopKWords(paragraph, 2);
        System.out.println(results);
    }
}
