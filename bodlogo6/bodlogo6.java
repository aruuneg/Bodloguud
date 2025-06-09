package bodlogo6;

public class bodlogo6 {
    public static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        int i = arr.length - 2;

        // 1. Баруун талаас багасаж эхэлсэн эхний индексийг олох
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "no answer";
        }

        // 2. i-с баруун талд arr[j] > arr[i] ийм хамгийн сүүлийн индексийг олох
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // 3. arr[i] болон arr[j] солих
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // 4. i+1-ээс хойших тэмдэгтүүдийг урвуу болгох
        int start = i + 1, end = arr.length - 1;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(biggerIsGreater("ab"));
    }
}
