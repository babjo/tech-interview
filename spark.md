# Spark Tech Interview

## RDD 란?
An RDD in Spark is simply an immutable distributed collection of objects.

기존 하둡은 데이터 처리시, HDFS 쓰기/읽기를 반복하여 느려
스파크는 램에 올려서 연산하자. 그런데 중간에 fault 나면? 램을 read-only로 만들어서 쓰자.

## 수행중 메모리가 부족하면 ?

LRU로 안쓰는 파티션 날림
- 캐시랑 하는짓 유사

## Narrow transformation vs Wide transformation
![transformation](_img/trans.png)

- Narrow transformation (involves no data shuffling)
    - 한 노드에서 처리 가능 (빠름)
    - Map, FlatMap, Filter, Sample
- Wide transformation (involves data shuffling)
    - SortByKey, ReduceByKey, GroupByKey, CogroupByKey, Join, Cartesian
    - 셔플이 필요, 네트워크를 타야한다 (느림)