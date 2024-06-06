package searchingSortingProblems;

// book allocation problem
public class SSP_Problem_25 {
    public static int minPagesAllocated(int[] pages, int students) {
        int n = pages.length; // Number of books

        // Handle edge cases
        if (students > n) {
            return -1; // Not enough books for all students
        }

        int sum = 0; // Total number of pages
        int max = Integer.MIN_VALUE; // Maximum number of pages in a book

        // Find the sum of all pages and the maximum pages in a book
        for (int page : pages) {
            sum += page;
            max = Math.max(max, page);
        }

        // Binary search for the minimum number of pages allocated to a student
        int low = max; // Minimum possible pages (highest book's pages)
        int high = sum; // Maximum possible pages (sum of all pages)
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if it's possible to allocate books with this mid value (pages per
            // student)
            if (isAllocationPossible(pages, n, students, mid)) {
                high = mid - 1; // Allocation possible, try to minimize pages further
            } else {
                low = mid + 1; // Allocation not possible, need more pages per student
            }
        }

        return low; // Minimum number of pages allocated to a student
    }

    private static boolean isAllocationPossible(int[] pages, int n, int students, int maxPages) {
        int student = 1; // Start with one student
        int currentPages = 0; // Pages allocated to the current student

        for (int i = 0; i < n; i++) {
            if (currentPages + pages[i] > maxPages) {
                student++; // Move to next student if current allocation exceeds limit
                currentPages = pages[i]; // Start fresh for the new student
            } else {
                currentPages += pages[i]; // Add book pages to current student
            }
        }

        return student <= students; // Check if all books can be allocated within the given student limit
    }

    public static void main(String[] args) {
        int[] pages = { 12, 34, 67, 90 };
        int students = 2;

        int minPages = minPagesAllocated(pages, students);
        System.out.println("Minimum number of pages allocated to a student: " + minPages);
    }
}
