package bodlogo28;

import java.io.*;
import java.util.*;

public class Solution {


    static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int num = 3;
        while (primes.size() < n) {
            boolean isPrime = true;
            for (int p : primes) {
                if (p * p > num) break;
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(num);
            num += 2;
        }
        return primes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        Stack<Integer> A = new Stack<>();
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A.push(Integer.parseInt(arrStr[i]));
        }

        List<Integer> primes = generatePrimes(q);

        List<Integer> result = new ArrayList<>();

        Stack<Integer> B = null;

        for (int i = 0; i < q; i++) {
            Stack<Integer> nextA = new Stack<>();
            B = new Stack<>();

            while (!A.isEmpty()) {
                int val = A.pop();
                if (val % primes.get(i) == 0) {
                    B.push(val);
                } else {
                    nextA.push(val);
                }
            }

        
            while (!B.isEmpty()) {
                result.add(B.pop());
            }
            A = nextA;
        }

        while (!A.isEmpty()) {
            result.add(A.pop());
        }

        for (int val : result) {
            System.out.println(val);
        }
    }
}
