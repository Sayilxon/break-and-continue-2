public class BreakAndContinueAdvanced {

    // Labeled break — exit from nested loops
    static int[] findInMatrix(int[][] matrix, int target) {
        outer:
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == target) {
                    System.out.printf("Found %d at [%d][%d]%n", target, r, c);
                    break outer;  // Exits BOTH loops
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Print primes using continue
    static void printPrimes(int limit) {
        System.out.println("Primes up to " + limit + ":");
        for (int n = 2; n <= limit; n++) {
            boolean composite = false;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) { composite = true; break; }
            }
            if (composite) continue;
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Process valid transactions only (continue on invalid)
    static double processTransactions(double[] transactions) {
        double balance = 1000.0;
        System.out.println("\nProcessing transactions:");
        for (double t : transactions) {
            if (Double.isNaN(t)) { System.out.println("  SKIP: invalid transaction"); continue; }
            if (t < 0 && Math.abs(t) > balance) { System.out.println("  SKIP: insufficient funds for " + t); continue; }
            balance += t;
            System.out.printf("  %+.2f → balance: $%.2f%n", t, balance);
            if (balance <= 0) { System.out.println("  STOP: account emptied"); break; }
        }
        return balance;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {5,  12, 8},
            {3,  99, 7},
            {42, 1, 15}
        };
        System.out.println("=== Labeled Break in Matrix Search ===");
        findInMatrix(matrix, 99);
        findInMatrix(matrix, 42);

        System.out.println("\n=== Prime Sieve with continue ===");
        printPrimes(50);

        double balance = processTransactions(
            new double[]{+200, -50, Double.NaN, -2000, +100, -300, +150}
        );
        System.out.printf("Final balance: $%.2f%n", balance);
    }
}
