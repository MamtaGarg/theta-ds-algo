package twopointer.stringreversal;

/**
 Problem: Given a string s and an integer k, reverse the first k characters for every 2k
  characters counting from the start of the string. If fewer than k characters remain,
  reverse all of them.

 Example:
    Input:  s = "abcdefgi", k = 2
    Output: "bacdfeig"

 Logic:
    1. Convert the string to a char array for in-place modification.
    2. Iterate in steps of 2k — in each chunk, only the first k characters are reversed.
    3. For each chunk, use a two-pointer swap to reverse from index i to min(i + k - 1, n - 1).
    4. Build the result string from the modified char array.

 Time Complexity:  O(n) — each character is visited at most once.
 Space Complexity: O(n) — for the char array copy of the string.
 */
public class ReverseKCharacters {

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Process every 2k-character chunk
        for (int i = 0; i < n; i += 2 * k) {
            // Reverse the first k characters of this chunk (or remaining if fewer than k)
            reverse(arr, i, Math.min(i + k - 1, n - 1));
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        // Standard two-pointer swap
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseStrClean(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k - 1, n - 1));
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "abcdefgi";
        System.out.println(reverseStr(str, 2));
    }

}
