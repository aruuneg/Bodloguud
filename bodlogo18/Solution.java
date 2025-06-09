package bodlogo18;

import java.io.*;
import java.util.*;

class Result {

    static final int MOD = 1000000007;
    static final int MAX = 1001;
    static long[] fact = new long[MAX];

    static void computeFactorials() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }

    static long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    static long modPow(long a, int p) {
        long result = 1;
        a %= MOD;
        while (p > 0) {
            if ((p & 1) == 1) result = (result * a) % MOD;
            a = (a * a) % MOD;
            p >>= 1;
        }
        return result;
    }

    public static int beadOrnaments(List<Integer> b) {
        computeFactorials();

        int total = 0;
        long result = 1;

        for (int beads : b) {
            total += beads;
            result = (result * modPow(beads, beads - 2)) % MOD;
        }

        result = (result * fact[total]) % MOD;

        for (int beads : b) {
            result = (result * modInverse(fact[beads])) % MOD;
        }

        return (int) result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int bCount = sc.nextInt();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < bCount; i++) {
                b.add(sc.nextInt());
            }
            int result = Result.beadOrnaments(b);
            System.out.println(result);
        }
        sc.close();
    }
}
