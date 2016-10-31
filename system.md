# System Tech Interview

## Process 와 Thread 차이
프로세스는 실행 중인 프로그램에 대한 인스턴스
쓰레드는 경량 프로세스

- 프로세스
    - 완벽히 독립적이기 때문에 메모리 영역(Code, Data, Heap, Stack)을 다른 프로세스와 공유하지 않음
    - Context Switching 시, 쓰레드보다 오버헤드가 큼
    
- 쓰레드
    - 해당 스레드를 위한 스택을 생성할 뿐 그 이외의 Code, Data, Heap영역을 공유
    - Context Switching 시, Stack 영역만 교체하면 되서 프로세스보다 오버헤드가 적음
    
## Dead lock 설명 / 방지법

- lock : 여러 프로세스/쓰레드가 동시에 같은 자원을 사용하려 할 때 발생
- Dead lock : 서로 상대방이 자원을 내놓을 때까지 작업을 멈추고 기다리는 상태

Dead lock 에 걸리면
- Dead lock인 프로세스를 다 죽이기
- Dead lock이 풀릴 때까지 자원을 선점해서 다른 프로세스에 할당하기

2가지 방법으로 처리

Dead lock 를 피하려면
- 자원 할당 그래프 (Resource-Allocation-Graph) 알고리즘
- 은행원 (Banker’s) 알고리즘

