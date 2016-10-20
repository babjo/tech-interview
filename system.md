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