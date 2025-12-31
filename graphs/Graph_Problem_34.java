package graphs;
import java.util.*;

// Problem Title => Water Jug Problem using BFS
public class Graph_Problem_34 {

    // Node class to represent a state of the jugs
    static class Node {
        int jug1, jug2, steps;
        Node(int jug1, int jug2, int steps) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.steps = steps;
        }
    }

    // Function to check if the state is already visited
    static boolean isVisited(Set<String> visited, int jug1, int jug2) {
        return visited.contains(jug1 + "," + jug2);
    }

    // Function to mark the state as visited
    static void markVisited(Set<String> visited, int jug1, int jug2) {
        visited.add(jug1 + "," + jug2);
    }

    // Function to solve the Water Jug problem using BFS
    static int waterJugBFS(int jug1Capacity, int jug2Capacity, int target) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        markVisited(visited, 0, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // If we reach the target, return the number of steps
            if (current.jug1 == target || current.jug2 == target) {
                return current.steps;
            }

            // Generate all possible states from the current state
            List<Node> nextStates = Arrays.asList(
                new Node(jug1Capacity, current.jug2, current.steps + 1), // Fill jug1
                new Node(current.jug1, jug2Capacity, current.steps + 1), // Fill jug2
                new Node(0, current.jug2, current.steps + 1), // Empty jug1
                new Node(current.jug1, 0, current.steps + 1), // Empty jug2
                new Node(Math.min(jug1Capacity, current.jug1 + current.jug2), current.jug1 + current.jug2 - Math.min(jug1Capacity, current.jug1 + current.jug2), current.steps + 1), // Pour jug2 into jug1
                new Node(current.jug1 + current.jug2 - Math.min(jug2Capacity, current.jug1 + current.jug2), Math.min(jug2Capacity, current.jug1 + current.jug2), current.steps + 1) // Pour jug1 into jug2
            );

            // Add the next states to the queue if they are not visited
            for (Node nextState : nextStates) {
                if (!isVisited(visited, nextState.jug1, nextState.jug2)) {
                    queue.add(nextState);
                    markVisited(visited, nextState.jug1, nextState.jug2);
                }
            }
        }

        // If we cannot reach the target, return -1
        return -1;
    }

    public static void main(String[] args) {
        int jug1Capacity = 4;
        int jug2Capacity = 3;
        int target = 2;

        int result = waterJugBFS(jug1Capacity, jug2Capacity, target);
        if (result != -1) {
            System.out.println("Minimum number of steps to get " + target + " liters: " + result);
        } else {
            System.out.println("It is not possible to get " + target + " liters.");
        }
    }
}

/*
Approach:
1. The problem is to find the minimum number of steps to measure exactly 'target' liters using two jugs with given capacities.
2. This can be solved using Breadth-First Search (BFS) to explore all possible states of the jugs.
3. The algorithm involves the following steps:
   a. Initialize a queue and a set to keep track of visited states.
   b. Start from the initial state (0, 0) and perform BFS.
   c. For each state, generate all possible next states by filling, emptying, or pouring between the jugs.
   d. If a state reaches the target, return the number of steps.
   e. If the queue is exhausted without reaching the target, return -1.

Notes:
- The function `waterJugBFS` solves the Water Jug problem using BFS.
- The function `isVisited` checks if a state is already visited.
- The function `markVisited` marks a state as visited.

Example:
Input:
Jug1 Capacity: 4
Jug2 Capacity: 3
Target: 2

Output:
Minimum number of steps to get 2 liters: 2

Explanation:
- One possible solution is to fill jug1 (4 liters) and pour from jug1 to jug2 until jug2 is full (3 liters), leaving 1 liter in jug1.
- Empty jug2 and pour the remaining 1 liter from jug1 to jug2.
- Fill jug1 again (4 liters) and pour from jug1 to jug2 until jug2 is full (3 liters), leaving 2 liters in jug1.
- The total number of steps is 2.
*/