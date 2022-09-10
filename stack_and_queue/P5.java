package stack_and_queue;

// Problem Title => Implement "N" stack's in an Array
public class P5 {

    // A Java class to represent k stacks in a single arrays.array of size n
    static class KStack {

        // Array of size n to store actual content to be stored in stacks
        int[] arr;

        // Array of size k to store indexes of top elements of stacks
        int[] top;

        // Array of size n to store next entry in all stacks and free linkedList.list
        int[] next;

        int n, k;

        // To store beginning index of free linkedList.list
        int free;

        // constructor to create k stacks in an arrays.array of size n
        KStack(int k1, int n1) {

            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;

            arr = new int[n];
            top = new int[k];
            next = new int[n];

            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                top[i] = -1;

            // Initialize all spaces as free
            free = 0;
            for (int i = 0; i < n - 1; i++)
                next[i] = i + 1;

            // -1 is used to indicate end of free linkedList.list
            next[n - 1] = -1;
        }

        // A utility function to check if there is space available
        boolean isFull() {
            return (free == -1);
        }

        // To push an item in stack number 'sn' where sn is from 0 to k-1
        void push(int item, int sn) {
            // Overflow check
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            // Store index of first free slot
            int i = free;

            // Update index of free slot to index of next slot in free linkedList.list
            free = next[i];

            // Update next of top and then top for stack number 'sn'
            next[i] = top[sn];
            top[sn] = i;

            // Put the item in arrays.array
            arr[i] = item;
        }

        // To pop a from stack number 'sn' where sn is from 0 to k-1
        int pop(int sn) {
            // Underflow check
            if (isEmpty(sn)) {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }

            // Find index of top item in stack number 'sn'
            int i = top[sn];

            // Change top to store next of previous top
            top[sn] = next[i];

            // Attach the previous top to the beginning of free linkedList.list
            next[i] = free;
            free = i;

            // Return the previous top item
            return arr[i];
        }

        // To check whether stack number 'sn' is empty or not
        boolean isEmpty(int sn) {
            return (top[sn] == -1);
        }

    }

    // Driver program
    public static void main(String[] args) {
        // Let us create 3 stacks in an arrays.array of size 10
        int k = 3, n = 10;

        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
