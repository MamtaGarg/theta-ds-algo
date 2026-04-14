package twopointer.stringreversal;

/**
 Problem: Given an input string s, reverse the order of the words.
  Words are separated by spaces. Extra leading/trailing spaces should be removed
  and multiple spaces between words reduced to a single space.
  Uses split + two-pointer swap (O(n) extra space from split).

 Example:
    Input:  "a good   example"
    Output: "example good a"

 Logic:
    1. Trim the input and split by one or more whitespace characters.
    2. Use two pointers (i at start, j at end) to swap words in the resulting array.
    3. Join the reversed word array with a single space.

 Time Complexity:  O(n) — split, swap, and join each take linear time.
 Space Complexity: O(n) — for the split word array and the joined result string.
 */
public class ReverseWordsWithExtraSpace {

    public static String reverseWords(String s) {
        // Split by one or more whitespace characters
        String[] str = s.split("\\s+");

        // Two pointers to swap words from ends toward center
        int i = 0, j = str.length - 1;
        while(i < j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        // Join reversed words with a single space
        return String.join(" ", str);
    }

    public static String reverseWordsClean(String s) {
        String[] str = s.split("\\s+");
        int i = 0, j = str.length - 1;
        while(i < j) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", str);
    }

    public static void main(String[] args) {
        //String str = "the sky is blue";

        // String str = "  hello world  ";
        String str = "a good   example";
        str = str.trim();

        System.out.println(reverseWords(str));
    }
}
