package twopointer.stringreversal;

/**
 Problem: Given an input string s, reverse the order of the words without using
  extra space for a new string (beyond the char array). Multiple spaces between
  words should be reduced to a single space, and leading/trailing spaces removed.

 Example:
    Input:  "the sky is blue"
    Output: "blue is sky the"

 Logic:
    1. Convert the string to a char array.
    2. Reverse the entire char array — words are now in correct order but each word is reversed.
    3. Reverse each individual word to restore its original character order.
    4. Clean up extra spaces: collapse multiple spaces into one and remove leading/trailing spaces.

 Time Complexity:  O(n) — each step (full reverse, word reverse, clean) is a linear pass.
 Space Complexity: O(n) — for the char array; no additional data structures used.
 */
public class ReverseStringWithoutExtraSpace {

    public static String reverseWords(String s) {
       int len = s.length();
        int i = 0, j = len - 1;
        char[] arr = s.toCharArray();

        // Step 1: Reverse the entire string
        reverse(arr, i, j);

        // Step 2: Reverse each individual word back to correct order
        reverseIndividualWords(arr);

        // Step 3: Remove extra spaces between words
        return cleanSpaces(arr);
    }

    private static String cleanSpaces(char[] arr) {
        // Two pointers: start (write) and end (read)
        int start = 0, end = 0;
        while(end < arr.length) {

            // Skip leading/extra spaces
            while(end < arr.length && arr[end] == ' ') end++;

            // Copy non-space characters
            while(end < arr.length && arr[end] != ' ') {
                arr[start] = arr[end];
                start++; end++;
            }

            // Skip trailing spaces after a word
            while(end < arr.length && arr[end] == ' ') end++;

            // Add a single space between words (only if more words follow)
            if(end < arr.length) {
                arr[start] = ' ';
                start++;
            }
        }
        return new String(arr, 0, start);
    }

    private static void reverseIndividualWords(char[] arr) {
        int start = 0;
        while(start < arr.length) {

            // Skip spaces to find the start of the next word
            while(start < arr.length && arr[start] == ' ') start++;

            // Find the end of the current word
            int end = start;
            while(end < arr.length && arr[end] != ' ') end++;

            // Reverse the current word in place
            reverse(arr, start,  end - 1);

            // Move to the next word
            start = end;
        }

    }

    public static void reverse( char[] arr, int left, int right) {
        // Standard two-pointer swap
        while(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

    public static String reverseWordsClean(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        char[] arr = s.toCharArray();
        reverse(arr, i, j);
        reverseIndividualWords(arr);
        return cleanSpaces(arr);
    }

    public static void main(String[] args) {
        String str = "the sky is blue";

        // String str = "  hello   world  ";
        //String str = "a good   example"; // elpmaxe   doog a
        str = str.trim();

        System.out.println(reverseWords(str));
    }
}
