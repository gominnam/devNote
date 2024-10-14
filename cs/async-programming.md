## Async Programming (비동기 프로그래밍)

### 1. 비동기 프로그래밍이란?

- 비동기는 작업이 시작되면 그 작업의 완료 여부에 상관없이 다른 작업을 진행할 수 있게 한다.
: 1. Thread 하나로 처리
: 2. 디스크 I/O 또는 네트워크 콜 과 같이 Blocking Call이 있을 때 CPU를 놀리지 말고 최대한 활용
: 3. OS 가 처리하는게 아닌 언어( Java, Python 등..) 단에서 하는 것 그러므로 언제 Context Switching 할 수 있는지 알려주어야 한다.
: 4. 다른 작업을 진행할 때 이전 작업과 독립(Independency)된 작업이어야 한다.


### 2. Source Code

```java
// reference chatgpt source
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample {
    public static void main(String[] args) {
        // 비동기 작업 생성 및 결과 반환
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                // 2초 동안 블로킹 작업 시뮬���이션
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "비동기 작업 완료!";
        });

        // 비동기 작업 결과 처리
        future.thenApply(result -> {
            System.out.println(result);
            return result;
        });

        // 다른 작업 수행
        System.out.println("다른 작업 수행 중...");

        // 비동기 작업 완료 대기
        try {
            String result = future.get(); // 비동기 작업이 완료될 때까지 대기
            System.out.println("최종 결과: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("모든 작업 완료!");
    }
}
```
- CompletableFuture.runAsync() : 비동기 작업 생성
- future.thenApply() : 비동기 작업 결과 처리
- future.get() : 비동기 작업 완료 대기
- CompletableFuture<Void> : 비동기 작업이 완료되면 결과를 반환하지 않는다.
- CompletableFuture<String> : 비동기 작업이 완료되면 결과를 반환한다.


### 3. 헷갈리는 용어 정리

- 1. 비동기
: 비동기는 특정 작업을 비동기적으로 처리하면서 기다리는 동안 다른 작업을 수행하는 방식입니다.</br>
  비동기 작업은 주로 시간이 많이 걸리는 작업(예: 파일 I/O, 네트워크 요청 등)을 메인 스레드를 차단하지 않고 처리할 수 있게 도와줍니다.</br>
  작업을 "다른 작업의 완료를 기다리지 않고" 바로 이어서 처리하는 것을 말합니다.

- 2. 동시성
: 동시성은 여러 작업을 겉보기에는 동시에 진행하는 것처럼 처리하는 방식입니다.</br>
  하지만 실제로는 하나의 CPU 코어에서 작업을 번갈아 가며 처리합니다.</br>
  즉, 작업을 빠르게 스위칭하며 병렬적으로 실행하는 것처럼 보이게 하는 것이 동시성입니다.</br>
  스레드나 프로세스들이 시간 분할을 통해 순차적으로 실행됩니다.

- 3. 병렬성
: 병렬성은 여러 작업을 실제 동시에 처리하는 것을 말합니다.</br>
  병렬성은 여러 CPU 코어에서 작업을 동시에 처리하는 것을 의미합니다.</br>
  즉, 여러 작업을 동시에 처리하므로 동시성보다 빠르게 작업을 처리할 수 있습니다.</br>
  병렬성은 동시성을 포함하고 있지만, 동시성은 병렬성을 포함하고 있지 않습니다.

