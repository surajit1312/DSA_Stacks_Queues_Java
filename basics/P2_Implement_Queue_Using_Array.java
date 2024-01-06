package basics;

/**
 * 
 * CodingNinjas: Implement Queue using Arrays
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825
 * 
 * 
 * 1 'e': Enqueue (add) element ‘e’ at the end of the queue.
 * 
 * 2: Dequeue (retrieve) the element from the front of the queue. If the queue
 * is empty, return -1.
 * 
 * 
 * TC: O(N)
 * SC: O(N)
 */
public class P2_Implement_Queue_Using_Array {
    public static void main(String[] args) {
        int capacity = 100;
        int n = 7;
        // operation - 1(insert), 2(pop), 3(top), 4(check if empty), 5(size)
        int[] operations = { 1, 1, 2, 1, 2, 2, 2 };
        int[] values = { 2, 7, -1, 13 };

        Queue queue = new Queue(capacity);
        int done = 0;
        while (done < n) {
            switch (operations[done]) {
                case 1:
                    queue.enqueue(values[done]);
                    break;
                case 2:
                    int dequeued = queue.dequeue();
                    System.out.println(dequeued);
                    break;
                default:
                    break;
            }
            done++;
        }
    }

    static class Queue {
        int front, rear;
        int[] arr;
        int capacity = 100001;
        int count = 0;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        Queue(int capacity) {
            front = 0;
            rear = 0;
            this.capacity = capacity;
            arr = new int[capacity];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            if (count >= capacity) {
                return;
            }
            int index = rear % capacity;
            arr[index++] = e;
            rear++;
            count++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if (front == rear) {
                return -1;
            }
            int index = front % capacity;
            int removed = arr[index];
            arr[index] = -1;
            front++;
            count--;
            return removed;
        }
    }
}
