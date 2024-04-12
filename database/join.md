# Database Join

## Join?

- 관계형 데이터 베이스에서 조인(Join)은 두 개 이상의 테이블을 연결하여 데이터를 검색하는 방법이다.
- 여러 분산된 데이터들을 테이블의 관계를 기반으로 통합된 정보를 검색할 수 있다.


## Join 유형

### 1. INNER JOIN(내부조인)

- 두 테이블에서 일치하는 데이터가 있는 행만 반환

```sql
SELECT Users.Name, Orders.OrderID
FROM USERS
INNER JOIN Orders
    ON Users.ID = Orders.UserID;
```


### 2. OUTER JOIN

- OUTER JOIN에는 LEFT, RIGHT, FULL OUTER JOIN 이 있다.
- OUTER JOIN은 일치하는 행이 없어도 결과를 반환한다(NULL).
  - LEFT JOIN: 왼쪽 테이블의 모든 행과 오른쪽 테이블의 일치하는 행을 반환
  - RIGHT JOIN: 오른쪽 테이블의 모든 행과 왼쪽 테이블의 일치하는 행을 반환
  - FULL OUTER JOIN: 왼쪽 테이블과 오른쪽 테이블의 모든 행을 반환 

```sql
// LEFT JOIN
SELECT Users.Name, Orders.OrderID
FROM USERS
LEFT JOIN Orders
    ON Users.ID = Orders.UserID;

    
// RIGHT JOIN
SELECT Users.Name, Orders.OrderID
FROM USERS
RIGHT JOIN Orders
    ON Users.ID = Orders.UserID;

    
// FULL OUTER JOIN
SELECT Users.Name, Orders.OrderID
FROM USERS
FULL OUTER JOIN Orders
    ON Users.ID = Orders.UserID;
```


### 3. SELF JOIN

- 테이블 자신을 조인하는 것
- 주로 테이블 내에서 관계를 찾을 때 사용한다.

```sql
SELECT a.Name, b.Name
FROM Employee a, Employee b
WHERE a.ManagerID = b.ID;
```
