# Бодлого 39 - No Prefix Set

## Бодлогын өгүүлбэр:
Нэрсийн жагсаалт өгөгдсөн. Тэдгээр нэрсийн аль нь нэг нь өөрийн урьдчилсан оролт (prefix) болбол "BAD SET" гэж хэвлэ. Үгүй бол "GOOD SET" гэж хэвлэ. Хэрвээ "BAD SET" бол prefix үүсгэсэн хамгийн анхны нэрийг хэвлэ.

Жишээ:  
Input:  
4  
aab  
defgab  
abcde  
aabcde  

Output:  
BAD SET  
aabcde

Учир нь `aabcde` нь `aab`-ийн prefix биш, гэхдээ `aab` ба `aabcde` нэрийн prefix үл тохирч байгаа.

## Холбоос:  
[https://www.hackerrank.com/challenges/no-prefix-set/problem](https://www.hackerrank.com/challenges/no-prefix-set/problem)

## Шийдэл:
- Trie мод ашиглан оролт нэрсийг хадгалж prefix-ийн зөрчлийг шалгах.
- Хэрвээ шинэ нэр модонд нэмэхэд аль нэг өмнөх нэр prefix бол, эсвэл шинэ нэр өөрөөсөө бусдыг prefix болгоход "BAD SET" гарна.
- `O(n * m)` хугацаатай, n - нэрсийн тоо, m - хамгийн урт нэрийн урт.