import java.util.*;

public class Prototype {

    static interface DocumentPrototype {
        DocumentPrototype cloneDocument();
    }

    // ConcretePrototype 클래스
    static class Document implements DocumentPrototype {
        private String title;
        private String content;

        public Document(String title, String content) {
            this.title = title;
            this.content = content;
        }

        // 복사 생성자를 사용하여 깊은 복사를 구현
        public Document(Document document) {
            this.title = document.title;
            this.content = document.content;
        }

        @Override
        public DocumentPrototype cloneDocument() {
            return new Document(this);
        }

        @Override
        public String toString() {
            return "Document{" +
                    "title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        // Getter와 Setter
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    // PrototypeManager 클래스
    static class DocumentManager {
        private Map<String, DocumentPrototype> prototypes = new HashMap<>();

        public void registerDocument(String key, DocumentPrototype document) {
            prototypes.put(key, document);
        }

        public DocumentPrototype createDocument(String key) {
            return prototypes.get(key).cloneDocument();
        }
    }

    public static void main(String[] args){
        DocumentManager manager = new DocumentManager();
        manager.registerDocument("brain", new Document("브레인 룰스", "뇌"));

        DocumentPrototype clonedDocument = manager.createDocument("brain");
        System.out.println(clonedDocument);
    }
}

/*

:: 원형 패턴 (Prototype Pattern) ::

1. 의도
- 원형이 되는 인스턴스를 사용하여 생성할 객체의 종류를 명시하고, 이렇게 만들어진 객체를 복사해서 새로운 객체를 생성

2. 이점
- 성능 향상:
  복잡한 객체를 생성하는 비용을 줄여줍니다. 초기화 과정이 복잡한 객체를 복제하여 생성하면 속도가 향상된다.
- 유연성:
  런타임에 객체의 타입을 동적으로 결정하고, 다양한 상태를 가진 객체를 쉽게 생성할 수 있다.
- 코드 간소화:
  객체 생성에 필요한 코드가 간소화되고, 객체를 생성하는 로직이 프로그램 로직과 분리되어 코드의 가독성이 향상된다.



*/