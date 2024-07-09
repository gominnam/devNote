public class Item_41 {

    // [page 249]
    // Marker Interface
    static public class User implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    // Marker Annotation
    public class Example {

        @Deprecated // 이 메서드는 더 이상 사용되지 않습니다.
        public void oldMethod() {
        }

        public void newMethod() {
            // 새로운 메서드입니다.
        }
    }
}

/*

1. 마커 인터페이스 (Marker Interface)
마커 인터페이스는 인터페이스에 아무런 메서드도 정의하지 않고, 특정 클래스가 어떤 속성을 가지고 있음을 표시하기 위해 사용됩니다. 주로 아래와 같은 경우에 사용됩니다:

- 타입 체크: 클래스가 특정 타입을 구현하고 있음을 나타내고, 이를 통해 타입 체크를 할 수 있습니다.
- 런타임 행동 지정: 특정 마커 인터페이스를 구현한 클래스에 대해 특별한 런타임 동작을 지정할 수 있습니다.

예시: Serializable 인터페이스
Java의 java.io.Serializable 인터페이스는 대표적인 마커 인터페이스입니다. 이 인터페이스를 구현하는 클래스는 직렬화가 가능하다는 것을 나타냅니다.

Serializable 인터페이스를 구현하면, JVM은 해당 객체를 직렬화할 수 있도록 특별한 처리를 합니다.
ObjectOutputStream은 객체를 바이트 스트림으로 변환하여 파일, 네트워크, 메모리 등으로 전송할 수 있게 합니다.
이는 객체의 상태를 저장하거나 다른 JVM으로 전송할 때 유용합니다.


2. 마커 애너테이션 (Marker Annotation)
마커 애너테이션은 주석(annotation) 형태로 클래스, 메서드, 필드 등에 특정 메타데이터를 부여하여, 컴파일러나 런타임 시스템에서 특별한 의미를 가지도록 합니다. 주로 아래와 같은 경우에 사용됩니다:

소스 코드에서 특정 정보를 표시: 소스 코드에서 개발자가 특정 의미를 부여하기 위해 사용합니다.
런타임에 특정 동작을 지정: 런타임 시스템이 애너테이션을 읽어 특별한 동작을 수행하도록 합니다.

 */