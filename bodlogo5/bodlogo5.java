public class bodlogo5 {
    public static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int length = s.length();
        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));
        if (rows * cols < length) rows++;

        StringBuilder encrypted = new StringBuilder();

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int idx = r * cols + c;
                if (idx < length) {
                    encrypted.append(s.charAt(idx));
                }
            }
            if (c < cols - 1) encrypted.append(" ");
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        String input = "if man was meant to stay on the ground god would have given us roots";
        System.out.println(encryption(input));
    }
}
