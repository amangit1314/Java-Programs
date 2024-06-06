package searchingSortingProblems;

import java.util.Scanner;

public class SSP_Problem_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of soldiers
        int N = scanner.nextInt();

        // Read the number of rounds
        int Q = scanner.nextInt();

        // Loop for each round
        for (int i = 0; i < Q; i++) {
            int M = scanner.nextInt(); // Bishu's power for this round

            // Count soldiers defeated and their total power
            int defeatedSoldiers = 0;
            int defeatedSoldiersPower = 0;

            // Loop through all soldiers
            for (int j = 0; j < N; j++) {
                if (scanner.nextInt() <= M) {
                    defeatedSoldiers++;
                    defeatedSoldiersPower += scanner.nextInt(); // Add power of defeated soldier
                }
            }

            // Print the results for this round
            System.out.println(defeatedSoldiers + " " + defeatedSoldiersPower);
        }

        scanner.close();
    }
}
