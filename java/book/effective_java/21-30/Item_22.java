public class Item_22 {

    // 상수 인터페이스 안티패턴 지양해야 함
    static interface ConstantInterface {
        static final int CONSTANT1 = 1;
        static final int CONSTANT2 = 2;
        static final int CONSTANT3 = 3;
    }

    // 3) 인스턴스화할 수 없는 유틸리티 클래스
    static class UtilityConstants {
        private UtilityConstants() {
            throw new AssertionError(); // 인스턴스화 방지
        }

        // java 7부터 숫자 리터럴에 '_' 를 사용할 수 있음. 가독성 좋음
        static final double UTIL_A = 1.124_122;
        static final double UTIL_B = 2.343_123;
        static final double UTIL_C = 311_123.123;
    }

    public static void main(String[] args){
        System.out.println(UtilityConstants.UTIL_A);
        System.out.println(UtilityConstants.UTIL_B);
        System.out.println(UtilityConstants.UTIL_C);
    }
}

/*

인터페이스는 자신을 구현한 클래스의 인스턴스를 참조할 수 있는 타입 역할을 한다.
클라이언트가 무엇을 할 수 있는지 인터페이스를 통해 알 수 있게 된다.

상수 인터페이스는 안티패턴으로 권장되지 않음
그러면 어떻게?
1) 클래스나 인터페이스 자체에 추가하기
2) 열거타입 (Item_34)
3) 인스턴스화할 수 없는 유틸리티 클래스(Item_4)

*/