
fibonacci(){
  local n=$1  # $1 : 첫번째 인자값

  if [ $n -le 0 ]; then
    echo '1 이상의 정수를 입력해야 합니다.'
    exit 1
  elif [ $n -eq 1 ]; then
    echo 1
  elif [ $n -eq 2 ]; then
    echo 1 1
  else
    local a=1
    local b=1
    local fib="1 1"

    for ((i=3; i<=$n; i++)); do
      local next=$((a + b))
      fib="$fib $next"
      a=$b
      b=$next
    done

    echo $fib
  fi
}

echo 'fibonacci를 shell-scirpt로 간단하게 구현한 실행파일입니다.'
read -p '피보나치 수열의 길이를 입력해주세요: ' length  # -p: 프롬프트 메시지를 나타내는 옵션
result=$(fibonacci $length)
echo "fibonacci result : $result"



# shellcheck disable=SC2016
# 부등호 참고
: '

-eq       : 두 수가 같음(equal)
            if [ "$a" -eq "$b" ]

-ne       : 두 수가 같지 않음(not equal)
            if [ "$a" -ne "$b" ]

-gt       : 왼쪽이 오른쪽보다 더 큼(greater than)
            if ["$a" -gt "$b" ]

-ge       : 왼쪽이 오른쪽보다 더 크거나 같음(greater than or equal)
            if [ "$a" -ge "$b" ]

-lt       : 왼쪽이 오른쪽보다 더 작음(less than)
            if [ "$a" -lt "$b" ]

-le       : 왼쪽이 오른쪽보다 더 작거나 같음(less than or equal)
            if [ "$a" -le "$b" ]

[ 부등호는 이중 소활호 (()) 에서 사용할 수 있다. ]
<         : 왼쪽이 오른쪽보다 더 작음
            if (( "$a" < "$b" ))

<=        : 왼쪽이 오른쪽보다 더 작거나 같음
            if (( "$a" <= "$b" ))

>         : 왼쪽이 오른쪽보다 더 큼
            if (( "$a" > "$b" ))

>=        : 왼쪽이 오른쪽보다 더 크거나 같음
            if (( "$a" >= "$b" ))

'