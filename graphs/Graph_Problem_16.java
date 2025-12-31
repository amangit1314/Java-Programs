// Given a sorted Dictionary of an Alien language, find order of character
import java.util.*;

public class Graph_Problem_17 {
    
    // Worst Approach: Brute Force
    // This approach involves comparing each pair of words to determine the order of characters.
    // Time Complexity: O(N^2 * M) where N is the number of words and M is the average length of a word.
    public static String findOrderBruteForce(String[] words) {
        // ...implementation...
        return "";
    }

    // Better Approach: Using Adjacency List and Topological Sort (Kahn's Algorithm)
    // This approach involves building a graph where each node is a character and edges represent the order.
    // Then, perform a topological sort to determine the order of characters.
    // Time Complexity: O(N * M) where N is the number of words and M is the average length of a word.
    public static String findOrderUsingKahnsAlgorithm(String[] words) {
        // Step 1: Create a graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }
        
        // Step 3: Perform topological sort
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }
        
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If the order length is not equal to the number of unique characters, there is a cycle
        if (order.length() != inDegree.size()) {
            return "";
        }
        
        return order.toString();
    }

    // Best Approach: Using Depth-First Search (DFS) for Topological Sort
    // This approach also involves building a graph and then performing a DFS to determine the order of characters.
    // Time Complexity: O(N * M) where N is the number of words and M is the average length of a word.
    public static String findOrderUsingDFS(String[] words) {
        // Step 1: Create a graph
        Map<Character, List<Character>> graph = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        StringBuilder order = new StringBuilder();
        
        // Initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    break;
                }
            }
        }
        
        // Step 3: Perform DFS
        for (char c : graph.keySet()) {
            if (!visited.contains(c)) {
                if (!dfs(c, graph, visited, visiting, order)) {
                    return ""; // Cycle detected
                }
            }
        }
        
        return order.reverse().toString();
    }
    
    private static boolean dfs(char current, Map<Character, List<Character>> graph, Set<Character> visited, Set<Character> visiting, StringBuilder order) {
        visiting.add(current);
        for (char neighbor : graph.get(current)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            if (visiting.contains(neighbor)) {
                return false; // Cycle detected
            }
            if (!dfs(neighbor, graph, visited, visiting, order)) {
                return false;
            }
        }
        visiting.remove(current);
        visited.add(current);
        order.append(current);
        return true;
    }
}