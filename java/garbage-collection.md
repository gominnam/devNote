# Garbage Collection (GC)

<br>
JVM에서 Garbage Collection(이하 GC)는 Heap 영역에 생성된 객체 중에서 참조되지 않은 객체를 탐색 후 제거하는 기능을 말한다.
GC가 메모리 관리를 자동으로 해주기 때문에 개발자는 메모리 관리에 대한 부담을 줄일 수 있다.
위와 같은 장점이 있지만 단점도 존재한다.<br>

- 메모리가 언제 해제되는지 시점을 정확하게 알 수 없기 때문에 제어가 힘들다.
- GC가 실행되면 GC를 실행하는 스레드를 제외한 나머지 스레드는 모두 작업을 멈춘다.(Stop-the-World)<br>

위와 같이 STW(Stop-the-World)로 인해 Thread의 작업이 모두 중단되는 상황이 서비스 이용에 차질을 줄 수 있기때문에
GC의 튜닝은 매우 중요하다. GC-알고리즘은 설정을 통해 Java에 적용할 수 있다.<br><br>

## GC의 대상
```agsl
- Unreachable Object: 객체가 참조되고 있지 않은 상태(null)
```
<br>

## GC 청소 방식
```agsl
- Mark and Sweep: GC가 실행되면 GC Root로부터 참조되지 않은 객체를 탐색 후 제거하는 방식
Mark된 Unreachable Object를 Sweep(청소)하여 빈자리들을 채우는 작업(Compaction)을 수행한다.
```

## heap 메모리 구조
```agsl
- 대부분의 객체는 금방 접근불가상태(Unreachable Object)가 된다.
- 위와 같은 개념을 토대로 Heap 메모리에 Young, Old 영역 2가지로 나눈다.
- Young 영역: 새롭게 생성된 객체가 할당되는 영역, 대부분의 객체가 금방 접근불가상태가 되기 때문에 많은 객체가 Young 영역에 생성된다.//Minor GC
- Old 영역: Young 영역에서 Reachable 상태를 유지하여 살아남은 객체가 Old 영역으로 이동한다.//Major GC
```


## GC Algorithm 종류
```agsl
- Serial GC: GC를 처리하는 스레드가 1개이다. GC를 처리하는 동안 GC를 제외한 모든 스레드가 작업을 멈춘다.(속도가 느리다.)
command: java -XX:+UseSerialGC -jar Application.java

- Parallel GC: GC를 처리(Young 영역만 해당)하는 스레드가 여러개이다. GC를 처리하는 동안 GC를 제외한 모든 스레드가 작업을 멈춘다.
command: java -XX:+UseParallelGC -jar Application.java  # -XX:ParallelGCThreads=N : 사용할 쓰레드의 갯수

- Parallel Old GC: Parallel GC에서 Old 영역도 포함된 개선 버전. GC를 처리하는 스레드가 여러개이다.
command: java -XX:+UseParallelOldGC -jar Application.java  # -XX:ParallelGCThreads=N : 사용할 쓰레드의 갯수

- Concurrent Mark Sweep(CMS) GC: GC를 처리하는 스레드가 여러개이다. GC를 처리하는 동안 GC를 제외한 모든 스레드가 작업을 멈추지 않는다.(Java 14부터 사용 중지)

- G1(Garbage first) GC: Young/Old 영역이 아닌 Region 영역이라는 새로운 개념을 도입. 상황에 따라 Eden, Survivor, Old 등 역할을 고정이 아닌 동적으로 부여
일일이 메모리를 탐색하지 않고 메모리가 많이 차있는 영역을 우선 GC 한다. 결국 GC 빈도가 줄어드는 효과를 얻게 되는 원리
command: java -XX:+UseG1GC -jar Application.java
```


## reference

- [http](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC)
