package searchingSortingProblems;

import java.util.HashMap;

public class SSP_Problem_18 {

  public static int minSwaps(int[] arr) {
    int n = arr.length;

    // Create a graph with n nodes (representing elements)
    HashMap<Integer, Integer> map = new HashMap<>(); // Key: original value, Value: index in the array
    for (int i = 0; i < n; i++) {
      map.put(arr[i], i);
    }

    // Count the number of cycles in the graph
    int cycleCount = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(arr, map, visited, i, cycleCount);
      }
    }

    return cycleCount; // Minimum swaps required is equal to the number of cycles
  }

  private static void dfs(int[] arr, HashMap<Integer, Integer> map, boolean[] visited, int i, int cycleCount) {
    visited[i] = true;
    int next = map.get(arr[i]); // Find the element that should be at index i

    if (!visited[next]) {
      dfs(arr, map, visited, next, cycleCount);
    } else { 
      cycleCount++;
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 8, 5, 4, 1, 3};
    int minSwaps = minSwaps(arr);
    System.out.println("Minimum number of swaps required: " + minSwaps);
  }
}
