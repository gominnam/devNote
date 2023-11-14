echo "간단한 두 수를 입력 받아 연산자 +,-,*,/를 계산하는 스크립트."
echo "[ex) fun(a, b, 연산자) ]"

read -p "첫번째 수를 입력하세요: " a
read -p "두번째 수를 입력 하세요: " b
read -p "연산자를 입력하세요: " op

case $op in
    "+")
        echo "$a + $b = $(($a + $b))"
        ;;
    "-")
        echo "$a - $b = $(($a - $b))"
        ;;
    "*")
        echo "$a * $b = $(($a * $b))"
        ;;
    "/")
        echo "$a / $b = $(($a / $b))"
        ;;
    *)
        echo "잘못된 연산자입니다."
        ;;
esac

echo "스크립트 종료"
