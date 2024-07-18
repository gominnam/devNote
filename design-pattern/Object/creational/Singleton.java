public class Singleton {
    // volatile 키워드를 사용하여 멀티스레드 환경에서의 문제를 해결한다.
    // 1. 한 스레드에서 volatile 변수 값 변경 시 다른 스레드에 즉시 보이게 된다.
    // 2. 원자성을 보장하지 않는다. => synchronized 블록이나 concurrent.atomic 클래스는 사용해야함
    // 3. 읽기와 쓰기 작업은 메모리 베리어를 통해 수행. => 순서 보장, 가시성 보장, 최적화 방지
    private static volatile Singleton instance = null;

    private Singleton() {
        // initialize();
    }

    public static Singleton getInstance() {
        if(instance == null) {
            // 모든 스레드가 이 블록으로 진입하기 전에 차례를 기다리게 함.
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public static void main(String[] args){
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    System.out.println(singleton1 == singleton2);  // true

    singleton1.doSomething();
}

/*

:: 싱글톤 패턴 (Singleton Pattern) ::

1. 의도
- 오직 한 개의 클래스 인스턴스만을 갖도록 보장하고, 이에 대한 전역전인 접근점을 제공.

2. 이점
- 인스턴스의 유일성 보장:
  오직 하나의 인스턴스만 생성되고, 이를 전역적으로 접근할 수 있다.
- 전역 접근:
  어디서든지 인스턴스에 접근할 수 있다.
- 자원 절약:
  불필요한 인스턴스 생성을 방지하여 메모리와 자원을 절약

3. 주의
- 테스트 어려움

 */