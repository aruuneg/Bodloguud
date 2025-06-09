package bodlogo27;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine().trim());

        StringBuilder s = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();
        history.push("");  // initial empty state

        while (Q-- > 0) {
            String[] parts = br.readLine().split(" ", 2);
            int op = Integer.parseInt(parts[0]);

            switch (op) {
                case 1:
                    history.push(s.toString());
                    s.append(parts[1]);
                    break;
                case 2:
                    history.push(s.toString());
                    int k = Integer.parseInt(parts[1]);
                    s.setLength(s.length() - k);
                    break;
                case 3:
                    int idx = Integer.parseInt(parts[1]) - 1;
                    System.out.println(s.charAt(idx));
                    break;
                case 4:
                    s = new StringBuilder(history.pop());
                    break;
            }
        }
    }
}
