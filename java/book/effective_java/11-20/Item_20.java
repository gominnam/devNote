public class Item_20 {

    // [page 135]
    // 복잡한 인터페이스라면 구현하는 수고를 덜어주는 골격 구현 함께 제공하기
    interface ComplexInterface {
        void method1();
        void method2();
        void method3();
        void method4();
    }

    static abstract class ComplexInterfaceSkeleton implements ComplexInterface {
        @Override
        public void method1() {
            // 기본 구현
            System.out.println("Default implementation of method1");
        }

        @Override
        public void method2() {
            // 기본 구현
            System.out.println("Default implementation of method2");
        }

        @Override
        public void method3() {
            // 기본 구현
            System.out.println("Default implementation of method3");
        }

        @Override
        public void method4() {
            // 기본 구현
            System.out.println("Default implementation of method4");
        }
    }

    static class CustomImplementation extends ComplexInterfaceSkeleton {
        @Override
        public void method1() {
            // Custom implementation
            System.out.println("Custom implementation of method1");
        }

        // method2, method3, method4는 기본 구현을 사용
    }

    public static void main(String[] args){
        ComplexInterface customImpl = new CustomImplementation();
        customImpl.method1(); // "Custom implementation of method1" 출력
        customImpl.method2(); // "Default implementation of method2" 출력
        customImpl.method3(); // "Default implementation of method3" 출력
        customImpl.method4(); // "Default implementation of method4" 출력
    }
}

/*

골격 구현클래스는 인터페이스 구현의 복잡성을 줄여주며,
필요한 부분만 재정의할 수 있게 해줍니다. 이를 통해 코드의 재사용성을 높이고 유지보수를 쉽게 할 수 있습니다.

 */