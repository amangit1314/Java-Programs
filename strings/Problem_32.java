package strings;

import java.util.ArrayList;
import java.util.List;

public class Problem_32 {

    public static void generateIPAddresses(String str, List<String> addresses, int start, int dots) {
      if (dots == 4 && start == str.length()) {
        addresses.add(str); // Valid IP address with 4 parts and reaching string end
        return;
      }
  
      if (dots > 4 || start >= str.length() || (dots == 4 && start < str.length())) {
        return; // Invalid scenarios: too many dots, exceeding string length, or incomplete address with 4 dots
      }
  
      for (int i = 1; i <= 3 && start + i <= str.length(); i++) {
        String part = str.substring(start, start + i);
        int num = Integer.parseInt(part);
  
        // Check for valid IP part (between 0 and 255, not starting with 0 except 0 itself)
        if (num >= 0 && num <= 255 && (part.length() == 1 || part.charAt(0) != '0' || num == 0)) {
          generateIPAddresses(str, addresses, start + i, dots + 1); // Recursively explore possibilities with the current part
          if (dots == 3) { // Don't add dot after the third part
            return;
          }
          addresses.add("."); // Add dot before next part (except after the third part)
        }
      }
    }
  
    public static List<String> findValidIPAddresses(String str) {
      List<String> addresses = new ArrayList<>();
      generateIPAddresses(str, addresses, 0, 0);
      return addresses;
    }
  
    public static void main(String[] args) {
      String str = "25525511135";
      List<String> validAddresses = findValidIPAddresses(str);
  
      System.out.println("Valid IP addresses for '" + str + "':");
      for (String address : validAddresses) {
        System.out.println(address);
      }
    }
  }
  