## Collaborator


### 1. Collaborator ?

- 하나의 Object 가 자기의 역할을 수행하기 위해 필요한 Dependency를 말한다.

```java
class Car {
    Engine engine; // Collaborator
    Tire tire; // Collaborator
    
    Car(Engine e, Tire t){
        this.engine = e;
        this.tire = t;
    }
    
    boolean isOwner(User user){ // Collaborator
        return user.isOwner(this);
    }
}
```
- Car 클래스에 있는 Engine, Tire 클래스가 Car 클래스의 Collaborator 이다.
- isOwner 메소드의 User 클래스 또한 Car 클래스의 Collaborator 이다.
</br></br>

### 2. 문제점

- Digging into Collaborators
- 즉, Collborator 를 파고들지 말라는 의미이다.

```java
class salesTaxCalculator {
    TaxTable taxTable;
    
    // ... 생략
    
    // 안좋은 Digging into Collaborators 코드 예시
    float computeSalesTax(User user, Invoice invoice){
        Address address = user.getAddress();
        float amount = invoice.getAmount();
        return amount * taxTable.getRate(address);
    }
    
    // 좋은 코드 예시
    float computeSalesTax(Address address, float amount){
        return amount * taxTable.getRate(address);
    }
}
```
- Digging 하지 말고 필요한 데이터를 직접 요청하도록 하자.
- Dependency 가 줄어들어서 코드 재사용에 용이하다.
- Test Code에서 간단하게 테스트 할 수 있게 된다.

### Reference

- [코맹탈출 Youtube](https://www.youtube.com/watch?v=FRO_W3hHaoQ&list=PLWzuJt3QAKnfg3RkrI3Au6Ktw_FCNdPMG&index=24)
- [Misko Hevery blog](http://misko.hevery.com/code-reviewers-guide/)
