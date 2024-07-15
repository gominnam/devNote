
# 실행 계획(Execution Planning) 

## 실행 계획을 사용하는 이유

1) 성능 분석: 쿼리가 실행되는 방식을 분석하여 병목 현상이나 비효율적인 부분을 식별 할 수 있다.
2) 인덱스 사용 확인: 쿼리가 적절한 인덱스를 사용하고 있는지 확인할 수 있다.
3) 조인 방식 분석: 여러 테이블 간의 조인 방식과 순서를 확인할 수 있다.
4) 비용 예측: 쿼리 실행에 필요한 리소스를 예측할 수 있어, 리소스 관리를 효율적으로 할 수 있다.


## 실행 계획

### - 실행 계획 쿼리
```sql
// MySQL
SELECT * FROM employees WHERE department_id = 1;

// 실행 계획 쿼리
EXPLAIN SELECT * FROM employees WHERE department_id = 1;
```

### - 실행 계획 결과 예시
```sql
+----+-------------+-----------+------+---------------+---------+---------+-------+------+-------------+
| id | select_type | table     | type | possible_keys | key     | key_len | ref   | rows | Extra       |
+----+-------------+-----------+------+---------------+---------+---------+-------+------+-------------+
|  1 | SIMPLE      | employees | ref  | dept_id_index | dept_id | 4       | const |    3 | Using where |
+----+-------------+-----------+------+---------------+---------+---------+-------+------+-------------+
```

1) id: 쿼리 각 부분을 나타내는 식별자. 복잡한 쿼리에서는 여러 행으로 나눠 진다.
2) select_type: 쿼리의 유형을 나타낸다.
    - SIMPLE: 단순한 SELECT 쿼리
    - PRIMARY: 복합 쿼리의 최상위 SELECT
    - SUBQUERY: 서브쿼리 (일반적으로 WHERE 절에서 사용)
    - DERIVED: 서브쿼리의 결과를 임시 테이블로 저장한 것
3) table: 쿼리에서 사용된 테이블 이름
4) type: 테이블의 레코드를 어떻게 읽는지 나타낸다.
    - system: 단일 레코드만 읽는다.
    - const: 상수 인덱스를 사용하여 단일 레코드를 읽는다.
    - eq_ref: 인덱스를 사용하여 단일 레코드를 읽는다.
    - ref: 인덱스를 사용하여 여러 레코드를 읽는다.
    - range: 인덱스를 사용하여 범위를 읽는다.
    - index: 인덱스를 읽는다.
    - all: 테이블 전체를 읽는다.
5) possible_keys: 쿼리에서 사용할 수 있는 인덱스 목록
6) key: 쿼리에서 실제로 사용된 인덱스
7) key_len: 선택된 인덱스의 길이
8) ref: 인덱스의 어떤 컬럼이 사용되는지 나타낸다.
9) rows: 쿼리 실행 결과로 예상되는 레코드 수
10) Extra: 추가 정보
    - Using where: WHERE 절에서 필터링을 수행한다.
    - Using index: 인덱스만 사용하여 쿼리를 처리한다.
    - Using temporary: 임시 테이블을 사용한다.


### - 실행 계획 해석

1) type: 쿼리의 성능을 결정하는 가장 중요한 요소 중 하나이다.
    - system, const: 가장 빠른 방법이다.
    - eq_ref, ref: 인덱스를 사용하여 레코드를 읽는다.
    - range: 인덱스를 사용하여 범위를 읽는다.
    - index: 인덱스를 읽는다.
    - all: 테이블 전체를 읽는다.
    - type이 `all` 이나 `index`인 경우 테이블 전체를 스캔하는 경우이므로, 인덱스를 추가하거나 쿼리를 재작성하는 것이 효율성을 높일 수 있다.

2) key: 쿼리에서 사용된 인덱스를 나타낸다.
    - key가 NULL이면 쿼리에서 인덱스를 사용하지 않는다.
    - key가 `PRIMARY`이면 기본 키를 사용한다.
    - key가 `NULL`이 아니면 쿼리에서 사용된 인덱스를 나타낸다.

3) rows: 쿼리 실행 결과로 예상되는 레코드 수를 나타낸다.
    - 예상되는 rows 값이 많다면, 쿼리의 성능을 높이기 위해 인덱스를 추가하거나 쿼리를 재작성하는 것이 효율성을 높일 수 있다.


## 실행 계획을 활용한 최적화


### 인덱스 추가
```sql
CREATE INDEX dept_id_index ON employees(department_id);
```

### 쿼리 재작성    
```sql
SELECT e.* 
FROM employees e 
JOIN departments d ON e.department_id = d.id 
WHERE d.name = 'Sales';
```


--------------------------------------------
- ref: chatGPT