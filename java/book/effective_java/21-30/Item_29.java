import java.util.*;

public class Item_29 {

    // [page 170]
    // 1) 제네릭 클래스 예제
    static class Stack<T> {
        private T[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        // 생성자
        @SuppressWarnings("unchecked") // 비검사 형변환이 안전함을 증명하면 경고를 숨긴다.
        public Stack() {
            // T[DEFAULT_INITIAL_CAPACITY]는 컴파일 오류 발생
            elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(T e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public T pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            T result = elements[--size];
            elements[size] = null; // 다 쓴 참조 해제
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }


    // 2) 제네릭 인터페이스 예제
    static interface Repository<T> {
        void save(T item);
        T findById(int id);
    }

    // 제네릭 인터페이스를 구현한 클래스
    static class InMemoryRepository<T> implements Repository<T> {
        private List<T> items = new ArrayList<>();
        private int currentId = 0;

        @Override
        public void save(T item) {
            items.add(item);
            currentId++;
        }

        @Override
        public T findById(int id) {
            if (id < 0 || id >= items.size()) {
                return null;
            }
            return items.get(id);
        }
    }

    public static void main(String[] args){
        // 제네릭 클래스
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("IntegerStak Pop: " + stack.pop());
        System.out.println("IntegerStak Pop: " + stack.pop());

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        System.out.println("StringStack Pop: " + stringStack.pop());

        // 제네릭 인터페이스
        Repository<String> stringRepo = new InMemoryRepository<>();
        stringRepo.save("Item 1");
        stringRepo.save("Item 2");

        System.out.println("Item with ID 0: " + stringRepo.findById(0));
        System.out.println("Item with ID 1: " + stringRepo.findById(1));
    }
}

/*

직접 형변환해야 하는 타입보다 제네릭 타입이 더 안전하고 쓰기 편하다.

 */