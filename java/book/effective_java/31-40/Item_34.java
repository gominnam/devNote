import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

public class Item_34 {

    // [page 213]
    static enum Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y; }
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y; }
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y; }
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y; }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public static final Map<String, Operation> stringToEnum =
                Stream.of(values()).collect(
                    toMap(Object::toString, e -> e)
                );

        public static Optional<Operation> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }

        //추상 메서드 선언하고 상수별 클래스몸체에서 재정의
        public abstract double apply(double x, double y);
    }

    public static void main(String[] args){
        double x = 2.0;
        double y = 3.3;
        for(Operation op : Operation.values()) {
            System.out.println(Operation.fromString(op.toString()));
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}