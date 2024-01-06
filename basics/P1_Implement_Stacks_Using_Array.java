package basics;

/**
 * CodingNinjas: Stack Implementation Using Array
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209
 * 
 * 
 * We perform the following operations on an empty stack which has capacity 2:
 * 
 * When operation 1 1 is performed, we insert 1 in the stack.
 * 
 * When operation 1 2 is performed, we insert 2 in the stack.
 * 
 * When operation 2 is performed, we remove the top element from the stack and
 * print 2.
 * 
 * When operation 3 is performed, we print the top element of the stack, i.e.,
 * 3.
 * 
 * When operation 4 is performed, we print 0 because the stack is not empty.
 * 
 * When operation 5 is performed, we print 0 because the stack is size 1, which
 * is not equal to its capacity.
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P1_Implement_Stacks_Using_Array {
    public static void main(String[] args) {
        int capacity = 2;
        int n = 6;
        // operation - 1(insert), 2(pop), 3(top), 4(check if empty), 5(size)
        int[] operations = { 1, 1, 2, 3, 4, 5 };
        int[] values = { 1, 2 };

        Stack st = new Stack(capacity);
        int done = 0;
        while (done < n) {
            switch (operations[done]) {
                case 1:
                    st.push(values[done]);
                    break;
                case 2:
                    int removed = st.pop();
                    System.out.println(removed);
                    break;
                case 3:
                    int top = st.top();
                    System.out.println(top);
                    break;
                case 4:
                    int isEmpty = st.isEmpty();
                    System.out.println(isEmpty);
                    break;
                case 5:
                    int isFull = st.isFull();
                    System.out.println(isFull);
                    break;
                default:
                    break;
            }
            done++;
        }
    }

    static class Stack {
        int[] arr = null;
        int capacity = 0;
        int top = -1;

        Stack(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top = -1;
        }

        public void push(int num) {
            if (isFull() == 0)
                arr[++top] = num;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            int popped = arr[top];
            arr[top] = 0;
            top = top - 1;
            return popped;
        }

        public int top() {
            if (top == -1) {
                return -1;
            }
            return arr[top];
        }

        public int isEmpty() {
            return top == -1 ? 1 : 0;
        }

        public int isFull() {
            return top + 1 == capacity ? 1 : 0;
        }
    }
}
