# 인덱스(Index) 최적화

## 1. 인덱스 구조

- B-트리: 대부분의 RDBMS에서 사용하는 인덱스 구조
- Hash: 특정한 경우에 유용한 인덱스 작동 방식. MySQL의 MEMORY 스토리지 엔진에서 사용하는 인덱스 구조

### B-트리 ?

#### 1) B-트리의 특징

- 균형 유지: 모든 리프 노드가 같은 레벨에 위치하도록 균형을 유지한다. (동일한 깊이)
- 정렬된 데이터: 각 노드의 키 값은 정렬된 상태로 유지된다.
- 다중 자식 노드: 각 노드는 여러 개의 자식 노드를 가질 수 있다.
- 탐색 효율성: 검색, 삽입, 삭제 연산이 로그(log) 시간 복잡도로 수행된다.


#### 2) B-트리의 구조

- 루트 노드: 트리의 최상위 노드
- 내부 노드: 루트 노드와 리프 노드 사이에 위치한 노드로 자식 노드를 갖는다.
- 리프 노드: 트리의 최하위 노드
  - m차수인 경우 노드에는 최대 'm'개의 자식 노드가 있을 수 있다.
  - 각 노드에는 최대 'm-1'개의 키 값을 가질 수 있다.
  - 각 노는 최소 'm/2'개의 자식 노드를 가져야 한다.(루트 노드 제외)


## 2. 적절한 인덱스 추가

- WHERE 절 최적화: 검색 조건에 자주 사용되는 컬럼에 인덱스를 추가한다.
- 조인 조건 최적화: 조인에 사용되는 컬럼에 인덱스를 추가한다.
- 다중 컬럼 인덱스: 복합 조건을 효율적으로 처리하기 위해 여러 컬럼으로 이루어진 인덱스를 생성한다.


## 3. 인덱스가 오히려 성능 저하를 일으키는 경우

1) 과도한 인덱스 사용
- 인덱스 유지 비용: 인덱스는 데이터 삽입, 업데이트, 삭제 시 갱되어야 합니다. 
  인덱스가 너무 많으면 이러한 작업 비용이 증가하여 전체 성능에 저하될 수 있다. (각 인덱스는 별도의 B-트리 구조를 사용하여 데이터를 관리)
- 디스크 공간 증가: 인덱스가 많으면 데이터베이스 파일의 크기가 커져 디스크 I/O 성능이 저하될 수 있다.

2) 분포가 나쁜 인덱스
- 인덱스 선택성: 인덱스의 선택성이 낮은 경우(예: 많은 행이 동일한 값을 가지는 경우) 인덱스를 사용해도 성능 향상이 크지 않습니다. 
  이럴 때는 전체 테이블 스캔이 더 효율적일 수 있습니다.
- 카디널리티 문제: 인덱스 컬럼의 유니크 값이 적으면 인덱스 사용이 비효율적일 수 있습니다.




