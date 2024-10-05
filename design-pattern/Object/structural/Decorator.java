public class Decorator {
    // 컴포넌트
    public interface Coffee {
        public void brewing();
        Double getCost();
    }

    // 컴포넌트 구현
    public static class SimpleCoffee implements Coffee {
        @Override
        public void brewing() {
            System.out.println("brewing coffee");
        }

        @Override
        public Double getCost() {
            return 2.0;
        }
    }

    // 데코레이터
    public static abstract class CoffeeDecorator implements Coffee {
        protected final Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public void brewing() {
            decoratedCoffee.brewing();
        }

        @Override
        public Double getCost() {
            return decoratedCoffee.getCost();
        }
    }

    // 데코레이터 구현
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public void brewing() {
            super.brewing();
            System.out.println("add milk");
        }

        @Override
        public Double getCost() {
            return super.getCost() + 0.5;
        }
    }

    // 데코레이터 구현
    static class WhipDecorator extends CoffeeDecorator {
        public WhipDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public void brewing() {
            super.brewing();
            System.out.println("add whip");
        }

        @Override
        public Double getCost() {
            return super.getCost() + 0.7;
        }
    }

    public static void main(String[] args){
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getCost());

        coffee = new WhipDecorator(coffee);
        coffee.brewing();
        System.out.println(coffee.getCost());
    }
}

/*

:: 장식자 패턴 (Decorator Pattern) ::

1. 구조

: 객체에 추가적인 요건을 동적으로(체이닝) 첨가

2. 의도

: 객체의 변경 없이 기능 확장이 가능.
: 여러 개의 데코레이터를 체이닝하여 다양한 기능 조합이 가능.

3. 추가

: getCost() 메소드의 값이 데코할 수록 증가하는게 처음에 이상하다고 생각
-> 데코레이터 패턴은 객체에 추가적인 요건을 동적(체이닝)으로 첨가하는 패턴이므로 점점 객체를 감싸기 때문에 값 증가.

 */