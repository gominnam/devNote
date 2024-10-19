## Deadlock (  교착상태 )


### 1. Deadlock 이란?

- 데드락(deadlock)은 두개 이상의 프로세스나 스레드가 서로 자원을 기다리며 무한 대기 상태에 빠지는 현상을 말한다.

- 데드락은 다음의 네 가지 조건이 동시에 성립할 때 발생한다.
  1. 상호 배제(Mutual exclusion) : 자원은 한 번에 한 프로세스(스레드)만 사용할 수 있다.
  2. 점유 대기(Hold and wait) : 프로세스가 자원을 가진 상태에서 다른 자원을 기다린다.
  3. 비선점(No preemption) : 프로세스가 다른 프로세스의 자원을 강제로 뺏을 수 없다. 스스로 해제할때까지 기다려야 한다.
  4. 순환 대기(Circular wait) : 프로세스가 자원을 기다리는데, 이 자원을 기다리는 프로세스가 순환 형태로 대기한다.

</br></br>

### 2. Deadlock 해결 방법

- 데드락을 해결하는 방법은 다음과 같다.
  1. 예방(Prevention) : 데드락이 발생하지 않도록 조건을 변경한다.
  2. 회피(Avoidance) : 데드락이 발생할 가능성이 있는 상황을 피한다.
  3. 탐지(Detection) : 데드락이 발생하면 이를 탐지하여 복구한다.

#### 1) Deadlock 예방(Prevention)

- 데드락 예방
: 데드락이 발생하는 네 가지 조건 중 하나 이상을 만족하지 않도록 하는 것이다.

  - 상호 배제(Mutual exclusion) 방지 : 자원을 공유할 수 있도록 한다.   ex) 읽기 전용 자원은 여러 프로세스가 공유할 수 있다.
  - 점유 대기(Hold and wait) 방지 : 프로세스가 자원을 요청할 때 다른 자원을 가지고 있지 않도록 한다.   ex) 프로세스가 모든 자원을 한 번에 요청하도록 한다. 
  - 비선점(No preemption) 방지 : 자원을 강제로 뺏지 않도록 한다.
  - **순환 대기(Circular wait) 방지** : 자원을 요청할 때 순환 대기가 발생하지 않도록 한다.   ex) 자원 1을 먼저 요청한 후에만 자원 2를 요청할 수 있게 하여 순환 대기가 발생하지 않도록 한다.

#### 2) Deadlock 회피(Avoidance)

- 데드락 회피
: 데드락이 발생할 가능성이 있는 상황을 피하는 것이다.

  - 프로세스가 자원을 요청할 때, 시스템은 현재 자원 상태와 앞으로 요청될 자원을 고려하여, 데드락을 유발하지 않는 경우에만 자원을 할당합니다.
  - 은행원 알고리즘(Banker's Algorithm)이 대표적인 데드락 회피 알고리즘이다.
    1. 자원 요청: 프로세스가 자원을 요청하면 시스템은 자원을 할당할 수 있는지 확인한다.
    2. 안전성 검사: 시스템이 안전 상태라면 자원을 할당하고, 그렇지 않다면 요청을 거부하고 프로세스는 대기합니다.

#### 3) Deadlock 탐지(Detection)

- 데드락 탐지
: 데드락이 발생하면 이를 탐지하여 복구하는 것이다.

  - 데드락 탐지 알고리즘은 주기적으로 시스템 상태를 검사하여 데드락을 탐지한다.
  - 데드락이 발생하면, 시스템은 데드락을 복구하기 위해 프로세스를 종료하거나 자원을 해제한다.

</br></br>

### 3. Deadlock 예제

- 철학자의 만찬 문제
    - 철학자 5명이 원탁에 앉아 식사를 한다.
    - 각 철학자는 젓가락 2개를 가지고 있다.
    - 철학자는 한 손에 하나의 젓가락만 집을 수 있다.
    - 철학자는 두 개의 젓가락을 모두 집어야 식사를 할 수 있다.
    - 철학자는 식사를 하고 나서 젓가락을 내려놓는다.

```java
// 왼쪽 젓가락을 집은 다음 오른쪽 젓가락을 집도록 순서를 정함
// 집을 수 없는 경우 왼쪽 젓가락을 내려놓고 다시 시도
class Chopstick {
    private Lock lock;
    
    public Chopstick() {
        lock = new ReentrantLock();
    } 
    
    /* 젓가락 집기 */
    public boolean pickUp() {
        return lock.tryLock(); 
    }
    
    public void putDown() {
        lock.unlock();
    }
}

class Philosopher extends Thread {
    private int bites = 5; // 식사를 시도하는 횟수
    private Chopstick left, right;
    
    public Pholosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }
    
    public void eat() {
        if(pickUp()) {
            chew();
            putDown();
        }
    }
    
    public boolean pickUp() {
        if(!left.pickUp()) {
            return false;
        }
        if(!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }
    
    public void putDown() {
        left.putDown();
        right.putDown();
    }
    
    public void chew() {
        System.out.println(Thread.currentThread().getName() + " is eating");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    @Override
    public void run() {
        for(int i = 0; i < bites; i++) {
            eat();
        }
    }
}

```
