package strings;

// Function to find Number of customers who could not get a computer
public class Problem_40 {
    public static int numCustomersNotGettingComputer(int totalCustomers, int numComputers, char[] customerPrefs) {
        if (totalCustomers <= 0 || numComputers < 0 || customerPrefs == null
                || customerPrefs.length != totalCustomers) {
            return -1; // Invalid input
        }

        // Count the number of customers needing laptops and desktops
        int laptopsNeeded = 0;
        int desktopsNeeded = 0;
        for (char pref : customerPrefs) {
            if (pref == 'L') {
                laptopsNeeded++;
            } else if (pref == 'D') {
                desktopsNeeded++;
            } else {
                // Invalid preference character, ignore
            }
        }

        // Check if there are enough computers to satisfy all preferences
        if (laptopsNeeded <= numComputers && desktopsNeeded <= numComputers) {
            return 0; // All customers get a computer
        }

        // Determine the type of computer in short supply
        int computersShort = Math.min(laptopsNeeded, desktopsNeeded);
        int customersShort = Math.max(laptopsNeeded, desktopsNeeded);

        // Calculate the number of customers who cannot get their preferred computer
        return customersShort - computersShort;
    }

    public static void main(String[] args) {
        int totalCustomers = 8;
        int numComputers = 5;
        char[] customerPrefs = { 'L', 'L', 'D', 'D', 'L', 'D', 'L', 'D' };

        int numNotGettingComputer = numCustomersNotGettingComputer(totalCustomers, numComputers, customerPrefs);
        System.out.println(numNotGettingComputer + " customers could not get their preferred computer.");
    }
}
