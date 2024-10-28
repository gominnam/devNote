## Hash Table (해시 테이블)

- Key-Value 를 빠르게 저장하고 읽을 수 있는 자료구조
- Dictionary 라고도 부른다.
- 시간복잡도 O(1), 공간복잡도 O(n) 으로 매우 빠르다. (Collision 이 없을 때)


### 구성 요소

- 해시 함수 (Hash Function): 입력된 키를 해시 값으로 변환하는 함수. 이 해시 값은 배열의 인덱스로 사용한다.
- 테이블 (Table): 해시 값에 따라 데이터를 저장하는 배열.
설계
</br></br>

### 동작 원리

1. 삽입 (Insert): 키를 해시 함수에 입력하여 해시 값을 얻습니다. 이 해시 값을 인덱스로 사용하여 테이블에 값을 저장합니다.
2. 검색 (Search): 키를 해시 함수에 입력하여 해시 값을 얻습니다. 이 해시 값을 인덱스로 사용하여 테이블에서 값을 검색합니다.
3. 삭제 (Delete): 키를 해시 함수에 입력하여 해시 값을 얻습니다. 이 해시 값을 인덱스로 사용하여 테이블에서 값을 삭제합니다.

</br></br>

### 충돌 (Collision)

- 원인: 서로 다른 키가 같은 해시 값을 가질 때 발생
- 해결 방법
  - Separate Chaining: 같은 해시 값을 가진 데이터를 연결 리스트로 연결
    - 배열 인덱스마다 LinkedList 를 사용하여 데이터를 저장
    - Chaining(=Iterator) 을 통하여 key에 해당되는 value를 얻을 수 있다.
    - LinkedList 대신 Tree 를 사용하여 성능을 향상시킬 수 있다. (O(n) -> O(logn)으로 줄어듬)
</br></br>
  - Probing: 빈 버킷을 찾을 때까지 다른 버킷을 탐색
    - Linear Probing: 다음 버킷을 탐색 (1씩 증가)
      - 선형 탐색을 사용하여 충돌을 해결
      - Hash Collision 이 많이 발생하면 Clustering 이 생길 수 있음
    - Quadratic Probing: 제곱만큼 떨어진 버킷을 탐색 (i^2)
      - 선형 탐색보다 더 떨어진 버킷을 탐색으로 Clustering 을 방지할 수 있다
    - Double Hashing: 두 번째 해시 함수를 사용하여 다음 버킷을 탐색



