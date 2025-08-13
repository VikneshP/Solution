import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static Character findFirstNonRepeatingChar(String input) {
        var charFrequency = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        character -> character,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        return charFrequency.entrySet()
                .stream()
                .filter(characterLongEntry -> characterLongEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(' ');
    }

    public static void main(String[] args) {
        var input = "aabbcc";
        var result = findFirstNonRepeatingChar(input);
        if (result.equals(' ')) {
            System.out.println("No non-repeating char found in the given input");
        } else {
            System.out.println("The first non-repeating char is : " + result);
        }

    }
}
