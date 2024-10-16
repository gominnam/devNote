## List

- List는 순서가 있는 데이터를 저장하는 선형자료구조이다.
- 각 요소에 접근할 수 있는 **인덱스(index)** 를 가지고 있다.
- List는 크게 **ArrayList** 와 **LinkedList** 로 나뉜다.

</br></br>

### ArrayList

- 내부적으로 배열로 구현된 List
- 인덱스를 통해 요소에 접근할 수 있어 빠르다.
- 요소를 추가하거나 삭제할 때, 배열의 크기를 변경해야 하는 경우 성능이 떨어질 수 있다.
: 배열의 크기는 고정되어 있기 때문에 새로운 요소를 추가할 때 더 큰 배열을 생성하고 기존배열을 복사한다.
: 중간에 삽입, 삭제할 때, 해당 위치 이후의 요소를 한 칸씩 이동해야 한다.
: 최악의 경우 O(n)의 시간 복잡도가 발생한다.

```java
public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;
    
    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    
    public void add(E data) {
        if (size == elementData.length) {
            int newSize = elementData.length * 2;
            elementData = Arrays.copyOf(elementData, newSize);
        }
        elementData[size++] = data;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }
    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }
    
    public int size() {
        return size;
    }
}
```

</br></br>

### LinkedList

- 내부적으로 노드로 구현된 List
- 각 노는 데이터와 다음 노드에 대한 참조를 갖는다.
- 요소를 추가하거나 삭제할 때, 다른 요소들을 이동할 필요가 없어 빠르다.
- 인덱스에 따라 요소에 접근할 때는 순차적으로 접근해 하므로 조회성능은 떨어진다.

```java
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    private static class Node<E> {
        E data;
        Node<E> next;
        
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }
    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> prev = head;
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            if (current == tail) {
                tail = prev;
            }
        }
        size--;
    }
    
    public int size() {
        return size;
    }
}


```

</br></br>

### 정리

- List의 종류에는 크게 ArrayList와 LinkedList가 있다.
: ArrayList는 조회가 빠르지만, 삽입/삭제가 많을 때는 성능 저하가 있을 수 있다.
: LinkedList는 삽입/삭제가 빈번한 경우 유리하지만, 조회 성능은 떨어진다.



