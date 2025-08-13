public class PalindromeFinder {

    public static boolean isPalindrome(String input) {
        var chars = input.toCharArray();
        for (int left = 0, right = chars.length - 1; left != right; left++, right--) {
            if (chars[left] != chars[right]) {
                System.out.println("The input string is NOT a palindrome");
                return false;
            }
        }
        System.out.println("The input string [ " + input + " ] is a palindrome");
        return true;
    }

    public static void main(String[] args) {
        var inputData = "viknesh";
        var startTime = System.currentTimeMillis();
        isPalindrome(inputData);
        System.out.println("Time taken to find the result: " + (System.currentTimeMillis() - startTime));
    }
}
