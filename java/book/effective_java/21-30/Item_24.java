public class Item_24 {

    // [page 148]
    // 내부 클래스의 익명클래스
    static interface Greeting {
        void sayHello();
    }

    static public class OuterClassA {
        void myMethod() {
            // Anonymous class 정의 및 인스턴스 생성
            Greeting greeting = new Greeting() {
                @Override
                public void sayHello() {
                    System.out.println("Hello from Anonymous Class");
                }
            };

            // 메서드 호출
            greeting.sayHello();
        }
    }


    // 내부 클래스의 지역클래스
    static public class OuterClassB {
        void myMethod() {
            final int localVar = 10; // 로컬 변수는 final 또는 effectively final이어야 함

            // 지역클래스 정의, 매서드를 호출할 때마다 생성
            class LocalClass {
                void display() {
                    System.out.println("Local Variable: " + localVar);
                }
            }

            // Local class의 인스턴스 생성 및 메서드 호출
            LocalClass localObject = new LocalClass();
            localObject.display();
        }
    }

    public static void main(String[] args){
        OuterClassA outerObjectA = new OuterClassA();
        outerObjectA.myMethod();

        OuterClassB outerObjectB = new OuterClassB();
        outerObjectB.myMethod();
    }
}

/*

1) 정의 위치
- 지역 클래스: 메서드 내에서 정의됩니다.
- 익명 클래스: 인스턴스 생성 시 동시에 정의됩니다.

2) 이름 유무:
- 지역 클래스: 이름이 있습니다.
- 익명 클래스: 이름이 없습니다.

3) 사용 시기
- 지역 클래스: 특정 메서드 내에서 여러 번 인스턴스화해야 할 때 사용됩니다.
- 익명 클래스: 인터페이스나 추상 클래스를 구현하면서 인스턴스를 한 번만 생성할 때 사용됩니다.


지역 클래스
복잡한 로직을 메서드 내부에서 분리하고 싶을 때 유용합니다.
특정 메서드 내에서 반복적으로 사용할 클래스를 정의할 때 사용합니다.

익명 클래스
단순히 인터페이스나 추상 클래스의 메서드를 구현할 때 사용합니다.
이벤트 핸들러나 콜백 메서드를 정의할 때 유용합니다.

 */