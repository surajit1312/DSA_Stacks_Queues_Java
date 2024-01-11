package medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * CodingNinjas: Next Greater Element
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/next-greater-element_670312
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P1_Next_Greater_Element_In_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 4, 2 };
        int n = 5;
        int[] nextElements = nextGreaterElement(arr, n);
        System.out
                .println("Next greater elements of Array " + Arrays.toString(arr) + " is : "
                        + Arrays.toString(nextElements));
    }

    private static int[] nextGreaterElement(int[] arr, int n) {
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(arr[i]);
        }
        return nge;
    }
}
