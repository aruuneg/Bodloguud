package bodlogo7;

import java.io.*;

class Result {

    public static String timeInWords(int h, int m) {
        String[] numbers = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
        };

        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            int nextHour = (h % 12) + 1;
            return "quarter to " + numbers[nextHour];
        } else if (m < 30) {
            if (m == 1) {
                return "one minute past " + numbers[h];
            } else {
                return numbers[m] + " minutes past " + numbers[h];
            }
        } else {
            int minsTo = 60 - m;
            int nextHour = (h % 12) + 1;
            if (minsTo == 1) {
                return "one minute to " + numbers[nextHour];
            } else {
                return numbers[minsTo] + " minutes to " + numbers[nextHour];
            }
        }
    }
}

public class bodlogo7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
