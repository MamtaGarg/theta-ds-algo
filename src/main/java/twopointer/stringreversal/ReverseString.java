package twopointer.stringreversal;

import java.util.Arrays;

/**
 Problem: Write a function that reverses a character array in-place.
  Do not allocate extra space — modify the input array with O(1) extra memory.

 Example:
    Input:  ['h', 'e', 'l', 'l', 'o']
    Output: ['o', 'l', 'l', 'e', 'h']

 Logic:
    1. Place two pointers at the start (i) and end (j) of the array.
    2. Swap the characters at i and j.
    3. Move both pointers inward and repeat until they meet.

 Time Complexity:  O(n) — half the array is traversed with swaps.
 Space Complexity: O(1) — in-place swaps only.
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        // Two pointers at opposite ends
        int i = 0, j = s.length - 1;

        while(i < j) {
            // Swap characters at i and j
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            // Move pointers inward
            i++;
            j--;
        }
    }

    public static void reverseStringClean(char[] s) {
        int i = 0, j = s.length - 1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
