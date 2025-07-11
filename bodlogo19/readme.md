# Бодлого 19

## Бодлогын өгүүлбэр:
N ширхэг хот болон тэдгээрийг холбосон M зам өгөгдсөн. Зам бүр хоёр хотоос бүрдэх ба жингийн утгатай. Мөн Q ширхэг хүсэлт өгөгдөх ба хүсэлт бүрд хоёр хот өгөгдөнө. Бидний зорилго бол эдгээр хоёр хотын хоорондох хамгийн бага замын уртыг олох юм.

## Холбоос:
[https://www.hackerrank.com/challenges/dijkstrashortreach](https://www.hackerrank.com/challenges/dijkstrashortreach)

## Шийдэл:
Энэхүү бодлого нь **граф дээрх хамгийн богино зам** олох нийтлэг бодлого бөгөөд **Dijkstra алгоритм** ашиглан үр дүнтэй шийдэж болно. Бүх хотыг хөршүүдтэй нь adjacency list хэлбэрээр хадгалж, PriorityQueue ашиглан хамгийн бага зардалтай замыг хайна.

Алгоритмын үе шатууд:
1. Графыг adjacency list-ээр төлөөлөх.
2. Dijkstra алгоритмыг эхлэх хот (x) дээрээс ажиллуулах.
3. Яг тухайн хүсэлтийн хоёр дахь хот (y)-ийн хамгийн бага зайг хариу болгоно.
4. Хэрэв хүрч болохгүй бол `-1` гэж хариулна.

Ийм аргаар алгоритмын хугацаа `O((N + M) log N)` бөгөөд олон хүсэлтүүд дээр хурдан ажиллана.

