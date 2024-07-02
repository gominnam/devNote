public class Item_21 {

    static interface InterfaceA {
        // 추상매서드
        void methodA();

        // 디폴트매서드
        default void defaultMethod() {
            System.out.println("InterfaceA default method");
        }
    }

    static interface InterfaceB {
        // 디폴트매서드
        default void defaultMethod() {
            System.out.println("InterfaceB default method");
        }
    }

    static class MyClassA implements InterfaceA {
        @Override
        public void methodA() {
            System.out.println("MyClassA methodA");
        }
    }

    static class MyClassAB implements InterfaceA, InterfaceB {
        @Override
        public void methodA() {
            System.out.println("MyClassAB methodA");
        }

        // InterfaceA, InterfaceB 모두 defaultMethod를 구현하고 있어 충돌 발생
        @Override
        public void defaultMethod() {
            System.out.println("override defaultMethod");
        }
    }


    public static void main(String[] args){
        MyClassA myClassA = new MyClassA();
        myClassA.methodA(); // MyClassA method1 출력
        myClassA.defaultMethod(); // InterfaceA default method 출력
        System.out.println();

        MyClassAB myClassAB = new MyClassAB();
        myClassAB.methodA();
        myClassAB.defaultMethod(); // MyClassAB default method 출력
    }
}

/*

기존의 인터페이스에서 매서드를 새로 추가하게 되면 컴파일 오류가 발생할 수 있다.
위의 문제를 방지하기 위해 디폴트 매서드를 사용하면 된다.
하지만 기존 인터페이스에 디폴트 매서드를 추가하는 일은 꼭 필요한 경우가 아니면 피해야한다.

 */