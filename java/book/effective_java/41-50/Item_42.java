public class Item_42 {
    // [page 254]
    // 익명 클래스 예제 소스코드
    static class AnonymousClassExample {
        public static void main(String[] args) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("익명 클래스 실행");
                }
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    // 람다 표현식 예제
    static class LambdaExample {
        public static void main(String[] args) {
            Runnable runnable = () -> System.out.println("람다 실행");

            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public static void main(String[] args){
        AnonymousClassExample.main(args);
        LambdaExample.main(args);
    }

}

/*

1. 익명 클래스 대신 람다를 사용해야 하는 상황
   람다 표현식을 사용하는 것이 더 적합한 경우는 주로 함수형 인터페이스를 사용할 때이다.
   함수형 인터페이스는 `하나`의 추상 메서드만 가지는 인터페이스이다.
   대표적인 예로 Runnable, Callable, Comparator, Function 등이 있다.

2. 람다는 이름이 없고 문서화도 못한다.
   따라서 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야 한다.

3. 람자는 자신을 참조할 수 없다.
   람다에서 this 키워드는 바깥 인스턴스를 가리킨다. 반면 익명 클래스에서의 this는 익명 클래스의 인스턴스 자신을 가리킨다.

 */