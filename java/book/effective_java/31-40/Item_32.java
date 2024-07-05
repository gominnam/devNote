public class Item_32 {
    // [page 191]
    public static void printNumbers(String label, int... numbers) { //...은 가변인수를 의미
        System.out.print(label + ": ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // 제네릭 타입으로 처리하기
    @SuppressWarnings("unchecked") // 제네릭 배열 생성을 허용하지 않는 경고를 숨김
    public static <T> void printList(T... elements) {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        printNumbers("minjun", 1, 2, 3);
        printNumbers("this is label", 2, 3, 4);

        printList(1, 2, 3);
        printList("Hello", "World");
    }
}

/*

가변인수의 특징
1) 0개 이상의 변수를 받을 수 있다.
2) 가변인수는 배열로 처리
3) 하나의 매서드에 가변인수는 하나만 사용 가능
4) 가변인수는 마지막 매개변수이어야 한다.

 */