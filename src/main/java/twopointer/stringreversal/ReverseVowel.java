package twopointer.stringreversal;

/**
 Problem: Given a string s, reverse only the vowels and return the modified string.
  Consonants and their positions remain unchanged.

 Example:
    Input:  "leetcode"
    Output: "leotcede"

 Logic:
    1. Convert the string to a char array for in-place modification.
    2. Place two pointers at the start (left) and end (right).
    3. Advance left until it points to a vowel; advance right until it points to a vowel.
    4. Swap the two vowels and move both pointers inward.
    5. Repeat until the pointers cross.

 Time Complexity:  O(n) — each character is visited at most once by each pointer.
 Space Complexity: O(n) — for the char array copy of the string.
 */
public class ReverseVowel {

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        // Two pointers at opposite ends
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // Move left pointer forward until it hits a vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            // Move right pointer backward until it hits a vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            // Swap the two vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move both pointers inward
            left++;
            right--;
        }

        return new String(arr);
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }

    public static String reverseVowelsClean(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !isVowel(arr[left])) left++;
            while (left < right && !isVowel(arr[right])) right--;
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }
}
