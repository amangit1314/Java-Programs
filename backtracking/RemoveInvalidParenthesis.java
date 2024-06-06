package backtracking;

import java.util.*;

// Problem Title => Remove Invalid Parenthesis
public class RemoveInvalidParenthesis {

  // check if character parenthesis (is open or close)
  static boolean isParenthesis(char c) {
    return ((c == '(') || (c == ')'));
  }

  static boolean isValidString(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(')
        count++;
      else if (str.charAt(i) == ')')
        count--;
      if (count < 0)
        return false;
    }
    return (count == 0);
  }

  // Method to remove invalid parenthesis (without using HashSet)
  static void removeInvalidParenthesis(String str) {
    if (str.isEmpty()) return;

    Queue<String> q = new LinkedList<>();
    String temp;

    // Pushing given string as starting node into queue
    q.add(str);

    int level = 0; // To track level for processing only valid strings of current level
    boolean foundValid = false; // Flag to indicate if a valid string was found

    while (!q.isEmpty()) {
      int size = q.size(); // Process all strings of current level

      for (int i = 0; i < size; i++) {
        str = q.poll();

        if (isValidString(str)) {
          System.out.println(str);
          foundValid = true;
        }

        // If a valid string is found at the current level, skip processing further strings
        // at this level (optimization)
        if (foundValid && level > 0) {
          continue;
        }

        for (int j = 0; j < str.length(); j++) {
          if (!isParenthesis(str.charAt(j))) continue;

          // Removing parenthesis from str and pushing into queue
          temp = str.substring(0, j) + str.substring(j + 1);
          q.add(temp);
        }
      }

      level++; // Move to next level (indicates processing children of current level strings)
      foundValid = false; // Reset flag for next level
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String expression = sc.nextLine();
    removeInvalidParenthesis(expression);
    sc.close();

    expression = "()v)";
    removeInvalidParenthesis(expression);
  }
}
