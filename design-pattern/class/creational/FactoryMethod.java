public class FactoryMethod {
    // Product 인터페이스
    static interface Product {
        void use();
    }

    static class ConcreteProductA implements Product {
        @Override
        public void use() {
            System.out.println("Product A");
        }
    }

    static class ConcreteProductB implements Product {
        @Override
        public void use() {
            System.out.println("Product B");
        }
    }

    // Creator 추상 클래스
    static abstract class Creator {
        public abstract Product factoryMethod();

        public void operation() {
            Product product = factoryMethod();
            product.use();
        }
    }

    static class ConcreteCreatorA extends Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

    static class ConcreteCreatorB extends Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductB();
        }
    }

    // Client
    public static void main(String[] args){
        Creator creatorA = new ConcreteCreatorA();
        creatorA.operation();

        Creator creatorB = new ConcreteCreatorB();
        creatorB.operation();
    }
}

/*

:: 팩토리 매서드 패턴 (Factory Method Pattern) ::

1. 의도
- 어떤 클래스의 인스턴스를 생성할지에 대한 결정은 서브클래스가 내리도록 한다.

2. 이점 및 효율성
- 객체 생성의 캡슐화:
  객체 생성 로직을 서브클래스에 위임하여 클라이언트 코드와 생성 로직을 분리
- 유연성 증가:
  새로운 제품을 추가할 때, 기존 코드를 수정할 필요 없이 새로운 ConcreteCreator 클래스를 추가하면 된다.
- 단일책임원칙(SRP):
  객체 생성과 사용을 분리하여 각의 책임을 명확히 할 수 있다.

3. 단점
- 클래스 수 증가:
  새로운 제품을 추가할 때마다 새로운 Creator 서브클래스를 작성해야 하므로 클래스 수가 증가한다.
- 복잡성 증가:
  구조가 복잡해질 수 있고, 이해하기 어려울 수 있다.


--------------------------------------------------------------------------------

## Abstract Factory 패턴과 Factory Method 패턴의 차이점

1) Abstract Factory
: 관련된 객체들의 제품군을 생성하는 인터페이스 제공
: 관련된 여러 객체들을 생성하는 메서드를 포함하는 클래스 구조


2) Factory Method
: 단일 객체를 생성하는 방법을 캡슐화
: 단일 객체를 생성하는 메서드를 포함하는 클래스 구조


*/