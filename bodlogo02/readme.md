# Бодлого 2 - Extra Long Factorials

## Бодлогын өгүүлбэр:
- `n!` (factorial) гэдэг нь `n × (n-1) × (n-2) × ... × 2 × 1` гэсэн үржвэр юм. Танд `n` гэсэн бүхэл тоо өгөгдөнө. `n!`-ийг бодож хэвлэ.

 - n нь ихээхэн том байж болох тул `long`, `int` гэх мэт төрлүүд багтахгүй. Тиймээс `BigInteger` (эсвэл Python-т бол шууд тоо) ашиглах шаардлагатай.

## Оролт:
- 1 ≤ n ≤ 100

## Гаралт:
- `n!` буюу n-ийн факториалын утгыг хэвлэнэ.

## Шийдэл:

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

System.out.println(result);
    }
}


