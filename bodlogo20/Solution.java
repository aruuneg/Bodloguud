package bodlogo20;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(br.readLine()).append("\n");
        }
        String text = sb.toString();

        // Regex: word characters or digits or _, then '@', then similar, anchored on word boundaries.
        Pattern p = Pattern.compile(
            "\\b[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(?:\\.[a-zA-Z0-9_]+)+\\b"
        );
        Matcher m = p.matcher(text);

        // Use TreeSet for unique and sorted
        TreeSet<String> set = new TreeSet<>();
        while (m.find()) {
            set.add(m.group());
        }

        // Print in lex order separated by semicolons
        String out = String.join(";", set);
        System.out.println(out);
    }
}
