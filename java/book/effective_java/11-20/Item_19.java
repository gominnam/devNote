public class Item_19 {

    // [page 125]
    // 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 매서드를 호출하면 안된다.
    static class SuperClass {
        public SuperClass() {
            System.out.println("SuperClass constructor called");
            init(); // 생성자에서 재정의 가능한 메서드를 호출
        }

        // 재정의 가능한 메서드
        protected void init() {
            System.out.println("SuperClass init method");
        }
    }

    static class SubClass extends SuperClass {
        private String message;

        public SubClass(String message) {
            this.message = message;
            System.out.println("SubClass constructor called");
        }

        @Override
        protected void init() {
            System.out.println("SubClass init method");
            System.out.println("Message: " + message); // message는 아직 초기화되지 않았을 수 있음
        }
    }
    /*
    출력 결과:
    SuperClass constructor called
    SubClass init method
    Message: null <<  message는 아직 초기화되지 않았을 수 있음 null 출력
    SubClass constructor called
     */

    static class SuperClassEdited {
        public SuperClassEdited() {
            System.out.println("SuperClass constructor called");
            // init() 호출을 제거
        }

        // 생성자 이후에 호출될 초기화 메서드
        public void completeInitialization() {
            init();
        }

        protected void init() {
            System.out.println("SuperClass init method");
        }
    }

    static class SubClassEdited extends SuperClassEdited {
        private String message;

        public SubClassEdited(String message) {
            super(); // 슈퍼 클래스 생성자 호출
            this.message = message;
            System.out.println("SubClass constructor called");
            completeInitialization(); // 초기화 완료 후 init 호출
        }

        @Override
        protected void init() {
            System.out.println("SubClass init method");
            System.out.println("Message: " + message);
        }
    }

    public static void main(String[] args) {
        SubClass sub = new SubClass("Hello, World!");
        System.out.println();
        SubClassEdited subEdited = new SubClassEdited("Hello, World!");
    }
}