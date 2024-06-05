package arrays;

/* Problem Title: Find common elements in 3 sorted arrays */
public class Array_Problem_19 {

    // This function prints common elements in firstArray
    void findCommon(int[] firstArray, int[] secondArray, int[] thirdArray) {
        // Initialize starting indices for arrays
        int firstIndex = 0, secondIndex = 0, thirdIndex = 0;

        // Iterate through arrays while all have elements
        while (firstIndex < firstArray.length && secondIndex < secondArray.length && thirdIndex < thirdArray.length) {
            // If elements are equal, print any and move forward in all arrays
            if (firstArray[firstIndex] == secondArray[secondIndex] && secondArray[secondIndex] == thirdArray[thirdIndex]) {
                System.out.print(firstArray[firstIndex] + " ");
                firstIndex++;
                thirdIndex++;
            } else if (firstArray[firstIndex] < secondArray[secondIndex]) {
                // First element is smaller, so move its index
                firstIndex++;
            } else if (secondArray[secondIndex] < thirdArray[thirdIndex]) {
                // Second element is smaller, so move its index
                secondIndex++;
            } else {
                // Third element is smaller, so move its index
                thirdIndex++;
            }
        }
    }

    /* Driver Code */
    public static void main(String[] args) {

        Array_Problem_19 object = new Array_Problem_19();
        int[] firstArray = {1, 5, 10, 20, 40, 80};
        int[] secondArray = {6, 7, 20, 80, 100};
        int[] thirdArray = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        object.findCommon(firstArray, secondArray, thirdArray);
    }
}
