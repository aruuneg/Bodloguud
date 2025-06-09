# Бодлого 36 - Merging Communities

## Бодлогын өгүүлбэр:
N бүлэг байгаа ба бүлэг бүр эхэндээ зөвхөн өөрийн гишүүнтэй. Та M үйлдэл хийнэ:

- `0 a b`: a бүлэг болон b бүлэгт багтдаг гишүүдийг нэгтгэнэ.
- `1 a`: a бүлгийн гишүүдийн тоог ол.

## Холбоос:
[https://www.hackerrank.com/challenges/merging-communities/problem](https://www.hackerrank.com/challenges/merging-communities/problem)

## Шийдэл:
- Disjoint Set Union (DSU) буюу Union-Find дата бүтэц ашиглана.
- Нэгтгэх үед бүлгийн төлөөлөгчийг шинэчилж, гишүүдийн тоог хадгална.
- Гишүүдийн тоог олох үед төлөөлөгч дээрээс уншина.
- Үйлдэл бүрийг ойролцоогоор O(α(N)) хугацаанд гүйцэтгэнэ (α нь inverse Ackermann function).
