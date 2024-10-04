public class TemplateMethod {

    static abstract class DataProcessor {
        // 템플릿 메소드를 정의
        // 3단계로 정의하고 final로 서브클래스에서 수정하지 못하도록 함
        public final void process() {
            readData();
            processData();
            writeData();
        }

        // 구체화 해야할 매서드
        protected abstract void readData();
        protected abstract void processData();
        protected abstract void writeData();
    }

    static class CSVDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            System.out.println("Read data from CSV file");
        }

        @Override
        protected void processData() {
            System.out.println("Process data from CSV file");
        }

        @Override
        protected void writeData() {
            System.out.println("Write data to CSV file");
        }
    }

    static class XMLDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            System.out.println("Read data from XML file");
        }

        @Override
        protected void processData() {
            System.out.println("Process data from XML file");
        }

        @Override
        protected void writeData() {
            System.out.println("Write data to XML file");
        }
    }

    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process(); // CSV 데이터를 처리

        System.out.println();

        DataProcessor xmlProcessor = new XMLDataProcessor();
        xmlProcessor.process(); // XML 데이터를 처리
    }
}

/*


:: 템플릿 메소드 패턴 (Template Method Pattern) ::

1. 구조

: 알고리즘의 골격(Template Method)을 정의하고 세부 단계(Concrete Class)를 구현합니다.

2. 의도

: 코드중복 제거 - 공통된 코드를 슈퍼클래스에 두어 중복을 제거하고, 서브클래스에서 구현할 메소드만 추상 메소드로 정의합니다.
: 확장성 - 서브클래스에서 알고리즘의 일부를 재정의할 수 있습니다.
: 유연성 - 알고리즘 구조는 유지하면서, 세부적인 처리를 서브클래스에서 정의할 수 있다.

3. 활용

: 데이터 처리 파이프라인 - ex) CSV, XML, JSON 등 서로 다른 데이터 형식을 처리할 때, 데이터 로드와 저장의 순서는 동일하게 유지하되, 각 형식에 맞는 처리 방식만 다르게.
: 파일 변환기 - ex) 텍스트 파일, PDF, 이미지 파일 등 서로 다른 파일 형식을 변환하는 작업에서도 템플릿 메서드를 사용

 */