public class AbstractFactory {
    // 1. 추상 제품 인터페이스 정의
    // Button 인터페이스
    static interface Button {
        void paint();
    }

    // Checkbox 인터페이스
    static interface Checkbox {
        void paint();
    }

    // 2. 구체적인 제품 클래스 정의
    // Windows 버튼 클래스
    static class WindowButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a WindowsButton.");
        }
    }

    // Mac 버튼 클래스
    static class MacButton implements Button {
        @Override
        public void paint() {
            System.out.println("Rendering a MacButton.");
        }
    }

    // Windows 체크박스 클래스
    static class WindowCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a WindowsCheckbox.");
        }
    }

    // Mac 체크박스 클래스
    static class MacCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Rendering a MacCheckbox.");
        }
    }

    // 3. 추상 팩토리 인터페이스 정의
    // GUI 팩토리 인터페이스
    static interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    // 4. 구체적인 팩토리 클래스 정의
    // Windows 팩토리 클래스
    static class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WindowCheckbox();
        }
    }

    // Mac 팩토리 클래스
    static class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

    // 5. 클라이언트 코드
    public static class Application {
        private Button button;
        private Checkbox checkbox;

        public Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        public void paint() {
            button.paint();
            checkbox.paint();
        }
    }

    // Test
    public static void main(String[] args){
        Application app; // 클래스
        GUIFactory factory; // 인터페이스

        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }

        app = new Application(factory);
        app.paint();
    }
}

/*

:: 추상 팩토리 (Abstract Factory Pattern) ::

1. 의도

- 상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 제공

2. 활용성

- 객체가 생성되거나 구성, 표현되는 방식과 무관하게 시스템을 독립적으로 만들고자 할 때
- 제품 클래스 라이브러리를 제공하고, 그들의 구현이 아닌 인터페이스를 노출시키고 싶은 경우
- 여러 제품군 중 하나를 선택해서 시스템을 설정하고, 구성한 제품을 다른 것으로 대체할 수 있을 때

- CreationFactory(ex. GUIFactory) 클래스의 인스턴스 한개가 런타임에 만들어지고,
  이 구체 팩토리는 어떤 특정 구현을 갖는 제품 객체를 생성

- 팩토리는 제품 객체를 생성하는 과정과 책임을 캡슐화한 것이기 때문에, 구체적인 구현 클래스가 사용자에게서 분리.

 */