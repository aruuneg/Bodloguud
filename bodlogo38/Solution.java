package bodlogo38;

import java.util.*;

public class Solution {
    static class Plant {
        int pesticide;
        int days;

        Plant(int pesticide, int days) {
            this.pesticide = pesticide;
            this.days = days;
        }
    }

    public static int poisonousPlants(int[] p) {
        Stack<Plant> stack = new Stack<>();
        int maxDays = 0;

        for (int pesticide : p) {
            int days = 0;
            while (!stack.isEmpty() && pesticide <= stack.peek().pesticide) {
                days = Math.max(days, stack.pop().days);
            }
            days = stack.isEmpty() ? 0 : days + 1;
            maxDays = Math.max(maxDays, days);
            stack.push(new Plant(pesticide, days));
        }

        return maxDays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(poisonousPlants(p));
        sc.close();
    }
}