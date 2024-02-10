# Shell Script에서 반환값을 사용하는 방법


### 1. 상태코드 반환
```bash
myFunctionA() {
    if [ "$1" = "true" ]; then
        return 0
    else
        return 1
    fi
}
```
- 함수에서 return 명령어를 사용하여 상태코드를 반환할 수 있다.
- 일반적으로 `0은 성공, 0이 아닌 값은 실패`를 의미한다.


### 2. 출력을 통한 값 반환
```bash
myFunctionB(){
    echo "Hello, World"
}

result=$(myFunctionB)
echo $result  # 출력값을 사용
```
- 표준 출력을 사용하여 값을 반환할 수 있다.


### 3. 배열을 통한 값 반환
```bash
myFunctionC(){
    local myArray=(1 2 3 4 5)
    echo "${myArray[@]}"
}

result=($(myFunctionC))
echo ${result[0]}  # 첫번째 값(1)을 사용
echo ${result[1]}  # 두번째 값(2)을 사용
```
