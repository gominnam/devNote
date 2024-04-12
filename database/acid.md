
# ACID 

## ACID?

- ACID는 데이터베이스에서 트랜잭션의 신뢰성을 보장해주기 위한 4가지 속성을 말한다.
    - Atomicity(원자성)
    - Consistency(일관성)
    - Isolation(고립성)
    - Durability(영속성)


## Atomicity(원자성)

- 원자성은 트랜잭션이 데이터베이스에 모두 반영 혹은 반영되지 않아야 한다는 것을 의미한다.
- 일련의 과정중 하나라도 실패하면 전체가 실패해야 한다.


## Consistency(일관성)

- 일관성은 트랜잭션이 성공적으로 완료되면 일관성 있는 상태로 유지되어야 한다는 것을 의미한다.


## Isolation(고립성)

- 고립성은 여러 트랜잭션이 동시에 실행되더라도 서로 영향을 미치지 않도록 보장해야 한다는 것을 의미한다.
- 결과가 완전히 반영되지 않으면 다른 트랜잭션에서 확인 불가능.
- 고립성은 동시성 제어를 통해 보장된다.


## Durability(영속성)

- 영속성은 트랜잭션이 성공적으로 완료되면 그 결과는 영구적으로 반영되어야 한다는 것을 의미한다.
- 시스템 장애가 발생해도 완료된 트랜잭의 결과는 손실되지 않는다.
