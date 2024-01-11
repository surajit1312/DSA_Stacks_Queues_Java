package medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * CodingNinjas: Next Greater Element II
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/next-greater-element-ii_6212757
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P2_Next_Greater_Element_In_Circular_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 4, 2 };
        int[] nextElements = nextGreaterElementII(arr);
        System.out
                .println("Next greater elements of Circular Array " + Arrays.toString(arr) + " is : "
                        + Arrays.toString(nextElements));
    }

    public static int[] nextGreaterElementII(int[] a) {
        int n = a.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i % n] >= stack.peek()) {
                stack.pop();
            }
            nge[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(a[i % n]);
        }
        return nge;
    }
}
