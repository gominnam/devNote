public class ChainOfResponsibility {
    // Handler Interface
    interface Handler {
        void setNextHandler(Handler nextHandler);
        void handleRequest(int level, String message);
    }

    // Concrete Handler
    static class InfoHandler implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(int level, String message) {
            if (level == 1) {
                System.out.println("InfoHandler: " + message);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(level, message);
            }
        }
    }

    // Concrete Handler
    static class DebugHandler implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(int level, String message) {
            if (level == 2) {
                System.out.println("DebugHandler: " + message);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(level, message);
            }
        }
    }

    // Concrete Handler
    static class ErrorHandler implements Handler {
        private Handler nextHandler;

        @Override
        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        @Override
        public void handleRequest(int level, String message) {
            if (level == 3) {
                System.out.println("ErrorHandler: " + message);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(level, message);
            }
        }
    }

    public static void main(String[] args) {
        Handler infoHandler = new InfoHandler();
        Handler debugHandler = new DebugHandler();
        Handler errorHandler = new ErrorHandler();

        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        // 체인의 첫 번째 핸들러에서 시작하여 요청 처리
        infoHandler.handleRequest(1, "Info message");
        infoHandler.handleRequest(2, "Debug message");
        infoHandler.handleRequest(3, "Error message");
        infoHandler.handleRequest(4, "Fatal message"); // 처리할 핸들러가 없으므로 무시
    }
}

/*

:: 책임 연쇄 패턴 (Chain of Responsibility) ::

1. 구조

: Handler(처리자) - Concrete Handler(구체적인 처리자) - Client(요청자)

2. 의도

: 요청을 처리하는 객체들이 체인 형태로 연결된 구조를 통해, 요청을 순차적으로 각 객체에 전달
  요청을 받는 객체가 요청을 처리할지, 다음 객체에 요청을 넘길지를 결정하는 것

3. 활용

: 사용자 인증 및 권한 처리 - 인증을 거친 후 권한 처리를 위해 체인을 통해 처리
: 에러 또는 예외 처리 - 각 예외 핸들러가 특정한 타입의 예외를 처리하고, 처리할 수 없는 경우 다음 핸들러로 예외를 넘깁니다.
: 데이터 검증 및 필터링 - 데이터를 처리할 때 [ ex) null 체크 -> 길이 체크 -> 형식 체크 순서로 데이터를 검증 ]


ref - https://refactoring.guru/design-patterns/chain-of-responsibility

 */