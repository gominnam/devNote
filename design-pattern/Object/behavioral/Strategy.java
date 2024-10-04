public class Strategy {

    // Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategy - CreditCard
    static class CreditCardStrategy implements PaymentStrategy {
        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

        public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
            this.name = name;
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.dateOfExpiry = dateOfExpiry;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid with credit/debit card");
        }
    }

    // Concrete Strategy - PayPal
    static class PayPalStrategy implements PaymentStrategy {
        private String emailId;
        private String password;

        public PayPalStrategy(String emailId, String password) {
            this.emailId = emailId;
            this.password = password;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using PayPal");
        }
    }

    // Context
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.paymentStrategy = strategy;
        }

        public void pay(int amount) {
            if (paymentStrategy != null) {
                paymentStrategy.pay(amount);
            } else {
                System.out.println("Payment strategy not set");
            }
        }
    }

    public static void main(String[] args){
        PaymentContext context = new PaymentContext();

        // Credit Card Payment
        context.setPaymentStrategy(new CreditCardStrategy("John Doe", "1234567890123456", "786", "12/15"));
        context.pay(100);

        // PayPal Payment
        context.setPaymentStrategy(new PayPalStrategy("emailId", "password"));
        context.pay(200);
    }
}

/*

:: 전략 패턴 (Strategy Pattern) ::

1. 구조

: Context(전략 객체) - Strategy Interface(전략 인터페이스) - Concrete Strategy(구체적인 전략)

2. 의도

: 알고리즘을 정의하고, 실행하는 클래스를 런타임에 선택할 수 있도록 하는 디자인 패턴

3. 활용

: 결제 처리 시스템 - 신용카드, 휴대폰 결제, 포인트 결제 등 다양한 결제 수단을 선택할 수 있습니다.
: 데이터 압축 알고리즘 - ZIP, RAR, 7z 등 다양한 압축 방식
: 다양한 경로 탐색 알고리즘 - BFS, DFS, Dijkstra 등 다양한 경로 탐색 알고리즘

4. 단점

: 전략이 많아질수록 클래스의 수가 늘어남.

 */