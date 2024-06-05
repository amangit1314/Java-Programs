package arrays;

/* Problem Title: Rearrange the array in alternating positive and negative items with O(1) extra space */
public class Array_Problem_20 {

    // Rotates elements in the subarray starting from `from` to the right by `steps` positions
    private void rightRotate(int[] array, int length, int from, int current) {
        int temp = array[current];
        for (int i = current; i > from; i--) {
            array[i] = array[i - 1];
        }
        array[from] = temp;
    }

    // Rearranges the array in alternating positive and negative items
    public void rearrange(int[] array, int length) {

        // Index of the first out-of-place element (needs to be swapped)
        int outOfPlaceIndex = -1;

        for (int index = 0; index < length; index++) {
            if (outOfPlaceIndex <= 0) {
                // Check if the current element is opposite in sign to the first out-of-place element or if both are negative (need correction)
                boolean needsCorrection = ((array[index] >= 0) && (array[outOfPlaceIndex] < 0) || (array[index] < 0) && (array[outOfPlaceIndex] >= 0));

                if (needsCorrection) {
                    // If there are more than one element between the current and the out-of-place element, update the out-of-place index to skip those elements
                    if (index - outOfPlaceIndex >= 2) {
                        outOfPlaceIndex += 2;
                    } else {
                        outOfPlaceIndex = -1; // reset if no correction needed
                    }
                }
            }

            // Check if the current element needs to be moved (positive at even index or negative at odd index)
            if (outOfPlaceIndex == -1) {
                boolean needsShift = ((array[index] >= 0) && ((index % 2) == 0)) || ((array[index] < 0) && (index % 2) == 1);
                if (needsShift) {
                    outOfPlaceIndex = index;
                }
            }
        }
    }

    // Prints the array
    private void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Array_Problem_20 rearrange = new Array_Problem_20();

        int[] array = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = array.length;

        System.out.println("Given array is ");

        rearrange.printArray(array, n);
        rearrange.rearrange(array, n);

        System.out.println("Rearranged array is ");

        rearrange.printArray(array, n);
    }
}
