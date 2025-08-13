public class PalindromeFinder {

    public static boolean isPalindrome(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        var left = 0;
        var right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        var inputData = "MADAM";
        var startTime = System.currentTimeMillis();
        var result = isPalindrome(inputData);
        if (result) {
            System.out.println("The given input is a palindrome");
        } else {
            System.out.println("The given input is NOT a palindrome");
        }
        System.out.println("Time taken to find the result: " + (System.currentTimeMillis() - startTime));
    }
}
