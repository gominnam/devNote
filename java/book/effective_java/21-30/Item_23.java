public class Item_23 {

    // [page 142]
    // tag 달린 클래스 안티패턴
    static class FigureTag {
        enum Shape { RECTANGLE, CIRCLE };

        // 태그 필드 - 현재 모양을 나타낸다.
        final Shape shape;

        // 이 필드는 shape가 RECTANGLE일 때만 사용된다.
        double length;
        double width;

        // 이 필드는 shape가 CIRCLE일 때만 사용된다.
        double radius;

        // Circle용 생성자
        FigureTag(double radius) {
            shape = Shape.CIRCLE;
            this.radius = radius;
        }

        // Rectangle용 생성자
        FigureTag(double length, double width) {
            shape = Shape.RECTANGLE;
            this.length = length;
            this.width = width;
        }

        double area() {
            switch(shape) {
                case RECTANGLE:
                    return length * width;
                case CIRCLE:
                    return Math.PI * (radius * radius);
                default:
                    throw new AssertionError();
            }
        }
    }

    // 계층구조로 리펙토링
    static abstract class Figure {
        abstract double area();
    }

    static class Circle extends Figure {
        final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * (radius * radius);
        }
    }

    static class Rectangle extends Figure {
        final double length;
        final double width;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }

    public static void main(String[] args){
        // FigureTag
        FigureTag tagRectangle = new FigureTag(3, 4);
        FigureTag tagCircle = new FigureTag(5);

        System.out.println("TagClass Rectangle area: " + tagRectangle.area());
        System.out.println("TagClass Circle area: " + tagCircle.area());
        System.out.println();

        // 계층구조로 리펙토링
        Figure rectangle = new Rectangle(3, 4);
        Figure circle = new Circle(5);

        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Circle area: " + circle.area());
    }
}

/*

태그 달린 클래스는 가독성도 나쁘고 비효율적이다. (필요하지 않은 코드들도 언제나 메모리를 잡아먹음)

계층구조로 리펙토링하면 가독성도 높아지고 유지보수도 쉬워진다.
타입 사이의 자연스러운 계층 관계를 반영하기 때문에 컴파일 시점에서 타입 검사 능력을 높여줌

*/